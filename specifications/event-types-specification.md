# GEDCOM X Event Types

## Status

This document enumerates a set of event types to be used for genealogical data exchange,
and requests discussion and suggestions for improvements.

The current state of this document is as a "stable draft", and as such, the document
may be subject to limited changes, BUT NOT backwards-incompatible changes, according to the
discussion and suggestions for improvement.

## Copyright Notice

Copyright 2011-2013 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

# 1. Introduction

An enumeration of types of events provides the means for descriptions of historical events to
be semantically processed by applications, rather than being only interpreted by people. This
specification provides such an enumeration by identifying specific event types and defining
the semantic significance of each type.

## 1.1 Identifier and Version

The identifier for this specification is:

`http://gedcomx.org/event-types/v1`

For convenience, this specification may be referred to as "GEDCOM X Event Types 1.0".
This specification uses "GEDCOM X Event Types" internally.

## 1.2 Notational Conventions

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

## 1.2.1 The URI Reference

The Uniform Resource Identifier ("URI") is used to identify event types. The URI is
specified by [RFC 3986](http://tools.ietf.org/html/rfc3986). This specification uses the term
"URI" to refer to both a "URI" and a "URI Reference" as defined by
[RFC 3986](http://tools.ietf.org/html/rfc3986).

# 2. Event Types

The following event types are specified:

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
`http://gedcomx.org/LandTransaction` | A land transaction event.
`http://gedcomx.org/Marriage` | A marriage event.
`http://gedcomx.org/MilitaryAward` | A military award event.
`http://gedcomx.org/MilitaryDischarge` | A military discharge event.
`http://gedcomx.org/Mission` | A mission event.
`http://gedcomx.org/MoveFrom` | An event of a move (i.e. change of residence) from a location.
`http://gedcomx.org/MoveTo` | An event of a move (i.e. change of residence) to a location.
`http://gedcomx.org/Naturalization` | A naturalization event (i.e. acquisition of citizenship and nationality).
`http://gedcomx.org/Ordination` | An ordination event.
`http://gedcomx.org/Retirement` | A retirement event.