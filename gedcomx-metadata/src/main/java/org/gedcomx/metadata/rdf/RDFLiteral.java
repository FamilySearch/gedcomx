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
package org.gedcomx.metadata.rdf;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.URI;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.SupportsExtensionAttributes;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * An element representing an RDF literal. For more information, see <a href="http://www.w3.org/TR/rdf-schema/#ch_literal">RDF Schema, Section 2.3</a>
 * and <a href="http://dublincore.org/documents/profile-guidelines/#appc">Using RDF properties in profiles: a technical primer</a>.
 *
 * @link http://www.w3.org/TR/rdf-schema/#ch_literal
 * @author Ryan Heaton
 */
@XmlType ( name = "Literal", namespace = CommonModels.RDFS_NAMESPACE )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public final class RDFLiteral implements SupportsExtensionAttributes {

  private static final URI DATE_DATATYPE = URI.create("http://www.w3.org/2001/XMLSchema#dateTime");
  private static final DatatypeFactory DATATYPE_FACTORY;
  static {
    try {
      DATATYPE_FACTORY = DatatypeFactory.newInstance();
    }
    catch (DatatypeConfigurationException e) {
      throw new RuntimeException(e);
    }
  }

  private String lang;
  private URI datatype;
  private String value;
  private Map<QName, String> extensionAttributes;

  public RDFLiteral() {
  }

  public RDFLiteral(String value) {
    this.value = value;
  }

  public RDFLiteral(Date value) {
    setValueAsDate(value);
  }

  /**
   * The datatype of the literal. For more information, start with the explanation of an
   * <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a> in the RDF primer.
   *
   * @return The datatype of the literal.
   */
  @XmlAttribute( name="datatype", namespace = CommonModels.RDF_NAMESPACE )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getDatatype() {
    return datatype;
  }

  /**
   * The datatype of the literal. For more information, start with the explanation of an
   * <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a> in the RDF primer.
   *
   * @param datatype The datatype of the literal.
   */
  public void setDatatype(URI datatype) {
    this.datatype = datatype;
  }

  /**
   * The language of the value of the property. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the value of the property.
   */
  @XmlAttribute( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of the value of the property. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the value of the property.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * The value of the property.
   *
   * @return The value of the property.
   */
  @XmlValue
  public String getValue() {
    return value;
  }

  /**
   * The value of the property.
   *
   * @param value The value of the property.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Get the value of this literal as a date.
   *
   * @return The value of this literal as a date.
   */
  @XmlTransient
  @JsonIgnore
  public Date getValueAsDate() {
    if (getValue() == null) {
      return null;
    }
    else if (getDatatype() != null && !DATE_DATATYPE.equals(getDatatype())) {
      throw new IllegalStateException(String.format("Literal is of type %s, not of type %s.", getDatatype(), DATE_DATATYPE));
    }

    return DATATYPE_FACTORY.newXMLGregorianCalendar(getValue()).toGregorianCalendar().getTime();
  }

  /**
   * Get the value of this literal as a date.
   *
   * @param valueAsDate The value of this literal as a date.
   */
  @JsonIgnore
  public void setValueAsDate(Date valueAsDate) {
    setDatatype(DATE_DATATYPE);
    GregorianCalendar gc = new GregorianCalendar();
    gc.setTime(valueAsDate);
    setValue(DATATYPE_FACTORY.newXMLGregorianCalendar(gc).toXMLFormat());
  }

  /**
   * Attribute extensions to the property.
   *
   * @return Attribute extensions to the property.
   */
  @XmlAnyAttribute
  @JsonIgnore
  public Map<QName, String> getExtensionAttributes() {
    return extensionAttributes;
  }

  /**
   * Attribute extensions to the property.
   *
   * @param extensionAttributes Attribute extensions to the property.
   */
  @JsonIgnore
  public void setExtensionAttributes(Map<QName, String> extensionAttributes) {
    this.extensionAttributes = extensionAttributes;
  }

  /**
   * Add a custom extension attribute.
   *
   * @param qname The qname of the attribute.
   * @param value The value of the attribute.
   */
  public void addExtensionAttribute(QName qname, String value) {
    if (this.extensionAttributes == null) {
      this.extensionAttributes = new HashMap<QName, String>();
    }

    this.extensionAttributes.put(qname, value);
  }
}
