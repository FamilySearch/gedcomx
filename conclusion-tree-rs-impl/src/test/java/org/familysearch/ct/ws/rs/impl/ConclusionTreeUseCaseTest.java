package org.familysearch.ct.ws.rs.impl;

import org.familysearch.ct.ws.service.api.PersonService;
import org.familysearch.ct.ws.test.DocAwareJerseyTest;

import java.util.Map;

import static org.easymock.EasyMock.createMock;

/**
 * @author Ryan Heaton
 */
public abstract class ConclusionTreeUseCaseTest extends DocAwareJerseyTest {

  protected PersonService mockPersonService;

  @Override
  protected void registerServerSideComponents(Map<Class<?>, Object> serverSideComponents) {
    super.registerServerSideComponents(serverSideComponents);
    this.mockPersonService = createMock(PersonService.class);
    serverSideComponents.put(PersonService.class, this.mockPersonService);
  }

}
