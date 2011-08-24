/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.build.enunciate;

import com.sun.mirror.declaration.*;
import com.sun.mirror.type.InterfaceType;
import com.sun.mirror.util.Declarations;
import net.sf.jelly.apt.Context;
import net.sf.jelly.apt.decorations.JavaDoc;
import net.sf.jelly.apt.decorations.declaration.DecoratedMethodDeclaration;
import net.sf.jelly.apt.decorations.declaration.PropertyDeclaration;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.config.SchemaInfo;
import org.codehaus.enunciate.contract.jaxb.*;
import org.codehaus.enunciate.contract.jaxb.types.XmlClassType;
import org.codehaus.enunciate.contract.jaxb.types.XmlTypeException;
import org.codehaus.enunciate.contract.jaxb.types.XmlTypeFactory;
import org.codehaus.enunciate.contract.validation.ValidationResult;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubClassOf;
import org.gedcomx.rt.RDFSubPropertyOf;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.beans.Introspector;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Basic processor for defining and validating integration the model with RDF.
 *
 * @author Ryan Heaton
 */
public class RDFProcessor {

  private final RDFSchema rdfSchema = new RDFSchema();

  public RDFProcessor() {
    loadKnownRDFSchemaDescriptions();
  }

  public RDFSchema getRdfSchema() {
    return rdfSchema;
  }

  public boolean isKnownRDFNamespace(String namespace) {
    return RDFSchema.RDF_NAMESPACE.equals(namespace) ||
      RDFSchema.RDFS_NAMESPACE.equals(namespace) ||
      XMLConstants.XML_NS_URI.equals(namespace) ||
      "http://purl.org/dc/dcmitype/".equals(namespace) ||
      "http://purl.org/dc/terms/".equals(namespace);
  }

  public ValidationResult processModel(EnunciateFreemarkerModel model) {
    ValidationResult result = new ValidationResult();
    for (SchemaInfo schemaInfo : model.getNamespacesToSchemas().values()) {
      if (!isKnownRDFNamespace(schemaInfo.getNamespace())) {
        describeSchema(schemaInfo, result);
        for (TypeDefinition typeDefinition : schemaInfo.getTypeDefinitions()) {
          if (typeDefinition instanceof QNameEnumTypeDefinition) {
            QNameEnumTypeDefinition qNameEnumDef = (QNameEnumTypeDefinition) typeDefinition;
            describeRDFClassesAndProperties(qNameEnumDef, result);
          }
          else if (typeDefinition instanceof ComplexTypeDefinition) {
            ComplexTypeDefinition complexTypeDefinition = (ComplexTypeDefinition) typeDefinition;
            describeRDFClassesAndProperties(complexTypeDefinition, result);
          }
          //simple types and enum types aren't described by RDF schema except as RDF literals.
        }
      }
    }
    return result;
  }

  /**
   * Describe the RDF classes and properties defined by the specified complex type definition.
   *
   * @param typeDefinition The type definition.
   * @param result The validation result to which to add any warnings or errors.
   */
  private void describeRDFClassesAndProperties(ComplexTypeDefinition typeDefinition, ValidationResult result) {
    if (!isResourceRef(typeDefinition)) {
      describeRDFClasses(typeDefinition, result);

      for (Attribute attribute : typeDefinition.getAttributes()) {
        describeRDFProperty(attribute, result);
      }

      for (Element element : typeDefinition.getElements()) {
        for (Element choice : element.getChoices()) {
          describeRDFProperty(choice, result);
        }

        if (element.isWrapped()) {
          result.addWarning(element, "A wrapped element adds significant confusion to the RDF schema.");
        }
      }
    }
  }

