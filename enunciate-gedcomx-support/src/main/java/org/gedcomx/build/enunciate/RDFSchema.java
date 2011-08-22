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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@XmlRootElement(namespace = RDFSchema.RDF_NAMESPACE, name = "RDF")
public class RDFSchema {

  public static final String RDF_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
  public static final String RDFS_NAMESPACE = "http://www.w3.org/2000/01/rdf-schema#";

  @XmlElement(namespace = RDFSchema.RDF_NAMESPACE, name = "Description")
  public List<RDFDescription> descriptions;

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

  public void addDescriptions(RDFSchema schema) {
    if (this.descriptions == null) {
      this.descriptions = new ArrayList<RDFDescription>();
    }

    this.descriptions.addAll(schema.descriptions);
  }

  public static class RDFDescription {

    @XmlAttribute (namespace = RDF_NAMESPACE)
    public String about;
    @XmlElement (namespace = RDFS_NAMESPACE)
    public String label;
    @XmlElement (namespace = RDFS_NAMESPACE)
    public String comment;
    @XmlElement (namespace = RDFS_NAMESPACE)
    public RDFResourceReference isDefinedBy;
    @XmlElement (namespace = RDF_NAMESPACE)
    public RDFResourceReference type;
    @XmlElement (namespace = RDFS_NAMESPACE)
    public List<RDFResourceReference> subClassOf;
    @XmlElement (namespace = RDFS_NAMESPACE)
    public List<RDFResourceReference> subPropertyOf;
    @XmlElement (namespace = RDFS_NAMESPACE)
    public List<RDFResourceReference> range;
    @XmlElement (namespace = RDFS_NAMESPACE)
    public List<RDFResourceReference> domain;

    public boolean isClassDescription() {
      return this.type != null && "http://www.w3.org/2000/01/rdf-schema#Class".equals(this.type.resource);
    }

    public boolean isPropertyDescription() {
      return this.type != null && "http://www.w3.org/1999/02/22-rdf-syntax-ns#Property".equals(this.type.resource);
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

    @XmlAttribute (namespace = RDF_NAMESPACE)
    public String resource;
  }
}
