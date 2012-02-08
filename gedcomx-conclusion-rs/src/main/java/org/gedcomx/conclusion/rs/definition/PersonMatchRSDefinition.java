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
package org.gedcomx.conclusion.rs.definition;

import org.gedcomx.atom.Entry;
import org.gedcomx.conclusion.ConclusionModel;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.Relationship;
import org.gedcomx.rt.rs.ResourceDefinition;
import org.gedcomx.rt.rs.ResourceRelationship;
import org.gedcomx.rt.rs.ResourceRelationships;

import javax.xml.bind.annotation.XmlElement;

/**
 * The person match resource defines a specific match for a person.
 *
 * @author Ryan Heaton
 */
@ResourceDefinition (
  name = "PersonMatch",
  namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE,
  resourceElement = Entry.class,
  subresources = { PersonSummaryRSDefinition.class },
  subresourceElements = {
    @XmlElement (type = Person.class, name = "person", namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE),
    @XmlElement (type = Person.class, name = "parent", namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE),
    @XmlElement (type = Person.class, name = "spouse", namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE),
    @XmlElement (type = Relationship.class, name = "relationship", namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE)
  }
)
@ResourceRelationships ( {
  @ResourceRelationship( identifier = PersonSummaryRSDefinition.REL, definedBy = PersonSummaryRSDefinition.class, description = "The link to the summary of the person that is identified as a match candidate." ),
  @ResourceRelationship( identifier = PersonRSDefinition.REL, definedBy = PersonRSDefinition.class, description = "The link to the person that is identified as a match candidate." )
})
public interface PersonMatchRSDefinition {

}