  /**
   * Describe the RDF classes and properties defined by the specified QName type definition and add them to the RDF schema.
   *
   * @param qNameEnumTypeDefinition The type definition to describe.
   * @param result The validation result to which to add any warnings or errors.
   */
  private void describeRDFClassesAndProperties(QNameEnumTypeDefinition qNameEnumTypeDefinition, ValidationResult result) {
    describeRDFClasses(qNameEnumTypeDefinition, result);
    Map<String, Object> enumValues = qNameEnumTypeDefinition.getEnumValues();
    for (EnumConstantDeclaration constant : qNameEnumTypeDefinition.getEnumConstants()) {
      QName qname = (QName) enumValues.get(constant.getSimpleName());
      if (qname != null) {
        String about = qname.getNamespaceURI() + qname.getLocalPart();
        RDFSchema.RDFDescription description = this.rdfSchema.findDescription(about);
        if (description == null) {
          description = new RDFSchema.RDFDescription();
          description.setAbout(about);
          description.setIsDefinedBy(qname.getNamespaceURI());
          description.setType(RDFSchema.RDFS_CLASS_TYPE);
          description.setLabel(constant.getSimpleName());
          description.setAssociatedDeclaration(constant);
          this.rdfSchema.addDescription(description);
        }
        else {
          if (!qname.getNamespaceURI().equals(description.getIsDefinedBy())) {
            StringBuilder message = new StringBuilder("Unable to describe class ").append(about).append(" because it's already described");
            appendPosition(message, description.getAssociatedDeclaration());
            message.append('.');
            result.addError(constant, message.toString());
          }

          if (!RDFSchema.RDFS_CLASS_TYPE.equals(description.getType())) {
            StringBuilder message = new StringBuilder("Unable to describe class ").append(about).append(" because it's already described as of type '").append(description.getType()).append("'");
            appendPosition(message, description.getAssociatedDeclaration());
            message.append('.');
            result.addError(constant, message.toString());
          }
        }

        String docComment = constant.getDocComment();
        docComment = docComment == null ? "" : docComment.trim();
        if (!docComment.isEmpty()) {
          description.addComment(docComment);
        }
      }
    }
  }

  /**
   * Create the RDF description for the specified accessor and add it to the RDF schema.
   *
   * @param accessor The accessor for which to describe the RDF property.
   * @param result The validation result to which to add any warnings or errors.
   */
  private void describeRDFProperty(Accessor accessor, ValidationResult result) {
    String namespace = accessor.getNamespace();
    String name = accessor.getName();
    String about = namespace + name;
    Set<String> domain = determineRDFDomain(accessor, result);
    Set<String> range = determineRDFRange(accessor, result);
    Set<String> superProperties = determineRDFSuperProperties(accessor, result);
    RDFSchema.RDFDescription description = this.rdfSchema.findDescription(about);
    if (description == null) {
      description = new RDFSchema.RDFDescription();
      description.setAbout(about);
      description.setLabel(name);
      description.setIsDefinedBy(namespace);
      description.setType(RDFSchema.RDF_PROPERTY_TYPE);
      description.setRange(range);
      description.setDomain(domain);
      description.setSubPropertyOf(superProperties);
      description.setAssociatedDeclaration(accessor);
      this.rdfSchema.addDescription(description);
    }
    else {
      if (!namespace.equals(description.getIsDefinedBy())) {
        StringBuilder message = new StringBuilder("Unable to describe property ").append(about).append(" because it's already described as defined by '").append(description.getIsDefinedBy()).append("'");
        appendPosition(message, description.getAssociatedDeclaration());
        message.append('.');
        result.addError(accessor, message.toString());
      }

      if (!RDFSchema.RDF_PROPERTY_TYPE.equals(description.getType())) {
        StringBuilder message = new StringBuilder("Unable to describe property ").append(about).append(" because it's already described as of type '").append(description.getType()).append("'");
        appendPosition(message, description.getAssociatedDeclaration());
        message.append('.');
        result.addError(accessor, message.toString());
      }

      if (!range.equals(description.getRange())) {
        StringBuilder message = new StringBuilder("Unable to describe property ").append(about).append(" because it's range is already described as ");
        message.append(getSetComparisonMessage(description.getRange(), range));
        appendPosition(message, description.getAssociatedDeclaration());
        message.append('.');
        result.addError(accessor, message.toString());
      }

      if (!domain.equals(description.getDomain())) {
        StringBuilder message = new StringBuilder("Unable to describe property ").append(about).append(" because it's domain is already described as ");
        message.append(getSetComparisonMessage(description.getDomain(), domain));
        appendPosition(message, description.getAssociatedDeclaration());
        message.append('.');
        result.addError(accessor, message.toString());
      }

      if (!superProperties.equals(description.getSubPropertyOf())) {
        StringBuilder message = new StringBuilder("Unable to describe property ").append(about).append(" because it's 'subPropertyOf' is already described as ");
        message.append(getSetComparisonMessage(description.getSubPropertyOf(), superProperties));
        appendPosition(message, description.getAssociatedDeclaration());
        message.append('.');
        result.addError(accessor, message.toString());
      }
    }

    if (accessor.getJavaDoc() != null) {
      String comment = accessor.getJavaDoc().toString();
      if (!comment.isEmpty()) {
        description.addComment(comment);
      }
    }
  }

