package org.familysearch.ct.service.impl.person;

import org.familysearch.ct.service.api.Attribution;
import org.familysearch.ct.service.api.ConclusionId;
import org.familysearch.ct.service.api.FactDate;
import org.familysearch.ct.service.api.FactPlace;
import org.familysearch.ct.service.api.person.PersonFact;
import org.familysearch.ct.service.api.person.PersonFactType;
import org.familysearch.ct.service.impl.FactImpl;

/**
 * @author Rob Lyon
 */
public class PersonFactImpl extends FactImpl implements PersonFact {

  @Override
  public FactDate getDate() {
    return null;
  }

  @Override
  public FactPlace getPlace() {
    return null;
  }

  @Override
  public String getValue() {
    return null;
  }

  @Override
  public ConclusionId getConclusionId() {
    return null;
  }

  @Override
  public String getType() {
    return null;
  }

  @Override
  public Attribution getAttribution() {
    return null;
  }

  @Override
  public PersonFactType getCanonicalType() {
    return null;
  }
}
