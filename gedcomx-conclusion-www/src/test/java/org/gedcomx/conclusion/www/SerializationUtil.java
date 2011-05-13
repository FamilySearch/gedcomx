package org.gedcomx.conclusion.www;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.gedcomx.attribution.AttributionConstants;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
  public static <C> C processThroughXml(C reference) throws JAXBException, UnsupportedEncodingException {
    return (C) processThroughXml(reference, reference.getClass());
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughXml(C reference, Class<? extends C> instanceClass) throws JAXBException, UnsupportedEncodingException {
    JAXBContext context = JAXBContext.newInstance(instanceClass);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
    marshaller.marshal(new JAXBElement(new QName(AttributionConstants.GEDCOMX_ATTRIBUTION_NAMESPACE, instanceClass.getSimpleName()), instanceClass, reference), out);
    if ("true".equals(System.getProperty("show.output"))) {
      System.out.println(new String(out.toByteArray(),"utf-8"));
    }
    JAXBElement<? extends C> element = context.createUnmarshaller().unmarshal(new StreamSource(new ByteArrayInputStream(out.toByteArray())), instanceClass);
    reference = element.getValue();
    return reference;
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughJson(C reference) throws IOException {
    return (C) processThroughJson(reference, reference.getClass());
  }

  @SuppressWarnings ( {"unchecked"} )
  public static <C> C processThroughJson(C reference, Class<? extends C> instanceClass) throws IOException {
    ObjectMapper mapper = new JacksonJaxbJsonProvider().locateMapper(instanceClass, null);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    mapper.getSerializationConfig().enable(SerializationConfig.Feature.INDENT_OUTPUT);
    mapper.writeValue(out, reference);
    if ("true".equals(System.getProperty("show.output"))) {
      System.out.println(new String(out.toByteArray(), "utf-8"));
    }
    reference = mapper.readValue(new ByteArrayInputStream(out.toByteArray()), instanceClass);
    return reference;
  }

}
