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
package org.gedcomx.rt;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.namespace.QName;
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
  public static <C> C processThroughXml(Object reference) throws JAXBException, UnsupportedEncodingException {
    return (C) processThroughXml(reference, reference.getClass());
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughXml(Object reference, Class<? extends C> instanceClass) throws JAXBException, UnsupportedEncodingException {
    JAXBContext context = JAXBContext.newInstance(instanceClass);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
    Object el = instanceClass.isAnnotationPresent(XmlRootElement.class) ? reference : null;
    if (el == null) {
      String ns = "";
      if (instanceClass.getPackage() != null && instanceClass.getPackage().getAnnotation(XmlSchema.class) != null) {
        ns = instanceClass.getPackage().getAnnotation(XmlSchema.class).namespace();
      }
      el = new JAXBElement(new QName(ns, instanceClass.getSimpleName()), instanceClass, reference);
    }
    marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new GedcomNamespacePrefixMapper(instanceClass));
    marshaller.marshal(el, out);
    if ("true".equals(System.getProperty("show.output"))) {
      System.out.println(new String(out.toByteArray(),"utf-8"));
    }
    JAXBElement<? extends C> element = context.createUnmarshaller().unmarshal(new StreamSource(new ByteArrayInputStream(out.toByteArray())), instanceClass);
    reference = element.getValue();
    return (C) reference;
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughJson(Object reference) throws IOException {
    return (C) processThroughJson(reference, reference.getClass());
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughJson(Object reference, Class<? extends C> instanceClass) throws IOException {
    ObjectMapper mapper = new JacksonJaxbJsonProvider().locateMapper(instanceClass, null);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    mapper.getSerializationConfig().enable(SerializationConfig.Feature.INDENT_OUTPUT);
    mapper.writeValue(out, reference);
    if ("true".equals(System.getProperty("show.output"))) {
      System.out.println(new String(out.toByteArray(), "utf-8"));
    }
    reference = mapper.readValue(new ByteArrayInputStream(out.toByteArray()), instanceClass);
    return (C) reference;
  }

}
