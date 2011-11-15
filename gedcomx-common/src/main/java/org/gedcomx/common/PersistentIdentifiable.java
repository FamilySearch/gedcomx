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
package org.gedcomx.common;

import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.RDFDomain;
import org.gedcomx.rt.RDFSubPropertyOf;

import javax.xml.bind.annotation.XmlType;
import java.net.URI;
import java.util.List;

/**
 * A resource that is able to be identifiable in a long-term, persistent way.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "PersistentIdentifiable" )
public interface PersistentIdentifiable {

  /**
   * The long-term persistent identifier for a resource.
   *
   * @return The long-term persistent identifier for a resource.
   */
  @RDFDomain({}) //any resource can be identified persistently.
  @RDFSubPropertyOf( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "identifier" )
  URI getPersistentId();

  /**
   * A long-term, persistent, globally unique identifier for this entity.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this entity.
   */
  void setPersistentId(URI persistentId);

  /**
   * List of alternate identifiers for a resource.
   *
   * @return List of alternate identifiers for a resource.
   */
  @RDFDomain({}) //any resource can have alternate ids.
  @RDFSubPropertyOf( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "identifier" )
  List<AlternateId> getAlternateIds();

  /**
   * The list of alternate ids of the entity.
   *
   * @param alternateIds The list of alternate ids of the entity.
   */
  void setAlternateIds(List<AlternateId> alternateIds);
}
