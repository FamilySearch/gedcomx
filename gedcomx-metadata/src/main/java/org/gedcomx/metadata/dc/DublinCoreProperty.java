package org.gedcomx.metadata.dc;

import org.gedcomx.metadata.MetadataConstants;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public abstract class DublinCoreProperty<S> {

  private String id;
  private String lang;
  private URI valueRef;
  private Map<QName, String> otherAttributes;

  @XmlAttribute( name = "ID", namespace = MetadataConstants.RDF_NAMESPACE )
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  @XmlAttribute( name = "resource", namespace = MetadataConstants.RDF_NAMESPACE )
  public URI getValueRef() {
    return valueRef;
  }

  public void setValueRef(URI valueRef) {
    this.valueRef = valueRef;
  }

  @XmlAnyAttribute
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  @XmlTransient
  public abstract S getValue();

  public abstract void setValue(S value);
}
