package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

import javax.ws.rs.core.HttpHeaders;

/**
 * @author Ryan Heaton
 */
public class OAuth2BearerTokenFilter extends ClientFilter {
  
  private final String accessToken;

  public OAuth2BearerTokenFilter(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public ClientResponse handle(ClientRequest cr) throws ClientHandlerException {
    if (!cr.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
      cr.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + this.accessToken);
    }

    return getNext().handle(cr);
  }
}
