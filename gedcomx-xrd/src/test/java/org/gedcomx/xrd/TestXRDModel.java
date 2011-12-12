package org.gedcomx.xrd;

import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Mike Gardiner
 */

@Test
public class TestXRDModel {

    public void testObjectFactory() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        assert objectFactory != null;
        AnyURI subjectURI = new AnyURI();
        subjectURI.setValue("http://www.gedcomx.org/test");
        objectFactory.createSubject(subjectURI);
    }

    public void testXRDType() throws Exception {
        XRDType xrd = new XRDType();
        AnyURI subject = new AnyURI();
        subject.setValue("http://www.gedcomx.org/test");

        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        ExpiresType expires = new ExpiresType();
        expires.setValue(calendar);

        xrd.setId("foo");
        xrd.setSubject(subject);
        xrd.setExpires(expires);

        JAXBContext jc = JAXBContext.newInstance("org.gedcomx.xrd");
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(xrd, System.out);

    }
}
