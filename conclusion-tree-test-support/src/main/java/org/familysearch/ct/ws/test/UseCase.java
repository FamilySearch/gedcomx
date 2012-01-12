package org.familysearch.ct.ws.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  private final Set<String> applicableBindings = new HashSet<String>();

  /**
   * @return Title of the use case
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title - The use case title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @param description - A description to associate with the use case
   * @return The associated use case
   */
  public UseCase withDescription(String description) {
    setDescription(description);
    return this;
  }

  /**
   * @return Description of the use case
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description - Description to assign to the use case
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * RequestAndResponse objects associated with the use case
   *
   * @return A list of RequestAndResponse objects
   */
  @XmlElement
  public List<RequestAndResponse> getRequests() {
    return requests;
  }

  /**
   * Add a binding class for which this use case is applicable.
   *
   * @param bindingClass The binding class to which this use case is applicable.
   * @return this use case.
   */
  public UseCase applicableTo(Class<?> bindingClass) {
    this.applicableBindings.add(bindingClass.getName());
    return this;
  }

  /**
   * The set of fully-qualified names of resource bindings to which this use case is applicable.
   *
   * @return The set of fully-qualified names of resource bindings to which this use case is applicable.
   */
  @XmlElement
  public Set<String> getApplicableBindings() {
    return applicableBindings;
  }
}
