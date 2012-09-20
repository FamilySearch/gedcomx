/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
package org.gedcomx.common;

import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Generic holder/container/collection for a set of resources.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "resources" )
@JsonElementWrapper (name = "resourceSets")
@XmlType ( name = "ResourceSet" )
public class ResourceSet extends ExtensibleData {

  private String id;

  /**
   * The id of this bundle.
   *
   * @return The id of this bundle.
   */
  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  /**
   * The id of this bundle.
   *
   * @param id The id of this bundle.
   */
  public void setId(String id) {
    this.id = id;
  }

}
