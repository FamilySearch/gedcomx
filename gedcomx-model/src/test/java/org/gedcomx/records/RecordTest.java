package org.gedcomx.records;

import org.gedcomx.Gedcomx;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.*;
import org.gedcomx.types.FactType;
import org.gedcomx.types.FieldValueType;
import org.gedcomx.types.NamePartType;
import org.gedcomx.types.RelationshipType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;


/**
 * @author Ryan Heaton
 */
@Test
public class RecordTest {

  /**
   * tests processing a WWW record through xml...
   */
  public void testRecordXml() throws Exception {
    Gedcomx record = create();
    record = processThroughXml(record);
    assertRecordEquals(record);
  }

  /**
   * tests processing a WWW record through json...
   */
  public void testRecordJson() throws Exception {
    Gedcomx record = create();
    record = processThroughJson(record);
    assertRecordEquals(record);
  }

  static Gedcomx create() {
    Record record = new Record();

    //set up the fields.
    ArrayList<Field> fields = new ArrayList<Field>();

    //given name
    Field givenNameField = new Field();
    givenNameField.setLabel("PR_NAME_GN");
    String givenNameId = "pr-gn";
    givenNameField.setType(NamePartType.Given.toQNameURI());
    givenNameField.setValues(new ArrayList<FieldValue>());
    FieldValue givenNameValue = new FieldValue();
    givenNameValue.setKnownType(FieldValueType.Original);
    givenNameValue.setText("Alma");
    givenNameValue.setReferenceToDataExtractedFromThisField(new ResourceReference(URI.create("#" + givenNameId)));
    givenNameField.getValues().add(givenNameValue);
    fields.add(givenNameField);

    //surname
    Field surnameField = new Field();
    surnameField.setLabel("PR_NAME_SURN");
    String surnameId = "pr-sn";
    surnameField.setType(NamePartType.Surname.toQNameURI());
    surnameField.setValues(new ArrayList<FieldValue>());
    FieldValue surNameValue = new FieldValue();
    surNameValue.setKnownType(FieldValueType.Original);
    surNameValue.setText("Heaton");
    surNameValue.setReferenceToDataExtractedFromThisField(new ResourceReference(URI.create("#" + surnameId)));
    surnameField.getValues().add(surNameValue);
    fields.add(surnameField);
    
    String deathDateId = "pr-dd";

    //death date: day
    Field deathDayField = new Field();
    deathDayField.setLabel("PR_DEATH_DATE_DAY");
    deathDayField.setType(URI.create("/Identifier/For/Death/Day"));
    deathDayField.setValues(new ArrayList<FieldValue>());
    FieldValue deathDayValue = new FieldValue();
    deathDayValue.setKnownType(FieldValueType.Original);
    deathDayValue.setText("30");
    deathDayValue.setReferenceToDataExtractedFromThisField(new ResourceReference(URI.create("#" + deathDateId)));
    deathDayField.getValues().add(deathDayValue);
    fields.add(deathDayField);

    //death date: month
    Field deathMonthField = new Field();
    deathMonthField.setLabel("PR_DEATH_DATE_MONTH");
    deathMonthField.setType(URI.create("/Identifier/For/Death/Month"));
    deathMonthField.setValues(new ArrayList<FieldValue>());
    FieldValue deathMonthValue = new FieldValue();
    deathMonthValue.setKnownType(FieldValueType.Original);
    deathMonthValue.setText("October");
    deathMonthValue.setReferenceToDataExtractedFromThisField(new ResourceReference(URI.create("#" + deathDateId)));
    deathMonthField.getValues().add(deathMonthValue);
    fields.add(deathMonthField);

    //death date: year
    Field deathYearField = new Field();
    deathYearField.setLabel("PR_DEATH_DATE_YEAR");
    deathYearField.setType(URI.create("/Identifier/For/Death/Year"));
    deathYearField.setValues(new ArrayList<FieldValue>());
    FieldValue deathYearValue = new FieldValue();
    deathYearValue.setKnownType(FieldValueType.Original);
    deathYearValue.setText("2002");
    deathYearValue.setReferenceToDataExtractedFromThisField(new ResourceReference(URI.create("#" + deathDateId)));
    deathYearField.getValues().add(deathYearValue);
    fields.add(deathYearField);
    
    //death date: place
    Field deathPlaceField = new Field();
    deathPlaceField.setLabel("PR_DEATH_PLACE");
    String deathPlaceId = "pr-dp";
    deathPlaceField.setType(URI.create("/Identifier/For/Death/Place"));
    deathPlaceField.setValues(new ArrayList<FieldValue>());
    FieldValue deathPlaceValue = new FieldValue();
    deathPlaceValue.setKnownType(FieldValueType.Original);
    deathPlaceValue.setText("Provo, Utah");
    deathPlaceValue.setReferenceToDataExtractedFromThisField(new ResourceReference(URI.create("#" + deathPlaceId)));
    deathPlaceField.getValues().add(deathPlaceValue);
    fields.add(deathPlaceField);
    
    String birthDateId = "pr-bd";

    //age
    Field ageField = new Field();
    ageField.setLabel("PR_AGE");
    ageField.setType(URI.create("/Identifier/For/Age"));
    ageField.setValues(new ArrayList<FieldValue>());
    FieldValue ageValue = new FieldValue();
    ageValue.setKnownType(FieldValueType.Original);
    ageValue.setText("88");
    ageValue.setReferenceToDataExtractedFromThisField(new ResourceReference(URI.create("#" + birthDateId)));
    ageField.getValues().add(ageValue);
    fields.add(ageField);
    
    //wife full name
    String wifeNameId = "s-n";
    Field wifeNameField = new Field();
    wifeNameField.setLabel("SP_NAME");
    wifeNameField.setType(URI.create("/Identifier/For/Wife/Name")); //todo: controlled vocabulary size?
    wifeNameField.setValues(new ArrayList<FieldValue>());
    FieldValue wifeNameValue = new FieldValue();
    wifeNameValue.setKnownType(FieldValueType.Original);
    wifeNameValue.setText("Marie Bishop");
    wifeNameValue.setReferenceToDataExtractedFromThisField(new ResourceReference(URI.create("#" + wifeNameId))); //todo: reference to relationship, too?
    wifeNameField.getValues().add(wifeNameValue);
    fields.add(wifeNameField);

    record.setFields(fields);
    
    //the principal person:
    String principalId = "p1";
    Person principal = new Person();
    principal.setId(principalId);
    Name principalName = new Name();
    NameForm principalNameForm = new NameForm();
    NamePart principalGivenName = new NamePart();
    principalGivenName.setValue("Alma");
    principalGivenName.setId(givenNameId);
    NamePart principalSurname = new NamePart();
    principalSurname.setValue("Heaton");
    principalSurname.setId(surnameId);
    principalNameForm.setParts(Arrays.asList(principalGivenName, principalSurname));
    principalName.setNameForms(Arrays.asList(principalNameForm));
    principal.setNames(Arrays.asList(principalName));
    Fact birth = new Fact();
    birth.setKnownType(FactType.Birth);
    birth.setDate(new Date());
    birth.getDate().setOriginal("1914");
    birth.getDate().setId(birthDateId);
    Fact death = new Fact();
    death.setKnownType(FactType.Death);
    death.setDate(new Date());
    death.getDate().setOriginal("30 October 2002");
    death.getDate().setFormal("+2002-10-30");
    death.getDate().setId(deathDateId);
    principal.setFacts(Arrays.asList(birth, death));
    
    //the spouse person:
    String spouseId = "p2";
    Person spouse = new Person();
    spouse.setId(spouseId);
    Name spouseName = new Name();
    NameForm spouseNameForm = new NameForm();
    spouseNameForm.setFullText("Marie Bishop");
    spouseName.setNameForms(Arrays.asList(spouseNameForm));
    spouseNameForm.setId(wifeNameId);
    spouse.setNames(Arrays.asList(spouseName));

    //the relationship to spouse:
    Relationship coupleRelationship = new Relationship();
    coupleRelationship.setKnownType(RelationshipType.Couple);
    coupleRelationship.setPerson1(new ResourceReference(URI.create("#" + principalId)));
    coupleRelationship.setPerson2(new ResourceReference(URI.create("#" + spouseId)));

    record.setPrincipalPersons(Arrays.asList(new ResourceReference(URI.create("#" + principalId))));

    Gedcomx gx = new Gedcomx();
    gx.setRecords(Arrays.asList(record));
    gx.setPersons(Arrays.asList(principal, spouse));
    gx.setRelationships(Arrays.asList(coupleRelationship));
    return gx;
  }

  static void assertRecordEquals(Gedcomx gx) {
    //todo:
  }

}
