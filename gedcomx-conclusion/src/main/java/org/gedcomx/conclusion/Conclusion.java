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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A genealogical conclusion.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Conclusion" )
public abstract class Conclusion extends GenealogicalResource {

  private Boolean preferred;
  private List<ResourceReference> sources;

  /**
   * Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   *
   * @return Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   */
  @XmlAttribute
  public Boolean getPreferred() {
    return preferred;
  }

  /**
   * Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   *
   * @param preferred Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   */
  public void setPreferred(Boolean preferred) {
    this.preferred = preferred;
  }

  /**
   * The source references for a conclusion.
   *
   * @return The source references for a conclusion.
   */
  @XmlElement (name="source")
  @JsonProperty ("sources")
  @JsonName ("sources")
  @RDFSubPropertyOf ( CommonModels.GEDCOMX_COMMON_NAMESPACE + "source")
  @RDFRange ({}) //any resource can be identified as a source.
  @SuppressWarnings("rdf:no_range")
  public List<ResourceReference> getSources() {
    return sources;
  }

  /**
   * The source references for a conclusion.
   *
   * @param sources The source references for a conclusion.
   */
  @JsonProperty("sources")
  public void setSources(List<ResourceReference> sources) {
    this.sources = sources;
  }

}
