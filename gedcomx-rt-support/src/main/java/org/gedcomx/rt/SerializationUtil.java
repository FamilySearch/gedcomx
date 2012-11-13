/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
package org.gedcomx.rt;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.node.ObjectNode;
import org.gedcomx.rt.json.GedcomJacksonModule;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author Ryan Heaton
 */
public class SerializationUtil {

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughXml(Object reference, SerializationProcessListener... listeners) throws JAXBException, UnsupportedEncodingException {
    return (C) processThroughXml(reference, reference.getClass(), listeners);
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughXml(Object reference, Class<? extends C> instanceClass, SerializationProcessListener... listeners) throws JAXBException, UnsupportedEncodingException {
    return processThroughXml(reference, instanceClass, JAXBContext.newInstance(instanceClass), listeners);
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughXml(Object reference, Class<? extends C> instanceClass, JAXBContext context, SerializationProcessListener... listeners) throws JAXBException, UnsupportedEncodingException {
    byte[] out = toXmlStream(reference, instanceClass, context, listeners);
    JAXBElement<? extends C> element = context.createUnmarshaller().unmarshal(new StreamSource(new ByteArrayInputStream(out)), instanceClass);
    reference = element.getValue();
    return (C) reference;
  }

  @SuppressWarnings ( {"unchecked"} )
  public static byte[] toXmlStream(Object reference, SerializationProcessListener... listeners) throws JAXBException, UnsupportedEncodingException {
    return toXmlStream(reference, reference.getClass(), listeners);
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> byte[] toXmlStream(Object reference, Class<? extends C> instanceClass, SerializationProcessListener... listeners) throws JAXBException, UnsupportedEncodingException {
    return toXmlStream(reference, instanceClass, JAXBContext.newInstance(instanceClass), listeners);
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> byte[] toXmlStream(Object reference, Class<? extends C> instanceClass, JAXBContext context, SerializationProcessListener... listeners) throws JAXBException, UnsupportedEncodingException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
    Object el = isRootElement(instanceClass) ? reference : null;
    if (el == null) {
      String ns = "";
      if (instanceClass.getPackage() != null && instanceClass.getPackage().getAnnotation(XmlSchema.class) != null) {
        ns = instanceClass.getPackage().getAnnotation(XmlSchema.class).namespace();
      }
      el = new JAXBElement(new QName(ns, instanceClass.getSimpleName()), instanceClass, reference);
    }
    marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new GedcomNamespaceManager(instanceClass));
    marshaller.marshal(el, out);
    if ("true".equals(System.getProperty("show.output"))) {
      System.out.println(new String(out.toByteArray(), "utf-8"));
    }
    
    if (listeners != null && listeners.length > 0) {
      String xml = new String(out.toByteArray(), "utf-8");
      for (SerializationProcessListener listener : listeners) {
        listener.xmlProcessed(reference, instanceClass, context, xml);
      }
    }
    
    return out.toByteArray();
  }

  private static <C> boolean isRootElement(Class<? extends C> instanceClass) {
    return instanceClass.isAnnotationPresent(XmlRootElement.class) || JAXBElement.class.isAssignableFrom(instanceClass);
  }

  public static Document toXmlDom(Object reference) throws JAXBException, UnsupportedEncodingException {
    return toXmlDom(reference, reference.getClass());
  }

  public static Document toXmlDom(Object reference, Class<?> instanceClass) throws JAXBException, UnsupportedEncodingException {
    byte[] out = toXmlStream(reference, instanceClass);
    try {
      DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
      builderFactory.setNamespaceAware(true);
      DocumentBuilder builder = builderFactory.newDocumentBuilder();
      return builder.parse(new ByteArrayInputStream(out));
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static Document toXmlDom(Object reference, Class<?> instanceClass, JAXBContext context) throws JAXBException, UnsupportedEncodingException {
    byte[] out = toXmlStream(reference, instanceClass, context);
    try {
      return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(out));
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughJson(Object reference, SerializationProcessListener... listeners) throws IOException {
    return (C) processThroughJson(reference, reference.getClass(), listeners);
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughJson(Object reference, Class<? extends C> instanceClass, SerializationProcessListener... listeners) throws IOException {
    return processThroughJson(reference, instanceClass, GedcomJacksonModule.createObjectMapper(instanceClass), listeners);
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughJson(Object reference, Class<? extends C> instanceClass, ObjectMapper mapper, SerializationProcessListener... listeners) throws IOException {
    byte[] buffer = toJsonStream(reference, instanceClass, mapper, listeners);
    reference = mapper.readValue(new ByteArrayInputStream(buffer), instanceClass);
    return (C) reference;
  }

  public static <C> byte[] toJsonStream(Object reference, SerializationProcessListener... listeners) throws IOException {
    return toJsonStream(reference, reference.getClass(), listeners);
  }

  public static <C> byte[] toJsonStream(Object reference, Class<? extends C> instanceClass, SerializationProcessListener... listeners) throws IOException {
    return toJsonStream(reference, instanceClass, GedcomJacksonModule.createObjectMapper(instanceClass), listeners);
  }

  protected static <C> byte[] toJsonStream(Object reference, Class<? extends C> instanceClass, ObjectMapper mapper, SerializationProcessListener... listeners) throws IOException {
    GedcomNamespaceManager.registerKnownJsonType(instanceClass);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    mapper.getSerializationConfig().enable(SerializationConfig.Feature.INDENT_OUTPUT);
    mapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    mapper.writeValue(out, reference);
    if ("true".equals(System.getProperty("show.output"))) {
      System.out.println(new String(out.toByteArray(), "utf-8"));
    }

    if (listeners != null && listeners.length > 0) {
      String json = new String(out.toByteArray(), "utf-8");
      for (SerializationProcessListener listener : listeners) {
        listener.jsonProcessed(reference, instanceClass, mapper, json);
      }
    }

    return out.toByteArray();
  }

  public static ObjectNode toJsonNode(Object reference) throws IOException {
    return toJsonNode(reference, reference.getClass());
  }

  public static ObjectNode toJsonNode(Object reference, Class<?> instanceClass) throws IOException {
    return toJsonNode(reference, instanceClass, GedcomJacksonModule.createObjectMapper(instanceClass));
  }

  public static ObjectNode toJsonNode(Object reference, Class<?> instanceClass, ObjectMapper mapper) throws IOException {
    byte[] out = toJsonStream(reference, instanceClass, mapper);
    return mapper.readValue(new ByteArrayInputStream(out), ObjectNode.class);
  }

}
