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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for XRDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XRDType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://docs.oasis-open.org/ns/xri/xrd-1.0}Expires" minOccurs="0"/>
 *         &lt;element ref="{http://docs.oasis-open.org/ns/xri/xrd-1.0}Subject" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://docs.oasis-open.org/ns/xri/xrd-1.0}Alias"/>
 *           &lt;element ref="{http://docs.oasis-open.org/ns/xri/xrd-1.0}Property"/>
 *           &lt;element ref="{http://docs.oasis-open.org/ns/xri/xrd-1.0}Link"/>
 *           &lt;any processContents='lax' namespace='##other'/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}id"/>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XRDType", propOrder = {
    "expires",
    "subject",
    "aliasOrPropertyOrLink"
})
public class XRDType {

    @XmlElement(name = "Expires")
    protected ExpiresType expires;
    @XmlElement(name = "Subject")
    protected AnyURI subject;
    @XmlElementRefs({
        @XmlElementRef(name = "Alias", namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", type = JAXBElement.class),
        @XmlElementRef(name = "Property", namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", type = JAXBElement.class),
        @XmlElementRef(name = "Link", namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", type = JAXBElement.class)
    })
    @XmlAnyElement(lax = true)
    protected List<Object> aliasOrPropertyOrLink;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;
    @XmlAnyAttribute
    private Map<QName, java.lang.String> otherAttributes = new HashMap<QName, java.lang.String>();

    /**
     * Gets the value of the expires property.
     * 
     * @return
     *     possible object is
     *     {@link ExpiresType }
     *     
     */
    public ExpiresType getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpiresType }
     *     
     */
    public void setExpires(ExpiresType value) {
        this.expires = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setSubject(AnyURI value) {
        this.subject = value;
    }

    /**
     * Gets the value of the aliasOrPropertyOrLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aliasOrPropertyOrLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAliasOrPropertyOrLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     * {@link JAXBElement }{@code <}{@link PropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link LinkType }{@code >}
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAliasOrPropertyOrLink() {
        if (aliasOrPropertyOrLink == null) {
            aliasOrPropertyOrLink = new ArrayList<Object>();
        }
        return this.aliasOrPropertyOrLink;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, java.lang.String> getOtherAttributes() {
        return otherAttributes;
    }

}
