package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlRootElement
public class Contributor {

  /**
   * url where contributor may be retrieved in a web service
   */
  private String url;
  /**
   * name of the contributor
   */
  private String name;
  /**
   * contact information for this contributor
   */
  private ContactInformation contactInformation;
  /**
   * external contributor ids, or ids of matching contributors in other systems
   */
  private Set<TypeValue> externalIds;

  public Contributor() {
  }

  public Contributor(String url, String name, ContactInformation contactInformation) {
    this.url = url;
    this.name = name;
    this.contactInformation = contactInformation;
  }

  @XmlAttribute
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @XmlElement
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlElement
  public ContactInformation getContactInformation() {
    return contactInformation;
  }

  public void setContactInformation(ContactInformation contactInformation) {
    this.contactInformation = contactInformation;
  }

  /**
   * gets the "external ids" (ids that come from systems "foreign" to the system where this resource originates)
   *
   * @return the "external ids" (ids that come from systems "foreign" to the system where this resource originates)
   */
  @XmlElement(name = "externalId")
  public Set<TypeValue> getExternalIds() {
    return externalIds;
  }

  public void setExternalIds(Set<TypeValue> externalIds) {
    this.externalIds = externalIds;
  }

  public void addExternalId(TypeValue typeValue) {
    if (this.externalIds == null) {
      this.externalIds = new HashSet<TypeValue>();
    }
    this.externalIds.add(typeValue);
  }

  /**
   * finds the external id that matches the given type
   *
   * @param type the type of external id to find
   * @return the external id, or null if no external id exists that matches the given type
   */
  public TypeValue findExternalId(String type) {
    if (externalIds == null) {
      return null;
    }
    for (TypeValue externalId : externalIds) {
      if (type.equals(externalId.getType())) {
        return externalId;
      }
    }
    return null;
  }

}
