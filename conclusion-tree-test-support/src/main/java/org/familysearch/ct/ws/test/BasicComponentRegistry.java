package org.familysearch.ct.ws.test;

import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProvider;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.core.spi.component.ioc.IoCFullyManagedComponentProvider;

import javax.ws.rs.ext.Provider;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
@Provider
public class BasicComponentRegistry implements IoCComponentProviderFactory {

  private final Map<Class<?>,Object> components;

  public BasicComponentRegistry(Map<Class<?>, Object> components) {
    this.components = components;
  }

  @Override
  public IoCComponentProvider getComponentProvider(Class<?> c) {
    return getComponentProvider(null, c);
  }

  @Override
  public IoCComponentProvider getComponentProvider(ComponentContext cc, Class<?> c) {
    final Object component = this.components.get(c);
    if (component != null) {
      return new IoCFullyManagedComponentProvider() {
        @Override
        public ComponentScope getScope() {
          return ComponentScope.Singleton;
        }

        @Override
        public Object getInstance() {
          return component;
        }
      };
    }
    return null;
  }

}
