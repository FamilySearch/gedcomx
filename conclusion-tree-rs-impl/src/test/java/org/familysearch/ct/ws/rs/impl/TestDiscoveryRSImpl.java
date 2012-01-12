package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientResponse;
import org.gedcomx.xrd.XRDModel;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDiscoveryRSImpl extends ConclusionTreeUseCaseTest {

  @Test
  public void testGet() throws Exception {
    createUseCase("Discovery")
      .withDescription("How to get the discovery resource.");
    ClientResponse response = resource().path("/.well-known/host-meta").accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    Date lastModified = response.getLastModified();
    assertNotNull(lastModified);
    Date later = new Date(lastModified.getTime() + (1000 * 60 * 60)); //one hour later

    createUseCase("Caching The Discovery")
      .withDescription("How the caching mechanism works on the discovery resource.");
    response = resource().path("/.well-known/host-meta").accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).header("If-Modified-Since", later).get(ClientResponse.class);
    assertEquals(Response.Status.NOT_MODIFIED.getStatusCode(), response.getStatus());


  }

}