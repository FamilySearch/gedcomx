package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

@XmlQNameEnum
public enum DatePartType {

  year,
  month,
  day,
  @XmlUnknownQNameEnumValue
  other

}
