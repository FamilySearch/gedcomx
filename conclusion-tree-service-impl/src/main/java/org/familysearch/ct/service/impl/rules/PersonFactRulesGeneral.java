package org.familysearch.ct.service.impl.rules;

import org.familysearch.ct.service.api.person.PersonFact;
import org.familysearch.ct.service.api.person.PersonFactType;

/**
 * The <code>PersonFactRulesGeneral</code> is a collection of general business rules
 * for <code>Fact</code> conclusions.
 *
 * @author Rob Lyon
 */
public class PersonFactRulesGeneral extends RuleSet<PersonFact> {

  public PersonFactRulesGeneral() {
    super(
      new ConclusionRulesGeneral<PersonFact>(),
      new PersonFactRuleTypeComposition(),
      new PersonFactRuleTypeCardinality()
    );
  }

  @Override
  public String getName() {
    return "Person Fact General Rules";
  }

  @Override
  public String getDescription() {
    return "A collection of general business rules for person fact conclusions.";
  }

  @Override
  public RuleCodes getCode() {
    return RuleCodes.Fact;
  }

  /**
   * The <code>PersonFactRuleTypeComposition</code> is a business rule that validates
   * the fields of a <code>Fact</code> conclusion per the type specification.
   *
   * @author Rob Lyon
   */
  static private class PersonFactRuleTypeComposition implements Rule<PersonFact> {

    @Override
    public void validate(PersonFact fact) {
      PersonFactType type = fact.getCanonicalType();
      switch (type) {
        // these fact types are not allowed to have a value field
        case Birth:
        case Death:
        case Christening:
        case Burial:
        case BarMitzvah:
        case BatMitzvah:
        case Cremation:
          if (fact.getValue() != null) {
            throw new RuleException(this, String.format("The value field is not allowed on the person fact %s type.", type));
          }
          break;

        // these fact types are not allowed to have date or place fields
        case Stillborn:
        case Caste_Name:
        case Clan_Name:
        case National_ID:
        case National_Origin:
        case Physical_Description:
        case Race:
        case Tribe_Name:
          if (fact.getDate() != null) {
            throw new RuleException(this, String.format("The date field is not allowed on the person fact %s type.", type));
          }
          if (fact.getPlace() != null) {
            throw new RuleException(this, String.format("The place field is not allowed on the person fact %s type.", type));
          }
          break;

        // all other fact types do not have restrictions on the fields
      }
    }

    @Override
    public String getName() {
      return "Fact Type Composition Rule";
    }

    @Override
    public String getDescription() {
      return "A business rule that validates the fields of a Fact conclusion per the type specification.";
    }

    @Override
    public RuleCodes getCode() {
      return RuleCodes.Fact_Composition;
    }

  }

  /**
   * The <code>PersonFactRuleTypeCardinality</code> is a business rule that validates
   * the cardinality of a <code>Fact</code> conclusion per the type specification.
   *
   * @author Rob Lyon
   */
  static private class PersonFactRuleTypeCardinality implements Rule<PersonFact> {

    @Override
    public void validate(PersonFact fact) {
    }

    @Override
    public String getName() {
      return "Fact Type Cardinality Rule";
    }

    @Override
    public String getDescription() {
      return "A business rule that validates the cardinality of a Fact conclusion per the type specification.";
    }

    @Override
    public RuleCodes getCode() {
      return RuleCodes.Fact_Cardinality;
    }

  }

}
