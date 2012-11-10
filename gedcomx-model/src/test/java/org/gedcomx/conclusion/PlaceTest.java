package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.TextValue;
import org.gedcomx.common.URI;
import org.gedcomx.types.IdentifierType;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


public class PlaceTest {
  @Test
  public void testPlace_Tikhvin() throws Exception {
    Place tikhvin = new Place();

    assertNull(tikhvin.getNames());
    assertEquals(tikhvin.getLatitude(), 0d);
    assertEquals(tikhvin.getLongitude(), 0d);
    assertNull(tikhvin.getIdentifiers());
    assertNull(tikhvin.getAttribution());
    assertNull(tikhvin.getExtensionElements());

    tikhvin.setNames(new ArrayList<TextValue>());
    tikhvin.getNames().add(new TextValue());
    tikhvin.getNames().add(new TextValue());
    tikhvin.getNames().add(new TextValue());
    tikhvin.getNames().get(0).setLang("ru-Cyrl");
    tikhvin.getNames().get(0).setValue("Ти́хвин");
    tikhvin.getNames().get(1).setLang("ru-Latn");
    tikhvin.getNames().get(1).setValue("Tikhvin");
    tikhvin.getNames().get(2).setLang("en-Latn");
    tikhvin.getNames().get(2).setValue("Tikhvin");
    tikhvin.setLatitude(59.6436111d);
    tikhvin.setLongitude(33.5094444d);
    tikhvin.setIdentifiers(new ArrayList<Identifier>());
    tikhvin.getIdentifiers().add(new Identifier());
    tikhvin.getIdentifiers().get(0).setKnownType(IdentifierType.Primary);
    tikhvin.getIdentifiers().get(0).setValue(URI.create("https://labs.familysearch.org/stdfinder/PlaceDetail.jsp?placeId=3262902"));
    tikhvin.setAttribution(new Attribution());
    tikhvin.getAttribution().setContributor(new ResourceReference(URI.create("urn:contributorId")));
    tikhvin.getAttribution().setModified(new java.util.Date(1321027871111L)); // 11 Nov 2011 11:11:11.111
    tikhvin.addExtensionElement("tikhvin-junkExtensionElement");

    assertEquals(tikhvin.getNames().get(0).getLang(), "ru-Cyrl");
    assertEquals(tikhvin.getNames().get(0).getValue(), "Ти́хвин");
    assertEquals(tikhvin.getNames().get(1).getLang(), "ru-Latn");
    assertEquals(tikhvin.getNames().get(1).getValue(), "Tikhvin");
    assertEquals(tikhvin.getNames().get(2).getLang(), "en-Latn");
    assertEquals(tikhvin.getNames().get(2).getValue(), "Tikhvin");
    assertEquals(tikhvin.getLatitude(), 59.6436111d);
    assertEquals(tikhvin.getLongitude(), 33.5094444d);
    assertEquals(tikhvin.getIdentifiers().get(0).getKnownType(), IdentifierType.Primary);
    assertEquals(tikhvin.getIdentifiers().get(0).getValue().toURI().toString(), "https://labs.familysearch.org/stdfinder/PlaceDetail.jsp?placeId=3262902");
    assertEquals(tikhvin.getAttribution().getContributor().getResource().toURI().toString(), "urn:contributorId");
    assertEquals(tikhvin.getAttribution().getModified().getTime(), 1321027871111L);
    assertEquals(tikhvin.findExtensionOfType(String.class), "tikhvin-junkExtensionElement");
  }

