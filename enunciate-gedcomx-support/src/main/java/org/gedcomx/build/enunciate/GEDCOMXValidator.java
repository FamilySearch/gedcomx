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

import com.sun.mirror.type.DeclaredType;
import com.sun.mirror.type.EnumType;
import com.sun.mirror.type.TypeMirror;
import org.codehaus.enunciate.contract.jaxb.*;
import org.codehaus.enunciate.contract.validation.BaseValidator;
import org.codehaus.enunciate.contract.validation.ValidationResult;
import org.codehaus.enunciate.qname.XmlQNameEnum;

import javax.xml.namespace.QName;
import java.util.Collection;

/**
 * @author Ryan Heaton
 */
public class GEDCOMXValidator extends BaseValidator {

  @Override
  public ValidationResult validateComplexType(ComplexTypeDefinition complexType) {
    return validateTypeDefinition(complexType);
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
      }
    }

    return result;
  }
}
