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
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.XmlTypeIdResolver;

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
@XmlType ( name = "Attribution", propOrder = {"modified", "statement", "contributor" } )
@SuppressWarnings("gedcomx:no_id")
public final class Attribution {

  private ResourceReference contributor;
  private Date modified;
  private String statement;

  /**
   * Reference to the contributor of the attributed data.
   *
   * @return Reference to the contributor of the attributed data.
   */
  @RDFRange({})
  @RDFSubPropertyOf( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "contributor")
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
   * The modified timestamp for the attributed data.
   *
   * @return The modified timestamp for the attributed data.
   */
  @RDFSubPropertyOf( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "modified")
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
  @RDFSubPropertyOf( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "description")
  public String getStatement() {
    return statement;
  }

  /**
   * The "proof statement" for the attributed data provided by the contributor.
   *
   * @param statement The "proof statement" for the attributed data provided by the contributor.
   */
  public void setStatement(String statement) {
    this.statement = statement;
  }
}
