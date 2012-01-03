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
 * @author Mike Gardiner
 */
public class UseCaseLoggingFilter extends LoggingFilter {

  private static final ThreadLocal<UseCase> CURRENT_USE_CASE = new ThreadLocal<UseCase>();
  private final List<UseCase> useCases = new ArrayList<UseCase>();

  public void setCurrentUseCase(UseCase uc) {
    if (CURRENT_USE_CASE.get() != null) {
      this.useCases.add(CURRENT_USE_CASE.get());
    }
    CURRENT_USE_CASE.set(uc);
  }

  public List<UseCase> getUseCases() {
    return useCases;
  }

  @Override
  public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
    ClientResponse response = super.handle(request);
    UseCase uc = CURRENT_USE_CASE.get();
    if (uc != null) {
      uc.getRequests().add(new RequestAndResponse(request, response));
    }
    return response;
  }
}
