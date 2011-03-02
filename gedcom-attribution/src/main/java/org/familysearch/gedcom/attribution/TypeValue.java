package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Merlin Carpenter
 *         Date: Feb 4, 2009
 */
public class TypeValue {

  private String type;
  private String value;

  public TypeValue() {
  }


  public TypeValue(String type, String value) {
    this.type = type;
    this.value = value;
  }

  @XmlAttribute
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @XmlValue
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public int hashCode() {
    int hashCode = 0;
    if (type != null) {
      hashCode ^= type.hashCode();
    }
    if (value != null) {
      hashCode ^= value.hashCode();
    }
    return hashCode;
  }

  public boolean equals(Object otherObj) {
    if (otherObj == null || !(otherObj instanceof TypeValue)) {
      return false;
    }
    TypeValue other = (TypeValue) otherObj;
    return isSame(type, other.type) && isSame(value, other.value);
  }

  private static boolean isSame(String s1, String s2) {
    return ((s1 == null && s2 == null) || (s1 != null && s1.equals(s2)));
  }

  public String toString() {
    return type + ":" + value;
  }

}
