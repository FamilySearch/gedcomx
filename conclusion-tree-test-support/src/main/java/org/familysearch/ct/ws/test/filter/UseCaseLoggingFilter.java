package org.familysearch.ct.ws.test.filter;


import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.LoggingFilter;
import org.familysearch.ct.ws.test.RequestAndResponse;
import org.familysearch.ct.ws.test.UseCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Extends the Jersey LoggingFilter so we can hook into the client requests
 * in order to get the Request and Response information necessary to document
 * the use cases.
 *
 * @author Mike Gardiner
 */
public class UseCaseLoggingFilter extends LoggingFilter {

  private static final ThreadLocal<UseCase> CURRENT_USE_CASE = new ThreadLocal<UseCase>();
  private static final ThreadLocal<String> CURRENT_REQUEST_DESCRIPTION = new ThreadLocal<String>();
  private final List<UseCase> useCases = new ArrayList<UseCase>();

  /**
   * Sets the current use case
   *
   * @param uc - The use case to set as current
   */
  public void setCurrentUseCase(UseCase uc) {
    if (CURRENT_USE_CASE.get() != null) {
      this.useCases.add(CURRENT_USE_CASE.get());
    }
    CURRENT_USE_CASE.set(uc);
  }

  /**
   * Set the description for the use case
   *
   * @param description - The use case description
   */
  public void setCurrentRequestDescription(String description) {
    CURRENT_REQUEST_DESCRIPTION.set(description);
  }

  /**
   * @return A list of use cases
   */
  public List<UseCase> getUseCases() {
    return useCases;
  }

  /**
   * Callback that gets called for each request
   *
   * @param request - The associated request
   * @return The associated response
   * @throws ClientHandlerException
   */
  @Override
  public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
    ClientResponse response = super.handle(request);
    UseCase uc = CURRENT_USE_CASE.get();
    if (uc != null) {
      String currReqDescription = CURRENT_REQUEST_DESCRIPTION.get();
      uc.getRequests().add(new RequestAndResponse(request, response, currReqDescription));
      CURRENT_REQUEST_DESCRIPTION.remove();
    }
    return response;
  }
}
