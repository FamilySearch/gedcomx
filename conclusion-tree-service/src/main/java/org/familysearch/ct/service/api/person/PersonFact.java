package org.familysearch.ct.service.api.person;

import org.familysearch.ct.service.api.Fact;

/**
 * @author Rob Lyon
 */
public interface PersonFact extends Fact {

  public PersonFactType getCanonicalType();

}
