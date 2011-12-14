package org.familysearch.ct.ws.rs.impl;

import org.familysearch.ct.service.api.CtServiceFactory;
import org.familysearch.ct.service.api.person.PersonService;
import org.familysearch.ct.service.impl.CtServiceFactoryImpl;

/**
 * @author Randy Bliss
 */
public abstract class RSBase {
    private CtServiceFactory factory;

    public RSBase() {
        this.factory = new CtServiceFactoryImpl();
    }

    public PersonService getPersonService() {
        return factory.getPersonService();
    }
}
