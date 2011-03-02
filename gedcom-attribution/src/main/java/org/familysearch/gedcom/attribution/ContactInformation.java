package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author CarpenterMP
 *         Date: Nov 5, 2009
 */
public class ContactInformation {

  private Address address;
  private String phone;
  private String email;
  private String siteUrl;

  public ContactInformation() {
  }

  public ContactInformation(String[] address, String phone, String email, String siteUrl) {
    this.address = new Address(address);
    this.phone = phone;
    this.email = email;
    this.siteUrl = siteUrl;
  }

  @XmlElement
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @XmlElement
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @XmlElement
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @XmlElement
  public String getSiteUrl() {
    return siteUrl;
  }

  public void setSiteUrl(String siteUrl) {
    this.siteUrl = siteUrl;
  }
}
