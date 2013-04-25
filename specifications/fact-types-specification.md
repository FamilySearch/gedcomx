# GEDCOM X Fact Types

## Status

This document enumerates a set of fact types to be used for genealogical data exchange,
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

An enumeration of types of facts provides the means for descriptions of facts about persons and
relationships to be semantically processed by applications, rather than being only interpreted by
people. This specification provides such an enumeration by identifying specific fact types and defining
the semantic significance of each type.

## 1.1 Identifier and Version

The identifier for this specification is:

`http://gedcomx.org/fact-types/v1`

For convenience, this specification may be referred to as "GEDCOM X Fact Types 1.0".
This specification uses "GEDCOM X Fact Types" internally.

## 1.2 Notational Conventions

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

## 1.2.1 The URI Reference

The Uniform Resource Identifier ("URI") is used to identify fact types. The URI is
specified by [RFC 3986](http://tools.ietf.org/html/rfc3986). This specification uses the term
"URI" to refer to both a "URI" and a "URI Reference" as defined by
[RFC 3986](http://tools.ietf.org/html/rfc3986).

# 2. Fact Types

This section specifies the set of fact types, grouping the types by 
whether a fact of the identified type is applicable to a person, couple relationship, 
or parent-child relationship.

## 2.1 Person Fact Types

Facts of the following types are applicable to a person:

URI | description 
----|------------
`http://gedcomx.org/Adoption`| A fact of a person's adoption. In the context of a parent-child relationship, it describes a fact of the adoption of a child by a parent.
`http://gedcomx.org/AdultChristening`| A fact of a person's christening or baptism as an adult.
`http://gedcomx.org/Amnesty`| A fact of a person's amnesty.
`http://gedcomx.org/Apprenticeship`| A fact of a person's apprenticeship.
`http://gedcomx.org/Baptism`| A fact of a person's baptism.
`http://gedcomx.org/BarMitzvah`| A fact of a person's bar mitzvah.
`http://gedcomx.org/BatMitzvah`| A fact of a person's bat mitzvah.
`http://gedcomx.org/Birth`| A fact of a person's birth.
`http://gedcomx.org/Blessing`| A fact of an official blessing received by a person, such as at the hands of a clergy member or at another religious rite.
`http://gedcomx.org/Burial`| A fact of the burial of person's body after death.
`http://gedcomx.org/Caste`| A fact of a person's caste.
`http://gedcomx.org/Census`| A fact of a person's participation in a census.
`http://gedcomx.org/Christening`| A fact of a person's christening *at birth*. Note: use `AdultChristening` for the christening as an adult.
`http://gedcomx.org/Circumcision`| A fact of a person's circumcision.
`http://gedcomx.org/Clan`| A fact of a person's clan.
`http://gedcomx.org/Confirmation`| A fact of a person's confirmation (or other rite of initiation) in a church or religion.
`http://gedcomx.org/Cremation`| A fact of the cremation of person's body after death.
`http://gedcomx.org/Death`| A fact of the death of a person.
`http://gedcomx.org/Education`| A fact of an education or an educational achievement (e.g. diploma, graduation, scholarship, etc.) of a person.
`http://gedcomx.org/Emigration`| A fact of the emigration of a person.
`http://gedcomx.org/Ethnicity`| A fact of a person's ethnicity or race.
`http://gedcomx.org/Excommunication`| A fact of a person's excommunication from a church.
`http://gedcomx.org/FirstCommunion`| A fact of a person's first communion in a church.
`http://gedcomx.org/Funeral`| A fact of a person's funeral.
`http://gedcomx.org/Heimat`| A fact of a person's _heimat_. "Heimat" refers to a person's affiliation by birth to a specific geographic place. Distinct heimaten are often useful as indicators that two persons of the same name are not likely to be closely related genealogically. In English, "heimat" may be described using terms like "ancestral home", "homeland", or "place of origin".
`http://gedcomx.org/Immigration`| A fact of a person's immigration.
`http://gedcomx.org/Imprisonment`| A fact of a person's imprisonment.
`http://gedcomx.org/LandTransation`| A fact of a land transaction enacted by a person.
`http://gedcomx.org/Living`| A fact of a record of a person's living for a specific period. This is designed to include "flourish", defined to mean the time period in an adult's life where he was most productive, perhaps as a writer or member of the state assembly. It does not reflect the person's birth and death dates.
`http://gedcomx.org/MaritalStatus`| A fact of a person's marital status.
`http://gedcomx.org/Medical`| A fact of a person's medical record, such as for an illness or hospital stay.
`http://gedcomx.org/MilitaryAward`| A fact of a person's military award.
`http://gedcomx.org/MilitaryDischarge`| A fact of a person's military discharge.
`http://gedcomx.org/MilitaryService`| A fact of a person's militray service.
`http://gedcomx.org/Mission`| A fact of a person's church mission.
`http://gedcomx.org/MoveTo`| A fact of a person's move (i.e. change of residence) to a new location.
`http://gedcomx.org/MoveFrom`| A fact of a person's move (i.e. change of residence) from a location.
`http://gedcomx.org/MultipleBirth`| A fact that a person was born as part of a multiple birth (e.g. twin, triplet, etc.)
`http://gedcomx.org/NationalId`| A fact of a person's national id (e.g. social security number).
`http://gedcomx.org/Nationality`| A fact of a person's nationality.
`http://gedcomx.org/Naturalization`| A fact of a person's naturalization (i.e. acquisition of citizenship and nationality).
`http://gedcomx.org/NumberOfChildren`| A fact of the number of children of a person or relationship.
`http://gedcomx.org/NumberOfMarriages`| A fact of a person's number of marriages.
`http://gedcomx.org/Occupation`| A fact of a person's occupation or employment.
`http://gedcomx.org/Ordination`| A fact of a person's ordination to a stewardship in a church.
`http://gedcomx.org/PhysicalDescription`| A fact of a person's physical description.
`http://gedcomx.org/Probate`| A fact of a receipt of probate of a person's property.
`http://gedcomx.org/Property`| A fact of a person's property or possessions.
`http://gedcomx.org/Religion`| A fact of a person's religion.
`http://gedcomx.org/Residence`| A fact of a person's residence.
`http://gedcomx.org/Retirement`| A fact of a person's retirement.
`http://gedcomx.org/Stillbirth`| A fact of a person's stillbirth.
`http://gedcomx.org/Will`| A fact of a person's will.
`http://gedcomx.org/Visit`| A fact of a person's visit to a place different from the person's residence.

## 2.2 Couple Relationship Fact Types

Facts of the following types are applicable to a couple relationship:

URI | description
----|------------
`http://gedcomx.org/Annulment`| The fact of an annulment of a marriage. | couple
`http://gedcomx.org/CommonLawMarriage`| The fact of a marriage by common law. | couple
`http://gedcomx.org/Divorce`| The fact of a divorce of a couple. | couple
`http://gedcomx.org/DivorceFiling`| The fact of a filing for divorce. | couple
`http://gedcomx.org/Engagement`| The fact of an engagement to be married. | couple
`http://gedcomx.org/Marriage`| The fact of a marriage. | couple
`http://gedcomx.org/MarriageBanns`| The fact of a marriage banns. | couple
`http://gedcomx.org/MarriageContract`| The fact of a marriage contract. | couple
`http://gedcomx.org/MarriageLicense`| The fact of a marriage license. | couple
`http://gedcomx.org/MarriageNotice`| The fact of a marriage notice. | couple
`http://gedcomx.org/NumberOfChildren`| A fact of the number of children of a person or relationship. | couple
`http://gedcomx.org/Separation`| A fact of a couple's separation. | couple

## 2.3 Parent-Child Relationship Fact Types

Facts of the following types are applicable to a parent-child relationship:

URI | description
----|------------
`http://gedcomx.org/AdoptiveParent`| A fact about an adoptive relationship between a parent an a child.
`http://gedcomx.org/BiologicalParent`| A fact the biological relationship between a parent and a child.
`http://gedcomx.org/FosterParent`| A fact about a foster relationship between a foster parent and a child.
`http://gedcomx.org/GuardianParent`| A fact about a legal guardianship between a parent and a child.
`http://gedcomx.org/StepParent`| A fact about the step relationship between a parent and a child.
`http://gedcomx.org/SociologicalParent`| A fact about a sociological relationship between a parent and a child, but not definable in typical legal or biological terms.
