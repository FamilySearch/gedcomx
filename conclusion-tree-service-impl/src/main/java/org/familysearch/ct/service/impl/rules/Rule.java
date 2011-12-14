package org.familysearch.ct.service.impl.rules;

/**
 * The <code>Rule</code> interface should be implemented by any
 * class whose instances are intended to implement business rules.
 *
 * @author Rob Lyon
 */
public interface Rule<T> {

  /**
   * Validate the object with this business rule.
   *
   * @param object the object to be validated.
   */
  void validate(T object);

  /**
   * The name of the rule.
   *
   * @return the name of the rule.
   */
  String getName();

  /**
   * The description of the rule.
   *
   * @return the description of the rule.
   */
  String getDescription();

  /**
   * The code of the rule.
   *
   * @return the code of the rule.
   */
  RuleCodes getCode();

}
