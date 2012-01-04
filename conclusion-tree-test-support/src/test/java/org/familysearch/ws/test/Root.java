package org.familysearch.ws.test;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author Mike Gardiner
 */
@Path ( "/root" )
public class Root {

  @GET
  public String getFoo() {
    return "foo";
  }

  @POST
  public String getBar() {
    return "bar";
  }
}
