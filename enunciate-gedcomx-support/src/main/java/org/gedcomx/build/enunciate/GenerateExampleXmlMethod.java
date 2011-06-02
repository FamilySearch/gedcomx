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

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import net.sf.jelly.apt.freemarker.FreemarkerModel;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.contract.jaxb.*;
import org.codehaus.enunciate.contract.jaxb.Attribute;
import org.codehaus.enunciate.contract.jaxb.Element;
import org.codehaus.enunciate.contract.jaxb.types.XmlClassType;
import org.codehaus.enunciate.contract.jaxb.types.XmlType;
import org.codehaus.enunciate.doc.DocumentationExample;
import org.jdom.*;
import org.jdom.output.XMLOutputter;

import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.util.List;
import java.util.Stack;

/**
 * @author Ryan Heaton
 */
public class GenerateExampleXmlMethod implements TemplateMethodModelEx {

  /**
   * Stack used for maintaining the list of type definitions for which we are currently generating example xml/json. Used to
   * prevent infinite recursion for circular references.
   */
  private static final ThreadLocal<Stack<String>> TYPE_DEF_STACK = new ThreadLocal<Stack<String>>();

  public Object exec(List list) throws TemplateModelException {
    if (list.size() < 1) {
      throw new TemplateModelException("The generateExampleJson method must have a root element as a parameter.");
    }

    Object object = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(0));
    String namespace;
    String name;
    TypeDefinition type;
    if (object instanceof RootElementDeclaration) {
      RootElementDeclaration rootEl = (RootElementDeclaration) object;
      namespace = rootEl.getNamespace();
      name = rootEl.getName();
      type = rootEl.getTypeDefinition();
    }
    else if (object instanceof TypeDefinition) {
      type = (TypeDefinition) object;
      namespace = "";
      name = type.getName();
    }
    else {
      throw new TemplateModelException("The generateExampleJson method must have a root element as a parameter.");
    }

