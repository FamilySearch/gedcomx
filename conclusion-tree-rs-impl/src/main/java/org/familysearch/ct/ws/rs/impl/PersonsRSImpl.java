package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonsRSDefinition;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
@Path("/persons")
public class PersonsRSImpl extends RSImplBase implements PersonsRSDefinition {

    public PersonsRSImpl() {
        super();
    }

    @POST
    @Override
    public Response createPerson(@Context UriInfo uriInfo, Person person) {
        return null;
    }
}
