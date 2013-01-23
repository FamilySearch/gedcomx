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
import org.gedcomx.common.Note;
import org.gedcomx.conclusion.*;
import org.gedcomx.contributor.Agent;
import org.gedcomx.source.SourceCitation;
import org.gedcomx.source.SourceDescription;
import org.gedcomx.source.SourceReference;

import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;

/**
 * Basic, no-op implementation of the GEDCOM X model visitor. Intended to be extended and appropriate methods overridden as needed.
 * 
 * @author Ryan Heaton
 */
@XmlTransient
public class GedcomxModelVisitorBase implements GedcomxModelVisitor {

  protected final LinkedList<Object> contextStack = new LinkedList<Object>();
  
  @Override
  public void visitGedcomx(Gedcomx gx) {
    this.contextStack.push(gx);

    List<Person> persons = gx.getPersons();
    if (persons != null) {
      for (Person person : persons) {
        if (person != null) {
          person.accept(this);
        }
      }
    }

    List<Relationship> relationships = gx.getRelationships();
    if (relationships != null) {
      for (Relationship relationship : relationships) {
        if (relationship != null) {
          relationship.accept(this);
        }
      }
    }

    List<CoupleChildRelationship> coupleChildRelationships = gx.getCoupleChildRelationships();
    if (coupleChildRelationships != null) {
      for (CoupleChildRelationship coupleChildRelationship : coupleChildRelationships) {
        if (coupleChildRelationship != null) {
          coupleChildRelationship.accept(this);
        }
      }
    }

    List<SourceDescription> sourceDescriptions = gx.getSourceDescriptions();
    if (sourceDescriptions != null) {
      for (SourceDescription sourceDescription : sourceDescriptions) {
        if (sourceDescription != null) {
          sourceDescription.accept(this);
        }
      }
    }

    List<Agent> agents = gx.getAgents();
    if (agents != null) {
      for (Agent agent : agents) {
        if (agent != null) {
          agent.accept(this);
        }
      }
    }
    
    List<Event> events = gx.getEvents();
    if (events != null) {
      for (Event event : events) {
        if (event != null) {
          event.accept(this);
        }
      }
    }
    
    List<PlaceDescription> places = gx.getPlaces();
    if (places != null) {
      for (PlaceDescription place : places) {
        if (place != null) {
          place.accept(this);
        }
      }
    }
    
    List<Document> documents = gx.getDocuments();
    if (documents != null) {
      for (Document document : documents) {
        if (document != null) {
          document.accept(this);
        }
      }
    }

    this.contextStack.pop();
  }

  @Override
  public void visitDocument(Document document) {
    this.contextStack.push(document);
    visitConclusion(document);
    this.contextStack.pop();
  }

  @Override
  public void visitPlaceDescription(PlaceDescription place) {
    this.contextStack.push(place);
    visitConclusion(place);
    this.contextStack.pop();
  }

  @Override
  public void visitEvent(Event event) {
    this.contextStack.push(event);
    visitConclusion(event);
    Date date = event.getDate();
    if (date != null) {
      date.accept(this);
    }

    PlaceReference place = event.getPlace();
    if (place != null) {
      place.accept(this);
    }

    List<EventRole> roles = event.getRoles();
    if (roles != null) {
      for (EventRole role : roles) {
        role.accept(this);
      }
    }
    this.contextStack.pop();
  }

  @Override
  public void visitEventRole(EventRole role) {
    this.contextStack.push(role);
    visitConclusion(role);
    this.contextStack.pop();
  }

  @Override
  public void visitAgent(Agent agent) {
    //no-op.
  }

  @Override
  public void visitSourceDescription(SourceDescription sourceDescription) {
    this.contextStack.push(sourceDescription);
    List<SourceReference> sources = sourceDescription.getSources();
    if (sources != null) {
      for (SourceReference source : sources) {
        source.accept(this);
      }
    }

    List<Note> notes = sourceDescription.getNotes();
    if (notes != null) {
      for (Note note : notes) {
        note.accept(this);
      }
    }

    List<SourceCitation> citations = sourceDescription.getCitations();
    if (citations != null) {
      for (SourceCitation citation : citations) {
        citation.accept(this);
      }
    }
    this.contextStack.pop();
  }

  @Override
  public void visitSourceCitation(SourceCitation citation) {
    //no-op.
  }

  @Override
  public void visitRelationship(Relationship relationship) {
    this.contextStack.push(relationship);
    visitConclusion(relationship);

    List<Fact> facts = relationship.getFacts();
    if (facts != null) {
      for (Fact fact : facts) {
        fact.accept(this);
      }
    }
    this.contextStack.pop();
  }

  @Override
  public void visitCoupleChildRelationship(CoupleChildRelationship coupleChildRelationship) {
    this.contextStack.push(coupleChildRelationship);
    visitConclusion(coupleChildRelationship);
    this.contextStack.pop();
  }

  protected void visitConclusion(Conclusion conclusion) {
    List<SourceReference> sourceReferences = conclusion.getSources();
    if (sourceReferences != null) {
      for (SourceReference sourceReference : sourceReferences) {
        sourceReference.accept(this);
      }
    }

    List<Note> notes = conclusion.getNotes();
    if (notes != null) {
      for (Note note : notes) {
        note.accept(this);
      }
    }
  }

  @Override
  public void visitPerson(Person person) {
    this.contextStack.push(person);
    visitConclusion(person);

    if (person.getGender() != null) {
      person.getGender().accept(this);
    }

    List<Name> names = person.getNames();
    if (names != null) {
      for (Name name : names) {
        name.accept(this);
      }
    }

    List<Fact> facts = person.getFacts();
    if (facts != null) {
      for (Fact fact : facts) {
        fact.accept(this);
      }
    }
    this.contextStack.pop();
  }

  @Override
  public void visitFact(Fact fact) {
    this.contextStack.push(fact);
    visitConclusion(fact);
    Date date = fact.getDate();
    if (date != null) {
      date.accept(this);
    }

    PlaceReference place = fact.getPlace();
    if (place != null) {
      place.accept(this);
    }
    this.contextStack.pop();
  }

  @Override
  public void visitPlaceReference(PlaceReference place) {
    //no-op.
  }

  @Override
  public void visitDate(Date date) {
    //no-op.
  }

  @Override
  public void visitName(Name name) {
    this.contextStack.push(name);
    visitConclusion(name);

    List<NameForm> forms = name.getNameForms();
    if (forms != null) {
      for (NameForm form : forms) {
        form.accept(this);
      }
    }
    this.contextStack.pop();
  }

  @Override
  public void visitNameForm(NameForm form) {
    this.contextStack.push(form);
    List<NamePart> parts = form.getParts();
    if (parts != null) {
      for (NamePart part : parts) {
        part.accept(this);
      }
    }
    this.contextStack.pop();
  }

  @Override
  public void visitNamePart(NamePart part) {
    //no-op...
  }

  @Override
  public void visitGender(Gender gender) {
    this.contextStack.push(gender);
    visitConclusion(gender);
    this.contextStack.pop();
  }

  @Override
  public void visitSourceReference(SourceReference sourceReference) {
    //no-op
  }

  @Override
  public void visitNote(Note note) {
    //no-op.
  }

  public LinkedList<Object> getContextStack() {
    return contextStack;
  }
}
