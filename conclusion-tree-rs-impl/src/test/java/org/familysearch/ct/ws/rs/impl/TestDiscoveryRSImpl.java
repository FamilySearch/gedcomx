package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientResponse;
import org.familysearch.ct.ws.service.api.DiscoveryService;
import org.familysearch.ct.ws.service.api.EntityBundle;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonSummaryRSDefinition;
import org.gedcomx.conclusion.rs.definition.PersonsRSDefinition;
import org.gedcomx.conclusion.rs.definition.SearchRSDefinition;
import org.gedcomx.xrd.Link;
import org.gedcomx.xrd.XRD;
import org.gedcomx.xrd.XRDModel;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.*;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class TestDiscoveryRSImpl extends ConclusionTreeUseCaseTest {
  public static final String DISCOVERY_PATH = "/discovery";

  @Test
  public void testGetUnauthenticated() throws Exception {
    createUseCase("Discovery (Unauthenticated)")
      .withDescription("An unauthenticated request for the discovery resource.")
      .applicableTo(DiscoveryRSImpl.class);

    long timestamp = System.currentTimeMillis();
    Date now = new Date(timestamp - (timestamp % 1000));
    DiscoveryService discoveryService = getServerSideMock(DiscoveryService.class);
    List<Link> authLinks = new ArrayList<Link>();
    Link authLink = new Link();
    authLink.setHref(URI.create("http://10.72.51.31:8080/identity/v2/login"));
    authLink.setRel(URI.create("Identity"));
    authLinks.add(authLink);
    EntityBundle linksBundle = createMock(EntityBundle.class);
    expect(discoveryService.getAuthenticatedPerson()).andReturn(null);
    expect(discoveryService.getAuthLinks()).andReturn(linksBundle);
    expect(linksBundle.getLastModified()).andReturn(now);
    expect(linksBundle.getEntity()).andReturn(authLinks);
    replay(discoveryService, linksBundle);

    ClientResponse response = resource().path(DISCOVERY_PATH).accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    verify(discoveryService, linksBundle);
    reset(discoveryService, linksBundle);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    Date lastModified = response.getLastModified();
    assertEquals(now.getTime(), lastModified.getTime());
    XRD xrd = response.getEntity(XRD.class);
    assertEquals(1, xrd.getLinks().size());
    assertEquals("Identity", xrd.getLinks().get(0).getRel().toString());

    createUseCase("Caching The Discovery")
      .withDescription("How the caching mechanism works on the discovery resource.")
      .applicableTo(DiscoveryRSImpl.class);
    Date later = new Date(lastModified.getTime() + (1000 * 60 * 60)); //one hour later
    expect(discoveryService.getAuthenticatedPerson()).andReturn(null);
    expect(discoveryService.getAuthLinks()).andReturn(linksBundle);
    expect(linksBundle.getLastModified()).andReturn(now);
    replay(discoveryService, linksBundle);
    response = resource().path(DISCOVERY_PATH).accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).header("If-Modified-Since", later).get(ClientResponse.class);
    assertEquals(Response.Status.NOT_MODIFIED.getStatusCode(), response.getStatus());
    verify(discoveryService, linksBundle);
    reset(discoveryService, linksBundle);
  }

  @Test
  public void testGetAuthenticated() throws Exception {
    createUseCase("Discovery (Authenticated)")
      .withDescription("An authenticated request for the discovery resource.")
      .applicableTo(DiscoveryRSImpl.class);

    long timestamp = System.currentTimeMillis();
    Date now = new Date(timestamp - (timestamp % 1000));
    Date earlier = new Date(timestamp - (timestamp % 1000) - 10000);
    DiscoveryService discoveryService = getServerSideMock(DiscoveryService.class);
    List<Link> authLinks = new ArrayList<Link>();
    Link authLink = new Link();
    authLink.setHref(URI.create("http://10.72.51.31:8080/identity/v2/login"));
    authLink.setRel(URI.create("Identity"));
    authLinks.add(authLink);
    EntityBundle linksBundle = createMock(EntityBundle.class);
    EntityBundle authPersonBundle = createMock(EntityBundle.class);
    expect(discoveryService.getAuthenticatedPerson()).andReturn(authPersonBundle);
    expect(discoveryService.getAuthLinks()).andReturn(linksBundle);
    expect(authPersonBundle.getLastModified()).andReturn(now);
    expect(linksBundle.getLastModified()).andReturn(earlier);
    Person authPerson = new Person();
    authPerson.setId("12345");
    expect(authPersonBundle.getEntity()).andReturn(authPerson);
    expect(linksBundle.getEntity()).andReturn(authLinks);
    replay(discoveryService, linksBundle, authPersonBundle);

    ClientResponse response = resource().path(DISCOVERY_PATH).queryParam("access_token", "abcdefg").accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    verify(discoveryService, linksBundle, authPersonBundle);
    reset(discoveryService, linksBundle, authPersonBundle);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    Date lastModified = response.getLastModified();
    assertEquals(now.getTime(), lastModified.getTime());
    XRD xrd = response.getEntity(XRD.class);
    assertFalse(xrd.getLinks().isEmpty());
    Set<String> linkRels = new TreeSet<String>(Arrays.asList("Identity", SearchRSDefinition.REL, PersonsRSDefinition.REL, PersonSummaryRSDefinition.REL));
    for (Link link : xrd.getLinks()) {
      assertTrue(linkRels.remove(link.getRel().toString()));
      if (SearchRSDefinition.REL.equals(link.getRel().toString())) {
        assertTrue(link.getTemplate().contains("access_token"));
      }
      else if (PersonSummaryRSDefinition.REL.equals(link.getRel().toString())) {
        assertTrue(link.getHref().toString().contains("access_token"));
      }
    }
    assertTrue(linkRels.isEmpty());
  }
}