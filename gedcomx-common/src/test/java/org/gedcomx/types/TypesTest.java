/**
 * Copyright 2011-2012 Intellectual Reserve, Inc. All Rights reserved.
 */
package org.gedcomx.types;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


/**
 */
public class TypesTest {
  @Test
  public void testToQNameURI() throws Exception {
    // NOTE: not a full test, but gets some code coverage

    assertEquals(AgePartType.fromQNameURI(AgePartType.Days.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Days");
    assertEquals(ConfidenceLevel.fromQNameURI(ConfidenceLevel.Possibly.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Possibly");
    assertEquals(DateFormatType.fromQNameURI(DateFormatType.ISO8601.toQNameURI()).toQNameURI().toString(), "iso:8601");
    assertEquals(DatePartType.fromQNameURI(DatePartType.Days.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Days");
    assertEquals(EventRoleType.fromQNameURI(EventRoleType.Principal.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Principal");
    assertEquals(EventType.fromQNameURI(EventType.Burial.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Burial");
    assertEquals(FactType.fromQNameURI(FactType.Marriage.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Marriage");
    assertEquals(FactType.fromQNameURI(FactType.BiologicalLineage.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Biological");
    assertEquals(FactType.fromQNameURI(FactType.Baptism.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Baptism");
    assertEquals(FactType.fromQNameURI(FactType.Household.toQNameURI()).toQNameURI().toString(), "http://record.gedcomx.org/Household");
    assertEquals(GenderType.fromQNameURI(GenderType.Male.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Male");
    assertEquals(IdentifierType.fromQNameURI(IdentifierType.Primary.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Primary");
    assertEquals(MaritalStatusType.fromQNameURI(MaritalStatusType.Married.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Married");
    assertEquals(NamePartType.fromQNameURI(NamePartType.Given.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Given");
    assertEquals(NameType.fromQNameURI(NameType.Formal.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Formal");
    assertEquals(PlacePartType.fromQNameURI(PlacePartType.Address.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Address");
    assertEquals(RecordType.fromQNameURI(RecordType.Census.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Census");
    assertEquals(RelationshipType.fromQNameURI(RelationshipType.Couple.toQNameURI()).toQNameURI().toString(), "http://gedcomx.org/Couple");
  }

  @Test
  public void testFactTypeIsLike() throws Exception {
    // NOTE: not a full test, but gets some code coverage

    assertFalse(FactType.Household.isBirthLike());
    assertFalse(FactType.Household.isDeathLike());
    assertFalse(FactType.Household.isMarriageLike());
    assertFalse(FactType.Household.isDivorceLike());
    assertFalse(FactType.Household.isMigrationLike());

    assertTrue(FactType.Christening.isBirthLike());
    assertTrue(FactType.Burial.isDeathLike());
    assertTrue(FactType.MarriageBanns.isMarriageLike());
    assertTrue(FactType.DivorceFiling.isDivorceLike());
    assertTrue(FactType.Naturalization.isMigrationLike());
  }

  @Test
  public void testFactTypeInnerClasses() throws Exception {
    // NOTE: not a full test, but gets some code coverage

    assertTrue(FactType.Person.isApplicable(FactType.Will));
    assertTrue(FactType.Couple.isApplicable(FactType.Separation));
    assertTrue(FactType.ParentChild.isApplicable(FactType.Guardianship));
    assertTrue(FactType.Record.isApplicable(FactType.Household));
  }

  @Test
  public void testRecordTypeHelpers() throws Exception {
    // NOTE: not a full test, but gets some code coverage

    assertTrue(RecordType.Vital.isVital());
    assertTrue(RecordType.Birth.isVital());
    assertFalse(RecordType.Census.isVital());
    assertEquals(RecordType.Marriage.getBaseType(), RecordType.Vital);
    assertEquals(RecordType.Bank.getBaseType(), RecordType.Legal);
    assertEquals(RecordType.Draft.getBaseType(), RecordType.Military);
    assertEquals(RecordType.Census.getBaseType(), RecordType.Census);
  }
}
