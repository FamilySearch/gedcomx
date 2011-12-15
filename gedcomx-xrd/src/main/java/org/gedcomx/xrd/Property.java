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


package org.gedcomx.xrd;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.net.URI;


/**
 * The <Property> element declares a property of a resource (when used as a child of the <XRD> element)
 * or link relation (when used as a child of the <Link> element), expressed as a key-value pair. The
 * key is identified by the type attribute, and the value expressed as the string content of the
 * <Property> element. A property MAY have no value if the type identifier alone is sufficient.
 * <Property> elements that contain no value MUST include the xsi:nil attribute with a value of true
 * as defined in [XML Schema].
 *
 * See http://docs.oasis-open.org/xri/xrd/v1.0/xrd-1.0.html#element.property
 *
 * @author Mike Gardiner, Ryan Heaton
 */
@XmlType ( name = "Property" )
@SuppressWarnings({"rdf-incompatible-ns", "unqualified-attribute"})
public final class Property {

  private URI type;
  private String value;

  @XmlAttribute ( required = true)
  @XmlSchemaType( name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  @SuppressWarnings("rdf-incompatible-type-reference")
  public URI getType() {
    return type;
  }

  public void setType(URI value) {
    this.type = value;
  }

  @XmlValue
  public String getValue() {
      return value;
  }

  public void setValue(String value) {
      this.value = value;
  }
}
