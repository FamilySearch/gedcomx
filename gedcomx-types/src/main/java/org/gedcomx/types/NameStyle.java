package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

@XmlQNameEnum
public enum NameStyle {

  chinese,
  kana,
  hangul,
  cyrillic,
  spanish,
  portugese,
  @XmlUnknownQNameEnumValue
  other

}
