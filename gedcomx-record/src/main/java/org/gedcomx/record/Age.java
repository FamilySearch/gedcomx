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

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A field that states the age of a person.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Age" )
public class Age extends Field implements Partitionable<AgePart> {

  private List<AgePart> parts;

  /**
   * The parts of the age.
   *
   * @return The parts of the age.
   */
  @XmlElement (name = "part")
  @JsonName ("parts")
  @JsonProperty ("parts")
  public List<AgePart> getParts() {
    return parts;
  }

  /**
   * The parts of the age.
   *
   * @param parts The parts of the age.
   */
  @JsonProperty ("parts")
  public void setParts(List<AgePart> parts) {
    this.parts = parts;
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    s.append(super.toString());

    if ((s.length() <= 0) && (parts != null)) {
      // Then show all the parts.
      for (AgePart agePart : parts) {
        s.append(agePart.toString() + " ");
      }
    }

    return s.toString().trim();
  }
}
