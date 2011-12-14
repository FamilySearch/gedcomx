package org.familysearch.ct.service.impl.rules;

/**
 * The <code>RuleValidateable</code> interface should be implemented by any
 * class whose instances are validated by business rules.
 *
 * @author Rob Lyon
 */
public interface RuleValidateable {

  /**
   * Validate the object with the associated business rules.
   */
  void validate();

}
