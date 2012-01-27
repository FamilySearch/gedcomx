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

import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.MemberDeclaration;
import com.sun.mirror.type.*;
import net.sf.jelly.apt.decorations.TypeMirrorDecorator;
import net.sf.jelly.apt.decorations.declaration.DecoratedMethodDeclaration;
import net.sf.jelly.apt.decorations.declaration.PropertyDeclaration;
import net.sf.jelly.apt.decorations.type.DecoratedClassType;
import net.sf.jelly.apt.decorations.type.DecoratedInterfaceType;
import net.sf.jelly.apt.decorations.type.DecoratedTypeMirror;
import org.codehaus.enunciate.contract.jaxb.*;
import org.codehaus.enunciate.contract.jaxb.types.KnownXmlType;
import org.codehaus.enunciate.contract.jaxb.types.XmlClassType;
import org.codehaus.enunciate.contract.jaxb.types.XmlType;
import org.codehaus.enunciate.contract.validation.BaseValidator;
import org.codehaus.enunciate.contract.validation.ValidationResult;
import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.*;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Ryan Heaton
 */
public class GedcomxValidator extends BaseValidator {

  @Override
  public ValidationResult validateComplexType(ComplexTypeDefinition complexType) {
    ValidationResult result = validateTypeDefinition(complexType);
    if (!complexType.isFinal() && !complexType.isAbstract()) {
      //validate the json type info.
      // (heatonra, 9/12/2011) for the record, I looked into lifting the requirement to annotate all non-abstract, non-final
      // classes with @JsonTypeInfo, @JsonTypeIdResolver and limiting its application to all classes that _extend_ non-abstract, non-final
      // classes. Everything seemed to work fine until you came across lists/collections that could possibly be mixed. When
      // Jackson deserializes a list of, e.g. RDFDescription that contains an instance of e.g. DublinCoreDescription then it pukes
      // with a message like "unrecognized property" because it's attempting to deserialize a DublinCoreDescription into an instance
      // of RDFDescription. Sigh. So it was decided that we'll continue with the policy of always writing out the type of non-final classes,
      // at least until Jackson provides some more runtime flexibility.
      JsonTypeInfo jsonTypeInfo = complexType.getAnnotation(JsonTypeInfo.class);
      if (jsonTypeInfo == null || jsonTypeInfo.include() != JsonTypeInfo.As.PROPERTY || jsonTypeInfo.use() != JsonTypeInfo.Id.CUSTOM || !XmlTypeIdResolver.TYPE_PROPERTY_NAME.equals(jsonTypeInfo.property())) {
        result.addError(complexType, "Non-final, non-abstract complex types need to be annotated with @JsonTypeInfo(use=JsonTypeInfo.Id.CUSTOM, property=\"@type\")");
      }

      String idResolverName = "";
      JsonTypeIdResolver typeIdResolverInfo = complexType.getAnnotation(JsonTypeIdResolver.class);
      if (typeIdResolverInfo != null) {
        try {
          idResolverName = typeIdResolverInfo.value().getName();
        }
        catch (MirroredTypeException e) {
          idResolverName = ((DeclaredType) e.getTypeMirror()).getDeclaration().getQualifiedName();
        }
      }

      if (!XmlTypeIdResolver.class.getName().equals(idResolverName)) {
        result.addError(complexType, "Non-final, non-abstract complex types need to be annotated with @org.codehaus.jackson.map.annotate.JsonTypeIdResolver(org.gedcomx.id.XmlTypeIdResolver.class) to specify their JSON type id.");
      }

      if (!suppressWarning(complexType, "gedcomx:no_id") && !hasIdAttribute(complexType)) {
        result.addWarning(complexType, "Non-final, non-abstract complex types might need to have an 'id' attribute so they can be referenced.");
      }
    }
    return result;
  }

  private boolean suppressWarning(Declaration declaration, String warning) {
    SuppressWarnings suppressionInfo = declaration.getAnnotation(SuppressWarnings.class);
    return suppressionInfo != null && Arrays.asList(suppressionInfo.value()).contains(warning);
  }

  protected boolean hasIdAttribute(ComplexTypeDefinition complexType) {
    boolean idAttributeFound = false;
    for (Attribute attribute : complexType.getAttributes()) {
      if (attribute.isXmlID()) {
        idAttributeFound = true;
        break;
      }
    }
    XmlType baseType = complexType.getBaseType();
    if (baseType instanceof XmlClassType) {
      TypeDefinition typeDefinition = ((XmlClassType) baseType).getTypeDefinition();
      if (typeDefinition.isComplex()) {
        idAttributeFound = hasIdAttribute((ComplexTypeDefinition) typeDefinition);
      }
    }
    return idAttributeFound;
  }

