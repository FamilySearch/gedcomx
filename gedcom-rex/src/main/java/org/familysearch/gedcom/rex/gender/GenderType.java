package org.familysearch.gedcom.rex.gender;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import java.lang.reflect.Field;

/**
 * The "type" of gender
 *
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
@XmlEnum
public enum GenderType {

  @XmlEnumValue("male")
  MALE,
  @XmlEnumValue("female")
  FEMALE,
  @XmlEnumValue("unknown")
  UNKNOWN;

  public String value() {
    try {
      Field field = GenderType.class.getField(name());
      return field.getAnnotation(XmlEnumValue.class).value();
    }
    catch (Exception e) {
      return name();
    }
  }

  public static GenderType fromValue(String v) {
    for (GenderType value : GenderType.values()) {
      if (v.equalsIgnoreCase(value.name())) {
        return value;
      }
      try {
        Field field = GenderType.class.getField(value.name());
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
