package org.gedcomx.records;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.Gedcomx;
import org.gedcomx.links.HypermediaEnabledData;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Ryan Heaton
 */
public class RecordDescriptor extends HypermediaEnabledData {

  private String lang;
  private String text;
  private List<FieldDescription> fields;

  /**
   * The language of this record description. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of this record description.
   */
  @XmlAttribute ( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of this record description. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of this record description.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * Human-readable text value of this descriptor, used to describe the kinds of records associated with this descriptor.
   *
   * @return Human-readable text value of the description.
   */
  public String getText() {
    return text;
  }

  /**
   * Human-readable text value of this descriptor, used to describe the kinds of records associated with this descriptor.
   *
   * @param text Human-readable text value of the description.
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * The fields that are applicable to this record.
   *
   * @return The fields that are applicable to this record.
   */
  @XmlElement (name="field")
  @JsonProperty ("fields")
  @JsonName ("fields")
  public List<FieldDescription> getFields() {
    return fields;
  }

  /**
   * The fields that are applicable to this record.
   *
   * @param fields The fields that are applicable to this record.
   */
  @JsonProperty ("fields")
  public void setFields(List<FieldDescription> fields) {
    this.fields = fields;
  }
}
