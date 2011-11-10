package org.familysearch.ct.shema;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;

/**
 * @author Randy Bliss
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Contribution {
  public Contribution() {}
  public Contribution(Contribution prototype) {}
  //todo: RJB this has to be replaced with equivalent schema object from GedcomX artifact
}
