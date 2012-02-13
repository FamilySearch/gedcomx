package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.core.InjectParam;
import org.familysearch.ct.ws.service.api.EntityBundle;
import org.familysearch.ct.ws.service.api.PersonService;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.ConclusionModel;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonSummaryRSDefinition;
import org.gedcomx.atom.Link;

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
public class PersonSummaryRSImpl extends RSImplBase implements PersonSummaryRSDefinition {

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
      EntityBundle<Person> summaryEntity = this.personService.getPersonSummary(id);
      if (summaryEntity == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
      }
      else {
        Date lastModified = summaryEntity.getLastModified();
        Response.ResponseBuilder notModified = lastModified != null ? this.request.evaluatePreconditions(lastModified) : null;
        if (notModified != null) {
          return notModified.build();
        }
        else {
          Person summary = summaryEntity.getEntity();
          summary.addExtensionElement(new Link("self", URI.create(getAbsolutePathLinkBuilder(uriInfo).build().getPath())));
          summary.addExtensionElement(new Link(PersonRSDefinition.REL, URI.create(getBaseLinkBuilder(uriInfo).path(PersonRSImpl.class).build(id).getPath())));
          return Response.ok(summary).lastModified(lastModified).build();
        }
      }
    }
  }

}
