/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.record;

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
