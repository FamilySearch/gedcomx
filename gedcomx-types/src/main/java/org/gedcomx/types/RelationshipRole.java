package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

@XmlQNameEnum
public enum RelationshipRole {

  grandparent,
  grandchild,
  ancestor,
  descendant,
  cousin,
  in_law,
  @XmlUnknownQNameEnumValue
  other

}