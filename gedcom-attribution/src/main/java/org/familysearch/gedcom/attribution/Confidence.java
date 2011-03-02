package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import java.lang.reflect.Field;

/**
 * indicates degree of confidence in the data contributed
 *
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlEnum
public enum Confidence {

  @XmlEnumValue("Definite")
  DEFINITE,
  @XmlEnumValue("Probable")
  PROBABLE,
  @XmlEnumValue("Reasonable")
  REASONABLE,
  @XmlEnumValue("Possible")
  POSSIBLE,
  @XmlEnumValue("Doubtful")
  DOUBTFUL;

  public String value() {
    try {
      Field field = Confidence.class.getField(name());
      return field.getAnnotation(XmlEnumValue.class).value();
    }
    catch (Exception e) {
      return name();
    }
  }

  public static Confidence fromValue(String v) {
    for (Confidence value : Confidence.values()) {
      if (v.equalsIgnoreCase(value.name())) {
        return value;
      }
      try {
        Field field = Confidence.class.getField(value.name());
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
