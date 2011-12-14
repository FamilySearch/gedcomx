package org.familysearch.ct.service.impl.rules;

import org.familysearch.ct.service.api.person.Person;

/**
 * The <code>PersonRulesGeneral</code> is a collection of all business rules
 * for <code>Person</code> entities.
 *
 * @author Rob Lyon
 */
public class PersonRules extends RuleSet<Person> {

  public PersonRules() {
    super(
      new PersonRulesGeneral()
    );
  }

  @Override
  public String getName() {
    return "Person Rules";
  }

  @Override
  public String getDescription() {
    return "A collection of all business rules for Person entities.";
  }

  @Override
  public RuleCodes getCode() {
    return RuleCodes.Person;
  }

}
