package org.familysearch.ct.ws.test;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.*;

/**
 * @author Ryan Heaton
 */
@Provider
public class FormattingJAXBContextResolver implements ContextResolver<JAXBContext> {

  @Override
  public JAXBContext getContext(Class<?> type) {
    try {
      return new FormattingJAXBContext(JAXBContext.newInstance(type));
    }
    catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  private static final class FormattingJAXBContext extends JAXBContext {

    private final JAXBContext delegate;


    public FormattingJAXBContext(JAXBContext delegate) {
      this.delegate = delegate;
    }

    @Override
    public Unmarshaller createUnmarshaller() throws JAXBException {
      return delegate.createUnmarshaller();
    }

    @Override
    public Marshaller createMarshaller() throws JAXBException {
      Marshaller marshaller = delegate.createMarshaller();
      marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
      return marshaller;
    }

    @Override
    public Validator createValidator() throws JAXBException {
      return delegate.createValidator();
    }
  }
}