    try {
      String prefix = namespace == null ? null : ((EnunciateFreemarkerModel) FreemarkerModel.get()).getNamespacesToPrefixes().get(namespace);
      Namespace jdomNS;
      if (org.jdom.Namespace.XML_NAMESPACE.getURI().equals(namespace)) {
        jdomNS = org.jdom.Namespace.XML_NAMESPACE;
      }
      else if (namespace == null || "".equals(namespace)) {
        jdomNS = org.jdom.Namespace.NO_NAMESPACE;
      }
      else {
        jdomNS = Namespace.getNamespace(prefix, namespace);
      }
      org.jdom.Element rootElement = new org.jdom.Element(name, jdomNS);
      generateExampleXml(type, rootElement);
      org.jdom.Document document = new org.jdom.Document(rootElement);

      XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
      StringWriter sw = new StringWriter();
      out.output(document, sw);
      sw.flush();
      return sw.toString();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  protected void generateExampleXml(TypeDefinition type, org.jdom.Element parent) {
    if (TYPE_DEF_STACK.get() == null) {
      TYPE_DEF_STACK.set(new Stack<String>());
    }

    if (TYPE_DEF_STACK.get().contains(type.getQualifiedName())) {
      parent.addContent(new org.jdom.Comment("..."));
    }
    else {
      TYPE_DEF_STACK.get().push(type.getQualifiedName());
      for (Attribute attribute : type.getAttributes()) {
        generateExampleXml(attribute, parent);
      }
      if (type.getValue() != null) {
        generateExampleXml(type.getValue(), parent);
      }
      else {
        for (Element element : type.getElements()) {
          generateExampleXml(element, parent);
        }
      }
      TYPE_DEF_STACK.get().pop();
    }

    XmlType baseType = type.getBaseType();
    if (baseType instanceof XmlClassType) {
      TypeDefinition typeDef = ((XmlClassType) baseType).getTypeDefinition();
      if (typeDef != null) {
        generateExampleXml(typeDef, parent);
      }
    }
  }

  protected void generateExampleXml(Attribute attribute, org.jdom.Element parent) {
    DocumentationExample exampleInfo = attribute.getAnnotation(DocumentationExample.class);
    if (exampleInfo == null || !exampleInfo.exclude()) {
      String namespace = attribute.getNamespace();
      String prefix = namespace == null ? null : ((EnunciateFreemarkerModel) FreemarkerModel.get()).getNamespacesToPrefixes().get(namespace);
      String exampleValue = exampleInfo == null || "##default".equals(exampleInfo.value()) ? "..." : exampleInfo.value();
      Namespace jdomNS;
      if (org.jdom.Namespace.XML_NAMESPACE.getURI().equals(namespace)) {
        jdomNS = org.jdom.Namespace.XML_NAMESPACE;
      }
      else if (namespace == null || "".equals(namespace)) {
        jdomNS = org.jdom.Namespace.NO_NAMESPACE;
      }
      else {
        jdomNS = Namespace.getNamespace(prefix, namespace);
      }
      org.jdom.Attribute attr = new org.jdom.Attribute(attribute.getName(), exampleValue, jdomNS);
      parent.setAttribute(attr);
    }
  }

  protected void generateExampleXml(Value value, org.jdom.Element parent) {
    DocumentationExample exampleInfo = value.getAnnotation(DocumentationExample.class);
    if (exampleInfo == null || !exampleInfo.exclude()) {
      parent.setContent(new org.jdom.Text(exampleInfo == null || "##default".equals(exampleInfo.value()) ? "..." : exampleInfo.value()));
    }
  }

  protected void generateExampleXml(Element element, org.jdom.Element parent) {
    DocumentationExample exampleInfo = element.getAnnotation(DocumentationExample.class);
    if (exampleInfo == null || !exampleInfo.exclude()) {
      if (element.isWrapped()) {
        String namespace = element.getNamespace();
        String prefix = namespace == null ? null : ((EnunciateFreemarkerModel) FreemarkerModel.get()).getNamespacesToPrefixes().get(namespace);
        Namespace jdomNS;
        if (org.jdom.Namespace.XML_NAMESPACE.getURI().equals(namespace)) {
          jdomNS = org.jdom.Namespace.XML_NAMESPACE;
        }
        else if (namespace == null || "".equals(namespace)) {
          jdomNS = org.jdom.Namespace.NO_NAMESPACE;
        }
        else {
          jdomNS = Namespace.getNamespace(prefix, namespace);
        }
        org.jdom.Element el = new org.jdom.Element(element.getWrapperName(), jdomNS);
        parent.addContent(el);
        parent = el;
      }

      for (Element choice : element.getChoices()) {
        QName ref = choice.getRef();
        int iterations = "1".equals(choice.getMaxOccurs()) ? 1 : 2;
        for (int i = 0; i < iterations; i++) {
          if (ref == null) {
            String namespace = choice.getNamespace();
            String prefix = namespace == null ? null : ((EnunciateFreemarkerModel) FreemarkerModel.get()).getNamespacesToPrefixes().get(namespace);
            Namespace jdomNS;
            if (org.jdom.Namespace.XML_NAMESPACE.getURI().equals(namespace)) {
              jdomNS = org.jdom.Namespace.XML_NAMESPACE;
            }
            else if (namespace == null || "".equals(namespace)) {
              jdomNS = org.jdom.Namespace.NO_NAMESPACE;
            }
            else {
              jdomNS = Namespace.getNamespace(prefix, namespace);
            }
            org.jdom.Element el = new org.jdom.Element(choice.getName(), jdomNS);
            String exampleValue = exampleInfo == null || "##default".equals(exampleInfo.value()) ? "..." : exampleInfo.value();
            XmlType xmlType = choice.getBaseType();
            if (i == 0) {
              generateExampleXml(xmlType, el, exampleValue);
            }
            else {
              if (xmlType instanceof XmlClassType) {
                for (Attribute attribute : ((XmlClassType)xmlType).getTypeDefinition().getAttributes()) {
                  generateExampleXml(attribute, parent);
                }
              }
              el.addContent(new Comment("..."));
            }

            parent.addContent(el);
          }
          else {
            String namespace = ref.getNamespaceURI();
            String name = ref.getLocalPart();
            String prefix = namespace == null ? null : ((EnunciateFreemarkerModel) FreemarkerModel.get()).getNamespacesToPrefixes().get(namespace);
            Namespace jdomNS;
            if (org.jdom.Namespace.XML_NAMESPACE.getURI().equals(namespace)) {
              jdomNS = org.jdom.Namespace.XML_NAMESPACE;
            }
            else if (namespace == null || "".equals(namespace)) {
              jdomNS = org.jdom.Namespace.NO_NAMESPACE;
            }
            else {
              jdomNS = Namespace.getNamespace(prefix, namespace);
            }
            org.jdom.Element el = new org.jdom.Element(name, jdomNS);
            el.addContent(new org.jdom.Text("..."));
            parent.addContent(el);
          }
        }
        if (iterations > 1) {
          parent.addContent(new Comment("...more \"" + (ref == null ? choice.getName() : ref.getLocalPart()) + "\" elements..."));
        }
      }
    }
  }

  public void generateExampleXml(XmlType type, org.jdom.Element parent, String example) {
    if (type instanceof XmlClassType) {
      generateExampleXml(((XmlClassType)type).getTypeDefinition(), parent);
    }
    else {
      type.generateExampleXml(parent, example);
    }
  }

}