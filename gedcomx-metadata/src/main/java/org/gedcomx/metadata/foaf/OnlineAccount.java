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
package org.gedcomx.metadata.foaf;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

/**
 * An online account as described by FOAF.
 *
 * @see <a href="http://xmlns.com/foaf/spec/#term_OnlineAccount">foaf:OnlineAccount</a>
 * @author Ryan Heaton
 */
@XmlType( name = "OnlineAccount" )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class OnlineAccount {

  private String id;
  private ResourceReference serviceHomepage;
  private RDFLiteral accountName;
  private RDFLiteral displayName;

  /**
   * The id of this online account.
   *
   * @return The id of this online account.
   */
  @XmlAttribute ( name = "ID", namespace = CommonNamespaces.RDF_NAMESPACE  )
  @XmlID
  public String getId() {
    return id;
  }

  /**
   * The id of this online account.
   *
   * @param id The id of this online account.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The homepage of the service that provides this account.
   *
   * @return The homepage of the service that provides this account.
   */
  @XmlElement (name = "accountServiceHomepage")
  @JsonName ("serviceHomepage")
  @JsonProperty ("serviceHomepage")
  public ResourceReference getServiceHomepage() {
    return serviceHomepage;
  }

  /**
   * The homepage of the service that provides this account.
   *
   * @param serviceHomepage The homepage of the service that provides this account.
   */
  @JsonProperty ("serviceHomepage")
  public void setServiceHomepage(ResourceReference serviceHomepage) {
    this.serviceHomepage = serviceHomepage;
  }

  /**
   * The name associated the holder of this account with the account.
   *
   * @return The name associated the holder of this account with the account.
   */
  public RDFLiteral getAccountName() {
    return accountName;
  }

  /**
   * The name associated the holder of this account with the account.
   *
   * @param accountName The name associated the holder of this account with the account.
   */
  public void setAccountName(RDFLiteral accountName) {
    this.accountName = accountName;
  }

  /**
   * The display name of the person or organization associated with this account.
   *
   * @return The display name of the person or organization associated with this account.
   */
  @XmlElement( name = "nick" )
  public RDFLiteral getDisplayName() {
    return displayName;
  }

  /**
   * The display name of the person or organization associated with this account.
   *
   * @param displayName The display name of the person or organization associated with this account.
   */
  public void setDisplayName(RDFLiteral displayName) {
    this.displayName = displayName;
  }
}
