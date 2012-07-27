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
    note.setText(new TextValue("hello, there"));
    note.setAttribution(new Attribution());
    note.getAttribution().setChangeMessage("note statement");
    Note otherNote = new Note();
    otherNote.setText(new TextValue("note of a note"));
    Note otherNote2 = new Note();
    otherNote2.setText(new TextValue("note2 of a note"));
    note.getText().setLang("en");

    note = processThroughXml(note);

    assertEquals("hello, there", note.getText().getValue());
    assertEquals("note statement", note.getAttribution().getChangeMessage());
    assertEquals("en", note.getText().getLang());
  }

  /**
   * tests note json
   */
  public void testNoteJson() throws Exception {
    Note note = new Note();
    note.setText(new TextValue("hello, there"));
    note.setAttribution(new Attribution());
    note.getAttribution().setChangeMessage("note statement");
    note.getText().setLang("en");

    note = processThroughJson(note);

    assertEquals("hello, there", note.getText().getValue());
    assertEquals("note statement", note.getAttribution().getChangeMessage());
    assertEquals("en", note.getText().getLang());
  }

}