  /**
   * Get a message describing the comparison between two string sets.
   *
   * @param set1 The first set.
   * @param set2 The second set.
   * @return The message describing the comparison.
   */
  private StringBuilder getSetComparisonMessage(Set<String> set1, Set<String> set2) {
    StringBuilder setComparisonMessage = new StringBuilder();
    if (set1 == null || set1.isEmpty()) {
      setComparisonMessage.append("empty");
    }
    else {
      setComparisonMessage.append('[');
      Iterator<String> it = set1.iterator();
      while (it.hasNext()) {
        setComparisonMessage.append("\"").append(it.next()).append("\"");
        if (it.hasNext()) {
          setComparisonMessage.append(",");
        }
      }
      setComparisonMessage.append(']');
    }
    setComparisonMessage.append(" which conflicts with ");
    if (set2 == null || set2.isEmpty()) {
      setComparisonMessage.append("the empty set");
    }
    else {
      setComparisonMessage.append('[');
      Iterator<String> it = set2.iterator();
      while (it.hasNext()) {
        setComparisonMessage.append("\"").append(it.next()).append("\"");
        if (it.hasNext()) {
          setComparisonMessage.append(",");
        }
      }
      setComparisonMessage.append(']');
    }

    return setComparisonMessage;
  }

  /**
   * Determine the RDF properties for which the specified accessor is a subproperty.
   *
   * @param accessor The accessor.
   * @param result The validation result to which to add any warnings or errors.
   * @return The set of RDF Class URIs that define the properties for which the specified accessor is a subproperty.
   */
  private Set<String> determineRDFSuperProperties(Accessor accessor, ValidationResult result) {
    //since there's no such thing as "subproperties" in java, we have to determine subproperties completely via annotations.
    TreeSet<String> superProperties = new TreeSet<String>();
    RDFSubPropertyOf rdfSubPropertyOf = accessor.getAnnotation(RDFSubPropertyOf.class);
    if (rdfSubPropertyOf != null) {
      superProperties.addAll(Arrays.asList(rdfSubPropertyOf.value()));
    }
    return superProperties;
  }

  /**
   * Determine the RDF range for the specified accessor.
   *
   * @param accessor The accessor.
   * @param result The validation result to which to add any warnings or errors.
   * @return The set of RDF Class URIs that define the range of the specified accessor.
   */
  private Set<String> determineRDFRange(Accessor accessor, ValidationResult result) {
    TreeSet<String> range = new TreeSet<String>();
    Set<String> explicitRange = getExplicitRange(accessor);
    if (explicitRange != null) {
      range.addAll(explicitRange);
    }
    else {
      org.codehaus.enunciate.contract.jaxb.types.XmlType xmlType = null;
      if (accessor.isElementRef()) {
        try {
          xmlType = XmlTypeFactory.getXmlType(accessor.getBareAccessorType());
        }
        catch (XmlTypeException e) {
          result.addWarning(accessor, String.format("Unable to determine range (%s). Please consider explicitly declaring the range of this accessor.", e.getMessage()));
        }
      }
      else {
        xmlType = accessor.getBaseType();
      }

      if (xmlType != null) {
        if (isResourceRef(xmlType)) {
          result.addWarning(accessor, "Unable to determine range because the accessor type appears to be a resource reference because it declares an rdf:resource attribute. Please consider explicitly declaring the range of this accessor.");
        }
        else if (xmlType.isSimple()) {
          //if the accessor type is a simple type, return literal.
          range.add(RDFSchema.RDFS_LITERAL_RANGE);
        }
        else {
          range.add(xmlType.getNamespace() + xmlType.getName());
        }
      }
    }

    return range;
  }

  /**
   * Whether the specified xml type appears to be an RDF resource reference.
   *
   * @param xmlType The xml type.
   * @return Whether the specified xml type appears to be an RDF resource reference.
   */
  private boolean isResourceRef(org.codehaus.enunciate.contract.jaxb.types.XmlType xmlType) {
    return xmlType instanceof XmlClassType && isResourceRef(((XmlClassType) xmlType).getTypeDefinition());
  }

