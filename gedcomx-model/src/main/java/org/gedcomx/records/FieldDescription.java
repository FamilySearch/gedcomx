package org.gedcomx.records;

/**
 * A description of a field in a record.
 *
 * @author Ryan Heaton
 */
public class FieldDescription {

  private String systemLabel;
  private String originalLabel;
  private String displayLabel;

  /**
   * The (system) label identifier for the field.
   *
   * @return The (system) label identifier for the field.
   */
  public String getSystemLabel() {
    return systemLabel;
  }

  /**
   * The (system) label identifier for the field.
   *
   * @param systemLabel The (system) label identifier for the field.
   */
  public void setSystemLabel(String systemLabel) {
    this.systemLabel = systemLabel;
  }

  /**
   * The original value of the field lable, as it appears on the record.
   *
   * @return The original value of the field lable, as it appears on the record.
   */
  public String getOriginalLabel() {
    return originalLabel;
  }

  /**
   * The original value of the field lable, as it appears on the record.
   *
   * @param originalLabel The original value of the field lable, as it appears on the record.
   */
  public void setOriginalLabel(String originalLabel) {
    this.originalLabel = originalLabel;
  }

  /**
   * The way the label of the field should be displayed, taking into account, e.g. the language of this description.
   *
   * @return The way the label of the field should be displayed, taking into account, e.g. the language of this description.
   */
  public String getDisplayLabel() {
    return displayLabel;
  }

  /**
   * The way the label of the field should be displayed, taking into account, e.g. the language of this description.
   *
   * @param displayLabel The way the label of the field should be displayed, taking into account, e.g. the language of this description.
   */
  public void setDisplayLabel(String displayLabel) {
    this.displayLabel = displayLabel;
  }
}
