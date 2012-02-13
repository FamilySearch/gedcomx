package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.WebResource;
import org.familysearch.ct.ws.service.api.DiscoveryService;
import org.familysearch.ct.ws.service.api.PersonService;
import org.familysearch.ct.ws.test.DocAwareJerseyTest;

import java.util.Map;

import static org.easymock.EasyMock.createMock;

/**
 * @author Ryan Heaton
 */
public abstract class ConclusionTreeUseCaseTest extends DocAwareJerseyTest {

  @Override
  protected void registerServerSideComponents(Map<Class<?>, Object> serverSideComponents) {
    super.registerServerSideComponents(serverSideComponents);
    serverSideComponents.put(PersonService.class, createMock(PersonService.class));
    serverSideComponents.put(DiscoveryService.class, createMock(DiscoveryService.class));
  }

  protected <M> M getServerSideMock(Class<M> clazz) {
    return (M) this.serverSideComponents.get(clazz);
  }

  @Override
  public WebResource resource() {
    WebResource resource = super.resource();
    resource.addFilter(new OAuth2BearerTokenFilter("your_access_token"));
    return resource;
  }

  public WebResource unauthenticatedResource() {
    return super.resource();
  }
}
