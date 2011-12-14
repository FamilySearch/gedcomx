package org.familysearch.ct.service.impl.rules;

/**
 * A failure of an object to be validated by associated business rules.
 *
 * @author Rob Lyon
 */
public class RuleException extends RuntimeException {

  private final Rule rule;

  public RuleException(Rule rule, String message) {
    this(rule, message, null);
  }

  public RuleException(Rule rule, String message, Throwable cause) {
    super(String.format("[%s:%s] %s (%s)", rule.getName(), rule.getCode().getCode(), rule.getDescription(), message), cause);
    this.rule = rule;
  }

  public Rule getRule() {
    return rule;
  }

}
