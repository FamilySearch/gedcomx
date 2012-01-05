package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Used to hold request and response information associated with a use case
 *
 * @author Mike Gardiner and Ryan Heaton
 */
@XmlType
public class RequestAndResponse implements Serializable {

  private String requestMethod;
  private URI requestPath;
  private List<Header> requestHeaders = new ArrayList<Header>();
  private String requestBody;
  private List<Header> responseHeaders = new ArrayList<Header>();
  private String responseBody;
  private int responseCode;
  private String responseMessage;
  private String description;

  /**
   * The default constructor
   */
  public RequestAndResponse() {
  }

  /**
   * Multiparameter convenience constructor
   *
   * @param request     - The request information associated with a use case
   * @param response    - The response information associated with a use case
   * @param description - The description associated with a use case
   */
  public RequestAndResponse(ClientRequest request, ClientResponse response, String description) {
    MultivaluedMap<String, Object> map = request.getHeaders();
    Set<String> set = map.keySet();
    Iterator<String> iterator = set.iterator();
    String content;

    this.requestMethod = request.getMethod();
    this.requestPath = request.getURI();
    while (iterator.hasNext()) {
      String key = iterator.next();
      content = map.get(key).get(0).toString();
      this.requestHeaders.add(new Header(key, content));
    }

    this.requestBody = (String) request.getEntity();

    MultivaluedMap<String, String> responseMap = response.getHeaders();
    set = responseMap.keySet();
    iterator = set.iterator();

    while (iterator.hasNext()) {
      String key = iterator.next();
      content = responseMap.get(key).get(0);
      this.responseHeaders.add(new Header(key, content));
    }

    this.responseBody = response.getEntity(String.class);
    this.responseCode = response.getStatus();
    this.responseMessage = response.getClientResponseStatus().getReasonPhrase();
    this.description = description;
  }

  /**
   * @return The HTTP request method
   */
  public String getRequestMethod() {
    return requestMethod;
  }

  /**
   * @param requestMethod - An HTTP request method
   */
  public void setRequestMethod(String requestMethod) {
    this.requestMethod = requestMethod;
  }

  /**
   * @return The request path
   */
  public URI getRequestPath() {
    return requestPath;
  }

  /**
   * @param requestPath - The request path
   */
  public void setRequestPath(URI requestPath) {
    this.requestPath = requestPath;
  }

  /**
   * @return A list of request headers
   */
  @XmlElement ( name = "requestHeader" )
  public List<Header> getRequestHeaders() {
    return requestHeaders;
  }

  /**
   * @param requestHeaders - A list of request headers
   */
  public void setRequestHeaders(List<Header> requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  /**
   * @return The request body
   */
  public String getRequestBody() {
    return requestBody;
  }

  /**
   * @param requestBody - The request body
   */
  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }

  /**
   * @return A list of response headers
   */
  @XmlElement ( name = "responseHeader" )
  public List<Header> getResponseHeaders() {
    return responseHeaders;
  }

  /**
   * @param responseHeaders - A list of response headers
   */
  public void setResponseHeaders(List<Header> responseHeaders) {
    this.responseHeaders = responseHeaders;
  }

  /**
   * @return The response body
   */
  public String getResponseBody() {
    return responseBody;
  }

  /**
   * @param responseBody - The response body
   */
  public void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }

  /**
   * @return The HTTP response code
   */
  public int getResponseCode() {
    return responseCode;
  }

  /**
   * @param responseCode - An HTTP response code
   */
  public void setResponseCode(int responseCode) {
    this.responseCode = responseCode;
  }

  /**
   * @return The response message
   */
  public String getResponseMessage() {
    return responseMessage;
  }

  /**
   * @param responseMessage - The response message
   */
  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
  }

  /**
   * @return A description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description - A description
   */
  public void setDescription(String description) {
    this.description = description;
  }
}
