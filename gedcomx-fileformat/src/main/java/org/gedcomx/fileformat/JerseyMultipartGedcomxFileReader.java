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
import com.sun.jersey.core.header.InBoundHeaders;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.MultiPartConfig;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.gedcomx.rt.GedcomJsonProvider;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.MessageBodyReader;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.beans.Introspector;
import java.io.*;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * Implementation of {@link org.gedcomx.fileformat.GedcomxFileWriter} that uses the jersey-multipart library to do the dirty work.
 *
 * @author Ryan Heaton
 */
public class JerseyMultipartGedcomxFileReader implements GedcomxFileReader {

  public static final int HEADER_BUFFFER_SIZE = 8 * 1024; //The max size of the header section of the file supported by this reader.
  public static final int BODY_PEEK_BUFFER_SIZE = 4 * 1024; //The number of bytes we can "peek" into head body part in order to discover the type.

  private final Map<QName, Class<?>> knownClasses = new HashMap<QName, Class<?>>();
  private final Client client;
  private final InBoundHeaders headers = new InBoundHeaders();
  private final Collection<GedcomxFilePart> parts;
  private final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
  private final JsonFactory jsonFactory = new JsonFactory();

  /**
   * Construct a writer with default configuration.
   *
   * @param in The file stream.
   */
  public JerseyMultipartGedcomxFileReader(InputStream in) throws IOException {
    this(in, Client.create());
  }

  /**
   * Construct a writer that will support the specified set of classes as body parts.
   * Sometimes these classes need to be specified because, for example, JAXB can't "see"
   * them via static code analysis.
   *
   * @param in The file stream.
   * @param contextClasses The classes with which to initialize the context.
   */
  public JerseyMultipartGedcomxFileReader(InputStream in, Class<?>... contextClasses) throws IOException {
    this(in, null, contextClasses);
  }

  /**
   * Construct a writer that will support the specified set of classes as body parts.
   * Sometimes these classes need to be specified because, for example, JAXB can't "see"
   * them via static code analysis.
   *
   * @param in The file stream.
   * @param config custom configuration of the multipart reader.
   * @param contextClasses The classes with which to initialize the context.
   */
  public JerseyMultipartGedcomxFileReader(InputStream in, MultiPartConfig config, Class<?>... contextClasses) throws IOException {
    this(in, Client.create(createCustomClientConfig(config, contextClasses)));

    for (Class<?> contextClass : contextClasses) {
      XmlRootElement rootElementInfo = contextClass.getAnnotation(XmlRootElement.class);
      if (rootElementInfo != null) {
        String name;
        String ns = "";
        if ("##default".equals(rootElementInfo.namespace())) {
          Package pkg = contextClass.getPackage();
          if (pkg != null && pkg.isAnnotationPresent(XmlSchema.class)) {
            ns = pkg.getAnnotation(XmlSchema.class).namespace();
          }
        }
        else {
          ns = rootElementInfo.namespace();
        }

        if ("##default".equals(rootElementInfo.name())) {
          name = Introspector.decapitalize(contextClass.getSimpleName());
        }
        else {
          name = rootElementInfo.name();
        }

        this.knownClasses.put(new QName(ns, name), contextClass);
      }
    }
  }

