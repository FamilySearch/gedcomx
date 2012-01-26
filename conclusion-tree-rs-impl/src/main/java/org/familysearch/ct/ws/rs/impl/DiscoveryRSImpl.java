package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.common.URI;
import org.gedcomx.conclusion.rs.definition.DiscoveryRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonsRSDefinition;
import org.gedcomx.xrd.Link;
import org.gedcomx.xrd.Title;
import org.gedcomx.xrd.XRD;
import org.gedcomx.xrd.XRDModel;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Mike Gardiner
 */
@Path ( "/discovery" )
@Produces ( XRDModel.XRD_V1_XML_MEDIA_TYPE )
public class DiscoveryRSImpl implements DiscoveryRSDefinition {
  
  @Context
  private UriInfo uriInfo;
  @Context
  private Request request;
  private static final Date STARTUP_DATE = Calendar.getInstance().getTime();

  @Override
  @GET
  public Response readHostMetadata() {
    Response.ResponseBuilder notModified  = request.evaluatePreconditions(STARTUP_DATE);
    if (notModified != null) {
      return notModified.build();
    }
    else {
      return Response.ok(buildXRD()).lastModified(STARTUP_DATE).build();
    }
  }

  @Override
  public void setProofStatement(String proofStatement) {
    //proof statement needed here?
  }

  protected XRD buildXRD() {
    XRD xrd = new XRD();
    xrd.setLinks(new ArrayList<Link>());

    // Persons Link
    Link personsLink = new Link();
    personsLink.setRel(URI.create(PersonsRSDefinition.REL));
    personsLink.setHref(URI.create(this.uriInfo.getBaseUriBuilder().path(PersonsRSImpl.class).build().getPath()));
    Title personsTitle = new Title();
    personsTitle.setValue("Persons");
    personsLink.getTitles().add(personsTitle);
    xrd.getLinks().add(personsLink);

    return xrd;
  }
}
