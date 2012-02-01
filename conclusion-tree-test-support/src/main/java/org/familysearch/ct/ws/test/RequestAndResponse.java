package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    this.requestMethod = request.getMethod();
    this.requestPath = request.getURI();
    final Set<Map.Entry<String, List<Object>>> requestEntries = map.entrySet();
    
    for (Map.Entry<String, List<Object>> entry : requestEntries) {
      String key = entry.getKey();
      String content = entry.getValue().get(0).toString();
      this.requestHeaders.add(new Header(key, content));
    }

    this.requestBody = (String) request.getEntity();

    MultivaluedMap<String, String> responseMap = response.getHeaders();
    final Set<Map.Entry<String, List<String>>> responseEntries = responseMap.entrySet();

    for (Map.Entry<String, List<String>> entry : responseEntries) {
      String key = entry.getKey();
      String content = entry.getValue().get(0);
      this.responseHeaders.add(new Header(key, content));
    }

    try {
      this.responseBody = consumeAndResetStream(response.getEntityInputStream());
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
    this.responseCode = response.getStatus();
    this.responseMessage = response.getClientResponseStatus().getReasonPhrase();
    this.description = description;
  }

  private String consumeAndResetStream(InputStream entityStream) throws IOException {
    if (!entityStream.markSupported()) {
      //If we ever need to, we could consume and replace the stream, but for now we'll
      //take the cheap route and just mark and reset the stream.
      throw new IllegalStateException("Unable to consume the entity stream for logging purposes: mark not supported.");
    }
    entityStream.mark(Integer.MAX_VALUE);
    try {
      return consume(entityStream);
    }
    finally {
      entityStream.reset();
    }
  }

  private String consume(InputStream entityStream) throws IOException {
    StringBuilder builder = new StringBuilder();
    byte[] bytes = new byte[1024 * 5]; //5 K buffer...
    int len = entityStream.read(bytes);
    while (len > 0) {
      builder.append(new String(bytes, 0, len));
      len = entityStream.read(bytes);
    }
    return builder.toString();
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