  @Test
  public void testPlaceDescription_Tikhvin() throws Exception {
    PlaceDescription tikhvinDesc = new PlaceDescription();

    assertNull(tikhvinDesc.getAbout());
    assertNull(tikhvinDesc.getNames());
    assertNull(tikhvinDesc.getType());
    assertNull(tikhvinDesc.getTemporalDescription());
    assertNull(tikhvinDesc.getSpatialDescription());
    assertNull(tikhvinDesc.getAttribution());
    assertNull(tikhvinDesc.getExtensionElements());

    tikhvinDesc.setAbout(URI.create("#tikhvin"));
    tikhvinDesc.setNames(new ArrayList<TextValue>());
    tikhvinDesc.getNames().add(new TextValue());
    tikhvinDesc.getNames().add(new TextValue());
    tikhvinDesc.getNames().add(new TextValue());
    tikhvinDesc.getNames().get(0).setLang("ru-Cyrl");
    tikhvinDesc.getNames().get(0).setValue("Ти́хвин, Ленингра́дская о́бласть, Россия");
    tikhvinDesc.getNames().get(1).setLang("ru-Latn");
    tikhvinDesc.getNames().get(1).setValue("Tikhvin, Leningradskaya Oblast', Rossiya");
    tikhvinDesc.getNames().get(2).setLang("en-Latn");
    tikhvinDesc.getNames().get(2).setValue("Tikhvin, Leningrad Oblast, Russia");
    tikhvinDesc.setType(URI.create("urn:place-authority/city"));
    tikhvinDesc.setTemporalDescription(new Date());
    tikhvinDesc.getTemporalDescription().setFormal("A+1383/");
    tikhvinDesc.setSpatialDescription(new ResourceReference(URI.create("data:application/vnd.google-earth.kml+xml;base64," +
                                                                         "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxrbWwgeG1sbnM9Imh0dHA6" +
                                                                         "Ly93d3cub3Blbmdpcy5uZXQva21sLzIuMiIgeG1sbnM6Z3g9Imh0dHA6Ly93d3cuZ29vZ2xlLmNv" +
                                                                         "bS9rbWwvZXh0LzIuMiIgeG1sbnM6a21sPSJodHRwOi8vd3d3Lm9wZW5naXMubmV0L2ttbC8yLjIi" +
                                                                         "IHhtbG5zOmF0b209Imh0dHA6Ly93d3cudzMub3JnLzIwMDUvQXRvbSI+DQo8UGxhY2VtYXJrIGlk" +
                                                                         "PSIyMSI+DQoJPG5hbWU+VGlraHZpbiwgTGVuaW5ncmFkIE9ibGFzdCwgUnVzc2lhPC9uYW1lPg0K" +
                                                                         "CTxNdWx0aUdlb21ldHJ5Pg0KCQk8UG9pbnQ+DQoJCTxjb29yZGluYXRlcz4zMy41LDU5LjYzMzMz" +
                                                                         "MzAwMDAwMDAxLDA8L2Nvb3JkaW5hdGVzPg0KCQk8L1BvaW50Pg0KCQk8TGluZWFyUmluZz4NCgkJ" +
                                                                         "CTxjb29yZGluYXRlcz4NCgkJCQkzMy40NTA5Niw1OS42MTYxNTk0LDAgMzMuNDUwOTYsNTkuNjUw" +
                                                                         "NTA2NiwwIDMzLjU0OTA0LDU5LjY1MDUwNjYsMCAzMy41NDkwNCw1OS42MTYxNTk0LDAgMzMuNDUw" +
                                                                         "OTYsNTkuNjE2MTU5NCwwIA0KCQkJPC9jb29yZGluYXRlcz4NCgkJPC9MaW5lYXJSaW5nPg0KCTwv" +
                                                                         "TXVsdGlHZW9tZXRyeT4NCjwvUGxhY2VtYXJrPg0KPC9rbWw+DQo=")));
    tikhvinDesc.setIdentifiers(new ArrayList<Identifier>());
    tikhvinDesc.getIdentifiers().add(new Identifier());
    tikhvinDesc.getIdentifiers().get(0).setKnownType(IdentifierType.Primary);
    tikhvinDesc.getIdentifiers().get(0).setValue(URI.create("https://labs.familysearch.org/stdfinder/PlaceDetail.jsp?placeId=3262902#placeDescriptionId"));
    tikhvinDesc.setAttribution(new Attribution());
    tikhvinDesc.getAttribution().setContributor(new ResourceReference(URI.create("urn:contributorId")));
    tikhvinDesc.getAttribution().setModified(new java.util.Date(1321027871111L)); // 11 Nov 2011 11:11:11.111
    tikhvinDesc.addExtensionElement("tikhvinDesc-junkExtensionElement");

    assertEquals(tikhvinDesc.getAbout().toURI().toString(), "#tikhvin");
    assertEquals(tikhvinDesc.getNames().get(0).getLang(), "ru-Cyrl");
    assertEquals(tikhvinDesc.getNames().get(0).getValue(), "Ти́хвин, Ленингра́дская о́бласть, Россия");
    assertEquals(tikhvinDesc.getNames().get(1).getLang(), "ru-Latn");
    assertEquals(tikhvinDesc.getNames().get(1).getValue(), "Tikhvin, Leningradskaya Oblast', Rossiya");
    assertEquals(tikhvinDesc.getNames().get(2).getLang(), "en-Latn");
    assertEquals(tikhvinDesc.getNames().get(2).getValue(), "Tikhvin, Leningrad Oblast, Russia");
    assertEquals(tikhvinDesc.getType().toURI().toString(), "urn:place-authority/city");
    assertEquals(tikhvinDesc.getTemporalDescription().getFormal(), "A+1383/");
    assertEquals(tikhvinDesc.getSpatialDescription().getResource().toURI().toString(), "data:application/vnd.google-earth.kml+xml;base64," +
      "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxrbWwgeG1sbnM9Imh0dHA6" +
      "Ly93d3cub3Blbmdpcy5uZXQva21sLzIuMiIgeG1sbnM6Z3g9Imh0dHA6Ly93d3cuZ29vZ2xlLmNv" +
      "bS9rbWwvZXh0LzIuMiIgeG1sbnM6a21sPSJodHRwOi8vd3d3Lm9wZW5naXMubmV0L2ttbC8yLjIi" +
      "IHhtbG5zOmF0b209Imh0dHA6Ly93d3cudzMub3JnLzIwMDUvQXRvbSI+DQo8UGxhY2VtYXJrIGlk" +
      "PSIyMSI+DQoJPG5hbWU+VGlraHZpbiwgTGVuaW5ncmFkIE9ibGFzdCwgUnVzc2lhPC9uYW1lPg0K" +
      "CTxNdWx0aUdlb21ldHJ5Pg0KCQk8UG9pbnQ+DQoJCTxjb29yZGluYXRlcz4zMy41LDU5LjYzMzMz" +
      "MzAwMDAwMDAxLDA8L2Nvb3JkaW5hdGVzPg0KCQk8L1BvaW50Pg0KCQk8TGluZWFyUmluZz4NCgkJ" +
      "CTxjb29yZGluYXRlcz4NCgkJCQkzMy40NTA5Niw1OS42MTYxNTk0LDAgMzMuNDUwOTYsNTkuNjUw" +
      "NTA2NiwwIDMzLjU0OTA0LDU5LjY1MDUwNjYsMCAzMy41NDkwNCw1OS42MTYxNTk0LDAgMzMuNDUw" +
      "OTYsNTkuNjE2MTU5NCwwIA0KCQkJPC9jb29yZGluYXRlcz4NCgkJPC9MaW5lYXJSaW5nPg0KCTwv" +
      "TXVsdGlHZW9tZXRyeT4NCjwvUGxhY2VtYXJrPg0KPC9rbWw+DQo=");
    assertEquals(tikhvinDesc.getIdentifiers().get(0).getKnownType(), IdentifierType.Primary);
    assertEquals(tikhvinDesc.getIdentifiers().get(0).getValue().toURI().toString(), "https://labs.familysearch.org/stdfinder/PlaceDetail.jsp?placeId=3262902#placeDescriptionId");
    assertEquals(tikhvinDesc.getAttribution().getContributor().getResource().toURI().toString(), "urn:contributorId");
    assertEquals(tikhvinDesc.getAttribution().getModified().getTime(), 1321027871111L);
    assertEquals(tikhvinDesc.findExtensionOfType(String.class), "tikhvinDesc-junkExtensionElement");
  }