  /**
   * Create a writer with a custom client.
   *
   * @param in The file stream.
   * @param client The client.
   */
  public JerseyMultipartGedcomxFileReader(InputStream in, Client client) throws IOException {
    this.client = client;
    if (!in.markSupported()) {
      in = new BufferedInputStream(in, HEADER_BUFFFER_SIZE);
    }
    in.mark(HEADER_BUFFFER_SIZE);

    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
    String line = reader.readLine();
    while (line == null || line.isEmpty()) { //trim off any preceding whitespace from the file.
      line = reader.readLine();
    }

    String currentName = null;
    StringBuilder currentValue = new StringBuilder();
    while (line != null && !line.isEmpty()) {
      if (line.charAt(0) == ' ' || line.charAt(0) == '\t') {
        //continuation of previous header value.
        currentValue.append(trimLeft(line));
      }
      else { //parse this as a header.
        //first push the current value on the stack, if it's there.
        if (currentName != null) {
          this.headers.add(currentName, currentValue.toString());
          currentName = null;
          currentValue = new StringBuilder();
        }

        int firstColon = line.indexOf(':');
        if (firstColon > 0) {
          currentName = line.substring(0, firstColon).trim();
          currentValue.append(trimLeft(line.substring(firstColon + 1)));
        }
        // else do nothing in an attempt to create a lenient reader.
      }

      line = reader.readLine();
    }

    if (currentName != null) {
      this.headers.add(currentName, currentValue.toString());
    }

    String contentType = this.headers.getFirst("Content-Type");
    if (contentType == null) {
      throw new IOException("Invalid file format: no Content-Type header.");
    }
    MediaType mediaType = MediaType.valueOf(contentType);
    if (!mediaType.isCompatible(GedcomxFileWriter.MEDIA_TYPE)) {
      throw new IOException("Invalid file format: unsupported content type: " + mediaType.toString());
    }

    in.reset(); //if there is more than 8K of headers, this will throw an IOException.
    MessageBodyReader<MultiPart> bodyReader = this.client.getProviders().getMessageBodyReader(MultiPart.class, MultiPart.class, new Annotation[0], mediaType);
    MultiPart mp = bodyReader.readFrom(MultiPart.class, MultiPart.class, null, mediaType, this.headers, in);
    List<GedcomxFilePart> parts = new ArrayList<GedcomxFilePart>();
    for (BodyPart bodyPart : mp.getBodyParts()) {
      GedcomxFilePartAdapter part = new GedcomxFilePartAdapter(bodyPart);
      if (part.getCid() == null) {
        throw new IOException("Invalid body part at index '" + parts.size() + "': no Content-ID specified.");
      }
      parts.add(part);
    }

    this.parts = parts;
  }

  private String trimLeft(String line) {
    while (!line.isEmpty() && (line.charAt(0) == ' ' || line.charAt(0) == '\t')) { //trim off the leading whitespace.
      line = line.substring(1);
    }
    return line;
  }

  static ClientConfig createCustomClientConfig(MultiPartConfig config, Class<?>... contextClasses) {
    DefaultClientConfig clientConfig = new DefaultClientConfig();
    try {
      Set<Class<?>> jaxbClasses = new HashSet<Class<?>>();
      for (Class<?> contextClass : contextClasses) {
        if (contextClass.isAnnotationPresent(XmlRootElement.class)) {
          jaxbClasses.add(contextClass);
        }
      }
      clientConfig.getSingletons().add(new SpecifiedClassesJAXBContextResolver(jaxbClasses));
      clientConfig.getSingletons().add(new GedcomJsonProvider(contextClasses));
    }
    catch (JAXBException e) {
      throw new IllegalArgumentException(e);
    }

    if (config != null) {
      clientConfig.getSingletons().add(config);
    }

    return clientConfig;
  }

  private static boolean isXml(MediaType mediaType) {
    return mediaType.getType().startsWith("application") && (mediaType.getSubtype().toLowerCase().equals("xml") || mediaType.getSubtype().toLowerCase().endsWith("+xml"));
  }

  private static boolean isJson(MediaType mediaType) {
    return mediaType.getType().startsWith("application") && (mediaType.getSubtype().toLowerCase().equals("json") || mediaType.getSubtype().toLowerCase().endsWith("+json"));
  }

  public String getHeader(String name) {
    return this.headers.getFirst(name);
  }

  public Map<String, List<String>> getHeaders() {
    return this.headers;
  }

  public Collection<GedcomxFilePart> getParts() {
    return this.parts;
  }

  private class GedcomxFilePartAdapter implements GedcomxFilePart {

    private final BodyPart bp;
    private final String cid;

