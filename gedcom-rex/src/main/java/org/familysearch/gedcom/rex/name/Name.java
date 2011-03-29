package org.familysearch.gedcom.rex.name;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.familysearch.gedcom.rex.Field;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType
public class Name extends Field {

  private QName type = NameType.NAME;
  private QName genre;
  private List<NamePart> parts;

  public Name() {
  }

  @XmlAttribute
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlAttribute
  public QName getGenre() {
    return genre;
  }

  public void setGenre(QName genre) {
    this.genre = genre;
  }

  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  public List<NamePart> getParts() {
    return parts;
  }

  public void setParts(List<NamePart> parts) {
    this.parts = parts;
  }
}
