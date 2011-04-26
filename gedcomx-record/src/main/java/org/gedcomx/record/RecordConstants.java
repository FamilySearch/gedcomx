package org.gedcomx.record;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
public class RecordConstants {

  private RecordConstants() {}

  public static final String GEDCOMX_RECORD_NAMESPACE = "http://gedcomx.org/record/v1";

}