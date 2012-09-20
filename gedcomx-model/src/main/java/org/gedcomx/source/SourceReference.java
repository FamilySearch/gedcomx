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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.*;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * An attributable reference to a description of a source.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "sourceReference" )
@JsonElementWrapper ( name = "source-references" )
@XmlType ( name = "SourceReference" )
public class SourceReference extends ExtensibleData implements Attributable {

  private ResourceReference sourceDescription;
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
  @JsonProperty
  @RDFRange( external = "org.gedcomx.source.SourceDescription" )
  public ResourceReference getSourceDescription() {
    return sourceDescription;
  }

  /**
   * A reference to a description of the source being referenced.
   *
   * @param sourceDescription A reference to a description of the source being referenced.
   */
  public void setSourceDescription(ResourceReference sourceDescription) {
    this.sourceDescription = sourceDescription;
  }

  /**
   * A reference to a description of the source being referenced.
   *
   * @param descriptionRef A reference to a description of the source being referenced.
   */
  @XmlTransient
  @JsonIgnore
  public void setSourceDescriptionURI(URI descriptionRef) {
    this.sourceDescription = descriptionRef != null ? new ResourceReference(descriptionRef) : null;
  }

}
