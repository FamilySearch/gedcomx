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

import javax.xml.bind.annotation.XmlAttribute;
import java.net.URI;

/**
 * A reference to a record collection.
 *
 * @author Ryan Heaton
 */
public final class RecordCollectionReference {

  private URI href;
  private String sortValue;

  /**
   * The link to the collection.
   *
   * @return The link to the collection.
   */
  @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
  public URI getHref() {
    return href;
  }

  /**
   * The link to the collection.
   *
   * @param href The link to the collection.
   */
  public void setHref(URI href) {
    this.href = href;
  }

  /**
   * The alphanumeric value on which the referring entity is to be sorted in the collection.
   *
   * @return The alphanumeric value on which the referring entity is to be sorted in the collection.
   */
  @XmlAttribute
  public String getSortValue() {
    return sortValue;
  }

  /**
   * The alphanumeric value on which the referring entity is to be sorted in the collection.
   *
   * @param sortValue The alphanumeric value on which the referring entity is to be sorted in the collection.
   */
  public void setSortValue(String sortValue) {
    this.sortValue = sortValue;
  }
}
