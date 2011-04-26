package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

/**
 * @author Ryan Heaton
 */
@XmlQNameEnum
public enum AgeUnits {

  years,

  months,

  days,

  hours,

  minutes,

  @XmlUnknownQNameEnumValue
  other

}
