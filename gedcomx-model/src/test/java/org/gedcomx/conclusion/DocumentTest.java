package org.gedcomx.conclusion;

import org.gedcomx.CustomEntity;
import org.gedcomx.common.*;
import org.gedcomx.source.SourceReference;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;


public class DocumentTest {
  @Test
  public void testAbstractDocument() throws Exception {
    Document document = new AbstractDocument();

    assertNull(document.getId());
    assertNull(document.getText());
    assertNull(document.getSources());
    assertNull(document.getAttribution());
    assertNull(document.getNotes());
    assertNull(document.getExtensionElements());

    document.setId("DDDD-DDD");
    document.setText(new TextValue("(The text of the document abstract goes here.)"));
    document.getText().setLang("en-US");
    document.addSource(new SourceReference());
    document.getSources().get(0).setSourceDescriptionURI(URI.create("urn:original-source1"));
    document.addSource(new SourceReference());
    document.getSources().get(1).setSourceDescriptionURI(URI.create("urn:original-source2"));
    document.setAttribution(new Attribution());
    document.getAttribution().setContributor(new ResourceReference(URI.create("urn:contributor-id")));
    document.addNote(new Note());
    document.getNotes().get(0).setText(new TextValue("(This is an example note #1, though not one to be emulated too closely.)"));
    document.addNote(new Note());
    document.getNotes().get(1).setText(new TextValue("(This is an example note #2, though not one to be emulated too closely.)"));
    document.addExtensionElement(new CustomEntity("1234"));
    document.addExtensionElement(new CustomEntity("2345"));

    assertEquals(document.getId(), "DDDD-DDD");
    assertEquals(document.getText().getLang(), "en-US");
    assertEquals(document.getText().getValue(), "(The text of the document abstract goes here.)");
    assertEquals(document.getSources().size(), 2);
    assertEquals(document.getSources().get(0).getSourceDescription().getResource().toURI().toString(), "urn:original-source1");
    assertEquals(document.getSources().get(1).getSourceDescription().getResource().toURI().toString(), "urn:original-source2");
    assertEquals(document.getNotes().size(), 2);
    assertEquals(document.getNotes().get(0).getText().getValue(), "(This is an example note #1, though not one to be emulated too closely.)");
    assertEquals(document.getNotes().get(1).getText().getValue(), "(This is an example note #2, though not one to be emulated too closely.)");
    assertNotNull(document.getExtensionElements());
    assertEquals(document.getExtensionElements().size(), 2);
    assertEquals(((CustomEntity)document.getExtensionElements().get(0)).getId(), "1234");
    assertEquals(((CustomEntity)document.getExtensionElements().get(1)).getId(), "2345");
    assertNull(document.findExtensionOfType(String.class));
    assertEquals(document.findExtensionOfType(CustomEntity.class).getId(), "1234");
    assertEquals(document.findExtensionsOfType(String.class).size(), 0);
    assertEquals(document.findExtensionsOfType(CustomEntity.class).size(), 2);
    assertEquals(document.findExtensionsOfType(CustomEntity.class).get(1).getId(), "2345");

    document.setSources(null);
    document.addSource(null);
    document.setNotes(null);
    document.addNote(null);
    document.setExtensionElements(null);
    assertNull(document.getSources());
    assertNull(document.getNotes());
    assertNull(document.findExtensionOfType(CustomEntity.class));
    assertEquals(document.findExtensionsOfType(CustomEntity.class).size(), 0);
  }

  @Test
  public void testAnalysisDocument() throws Exception {
    Document document = new AnalysisDocument();

    assertNull(document.getId());
    assertNull(document.getText());
    assertNull(document.getSources());
    assertNull(document.getAttribution());
    assertNull(document.getNotes());
    assertNull(document.getExtensionElements());
  }

  @Test
  public void testTranscriptionDocument() throws Exception {
    Document document = new TranscriptionDocument();

    assertNull(document.getId());
    assertNull(document.getText());
    assertNull(document.getSources());
    assertNull(document.getAttribution());
    assertNull(document.getNotes());
    assertNull(document.getExtensionElements());
  }

  @Test
  public void testTranslationDocument() throws Exception {
    Document document = new TranslationDocument();

    assertNull(document.getId());
    assertNull(document.getText());
    assertNull(document.getSources());
    assertNull(document.getAttribution());
    assertNull(document.getNotes());
    assertNull(document.getExtensionElements());
  }
}
