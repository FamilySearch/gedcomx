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
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubPropertyOf;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A resource that is able to be supported by sources.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "SourceSupported" )
public interface SourceSupported {

  /**
   * The source references for a resource.
   *
   * @return The source references for a resource.
   */
  @RDFDomain ({}) //any resource can be identified persistently.
  @RDFRange ({}) //any resource can be identified as a source.
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "source" )
  @SuppressWarnings("rdf:no_range")
  List<ResourceReference> getSources();
}