  @Override
  public ValidationResult validateSimpleType(SimpleTypeDefinition simpleType) {
    return validateTypeDefinition(simpleType);
  }

  @Override
  public ValidationResult validateEnumType(EnumTypeDefinition enumType) {
    return validateTypeDefinition(enumType);
  }

  @Override
  public ValidationResult validateRootElement(RootElementDeclaration rootElementDeclaration) {
    ValidationResult result = super.validateRootElement(rootElementDeclaration);
    String namespace = rootElementDeclaration.getNamespace();
    if (namespace == null || "".equals(namespace)) {
      result.addError(rootElementDeclaration, "Root element should not be in the empty namespace.");
    }

    if (rootElementDeclaration.getName().toLowerCase().startsWith("web")) {
      result.addWarning(rootElementDeclaration, "You probably don't want a root element that starts with the name 'web'. Consider renaming using the @XmlRootElement annotation.");
    }

    JsonTypeInfo jsonTypeInfo = rootElementDeclaration.getAnnotation(JsonTypeInfo.class);
    if (jsonTypeInfo == null || jsonTypeInfo.include() != JsonTypeInfo.As.PROPERTY || jsonTypeInfo.use() != JsonTypeInfo.Id.CUSTOM || !XmlTypeIdResolver.TYPE_PROPERTY_NAME.equals(jsonTypeInfo.property())) {
      result.addError(rootElementDeclaration, "Root elements need to be annotated with @JsonTypeInfo(use=JsonTypeInfo.Id.CUSTOM, property=\"@type\")");
    }

    String idResolverName = "";
    JsonTypeIdResolver typeIdResolverInfo = rootElementDeclaration.getAnnotation(JsonTypeIdResolver.class);
    if (typeIdResolverInfo != null) {
      try {
        idResolverName = typeIdResolverInfo.value().getName();
      }
      catch (MirroredTypeException e) {
        idResolverName = ((DeclaredType) e.getTypeMirror()).getDeclaration().getQualifiedName();
      }
    }

    if (!XmlTypeIdResolver.class.getName().equals(idResolverName)) {
      result.addError(rootElementDeclaration, "Root elements need to be annotated with @org.codehaus.jackson.map.annotate.JsonTypeIdResolver(org.gedcomx.id.XmlTypeIdResolver.class) to specify their JSON type id.");
    }

    if (namespace.startsWith(CommonModels.GEDCOMX_DOMAIN) && rootElementDeclaration.getAnnotation(JsonElementWrapper.class) == null) {
      result.addWarning(rootElementDeclaration, "Root elements in the '" + CommonModels.GEDCOMX_DOMAIN + "' namespace should probably be annotated with @" + JsonElementWrapper.class.getSimpleName() + ".");
    }

    return result;
  }

