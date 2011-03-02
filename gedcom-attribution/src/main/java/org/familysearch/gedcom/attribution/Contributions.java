package org.familysearch.gedcom.attribution;

import org.codehaus.enunciate.ClientName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
public class Contributions {

  private List<Contribution> contributions;

  @XmlElement(name="contribution")
  @ClientName("contributionList")
  public List<Contribution> getContributions() {
    return contributions;
  }

  public void setContributions(List<Contribution> contributions) {
    this.contributions = contributions;
  }
}
