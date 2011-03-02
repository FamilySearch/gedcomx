package org.familysearch.gedcom.rex.name;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

@XmlTransient
public class NameGenre {

  public static final QName CHINESE = new QName(GedcomConstants.GEDCOM_REX_NAMESPACE, "Chinese");
  public static final QName KANA = new QName(GedcomConstants.GEDCOM_REX_NAMESPACE, "Kana");
  public static final QName HANGUL = new QName(GedcomConstants.GEDCOM_REX_NAMESPACE, "Hangul");
  public static final QName CYRILLIC = new QName(GedcomConstants.GEDCOM_REX_NAMESPACE, "Cyrillic");
  public static final QName SPANISH = new QName(GedcomConstants.GEDCOM_REX_NAMESPACE, "Spanish");
  public static final QName PORTUGUESE = new QName(GedcomConstants.GEDCOM_REX_NAMESPACE, "Portugese");

}
