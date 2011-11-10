package org.familysearch.ct.shema;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Randy Bliss
 */
public enum ConclusionScope {
    FULL,
    SUMMARY;

    @XmlTransient
    public boolean isFull() {
      return this == FULL;
    }

    @XmlTransient
    public boolean isSummary() {
      return this == SUMMARY;
    }
  }
