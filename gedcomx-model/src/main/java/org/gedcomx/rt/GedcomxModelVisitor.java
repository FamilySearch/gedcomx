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
package org.gedcomx.rt;

import org.gedcomx.Gedcomx;
import org.gedcomx.agent.Agent;
import org.gedcomx.common.Note;
import org.gedcomx.conclusion.*;
import org.gedcomx.source.SourceCitation;
import org.gedcomx.source.SourceDescription;
import org.gedcomx.source.SourceReference;

/**
 * Visitor interface for the GEDCOM X model.
 *
 * @author Ryan Heaton
 */
public interface GedcomxModelVisitor {

  void visitGedcomx(Gedcomx gx);

  void visitDocument(Document document);

  void visitPlaceDescription(PlaceDescription place);

  void visitEvent(Event event);

  void visitEventRole(EventRole role);

  void visitAgent(Agent agent);

  void visitSourceDescription(SourceDescription sourceDescription);

  void visitSourceCitation(SourceCitation citation);

  void visitRelationship(Relationship relationship);

  void visitPerson(Person person);

  void visitFact(Fact fact);

  void visitPlaceReference(PlaceReference place);

  void visitDate(Date date);

  void visitName(Name name);

  void visitNameForm(NameForm form);

  void visitNamePart(NamePart part);

  void visitGender(Gender gender);

  void visitSourceReference(SourceReference sourceReference);

  void visitNote(Note note);
}
