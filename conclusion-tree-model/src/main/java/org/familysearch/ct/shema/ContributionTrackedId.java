package org.familysearch.ct.shema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Randy Bliss
 */
@XmlRootElement
  public class ContributionTrackedId {
    private String personId;
    private Contribution contribution;
    private Justification justification;

    public ContributionTrackedId() {
      this.personId = null;
      this.contribution = new Contribution();
      this.justification = new Justification();
    }

    public ContributionTrackedId(ContributionTrackedId other) {
      this.personId = other.personId;
      this.contribution = new Contribution(other.contribution);
      this.justification = new Justification(other.justification);
    }

    public String getPersonId() {
      return this.personId;
    }

    public void setPersonId(String personId) {
      this.personId = personId;
    }

    public Contribution getContribution() {
      return this.contribution;
    }

    public void setContribution(Contribution contribution) {
      if (contribution == null) {
        throw new NullPointerException("contribution cannot be null for this operation");
      }
      this.contribution = contribution;
    }

    public Justification getJustification() {
      return this.justification;
    }

    public void setJustification(Justification justification) {
      if (justification == null) {
        throw new NullPointerException("justification cannot be null for this operation");
      }
      this.justification = justification;
    }

    @XmlTransient
    public boolean isPersonIdSpecified() {
      return this.personId != null && !this.personId.trim().isEmpty();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) { return true; }
      if (o == null || getClass() != o.getClass()) { return false; }

      ContributionTrackedId that = (ContributionTrackedId) o;

      if (personId != null ? !personId.equals(that.personId) : that.personId != null) { return false; }
      if (justification != null ? !justification.equals(that.justification) : that.justification != null) { return false; }
      //noinspection RedundantIfStatement
      if (contribution != null ? !contribution.equals(that.contribution) : that.contribution != null) { return false; }

      return true;
    }

    @Override
    public int hashCode() {
      int result = personId != null ? personId.hashCode() : 0;
      result = 31 * result + (contribution != null ? contribution.hashCode() : 0);
      result = 31 * result + (justification != null ? justification.hashCode() : 0);
      return result;
    }
  }