  @Test
  public void testPlaceReference_Tikhvin() throws Exception {
    PlaceReference tikhvinRef = new PlaceReference();

    assertNull(tikhvinRef.getOriginal());
    assertNull(tikhvinRef.getDescriptionRef());
    assertNull(tikhvinRef.getExtensionElements());

    tikhvinRef.setOriginal("Tikhvin, Leningradskaya Oblast, Russia");
    tikhvinRef.setDescriptionRef(URI.create("#tikhvinDesc1"));
    tikhvinRef.addExtensionElement("tikhvinRef-junkExtensionElement");

    assertEquals(tikhvinRef.getOriginal(), "Tikhvin, Leningradskaya Oblast, Russia");
    assertEquals(tikhvinRef.getDescriptionRef().toURI().toString(), "#tikhvinDesc1");
    assertEquals(tikhvinRef.findExtensionOfType(String.class), "tikhvinRef-junkExtensionElement");
    assertEquals(tikhvinRef.toString(), "PlaceReference{original='Tikhvin, Leningradskaya Oblast, Russia', descriptionRef='#tikhvinDesc1'}");
  }

  @Test
  public void testPlace_Luga() throws Exception {
    Place luga = new Place();

    assertNull(luga.getNames());
    assertEquals(luga.getLatitude(), 0d);
    assertEquals(luga.getLongitude(), 0d);
    assertNull(luga.getIdentifiers());
    assertNull(luga.getAttribution());
    assertNull(luga.getExtensionElements());

    luga.setNames(new ArrayList<TextValue>());
    luga.getNames().add(new TextValue());
    luga.getNames().add(new TextValue());
    luga.getNames().add(new TextValue());
    luga.getNames().get(0).setLang("ru-Cyrl");
    luga.getNames().get(0).setValue("Лу́га");
    luga.getNames().get(1).setLang("ru-Latn");
    luga.getNames().get(1).setValue("Luga");
    luga.getNames().get(2).setLang("en-Latn");
    luga.getNames().get(2).setValue("Luga");
    luga.setLatitude(58.7372222d);
    luga.setLongitude(29.8452778d);
    luga.setIdentifiers(new ArrayList<Identifier>());
    luga.getIdentifiers().add(new Identifier());
    luga.getIdentifiers().get(0).setKnownType(IdentifierType.Primary);
    luga.getIdentifiers().get(0).setValue(URI.create("https://labs.familysearch.org/stdfinder/PlaceDetail.jsp?placeId=3314013"));
    luga.setAttribution(new Attribution());
    luga.getAttribution().setContributor(new ResourceReference(URI.create("urn:contributorId")));
    luga.getAttribution().setModified(new java.util.Date(1321027871111L)); // 11 Nov 2011 11:11:11.111
    luga.addExtensionElement("luga-junkExtensionElement");

    assertEquals(luga.getNames().get(0).getLang(), "ru-Cyrl");
    assertEquals(luga.getNames().get(0).getValue(), "Лу́га");
    assertEquals(luga.getNames().get(1).getLang(), "ru-Latn");
    assertEquals(luga.getNames().get(1).getValue(), "Luga");
    assertEquals(luga.getNames().get(2).getLang(), "en-Latn");
    assertEquals(luga.getNames().get(2).getValue(), "Luga");
    assertEquals(luga.getLatitude(), 58.7372222d);
    assertEquals(luga.getLongitude(), 29.8452778d);
    assertEquals(luga.getIdentifiers().get(0).getKnownType(), IdentifierType.Primary);
    assertEquals(luga.getIdentifiers().get(0).getValue().toURI().toString(), "https://labs.familysearch.org/stdfinder/PlaceDetail.jsp?placeId=3314013");
    assertEquals(luga.getAttribution().getContributor().getResource().toURI().toString(), "urn:contributorId");
    assertEquals(luga.getAttribution().getModified().getTime(), 1321027871111L);
    assertEquals(luga.findExtensionOfType(String.class), "luga-junkExtensionElement");
  }

