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
import java.util.List;

/**
 * Basic, no-op implementation of the GEDCOM X model visitor. Intended to be extended and appropriate methods overridden as needed.
 * 
 * @author Ryan Heaton
 */
@XmlTransient
public class BasicGedcomxModelVisitor implements GedcomxModelVisitor {
  
  @Override
  public void visitGedcomx(Gedcomx gx) {
    List<Person> persons = gx.getPersons();
    if (persons != null) {
      for (Person person : persons) {
        if (person != null) {
          visitPerson(person);
        }
      }
    }

    List<Relationship> relationships = gx.getRelationships();
    if (relationships != null) {
      for (Relationship relationship : relationships) {
        if (relationship != null) {
          visitRelationship(relationship);
        }
      }
    }

    List<SourceDescription> sourceDescriptions = gx.getSourceDescriptions();
    if (sourceDescriptions != null) {
      for (SourceDescription sourceDescription : sourceDescriptions) {
        if (sourceDescription != null) {
          visitSourceDescription(sourceDescription);
        }
      }
    }

    List<Agent> agents = gx.getAgents();
    if (agents != null) {
      for (Agent agent : agents) {
        if (agent != null) {
          visitAgent(agent);
        }
      }
    }
    
    List<Event> events = gx.getEvents();
    if (events != null) {
      for (Event event : events) {
        if (event != null) {
          visitEvent(event);
        }
      }
    }
    
    List<PlaceDescription> places = gx.getPlaces();
    if (places != null) {
      for (PlaceDescription place : places) {
        if (place != null) {
          visitPlaceDescription(place);
        }
      }
    }
    
    List<Document> documents = gx.getDocuments();
    if (documents != null) {
      for (Document document : documents) {
        if (document != null) {
          visitDocument(document);
        }
      }
    }
  }

  @Override
  public void visitDocument(Document document) {
    visitConclusion(document);
  }

  @Override
  public void visitPlaceDescription(PlaceDescription place) {
    List<SourceReference> sources = place.getSources();
    if (sources != null) {
      for (SourceReference source : sources) {
        visitSourceReference(source);
      }
    }
  }

  @Override
  public void visitEvent(Event event) {
    Date date = event.getDate();
    if (date != null) {
      visitDate(date);
    }

    PlaceReference place = event.getPlace();
    if (place != null) {
      visitPlaceReference(place);
    }

    List<EventRole> roles = event.getRoles();
    for (EventRole role : roles) {
      visitEventRole(role);
    }
  }

  @Override
  public void visitEventRole(EventRole role) {
    //no-op.
  }

  @Override
  public void visitAgent(Agent agent) {
    //no-op.
  }

  @Override
  public void visitSourceDescription(SourceDescription sourceDescription) {
    List<SourceReference> sources = sourceDescription.getSources();
    if (sources != null) {
      for (SourceReference source : sources) {
        visitSourceReference(source);
      }
    }

    List<Note> notes = sourceDescription.getNotes();
    if (notes != null) {
      for (Note note : notes) {
        visitNote(note);
      }
    }

    SourceCitation citation = sourceDescription.getCitation();
    if (citation != null) {
      visitSourceCitation(citation);
    }
  }

  @Override
  public void visitSourceCitation(SourceCitation citation) {
    //no-op.
  }

  @Override
  public void visitRelationship(Relationship relationship) {
    visitConclusion(relationship);

    List<Fact> facts = relationship.getFacts();
    if (facts != null) {
      for (Fact fact : facts) {
        visitFact(fact);
      }
    }
  }

  protected void visitConclusion(Conclusion conclusion) {
    List<SourceReference> sourceReferences = conclusion.getSources();
    if (sourceReferences != null) {
      for (SourceReference sourceReference : sourceReferences) {
        visitSourceReference(sourceReference);
      }
    }

    List<Note> notes = conclusion.getNotes();
    if (notes != null) {
      for (Note note : notes) {
        visitNote(note);
      }
    }
  }

  @Override
  public void visitPerson(Person person) {
    visitConclusion(person);

    if (person.getGender() != null) {
      visitGender(person.getGender());
    }

    List<Name> names = person.getNames();
    if (names != null) {
      for (Name name : names) {
        visitName(name);
      }
    }

    List<Fact> facts = person.getFacts();
    if (facts != null) {
      for (Fact fact : facts) {
        visitFact(fact);
      }
    }
  }

  @Override
  public void visitFact(Fact fact) {
    Date date = fact.getDate();
    if (date != null) {
      visitDate(date);
    }

    PlaceReference place = fact.getPlace();
    if (place != null) {
      visitPlaceReference(place);
    }
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
    visitConclusion(name);
    List<NameForm> forms = name.getNameForms();
    if (forms != null) {
      for (NameForm form : forms) {
        visitNameForm(form);
      }
    }
  }

  @Override
  public void visitNameForm(NameForm form) {
    List<NamePart> parts = form.getParts();
    if (parts != null) {
      for (NamePart part : parts) {
        visitNamePart(part);
      }
    }
  }

  @Override
  public void visitNamePart(NamePart part) {
    //no-op...
  }

  @Override
  public void visitGender(Gender gender) {
    visitConclusion(gender);
  }

  @Override
  public void visitSourceReference(SourceReference sourceReference) {
    //no-op
  }

  @Override
  public void visitNote(Note note) {
    //no-op.
  }

}
