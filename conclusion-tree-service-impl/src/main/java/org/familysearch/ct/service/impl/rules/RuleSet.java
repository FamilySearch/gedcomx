package org.familysearch.ct.service.impl.rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The <code>RuleSet</code> is a collection of general business rules.
 *
 * @author Rob Lyon
 */
public abstract class RuleSet<T> implements Rule<T> {

  final List<Rule<T>> rules;

  protected RuleSet(Rule<T>... rules) {
    if (rules == null) {
      throw new IllegalArgumentException("RuleSet requires a non-null list of rules.");
    }
    this.rules = new ArrayList<Rule<T>>(Arrays.asList(rules));
  }

  @Override
  public void validate(T entity) {
    for (Rule<T> rule : rules) {
      rule.validate(entity);
    }
  }

}
