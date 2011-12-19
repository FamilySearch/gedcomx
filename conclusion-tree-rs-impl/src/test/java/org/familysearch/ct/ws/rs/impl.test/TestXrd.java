package org.familysearch.ct.ws.rs.impl.test;

import org.familysearch.ct.ws.rs.impl.XrdRSImpl;
import org.gedcomx.xrd.Link;
import org.gedcomx.xrd.Title;
import org.gedcomx.xrd.XRD;
import org.testng.annotations.Test;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.testng.Assert.*;

@Test
public class TestXrd {
    public void testXrdHead() throws Exception {
        XrdRSImpl xrdImpl = new XrdRSImpl();
        assertNotNull(xrdImpl);

        Response response = xrdImpl.headXRD();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        MultivaluedMap<String, Object> headers = response.getMetadata();
        assertNotNull(headers);
        assertNotNull(headers.get("Last-Modified"));
    }

    public void testXrdRead() throws Exception {
        XrdRSImpl xrdImpl = new XrdRSImpl();
        assertNotNull(xrdImpl);
        
        Response response = xrdImpl.readXRD();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        
        XRD xrd = (XRD) response.getEntity();
        assertNotNull(xrd);
        assertNull(xrd.getSubject());

        List<Link> links = xrd.getLinks();
        assertNotNull(links);
        assertEquals(1, links.size());

        Link personLink = links.get(0);
        assertNotNull(personLink);
        assertEquals("persons", personLink.getHref().getPath());

        assertNotNull(personLink.getTitles());
        assertEquals(1, personLink.getTitles().size());
        Title personTitle = personLink.getTitles().get(0);
        assertEquals("Persons", personTitle.getValue());
    }
}