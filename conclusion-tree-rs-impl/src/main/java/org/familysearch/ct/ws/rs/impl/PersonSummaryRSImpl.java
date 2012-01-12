package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.core.InjectParam;
import org.familysearch.ct.service.api.person.PersonService;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.ConclusionModel;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonSummaryRSDefinition;
import org.gedcomx.rs.Link;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Date;

/**
 * @author Ryan Heaton
 */
@Path ( "/persons/{id}/summary" )
@Produces ( { ConclusionModel.GEDCOMX_CONCLUSION_V1_XML_MEDIA_TYPE, ConclusionModel.GEDCOMX_CONCLUSION_V1_JSON_MEDIA_TYPE })
public class PersonSummaryRSImpl implements PersonSummaryRSDefinition {

  @InjectParam
  private PersonService personService;

  @Context
  private Request request;

  @Override
  @GET
  public Response readPersonSummary(@Context UriInfo uriInfo) {
    String id = uriInfo.getPathParameters().getFirst("id");
    if (id == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    else {
      Date lastModified = this.personService.getSummaryLastModified(id);
      if (lastModified == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
      }
      else {
        Response.ResponseBuilder notModified = this.request.evaluatePreconditions(lastModified);
        if (notModified != null) {
          return notModified.build();
        }
        else {
          Person summary = this.personService.getSummary(id);
          summary.addExtensionElement(new Link("self", URI.create(uriInfo.getAbsolutePath().getPath())));
          summary.addExtensionElement(new Link(PersonRSDefinition.REL, URI.create(uriInfo.getBaseUriBuilder().path(PersonRSImpl.class).build(id).getPath())));
          return Response.ok(summary).lastModified(lastModified).build();
        }
      }
    }
  }

  @Override
  public void setProofStatement(String proofStatement) {
  }
}
