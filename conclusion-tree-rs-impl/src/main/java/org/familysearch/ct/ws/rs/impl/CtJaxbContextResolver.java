package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.common.ResourceSet;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.Relationship;
import org.gedcomx.atom.Link;
import org.gedcomx.rt.GedcomNamespaceManager;
import org.gedcomx.xrd.XRD;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.*;

/**
 * The JAXB context resolver that is responsible for making sure all the conclusion model classes are available
 * in the context and that the XML is pretty.
 * 
 * @author Ryan Heaton
 */
@Provider
public class CtJaxbContextResolver implements ContextResolver<JAXBContext> {

  private JAXBContext context;

  public CtJaxbContextResolver() throws JAXBException {
    this.context = JAXBContext.newInstance(Person.class, Relationship.class, ResourceSet.class, Link.class, XRD.class);
  }

  @Override
  public JAXBContext getContext(Class<?> type) {
    return new FormattingJAXBContext(this.context, type);
  }

  private static final class FormattingJAXBContext extends JAXBContext {

    private final JAXBContext delegate;
    private final GedcomNamespaceManager namespaceManager;

    public FormattingJAXBContext(JAXBContext delegate, Class<?> rootClass) {
      this.delegate = delegate;
      this.namespaceManager = new GedcomNamespaceManager(rootClass);
    }

    @Override
    public Unmarshaller createUnmarshaller() throws JAXBException {
      return delegate.createUnmarshaller();
    }

    @Override
    public Marshaller createMarshaller() throws JAXBException {
      Marshaller marshaller = delegate.createMarshaller();
      marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
      marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", this.namespaceManager);
      return marshaller;
    }

    @Override
    public Validator createValidator() throws JAXBException {
      return delegate.createValidator();
    }
  }
}
