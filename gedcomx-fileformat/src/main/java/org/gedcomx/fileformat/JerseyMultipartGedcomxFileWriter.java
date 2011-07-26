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
package org.gedcomx.fileformat;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.header.OutBoundHeaders;
import com.sun.jersey.core.util.UnmodifiableMultivaluedMap;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.Boundary;
import com.sun.jersey.multipart.MultiPart;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Implementation of {@link GedcomxFileWriter} that uses the jersey-multipart library to do the dirty work.
 *
 * @author Ryan Heaton
 */
public class JerseyMultipartGedcomxFileWriter implements GedcomxFileWriter {

  private final MultiPart root;
  private final Client client;
  private final OutBoundHeaders headers = new OutBoundHeaders();

  /**
   * Construct a writer with default configuration.
   */
  public JerseyMultipartGedcomxFileWriter() {
    this(Client.create());
  }

  /**
   * Construct a writer that will support the specified set of classes as body parts.
   * Sometimes these classes need to be specified because, for example, JAXB can't "see"
   * them via static code analysis.
   *
   * @param contextClasses The classes with which to initialize the context.
   */
  public JerseyMultipartGedcomxFileWriter(Class<?>... contextClasses) {
    this(Client.create(createCustomClientConfig(contextClasses)));
  }

  /**
   * Create a writer with a custom client.
   *
   * @param client The client.
   */
  public JerseyMultipartGedcomxFileWriter(Client client) {
    this.root = new MultiPart(MEDIA_TYPE);
    this.client = client;
  }

  private static ClientConfig createCustomClientConfig(Class<?>... contextClasses) {
    DefaultClientConfig clientConfig = new DefaultClientConfig();
    try {
      Set<Class<?>> jaxbClasses = new HashSet<Class<?>>();
      for (Class<?> contextClass : contextClasses) {
        if (contextClass.isAnnotationPresent(XmlRootElement.class)) {
          jaxbClasses.add(contextClass);
        }
      }
      clientConfig.getSingletons().add(new SpecifiedClassesJAXBContextResolver(jaxbClasses));
      clientConfig.getSingletons().add(new ObjectMapperContextResolver(contextClasses));
    }
    catch (JAXBException e) {
      throw new IllegalArgumentException(e);
    }
    return clientConfig;
  }

  /**
   * {@inheritDoc}
   */
  public String addPart(String mediaType, Object content) {
    BodyPart bp = new BodyPart(content, MediaType.valueOf(mediaType));
    String contentId = UUID.randomUUID().toString();
    bp.getHeaders().putSingle("Content-ID", "<" + contentId + ">");
    this.root.bodyPart(bp);
    return contentId;
  }

  /**
   * Builder-pattern method for adding a part.
   *
   * @param bp The body part.
   * @return this.
   * @throws IllegalArgumentException If the body part doesn't have a Content-Id header, or hasn't defined a media type, or hasn't defined an entity.
   */
  public JerseyMultipartGedcomxFileWriter part(BodyPart bp) {
    if (!bp.getHeaders().containsKey("Content-ID")) {
      throw new IllegalArgumentException("A body part must have a Content-ID header.");
    }

    if (bp.getMediaType() == null) {
      throw new IllegalArgumentException("A body part must have a content type defined.");
    }

    if (bp.getEntity() == null) {
      throw new IllegalArgumentException("A body part must have an entity defined.");
    }

    this.root.bodyPart(bp);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  public void setHeader(String name, String value) {
    if (!name.toLowerCase().startsWith("content-")) {
      throw new IllegalArgumentException("A header for a part must start with \"Content-");
    }

    this.headers.putSingle(name, value);
  }

  /**
   * Builder-pattern method for setting a header.
   *
   * @param name The name of the header.
   * @param value The value for the header.
   * @return this.
   */
  public JerseyMultipartGedcomxFileWriter header(String name, String value) {
    this.headers.putSingle(name, value);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  public void writeTo(OutputStream out) throws IOException {
    //first write the file headers...
    OutBoundHeaders headers = new OutBoundHeaders(this.headers);
    if (!headers.containsKey("MIME-Version")) {
      headers.putSingle("MIME-Version", "1.0");
    }

    MediaType mediaType = root.getMediaType();
    final MediaType boundaryMediaType = Boundary.addBoundary(mediaType);
    if (boundaryMediaType != mediaType) {
      headers.putSingle(HttpHeaders.CONTENT_TYPE, boundaryMediaType);
    }

    // iterate for the nested body parts
    final Writer headerWriter = new OutputStreamWriter(out, "utf-8");
    for (Map.Entry<String, List<Object>> entry : headers.entrySet()) {
      // Write this header and its value(s)
      headerWriter.write(entry.getKey());
      headerWriter.write(':');
      boolean first = true;
      for (Object value : entry.getValue()) {
        if (first) {
          headerWriter.write(' ');
          first = false;
        }
        else {
          headerWriter.write(',');
        }
        headerWriter.write(String.valueOf(value));
      }

      headerWriter.write("\r\n");
    }

    // Mark the end of the headers for this body part
    headerWriter.flush();

    //we could write out a preamble here, perhaps conforming to the suggestion in rfc2046, but I
    //couldn't think of anything intelligent to say, so we'll leave it out.
    //See http://tools.ietf.org/html/rfc2046#section-5.1.1
    //here's how you could add it though:
    // headerWriter.write("\r\n");
    // headerWriter.write("Here is some text that you can put as a preamble in case the file ever gets opened by a text editor. It should be ignored");
    // headerWriter.flush();

    MessageBodyWriter<MultiPart> writer = this.client.getProviders().getMessageBodyWriter(MultiPart.class, MultiPart.class, new Annotation[0], mediaType);
    writer.writeTo(root, MultiPart.class, MultiPart.class, null, boundaryMediaType, new UnmodifiableMultivaluedMap<String, Object>(headers), out);
  }
}
