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
public class PersonsRSImpl extends RSBase implements PersonsRSDefinition {
    private PersonMapper mapper = new PersonMapper();

    public PersonsRSImpl() {
        super();
    }

    @POST
    @Override
    public Response createPerson(@Context UriInfo uriInfo, Person person) {
        String personId = getPersonService().createPerson(mapper.fromResource(person));
        return null;
    }

    public void setProofStatement(String proofStatement) {

    }
}
