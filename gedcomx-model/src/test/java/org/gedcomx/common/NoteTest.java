package org.gedcomx.common;

import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;


/**
 * @author Ryan Heaton
 */
@Test
public class NoteTest {

  /**
   * tests note xml
   */
  public void testNoteXml() throws Exception {
    Note note = new Note();
    note.setText("hello, there");
    note.setSubject("subject");
    note.setAttribution(new Attribution());
    note.getAttribution().setChangeMessage("note statement");
    Note otherNote = new Note();
    otherNote.setText("note of a note");
    Note otherNote2 = new Note();
    otherNote2.setText("note2 of a note");
    note.setLang("en");

    note = processThroughXml(note);

    assertEquals("hello, there", note.getText());
    assertEquals("subject", note.getSubject());
    assertEquals("note statement", note.getAttribution().getChangeMessage());
    assertEquals("en", note.getLang());
  }

  /**
   * tests note json
   */
  public void testNoteJson() throws Exception {
    Note note = new Note();
    note.setSubject("subject");
    note.setText("hello, there");
    note.setAttribution(new Attribution());
    note.getAttribution().setChangeMessage("note statement");
    note.setLang("en");

    note = processThroughJson(note);

    assertEquals("subject", note.getSubject());
    assertEquals("hello, there", note.getText());
    assertEquals("note statement", note.getAttribution().getChangeMessage());
    assertEquals("en", note.getLang());
  }

}
