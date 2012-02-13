package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.core.InjectParam;
import org.familysearch.ct.ws.service.api.DiscoveryService;
import org.familysearch.ct.ws.service.api.EntityBundle;
import org.familysearch.ct.ws.service.api.SearchParameter;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.rs.definition.DiscoveryRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonSummaryRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonsRSDefinition;
import org.gedcomx.conclusion.rs.definition.SearchRSDefinition;
import org.gedcomx.conclusion.Person;
import org.gedcomx.xrd.Link;
import org.gedcomx.xrd.Title;
import org.gedcomx.xrd.XRD;
import org.gedcomx.xrd.XRDModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.*;

/**
 * <h3>Conclusion Tree Discovery Resource</h3>
 * 
 * <p>If authentication credentials are supplied to the discovery resource, the resource will contain links to resources available to the authenticated
 * user. Otherwise, just the set of links describing the OAuth 2 authentication endpoints will be supplied.</p>
 * 
 * @author Mike Gardiner
 */
@Path ( "/discovery" )
@Produces ( XRDModel.XRD_V1_XML_MEDIA_TYPE )
public class DiscoveryRSImpl extends RSImplBase implements DiscoveryRSDefinition {

  @Context
  private Request request;

  @Context
  private UriInfo uriInfo;

  @InjectParam
  DiscoveryService discoveryService;

  @Override
  @GET
  public Response readHostMetadata() {
    EntityBundle<Person> authPersonBundle = this.discoveryService.getAuthenticatedPerson();
    EntityBundle<List<Link>> authLinksBundle = this.discoveryService.getAuthLinks();
    long lastModifiedTimestamp = 0L;
    if (authPersonBundle != null) {
      Date lastModified = authPersonBundle.getLastModified();
      if (lastModified != null) {
        lastModifiedTimestamp = Math.max(lastModifiedTimestamp, lastModified.getTime());
      }
    }

    if (authLinksBundle != null) {
      Date lastModified = authLinksBundle.getLastModified();
      if (lastModified != null) {
        lastModifiedTimestamp = Math.max(lastModifiedTimestamp, lastModified.getTime());
      }
    }

    if (lastModifiedTimestamp > 0L) {
      Response.ResponseBuilder notModified  = request.evaluatePreconditions(new Date(lastModifiedTimestamp));
      if (notModified != null) {
        return notModified.build();
      }
    }

    XRD xrd = new XRD();
    ArrayList<Link> links = new ArrayList<Link>();
    if (authPersonBundle != null) {
      links.add(buildPersonsLink());
      links.add(buildSearchLink());
      Person authPerson = authPersonBundle.getEntity();
      if (authPerson != null) {
        links.add(buildPersonSummaryLink(authPerson.getId()));
      }
    }
    if (authLinksBundle != null) {
      List<Link> authLinks = authLinksBundle.getEntity();
      if (authLinks != null) {
        links.addAll(authLinks);
      }
    }

    xrd.setLinks(links);
    Response.ResponseBuilder res = Response.ok(xrd);
    if (lastModifiedTimestamp > 0L) {
      res.lastModified(new Date(lastModifiedTimestamp));
    }
    return res.build();
  }

  /**
   * Build the link to the search resource.
   * 
   * @return The session id.
   */
  private Link buildSearchLink() {
    Link link = new Link();
    link.setRel(URI.create(SearchRSDefinition.REL));
    StringBuilder path = new StringBuilder(decorate(this.uriInfo.getBaseUriBuilder().path(PersonSearchRSImpl.class)).build().getPath());
    char queryChar = '?';
    if (path.indexOf("?") > 0) {
      queryChar = '&';
    }
    path.append('{').append(queryChar);
    path.append("resourceType,");
    Iterator<SearchParameter> paramValuesIt = Arrays.asList(SearchParameter.values()).iterator();
    while (paramValuesIt.hasNext()) {
      SearchParameter next =  paramValuesIt.next();
      path.append(next.toString());
      if (paramValuesIt.hasNext()) {
        path.append(',');
      }
    }
    path.append('}');
    link.setTemplate(path.toString());
    Title title = new Title();
    title.setValue("Person Search");
    link.getTitles().add(title);
    return link;
  }

  /**
   * Build the persons link.
   *
   * @return The persons link.
   */
  private Link buildPersonsLink() {
    Link link = new Link();
    link.setRel(URI.create(PersonsRSDefinition.REL));
    link.setHref(URI.create(decorate(this.uriInfo.getBaseUriBuilder().path(PersonsRSImpl.class)).build().getPath()));

    Title title = new Title();
    title.setValue("Persons");
    link.getTitles().add(title);

    return link;
  }

  /**
   * Build the person summary link
   *
   * @param id = Id of person
   * @return Person summary link
   */
  private Link buildPersonSummaryLink(String id) {
    Link link = new Link();
    link.setRel(URI.create(PersonSummaryRSDefinition.REL));

    UriBuilder summaryLinkBuilder = decorate(this.uriInfo.getBaseUriBuilder().path(PersonSummaryRSImpl.class));
    link.setHref(URI.create(summaryLinkBuilder.build(id).getPath()));

    Title title = new Title();
    title.setValue("Person Summary");
    link.getTitles().add(title);

    return link;
  }
}
