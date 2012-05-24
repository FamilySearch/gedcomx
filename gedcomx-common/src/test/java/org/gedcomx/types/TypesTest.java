/**
 * Copyright 2011-2012 Intellectual Reserve, Inc. All Rights reserved.
 */
package org.gedcomx.types;

import org.testng.annotations.Test;

/**
 */
public class TypesTest {
  @Test
  public void testToQNameURI() throws Exception {
    // These enum classes don't need to be tested, so just call toQNameURI to get the code referenced in a test
    AgePartType.Days.toQNameURI();
    DatePartType.Days.toQNameURI();
    FactType.Couple.Marriage.toQNameURI();
    FactType.ParentChild.Biological.toQNameURI();
    FactType.Person.Baptism.toQNameURI();
    FactType.Record.Household.toQNameURI();
    GenderType.Male.toQNameURI();
    MaritalStatusType.Married.toQNameURI();
    NamePartType.Given.toQNameURI();
    NameType.Formal.toQNameURI();
    PlacePartType.Address.toQNameURI();
    RecordType.Census.getBaseType();
    RelationshipRole.Ancestor.toQNameURI();
    RelationshipType.Couple.toQNameURI();
  }
}