    private GedcomxFilePartAdapter(BodyPart bp) {
      this.bp = bp;
      String cid = this.bp.getHeaders().getFirst("Content-ID");
      if (cid.isEmpty()) {
        cid = null;
      }

      if (cid != null && cid.charAt(0) == '<') {
        cid = cid.substring(1);

        if (cid.isEmpty()) {
          cid = null;
        }

        if (cid != null && cid.charAt(cid.length() - 1) == '>') {
          cid = cid.substring(0, cid.length() - 1);
        }
      }

      this.cid = cid;
    }

    public String getCid() {
      return this.cid;
    }

    public String getMediaType() {
      return this.bp.getMediaType().toString();
    }

    public Object getContent() throws IOException {
      MediaType mediaType = bp.getMediaType();
      Object entity = bp.getEntity();

      if (entity instanceof BodyPartEntity) {
        final BodyPartEntity bpe = (BodyPartEntity) entity;
        entity = null;
        InputStream in = new BodyPartEntityStream(bpe);

        List<String> encodings = bp.getHeaders().get("Content-Encoding");
        if (encodings != null) {
          for (String encoding : encodings) {
            if ("gzip".equalsIgnoreCase(encoding)) {
              in = new GZIPInputStream(in);
              break;
            }
          }
        }

        //todo: support for Content-Transfer-Encoding header.

        if (!knownClasses.isEmpty() && (isXml(mediaType) || isJson(mediaType))) {
          Class<?> associatedClass = null;
          //this is xml or json; let's see if we recognize an associated class...
          in = new BufferedInputStream(in, BODY_PEEK_BUFFER_SIZE);
          in.mark(BODY_PEEK_BUFFER_SIZE);

          try {
            if (isXml(mediaType)) {
              XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(in);
              while (reader.hasNext()) {
                if (XMLStreamConstants.START_ELEMENT == reader.next()) {
                  break;
                }
              }

              associatedClass = knownClasses.get(reader.getName());
            }
            else {
              JsonParser parser = jsonFactory.createJsonParser(in);
              if (parser.nextToken() == JsonToken.START_OBJECT) {
                JsonToken jsonToken = parser.nextToken();
                while (jsonToken == JsonToken.FIELD_NAME) {
                  String fieldName = parser.getCurrentName();
                  JsonToken valueToken = parser.nextToken();
                  if ("@type".equalsIgnoreCase(fieldName)) {
                    //we've found the type attribute.
                    if (valueToken == JsonToken.VALUE_STRING) {
                      String qNameValue = parser.getText();
                      try {
                        associatedClass = knownClasses.get(QName.valueOf(qNameValue));
                        break;
                      }
                      catch (IllegalArgumentException e) {
                        throw new IOException("Invalid QName string for '@type' attribute: " + qNameValue);
                      }
                    }
                    else {
                      throw new IOException("Invalid token for '@type' attribute (expected qname string): " + valueToken);
                    }
                  }

                  jsonToken = parser.nextToken(); //advance to the next field
                }
              }
            }
          }
          catch (IOException ioe) {
            throw ioe;
          }
          catch (Exception e) {
            //fall through...
            associatedClass = null;
          }
          finally {
            //reset the inputstream.
            in.reset();
          }

          if (associatedClass != null) {
            //we found an associated class.
            MessageBodyReader reader = client.getProviders().getMessageBodyReader(associatedClass, associatedClass, new Annotation[0], mediaType);
            if (reader != null) {
              entity = reader.readFrom(associatedClass, associatedClass, new Annotation[0], mediaType, this.bp.getHeaders(), in);
              bpe.cleanup();
              in.close();
            }
          }
        }

        if (entity == null) {
          //we didn't find an entity, so we'll assign the input stream as the entity.
          entity = in;
        }

        bp.setEntity(entity);
      }

      return entity;
    }
  }

  /**
   * A stream that cleans up its body part entity when closed.
   */
  private static class BodyPartEntityStream extends FilterInputStream {

    private final BodyPartEntity entity;

    private BodyPartEntityStream(BodyPartEntity entity) {
      super(entity.getInputStream());
      this.entity = entity;
    }

    @Override
    public void close() throws IOException {
      super.close();
      this.entity.cleanup();
    }
  }

}