  /**
   * Whether the specified type definition appears to be an RDF resource reference.
   *
   * @param typeDefinition the type definition.
   * @return Whether the specified xml type appears to be an RDF resource reference.
   */
  private boolean isResourceRef(TypeDefinition typeDefinition) {
    for (Attribute attribute : typeDefinition.getAttributes()) {
      if (RDFSchema.RDF_NAMESPACE.equals(attribute.getNamespace()) && "resource".equals(attribute.getName())) {
        return true;
      }
    }

    return false;
  }

  /**
   * Get the explicit range for the specified accessor.
   *
   * @param accessor The accessor.
   * @return The range, or null of no explicit range was provided.
   */
  private Set<String> getExplicitRange(Accessor accessor) {
    Set<String> range = null;
    RDFRange rangeInfo = accessor.getAnnotation(RDFRange.class);
    if (rangeInfo != null) {
      range = new TreeSet<String>();
      range.addAll(Arrays.asList(rangeInfo.value()));
    }
    return range;
  }

  /**
   * Determine the RDF domain of the given accessor.
   *
   * @param accessor The accessor.
   * @param result The validation result against which to log any warnings or errors.
   * @return The set of RDF Class URIs that define the domain for the specified accessor.
   */
  private Set<String> determineRDFDomain(Accessor accessor, ValidationResult result) {
    TypeDeclaration declaringType = accessor.getDeclaringType();
    if (accessor.getDelegate() instanceof PropertyDeclaration) {
      //only property declarations can be declared in an inherited type
      DecoratedMethodDeclaration getter = ((PropertyDeclaration) accessor.getDelegate()).getGetter();
      if (getter != null) {
        //only the getter; we won't worry about the setter.
        MethodDeclaration method = (MethodDeclaration) getter.getDelegate();
        TypeDeclaration candidate = findDeclaringType(method.getDeclaringType(), method);
        if (candidate != null) {
          declaringType = candidate;
        }
      }
    }

    TreeSet<String> domain = new TreeSet<String>();
    QName rdfUri = findRDFUri(declaringType);
    domain.add(rdfUri.getNamespaceURI() + rdfUri.getLocalPart());
    return domain;
  }

  /**
   * Find the declaring type of the given method starting from a specified type.
   *
   * @param type The type.
   * @param method The method.
   * @return The type that declares the specified method from the inheritance tree of the specified type.
   */
  private TypeDeclaration findDeclaringType(TypeDeclaration type, MethodDeclaration method) {
    if (type == null || Object.class.getName().equals(type.getQualifiedName())) {
      return null;
    }

    while (method instanceof DecoratedMethodDeclaration) {
      method = (MethodDeclaration) ((DecoratedMethodDeclaration) method).getDelegate();
    }

    Declarations declarationUtils = Context.getCurrentEnvironment().getDeclarationUtils();
    Collection<? extends MethodDeclaration> methods = type.getMethods();
    for (MethodDeclaration candidate : methods) {
      while (candidate instanceof DecoratedMethodDeclaration) {
        candidate = (MethodDeclaration) ((DecoratedMethodDeclaration) candidate).getDelegate();
      }

      if (declarationUtils.overrides(candidate, method)) {
        return type;
      }
    }

    Collection<InterfaceType> superinterfaces = type.getSuperinterfaces();
    if (superinterfaces != null) {
      for (InterfaceType superinterface : superinterfaces) {
        TypeDeclaration declaringType = findDeclaringType(superinterface.getDeclaration(), method);
        if (declaringType != null) {
          return declaringType;
        }
      }
    }

    if (type instanceof ClassDeclaration) {
      TypeDeclaration declaringType = findDeclaringType(((ClassDeclaration) type).getSuperclass().getDeclaration(), method);
      if (declaringType != null) {
        return declaringType;
      }
    }

    return null;
  }

  /**
   * Describe the specified schema and add the description to the RDF schema.
   *
   * @param schema The schema to describe.
   * @param result The result against which to log any errors or warnings.
   */
  private void describeSchema(SchemaInfo schema, ValidationResult result) {
    String label = (String) schema.getProperty("label");
    if (label == null) {
      label = schema.getId();
    }

    String desc = (String) schema.getProperty("description");
    if (desc == null) {
      desc = String.format("Vocabulary definitions for the %s namespace.", schema.getNamespace());
    }

    RDFSchema.RDFDescription description = this.rdfSchema.findDescription(schema.getNamespace());
    if (description == null) {
      description = new RDFSchema.RDFDescription();
      this.rdfSchema.addDescription(description);
    }
    description.setAbout(schema.getNamespace());
    description.setLabel(label);
    description.addComment(desc);
  }

