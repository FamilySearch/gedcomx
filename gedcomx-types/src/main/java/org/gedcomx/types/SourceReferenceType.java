package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

@XmlQNameEnum
public enum SourceReferenceType {

  source,
  image,
  @XmlUnknownQNameEnumValue
  other

}
