package org.familysearch.ct.ws.rs.binding;

import org.gedcomx.conclusion.Conclusion;
import org.gedcomx.conclusion.rs.definition.ConclusionsRSDefinition;
import org.gedcomx.rt.rs.ResourceServiceBinding;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Randy Bliss
 */
@ResourceServiceBinding
public interface ConclusionsRSBinding extends ConclusionsRSDefinition {

  @GET
  @Override
  Response readConclusions(@Context UriInfo uriInfo);

  @POST
  @Override
  Response createConclusion(@Context UriInfo uriInfo, Conclusion conclusion);
}
