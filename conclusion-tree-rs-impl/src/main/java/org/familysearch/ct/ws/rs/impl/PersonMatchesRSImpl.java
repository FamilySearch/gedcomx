package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.core.InjectParam;
import org.familysearch.ct.ws.service.api.EntityBundle;
import org.familysearch.ct.ws.service.api.PersonService;
import org.gedcomx.atom.AtomModel;
import org.gedcomx.atom.Entry;
import org.gedcomx.atom.Feed;
import org.gedcomx.atom.Link;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonMatchesRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonRSDefinition;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@Path ( "/persons/{id}/matches" )
@Produces ( { AtomModel.ATOM_XML_MEDIA_TYPE, AtomModel.ATOM_GEDCOMX_JSON_MEDIA_TYPE })
public class PersonMatchesRSImpl implements PersonMatchesRSDefinition {
  
  @InjectParam
  private PersonService personService;

  @Context
  private Request request;

  @Override
  @GET
  public Response readPersonMatches(@Context UriInfo uriInfo) {
    String id = uriInfo.getPathParameters().getFirst("id");
    if (id == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    else {
      EntityBundle<Feed> matchResult = this.personService.getPersonMatches(id);
      if (matchResult == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
      }
      else {
        Date lastModified = matchResult.getLastModified();
        Response.ResponseBuilder notModified = lastModified != null ? this.request.evaluatePreconditions(lastModified) : null;
        if (notModified != null) {
          return notModified.build();
        }
        else {
          Feed matches = matchResult.getEntity();
          addLinks(matches, id, uriInfo);
          return Response.ok(matches).lastModified(lastModified).build();
        }
      }
    }
  }

  private void addLinks(Feed matches, String id, UriInfo uriInfo) {
    ArrayList<Link> links = new ArrayList<Link>();
    links.add(new Link("self", URI.create(uriInfo.getAbsolutePath().getPath())));
    links.add(new Link(PersonRSDefinition.REL, URI.create(uriInfo.getBaseUriBuilder().path(PersonRSImpl.class).build(id).getPath())));
    matches.setLinks(links);

    List<Entry> entries = matches.getEntries();
    if (entries != null) {
      for (Entry entry : entries) {
        Person person = entry.findExtensionOfType(Person.class);
        id = person.getId();
        List<Link> entryLinks = new ArrayList<Link>();
        entryLinks.add(new Link(PersonRSDefinition.REL, URI.create(uriInfo.getBaseUriBuilder().path(PersonRSImpl.class).build(id).getPath())));
        entry.setLinks(entryLinks);
      }
    }
  }

}
