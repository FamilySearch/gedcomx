package org.familysearch.ct.ws.rs.impl.test;

import org.familysearch.ct.ws.rs.impl.XrdRSImpl;
import org.gedcomx.xrd.XRD;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

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
        assertEquals(1, xrd.getLinks().size());
    }
}