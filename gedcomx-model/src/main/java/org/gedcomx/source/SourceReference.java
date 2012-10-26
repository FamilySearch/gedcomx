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
package org.gedcomx.source;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.*;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An attributable reference to a description of a source.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "sourceReference" )
@JsonElementWrapper ( name = "sourceReferences" )
@XmlType ( name = "SourceReference" )
public class SourceReference extends ExtensibleData implements Attributable {

  private URI descriptionRef;
  private Attribution attribution;

  /**
   * The attribution metadata for this source reference.
   *
   * @return The attribution metadata for this source reference.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this source reference.
   *
   * @param attribution The attribution metadata for this source reference.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * A reference to a description of the source being referenced.
   *
   * @return A reference to a description of the source being referenced.
   */
  @XmlAttribute ( name = "description" )
  @JsonName ( "description" )
  @JsonProperty ( "description" )
  public URI getDescriptionRef() {
    return descriptionRef;
  }

  /**
   * A reference to a description of the source being referenced.
   *
   * @param descriptionRef A reference to a description of the source being referenced.
   */
  @JsonProperty ( "description" )
  public void setDescriptionRef(URI descriptionRef) {
    this.descriptionRef = descriptionRef;
  }
}
