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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.*;
import org.gedcomx.types.ConfidenceLevel;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Attribution for data.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper ( name = "attribution" )
@JsonTypeInfo ( use = JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Attribution", propOrder = {"modified", "proofStatement", "confidence", "contributor" } )
@SuppressWarnings("gedcomx:no_id")
public final class Attribution {

  private ResourceReference contributor;
  private TypeReference<ConfidenceLevel> confidence;
  private Date modified;
  private String proofStatement;

  /**
   * Reference to the contributor of the attributed data.
   *
   * @return Reference to the contributor of the attributed data.
   */
  @RDFRange({})
  @RDFSubPropertyOf( CommonModels.DUBLIN_CORE_NAMESPACE + "contributor")
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
   * The level of confidence the contributor has about the data.
   *
   * @return The level of confidence the contributor has about the data.
   */
  public TypeReference<ConfidenceLevel> getConfidence() {
    return confidence;
  }

  /**
   * The level of confidence the contributor has about the data.
   *
   * @param confidence The level of confidence the contributor has about the data.
   */
  public void setConfidence(TypeReference<ConfidenceLevel> confidence) {
    this.confidence = confidence;
  }

  /**
   * The enum referencing the known confidence level, or {@link org.gedcomx.types.ConfidenceLevel#OTHER} if not known.
   *
   * @return The enum referencing the known confidence level, or {@link org.gedcomx.types.ConfidenceLevel#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public ConfidenceLevel getKnownConfidenceLevel() {
    return getConfidence() == null ? null : XmlQNameEnumUtil.fromURI(getConfidence().getType(), ConfidenceLevel.class);
  }

  /**
   * Set the confidence level from a known enumeration of confidence levels.
   *
   * @param level The known level.
   */
  @JsonIgnore
  public void setKnownConfidenceLevel(ConfidenceLevel level) {
    setConfidence(level == null ? null : new TypeReference<ConfidenceLevel>(level));
  }

  /**
   * The modified timestamp for the attributed data.
   *
   * @return The modified timestamp for the attributed data.
   */
  @RDFSubPropertyOf( CommonModels.DUBLIN_CORE_NAMESPACE + "modified")
  public Date getModified() {
    return modified;
  }

  /**
   * The modified timestamp for the attributed data.
   *
   * @param modified The modified timestamp for the attributed data.
   */
  public void setModified(Date modified) {
    this.modified = modified;
  }

  /**
   * The "proof statement" for the attributed data provided by the contributor.
   *
   * @return The "proof statement" for the attributed data provided by the contributor.
   */
  @RDFSubPropertyOf( CommonModels.DUBLIN_CORE_NAMESPACE + "description")
  public String getProofStatement() {
    return proofStatement;
  }

  /**
   * The "proof statement" for the attributed data provided by the contributor.
   *
   * @param proofStatement The "proof statement" for the attributed data provided by the contributor.
   */
  public void setProofStatement(String proofStatement) {
    this.proofStatement = proofStatement;
  }
}
