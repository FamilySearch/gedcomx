/**
 * Copyright 2011 Intellectual Reserve, Inc.
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
package org.gedcomx.build.enunciate;

import com.sun.mirror.declaration.Declaration;
import net.sf.jelly.apt.decorations.declaration.DecoratedDeclaration;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@XmlRootElement(namespace = RDFSchema.RDF_NAMESPACE, name = "RDF")
public class RDFSchema {

  public static final String RDF_NAMESPACE     = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
  public static final String RDF_PROPERTY_TYPE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#Property";
  public static final String RDFS_NAMESPACE    = "http://www.w3.org/2000/01/rdf-schema#";
  public static final String RDFS_CLASS_TYPE   = "http://www.w3.org/2000/01/rdf-schema#Class";

  List<RDFDescription> descriptions;

  public RDFDescription findDescription(String about) {
    RDFDescription description = null;
    if (this.descriptions != null) {
      for (RDFDescription candidate : descriptions) {
        if (about.equals(candidate.about)) {
          description = candidate;
          break;
        }
      }
    }
    return description;
  }

  @XmlElement(namespace = RDFSchema.RDF_NAMESPACE, name = "Description")
  public List<RDFDescription> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<RDFDescription> descriptions) {
    this.descriptions = descriptions;
  }

  public void addDescriptions(RDFSchema schema) {
    if (this.descriptions == null) {
      this.descriptions = new ArrayList<RDFDescription>();
    }

    this.descriptions.addAll(schema.descriptions);
  }

  public static class RDFDescription {

    String about;
    String label;
    List<String> comments;
    RDFResourceReference isDefinedBy;
    RDFResourceReference type;
    List<RDFResourceReference> subClassOf;
    List<RDFResourceReference> subPropertyOf;
    List<RDFResourceReference> range;
    List<RDFResourceReference> domain;
    Declaration associatedDeclaration;

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
    public List<String> getComments() {
      return comments;
    }

    public void setComments(List<String> comments) {
      this.comments = comments;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    public RDFResourceReference getIsDefinedBy() {
      return isDefinedBy;
    }

    public void setIsDefinedBy(RDFResourceReference definedBy) {
      isDefinedBy = definedBy;
    }

    @XmlElement (namespace = RDF_NAMESPACE)
    public RDFResourceReference getType() {
      return type;
    }

    public void setType(RDFResourceReference type) {
      this.type = type;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    public List<RDFResourceReference> getSubClassOf() {
      return subClassOf;
    }

    public void setSubClassOf(List<RDFResourceReference> subClassOf) {
      this.subClassOf = subClassOf;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    public List<RDFResourceReference> getSubPropertyOf() {
      return subPropertyOf;
    }

    public void setSubPropertyOf(List<RDFResourceReference> subPropertyOf) {
      this.subPropertyOf = subPropertyOf;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    public List<RDFResourceReference> getRange() {
      return range;
    }

    public void setRange(List<RDFResourceReference> range) {
      this.range = range;
    }

    @XmlElement (namespace = RDFS_NAMESPACE)
    public List<RDFResourceReference> getDomain() {
      return domain;
    }

    public void setDomain(List<RDFResourceReference> domain) {
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
      return this.type != null && RDFS_CLASS_TYPE.equals(this.type.resource);
    }

    public boolean isPropertyDescription() {
      return this.type != null && RDF_PROPERTY_TYPE.equals(this.type.resource);
    }

    public boolean isLiteral() {
      boolean literal = false;
      if (this.range != null) {
        for (RDFResourceReference range : this.range) {
          if ("http://www.w3.org/2000/01/rdf-schema#Literal".equals(range.resource)) {
            literal = true;
            break;
          }
        }
      }
      return literal;
    }


  }

  public static class RDFResourceReference {

    String resource;

    @XmlAttribute (namespace = RDF_NAMESPACE)
    public String getResource() {
      return resource;
    }

    public void setResource(String resource) {
      this.resource = resource;
    }
  }
}
