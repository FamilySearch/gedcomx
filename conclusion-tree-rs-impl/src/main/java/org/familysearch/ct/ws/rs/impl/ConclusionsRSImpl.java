package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.conclusion.Conclusion;
import org.gedcomx.conclusion.rs.definition.ConclusionsRSDefinition;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Randy Bliss
 */
public class ConclusionsRSImpl implements ConclusionsRSDefinition {

  @GET
  @Override
  public Response readConclusions(@Context UriInfo uriInfo) {
    return null;
  }

  @POST
  @Override
  public Response createConclusion(@Context UriInfo uriInfo, Conclusion conclusion) {
    return null;
  }

  public void setProofStatement(String proofStatement) {

  }
}
