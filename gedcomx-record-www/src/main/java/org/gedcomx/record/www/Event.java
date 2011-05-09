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
package org.gedcomx.record.www;

import org.gedcomx.www.Links;
import org.gedcomx.www.PersistentIdentifier;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
@XmlRootElement (name = "event")
@XmlType (name = "event")
public class Event extends org.gedcomx.record.Event {

  private URI base;
  private PersistentIdentifier persistentId;
  private Links links;

  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  public void setBase(URI base) {
    this.base = base;
  }

  public PersistentIdentifier getPersistentId() {
    return persistentId;
  }

  public void setPersistentId(PersistentIdentifier persistentId) {
    this.persistentId = persistentId;
  }

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }
}
