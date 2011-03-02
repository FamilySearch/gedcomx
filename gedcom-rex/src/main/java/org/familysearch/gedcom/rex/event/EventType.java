package org.familysearch.gedcom.rex.event;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the known types of events.
 *
 * @author Merlin Carpenter
 *         Date: Aug 8, 2008
 */
@XmlTransient
public class EventType {

  private EventType() {}

  public static final QName ADOPTION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "adoption");
  public static final QName ADULT_CHRISTENING = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "adult_christening");
  public static final QName ANNULMENT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "annulment");
  public static final QName BAPTISM = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "baptism");
  public static final QName BAR_MITZVAH = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "bar_mitzvah");
  public static final QName BAS_MITZVAH = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "bas_mitzvah");
  public static final QName BIRTH = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "birth");
  public static final QName BLESSING = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "blessing");
  public static final QName BURIAL = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "burial");
  public static final QName CENSUS = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "census");
  public static final QName CHRISTENING = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "christening");
  public static final QName CIRCUMCISION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "circumcision");
  public static final QName CONFIRMATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "confirmation");
  public static final QName CREMATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "cremation");
  public static final QName DEATH = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "death");
  public static final QName DIVORCE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "divorce");
  public static final QName DIVORCE_FILING = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "divorce_filing");
  public static final QName EMIGRATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "emigration");
  public static final QName ENGAGEMENT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "engagement");
  public static final QName EXCOMMUNICATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "excommunication");
  public static final QName FIRST_COMMUNION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "first_communion");
  public static final QName FLOURISH = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "flourish");
  public static final QName FUNERAL = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "funeral");
  public static final QName GRADUATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "graduation");
  public static final QName ILLNESS = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "illness");
  public static final QName IMMIGRATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "immigration");
  public static final QName INTERMENT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "interment");
  public static final QName MARRIAGE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "marriage");
  public static final QName MARRIAGE_BANNS = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "marriage_banns");
  public static final QName MARRIAGE_CONTRACT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "marriage_contract");
  public static final QName MARRIAGE_LICENSE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "marriage_license");
  public static final QName MARRIAGE_NOTICE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "marriage_notice");
  public static final QName MARRIAGE_SETTLEMENT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "marriage_settlement");
  public static final QName MILITARY_AWARD = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "military_award");
  public static final QName MILITARY_DISCHARGE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "military_discharge");
  public static final QName MILITARY_SERVICE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "military_service");
  public static final QName MISSION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "mission");
  public static final QName MOVE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "move");
  public static final QName NATURALIZATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "naturalization");
  public static final QName ORDINANCE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "ordinance");
  public static final QName ORDINATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "ordination");
  public static final QName PROBATE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "probate");
  public static final QName RESIDENCE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "residence");
  public static final QName RETIREMENT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "retirement");
  public static final QName SEPARATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "separation");
  public static final QName WILL = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_NAMESPACE, "will");

  // LDS ordinances
  public static final QName LDS_BAPTISM = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_LDS_NAMESPACE, "baptism");
  public static final QName LDS_CONFIRMATION = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_LDS_NAMESPACE, "confirmation");
  public static final QName LDS_INITIATORY = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_LDS_NAMESPACE, "initiatory");
  public static final QName LDS_ENDOWMENT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_LDS_NAMESPACE, "endowment");
  public static final QName LDS_SEALING_SPOUSE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_LDS_NAMESPACE, "sealing_to_spouse");
  public static final QName LDS_SEALING_PARENT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_LDS_NAMESPACE, "sealing_to_parents");
  public static final QName LDS_LICENSED_MARRIAGE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_LDS_NAMESPACE, "licensed_marriage");
  public static final QName LDS_TIME_ONLY_MARRIAGE = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_LDS_NAMESPACE, "time_only_marriage");

  public final static Set<QName> BIRTHLIKE_EVENT_TYPES = Collections.unmodifiableSet(new HashSet<QName>(Arrays.asList(BAPTISM, BIRTH, CHRISTENING, BLESSING, CIRCUMCISION, ADOPTION)));
  public final static Set<QName> DEATHLIKE_EVENT_TYPES = Collections.unmodifiableSet(new HashSet<QName>(Arrays.asList(DEATH, BURIAL, CREMATION, FUNERAL, INTERMENT, PROBATE, WILL)));
  public final static Set<QName> MARRIAGELIKE_EVENT_TYPES = Collections.unmodifiableSet(new HashSet<QName>(Arrays.asList(MARRIAGE, ENGAGEMENT, MARRIAGE_BANNS, MARRIAGE_CONTRACT, MARRIAGE_LICENSE, MARRIAGE_NOTICE, MARRIAGE_SETTLEMENT, LDS_SEALING_SPOUSE, LDS_LICENSED_MARRIAGE, LDS_TIME_ONLY_MARRIAGE)));
  public final static Set<QName> DIVORCELIKE_EVENT_TYPES = Collections.unmodifiableSet(new HashSet<QName>(Arrays.asList(DIVORCE, DIVORCE_FILING, ANNULMENT, SEPARATION)));
  public final static Set<QName> MIGRATIONLIKE_EVENT_TYPES = Collections.unmodifiableSet(new HashSet<QName>(Arrays.asList(IMMIGRATION, EMIGRATION, NATURALIZATION, MOVE)));

}
