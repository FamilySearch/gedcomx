package org.familysearch.ct.service.impl.rules;

import org.familysearch.ct.service.api.person.PersonFact;

/**
 * The <code>PersonFactRulesGeneral</code> is a collection of all business rules
 * for <code>Fact</code> conclusions.
 *
 * @author Rob Lyon
 */
public class PersonFactRules extends RuleSet<PersonFact> {

  public PersonFactRules() {
    super(
      new PersonFactRulesGeneral()
    );
  }

  @Override
  public String getName() {
    return "Person Fact Rules";
  }

  @Override
  public String getDescription() {
    return "A collection of all business rules for person fact conclusions.";
  }

  @Override
  public RuleCodes getCode() {
    return RuleCodes.Fact;
  }

}
