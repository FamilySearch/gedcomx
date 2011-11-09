package org.familysearch.ct.www.impl;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Randy Bliss
 */
public enum ConclusionCategory {
    /**
     * Specify ALL to include both vital and non-vital conclusions.
     */
    ALL(true, true),

    /**
     * Specify NON_VITAL to include only non-vital conclusions in the list.
     */
    NON_VITAL(false, true),

    /**
     * Specify VITAL to include only vital conclusions in the list.
     */
    VITAL(true, false);

    private boolean includesVital;
    private boolean includesNonVital;

    private ConclusionCategory(boolean includesVital, boolean includesNonVital) {
      this.includesVital = includesVital;
      this.includesNonVital = includesNonVital;
    }

    @XmlTransient
    public boolean isAll() {
      return this == ALL;
    }

    @XmlTransient
    public boolean isVital() {
      return this == VITAL;
    }

    @XmlTransient
    public boolean isNonVital() {
      return this == NON_VITAL;
    }

    @XmlTransient
    public boolean includesVital() {
      return includesVital;
    }

    @XmlTransient
    public boolean includesNonVital() {
      return includesNonVital;
    }
  }
