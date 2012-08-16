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
package org.gedcomx.common;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.rt.json.JsonSimpleValue;
import org.gedcomx.types.ResourceFragmentParameter;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;

/**
 * A generic reference to a resource.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "ResourceReference" )
@XmlSeeAlso(ResourceFragmentParameter.class)
@JsonSerialize (using = ResourceReference.JsonSerializer.class)
@JsonDeserialize (using = ResourceReference.JsonDeserializer.class)
@JsonSimpleValue ( example = "http://path/to/resource" )
public final class ResourceReference {

  private URI resource;

  public ResourceReference() {
  }

  public ResourceReference(URI resource) {
    this.resource = resource;
  }

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @link http://www.w3.org/TR/webarch/#identification
   * @return The URI to the resource.
   */
  @XmlAttribute
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getResource() {
    return resource;
  }

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @link http://www.w3.org/TR/webarch/#identification
   * @param resource The URI to the resource.
   */
  public void setResource(URI resource) {
    this.resource = resource;
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (resource == null) ? "" : resource.toString();
  }

  public static class JsonSerializer extends org.codehaus.jackson.map.JsonSerializer<ResourceReference> {
    @Override
    public void serialize(ResourceReference value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
      if (value == null || value.getResource() == null) {
        jgen.writeNull();
      }
      else {
        jgen.writeString(value.getResource().toString());
      }
    }
  }

  public static class JsonDeserializer extends org.codehaus.jackson.map.JsonDeserializer<ResourceReference> {

    @Override
    public ResourceReference deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      String text = jp.getText();
      if (text == null) {
        return null;
      }
      else {
        return new ResourceReference(URI.create(text));
      }
    }
  }
}
