package org.gedcomx.conclusion;

import org.gedcomx.common.FormalValue;
import org.gedcomx.common.URI;
import org.gedcomx.test.RecipeTest;
import org.gedcomx.test.Snippet;
import org.gedcomx.types.FactType;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;

/**
 * @author Ryan Heaton
 */
@Test
public class TestDateRecipes extends RecipeTest {

  public void testDateFormalValue() throws Exception {
    createRecipe("Simple Formal Date")
      .withDescription("Simple recipe for how to use dates.")
      .applicableTo(Date.class);


    Person person = new Person();
    person.setId("12345");
    person.setFacts(new ArrayList<Fact>());
    Fact fact = new Fact();
    fact.setKnownType(FactType.Birth);
    person.getFacts().add(fact);
    Date date = new Date();
    date.setOriginal("1 July 1980");
    FormalValue formal = new FormalValue();
    formal.setDatatype(URI.create("iso:123456"));
    formal.setText("1980-07-01");
    date.setFormal(formal);
    fact.setDate(date);

    Snippet snippet = new Snippet();
    person = processThroughXml(person, snippet);
    //todo: verify person.
    person = processThroughJson(person, snippet);
    //todo: verify person.
    addSnippet(snippet);

  }

}