  /**
   * Find the RDF URI for the specified type declaration.
   *
   * @param typeDeclaration The type declaration.
   * @return The RDF URI, in terms of its QName.
   */
  private QName findRDFUri(TypeDeclaration typeDeclaration) {
    if (typeDeclaration == null || Object.class.getName().equals(typeDeclaration.getQualifiedName())) {
      return null;
    }

    String namespace = "";
    String name = Introspector.decapitalize(typeDeclaration.getSimpleName());
    PackageDeclaration pkg = typeDeclaration.getPackage();
    if (pkg != null && pkg.getAnnotation(XmlSchema.class) != null) {
      namespace = pkg.getAnnotation(XmlSchema.class).namespace();
    }
    XmlType xmlType = typeDeclaration.getAnnotation(XmlType.class);
    if (xmlType != null) {
      if (!"##default".equals(xmlType.namespace())) {
        namespace = xmlType.namespace();
      }
      if (!"##default".equals(xmlType.name())) {
        name = xmlType.name();
      }
    }

    return new QName(namespace, name);
  }

  /**
   * Describe the RDF classes for the specified type definition and add them to the RDF schema.
   *
   * @param typeDefinition The type definition to describe.
   * @param result The validation result to which to add any warnings or errors.
   */
  private void describeRDFClasses(TypeDefinition typeDefinition, ValidationResult result) {
    String namespace = typeDefinition.getNamespace();
    String about = typeDefinition.getName();
    RDFSchema.RDFDescription description = this.rdfSchema.findDescription(about);
    if (description == null) {
      description = new RDFSchema.RDFDescription();
      description.setAbout(about);
      description.setIsDefinedBy(namespace);
      description.setType(RDFSchema.RDFS_CLASS_TYPE);
      description.setLabel(typeDefinition.getSimpleName());
      description.setAssociatedDeclaration(typeDefinition);
      String comment = new JavaDoc(typeDefinition.getDocComment()).toString();
      if (!comment.isEmpty()) {
        description.addComment(comment);
      }

      if (!typeDefinition.isBaseObject()) {
        org.codehaus.enunciate.contract.jaxb.types.XmlType xmlType = typeDefinition.getBaseType();
        if (!xmlType.isSimple()) {
          description.addSubClassOf(xmlType.getNamespace() + xmlType.getName());
        }
        else {
          result.addWarning(typeDefinition, String.format("Unable to add %s as a super class of %s because it's a simple type.", xmlType.getNamespace() + xmlType.getName(), about));
        }
      }

      for (String superclass : findExplicitSuperclasses(typeDefinition)) {
        description.addSubClassOf(superclass);
      }

      Collection<InterfaceType> superinterfaces = typeDefinition.getSuperinterfaces();
      if (superinterfaces != null) {
        for (InterfaceType superinterface : superinterfaces) {
          String resource = describeRDFClasses(superinterface.getDeclaration(), result);
          if (resource != null) {
            description.addSubClassOf(resource);
          }
        }
      }

      this.rdfSchema.addDescription(description);
    }
    else if (!(description.getAssociatedDeclaration() instanceof TypeDeclaration) || !((TypeDeclaration) description.getAssociatedDeclaration()).getQualifiedName().equals(typeDefinition.getQualifiedName())) {
      StringBuilder message = new StringBuilder("Unable to describe class ").append(about).append(" because it's already described");
      appendPosition(message, description.getAssociatedDeclaration());
      message.append('.');
      result.addError(typeDefinition, message.toString());
    }
  }

  private Set<String> findExplicitSuperclasses(TypeDeclaration declaration) {
    TreeSet<String> explicitSupers = new TreeSet<String>();
    RDFSubClassOf subClassOf = declaration.getAnnotation(RDFSubClassOf.class);
    if (subClassOf != null) {
      explicitSupers.addAll(Arrays.asList(subClassOf.value()));
    }
    return explicitSupers;
  }

