/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.build.enunciate.rdf;

import com.sun.mirror.declaration.Declaration;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Basic XML model for an RDF schema document.
 *
 * @author Ryan Heaton
 */
@XmlRootElement(namespace = RDFSchema.RDF_NAMESPACE, name = "RDF")
public class RDFSchema {

  public static final String RDF_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
  public static final String RDF_PROPERTY_TYPE = RDF_NAMESPACE + "Property";
  public static final String RDFS_NAMESPACE    = "http://www.w3.org/2000/01/rdf-schema#";
  public static final String RDFS_CLASS_TYPE   = RDFS_NAMESPACE + "Class";
  public static final String RDFS_LITERAL_RANGE = RDFS_NAMESPACE + "Literal";
  public static final String DUBLIN_CORE_NAMESPACE = "http://purl.org/dc/terms/";
  public static final String DUBLIN_CORE_TYPE_NAMESPACE = "http://purl.org/dc/dcmitype/";

  private List<RDFDescription> descriptions;

  @XmlElement(namespace = RDFSchema.RDF_NAMESPACE, name = "Description")
  public List<RDFDescription> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<RDFDescription> descriptions) {
    this.descriptions = descriptions;
  }

  public void addDescription(RDFDescription description) {
    if (description != null) {
      if (this.descriptions == null) {
        this.descriptions = new ArrayList<RDFDescription>();
      }

      this.descriptions.add(description);
    }
  }

  public RDFDescription findDescription(String about) {
    RDFDescription description = null;
    if (this.getDescriptions() != null) {
      for (RDFDescription candidate : this.descriptions) {
        if (about.equals(candidate.getAbout())) {
          description = candidate;
          break;
        }
      }
    }
    return description;
  }

  public void addDescriptions(RDFSchema schema) {
    if (this.getDescriptions() == null) {
      this.descriptions = new ArrayList<RDFDescription>();
    }

    this.descriptions.addAll(schema.getDescriptions());
  }

  public static class RDFDescription {

    private String about;
    private String label;
    private Set<String> comments;
    private String isDefinedBy;
    private String type;
    private Set<String> subClassOf;
    private Set<String> subPropertyOf;
    private Set<String> range;
    private Set<String> domain;
    private Declaration associatedDeclaration;

    @XmlAttribute (namespace = RDF_NAMESPACE)
    public String getAbout() {
      return about;
    }

    public void setAbout(String about) {
      this.about = about;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    @XmlElement (name = "comment", namespace = RDFS_NAMESPACE)
    public Set<String> getComments() {
      return comments;
    }

    public void setComments(Set<String> comments) {
      this.comments = comments;
    }

    public void addComment(String comment) {
      if (comment != null) {
        if (this.comments == null) {
          this.comments = new TreeSet<String>();
        }

        this.comments.add(comment);
      }
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    @XmlJavaTypeAdapter(StringToResourceAdapter.class)
    public String getIsDefinedBy() {
      return this.isDefinedBy;
    }

    public void setIsDefinedBy(String definedBy) {
      this.isDefinedBy = definedBy;
    }

    @XmlElement (namespace = RDF_NAMESPACE)
    @XmlJavaTypeAdapter(StringToResourceAdapter.class)
    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    @XmlJavaTypeAdapter(StringToResourceAdapter.class)
    public Set<String> getSubClassOf() {
      return subClassOf;
    }

    public void setSubClassOf(Set<String> subClassOf) {
      this.subClassOf = subClassOf;
    }

    public void addSubClassOf(String resource) {
      if (resource != null) {
        if (this.subClassOf == null) {
          this.subClassOf = new TreeSet<String>();
        }

        this.subClassOf.add(resource);
      }
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    @XmlJavaTypeAdapter(StringToResourceAdapter.class)
    public Set<String> getSubPropertyOf() {
      return subPropertyOf;
    }

    public void setSubPropertyOf(Set<String> subPropertyOf) {
      this.subPropertyOf = subPropertyOf;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    @XmlJavaTypeAdapter(StringToResourceAdapter.class)
    public Set<String> getRange() {
      return range;
    }

    public void setRange(Set<String> range) {
      this.range = range;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    @XmlJavaTypeAdapter(StringToResourceAdapter.class)
    public Set<String> getDomain() {
      return domain;
    }

    public void setDomain(Set<String> domain) {
      this.domain = domain;
    }

    @XmlTransient
    public Declaration getAssociatedDeclaration() {
      return associatedDeclaration;
    }

    public void setAssociatedDeclaration(Declaration associatedDeclaration) {
      this.associatedDeclaration = associatedDeclaration;
    }

    public boolean isClassDescription() {
      return RDFS_CLASS_TYPE.equals(this.type);
    }

    public boolean isPropertyDescription() {
      return RDF_PROPERTY_TYPE.equals(this.type);
    }

    public boolean isLiteral() {
      return this.range != null && this.range.size() == 1 && this.range.contains(RDFS_LITERAL_RANGE);
    }
  }

  public static class RDFResourceReference {

    private String resource;

    public RDFResourceReference() {
    }

    public RDFResourceReference(String resource) {
      this.resource = resource;
    }

    @XmlAttribute (namespace = RDF_NAMESPACE)
    public String getResource() {
      return resource;
    }

    public void setResource(String resource) {
      this.resource = resource;
    }
  }

  public static class StringToResourceAdapter extends XmlAdapter<RDFResourceReference, String> {
    @Override
    public String unmarshal(RDFResourceReference v) throws Exception {
      return v == null ? null : v.getResource();
    }

    @Override
    public RDFResourceReference marshal(String v) throws Exception {
      return v == null ? null : new RDFResourceReference(v);
    }
  }
}
