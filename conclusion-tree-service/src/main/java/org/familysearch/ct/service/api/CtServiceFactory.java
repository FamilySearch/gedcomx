package org.familysearch.ct.service.api;

import org.familysearch.ct.service.api.person.PersonService;

/**
 * @author Randy Bliss
 */
public interface CtServiceFactory {
  public PersonService getPersonService();
}
