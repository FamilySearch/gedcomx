package org.gedcomx.metadata;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
public class MetadataConstants {

  private MetadataConstants() {}

  public static final String RDF_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
  public static final String RDF_MEDIA_TYPE = "application/rdf+xml";
  public static final String DUBLIN_CORE_NAMESPACE = "http://purl.org/dc/terms/";
  public static final String DUBLIN_CORE_TYPE_NAMESPACE = "http://purl.org/dc/dcmitype/";

}
