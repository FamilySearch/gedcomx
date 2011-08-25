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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Attribution for data.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonTypeInfo ( use = JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Attribution", propOrder = { "timestamp", "explanation", "contributor" } )
@SuppressWarnings("gedcomx:no_id")
public final class Attribution {

  private ResourceReference contributor;
  private Date timestamp;
  private String explanation;

  /**
   * Reference to the contributor of the attributed data.
   *
   * @return Reference to the contributor of the attributed data.
   */
  @RDFRange({})
  @RDFSubPropertyOf( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "contributor")
  public ResourceReference getContributor() {
    return contributor;
  }

  /**
   * Reference to the contributor of the attributed data.
   *
   * @param contributor Reference to the contributor of the attributed data.
   */
  public void setContributor(ResourceReference contributor) {
    this.contributor = contributor;
  }

  /**
   * The timestamp for the attributed data.
   *
   * @return The timestamp for the attributed data.
   */
  @RDFSubPropertyOf( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "modified")
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp for the attributed data.
   *
   * @param timestamp The timestamp for the attributed data.
   */
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * The explanation for the attributed data (likely provided by the contributor).
   *
   * @return The explanation for the attributed data (likely provided by the contributor).
   */
  @RDFSubPropertyOf( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "description")
  public String getExplanation() {
    return explanation;
  }

  /**
   * The explanation for the attributed data (likely provided by the contributor).
   *
   * @param explanation The explanation for the attributed data (likely provided by the contributor).
   */
  public void setExplanation(String explanation) {
    this.explanation = explanation;
  }
}
