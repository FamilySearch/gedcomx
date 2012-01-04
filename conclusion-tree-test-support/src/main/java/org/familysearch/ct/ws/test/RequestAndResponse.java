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

  public RequestAndResponse() {
  }

  public RequestAndResponse(ClientRequest request, ClientResponse response) {
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
  }

  public String getRequestMethod() {
    return requestMethod;
  }

  public void setRequestMethod(String requestMethod) {
    this.requestMethod = requestMethod;
  }

  public URI getRequestPath() {
    return requestPath;
  }

  public void setRequestPath(URI requestPath) {
    this.requestPath = requestPath;
  }

  @XmlElement ( name = "requestHeader" )
  public List<Header> getRequestHeaders() {
    return requestHeaders;
  }

  public void setRequestHeaders(List<Header> requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  public String getRequestBody() {
    return requestBody;
  }

  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }

  @XmlElement ( name = "responseHeader" )
  public List<Header> getResponseHeaders() {
    return responseHeaders;
  }

  public void setResponseHeaders(List<Header> responseHeaders) {
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

  public String getResponseMessage() {
    return responseMessage;
  }

  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
  }
}
