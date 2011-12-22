package org.familysearch.ct.ws.rs.impl.test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import com.sun.jersey.test.framework.spi.container.inmemory.InMemoryTestContainerFactory;
import org.gedcomx.xrd.XRDModel;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDiscoveryRSImpl extends JerseyTest {

  public TestDiscoveryRSImpl() throws TestContainerException {
    super("org.familysearch.ct.ws.rs.impl");
  }

  @Override
  protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
    return new InMemoryTestContainerFactory();
  }

  @Test
  public void testGet() throws Exception {
    ClientResponse response = resource().path("/.well-known/host-meta").accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    Date lastModified = response.getLastModified();
    assertNotNull(lastModified);
    Date later = new Date(lastModified.getTime() + (1000 * 60 * 60)); //one hour later
    response = resource().path("/.well-known/host-meta").accept(XRDModel.XRD_V1_XML_MEDIA_TYPE).header("If-Modified-Since", later).get(ClientResponse.class);
    assertEquals(Response.Status.NOT_MODIFIED.getStatusCode(), response.getStatus());
  }

}