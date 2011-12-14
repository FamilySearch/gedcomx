package org.familysearch.ct.ws.rs.impl;

import org.familysearch.ct.service.impl.person.PersonImpl;
import org.gedcomx.conclusion.Person;

/**
 * @author Randy Bliss
 */
public class PersonMapper {
  public Person toResource(org.familysearch.ct.service.api.person.Person person) {
    return new Person();
  }

  public org.familysearch.ct.service.api.person.Person fromResource(Person person) {
    return new PersonImpl();
  }
}
