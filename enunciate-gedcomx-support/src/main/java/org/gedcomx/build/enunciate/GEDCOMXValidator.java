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
import com.sun.mirror.type.DeclaredType;
import com.sun.mirror.type.EnumType;
import com.sun.mirror.type.MirroredTypeException;
import com.sun.mirror.type.TypeMirror;
import net.sf.jelly.apt.decorations.declaration.DecoratedMethodDeclaration;
import net.sf.jelly.apt.decorations.declaration.PropertyDeclaration;
import org.codehaus.enunciate.contract.jaxb.*;
import org.codehaus.enunciate.contract.jaxb.types.XmlClassType;
import org.codehaus.enunciate.contract.jaxb.types.XmlType;
import org.codehaus.enunciate.contract.validation.BaseValidator;
import org.codehaus.enunciate.contract.validation.ValidationResult;
import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Ryan Heaton
 */
public class GEDCOMXValidator extends BaseValidator {

  @Override
  public ValidationResult validateComplexType(ComplexTypeDefinition complexType) {
    ValidationResult result = validateTypeDefinition(complexType);
    if (!complexType.isFinal() && !complexType.isAbstract()) {
      //validate the json type info.
      JsonTypeInfo jsonTypeInfo = complexType.getAnnotation(JsonTypeInfo.class);
      if (jsonTypeInfo == null || jsonTypeInfo.include() != JsonTypeInfo.As.PROPERTY || jsonTypeInfo.use() != JsonTypeInfo.Id.CUSTOM || !"@type".equals(jsonTypeInfo.property())) {
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
        if ("href".equals(attribute.getName()) && !"http://www.w3.org/1999/xlink".equals(attribute.getNamespace())) {
          result.addError(attribute, "Entity links should be make with an attribute named 'href' in the 'http://www.w3.org/1999/xlink' namespace.");
        }

        if ("id".equalsIgnoreCase(attribute.getName()) && !attribute.isXmlID()) {
          result.addError(attribute, "Id attributes should be annotated as @XmlID.");
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
    }

    Collection<Element> elements = typeDef.getElements();
    if (elements != null && !elements.isEmpty()) {
      for (Element element : elements) {
        for (Element choice : element.getChoices()) {
          if ("href".equals(choice.getName()) && !"http://www.w3.org/1999/xlink".equals(choice.getNamespace())) {
            result.addError(choice, "Entity links should be make with an attribute named 'href' in the 'http://www.w3.org/1999/xlink' namespace. You probably need to apply @XmlAttribute(namespace='http://www.w3.org/1999/xlink')");
          }

          if ("id".equals(choice.getName()) && !choice.isXmlID()) {
            result.addError(choice, "Accessors named 'id' should be attributes and annotated with @XmlID.");
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
            if ("persistentidentifier".equals(((DeclaredType)accessorType).getDeclaration().getSimpleName().toLowerCase()) &&
              (!"persistentId".equals(element.getName()) || element.isWrapped())) {
              result.addWarning(element, "Element name for PersistentIdentifier should probably be named 'persistentId' to be consistent.");
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

    return result;
  }
}
