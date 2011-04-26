package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

@XmlQNameEnum
public enum PlacePartType {

  country,
  state,
  province,
  county,
  city,
  town,
  parish,
  territory,
  district,
  township,
  ward,
  section,
  island,
  church,
  cemetery,
  plot_number,
  mortuary,
  ship,
  post_office,
  hospital,
  address,
  postal_code,
  military_base,
  prison,
  @XmlUnknownQNameEnumValue
  other

}
