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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.common.URI;
import org.gedcomx.rt.CommonModels;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;

/**
 * A value that has been formalized via normalization, standardization, or both.
 *
 * A <i>normalized</i> value is a value whose text has been formatted for the purpose of easier processing (perhaps for display
 * purposes). Normalization <i>might</i> be based on a known standard.
 *
 * A <i>standardized</i> value is a value that has been resolved to a discrete, machine-identifiable value based on a specific standard.
 * A value that has been standardized will either refer to a specific item of a constrained vocabulary (via resource references)
 * OR constrain the value to a standard using the datatype, creating an
 * <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a>.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "FormalValue" )
@SuppressWarnings("gedcomx:no_id")
public class FormalValue {

  private URI datatype;
  private URI resource;
  private String text;

  /**
   * The datatype of the the normalized value. This is used to identify the mapping between the normalized value
   * and the standard value. For more information, start with the explanation of an
   * <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a> in the RDF primer.
   *
   * @return The datatype of the the normalized value.
   */
  @XmlAttribute( name="datatype", namespace = CommonModels.RDF_NAMESPACE )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getDatatype() {
    return datatype;
  }

  /**
   * The datatype of the the normalized value. This is used to identify the mapping between the normalized value
   * and the standard value. For more information, start with the explanation of an
   * <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a> in the RDF primer.
   *
   * @param datatype The datatype of the the normalized value.
   */
  public void setDatatype(URI datatype) {
    this.datatype = datatype;
  }

  /**
   * A reference to the resource that defines the normalized value in a structured form.
   *
   * @return A reference to the resource that defines the normalized value in a structured form.
   */
  @XmlAttribute( name="resource", namespace = CommonModels.RDF_NAMESPACE )
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
    return getResource() != null ? XmlQNameEnumUtil.fromURIValue(getResource().toString(), clazz) : null;
  }

  /**
   * Set the value from an enumeration of known values.
   *
   * @param value The known value.
   */
  @XmlTransient
  @JsonIgnore
  public void setKnownValue(Enum value) {
    this.resource = URI.create(XmlQNameEnumUtil.toURIValue(value));
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

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (text == null) ? "" : text;
  }
}