  public ValidationResult validateTypeDefinition(TypeDefinition typeDef) {
    ValidationResult result = new ValidationResult();

    //heatonra: using @XmlSeeAlso for a QName enum doesn't actually include the xmlns declaration, so there's no reason to validate it here...
    //heatonra: I couldn't figure out a good way to validate the use of @XmlSeeAlso for extended types at build-time. I think we'll have to rely on unit tests to validate this.

    if ("".equals(typeDef.getNamespace())) {
      result.addError(typeDef, "Type definition should not be in the empty namespace.");
    }

    if (typeDef.getName().toLowerCase().startsWith("web")) {
      result.addWarning(typeDef, "You probably don't want a type definition that starts with the name 'web'. Consider renaming using the @XmlType annotation.");
    }

    Collection<Attribute> attributes = typeDef.getAttributes();
    if (attributes != null && !attributes.isEmpty()) {
      for (Attribute attribute : attributes) {
        boolean isURI = ((DecoratedTypeMirror) TypeMirrorDecorator.decorate(attribute.getAccessorType())).isInstanceOf("org.gedcomx.common.URI");
        if (isURI && !KnownXmlType.ANY_URI.getQname().equals(attribute.getBaseType().getQname())) {
          result.addError(attribute, "Accessors of type 'org.gedcomx.common.URI' should of type xs:anyURI. Please annotate the attribute with @XmlSchemaType(name = \"anyURI\", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)");
        }

        if ("id".equalsIgnoreCase(attribute.getName())) {
          if (!attribute.isXmlID()) {
            result.addError(attribute, "Id attributes should be annotated as @XmlID.");
          }
        }

        if ("persistentId".equalsIgnoreCase(attribute.getName())) {
          result.addWarning(attribute, "Persistent IDs should be elements to conform to the established pattern.");
        }

        TypeMirror accessorType = attribute.getAccessorType();
        if (accessorType instanceof EnumType && ((EnumType) accessorType).getDeclaration().getAnnotation(XmlQNameEnum.class) != null) {
          result.addError(attribute, "Accessors should not reference QName enums directly. You probably want to annotate this accessor with @XmlTransient.");
        }
      }
    }

    Value value = typeDef.getValue();
    if (value != null) {
      TypeMirror accessorType = value.getAccessorType();
      if (accessorType instanceof EnumType && ((EnumType) accessorType).getDeclaration().getAnnotation(XmlQNameEnum.class) != null) {
        result.addError(value, "Accessors should not reference QName enums directly. You probably want to annotate this accessor with @XmlTransient.");
      }

      boolean isURI = ((DecoratedTypeMirror) TypeMirrorDecorator.decorate(accessorType)).isInstanceOf("org.gedcomx.common.URI");
      if (isURI && !KnownXmlType.ANY_URI.getQname().equals(value.getBaseType().getQname())) {
        result.addError(value, "Accessors of type 'org.gedcomx.common.URI' should of type xs:anyURI. Please annotate the value with @XmlSchemaType(name = \"anyURI\", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)");
      }
    }

    Collection<Element> elements = typeDef.getElements();
    if (elements != null && !elements.isEmpty()) {
      for (Element element : elements) {
        for (Element choice : element.getChoices()) {
          boolean isURI = ((DecoratedTypeMirror) TypeMirrorDecorator.decorate(choice.getAccessorType())).isInstanceOf("org.gedcomx.common.URI");
          if (isURI && !KnownXmlType.ANY_URI.getQname().equals(choice.getBaseType().getQname())) {
            result.addError(choice, "Accessors of type 'org.gedcomx.common.URI' should of type xs:anyURI. Please annotate the element with @XmlSchemaType(name = \"anyURI\", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)");
          }

          if ("href".equals(choice.getName())) {
            result.addError(choice, "Entity links should be make with an attribute named 'href'. You probably need to apply @XmlAttribute.");
          }

          if ("persistentId".equals(choice.getName()) && !isURI) {
            result.addError(choice, "Accessors named 'persistentId' should be elements of type URI.");
          }

          TypeMirror accessorType = choice.getAccessorType();
          if (accessorType instanceof EnumType && ((EnumType) accessorType).getDeclaration().getAnnotation(XmlQNameEnum.class) != null) {
            result.addError(choice, "Accessors should not reference QName enums directly. You probably want to annotate this accessor with @XmlTransient.");
          }

          accessorType = choice.getBareAccessorType();
          if (accessorType instanceof DeclaredType) {
            if ("alternateid".equals(((DeclaredType)accessorType).getDeclaration().getSimpleName().toLowerCase()) &&
              (!"alternateId".equals(element.getName()) || element.isWrapped())) {
              result.addWarning(element, "Element name for AlternateId should probably be named 'alternateId' to be consistent.");
            }
          }

          QName ref = choice.getRef();
          String ns = ref != null ? ref.getNamespaceURI() : choice.getNamespace();
          if (ns == null || "".equals(ns)) {
            result.addError(choice, "Choice should not reference the empty namespace.");
          }
        }

        if (element.isCollectionType()) {
          if (!element.isWrapped() && element.getName().endsWith("s")) {
            if (!suppressWarning(element, "gedcomx:plural_xml_name")) {
              result.addWarning(element, "You may want to use @XmlElement to change the name to a non-plural form.");
            }
          }
          else {
            //make sure collection types have a proper json name.
            String jsonMemberName = element.getJsonMemberName();
            if (!jsonMemberName.endsWith("s")) {
              if (!suppressWarning(element, "gedcomx:non_plural_json_name")) {
                result.addWarning(element, "Collection element should probably have a JSON name that ends with 's'. Consider annotating it with @JsonName.");
              }
            }
            else if (!element.isWrapped()) {
              if (element.getDelegate() instanceof PropertyDeclaration) {
                DecoratedMethodDeclaration getter = ((PropertyDeclaration) element.getDelegate()).getGetter();
                if (getter == null || getter.getAnnotation(JsonProperty.class) == null || !jsonMemberName.equals(getter.getAnnotation(JsonProperty.class).value())) {
                  result.addWarning(element, "Collection element is annotated with @JsonName, but the getter needs to also be annotated with @JsonProperty(\"" + jsonMemberName + "\").");
                }
                DecoratedMethodDeclaration setter = ((PropertyDeclaration) element.getDelegate()).getSetter();
                if (setter == null || setter.getAnnotation(JsonProperty.class) == null || !jsonMemberName.equals(setter.getAnnotation(JsonProperty.class).value())) {
                  result.addWarning(element, "Collection element is annotated with @JsonName, but the setter needs to also be annotated with @JsonProperty(\"" + jsonMemberName + "\").");
                }
              }
              else if (element.getDelegate() instanceof FieldDeclaration) {
                if (element.getAnnotation(JsonProperty.class) == null || !jsonMemberName.equals(element.getAnnotation(JsonProperty.class).value())) {
                  result.addWarning(element, "Collection element is annotated with @JsonName, but the field needs to also be annotated with @JsonProperty(\"" + jsonMemberName + "\").");
                }
              }
            }
          }
        }
      }
    }

    AnyElement anyElement = typeDef.getAnyElement();
    if (anyElement != null) {
      if (!isInstanceOf(typeDef, SupportsExtensionElements.class.getName())) {
        result.addError(anyElement, "Type definitions that supply the 'any' element must implement " +
          SupportsExtensionElements.class.getName() + " so the 'any' elements can be serialized to/from JSON.");
      }

      if (!"extensionElements".equals(anyElement.getSimpleName())) {
        if (!suppressWarning(anyElement, "gedcomx:unconventional_any_element_name")) {
          result.addWarning(anyElement, "The 'any' element might be better named 'extensionElements' to conform to convention.");
        }
      }

      JsonIgnore getterIgnore = anyElement.getDelegate() instanceof PropertyDeclaration ?
        ((PropertyDeclaration) anyElement.getDelegate()).getGetter().getAnnotation(JsonIgnore.class) :
        anyElement.getAnnotation(JsonIgnore.class);
      JsonIgnore setterIgnore = anyElement.getDelegate() instanceof PropertyDeclaration ?
        ((PropertyDeclaration) anyElement.getDelegate()).getGetter().getAnnotation(JsonIgnore.class) :
        getterIgnore;
      if (getterIgnore == null || setterIgnore == null) {
        String message = "Properties annotated with @XmlAnyElement should be annotated with @JsonIgnore.";
        if (anyElement.getDelegate() instanceof PropertyDeclaration) {
          message += " (On both the getter and the setter.)";
        }
        result.addError(anyElement, message);
      }
    }

    if (typeDef.isHasAnyAttribute()) {
      if (!isInstanceOf(typeDef, SupportsExtensionAttributes.class.getName())) {
        result.addError(anyElement, "Type definitions that supply the 'any' attribute must implement " +
          SupportsExtensionAttributes.class.getName() + " so the 'any' attributes can be serialized to/from JSON.");
      }

      MemberDeclaration anyAttribute = null;
      for (PropertyDeclaration prop : typeDef.getProperties()) {
        if (prop.getAnnotation(XmlAnyAttribute.class) != null) {
          anyAttribute = prop;
        }
      }

      if (anyAttribute == null) {
        //must be a field.
        for (FieldDeclaration field : typeDef.getFields()) {
          if (field.getAnnotation(XmlAnyAttribute.class) != null) {
            anyAttribute = field;
          }
        }
      }

      if (anyAttribute != null) {
        if (!"extensionAttributes".equals(anyAttribute.getSimpleName())) {
          if (!suppressWarning(anyElement, "gedcomx:unconventional_any_attribute_name")) {
            result.addWarning(anyElement, "The 'any' attribute might be better named 'extensionAttributes' to conform to convention.");
          }
        }

        JsonIgnore getterIgnore = anyAttribute instanceof PropertyDeclaration ?
          ((PropertyDeclaration) anyAttribute).getGetter().getAnnotation(JsonIgnore.class) :
          anyAttribute.getAnnotation(JsonIgnore.class);
        JsonIgnore setterIgnore = anyAttribute instanceof PropertyDeclaration ?
          ((PropertyDeclaration) anyAttribute).getGetter().getAnnotation(JsonIgnore.class) :
          getterIgnore;
        if (getterIgnore == null || setterIgnore == null) {
          String message = "Properties annotated with @XmlAnyAttribute should be annotated with @JsonIgnore.";
          if (anyAttribute instanceof PropertyDeclaration) {
            message += " (On both the getter and the setter.)";
          }
          result.addError(anyAttribute, message);
        }
      }
    }

    return result;
  }

  private boolean isInstanceOf(TypeDefinition typeDef, String name) {
    for (InterfaceType interfaceType : typeDef.getSuperinterfaces()) {
      if (((DecoratedInterfaceType)TypeMirrorDecorator.decorate(interfaceType)).isInstanceOf(name)) {
        return true;
      }
    }

    ClassType superclass = typeDef.getSuperclass();
    if (superclass != null && ((DecoratedClassType) TypeMirrorDecorator.decorate(superclass)).isInstanceOf(name)) {
      return true;
    }

    return false;
  }
}
