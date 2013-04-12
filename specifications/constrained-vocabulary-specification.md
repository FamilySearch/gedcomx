# The GEDCOM X Constrained Vocabulary

## Status

This document specifies a constrained vocabulary of terms and types for genealogical data,
and requests discussion and suggestions for improvements.

The current state of this document is as a DRAFT, and as such, the document
may be subject to changes, including backwards-incompatible changes, according to the
discussion and suggestions for improvement.

## Copyright Notice

Copyright 2011-2013 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

# 1. Introduction

A vocabulary of terms and types for genealogical data provides the means for genealogical data to
be semantically processed by applications, rather than being only interpreted by people. This
specification provides such a vocabulary by defining the elements of the vocabulary, the semantic
significance of each element, and the ontological relationships between the elements.

## 1.1 Identifier and Version

The identifier for this specification is:

`http://gedcomx.org/vocabulary/v1`

For convenience, this specification may be referred to as "GEDCOM X Constrained Vocabulary 1.0".
This specification uses "GEDCOM X Vocabulary" internally.

## 1.2 Notational Conventions

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

## 1.2.1 The URI Reference

The Uniform Resource Identifier ("URI") is used to identify elements of the GEDCOM X
vocabulary. The URI is specified by [RFC 3986](http://tools.ietf.org/html/rfc3986).
This specification uses the term "URI" to refer to both a "URI" and a "URI Reference" as
defined by [RFC 3986](http://tools.ietf.org/html/rfc3986).

## 1.2.2 Classes and Subclasses

A basic step in any kind of description process is identifying the various kinds of
things to be described. This specification refers to a "kind of thing" as a "class", and
provides vocabulary elements for classes that are relevant to genealogical data.

Some classes define a relationship to other classes such that they provide a specialization
of the related classes. When one class is a specialization of another class, it is said
to be a "subclass" of the class that is specialized. A subclass inherits all the properties
of its parent class, and a class MAY be a subclass of more than one class.

# 2. Vocabulary Elements for Root Classes

The following elements of the GEDCOM X vocabulary identify the root-level classes of genealogical
data:

URI | description
----|-------------
`http://gedcomx.org/Person`| A person.
`http://gedcomx.org/Relationship`| A relationship between two persons.
`http://gedcomx.org/Event`| A historical event.
`http://gedcomx.org/EventRole`| A role played by a person in a historical event.
`http://gedcomx.org/Document`| A document.
`http://gedcomx.org/Date`| A date.
`http://gedcomx.org/Place`| A geographic place.
`http://gedcomx.org/Gender`| The gender of a person.
`http://gedcomx.org/Name`| The name of a person.
`http://gedcomx.org/NameForm`| A form or representation of a name of a person.
`http://gedcomx.org/NamePart`| A part of a name of a person.
`http://gedcomx.org/Fact`| A fact about a person or relationship

# 3. Vocabulary Elements for Subclasses

This section provides vocabulary elements for subclasses of genealogical data.

## 3.1 Person Subclasses

There are no subclasses of `http://gedcomx.org/Person` defined.

## 3.2 Relationship Subclasses

The following elements identify subclasses of the `http://gedcomx.org/Relationship` class:

URI | description
----|-------------
`http://gedcomx.org/Couple`| A relationship between two persons for the purposes of companionship, often for the purpose of starting a family and raising children.
`http://gedcomx.org/ParentChild`| A relationship from a parent to a child.

## 3.3 Event Subclasses

The following elements identify subclasses of the `http://gedcomx.org/Event` class:

URI | description
----|------------
`http://gedcomx.org/Adoption` | An adoption event.
`http://gedcomx.org/AdultChristening` | An adult christening event.
`http://gedcomx.org/Annulment` | An annulment event of a marriage.
`http://gedcomx.org/Baptism` | A baptism event.
`http://gedcomx.org/BarMitzvah` | A bar mitzvah event.
`http://gedcomx.org/BatMitzvah` | A bat mitzvah event.
`http://gedcomx.org/Birth` | A birth event.
`http://gedcomx.org/Blessing` | A an official blessing event, such as at the hands of a clergy member or at another religious rite.
`http://gedcomx.org/Burial` | A burial event.
`http://gedcomx.org/Census` | A census event.
`http://gedcomx.org/Christening` | A christening event *at birth*. Note: use `AdultChristening` for a christening event as an adult.
`http://gedcomx.org/Circumcision` | A circumcision event.
`http://gedcomx.org/Confirmation` | A confirmation event (or other rite of initiation) in a church or religion.
`http://gedcomx.org/Cremation` | A cremation event after death.
`http://gedcomx.org/Death` | A death event.
`http://gedcomx.org/Divorce` | A divorce event.
`http://gedcomx.org/DivorceFiling` | A divorce filing event.
`http://gedcomx.org/Education` | A education or an educational achievement event (e.g. diploma, graduation, scholarship, etc.).
`http://gedcomx.org/Engagement` | An engagement to be married event.
`http://gedcomx.org/Emigration` | An emigration event.
`http://gedcomx.org/Excommunication` | An excommunication event from a church.
`http://gedcomx.org/FirstCommunion` | A first communion event.
`http://gedcomx.org/Funeral` | A funeral event.
`http://gedcomx.org/Immigration` | An immigration event.
`http://gedcomx.org/LandTransation` | A land transaction event.
`http://gedcomx.org/Marriage` | A marriage event.
`http://gedcomx.org/MilitaryAward` | A military award event.
`http://gedcomx.org/MilitaryDischarge` | A military discharge event.
`http://gedcomx.org/Mission` | A mission event.
`http://gedcomx.org/MoveFrom` | An event of a move (i.e. change of residence) from a location.
`http://gedcomx.org/MoveTo` | An event of a move (i.e. change of residence) to a location.
`http://gedcomx.org/Naturalization` | A naturalization event (i.e. acquisition of citizenship and nationality).
`http://gedcomx.org/Ordination` | An ordination event.
`http://gedcomx.org/Retirement` | A retirement event.

## 3.4 Event Role Subclasses

The following elements identify subclasses of the `http://gedcomx.org/EventRole` class:

URI | description
----|------------
`http://gedcomx.org/Principal`| The "principal" role of the event. For example, the person of a birth event that was born was the "principal" of the event.
`http://gedcomx.org/Participant`| A participant in the event.
`http://gedcomx.org/Official`| An person officiating the event.
`http://gedcomx.org/Witness`| A witness of the event.

## 3.5 Document Subclasses

The following elements identify subclasses of the `http://gedcomx.org/Document` class:

URI | description
----|-------------
`http://gedcomx.org/Abstract` | The document is an abstract of a record or document.
`http://gedcomx.org/Transcription` | The document is a transcription of a record or document.
`http://gedcomx.org/Translation` | The document is a translation of a record or document.
`http://gedcomx.org/Analysis` | The document is an analysis done by a researcher, often used as a genealogical proof statement.

## 3.6 Date Subclasses

There are no subclasses of `http://gedcomx.org/Date` defined.

## 3.7 Place Subclasses

There are no subclasses of `http://gedcomx.org/Place` defined.

## 3.8 Gender Subclasses

The following elements identify subclasses of the  `http://gedcomx.org/Gender` class:

URI | description
----|-------------
`http://gedcomx.org/Male`| Male gender.
`http://gedcomx.org/Female`| Female gender.
`http://gedcomx.org/Unknown`| Unknown gender.

## 3.9 Name Subclasses

The following elements identify subclasses of the `http://gedcomx.org/Name` class:

URI | description
----|-------------
`http://gedcomx.org/BirthName` | Name given at birth.
`http://gedcomx.org/MarriedName` | Name accepted at marriage.
`http://gedcomx.org/AlsoKnownAs` | "Also known as" name.
`http://gedcomx.org/Nickname`| Nickname.
`http://gedcomx.org/AdoptiveName` | Name given at adoption.
`http://gedcomx.org/FormalName` | A formal name, usually given to distinguish it from a name more commonly used.
`http://gedcomx.org/ReligiousName` | A name given at a religious rite or ceremony.

## 3.10 Name Form Subclasses

There are no subclasses of `http://gedcomx.org/NameForm` defined.

## 3.11 Name Part Subclasses

The following elements identify subclasses of the `http://gedcomx.org/NamePart` class.

## 3.10.1 Context-Based Name Part Subclasses

The following subclasses of `http://gedcomx.org/NamePart` are used to identify the context
of the name part in relation to the (full) name.

URI | description
----|-------------
`http://gedcomx.org/Prefix`| A name prefix. 
`http://gedcomx.org/Suffix`| A name suffix.
`http://gedcomx.org/Given`| A given name.
`http://gedcomx.org/Surname`| A surname.

## 3.10.2 Usage-Based Name Part Subclasses

The following subclasses of `http://gedcomx.org/NamePart` are used to identify how the name part
was used by the person to which the name applies.

URI | description
----|-------------
`http://gedcomx.org/Title`|A designation for honorifics (e.g. Dr., Rev., His Majesty, Haji), ranks (e.g. Colonel, General, Knight, Esquire), positions (e.g. Count, Chief, Father, King) or other titles (e.g., PhD, MD).
`http://gedcomx.org/Primary`|A designation for the name of most prominent in importance among the names of that type (e.g., the primary given name).
`http://gedcomx.org/Secondary`|A designation for a name that is not primary in its importance among the names of that type (e.g., a secondary given name).
`http://gedcomx.org/Middle`|A designation useful for cultures that designate a middle name that is distinct from a given name and a surname.
`http://gedcomx.org/Familiar`|A designation for one's familiar name. The qualifier value SHOULD NOT be used.
`http://gedcomx.org/Religious`|A designation for a name given for religious purposes. The qualifier value SHOULD NOT be used.
`http://gedcomx.org/Family`|A name that associates a person with a group, such as a clan, tribe, or patriarchal hierarchy.
`http://gedcomx.org/Maiden`|A designation given by women to their original surname after they adopt a new surname upon marriage.
`http://gedcomx.org/Patronymic`|A name derived from a father or paternal ancestor.
`http://gedcomx.org/Matronymic`|A name derived from a mother or maternal ancestor.
`http://gedcomx.org/Geographic`|A name derived from associated geography.
`http://gedcomx.org/Occupational`|A name derived from one's occupation.
`http://gedcomx.org/Characteristic`|A name derived from a characteristic.
`http://gedcomx.org/Postnom`|A name mandedated by law populations from Congo Free State / Belgian Congo / Congo / Democratic Republic of Congo (formerly Zaire).
`http://gedcomx.org/Particle`|A grammatical designation for articles (a, the, dem, las, el, etc.), prepositions (of, from, aus, zu, op, etc.), initials (e.g. PhD, MD), annotations (e.g. twin, wife of, infant, unknown), comparators (e.g. Junior, Senior, younger, little), ordinals (e.g. III, eighth), and conjunctions (e.g. and, or, nee, ou, y, o, ne, &amp;).


## 3.12 Fact Subclasses

The following elements identify subclasses of the `http://gedcomx.org/Fact` class. Subclasses of `Fact` also
specify a class as the value of the "scope" of the subclass. The subclass is only applicable within the context
of its scope.

URI | description | scope
----|-------------|------
`http://gedcomx.org/Adoption`| A fact of a person's adoption. In the context of a parent-child relationship, it describes a fact of the adoption of a child by a parent. | `http://gedcomx.org/Person`
`http://gedcomx.org/AdultChristening`| A fact of a person's christening or baptism as an adult. | `http://gedcomx.org/Person`
`http://gedcomx.org/Amnesty`| A fact of a person's amnesty. | `http://gedcomx.org/Person`
`http://gedcomx.org/Apprenticeship`| A fact of a person's apprenticeship. | `http://gedcomx.org/Person`
`http://gedcomx.org/Baptism`| A fact of a person's baptism. | `http://gedcomx.org/Person`
`http://gedcomx.org/BarMitzvah`| A fact of a person's bar mitzvah. | `http://gedcomx.org/Person`
`http://gedcomx.org/BatMitzvah`| A fact of a person's bat mitzvah. | `http://gedcomx.org/Person`
`http://gedcomx.org/Birth`| A fact of a person's birth. | `http://gedcomx.org/Person`
`http://gedcomx.org/Blessing`| A fact of an official blessing received by a person, such as at the hands of a clergy member or at another religious rite. | `http://gedcomx.org/Person`
`http://gedcomx.org/Burial`| A fact of the burial of person's body after death. | `http://gedcomx.org/Person`
`http://gedcomx.org/Caste`| A fact of a person's caste. | `http://gedcomx.org/Person`
`http://gedcomx.org/Census`| A fact of a person's participation in a census. | `http://gedcomx.org/Person`
`http://gedcomx.org/Christening`| A fact of a person's christening *at birth*. Note: use `AdultChristening` for the christening as an adult. | `http://gedcomx.org/Person`
`http://gedcomx.org/Circumcision`| A fact of a person's circumcision. | `http://gedcomx.org/Person`
`http://gedcomx.org/Clan`| A fact of a person's clan. | `http://gedcomx.org/Person`
`http://gedcomx.org/Confirmation`| A fact of a person's confirmation (or other rite of initiation) in a church or religion. | `http://gedcomx.org/Person`
`http://gedcomx.org/Cremation`| A fact of the cremation of person's body after death. | `http://gedcomx.org/Person`
`http://gedcomx.org/Death`| A fact of the death of a person. | `http://gedcomx.org/Person`
`http://gedcomx.org/Education`| A fact of an education or an educational achievement (e.g. diploma, graduation, scholarship, etc.) of a person. | `http://gedcomx.org/Person`
`http://gedcomx.org/Emigration`| A fact of the emigration of a person. | `http://gedcomx.org/Person`
`http://gedcomx.org/Ethnicity`| A fact of a person's ethnicity or race. | `http://gedcomx.org/Person`
`http://gedcomx.org/Excommunication`| A fact of a person's excommunication from a church. | `http://gedcomx.org/Person`
`http://gedcomx.org/FirstCommunion`| A fact of a person's first communion in a church. | `http://gedcomx.org/Person`
`http://gedcomx.org/Funeral`| A fact of a person's funeral. | `http://gedcomx.org/Person`
`http://gedcomx.org/Immigration`| A fact of a person's immigration. | `http://gedcomx.org/Person`
`http://gedcomx.org/Imprisonment`| A fact of a person's imprisonment. | `http://gedcomx.org/Person`
`http://gedcomx.org/LandTransation`| A fact of a land transaction enacted by a person. | `http://gedcomx.org/Person`
`http://gedcomx.org/Living`| A fact of a record of a person's living for a specific period. This is designed to include "flourish", defined to mean the time period in an adult's life where he was most productive, perhaps as a writer or member of the state assembly. It does not reflect the person's birth and death dates. | `http://gedcomx.org/Person`
`http://gedcomx.org/MaritalStatus`| A fact of a person's marital status. | `http://gedcomx.org/Person`
`http://gedcomx.org/Medical`| A fact of a person's medical record, such as for an illness or hospital stay. | `http://gedcomx.org/Person`
`http://gedcomx.org/MilitaryAward`| A fact of a person's military award. | `http://gedcomx.org/Person`
`http://gedcomx.org/MilitaryDischarge`| A fact of a person's military discharge. | `http://gedcomx.org/Person`
`http://gedcomx.org/MilitaryService`| A fact of a person's militray service. | `http://gedcomx.org/Person`
`http://gedcomx.org/Mission`| A fact of a person's church mission. | `http://gedcomx.org/Person`
`http://gedcomx.org/MoveTo`| A fact of a person's move (i.e. change of residence) to a new location. | `http://gedcomx.org/Person`
`http://gedcomx.org/MoveFrom`| A fact of a person's move (i.e. change of residence) from a location. | `http://gedcomx.org/Person`
`http://gedcomx.org/MultipleBirth`| A fact that a person was born as part of a multiple birth (e.g. twin, triplet, etc.) | `http://gedcomx.org/Person`
`http://gedcomx.org/NationalId`| A fact of a person's national id (e.g. social security number). | `http://gedcomx.org/Person`
`http://gedcomx.org/Nationality`| A fact of a person's nationality. | `http://gedcomx.org/Person`
`http://gedcomx.org/Naturalization`| A fact of a person's naturalization (i.e. acquisition of citizenship and nationality). | `http://gedcomx.org/Person`
`http://gedcomx.org/NumberOfChildren`| A fact of the number of children of a person or relationship. | `http://gedcomx.org/Person`
`http://gedcomx.org/NumberOfMarriages`| A fact of a person's number of marriages. | `http://gedcomx.org/Person`
`http://gedcomx.org/Occupation`| A fact of a person's occupation or employment. | `http://gedcomx.org/Person`
`http://gedcomx.org/Ordination`| A fact of a person's ordination to a stewardship in a church. | `http://gedcomx.org/Person`
`http://gedcomx.org/PhysicalDescription`| A fact of a person's physical description. | `http://gedcomx.org/Person`
`http://gedcomx.org/Probate`| A fact of a receipt of probate of a person's property. | `http://gedcomx.org/Person`
`http://gedcomx.org/Property`| A fact of a person's property or possessions. | `http://gedcomx.org/Person`
`http://gedcomx.org/Religion`| A fact of a person's religion. | `http://gedcomx.org/Person`
`http://gedcomx.org/Residence`| A fact of a person's residence. | `http://gedcomx.org/Person`
`http://gedcomx.org/Retirement`| A fact of a person's retirement. | `http://gedcomx.org/Person`
`http://gedcomx.org/Stillbirth`| A fact of a person's stillbirth. | `http://gedcomx.org/Person`
`http://gedcomx.org/Will`| A fact of a person's will. | `http://gedcomx.org/Person`
`http://gedcomx.org/Visit`| A fact of a person's visit to a place different from the person's residence. | `http://gedcomx.org/Person`
`http://gedcomx.org/Annulment`| The fact of an annulment of a marriage. | `http://gedcomx.org/Couple`
`http://gedcomx.org/CommonLawMarriage`| The fact of a marriage by common law. | `http://gedcomx.org/Couple`
`http://gedcomx.org/Divorce`| The fact of a divorce of a couple. | `http://gedcomx.org/Couple`
`http://gedcomx.org/DivorceFiling`| The fact of a filing for divorce. | `http://gedcomx.org/Couple`
`http://gedcomx.org/Engagement`| The fact of an engagement to be married. | `http://gedcomx.org/Couple`
`http://gedcomx.org/Marriage`| The fact of a marriage. | `http://gedcomx.org/Couple`
`http://gedcomx.org/MarriageBanns`| The fact of a marriage banns. | `http://gedcomx.org/Couple`
`http://gedcomx.org/MarriageContract`| The fact of a marriage contract. | `http://gedcomx.org/Couple`
`http://gedcomx.org/MarriageLicense`| The fact of a marriage license. | `http://gedcomx.org/Couple`
`http://gedcomx.org/MarriageNotice`| The fact of a marriage notice. | `http://gedcomx.org/Couple`
`http://gedcomx.org/NumberOfChildren`| A fact of the number of children of a person or relationship. | `http://gedcomx.org/Couple`
`http://gedcomx.org/Separation`| A fact of a couple's separation. | `http://gedcomx.org/Couple`
`http://gedcomx.org/AdoptiveParent`| A fact about an adoptive relationship between a parent an a child. | `http://gedcomx.org/ParentChild`
`http://gedcomx.org/BiologicalParent`| A fact the biological relationship between a parent and a child. | `http://gedcomx.org/ParentChild`
`http://gedcomx.org/FosterParent`| A fact about a foster relationship between a foster parent and a child. | `http://gedcomx.org/ParentChild`
`http://gedcomx.org/GuardianParent`| A fact about a legal guardianship between a parent and a child. | `http://gedcomx.org/ParentChild`
`http://gedcomx.org/StepParent`| A fact about the step relationship between a parent and a child. | `http://gedcomx.org/ParentChild`
`http://gedcomx.org/SociologicalParent`| A fact about a sociological relationship between a parent and a child, but not definable in typical legal or biological terms. | `http://gedcomx.org/ParentChild`

# 4. Miscellaneous Classes

This section provides vocabulary elements for other miscellaneous classes that are useful to the description of genealogical data.

## 4.1 Classes of Confidence Levels

The following elements of the GEDCOM X vocabulary identify classes used for providing a researcher's confidence level
in certain genealogical data:

URI | description
----|------------
`http://gedcomx.org/High`|The contributor has a high degree of confidence that the assertion is true.
`http://gedcomx.org/Medium`|The contributor has a medium degree of confidence that the assertion is true.
`http://gedcomx.org/Low`|The contributor has a low degree of confidence that the assertion is true.

