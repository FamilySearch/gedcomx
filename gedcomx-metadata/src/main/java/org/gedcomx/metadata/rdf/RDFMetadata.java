package org.gedcomx.metadata.rdf;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
@XmlRootElement(name = "RDF")
public class RDFMetadata {

  private List<RDFDataDescription> dataDescriptions;
  private Map<QName, String> otherAttributes;
  private List<Object> otherElements;

  @XmlElement ( name = "Description" )
  public List<RDFDataDescription> getDataDescriptions() {
    return dataDescriptions;
  }

  public void setDataDescriptions(List<RDFDataDescription> dataDescriptions) {
    this.dataDescriptions = dataDescriptions;
  }

  @XmlAnyAttribute
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  @XmlAnyElement( lax = true )
  public List<Object> getOtherElements() {
    return otherElements;
  }

  public void setOtherElements(List<Object> otherElements) {
    this.otherElements = otherElements;
  }
}
