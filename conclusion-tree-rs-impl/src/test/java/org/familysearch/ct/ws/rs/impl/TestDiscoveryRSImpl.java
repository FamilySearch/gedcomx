package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientResponse;
import org.gedcomx.conclusion.rs.definition.PersonsRSDefinition;
import org.gedcomx.xrd.XRD;
import org.gedcomx.xrd.XRDModel;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDiscoveryRSImpl extends ConclusionTreeUseCaseTest {
  public static final String DISCOVERY_PATH = "/discovery";

  @Test
  public void testGet() throws Exception {
    createUseCase("Discovery")
      .withDescription("How to get the discovery resource.")
      .applicableTo(DiscoveryRSImpl.class);
    ClientResponse response = resource().path(DISCOVERY_PATH).accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    Date lastModified = response.getLastModified();
    assertNotNull(lastModified);
    XRD xrd = response.getEntity(XRD.class);
    assertEquals(1, xrd.getLinks().size());
    assertEquals(PersonsRSDefinition.REL, xrd.getLinks().get(0).getRel().toString());

    createUseCase("Caching The Discovery")
      .withDescription("How the caching mechanism works on the discovery resource.")
      .applicableTo(DiscoveryRSImpl.class);
    Date later = new Date(lastModified.getTime() + (1000 * 60 * 60)); //one hour later
    response = resource().path(DISCOVERY_PATH).accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).header("If-Modified-Since", later).get(ClientResponse.class);
    assertEquals(Response.Status.NOT_MODIFIED.getStatusCode(), response.getStatus());
  }
}