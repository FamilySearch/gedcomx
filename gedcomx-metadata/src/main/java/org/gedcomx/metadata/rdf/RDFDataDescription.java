package org.gedcomx.metadata.rdf;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public class RDFDataDescription {

  private String id; 
  private URI dataRef;
  private Map<QName, String> otherAttributes;
  private List<Object> otherElements;

  @XmlAttribute( name = "ID" )
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  @XmlAttribute( name = "about" )
  public URI getDataRef() {
    return dataRef;
  }

  public void setDataRef(URI dataRef) {
    this.dataRef = dataRef;
  }

  @XmlAnyAttribute
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  @XmlAnyElement ( lax = true )
  public List<Object> getOtherElements() {
    return otherElements;
  }

  public void setOtherElements(List<Object> otherElements) {
    this.otherElements = otherElements;
  }
}
