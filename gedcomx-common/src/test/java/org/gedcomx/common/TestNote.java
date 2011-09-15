package org.gedcomx.common;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestNote {

  /**
   * tests note xml
   */
  public void testNoteXml() throws Exception {
    Note note = new Note();
    note.setText("hello, there");
    note.setAttribution(new Attribution());
    note.getAttribution().setStatement("note statement");
    Note otherNote = new Note();
    otherNote.setText("note of a note");
    note.setExtensionElements(Arrays.asList((Object) otherNote));
    note.setId("id");
    note.setLang("en");
    note.setMediaType("text/plain");

    note = processThroughXml(note);

    assertEquals("hello, there", note.getText());
    assertEquals("note statement", note.getAttribution().getStatement());
    assertEquals("note of a note", ((Note) note.getExtensionElements().get(0)).getText());
    assertEquals("id", note.getId());
    assertEquals("en", note.getLang());
    assertEquals("text/plain", note.getMediaType());
  }

  /**
   * tests note json
   */
  public void testNoteJson() throws Exception {
    Note note = new Note();
    note.setText("hello, there");
    note.setAttribution(new Attribution());
    note.getAttribution().setStatement("note statement");
    Note otherNote = new Note();
    otherNote.setText("note of a note");
    note.setExtensionElements(Arrays.asList((Object) otherNote));
    note.setId("id");
    note.setLang("en");
    note.setMediaType("text/plain");

    note = processThroughJson(note);

    assertEquals("hello, there", note.getText());
    assertEquals("note statement", note.getAttribution().getStatement());
    assertEquals("note of a note", ((Note) note.getExtensionElements().get(0)).getText());
    assertEquals("id", note.getId());
    assertEquals("en", note.getLang());
    assertEquals("text/plain", note.getMediaType());
  }

}
