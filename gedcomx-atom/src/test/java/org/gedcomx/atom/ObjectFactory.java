package org.gedcomx.atom;

import org.gedcomx.rt.JsonElementWrapper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
@XmlRegistry
public class ObjectFactory {

  @XmlElementDecl( namespace = "urn:different", name = "diff" )
  @JsonElementWrapper( name = "different" )
  JAXBElement<CustomEntity> createCustomEntitySubelement(CustomEntity en) {
    return new JAXBElement<CustomEntity>(new QName("urn:different", "diff"), CustomEntity.class,  en);
  }
}
