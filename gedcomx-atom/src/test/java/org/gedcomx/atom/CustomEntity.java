package org.gedcomx.atom;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalEntity;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ryan Heaton
 */
@XmlRootElement (namespace = "urn:custom")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME )
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class CustomEntity extends GenealogicalEntity {
}
