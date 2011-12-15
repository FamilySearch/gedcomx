package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.conclusion.rs.definition.XRDRSDefinition;
import org.gedcomx.xrd.XRD;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Mike Gardiner
 */
@Path("/discover")
public class XRDRSImpl implements XRDRSDefinition {
    @GET
    @Override
    public Response readXRD() {

        try {
            return Response.ok(buildXRD()).build();
        }
        catch (URISyntaxException e) {
            return Response.serverError().build();
        }
    }

    @HEAD
    @Override
    public Response headXRD() {
        return null;
    }

    @Override
    public void setProofStatement(String proofStatement) {

    }

    protected XRD buildXRD() throws URISyntaxException {
        XRD xrd = new XRD();
        xrd.setSubject(new URI(""));
       // xrd.setLinks();

        return xrd;
    }
}
