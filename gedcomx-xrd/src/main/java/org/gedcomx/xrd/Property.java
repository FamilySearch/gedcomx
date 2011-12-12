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
 * todo: fill in docs
 */
@XmlType ( name = "Property" )
@SuppressWarnings("rdf-incompatible-ns")
public final class Property {

  private URI type;
  private String value;

  @XmlAttribute ( required = true )
  @XmlSchemaType( name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI )
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
