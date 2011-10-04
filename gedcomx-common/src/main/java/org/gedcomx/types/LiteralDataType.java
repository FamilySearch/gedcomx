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

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlQNameEnumValue;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;
import org.gedcomx.rt.CommonNamespaces;

import javax.xml.XMLConstants;
import java.net.URI;

/**
 * Enumeration of some known datatypes. For more information, start with the explanation of an
 * <a href="http://www.w3.org/TR/rdf-primer/#typedliterals">RDF Typed Literal</a> in the RDF primer.
 *
 * @author Ryan Heaton
 * @see <a href="http://www.w3.org/TR/2001/REC-xmlschema-2-20010502/#built-in-datatypes">built-in datatypes</a>
 */
@XmlQNameEnum (
  namespace = CommonNamespaces.RDF_NAMESPACE,
  base = XmlQNameEnum.BaseType.URI
)
public enum LiteralDataType {

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "boolean"
  )
  Boolean,

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "int"
  )
  Int,

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "long"
  )
  Long,

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "short"
  )
  Short,

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "float"
  )
  Float,

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "double"
  )
  Double,

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "string"
  )
  String,

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "dateTime"
  )
  DateTime,

  @XmlQNameEnumValue (
    namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI + "#",
    localPart = "base64Binary"
  )
  Base64Binary,

  /**
   * Custom
   */
  @XmlUnknownQNameEnumValue
  OTHER;

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public URI toQNameURI() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.toURI(this);
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static LiteralDataType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURI(qname, LiteralDataType.class);
  }

}
