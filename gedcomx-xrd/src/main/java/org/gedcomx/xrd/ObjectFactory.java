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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.gedcomx.xrd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Alias_QNAME = new QName("http://docs.oasis-open.org/ns/xri/xrd-1.0", "Alias");
    private final static QName _Subject_QNAME = new QName("http://docs.oasis-open.org/ns/xri/xrd-1.0", "Subject");
    private final static QName _Expires_QNAME = new QName("http://docs.oasis-open.org/ns/xri/xrd-1.0", "Expires");
    private final static QName _Link_QNAME = new QName("http://docs.oasis-open.org/ns/xri/xrd-1.0", "Link");
    private final static QName _XRDS_QNAME = new QName("http://docs.oasis-open.org/ns/xri/xrd-1.0", "XRDS");
    private final static QName _Title_QNAME = new QName("http://docs.oasis-open.org/ns/xri/xrd-1.0", "Title");
    private final static QName _XRD_QNAME = new QName("http://docs.oasis-open.org/ns/xri/xrd-1.0", "XRD");
    private final static QName _Property_QNAME = new QName("http://docs.oasis-open.org/ns/xri/xrd-1.0", "Property");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.gedcomx.xrd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LinkType }
     * 
     */
    public LinkType createLinkType() {
        return new LinkType();
    }

    /**
     * Create an instance of {@link String }
     * 
     */
    public String createString() {
        return new String();
    }

    /**
     * Create an instance of {@link XRDSType }
     * 
     */
    public XRDSType createXRDSType() {
        return new XRDSType();
    }

    /**
     * Create an instance of {@link PropertyType }
     * 
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link TitleType }
     * 
     */
    public TitleType createTitleType() {
        return new TitleType();
    }

    /**
     * Create an instance of {@link AnyURI }
     * 
     */
    public AnyURI createAnyURI() {
        return new AnyURI();
    }

    /**
     * Create an instance of {@link XRDType }
     * 
     */
    public XRDType createXRDType() {
        return new XRDType();
    }

    /**
     * Create an instance of {@link ExpiresType }
     * 
     */
    public ExpiresType createExpiresType() {
        return new ExpiresType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", name = "Alias")
    public JAXBElement<AnyURI> createAlias(AnyURI value) {
        return new JAXBElement<AnyURI>(_Alias_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", name = "Subject")
    public JAXBElement<AnyURI> createSubject(AnyURI value) {
        return new JAXBElement<AnyURI>(_Subject_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExpiresType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", name = "Expires")
    public JAXBElement<ExpiresType> createExpires(ExpiresType value) {
        return new JAXBElement<ExpiresType>(_Expires_QNAME, ExpiresType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", name = "Link")
    public JAXBElement<LinkType> createLink(LinkType value) {
        return new JAXBElement<LinkType>(_Link_QNAME, LinkType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XRDSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", name = "XRDS")
    public JAXBElement<XRDSType> createXRDS(XRDSType value) {
        return new JAXBElement<XRDSType>(_XRDS_QNAME, XRDSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TitleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", name = "Title")
    public JAXBElement<TitleType> createTitle(TitleType value) {
        return new JAXBElement<TitleType>(_Title_QNAME, TitleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XRDType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", name = "XRD")
    public JAXBElement<XRDType> createXRD(XRDType value) {
        return new JAXBElement<XRDType>(_XRD_QNAME, XRDType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/xri/xrd-1.0", name = "Property")
    public JAXBElement<PropertyType> createProperty(PropertyType value) {
        return new JAXBElement<PropertyType>(_Property_QNAME, PropertyType.class, null, value);
    }

}
