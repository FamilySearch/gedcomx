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

import org.codehaus.enunciate.ClientName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * A date field.
 */
@ClientName("DateInfo")
public class Date extends Field {

  private List<DatePart> parts;

  /**
   * The parts of the date.
   *
   * @return The parts of the date.
   */
  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  public List<DatePart> getParts() {
    return parts;
  }

  /**
   * The parts of the date.
   *
   * @param parts The parts of the date.
   */
  public void setParts(List<DatePart> parts) {
    this.parts = parts;
  }
}
