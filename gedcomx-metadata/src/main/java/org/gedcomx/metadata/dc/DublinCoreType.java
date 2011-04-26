package org.gedcomx.metadata.dc;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;
import org.gedcomx.metadata.MetadataConstants;

/**
 * @author Ryan Heaton
 */
@XmlQNameEnum (namespace = MetadataConstants.DUBLIN_CORE_TYPE_NAMESPACE)
public enum DublinCoreType {

  Collection,

  Dataset,

  Event,

  Image,

  InteractiveResource,

  MovingImage,

  PhysicalObject,

  Service,

  Software,

  Sound,

  StillImage,

  Text
}
