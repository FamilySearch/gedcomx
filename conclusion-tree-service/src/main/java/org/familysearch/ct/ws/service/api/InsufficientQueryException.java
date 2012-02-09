package org.familysearch.ct.ws.service.api;

/**
 * @author Ryan Heaton
 */
public class InsufficientQueryException extends RuntimeException {

  public InsufficientQueryException() {
  }

  public InsufficientQueryException(String message) {
    super(message);
  }

  public InsufficientQueryException(String message, Throwable cause) {
    super(message, cause);
  }

  public InsufficientQueryException(Throwable cause) {
    super(cause);
  }
}
