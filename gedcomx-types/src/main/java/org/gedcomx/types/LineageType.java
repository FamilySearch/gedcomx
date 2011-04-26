package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

@XmlQNameEnum
public enum LineageType {

  biological,
  adopted,
  step,
  foster,
  guardianship,
  @XmlUnknownQNameEnumValue
  other

}
