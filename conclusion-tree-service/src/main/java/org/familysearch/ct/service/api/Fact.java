package org.familysearch.ct.service.api;

/**
 * @author Rob Lyon
 */
public interface Fact extends Conclusion {

  public FactDate getDate();

  public FactPlace getPlace();

  public String getValue();

}
