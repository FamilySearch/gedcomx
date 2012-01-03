package org.familysearch.ct.ws.test;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * A documented use case for the CT API.
 *
 * @author Mike Gardiner
 * @author Ryan Heaton
 */
@XmlRootElement
public class UseCase {

  private String title;
  private String description;
  private final List<RequestAndResponse> requests = new ArrayList<RequestAndResponse>();

  public UseCase title(String title) {
    setTitle(title);
    return this;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UseCase description(String description) {
    setDescription(description);
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<RequestAndResponse> getRequests() {
    return requests;
  }

}
