package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;
import java.io.Serializable;

/**
 * @author Mike Gardiner and Ryan Heaton
 */
public class RequestAndResponse implements Serializable {

  private MultivaluedMap<String, Object> requestHeaders;
  private String requestBody;
  private MultivaluedMap<String, String> responseHeaders;
  private String responseBody;
  private int responseCode;

  public RequestAndResponse() {
  }

  public RequestAndResponse(ClientRequest request, ClientResponse response) {
    requestHeaders = request.getHeaders();
    requestBody = (String) request.getEntity();
    responseHeaders = response.getHeaders();
    responseBody = response.getEntity(String.class);
    responseCode = response.getStatus();
  }

  public MultivaluedMap<String, Object> getRequestHeaders() {
    return requestHeaders;
  }

  public void setRequestHeaders(MultivaluedMap<String, Object> requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  public String getRequestBody() {
    return requestBody;
  }

  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }

  public MultivaluedMap<String, String> getResponseHeaders() {
    return responseHeaders;
  }

  public void setResponseHeaders(MultivaluedMap<String, String> responseHeaders) {
    this.responseHeaders = responseHeaders;
  }

  public String getResponseBody() {
    return responseBody;
  }

  public void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(int responseCode) {
    this.responseCode = responseCode;
  }
}
