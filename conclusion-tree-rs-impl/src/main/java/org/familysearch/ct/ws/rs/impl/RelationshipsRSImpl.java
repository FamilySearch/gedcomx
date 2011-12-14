package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.conclusion.Relationship;
import org.gedcomx.conclusion.rs.definition.RelationshipsRSDefinition;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
@Path("/relationships")
public class RelationshipsRSImpl implements RelationshipsRSDefinition {

    @POST
    @Override
    public Response createRelationship(@Context UriInfo uriInfo, Relationship relationship) {
        return null;
    }

    public void setProofStatement(String proofStatement) {

    }
}