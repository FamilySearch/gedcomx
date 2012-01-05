package org.familysearch.ct.ws.test;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.*;

/**
 * This class is used to configure the body format when marshaling objects.
 *
 * @author Ryan Heaton
 */
@Provider
public class FormattingJAXBContextResolver implements ContextResolver<JAXBContext> {

  /**
   * Gets a JAXB context
   *
   * @param type - The class type
   * @return JAXBContext
   */
  @Override
  public JAXBContext getContext(Class<?> type) {
    try {
      return new FormattingJAXBContext(JAXBContext.newInstance(type));
    }
    catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Inner class to override formatting configuration
   */
  private static final class FormattingJAXBContext extends JAXBContext {

    private final JAXBContext delegate;

    /**
     * Constructor
     *
     * @param delegate - The JAXB context to use
     */
    public FormattingJAXBContext(JAXBContext delegate) {
      this.delegate = delegate;
    }

    /**
     * Creates an unmarshaller
     *
     * @return Unmarshaller
     * @throws JAXBException
     */
    @Override
    public Unmarshaller createUnmarshaller() throws JAXBException {
      return delegate.createUnmarshaller();
    }

    /**
     * Creates a marshaller
     *
     * @return Marshaller
     * @throws JAXBException
     */
    @Override
    public Marshaller createMarshaller() throws JAXBException {
      Marshaller marshaller = delegate.createMarshaller();
      marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
      return marshaller;
    }

    /**
     * Creates a validator
     *
     * @return Validator
     * @throws JAXBException
     */
    @Override
    public Validator createValidator() throws JAXBException {
      return delegate.createValidator();
    }
  }
}
