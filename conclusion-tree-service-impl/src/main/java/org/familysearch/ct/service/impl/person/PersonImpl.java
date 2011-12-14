package org.familysearch.ct.service.impl.person;

import org.familysearch.ct.service.api.EntityId;
import org.familysearch.ct.service.api.person.Person;
import org.familysearch.ct.service.api.person.PersonId;
import org.familysearch.ct.service.impl.rules.PersonRules;
import org.familysearch.ct.service.impl.rules.RuleValidateable;

/**
 * @author Rob Lyon
 */
public class PersonImpl implements Person, RuleValidateable {

  static final PersonRules rules = new PersonRules();

  public PersonId getPersonId() {
    return null;
  }

  public EntityId getEntityId() {
    return getPersonId();
  }

  @Override
  public void validate() {
    rules.validate(this);
  }

}
