package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

@XmlQNameEnum
public enum NameType {

  name,
  also_known_as,
  maiden_name,
  married_name,
  nickname,
  adoptive,
  formal,
  religious,
  @XmlUnknownQNameEnumValue
  other

}
