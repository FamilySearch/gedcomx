package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.conclusion.Conclusion;
import org.gedcomx.conclusion.rs.definition.ConclusionRSDefinition;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Randy Bliss
 */
public class ConclusionRSImpl implements ConclusionRSDefinition {

  @GET
  @Override
  public Conclusion readConclusion(@Context UriInfo uriInfo) {
    return null;
  }

  @PUT
  @Override
  public void updateConclusion(@Context UriInfo uriInfo, Conclusion conclusion) {

  }

  @DELETE
  @Override
  public void deleteConclusion(@Context UriInfo uriInfo) {

  }
}
