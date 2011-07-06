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
package org.gedcomx.attribution;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Attribution for data.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@SuppressWarnings("gedcomx:no_id")
public class Attribution {

  private ContributorReference contributor;
  private Date timestamp;
  private String explanation;

  /**
   * Reference to the contributor of the attributed data.
   *
   * @return Reference to the contributor of the attributed data.
   */
  public ContributorReference getContributor() {
    return contributor;
  }

  /**
   * Reference to the contributor of the attributed data.
   *
   * @param contributor Reference to the contributor of the attributed data.
   */
  public void setContributor(ContributorReference contributor) {
    this.contributor = contributor;
  }

  /**
   * The timestamp for the attributed data.
   *
   * @return The timestamp for the attributed data.
   */
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
