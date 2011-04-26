package org.gedcomx.source;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.SourceReferenceType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
public class SourceReference {

  private URI href;
  private SourceQualifier qualifier;
  private QName type;

  @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }

  @XmlAttribute
  @XmlQNameEnumRef (SourceReferenceType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public SourceReferenceType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), SourceReferenceType.class);
  }

  public void setKnownType(SourceReferenceType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  public SourceQualifier getQualifier() {
    return qualifier;
  }

  public void setQualifier(SourceQualifier qualifier) {
    this.qualifier = qualifier;
  }
}
