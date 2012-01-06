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
package org.gedcomx.types;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.rt.CommonModels;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import org.gedcomx.common.URI;

/**
 * A RDF reference to an age part type.
 *
 * @author Ryan Heaton
 */
@XmlType ( namespace = CommonModels.RDF_NAMESPACE, name = "type" )
@JsonSerialize (using = TypeReference.JsonSerializer.class)
@JsonDeserialize (using = TypeReference.JsonDeserializer.class)
public final class TypeReference<T extends Enum> {

  private URI type;

  public TypeReference() {
  }

  public TypeReference(URI type) {
    this.type = type;
  }

  public TypeReference(T type) {
    setKnownType(type);
  }

  /**
   * The identifier of the type being referenced.
   *
   * @return The identifier of the type being referenced.
   */
  @XmlAttribute ( namespace= CommonModels.RDF_NAMESPACE, name = "resource" )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The identifier of the type being referenced.
   *
   * @param type The identifier of the type being referenced.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * Set the age unit from a known enumeration of age part types.
   *
   * @param type The age part type.
   */
  @XmlTransient
  @JsonIgnore
  public void setKnownType(T type) {
    setType(URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(type)));
  }

  public static class JsonSerializer extends org.codehaus.jackson.map.JsonSerializer<TypeReference> {
    @Override
    public void serialize(TypeReference value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
      if (value == null || value.getType() == null) {
        jgen.writeNull();
      }
      else {
        jgen.writeString(value.getType().toString());
      }
    }
  }

  public static class JsonDeserializer extends org.codehaus.jackson.map.JsonDeserializer<TypeReference> {

    @Override
    public TypeReference deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      String text = jp.getText();
      if (text == null) {
        return null;
      }
      else {
        return new TypeReference(URI.create(text));
      }
    }
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (type == null) ? "" : type.toString();
  }
}
