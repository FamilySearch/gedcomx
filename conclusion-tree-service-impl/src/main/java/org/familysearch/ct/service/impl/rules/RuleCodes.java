package org.familysearch.ct.service.impl.rules;

/**
 * @author Rob Lyon
 */
public enum RuleCodes {

  // person codes
  Person(100),
  Person_Composition(101),

  // relationship codes
  Relationship(200),
  Relationship_Composition(201),

  // conclusion codes
  Conclusion(300),
  Conclusion_Composition(301),

  Name(320),
  Name_Composition(321),

  Gender(340),
  Gender_Composition(341),

  Fact(360),
  Fact_Composition(361),
  Fact_Cardinality(362),

  // source codes

  // note codes

  ;

  private final int code;

  RuleCodes(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

}
