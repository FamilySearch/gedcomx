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
package org.gedcomx.contributor;

import org.gedcomx.rt.CommonModels;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An address.
 *
 * @see <a href="http://www.w3.org/2000/10/swap/pim/contact">Contact RDF Schema</a>
 * @author Ryan Heaton
 */
@XmlType ( name = "Address" )
public class Address {

  private String city;
  private String country;
  private String postalCode;
  private String stateOrProvince;
  private String street;
  private String street2;
  private String street3;
  private String value;

  /**
   * The city.
   *
   * @return The city.
   */
  public String getCity() {
    return city;
  }

  /**
   * The city.
   *
   * @param city The city.
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * The country.
   *
   * @return The country.
   */
  public String getCountry() {
    return country;
  }

  /**
   * The country.
   *
   * @param country The country.
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * The postal code.
   *
   * @return The postal code.
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * The postal code.
   *
   * @param postalCode The postal code.
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * The state or province.
   *
   * @return The state or province.
   */
  public String getStateOrProvince() {
    return stateOrProvince;
  }

  /**
   * The state or province.
   *
   * @param stateOrProvince The state or province.
   */
  public void setStateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
  }

  /**
   * The street.
   *
   * @return The street.
   */
  public String getStreet() {
    return street;
  }

  /**
   * The street.
   *
   * @param street The street.
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * Additional street information.
   *
   * @return Additional street information.
   */
  public String getStreet2() {
    return street2;
  }

  /**
   * Additional street information.
   *
   * @param street2 Additional street information.
   */
  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  /**
   * Additional street information.
   *
   * @return Additional street information.
   */
  public String getStreet3() {
    return street3;
  }

  /**
   * Additional street information.
   *
   * @param street3 Additional street information.
   */
  public void setStreet3(String street3) {
    this.street3 = street3;
  }

  /**
   * The value of the property, if it can be expressed as a string.
   *
   * @return The value of the property.
   */
  @XmlElement ( name = "value", namespace = CommonModels.RDF_NAMESPACE )
  public String getValue() {
    return value;
  }

  /**
   * The value of the property, if it can be expressed as a string.
   *
   * @param value The value of the property.
   */
  public void setValue(String value) {
    this.value = value;
  }
}
