package org.familysearch.gedcom.rex.date;

import org.codehaus.enunciate.ClientName;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType(propOrder = {"original", "interpreted", "normalized", "astro"})
@ClientName("DateInfo")
public class Date {

  private String id;
  private DateValue original;
  private DateValue interpreted;
  private DateValue normalized;
  private AstroDate astro;

  public Date() {
  }

  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlElement
  public DateValue getOriginal() {
    return original;
  }

  public void setOriginal(DateValue original) {
    this.original = original;
  }

  @XmlElement
  public DateValue getInterpreted() {
    return interpreted;
  }

  public void setInterpreted(DateValue interpreted) {
    this.interpreted = interpreted;
  }

  @XmlElement
  public DateValue getNormalized() {
    return normalized;
  }

  public void setNormalized(DateValue normalized) {
    this.normalized = normalized;
  }

  @XmlElement
  public AstroDate getAstro() {
    return astro;
  }

  public void setAstro(AstroDate astro) {
    this.astro = astro;
  }

}
