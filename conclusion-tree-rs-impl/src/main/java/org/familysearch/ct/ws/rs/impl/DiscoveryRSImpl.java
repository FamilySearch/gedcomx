package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.core.InjectParam;
import org.familysearch.ct.ws.service.api.DiscoveryService;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.rs.definition.DiscoveryRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonSummaryRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonsRSDefinition;
import org.gedcomx.xrd.Link;
import org.gedcomx.xrd.Title;
import org.gedcomx.xrd.XRD;
import org.gedcomx.xrd.XRDModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Mike Gardiner
 */
@Path ( "/discovery" )
@Produces ( XRDModel.XRD_V1_XML_MEDIA_TYPE )
public class DiscoveryRSImpl implements DiscoveryRSDefinition {

  @Context
  private Request request;

  @Context
  UriInfo uriInfo;

  private static final Date STARTUP_DATE = Calendar.getInstance().getTime();
  @InjectParam
  DiscoveryService discoveryService;

  @Override
  @GET
  public Response readHostMetadata() {

      Response.ResponseBuilder notModified  = request.evaluatePreconditions(STARTUP_DATE);

      if (notModified != null) {
        return notModified.build();
      }
      else {
        XRD xrd = new XRD();
        xrd.setLinks(new ArrayList<Link>());

        // Add Links
        String sessionId = discoveryService.getSessionId();
        
        if(sessionId != null) {
          xrd.getLinks().add(buildPersonSummaryLink(sessionId));
          xrd.getLinks().add(buildPersonsLink(sessionId));  
        }
        else {
          List<Link> authLinks = discoveryService.getAuthLinks();
          if (authLinks != null) {
            for (Link link : authLinks) {
              xrd.getLinks().add(link);
            }
          }  
        }

        return Response.ok(xrd).lastModified(STARTUP_DATE).build();
      }
  }

  /**
   * Build the persons link
   * @param sessionId A valid session id
   * @return The persons link
   */
  private Link buildPersonsLink(String sessionId) {
    Link link = new Link();
    link.setRel(URI.create(PersonsRSDefinition.REL));

    link.setHref(URI.create(this.uriInfo.getBaseUriBuilder().
        path(PersonsRSImpl.class).
        queryParam("sessionId", sessionId).
        build().toString()));

    Title title = new Title();
    title.setValue("Persons");
    link.getTitles().add(title);

    return link;
  }

  /**
   * Build the person summary link
   * @param sessionId A valid session if
   * @return Person summary link
   */
  private Link buildPersonSummaryLink(String sessionId) {
    Link link = new Link();
    link.setRel(URI.create(PersonSummaryRSDefinition.REL));

    link.setHref(URI.create(this.uriInfo.getBaseUriBuilder().
      path(PersonSummaryRSImpl.class).
      queryParam("sessionId", sessionId).
      build().toString()));

    Title title = new Title();
    title.setValue("Person Summary");
    link.getTitles().add(title);

    return link;
  }

  @Override
  public void setProofStatement(String proofStatement) {
    //proof statement needed here?
  }
}
