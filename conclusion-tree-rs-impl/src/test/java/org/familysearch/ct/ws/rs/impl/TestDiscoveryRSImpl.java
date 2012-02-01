package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientResponse;
import org.familysearch.ct.ws.service.api.DiscoveryService;
import org.gedcomx.common.URI;
import org.gedcomx.xrd.Link;
import org.gedcomx.xrd.XRD;
import org.gedcomx.xrd.XRDModel;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDiscoveryRSImpl extends ConclusionTreeUseCaseTest {
  public static final String DISCOVERY_PATH = "/discovery";

  @Test
  public void testGet() throws Exception {
    createUseCase("Discovery")
      .withDescription("How to get the discovery resource.")
      .applicableTo(DiscoveryRSImpl.class);

    DiscoveryService discoveryService = getServerSideMock(DiscoveryService.class);
    List<Link> authLinks = new ArrayList<Link>();
    Link authLink = new Link();
    authLink.setHref(URI.create("http://10.72.51.31:8080/identity/v2/login"));
    authLink.setRel(URI.create("Identity"));
    authLinks.add(authLink);
    expect(discoveryService.getAuthLinks()).andReturn(authLinks);
    expect(discoveryService.getSessionId()).andReturn(null);
    replay(discoveryService);

    ClientResponse response = resource().path(DISCOVERY_PATH).accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    verify(discoveryService);
    reset(discoveryService);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

    Date lastModified = response.getLastModified();
    assertNotNull(lastModified);
    XRD xrd = response.getEntity(XRD.class);
    assertEquals(1, xrd.getLinks().size());
    assertEquals("Identity", xrd.getLinks().get(0).getRel().toString());

    createUseCase("Caching The Discovery")
      .withDescription("How the caching mechanism works on the discovery resource.")
      .applicableTo(DiscoveryRSImpl.class);
    Date later = new Date(lastModified.getTime() + (1000 * 60 * 60)); //one hour later
    expect(discoveryService.getAuthLinks()).andReturn(authLinks);
    replay(discoveryService);
    response = resource().path(DISCOVERY_PATH).accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).header("If-Modified-Since", later).get(ClientResponse.class);
    assertEquals(Response.Status.NOT_MODIFIED.getStatusCode(), response.getStatus());
  }
}