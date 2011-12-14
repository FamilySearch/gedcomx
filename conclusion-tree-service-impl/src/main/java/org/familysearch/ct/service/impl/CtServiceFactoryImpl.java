package org.familysearch.ct.service.impl;

import org.familysearch.ct.service.api.CtServiceFactory;
import org.familysearch.ct.service.api.person.PersonService;
import org.familysearch.ct.service.impl.person.PersonServiceImpl;

/**
 * @author Randy Bliss
 */
public class CtServiceFactoryImpl implements CtServiceFactory {

  public CtServiceFactoryImpl() {}

  public PersonService getPersonService() {
    return new PersonServiceImpl();
  }
}
