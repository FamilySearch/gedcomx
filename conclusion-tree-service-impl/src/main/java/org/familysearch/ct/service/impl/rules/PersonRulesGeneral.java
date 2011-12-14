package org.familysearch.ct.service.impl.rules;

import org.familysearch.ct.service.api.person.Person;

/**
 * The <code>PersonRulesGeneral</code> is a collection of general business rules
 * for <code>Person</code> entities.
 *
 * @author Rob Lyon
 */
public class PersonRulesGeneral extends RuleSet<Person> {

  public PersonRulesGeneral() {
    super(
      new PersonRuleFacts(),
      new PersonRuleMinimum()
    );
  }

  @Override
  public String getName() {
    return "Person General Rules";
  }

  @Override
  public String getDescription() {
    return "A collection of general business rules for Person entities.";
  }

  @Override
  public RuleCodes getCode() {
    return RuleCodes.Person;
  }

  /**
   * The <code>PersonRuleFacts</code> is a business rule that validates
   * the <code>Fact</code> conclusions of the <code>Person</code> entity.
   *
   * @author Rob Lyon
   */
  static private class PersonRuleFacts implements Rule<Person> {

    @Override
    public void validate(Person person) {
    }

    @Override
    public String getName() {
      return "Person Facts Rule";
    }

    @Override
    public String getDescription() {
      return "A business rule that validates the Fact conclusions of the Person entity.";
    }

    @Override
    public RuleCodes getCode() {
      return RuleCodes.Fact;
    }

  }

  /**
   * The <code>PersonRuleMinimum</code> is a business rule that validates
   * the minimum requirements for a <code>Person</code> entity.
   *
   * @author Rob Lyon
   */
  static private class PersonRuleMinimum implements Rule<Person> {

    @Override
    public void validate(Person person) {
    }

    @Override
    public String getName() {
      return "Person Minimum Rule";
    }

    @Override
    public String getDescription() {
      return "A business rule that validates the minimum requirements for a Person entity.";
    }

    @Override
    public RuleCodes getCode() {
      return RuleCodes.Person_Composition;
    }

  }

}
