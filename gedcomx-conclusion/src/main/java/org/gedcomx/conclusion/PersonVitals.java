package org.gedcomx.conclusion;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.PersistentIdentifiable;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.JsonExtensionElement;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;
import java.util.List;

/**
 * Definition of the vital information for a person.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "PersonVitals", propOrder = { "persistentId", "alternateIds", "name", "birth", "death" } )
public class PersonVitals extends GenealogicalResource implements PersistentIdentifiable {

  private URI persistentId;
  private List<AlternateId> alternateIds;
  private ResourceReference name;
  private ResourceReference birth;
  private ResourceReference death;

  /**
   * The persistent id of the person.
   *
   * @return The persistent id of the person.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * The persistent id of the person.
   *
   * @param persistentId The persistent id of the person.
   */
  public void setPersistentId(URI persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the person.
   *
   * @return The list of alternate ids of the person.
   */
  @XmlElement (name="alternateId")
  @JsonProperty ("alternateIds")
  @JsonName ("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the entity.
   *
   * @param alternateIds The list of alternate ids of the entity.
   */
  @JsonProperty ("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * Reference to the primary name for a person.
   *
   * @return Reference to the primary name for a person.
   */
  public ResourceReference getName() {
    return name;
  }

  /**
   * Reference to the primary name for a person.
   *
   * @param name Reference to the primary name for a person.
   */
  public void setName(ResourceReference name) {
    this.name = name;
  }

  /**
   * Reference to the primary birth event for a person.
   *
   * @return Reference to the primary birth event for a person.
   */
  public ResourceReference getBirth() {
    return birth;
  }

  /**
   * Reference to the primary birth event for a person.
   *
   * @param birth Reference to the primary birth event for a person.
   */
  public void setBirth(ResourceReference birth) {
    this.birth = birth;
  }

  /**
   * Reference to the primary death event for a person.
   *
   * @return Reference to the primary death event for a person.
   */
  public ResourceReference getDeath() {
    return death;
  }

  /**
   * Reference to the primary death event for a person.
   *
   * @param death Reference to the primary death event for a person.
   */
  public void setDeath(ResourceReference death) {
    this.death = death;
  }
}
