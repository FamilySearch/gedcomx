package org.familysearch.ct.ws.rs.binding;

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
public interface RelationshipRSBinding extends RelationshipRSDefinition {

  @GET
  @Override
  Response readRelationship(@Context UriInfo uriInfo);

  @PUT
  @Override
  void updateRelationship(@Context UriInfo uriInfo, Relationship relationship);

  @DELETE
  @Override
  void deleteRelationship(@Context UriInfo uriInfo);

  @Path("/conclusions")
  ConclusionsRSBinding getConclusionsResource();

  @Path("/conclusions/{cid}")
  ConclusionRSBinding getConclusionResource();
}