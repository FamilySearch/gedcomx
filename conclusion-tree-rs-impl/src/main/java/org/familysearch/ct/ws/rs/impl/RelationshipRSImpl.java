package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.conclusion.Relationship;
import org.gedcomx.conclusion.rs.definition.RelationshipRSDefinition;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
@Path ("/relationships/{rid}")
public class RelationshipRSImpl implements RelationshipRSDefinition {

  @GET
  @Override
  public Response readRelationship(@Context UriInfo uriInfo) {
    return null;
  }

  @PUT
  @Override
  public void updateRelationship(@Context UriInfo uriInfo, Relationship relationship) {

  }

  @DELETE
  @Override
  public void deleteRelationship(@Context UriInfo uriInfo) {

  }

  @Path("/conclusions")
  public ConclusionsRSImpl getConclusionsResource() {
    return new ConclusionsRSImpl();
  }

  @Path("/conclusions/{cid}")
  public ConclusionRSImpl getConclusionResource() {
     return new ConclusionRSImpl();
  }

  public void setProofStatement(String proofStatement) {

  }
}