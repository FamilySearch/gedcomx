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

package org.gedcomx.xrd;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


/**
 * The <Link> element serves as a container for metadata about a relation between
 * the resource described by the XRD and a related resource.
 * <p/>
 * See http://docs.oasis-open.org/xri/xrd/v1.0/xrd-1.0.html#element.link
 *
 * @author Mike Gardiner, Ryan Heaton
 */
@XmlType(name = "Link", propOrder = {"titles", "properties"})
@SuppressWarnings({"rdf-incompatible-ns", "unqualified-attribute"})
public final class Link {
    private URI rel;
    protected URI href;
    protected List<Title> titles;
    protected List<Property> properties;


    /**
     * An optional value that defines the semantics of the relation between the resource
     * described by the XRD and the linked resource.
     *
     * @return A valid URI
     */
    @XmlAttribute
    @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
    public URI getRel() {
        return rel;
    }

    /**
     * Sets an optional value that defines the semantics of the relation between the resource
     * described by the XRD and the linked resource.
     *
     * @param rel - An valid URI
     */
    public void setRel(URI rel) {
        this.rel = rel;
    }

    /**
     * The optional href attribute provides the URI of the linked resource. If no
     * href attribute is defined, it is assumed the URI can be obtained from a
     * template attribute or by application-specific means.
     *
     * @return A valid URI
     */
    @XmlAttribute
    @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
    public URI getHref() {
        return href;
    }

    /**
     * The optional href attribute provides the URI of the linked resource. If no
     * href attribute is defined, it is assumed the URI can be obtained from a
     * template attribute or by application-specific means.
     *
     * @param href - A valid URI
     */
    public void setHref(URI href) {
        this.href = href;
    }

    /**
     * Provides a human-readable description of the linked resource.
     *
     * @return Zero or more Title elements
     */
    @JsonName("titles")
    @JsonProperty("titles")
    @XmlElement( name = "Title" )
    public List<Title> getTitles() {
        if (titles == null) {
            titles = new ArrayList<Title>();
        }

        return this.titles;
    }

    /**
     * Provides a human-readable description of the linked resource.
     *
     * @param titles - Zero or more Title elements
     */
    @JsonName("titles")
    @JsonProperty("titles")
    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    /**
     *  Declares an optional property of this link relation, as described in
     *  Section 2.5, “Element <Property>”. It is important to note that this
     *  value does not identify any property of the linked resource or the
     *  resource described by the XRD, but rather of the link relation between
     *  the linked resources.
     *
     * @return Zero or more Property elements
     */
    @JsonName("properties")
    @JsonProperty("properties")
    @XmlElement( name = "Property" )
    public List<Property> getProperties() {
        if (properties == null) {
            properties = new ArrayList<Property>();
        }

        return this.properties;
    }

    /**
     * Declares an optional property of this link relation, as described in
     *  Section 2.5, “Element <Property>”. It is important to note that this
     *  value does not identify any property of the linked resource or the
     *  resource described by the XRD, but rather of the link relation between
     *  the linked resources.
     *
     * @param properties - Zero or more Property elements
     */
    @JsonName("properties")
    @JsonProperty("properties")
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