  @Test
  public void testPlaceDescription_Luga() throws Exception {
    PlaceDescription lugaDesc = new PlaceDescription();

    assertNull(lugaDesc.getAbout());
    assertNull(lugaDesc.getNames());
    assertNull(lugaDesc.getType());
    assertNull(lugaDesc.getTemporalDescription());
    assertNull(lugaDesc.getSpatialDescription());
    assertNull(lugaDesc.getAttribution());
    assertNull(lugaDesc.getExtensionElements());

    lugaDesc.setAbout(URI.create("#luga"));
    lugaDesc.setNames(new ArrayList<TextValue>());
    lugaDesc.getNames().add(new TextValue());
    lugaDesc.getNames().add(new TextValue());
    lugaDesc.getNames().add(new TextValue());
    lugaDesc.getNames().get(0).setLang("ru-Cyrl");
    lugaDesc.getNames().get(0).setValue("Лу́га, Новгоро́дская о́бласть, Россия");
    lugaDesc.getNames().get(1).setLang("ru-Latn");
    lugaDesc.getNames().get(1).setValue("Luga, Leningradskaya Oblast', Rossiya");
    lugaDesc.getNames().get(2).setLang("en-Latn");
    lugaDesc.getNames().get(2).setValue("Luga, Leningrad Oblast, Russia");
    lugaDesc.setType(URI.create("urn:place-authority/city"));
    lugaDesc.setTemporalDescription(new Date());
    lugaDesc.getTemporalDescription().setFormal("+1777-08-03/");
    lugaDesc.setSpatialDescription(new ResourceReference(URI.create("data:application/vnd.google-earth.kml+xml;base64," +
                                                                      "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxrbWwgeG1sbnM9Imh0dHA6" +
                                                                      "Ly93d3cub3Blbmdpcy5uZXQva21sLzIuMiIgeG1sbnM6Z3g9Imh0dHA6Ly93d3cuZ29vZ2xlLmNv" +
                                                                      "bS9rbWwvZXh0LzIuMiIgeG1sbnM6a21sPSJodHRwOi8vd3d3Lm9wZW5naXMubmV0L2ttbC8yLjIi" +
                                                                      "IHhtbG5zOmF0b209Imh0dHA6Ly93d3cudzMub3JnLzIwMDUvQXRvbSI+DQo8UGxhY2VtYXJrPg0K" +
                                                                      "CTxuYW1lPkx1Z2EsIExlbmluZ3JhZCBPYmxhc3QsIFJ1c3NpYTwvbmFtZT4NCgk8TXVsdGlHZW9t" +
                                                                      "ZXRyeT4NCgkJPFBvaW50Pg0KCQk8Y29vcmRpbmF0ZXM+MjkuODQ3OTY2LDU4LjczNTIxMywwPC9j" +
                                                                      "b29yZGluYXRlcz4NCgkJPC9Qb2ludD4NCgkJPExpbmVhclJpbmc+DQoJCQk8Y29vcmRpbmF0ZXM+" +
                                                                      "DQoJCQkJMjkuODA1NTQzMiw1OC43MDA4MjY2LDAgMjkuODA1NTQzMiw1OC43Njk1OTk0LDAgMjku" +
                                                                      "ODkwMzg4OCw1OC43Njk1OTk0LDAgMjkuODkwMzg4OCw1OC43MDA4MjY2LDAgMjkuODA1NTQzMiw1" +
                                                                      "OC43MDA4MjY2LDAgDQoJCQk8L2Nvb3JkaW5hdGVzPg0KCQk8L0xpbmVhclJpbmc+DQoJPC9NdWx0" +
                                                                      "aUdlb21ldHJ5Pg0KPC9QbGFjZW1hcms+DQo8L2ttbD4NCg==")));
    lugaDesc.setIdentifiers(new ArrayList<Identifier>());
    lugaDesc.getIdentifiers().add(new Identifier());
    lugaDesc.getIdentifiers().get(0).setKnownType(IdentifierType.Primary);
    lugaDesc.getIdentifiers().get(0).setValue(URI.create("https://labs.familysearch.org/stdfinder/PlaceDetail.jsp?placeId=3314013#placeDescriptionId"));
    lugaDesc.setAttribution(new Attribution());
    lugaDesc.getAttribution().setContributor(new ResourceReference(URI.create("urn:contributorId")));
    lugaDesc.getAttribution().setModified(new java.util.Date(1321027871111L)); // 11 Nov 2011 11:11:11.111
    lugaDesc.addExtensionElement("lugaDesc-junkExtensionElement");

    assertEquals(lugaDesc.getAbout().toURI().toString(), "#luga");
    assertEquals(lugaDesc.getNames().get(0).getLang(), "ru-Cyrl");
    assertEquals(lugaDesc.getNames().get(0).getValue(), "Лу́га, Новгоро́дская о́бласть, Россия");
    assertEquals(lugaDesc.getNames().get(1).getLang(), "ru-Latn");
    assertEquals(lugaDesc.getNames().get(1).getValue(), "Luga, Leningradskaya Oblast', Rossiya");
    assertEquals(lugaDesc.getNames().get(2).getLang(), "en-Latn");
    assertEquals(lugaDesc.getNames().get(2).getValue(), "Luga, Leningrad Oblast, Russia");
    assertEquals(lugaDesc.getType().toURI().toString(), "urn:place-authority/city");
    assertEquals(lugaDesc.getTemporalDescription().getFormal(), "+1777-08-03/");
    assertEquals(lugaDesc.getSpatialDescription().getResource().toURI().toString(), "data:application/vnd.google-earth.kml+xml;base64," +
      "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxrbWwgeG1sbnM9Imh0dHA6" +
      "Ly93d3cub3Blbmdpcy5uZXQva21sLzIuMiIgeG1sbnM6Z3g9Imh0dHA6Ly93d3cuZ29vZ2xlLmNv" +
      "bS9rbWwvZXh0LzIuMiIgeG1sbnM6a21sPSJodHRwOi8vd3d3Lm9wZW5naXMubmV0L2ttbC8yLjIi" +
      "IHhtbG5zOmF0b209Imh0dHA6Ly93d3cudzMub3JnLzIwMDUvQXRvbSI+DQo8UGxhY2VtYXJrPg0K" +
      "CTxuYW1lPkx1Z2EsIExlbmluZ3JhZCBPYmxhc3QsIFJ1c3NpYTwvbmFtZT4NCgk8TXVsdGlHZW9t" +
      "ZXRyeT4NCgkJPFBvaW50Pg0KCQk8Y29vcmRpbmF0ZXM+MjkuODQ3OTY2LDU4LjczNTIxMywwPC9j" +
      "b29yZGluYXRlcz4NCgkJPC9Qb2ludD4NCgkJPExpbmVhclJpbmc+DQoJCQk8Y29vcmRpbmF0ZXM+" +
      "DQoJCQkJMjkuODA1NTQzMiw1OC43MDA4MjY2LDAgMjkuODA1NTQzMiw1OC43Njk1OTk0LDAgMjku" +
      "ODkwMzg4OCw1OC43Njk1OTk0LDAgMjkuODkwMzg4OCw1OC43MDA4MjY2LDAgMjkuODA1NTQzMiw1" +
      "OC43MDA4MjY2LDAgDQoJCQk8L2Nvb3JkaW5hdGVzPg0KCQk8L0xpbmVhclJpbmc+DQoJPC9NdWx0" +
      "aUdlb21ldHJ5Pg0KPC9QbGFjZW1hcms+DQo8L2ttbD4NCg==");
    assertEquals(lugaDesc.getIdentifiers().get(0).getKnownType(), IdentifierType.Primary);
    assertEquals(lugaDesc.getIdentifiers().get(0).getValue().toURI().toString(), "https://labs.familysearch.org/stdfinder/PlaceDetail.jsp?placeId=3314013#placeDescriptionId");
    assertEquals(lugaDesc.getAttribution().getContributor().getResource().toURI().toString(), "urn:contributorId");
    assertEquals(lugaDesc.getAttribution().getModified().getTime(), 1321027871111L);
    assertEquals(lugaDesc.findExtensionOfType(String.class), "lugaDesc-junkExtensionElement");
  }

  @Test
  public void testPlaceReference_Luga() throws Exception {
    PlaceReference lugaRef = new PlaceReference();

    assertNull(lugaRef.getOriginal());
    assertNull(lugaRef.getDescriptionRef());
    assertNull(lugaRef.getExtensionElements());

    lugaRef.setOriginal("Luga, Leningradskaya Oblast', Russia");
    lugaRef.setDescriptionRef(URI.create("#lugaDesc1"));
    lugaRef.addExtensionElement("lugaRef-junkExtensionElement");

    assertEquals(lugaRef.getOriginal(), "Luga, Leningradskaya Oblast', Russia");
    assertEquals(lugaRef.getDescriptionRef().toURI().toString(), "#lugaDesc1");
    assertEquals(lugaRef.findExtensionOfType(String.class), "lugaRef-junkExtensionElement");
    assertEquals(lugaRef.toString(), "PlaceReference{original='Luga, Leningradskaya Oblast', Russia', descriptionRef='#lugaDesc1'}");
  }
}
