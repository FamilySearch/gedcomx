package org.familysearch.ct.ws.rs.impl.test;

import org.familysearch.ct.ws.rs.impl.XrdRSImpl;
import org.gedcomx.xrd.Link;
import org.gedcomx.xrd.Title;
import org.gedcomx.xrd.XRD;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

@Test
public class TestXrd {
    public void testXrd() throws Exception {
        XrdRSImpl xrdImpl = new XrdRSImpl();
        assertNotNull(xrdImpl);
        
        Response response = xrdImpl.readXRD();
        assertNotNull(response);
        
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