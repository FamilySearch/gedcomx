package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import java.lang.reflect.Field;

/**
 * the well-known reason for a given attribution
 *
 * @author Merlin Carpenter
 *         Date: Aug 26, 2008
 */
@XmlEnum
public enum ReasonType {

  @XmlEnumValue("Implied")
  IMPLIED,
  @XmlEnumValue("Derived")
  DERIVED,
  @XmlEnumValue("Other")
  OTHER;

  public String value() {
    try {
      Field field = ReasonType.class.getField(name());
      return field.getAnnotation(XmlEnumValue.class).value();
    }
    catch (Exception e) {
      return name();
    }
  }

  public static ReasonType fromValue(String v) {
    for (ReasonType value : ReasonType.values()) {
      if (v.equalsIgnoreCase(value.name())) {
        return value;
      }
      try {
        Field field = ReasonType.class.getField(value.name());
        if (v.equals(field.getAnnotation(XmlEnumValue.class).value())) {
          return value;
        }
      }
      catch (Exception e) {
        // if this happens, it is because there was no annotation on the enum constant
      }
    }
    throw new IllegalArgumentException(v);
  }

}
