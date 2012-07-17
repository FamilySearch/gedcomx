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
package org.gedcomx.metadata.foaf;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.SupportsExtensionElements;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * A FOAF agent, e.g. person or organization
 *
 * @see <a href="http://xmlns.com/foaf/spec/#term_Agent">foaf:Agent</a>
 * @author Ryan Heaton
 */
@XmlType (name = "Agent")
public abstract class Agent implements SupportsExtensionElements {

  private String id;
  private RDFLiteral name;
  private RDFLiteral homepage;
  private RDFLiteral openid;
  private List<OnlineAccount> accounts;
  private List<ResourceReference> emails;
  private List<ResourceReference> phones;
  private List<Address> addresses;
  private List<Object> extensionElements;

  /**
   * The id of this piece of metadata.
   *
   * @return The id of this piece of metadata.
   */
  @XmlAttribute ( name = "ID" )
  @XmlID
  public String getId() {
    return id;
  }

  /**
   * The id of this piece of metadata.
   *
   * @param id The id of this piece of metadata.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The name of the person or organization.
   *
   * @return The name of the person or organization.
   */
  public RDFLiteral getName() {
    return name;
  }

  /**
   * The name of the person or organization.
   *
   * @param name The name of the person or organization.
   */
  public void setName(RDFLiteral name) {
    this.name = name;
  }

  /**
   * The homepage of the person or organization. Note this is different from the
   * homepage of the service where the person or organization has an account.
   *
   * @return The homepage.
   */
  public RDFLiteral getHomepage() {
    return homepage;
  }

  /**
   * The homepage of the person or organization. Note this is different from the
   * homepage of the service where the person or organization has an account.
   *
   * @param homepage The homepage.
   */
  public void setHomepage(RDFLiteral homepage) {
    this.homepage = homepage;
  }

  /**
   * The <a href="http://openid.net/">openid</a> of the person or organization.
   *
   * @return The <a href="http://openid.net/">openid</a> of the person or organization.
   */
  public RDFLiteral getOpenid() {
    return openid;
  }

  /**
   * The <a href="http://openid.net/">openid</a> of the person or organization.
   *
   * @param openid The <a href="http://openid.net/">openid</a> of the person or organization.
   */
  public void setOpenid(RDFLiteral openid) {
    this.openid = openid;
  }

  /**
   * The accounts that belong to this person or organization.
   *
   * @return The accounts that belong to this person or organization.
   */
  @XmlElement(name = "account")
  @JsonName ("accounts")
  @JsonProperty ("accounts")
  public List<OnlineAccount> getAccounts() {
    return accounts;
  }

  /**
   * The accounts that belong to this person or organization.
   *
   * @param accounts The accounts that belong to this person or organization.
   */
  @JsonProperty ("accounts")
  public void setAccounts(List<OnlineAccount> accounts) {
    this.accounts = accounts;
  }

  /**
   * The emails that belong to this person or organization.
   *
   * @return The emails that belong to this person or organization.
   */
  @XmlElement(name = "mbox")
  @JsonName ("emails")
  @JsonProperty ("emails")
  public List<ResourceReference> getEmails() {
    return emails;
  }

  /**
   * The emails that belong to this person or organization.
   *
   * @param emails The emails that belong to this person or organization.
   */
  @JsonProperty ("emails")
  public void setEmails(List<ResourceReference> emails) {
    this.emails = emails;
  }

  /**
   * The phones that belong to this person or organization.
   *
   * @return The phones that belong to this person or organization.
   */
  @XmlElement(name = "phone")
  @JsonName ("phones")
  @JsonProperty ("phones")
  public List<ResourceReference> getPhones() {
    return phones;
  }

  /**
   * The phones that belong to this person or organization.
   *
   * @param phones The phones that belong to this person or organization.
   */
  @JsonProperty ("phones")
  public void setPhones(List<ResourceReference> phones) {
    this.phones = phones;
  }

  /**
   * The addresses that belong to this person or organization.
   *
   * @return The addresses that belong to this person or organization.
   */
  @XmlElement(name = "address", namespace = CommonModels.CONTACT_NAMESPACE)
  @JsonName ("addresses")
  @JsonProperty ("addresses")
  @SuppressWarnings("gedcomx:plural_xml_name")
  public List<Address> getAddresses() {
    return addresses;
  }

  /**
   * The addresses that belong to this person or organization.
   *
   * @param addresses The addresses that belong to this person or organization.
   */
  @JsonProperty ("addresses")
  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  /**
   * Add an extension element.
   *
   * @param element The extension element to add.
   */
  public void addExtensionElement(Object element) {
    if (this.extensionElements == null) {
      this.extensionElements = new ArrayList<Object>();
    }

    this.extensionElements.add(element);
  }

  /**
   * Finds the first extension of a specified type.
   *
   * @param clazz The type.
   * @return The extension, or null if none found.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> E findExtensionOfType(Class<E> clazz) {
    if (this.extensionElements != null) {
      for (Object extension : extensionElements) {
        if (clazz.isInstance(extension)) {
          return (E) extension;
        }
      }
    }

    return null;
  }

  /**
   * Find the extensions of a specified type.
   *
   * @param clazz The type.
   * @return The extensions, possibly empty but not null.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> List<E> findExtensionsOfType(Class<E> clazz) {
    List<E> ext = new ArrayList<E>();
    if (this.extensionElements != null) {
      for (Object extension : extensionElements) {
        if (clazz.isInstance(extension)) {
          ext.add((E) extension);
        }
      }
    }

    return ext;
  }

  /**
   * Custom elements applicable as part of this metadata.
   *
   * @return Custom elements applicable as part of this metadata.
   */
  @XmlAnyElement ( lax = true )
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom elements applicable as part of this metadata.
   *
   * @param extensionElements Custom elements applicable as part of this metadata.
   */
  @JsonIgnore
  public void setExtensionElements(List<Object> extensionElements) {
    this.extensionElements = extensionElements;
  }
}
