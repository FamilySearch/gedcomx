package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.conclusion.rs.definition.XrdRSDefinition;
import org.gedcomx.xrd.Link;
import org.gedcomx.xrd.Title;
import org.gedcomx.xrd.XRD;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Mike Gardiner
 */
@Path("/discover")
public class XrdRSImpl implements XrdRSDefinition {
    @Context
    UriInfo uriInfo;
    Date startupDate =  Calendar.getInstance().getTime();

    @GET
    @Override
    public Response readXRD() {

        try {
            return Response.ok(buildXRD()).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @HEAD
    @Override
    public Response headXRD() {
        return Response.ok().lastModified(startupDate).build();
    }

    @Override
    public void setProofStatement(String proofStatement) {

    }

    protected XRD buildXRD() throws Exception {
        String basePath = uriInfo.getBaseUri().getPath();
        XRD xrd = new XRD();
        xrd.setSubject(new URI(basePath));

        // Persons Link
        Link personsLink = new Link();
        personsLink.setHref(new URI(basePath + "/persons"));
        Title personsTitle = new Title();
        personsTitle.setValue("Persons");
        personsLink.getTitles().add(personsTitle);
        xrd.getLinks().add(personsLink);

        // Person Link
        Link personLink = new Link();
        personLink.setHref(new URI(basePath + "/person/{rid}"));
        Title personTitle = new Title();
        personTitle.setValue("Person");
        personLink.getTitles().add(personTitle);
        xrd.getLinks().add(personLink);

        // Relationships Link
        Link relationshipsLink = new Link();
        relationshipsLink.setHref(new URI(relationshipsLink + "/relationships"));
        Title relationshipsTitle = new Title();
        relationshipsTitle.setValue("Relationships");
        relationshipsLink.getTitles().add(relationshipsTitle);
        xrd.getLinks().add(relationshipsLink);

        // Relationship Link
        Link relationshipLink = new Link();
        relationshipLink.setHref(new URI(relationshipLink + "/relationship/{rid}"));
        Title relationshipTitle = new Title();
        relationshipTitle.setValue("Relationship");
        relationshipLink.getTitles().add(relationshipTitle);
        xrd.getLinks().add(relationshipLink);

        return xrd;
    }
}
