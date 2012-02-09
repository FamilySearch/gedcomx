package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.core.InjectParam;
import org.familysearch.ct.ws.service.api.InsufficientQueryException;
import org.familysearch.ct.ws.service.api.PersonService;
import org.familysearch.ct.ws.service.api.SearchParameter;
import org.gedcomx.atom.AtomModel;
import org.gedcomx.atom.Entry;
import org.gedcomx.atom.Feed;
import org.gedcomx.atom.Link;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonRSDefinition;
import org.gedcomx.conclusion.rs.definition.SearchRSDefinition;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.*;

/**
 * <h3>Extensions and Refinements</h3>
 *
 * <p>The binding of the search resource to the FamilySearch conclusion tree accepts the search parameters defined above as query parameters on the URL. The
 * "<tt>parent</tt>" relation query parameters are not supported in this binding, so queries must specify either "<tt>father</tt>" or "<tt>mother</tt>". This
 * binding also supports the following nonstandard parameters:</p>
 *
 * <table>
 *   <tr>
 *     <th>variable</th>
 *     <th>description</th>
 *   </tr>
 *   <tr>
 *     <td>exactName</td>
 *     <td>The exact full name of the person (i.e. do no include similar names or names of alternate spellings in the results).</td>
 *   </tr>
 *   <tr>
 *     <td>exactGivenName</td>
 *     <td>The exact given name of the person (i.e. do no include similar given names or given names of alternate spellings in the results).</td>
 *   </tr>
 *   <tr>
 *     <td>exactFamilyName</td>
 *     <td>The exact family name of the person (i.e. do no include similar family names or family names of alternate spellings in the results).</td>
 *   </tr>
 * </table>
 * 
 * @author Ryan Heaton
 */
@Path ( "/search" )
@Produces ( { AtomModel.ATOM_XML_MEDIA_TYPE, AtomModel.ATOM_GEDCOMX_JSON_MEDIA_TYPE })
public class PersonSearchRSImpl implements SearchRSDefinition {
  
  @InjectParam
  private PersonService personService;

  @Context
  private Request request;

  @Override
  @GET
  public Response readPersonMatches(@Context UriInfo uriInfo) {
    MultivaluedMap<String,String> queryParameters = uriInfo.getQueryParameters();
    boolean match = "person-matches".equals(queryParameters.getFirst("resourceType"));
    EnumMap<SearchParameter, String> parameterMap = new EnumMap<SearchParameter, String>(SearchParameter.class);
    Map<Integer, List<String>> warnings = new TreeMap<Integer, List<String>>();
    for (Map.Entry<String, List<String>> queryParam : queryParameters.entrySet()) {
      SearchParameter param;
      try {
        param = SearchParameter.valueOf(queryParam.getKey());
      }
      catch (IllegalArgumentException e) {
        addWarning(warnings, 299, "Unsupported parameter: %s", queryParam.getKey());
        continue;
      }

      List<String> values = queryParam.getValue();
      if (values.isEmpty()) {
        addWarning(warnings, 299, "Empty value supplied for parameter %s. The parameter is ignored.", queryParam.getKey());
        continue;
      }
      else if (values.size() > 1) {
        addWarning(warnings, 299, "Multiple values supplied for parameter %s. Only the first is relevant.", queryParam.getKey());
      }

      parameterMap.put(param, values.get(0));
    }

    Feed results;
    try {
      results = match ? this.personService.searchForPersonMatches(parameterMap) : this.personService.searchForPersons(parameterMap);
    }
    catch (InsufficientQueryException e) {
      Response.ResponseBuilder res = Response.status(413);
      appendWarnings(res, warnings);
      return res.build();
    }

    if (results == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    else {
      addLinks(results, uriInfo);
      Response.ResponseBuilder res = results.getEntries() == null || results.getEntries().isEmpty() ? Response.noContent() : Response.ok(results);
      appendWarnings(res, warnings);
      return res.build();
    }
  }

  private void appendWarnings(Response.ResponseBuilder res, Map<Integer, List<String>> warnings) {
    for (Map.Entry<Integer, List<String>> warningSet : warnings.entrySet()) {
      for (String message : warningSet.getValue()) {
        res.header("Warning", String.format("%s FamilySearch \"%s\"", warningSet.getKey(), message));
      }
    }
  }

  private void addWarning(Map<Integer, List<String>> bucket, int code, String message, Object... messageArgs) {
    List<String> messages = bucket.get(code);
    if (messages == null) {
      messages = new ArrayList<String>();
      bucket.put(code, messages);
    }
    messages.add(String.format(message, messageArgs));
  }

  private void addLinks(Feed matches, UriInfo uriInfo) {
    List<Entry> entries = matches.getEntries();
    if (entries != null) {
      for (Entry entry : entries) {
        Person person = entry.findExtensionOfType(Person.class);
        String id = person.getId();
        List<Link> entryLinks = new ArrayList<Link>();
        entryLinks.add(new Link(PersonRSDefinition.REL, URI.create(uriInfo.getBaseUriBuilder().path(PersonRSImpl.class).build(id).getPath())));
        entry.setLinks(entryLinks);
      }
    }
  }

}
