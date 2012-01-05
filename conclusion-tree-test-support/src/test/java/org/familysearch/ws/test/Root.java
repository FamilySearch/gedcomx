package org.familysearch.ws.test;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * This is just a dummy resource need to test the DocAwareJerseyTest functionality
 *
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
