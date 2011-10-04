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
package org.gedcomx.common;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.LiteralDataType;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.net.URI;

/**
 * A normalized value.
 *
 * A normalized value can be an <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a> or it can be
 * a reference to a resource that defines its value in a structured form, or it can be both.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use = JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "NormalizedValue" )
public final class NormalizedValue {

  private URI datatype;
  private URI resource;
  private String text;

  /**
   * The datatype of the the normalized value. For more information, start with the explanation of an
   * <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a> in the RDF primer.
   *
   * @return The datatype of the the normalized value.
   */
  @XmlAttribute( name="datatype", namespace = CommonNamespaces.RDF_NAMESPACE )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getDatatype() {
    return datatype;
  }

  /**
   * The datatype of the the normalized value. For more information, start with the explanation of an
   * <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a> in the RDF primer.
   *
   * @param datatype The datatype of the the normalized value.
   */
  public void setDatatype(URI datatype) {
    this.datatype = datatype;
  }

  /**
   * Get the known data type from a list of well-known data types.
   *
   * @return The known data type.
   */
  @XmlTransient
  @JsonIgnore
  public LiteralDataType getKnownDataType() {
    return LiteralDataType.fromQNameURI(getDatatype());
  }

  /**
   * Set the known data type from a list of well-known data types.
   *
   * @param dataType The known data type.
   */
  @JsonIgnore
  public void setKnownDataType(LiteralDataType dataType) {
    setDatatype(XmlQNameEnumUtil.toURI(dataType));
  }

  /**
   * A reference to the resource that defines the normalized value in a structured form.
   *
   * @return A reference to the resource that defines the normalized value in a structured form.
   */
  @XmlAttribute( name="resource", namespace = CommonNamespaces.RDF_NAMESPACE )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getResource() {
    return resource;
  }

  /**
   * A reference to the resource that defines the normalized value in a structured form.
   *
   * @param resource A reference to the resource that defines the normalized value in a structured form.
   */
  public void setResource(URI resource) {
    this.resource = resource;
  }

  /**
   * Get the value from an enumeration of known values.
   *
   * @param clazz The enumeration.
   * @return The value.
   */
  public <E extends Enum<E>> E getKnownValue(Class<E> clazz) {
    return XmlQNameEnumUtil.fromURI(getResource(), clazz);
  }

  /**
   * Set the value from an enumeration of known values.
   *
   * @param value The known value.
   */
  @XmlTransient
  @JsonIgnore
  public void setKnownValue(Enum value) {
    this.resource = XmlQNameEnumUtil.toURI(value);
  }

  /**
   * The text of the normalized value.
   *
   * @return The text of the normalized value.
   */
  @XmlValue
  public String getText() {
    return text;
  }

  /**
   * The text of the normalized value.
   *
   * @param text The text of the normalized value.
   */
  public void setText(String text) {
    this.text = text;
  }

}
