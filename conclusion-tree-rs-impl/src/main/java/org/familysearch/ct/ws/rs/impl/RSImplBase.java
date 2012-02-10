package org.familysearch.ct.ws.rs.impl;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.UriBuilder;

/**
 * Base class for RS implementations.
 * 
 * @author Ryan Heaton
 */
public abstract class RSImplBase {
  
  private String sessionIdQueryParam;
  private String sessionIdAuthHeader;

  public String getSessionId() {
    return sessionIdQueryParam == null ? sessionIdAuthHeader : sessionIdQueryParam;
  }

  /**
   * The id of the OAuth 2 access token used for identification and authorization of the user (and agent) making the request.
   *
   * @param sessionId The id of the OAuth 2 access token used for identification and authorization of the user (and agent) making the request.
   */
  @QueryParam("access_token")
  public void setSessionId(String sessionId) {
    this.sessionIdQueryParam = sessionId;
  }

  /**
   * The authorization carrying the OAuth 2.0 bearer token. See <a href="http://tools.ietf.org/html/draft-ietf-oauth-v2-bearer">Auth 2.0 Bearer Tokens</a>.
   *
   * @param authHeader The authorization header.
   */
  @HeaderParam("Authorization")
  public void setAuthorization(String authHeader) {
    if (authHeader != null && authHeader.trim().toLowerCase().startsWith("bearer ")) {
      this.sessionIdAuthHeader = authHeader.substring(7).trim();
    }
  }

  /**
   * Decorate the specified link as needed to make sure it contains any necessary authorization parameters or whatever.
   *
   * @param path The link to decorate.
   * @return The decorated link.
   */
  protected UriBuilder decorate(UriBuilder path) {
    return this.sessionIdQueryParam != null ? path.queryParam("access_token", this.sessionIdQueryParam) : path;
  }
}
