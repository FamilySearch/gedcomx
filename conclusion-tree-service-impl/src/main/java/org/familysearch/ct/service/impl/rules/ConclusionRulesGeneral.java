package org.familysearch.ct.service.impl.rules;

import org.familysearch.ct.service.api.Conclusion;

/**
 * The <code>ConclusionRulesGeneral</code> is a collection of general business rules
 * for all conclusions.
 *
 * @author Rob Lyon
 */
public class ConclusionRulesGeneral<T extends Conclusion> extends RuleSet<T> {

  public ConclusionRulesGeneral() {
    super(
      new ConclusionRuleComposition<T>()
    );
  }

  @Override
  public String getName() {
    return "Conclusion General Rules";
  }

  @Override
  public String getDescription() {
    return "A collection of general business rules for all conclusions.";
  }

  @Override
  public RuleCodes getCode() {
    return RuleCodes.Conclusion;
  }

  /**
   * The <code>ConclusionRuleComposition</code> is a business rule that validates
   * the fields of all conclusions.
   *
   * @author Rob Lyon
   */
  static protected class ConclusionRuleComposition<T extends Conclusion> implements Rule<T> {

    @Override
    public void validate(T conclusion) {
      if (conclusion == null) {
        throw new RuleException(this, "The conclusion is null.");
      }
//      if (conclusion.getConclusionId() == null) {
//        throw new RuleException(this, "The conclusion ID is null.");
//      }
      if (conclusion.getType() == null) {
        throw new RuleException(this, "The conclusion type is null.");
      }
//      if (conclusion.getAttribution() == null) {
//        throw new RuleException(this, "The conclusion attribution is null.");
//      }
    }

    @Override
    public String getName() {
      return "Conclusion Composition Rule";
    }

    @Override
    public String getDescription() {
      return "A business rule that validates the fields of a all conclusions.";
    }

    @Override
    public RuleCodes getCode() {
      return RuleCodes.Conclusion_Composition;
    }

  }

}