  /**
   * Describe the RDF classes for the specified interface declaration and add them to the RDF schema.
   *
   * @param iface The type declaration to describe.
   * @param result The validation result to which to add any warnings or errors.
   * @return The RDF URI of the class description for the specified interface.
   */
  private String describeRDFClasses(InterfaceDeclaration iface, ValidationResult result) {
    String about = null;
    if (iface.getAnnotation(XmlType.class) != null) {
      QName rdfUri = findRDFUri(iface);
      String namespace = rdfUri.getNamespaceURI();
      about = namespace + rdfUri.getLocalPart();
      RDFSchema.RDFDescription description = this.rdfSchema.findDescription(about);
      if (description == null) {
        description = new RDFSchema.RDFDescription();
        description.setAbout(about);
        description.setIsDefinedBy(namespace);
        description.setType(RDFSchema.RDFS_CLASS_TYPE);
        description.setLabel(iface.getSimpleName());
        description.setAssociatedDeclaration(iface);
        String comment = new JavaDoc(iface.getDocComment()).toString();
        if (!comment.isEmpty()) {
          description.addComment(comment);
        }
        this.rdfSchema.addDescription(description);

        for (String superclass : findExplicitSuperclasses(iface)) {
          description.addSubClassOf(superclass);
        }

        Collection<InterfaceType> superinterfaces = iface.getSuperinterfaces();
        if (superinterfaces != null) {
          for (InterfaceType superinterface : superinterfaces) {
            String resource = describeRDFClasses(superinterface.getDeclaration(), result);
            if (resource != null) {
              description.addSubClassOf(resource);
            }
          }
        }
      }
      else if (!(description.getAssociatedDeclaration() instanceof TypeDeclaration) || !((TypeDeclaration) description.getAssociatedDeclaration()).getQualifiedName().equals(iface.getQualifiedName())) {
        StringBuilder message = new StringBuilder("Unable to describe class ").append(about).append(" because it's already described");
        appendPosition(message, description.getAssociatedDeclaration());
        message.append('.');
        result.addError(iface, message.toString());
      }
    }

    return about;
  }

  protected void loadKnownRDFSchemaDescriptions() {
    Unmarshaller unmarshaller;
    try {
      unmarshaller = JAXBContext.newInstance(RDFSchema.class).createUnmarshaller();
    }
    catch (JAXBException e) {
      throw new RuntimeException(e);
    }

    URL resource = RDFProcessor.class.getResource("dcterms.rdf.xml");
    if (resource != null) {
      loadRDFSchema(unmarshaller, resource);
    }
    addDescription(RDFSchema.RDF_NAMESPACE, "ID", true, true);
    addDescription(RDFSchema.RDF_NAMESPACE, "about", true, true);
    addDescription(RDFSchema.RDF_NAMESPACE, "resource", true, true);
    addDescription(RDFSchema.RDF_NAMESPACE, "value", true, true);
    addDescription(RDFSchema.RDF_NAMESPACE, "type", true, false);
    addDescription(RDFSchema.RDF_NAMESPACE, "Description", true, false);
    addDescription(XMLConstants.XML_NS_URI, "lang", true, true);
  }

  protected void loadRDFSchema(Unmarshaller unmarshaller, URL schemaUrl) {
    try {
      InputStream stream = schemaUrl.openStream();
      RDFSchema schema = (RDFSchema) unmarshaller.unmarshal(stream);
      this.rdfSchema.addDescriptions(schema);
    }
    catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    catch (IOException e) {
      throw new RuntimeException(String.format("Unable to read resource %s: %s", schemaUrl, e.getMessage()));
    }
  }

  protected void addDescription(String namespace, String name, boolean property, boolean literal) {
    RDFSchema.RDFDescription description = new RDFSchema.RDFDescription();
    description.setAbout(namespace + name);
    if (property) {
      description.setType(RDFSchema.RDF_PROPERTY_TYPE);
    }
    if (literal) {
      description.setRange(new TreeSet<String>());
      description.getRange().add(RDFSchema.RDFS_LITERAL_RANGE);
    }
    description.setIsDefinedBy(namespace);
    this.rdfSchema.addDescription(description);
  }

  private void appendPosition(StringBuilder message, Declaration associatedDeclaration) {
    if (associatedDeclaration != null) {
      message.append(" as defined by ");
      if (associatedDeclaration.getPosition() != null) {
        message.append(associatedDeclaration.getPosition());
      }
      else {
        if (associatedDeclaration instanceof MemberDeclaration) {
          TypeDeclaration declaringType = ((MemberDeclaration) associatedDeclaration).getDeclaringType();
          if (declaringType != null) {
            message.append(declaringType.getQualifiedName()).append('#');
          }
          message.append(associatedDeclaration instanceof TypeDeclaration ? ((TypeDeclaration)associatedDeclaration).getQualifiedName() : associatedDeclaration.getSimpleName());
        }
      }
    }
  }

}
