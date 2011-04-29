package org.gedcomx.www;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

/**
 * @author Ryan Heaton
 */
@XmlQNameEnum
public enum PersistentIdentifierType {

  pal,

  @XmlUnknownQNameEnumValue
  other
}
