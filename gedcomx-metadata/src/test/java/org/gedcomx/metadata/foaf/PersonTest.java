package org.gedcomx.metadata.foaf;

import org.gedcomx.common.ResourceReference;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.testng.annotations.Test;

import org.gedcomx.common.URI;
import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class PersonTest {

  public void testPersonXml() throws Exception {
    Person person = createPerson();
    person = processThroughXml(person);
    assertPerson(person);
  }

  /**
   * tests alternate id json
   */
  public void testPersonJson() throws Exception {
    Person person = createPerson();
    person = processThroughJson(person);
    assertPerson(person);
  }

  private Person createPerson() {
    Person person = new Person();
    person.setFamilyName(new RDFLiteral("family name"));
    person.setGivenName(new RDFLiteral("given name"));
    person.setLanguage(new RDFLiteral("en"));
    person.setAccounts(new ArrayList<OnlineAccount>());
    OnlineAccount account = new OnlineAccount();
    account.setAccountName(new RDFLiteral("account name"));
    account.setDisplayName(new RDFLiteral("display name"));
    account.setId("id");
    account.setServiceHomepage(new ResourceReference());
    account.getServiceHomepage().setResource(URI.create("http://familysearch.org"));
    person.getAccounts().add(account);
    person.setAddresses(new ArrayList<Address>());
    Address address = new Address();
    address.setValue("street1\nstreet2\nstreet3\ncity UT, 88888\ncountry");
    address.setCity("city");
    address.setCountry("country");
    address.setId("id");
    address.setPostalCode("88888");
    address.setStateOrProvince("UT");
    address.setStreet("street1");
    address.setStreet2("street2");
    address.setStreet3("street3");
    person.getAddresses().add(address);
    person.setEmails(new ArrayList<ResourceReference>());
    ResourceReference email = new ResourceReference();
    email.setResource(URI.create("mailto:heatonra@familysearch.org"));
    person.getEmails().add(email);
    person.setHomepage(new RDFLiteral("http://familysearch.org/heatonra"));
    person.setName(new RDFLiteral("Ryan Heaton"));
    person.setOpenid(new RDFLiteral("openid"));
    person.setPhones(new ArrayList<ResourceReference>());
    ResourceReference phone = new ResourceReference();
    phone.setResource(URI.create("tel:+18012401000"));
    person.getPhones().add(phone);
    return person;
  }

  private void assertPerson(Person person) {
    assertEquals("family name", person.getFamilyName().getValue());
    assertEquals("given name", person.getGivenName().getValue());
    assertEquals("en", person.getLanguage().getValue());
    assertEquals(1, person.getAccounts().size());
    assertEquals("account name", person.getAccounts().get(0).getAccountName().getValue());
    assertEquals("display name", person.getAccounts().get(0).getDisplayName().getValue());
    assertEquals("id", person.getAccounts().get(0).getId());
    assertEquals("http://familysearch.org", person.getAccounts().get(0).getServiceHomepage().getResource().toString());
    assertEquals(1, person.getAddresses().size());
    assertEquals("street1\nstreet2\nstreet3\ncity UT, 88888\ncountry", person.getAddresses().get(0).getValue());
    assertEquals("city", person.getAddresses().get(0).getCity());
    assertEquals("country", person.getAddresses().get(0).getCountry());
    assertEquals("id", person.getAddresses().get(0).getId());
    assertEquals("88888", person.getAddresses().get(0).getPostalCode());
    assertEquals("UT", person.getAddresses().get(0).getStateOrProvince());
    assertEquals("street1", person.getAddresses().get(0).getStreet());
    assertEquals("street2", person.getAddresses().get(0).getStreet2());
    assertEquals("street3", person.getAddresses().get(0).getStreet3());
    assertEquals(1, person.getEmails().size());
    assertEquals("mailto:heatonra@familysearch.org", person.getEmails().get(0).getResource().toString());
    assertEquals("http://familysearch.org/heatonra", person.getHomepage().getValue());
    assertEquals("Ryan Heaton", person.getName().getValue());
    assertEquals("openid", person.getOpenid().getValue());
    assertEquals(1, person.getPhones().size());
    assertEquals("tel:+18012401000", person.getPhones().get(0).getResource().toString());
  }

}
