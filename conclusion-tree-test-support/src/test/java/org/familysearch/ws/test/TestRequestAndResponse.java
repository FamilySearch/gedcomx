package org.familysearch.ws.test;

import org.familysearch.ct.ws.test.Header;
import org.familysearch.ct.ws.test.RequestAndResponse;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Unit tests for the RequestAndResponse class
 *
 * @author Mike Gardiner
 */
public class TestRequestAndResponse {

  /**
   * Test the getters and setters for RequestAndResponse
   *
   * @throws Exception - If error occurs
   */
  @Test
  public void testGettersAndSetters() throws Exception {

    // Define the test values
    final String desc = "Description";
    final String body = "Body";
    final String method = "GET";
    final URI path = URI.create("/some/path");
    final String respBody = "Response Body";
    final int respCode = 200;
    final String respMessage = "Response Message";
    final List<Header> reqHeaders = new ArrayList<Header>();
    reqHeaders.add(new Header("Request Header 1", "Request Value 1"));
    reqHeaders.add(new Header("Request Header 2", "Request Value 2"));
    final List<Header> respHeaders = new ArrayList<Header>();
    respHeaders.add(new Header("Request Header 1", "Request Value 1"));
    respHeaders.add(new Header("Request Header 2", "Request Value 2"));

    // Set the definition values
    RequestAndResponse reqAndResp = new RequestAndResponse();
    reqAndResp.setDescription(desc);
    reqAndResp.setRequestBody(body);
    reqAndResp.setRequestHeaders(reqHeaders);
    reqAndResp.setRequestMethod(method);
    reqAndResp.setRequestPath(path);
    reqAndResp.setResponseBody(respBody);
    reqAndResp.setResponseCode(respCode);
    reqAndResp.setResponseHeaders(respHeaders);
    reqAndResp.setResponseMessage(respMessage);

    // Test expected results
    assertEquals(desc, reqAndResp.getDescription());
    assertEquals(body, reqAndResp.getRequestBody());
    assertEquals(reqHeaders, reqAndResp.getRequestHeaders());
    assertEquals(method, reqAndResp.getRequestMethod());
    assertEquals(path, reqAndResp.getRequestPath());
    assertEquals(respBody, reqAndResp.getResponseBody());
    assertEquals(respCode, reqAndResp.getResponseCode());
    assertEquals(respMessage, reqAndResp.getResponseMessage());
    assertEquals(respHeaders, reqAndResp.getResponseHeaders());
  }
}
