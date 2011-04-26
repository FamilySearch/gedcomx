package org.gedcomx.source;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

/**
 * @author Ryan Heaton
 */
@XmlQNameEnum
public enum SourceQualifierProperty {

  x,

  y,

  width,

  height,

  start_milliseconds,

  end_milliseconds,

  @XmlUnknownQNameEnumValue
  other
}
