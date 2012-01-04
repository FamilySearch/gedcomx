package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Mike Gardiner and Ryan Heaton
 */
@XmlType
public class RequestAndResponse implements Serializable {
  private List<Header> requestHeaders = new ArrayList<Header>();
  private String requestBody;
  private List<Header> responseHeaders = new ArrayList<Header>();
  private String responseBody;
  private int responseCode;

  public RequestAndResponse() {
  }

  public RequestAndResponse(ClientRequest request, ClientResponse response) {
    MultivaluedMap<String, Object> map = request.getHeaders();
    Set<String> set = map.keySet();
    Iterator<String> iterator = set.iterator();
    String content;

    while (iterator.hasNext()) {
      String key = iterator.next();
      content = map.get(key).get(0).toString();
      requestHeaders.add(new Header(key, content));
    }

    requestBody = (String) request.getEntity();

    MultivaluedMap<String, String> responseMap = response.getHeaders();
    set = responseMap.keySet();
    iterator = set.iterator();

    while (iterator.hasNext()) {
      String key = iterator.next();
      content = responseMap.get(key).get(0);
      responseHeaders.add(new Header(key, content));
    }

    responseBody = response.getEntity(String.class);
    responseCode = response.getStatus();
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
}
