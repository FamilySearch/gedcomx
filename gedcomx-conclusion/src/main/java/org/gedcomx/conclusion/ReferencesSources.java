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
package org.gedcomx.conclusion;

import org.gedcomx.common.SourceReference;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.RDFDomain;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubPropertyOf;

import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * Conclusion data that references sources.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "ReferencesSources" )
public interface ReferencesSources {

  /**
   * The references to the sources of a conclusion resource.
   *
   * @return The references to the sources of a conclusion resource.
   */
  @RDFSubPropertyOf ( CommonModels.DUBLIN_CORE_NAMESPACE + "source")
  @RDFDomain ({}) //any resource can be identified persistently.
  @RDFRange ({}) //any resource can be identified as a source.
  @SuppressWarnings("rdf:no_range")
  List<SourceReference> getSourceReferences();

  /**
   * The references to the sources of a conclusion resource.
   *
   * @param notes The references to the sources of a conclusion resource.
   */
  void setSourceReferences(List<SourceReference> notes);
}
