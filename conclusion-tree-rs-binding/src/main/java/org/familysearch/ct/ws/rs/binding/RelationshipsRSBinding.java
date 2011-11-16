package org.familysearch.ct.ws.rs.binding;

import org.gedcomx.conclusion.Relationship;
import org.gedcomx.conclusion.rs.definition.RelationshipsRSDefinition;
import org.gedcomx.rt.www.ResourceServiceBinding;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
@ResourceServiceBinding
@Path ("/relationships")
public interface RelationshipsRSBinding extends RelationshipsRSDefinition {

  @POST
  @Override
  Response createRelationship(@Context UriInfo uriInfo, Relationship relationship);
}