# The GEDCOM X Structured Data Specification

## Status

This document provides a formal schema for a vocabulary of genealogical information for use
in structured data (RDFa, Microdata, JSON-LD, etc.), and requests discussion and suggestions for improvements.

The current state of this document is as a DRAFT, and as such, the document
may be subject to changes, including backwards-incompatible changes, according to the
discussion and suggestions for improvement.

## Copyright Notice

Copyright 2011-2015 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

## Summary

The GEDCOM X Structured Data specification defines a formal vocabulary for genealogical data for use in structured data (RDFa, Microdata, JSON-LD, etc.).


<a name="intro"/>

# 1. Introduction

## Table Of Contents

* [1. Introduction](#intro)
  * [1.1 Identifier, Version and Dependencies](#id-and-version)
  * [1.2 Notational Conventions](#notational-conventions)
    * [1.2.1 Keywords](#keywords)
  * [1.3 Definitions](#definitions)
    * [1.3.1 Data Types and Properties](#data-properties)
    * [1.3.2 Data Instances](#data-instances)
    * [1.3.3 Basic Data Types](#data-types)
    * [1.3.4 The URI Reference](#uri)
    * [1.3.5 Original and Normalized Values](#formal-values)
    * [1.3.6 Enumerated Values](#enumerated-value)
    * [1.3.7 Controlled Vocabularies](#controlled-vocab)
    * [1.3.8 Text Types](#text-types)
  * [1.4 Internationalization Considerations](#il8n)
* [2. Top-Level Data Types](#top-data-types)
  * [2.1 The "Person" Data Type](#person)
  * [2.2 The "Relationship" Data Type](#relationship)
    * [2.2.1 Known Relationship Types](#known-relationship-types)
  * [2.3 The "SourceDescription" Data Type](#source-description)
    * [2.3.1 Known Resource Types](#known-resource-types)
  * [2.4 The "Agent" Data Type](#agent)
  * [2.5 The "Event" Data Type](#event)
    * [2.5.1 Known Event Types](#known-event-types)
    * [2.5.2 Events Versus Facts](#events-vs-facts)
  * [2.6 The "Document" Data Type](#document)
    * [2.6.1 Known Document Types](#known-document-types)
  * [2.7 The "PlaceDescription" Data Type](#place-description)
* [3. Component-Level Data Types](#component-data-types)
  * [3.1 The "Identifier" Data Type](#identifier-type)
  * [3.2 The "Attribution" Data Type](#attribution)
  * [3.3 The "Note" Data Type](#note)
  * [3.4 The "TextValue" Data Type](#text-value)
  * [3.5 The "SourceCitation" Data Type](#source-citation)
  * [3.6 The "SourceReference" Data Type](#source-reference)
  * [3.7 The "EvidenceReference" Data Type](#evidence-reference)
  * [3.8 The "OnlineAccount" Data Type](#online-account)
  * [3.9 The "Address" Data Type](#address)
  * [3.10 The "Conclusion" Data Type](#conclusion)
    * [3.10.1 Known Confidence Levels](#known-confidence-levels)
  * [3.11 The "Subject" Data Type](#subject)
  * [3.12 The "Gender" Data Type](#gender)
    * [3.12.1 Known Gender Types](#known-gender-types)
  * [3.13 The "Name" Data Type](#name-conclusion)
    * [3.13.1 Known Name Types](#known-name-types)
  * [3.14 The "Fact" Data Type](#3-fact-conclusion)
    * [3.14.1 Known Fact Types](#known-fact-types)
    * [3.14.2 Known Fact Qualifiers](#known-fact-qualifier)
  * [3.15 The "EventRole" Data Type](#conclusion-event-role)
    * [3.15.1 Known Role Types](#known-roles)
  * [3.16 The "Date" Data Type](#conclusion-date)
  * [3.17 The "PlaceReference" Data Type](#conclusion-place-reference)
  * [3.18 The "NamePart" Data Type](#name-part)
    * [3.18.1 Known Name Part Types](#known-name-part-types)
  * [3.19 The "NameForm" Data Type](#name-form)
  * [3.20 The "Qualifier" Data Type](#qualifier)
* [4. Extracted Conclusion Constraints](#extracted-conclusion-constraints)
  * [4.1 Persona](#persona)
* [5. Extensibility](#extensibility)
  * [5.1 Data Type Extensions](#data-type-extensions)
  * [5.2 Enumerated Value Extensions](#enumerated-value-extensions)
    * [5.2.1 User-Defined Enumerated Values](#user-enumerated-values)
  * [5.3 Extension Properties](#extension-properties)
  * [5.4 Processing Extension](#processing-extensions)

<a name="id-and-version"/>

## 1.1 Identifier, Version and Dependencies

The identifier for this specification is:

`http://gedcomx.org/structured-data/v1`

For convenience, the GEDCOM X Structured Data specification may be referred to as "GEDCOM X Structured Data 1.0".
This specification uses "GEDCOM X" or "GEDCOM X Structured Data" internally.

This specification formalizes the data types defined by the GEDCOM X Conceptual Model specification identified
by [`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).

<a name="notational-conventions"/>

## 1.2 Notational Conventions

<a name="keywords"/>

### 1.2.1 Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

<div vocab="http://gedcomx.org/v1/>

# 2. Top-Level Data Types

The data types in this section are designated as "top-level" data types because they define the
top-level units of genealogical data. A GEDCOM X data set is defined as a collection of instances
of top-level data types. The definitions of top-level data types stand separately
from the definitions of other top-level data types and the lifecycle of instances of these data
types is distinct from the lifecycle of instances of the other top-level data types.

<a name="person"/>

<div typeof="rdfs:Class" resource="http://gedcomx.org/v1/Person">

## 2.1 The "Person" Data Type

<span property="rdfs:Comment">The `Person` data type defines a description of a person.</span>

### identifier

The identifier for the `Person` data type is:

`http://gedcomx.org/v1/Person`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Subject`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
private | Whether this instance of `Person` has been designated for limited distribution or display. | boolean | OPTIONAL. A description of how implementations should use private data is outside the scope of this specification.
gender | The gender of the person. | [`http://gedcomx.org/v1/Gender`](#gender) | OPTIONAL.
names | The names of the person. | List of [`http://gedcomx.org/v1/Name`](#name-conclusion). Order is preserved. | OPTIONAL.  If more than one name is provided, names are assumed to be given in order of preference, with the most preferred name in the first position in the list.
facts | The facts of the person. | List of [`http://gedcomx.org/v1/Fact`](#fact-conclusion). Order is preserved. | OPTIONAL.

</div>

<a name="relationship"/>

## 2.2 The "Relationship" Data Type

The `Relationship` data type describes a relationship between two persons.

### identifier

The identifier for the `Relationship` data type is:

`http://gedcomx.org/v1/Relationship`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Subject`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
type | Enumerated value identifying the type of the relationship. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify a relationship type, and use of a [known relationship type](#known-relationship-types) is RECOMMENDED.
person1 | Reference to the first person in the relationship. | [URI](#uri) | REQUIRED. MUST resolve to an instance of [`http://gedcomx.org/v1/Person`](#person)
person2 | Reference to the second person in the relationship. | [URI](#uri) | REQUIRED. MUST resolve to an instance of [`http://gedcomx.org/v1/Person`](#person)
facts | The facts about the relationship. | List of [`http://gedcomx.org/v1/Fact`](#fact-conclusion). Order is preserved. | OPTIONAL.

Note: when a relationship type implies direction, the relationship is said to
be *from* person1 *to* person2. For example, in a parent-child relationship, the
relationship is said to be "from a parent to a child"; therefore, the `person1`
property refers to the parent and the `person2` property refers to the child.

<a name="known-relationship-types"/>

### 2.2.1 Known Relationship Types

The following relationship types are defined by GEDCOM X:

URI | description
----|-------------
`http://gedcomx.org/Couple`| A relationship of a pair of persons.
`http://gedcomx.org/ParentChild`| A relationship from a parent to a child.


<a name="source-description"/>

## 2.3 The "SourceDescription" Data Type

The `SourceDescription` data type defines a description of a source of genealogical information.

### identifier

The identifier for the "SourceDescription" data type is:

`http://gedcomx.org/v1/SourceDescription`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
id | An identifier for the data structure holding the source description data. | string | OPTIONAL.  The id is to be used as a "fragment identifier" as defined by [RFC 3986, Section 3.5](http://tools.ietf.org/html/rfc3986#section-3.5). As such, the constraints of the id are provided in the definition of the media type (e.g. XML, JSON) of the data structure.
resourceType | Enumerated value identifying the type of resource being described. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify a resource type, and use of a [known resource type](#known-resource-types) is RECOMMENDED.
citations | The citation(s) for this source. | [`http://gedcomx.org/v1/SourceCitation`](#source-citation). Order is preserved. | REQUIRED.  At least one citation MUST be provided. If more than one citation is provided, citations are assumed to be given in order of preference, with the most preferred citation in the first position in the list.
mediaType | A hint about the media type of the resource being described. | string | OPTIONAL. If provided, MUST be a valid MIME (media) type as specified by [RFC 4288](http://tools.ietf.org/html/rfc4288).
about | A uniform resource identifier (URI) for the resource being described. | [URI](#uri) | OPTIONAL.
mediator | A reference to the entity that mediates access to the described source. | [URI](#uri) | OPTIONAL. If provided, MUST resolve to an instance of [`http://gedcomx.org/v1/Agent`](#agent).
sources | A list of references to any sources from which this source is derived. | List of [`http://gedcomx.org/v1/SourceReference`](#source-reference) | OPTIONAL.
analysis  | A reference to a document containing analysis about this source. | [URI](#uri) | OPTIONAL. If provided, MUST resolve to an instance of [`http://gedcomx.org/v1/Document`](#document) of type `http://gedcomx.org/Analysis`.
componentOf | A reference to the source that contains this source, i.e. its parent context. Used when the description of a source is not complete without the description of its parent (or containing) source. | [`http://gedcomx.org/v1/SourceReference`](#source-reference) | OPTIONAL.
titles | The display name(s) for this source. | List of [`http://gedcomx.org/TextValue`](#text-value). Order is preserved. | OPTIONAL. If more than one title is provided, titles are assumed to be given in order of preference, with the most preferred title in the first position in the list.
notes  | A list of notes about a source. | List of [`http://gedcomx.org/Note`](#note) | OPTIONAL.
attribution | The attribution of this source description. | [`http://gedcomx.org/Attribution`](#attribution) | OPTIONAL. If not provided, the attribution of the containing data set (e.g. file) of the source description is assumed.
rights  | The rights for this resource. | List of [URI](#uri). Order is preserved. | OPTIONAL. If provided, MUST resolve to a resource that describes the rights associated with the resource being described.
coverage | The coverage of the resource. | [`http://gedcomx.org/v1/Coverage`](#coverage) | OPTIONAL.
descriptions | Human-readable descriptions of this source. | List of [`http://gedcomx.org/TextValue`](#text-value). Order is preserved. | OPTIONAL. If more than one description is provided, descriptions are assumed to be given in order of preference, with the most preferred description in the first position in the list.
identifiers | A list of identifiers for the resource being described. | List of [`http://gedcomx.org/v1/Identifier`](#identifier-type). Order is preserved. | OPTIONAL.
created | Timestamp of when the resource being described was created. | timestamp | OPTIONAL.
modified | Timestamp of when the resource being described was modified. | timestamp | OPTIONAL.
repository | A reference to the repository that contains the described resource. | [URI](#uri) | OPTIONAL. If provided, MUST resolve to an instance of [`http://gedcomx.org/v1/Agent`](#agent).

<a name="known-resource-types"/>

### 2.3.1 Known Resource Types

The following resource types are identified by GEDCOM X:

URI | description
----|------------
`http://gedcomx.org/Collection` | A collection of genealogical resources. A collection may contain physical artifacts (such as a collection of books in a library), records (such as the 1940 U.S. Census), or digital artifacts (such as an online genealogical application).
`http://gedcomx.org/PhysicalArtifact` | A physical artifact, such as a book.
`http://gedcomx.org/DigitalArtifact` | A digital artifact, such as a digital image of a birth certificate or other record.
`http://gedcomx.org/Record` | A historical record, such as a census record or a vital record.


<a name="agent"/>

## 2.4 The "Agent" Data Type

The `Agent` data type defines someone or something that curates genealogical data, such as a genealogical researcher, user of software, or organization.

### identifier

The identifier for the `Agent` data type is:

`http://gedcomx.org/v1/Agent`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
id | An identifier for the data structure holding the agent data. | string | OPTIONAL.  The id is to be used as a "fragment identifier" as defined by [RFC 3986, Section 3.5](http://tools.ietf.org/html/rfc3986#section-3.5). As such, the constraints of the id are provided in the definition of the media type (e.g. XML, JSON) of the data structure.
identifiers | A list of identifiers for the agent. | List of [`http://gedcomx.org/v1/Identifier`](#identifier-type). Order is preserved. | OPTIONAL.
names | The name(s) of the person or organization.| List of [`http://gedcomx.org/TextValue`](#text-value).  Order is preserved. | OPTIONAL.   If more than one name is provided, names are assumed to be given in order of preference, with the most preferred name in the first position in the list.
homepage | The homepage of the person or organization. | [URI](#uri) | OPTIONAL.
openid  | The [openid](http://openid.net/) of the person or organization. | [URI](#uri) | OPTIONAL.
accounts  | The online account(s) of the person or organization. | List of [`http://gedcomx.org/v1/OnlineAccount`](#online-account). Order is preserved. | OPTIONAL.
emails  | The email address(es) of the person or organization. | List of [URI](#uri). Order is preserved. | OPTIONAL.  If provided, MUST resolve to a valid e-mail address (e.g. "mailto:someone@gedcomx.org").
phones  | The phone(s) (voice, fax, mobile) of the person or organization. | List of [URI](#uri). Order is preserved. | OPTIONAL. If provided, MUST resolve to a valid phone number (e.g. "tel:+1-201-555-0123").
addresses  | The address(es) of the person or organization. | List of [`http://gedcomx.org/v1/Address`](#address). Order is preserved. | OPTIONAL.
person | A reference to the person that describes this agent. | [URI](#uri) | OPTIONAL. MUST resolve to an instance of [`http://gedcomx.org/v1/Person`](#person).


<a name="event"/>

## 2.5 The "Event" Data Type

The `Event` data type defines a description of a historical event.

### identifier

The identifier for the `Event` data type is:

`http://gedcomx.org/v1/Event`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Subject`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
type | Enumerated value identifying the type of the event. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify an event type, and use of a [known event type](#known-event-types) is RECOMMENDED.
date | The date of the event. | [`http://gedcomx.org/v1/Date`](#conclusion-date) | OPTIONAL.
place | A reference to the place applicable to this event. | [`http://gedcomx.org/v1/PlaceReference`](#conclusion-place-reference) | OPTIONAL.
roles | Information about how persons participated in the event. | List of [`http://gedcomx.org/v1/EventRole`](#conclusion-event-role). Order is preserved. | OPTIONAL.

<a name="known-event-types"/>

### 2.5.1 Known Event Types

The following event types are defined by GEDCOM X:

URI | description
----|------------
`http://gedcomx.org/Adoption` | An adoption event.
`http://gedcomx.org/Birth` | A birth event.
`http://gedcomx.org/Burial` | A burial event.
`http://gedcomx.org/Census` | A census event.
`http://gedcomx.org/Christening` | A christening event *at birth*. Note that this enumerated value does not identify an adult christening.
`http://gedcomx.org/Death` | A death event.
`http://gedcomx.org/Divorce` | A divorce event.
`http://gedcomx.org/Marriage` | A marriage event.

In addition to these elements, processors SHOULD support any other elements defined by the
[GEDCOM X Event Types](https://github.com/FamilySearch/gedcomx/blob/master/specifications/event-types-specification.md) specification.

<a name="events-vs-facts"/>

### 2.5.2 Events Versus Facts

GEDCOM X implementations need to be able to recognize the difference between the concept of an "event" and the concept of a "fact"
as defined by this specification in order to correctly use the data types associated with these concepts. This section is provided
for the purpose of explicitly defining and distinguishing the two concepts.

An "event" is an occurrence that happened at a specific time or period of time, often at a specific place or set of places. Genealogically
relevant events are often described by referencing the persons that played a role in that event. Hence events often refer to persons
and might infer relationships, but events are described independently of those persons and relationships.

A "fact" is a data item that is presumed to be true about a specific subject, such as a person or relationship. A time or place is
often, but not always, applicable to a fact. Facts do not exist outside the scope of the subject to which they apply.

Events are often used to infer facts. A marriage event, for example, infers the fact that two persons were married, and birth event
infers the fact that a person was born. Facts also sometimes infer events, but the existence of a fact might not always justify a
description of an event. For example, a birth fact provided by a census record might not warrant a description of a birth event, even
though the existence of such an event is implied. On the other hand, a birth record that provides information about biological
parents, adoptive parents, additional witnesses, etc. might justify a description of the event in addition to descriptions of any
facts provided by the record.

Despite the occasional inference of facts from events and vice versa, this specification dictates that the two concepts
are described independently. This version of the specification does not provide a direct association between instances of the two
data types, although an indirect association can be found via the event role.


<a name="document"/>

## 2.6 The "Document" Data Type

The `Document` data type defines the base conceptual model for genealogical data that are managed as textual documents.

### identifier

The identifier for the `Document` data type is:

`http://gedcomx.org/v1/Document`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Conclusion`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
type | Enumerated value identifying the type of the document. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify a document type, and use of a [known document type](#known-document-types) is RECOMMENDED.
extracted | Whether this document is to be constrained as an _extracted conclusion_. | boolean | OPTIONAL. Default: `false`. Refer to [Extracted Conclusion Constraints](#extracted-conclusion-constraints).
textType | The type of text in the `text` property. | string | OPTIONAL. If provided, the value MUST be a [valid text type](#text-types).  If no value is provided, "plain" is assumed.
text | The text of the document. | string | REQUIRED.
attribution | The attribution of the document. | [`http://gedcomx.org/Attribution`](#attribution) | OPTIONAL. If not provided, the attribution of the containing data set (e.g. file) of the document is assumed.

<a name="known-document-types"/>

### 2.6.1 Known Document Types

The following document types are defined by GEDCOM X:

URI | description
----|-------------
`http://gedcomx.org/Abstract` | The document is an abstract of a record or document.
`http://gedcomx.org/Transcription` | The document is a transcription of a record or document.
`http://gedcomx.org/Translation` | The document is a translation of a record or document.
`http://gedcomx.org/Analysis` | The document is an analysis done by a researcher; a genealogical proof statement is an example of one kind of analysis document.


<a name="place-description"/>

## 2.7 The "PlaceDescription" Data Type

The `PlaceDescription` data type describes the details of a place in terms of its name
and possibly its type, time period, and/or a geospatial description -- functioning as a description
of a place as a snapshot in time.

### identifier

The identifier for the `PlaceDescription` data type is:

`http://gedcomx.org/v1/PlaceDescription`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Subject`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
names | A list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place. | List of [`http://gedcomx.org/v1/TextValue`](#text-value). Order is preserved. | REQUIRED. The list MUST contain at least one name.
type | An implementation-specific uniform resource identifier (URI) used to identify the type of a place (e.g., address, city, county, province, state, country, etc.). | [Enumerated Value](#enumerated-value) | OPTIONAL.  There is no current definition of a set of known place types.
place | An identifier for the place being described. | [URI](#uri) | OPTIONAL. Descriptions that provide the same value for `place` are interpreted as alternate descriptions of the same place. If provided, MUST NOT use a base URI of `http://gedcomx.org/`. If provided, the value MAY resolve to an external resource that is application-specific and outside the scope of this specification.
jurisdiction | A reference to a description of the jurisdiction of this place. | [URI](#uri) | OPTIONAL. If provided, MUST resolve to an instance of [`http://gedcomx.org/v1/PlaceDescription`](#place-description).
latitude | Angular distance, in degrees, north or south of the Equator (0.0 degrees). | double | OPTIONAL.  If provided, MUST provide `longitude` also.  Values range from −90.0 degrees (south of the equator) to 90.0 degrees (north of the equator). It is assumed that descriptions that provide the same value for the `place` property share identical `longitude` values.
longitude | Angular distance, in degrees, east or west of the Prime Meridian (0.0 degrees). | double | OPTIONAL.  If provided, MUST provide `latitude` also.  Values range from −180.0 degrees (west of the Meridian) to 180.0 degrees (east of the Meridian). It is assumed that descriptions that provide the same value for the `place` property share identical `latitude` values.
temporalDescription | A description of the time period to which this place description is relevant. | [`http://gedcomx.org/v1/Date`](#conclusion-date) | OPTIONAL.
spatialDescription | A reference to a geospatial description of this place. | [`URI`](#uri) | OPTIONAL. It is RECOMMENDED that this geospatial description resolve to a [KML](http://en.wikipedia.org/wiki/Keyhole_Markup_Language) document.

<a name="component-data-types"/>

# 3. Component-Level Data Types

The data types in this section are designated as "component-level" data types because they are
designed to be referenced and re-used by other data types, most notably the top-level data types.
The lifecycle of instances of these data types is generally tied to the lifecycle of instances of
a top-level data type.


<a name="identifier-type"></a>

## 3.1 The "Identifier" Data Type

The `Identifier` data type defines the data structure used to supply an identifier of a genealogical resource.

The `Identifier` data type does NOT support extension properties (see [Extension Properties](#extension-properties)).

### identifier

The identifier for the "Identifier" data type is:

`http://gedcomx.org/v1/Identifier`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
value | The value of the identifier. | [URI](#uri) | REQUIRED.
type  | Enumerated value that identifies how the identifier is to be used and the nature of the resource to which the identifier resolves. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify an identifier type, and use of a [known identifier type](#known-identifier-types) is RECOMMENDED. If no type is provided, the usage and nature of the identifier is application-specific.

<a name="known-identifier-types"/>

### known identifier types

The following identifier types are defined by GEDCOM X.

URI | description
----|------------
`http://gedcomx.org/Primary` | The primary identifier for the resource. The value of the identifier MUST resolve to the instance of `Subject` to which the identifier applies.
`http://gedcomx.org/Authority` | An identifier for the resource in an external authority or other expert system. The value of the identifier MUST resolve to a public, authoritative, source for information about the `Subject` to which the identifier applies.
`http://gedcomx.org/Deprecated` | An identifier that has been relegated, deprecated, or otherwise downgraded. This identifier is commonly used as the result of a merge when what was once a primary identifier for a resource is no longer the primary identifier. The value of the identifier MUST resolve to the instance of `Subject` to which the identifier applies.

### examples

* An instance of `Person` with an identifier of type `http://gedcomx.org/Primary` and value "12345" is merged into an
  instance of `Person` with an identifier of type `http://gedcomx.org/Primary` and value "67890". Person "67890" assumes
  an identifier of type `http://gedcomx.org/Deprecated` and value "12345". The identifier type `http://gedcomx.org/Deprecated`
  is used because the merged person "12345" now has identifier of type `http://gedcomx.org/Primary` with value "67890".
* A description of Salt Lake City, Utah, United States is provided using an instance of `PlaceDescription`. Salt Lake City is
  maintained in the [Geographic Names Information System (GNIS)](http://geonames.usgs.gov/), an external place authority. The
  description of Salt Lake City might identify the associated GNIS resource using an identifier of type
  `http://gedcomx.org/Authority` with value "http://geonames.usgs.gov/pls/gnispublic/f?p=gnispq:3:::NO::P3_FID:2411771".


<a name="attribution"/>

## 3.2 The "Attribution" Data Type

The `Attribution` data type defines the data structure used to attribute _who_, _when_, and _why_ to
genealogical data. Data is attributed to the agent who made the _latest significant change_ to the nature
of the data being attributed. The definition of a "significant change" is outside the scope of this specification
and is left to the implementer of the application.

#### The Granularity of Attribution

The granularity of data that is attributed varies widely from application to application. Some highly collaborative applications
might take a fine-grained approach, tracking attribution at the level of names and facts. Single-user
applications might simply provide attribution for a large set of data, such as an entire data tree. GEDCOM X explicitly
defines attribution for top-level entities such as persons, relationships, and documents, as well as for some other specific
data types such as notes and source references. However, GEDCOM X also recognizes attribution as an extension property that can
be applied at a finer level of granularity. (For more information about extension properties, see Section 6). For all data types
where attribution is explicitly recognized, it is an OPTIONAL property.

If data is not explicitly attributed, the attribution for the data is assumed to be the attribution for the containing
data. For example, if no attribution is provided for the name of a person (as an extension property of the name), then the
attribution for the name is assumed to be the attribution of the person that contains the name. If no attribution for the
person is provided, the attribution is assumed to be the attribution for the data set that contains the person.

### identifier

The identifier for the "Attribution" data type is:

`http://gedcomx.org/v1/Attribution`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
contributor | Reference to the agent to whom the attributed data is attributed. | [URI](#uri) | OPTIONAL. If provided, MUST resolve to an instance of [`http://gedcomx.org/v1/Agent`](#agent).
modified | Timestamp of when the attributed data was contributed. | timestamp | OPTIONAL.
changeMessage | A statement of why the attributed data is being provided by the contributor. | string | OPTIONAL.


<a name="note"/>

## 3.3 The "Note" Data Type

The `Note` data type defines a note that was contributed from genealogical research.

Notes are not intended to contain genealogical conclusions.  Notes are only associated with a single genealogical resource.

### identifier

The identifier for the "Note" data type is:

`http://gedcomx.org/v1/Note`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
lang | The locale identifier for the note. | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag | OPTIONAL. If not provided, the locale is determined per [Internationalization Considerations](#i18n).
subject | A subject or title for the note. | string | OPTIONAL.
text | The text of the note. | string | REQUIRED.
attribution | The attribution of this note. | [`http://gedcomx.org/Attribution`](#attribution) | OPTIONAL. If not provided, the attribution of the containing resource of the note is assumed.


<a name="text-value"/>

## 3.4 The "TextValue" Data Type

The `TextValue` data type defines a literal text value.

The `TextValue` data type does NOT support extension properties (see [Extension Properties](#extension-properties)).

### identifier

The identifier for the "TextValue" data type is:

`http://gedcomx.org/v1/TextValue`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
lang | The locale identifier for the value of the text. | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag | OPTIONAL. If not provided, the locale is determined per [Internationalization Considerations](#i18n).
value | The text value. | string | REQUIRED.


<a name="source-citation"/>

## 3.5 The "SourceCitation" Data Type

The `SourceCitation` data type defines a container for the metadata necessary for an agent to identify a source(s).

### identifier

The identifier for the "SourceCitation" data type is:

`http://gedcomx.org/v1/SourceCitation`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
lang | The locale identifier for the bibliographic metadata. | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag | OPTIONAL. If not provided, the locale is determined per [Internationalization Considerations](#i18n).
value | The bibliographic metadata rendered as a full citation. | string | REQUIRED.  This string is plain text, but MAY include an xhtml [`cite`](http://www.w3.org/TR/html5/text-level-semantics.html#the-cite-element) element.  If the `value` includes a [`cite`](http://www.w3.org/TR/html5/text-level-semantics.html#the-cite-element) element, the text-level semantics defined for [`cite`](http://www.w3.org/TR/html5/text-level-semantics.html#the-cite-element) MUST apply&mdash;i.e., the element MUST represent the title of a work.


<a name="source-reference"/>

## 3.6 The "SourceReference" Data Type

The `SourceReference` data type defines a reference to a source description.

### identifier

The identifier for the "SourceReference" data type is:

`http://gedcomx.org/v1/SourceReference`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
description  | Reference to a _description_ of the target source. | [URI](#uri) | REQUIRED. MUST resolve to an instance of [`http://gedcomx.org/v1/SourceDescription`](#source-description).
attribution | The attribution of this source reference. | [`http://gedcomx.org/Attribution`](#attribution) | OPTIONAL. If not provided, the attribution of the containing resource of the source reference is assumed.


<a name="evidence-reference"/>

## 3.7 The "EvidenceReference" Data Type

The `EvidenceReference` data type defines a reference to data being used to derive the given instance of `Subject`.
For example, an "evidence" `Subject` (i.e., the object holding the `EvidenceReference` instance) can refer to content
extracted from a source (i.e., an ["extracted"](#extracted-conclusion-constraints) `Subject`) as *information* being
used to derive the *evidence* expressed in this `Subject`.

### identifier

The identifier for the "EvidenceReference" data type is:

`http://gedcomx.org/v1/EvidenceReference`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
resource  | Reference to the supporting data. | [URI](#uri) | REQUIRED. MUST resolve to an instance of [`http://gedcomx.org/v1/Subject`](#subject).
attribution | The attribution of this evidence reference. | [`http://gedcomx.org/Attribution`](#attribution) | OPTIONAL. If not provided, the attribution of the containing resource of the source reference is assumed.

### examples

* An application allows a researcher to extract information from a single census record about a person, representing the
  information as a [persona](#persona) with an identifier "abcde". The researcher extracts additional information about the
  person from a birth certificate and the application assigns the resulting [persona](#persona) an identifier "fghij". As the
  researcher gathers and analyzes the information, he will create a (working) `Person` conclusion. When the researcher concludes
  that the person represented in "abcde" and in "fghij" are the same person, he will add two `EvidenceReference` instances to the
  working `Person`: one for "abcde" and one for "fghij".


<a name="online-account"/>

## 3.8 The "OnlineAccount" Data Type

The `OnlineAccount` data type defines a description of an account for an online service provider.

### identifier

The identifier for the `OnlineAccount` data type is:

`http://gedcomx.org/v1/OnlineAccount`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
serviceHomepage  | The URI identifying the online service provider that holds the account being described. | [URI](#uri) | REQUIRED.
accountName | The name, label, or id that uniquely identifies the account maintained by the online service provider. | string | REQUIRED.


<a name="address"/>

## 3.9 The "Address" Data Type

The `Address` data type defines a street or postal address of a person or organization.

### identifier

The identifier for the `Address` data type is:

`http://gedcomx.org/v1/Address`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
value | A full representation of the complete address. | string | OPTIONAL.
city | The city. | string | OPTIONAL.
country | The country. | string | OPTIONAL.
postalCode | The postal code. | string | OPTIONAL.
stateOrProvince | The state or province. | string | OPTIONAL.
street | The street. | string | OPTIONAL.
street2 | The street (second line). | string | OPTIONAL.
street3 | The street (third line). | string | OPTIONAL.
street4 | The street (fourth line). | string | OPTIONAL.
street5 | The street (fifth line). | string | OPTIONAL.
street6 | The street (sixth line). | string | OPTIONAL.


<a name="conclusion"/>

## 3.10 The "Conclusion" Data Type

The `Conclusion` data type defines the abstract concept for a basic genealogical data item.

In formal discussions of the genealogical research process, the term "conclusion" usually has a more specific meaning and is used to refer
to an "accepted" hypothesis in accordance with the [Genealogical Proof Standard](http://www.bcgcertification.org/resources/standard.html).
The name of the `Conclusion` data type is not meant to be associated with the definition of the term "conclusion" as it is described in the
genealogical research process. Rather, the name refers to the notion that any information that is interpreted from an "original" is in some way
a "conclusion"&mdash;even if the interpreter was diligent in representing the information verbatim as it was found in the original.

### identifier

The identifier for the `Conclusion` data type is:

`http://gedcomx.org/v1/Conclusion`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
id | An identifier for the conclusion data. | string | OPTIONAL.  The id is to be used as a "fragment identifier" as defined by [RFC 3986, Section 3.5](http://tools.ietf.org/html/rfc3986#section-3.5). As such, the constraints of the id are provided in the definition of the media type (e.g. XML, JSON) of the data structure.
lang | The locale identifier for the conclusion. | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag | OPTIONAL. If not provided, the locale is determined per [Internationalization Considerations](#i18n).
sources | The list of references to the sources of related to this conclusion. | List of [`http://gedcomx.org/v1/SourceReference`](#source-reference). Order is preserved. | OPTIONAL. Note that the sources referenced from conclusions are also considered to be sources of the entities that contain them. For example, a source associated with the [`Name`](#name-conclusion) of a [`Person`](#person) is also source for the [`Person`](#person).
analysis  | Reference to a document containing analysis supporting this conclusion. | [URI](#uri) | OPTIONAL. If provided, MUST resolve to an instance of [`http://gedcomx.org/v1/Document`](#document) of type `http://gedcomx.org/Analysis`.
notes  | A list of notes about this conclusion. | List of [`http://gedcomx.org/Note`](#note) | OPTIONAL.
confidence  | Reference to a confidence level for this conclusion. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify a confidence level, and use of a [known confidence level](#known-confidence-levels) is RECOMMENDED.

<a name="known-confidence-levels"/>

### 3.10.1 Known Confidence Levels

The following confidence levels are defined by GEDCOM X.

URI | description
----|------------
`http://gedcomx.org/High`|The contributor has a high degree of confidence that the assertion is true.
`http://gedcomx.org/Medium`|The contributor has a medium degree of confidence that the assertion is true.
`http://gedcomx.org/Low`|The contributor has a low degree of confidence that the assertion is true.


<a name="subject"/>

## 3.11 The "Subject" Data Type

The `Subject` data type defines the abstract concept of a genealogical _subject_.

A "subject" is something with a unique and intrinsic identity, such as a person or a location on the surface of the earth. We
identify that subject in time and space using various supporting conclusions. For example, a person is a subject with supporting
conclusions such as name, birth, gender, etc. We aggregate these supporting conclusions to form an apparently-unique identity by
which we can distinguish our subject from all other possible subjects.

Note that a subject is itself a conclusion and can be used as a supporting conclusion for other subjects (via the `evidence` property).
However, not all supporting conclusions are subjects. Researchers may research and debate a fact (e.g. where it took place, when it took
place, the spelling of the name, etc.), but it is always within the context of a subject (e.g. where was _the person_ born, when was _the person_
born, how should _the person's_ name be spelled).

### identifier

The identifier for the `Subject` data type is:

`http://gedcomx.org/v1/Subject`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Conclusion`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
extracted | Whether this subject is to be constrained as an _extracted conclusion_. | boolean | OPTIONAL. Default: `false`. Refer to [Extracted Conclusion Constraints](#extracted-conclusion-constraints).
evidence | References to other subjects that support this subject. | List of [`http://gedcomx.org/v1/EvidenceReference`](#evidence-reference). Order is preserved. | OPTIONAL.  If provided, each reference MUST resolve to an instance of subject of the same type as this instance (e.g., if the subject is an instance of `Person`, all of its `evidence` references must resolve to instances of `Person`).
media | References to multimedia resources for this subject, such as photos or videos, intended to provide additional context or illustration for the subject and _not_ considered evidence supporting the identity of the subject or its supporting conclusions. | List of [`http://gedcomx.org/v1/SourceReference`](#source-reference) | OPTIONAL. Media references SHOULD be ordered by priority such that applications that wish to display a single media item (such as an image) MAY choose the first applicable media reference. Note that the `SourceReference` is used for multimedia references and therefore MUST resolve to a `SourceDescription` of the resource, which in turn provides a reference to the resource itself.
identifiers | A list of identifiers for the subject. | List of [`http://gedcomx.org/v1/Identifier`](#identifier-type). Order is preserved. | OPTIONAL.
attribution | The attribution of this subject. | [`http://gedcomx.org/Attribution`](#attribution) | OPTIONAL. If not provided, the attribution of the containing data set (e.g. file) of the _subject_ is assumed.


<a name="gender"/>

## 3.12 The "Gender" Data Type

The `Gender` data type defines a gender of a person.

### identifier

The identifier for the `Gender` data type is:

`http://gedcomx.org/v1/Gender`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Conclusion`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
type  | Enumerated value identifying the gender. | [Enumerated Value](#enumerated-value) | REQUIRED. MUST identify a gender type, and use of a [known gender type](#known-gender-types) is RECOMMENDED.


<a name="known-gender-types"/>

### 3.12.1 Known Gender Types

The following gender types are defined by GEDCOM X:

URI | description
----|-------------
`http://gedcomx.org/Male`| Male gender.
`http://gedcomx.org/Female`| Female gender.
`http://gedcomx.org/Unknown`| Unknown gender.


<a name="name-conclusion"/>

## 3.13 The "Name" Data Type

The `Name` data type defines a name of a person.

A `Name` is intended to represent a single variant of a person's name.  This means that nicknames, spelling variations,
or other names (often distinguishable by a name `type`) should be modeled with separate instances of `Name`.

The name forms of a name contain alternate representations of the name.  A `Name` MUST contain at least one name form, presumably
a representation of the name that is considered proper and well formed in the person's native, historical cultural context.
Other name forms MAY be included, which can be used to represent this name in contexts where the native name form is not
easily recognized and interpreted.  Alternate forms are more likely in situations where conclusions are being analyzed
across cultural context boundaries that have both language and writing script differences.

For example, a Korean name has a native Korean form, but can also have a Chinese form and a Roman/Latin form&mdash;three
different name forms, but each representing the same name.

If more than one name form is provided, included name forms are presumed to be given in order of preference, with the
most preferred name form in the first position in the list.

### identifier

The identifier for the `Name` data type is:

`http://gedcomx.org/v1/Name`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Conclusion`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
type | Enumerated value identifying the name type. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify a name type, and use of a [known name type](#known-name-types) is RECOMMENDED.
nameForms | The name form(s) that best express this name, usually representations considered proper and well formed in the person's native, historical cultural context. | List of [`http://gedcomx.org/v1/NameForm`](#name-form). Order is preserved. | REQUIRED. At least one name form MUST be provided. All included name forms SHOULD be representations of the same name, and NOT variants of the name (i.e., not nicknames or spelling variations).
date | The date of applicability of the name. | [`http://gedcomx.org/v1/Date`](#conclusion-date) | OPTIONAL.

### examples

Consider the following: a Russian person with the birth name "Александр" (rendered as "Alexander" in English and in a Latin script) that
also went by this name's common nickname, "Саша" (rendered as "Sasha" in English).

It is tempting to think that this situation should be modeled with one `Name` instance that has several alternate `NameForm`s.  The model is
_not_ designed to be used in this way. Instead, this person's names ought to be modeled such that the birth name and the nickname are modeled
as two separate `Name` instances: one instance for the birth name, and one for the nickname.  The `type` property MAY be provided to distinguish
the birth name from the nickname. Each `Name` instance MAY have two `NameForm` instances: one with the native form of the name and another with
the alternate form.  Using an informal pseudo code, it might look something like the following:

```
Name1.type=http://gedcomx.org/BirthName
Name1.nameForms[0].fullText=Александр
Name1.nameForms[1].fullText=Alexander

Name2.type=http://gedcomx.org/Nickname
Name2.nameForms[0].fullText=Саша
Name2.nameForms[1].fullText=Sasha
```

<a name="known-name-types"/>

### 3.13.1 Known Name Types

The following name types are defined by GEDCOM X:

URI | description
----|-------------
`http://gedcomx.org/BirthName` | Name given at birth.
`http://gedcomx.org/MarriedName` | Name accepted at marriage.
`http://gedcomx.org/AlsoKnownAs` | "Also known as" name.
`http://gedcomx.org/Nickname`| Nickname.
`http://gedcomx.org/AdoptiveName` | Name given at adoption.
`http://gedcomx.org/FormalName` | A formal name, usually given to distinguish it from a name more commonly used.
`http://gedcomx.org/ReligiousName` | A name given at a religious rite or ceremony.


<a name="3-fact-conclusion"/>

## 3.14 The "Fact" Data Type

The `Fact` data type defines a data item that is presumed to be true about a specific subject, such as a person or
relationship. To distinguish the concept of "fact" from "event", refer to [Events Versus Facts](#events-vs-facts).

### identifier

The identifier for the `Fact` data type is:

`http://gedcomx.org/v1/Fact`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Conclusion`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
type | Enumerated value identifying the type of the fact. | [Enumerated Value](#enumerated-value) | REQUIRED. MUST identify a fact type, and use of a [known fact type](#known-fact-types) is RECOMMENDED.
date | The date of applicability of the fact. | [`http://gedcomx.org/v1/Date`](#conclusion-date) | OPTIONAL.
place | A reference to the place applicable to this fact. | [`http://gedcomx.org/v1/PlaceReference`](#conclusion-place-reference) | OPTIONAL.
value | The value of the fact. | string | OPTIONAL.
qualifiers | Qualifiers to add additional details about the fact. | List of [http://gedcomx.org/v1/Qualifier](#qualifier) | OPTIONAL. If present, use of a [known fact qualifier](#known-fact-qualifier) is RECOMMENDED.

<a name="known-fact-types"/>

### 3.14.1 Known Fact Types

The following fact types are defined by GEDCOM X:

URI | description | scope
----|-------------|------
`http://gedcomx.org/Adoption`| A fact of a person's adoption. | person
`http://gedcomx.org/Birth`| A fact of a person's birth. | person
`http://gedcomx.org/Burial`| A fact of the burial of person's body after death. | person
`http://gedcomx.org/Christening`| A fact of a person's christening *at birth*. Note that this does not identify an adult christening. | person
`http://gedcomx.org/Death`| A fact of the death of a person. | person
`http://gedcomx.org/Residence`| A fact of a person's residence. | person
`http://gedcomx.org/Divorce`| The fact of a divorce of a couple. | couple relationship
`http://gedcomx.org/Marriage`| The fact of a marriage. | couple relationship

In addition to these elements, processors SHOULD support any other elements defined by the
[GEDCOM X Fact Types](https://github.com/FamilySearch/gedcomx/blob/master/specifications/fact-types-specification.md) specification.

<a name="known-fact-qualifier"/>

### 3.14.2 Known Fact Qualifiers

The following fact qualifiers are defined by GEDCOM X:

name | value
-----|-------
`http://gedcomx.org/Age`| The age of a person at the event described by the fact.
`http://gedcomx.org/Cause`| The cause of the fact, such as the cause of death.
`http://gedcomx.org/Religion`| The religion associated with a religious event such as a baptism or excommunication.


<a name="conclusion-event-role"/>

## 3.15 The "EventRole" Data Type

The `EventRole` data type defines a role played in an event by a person.

### identifier

The identifier for the `EventRole` data type is:

`http://gedcomx.org/v1/EventRole`

### extension

This data type extends the following data type:

`http://gedcomx.org/v1/Conclusion`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
person | Reference to the event participant. | [`URI`](#uri) | REQUIRED. MUST resolve to an instance of [`http://gedcomx.org/v1/Person`](#person).
type | Enumerated value identifying the participant's role. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify a role type, and use of a [known role type](#known-roles) is RECOMMENDED.
details | Details about the role of participant in the event. | string | OPTIONAL.

<a name="known-roles"/>

### 3.15.1 Known Role Types

The following role types are defined by GEDCOM X:

URI | description
----|------------
`http://gedcomx.org/Principal`| The person is the principal person of the event. For example, the principal of a birth event is the person that was born.
`http://gedcomx.org/Participant`| A participant in the event.
`http://gedcomx.org/Official`| A person officiating the event.
`http://gedcomx.org/Witness`| A witness of the event.


<a name="conclusion-date"/>

## 3.16 The "Date" Data Type

The `Date` data type defines a genealogical date.

### identifier

The identifier for the `Date` data type is:

`http://gedcomx.org/v1/Date`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
original | The original value of the date as supplied by the contributor. | string | OPTIONAL.
formal | The standardized [formal value](#formal-values) of the date, formatted according to the GEDCOM X Date Format specification. | [GEDCOM X Date](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md) | OPTIONAL.


<a name="conclusion-place-reference"/>

## 3.17 The "PlaceReference" Data Type

The `PlaceReference` data type defines a reference to a description of a place.

### identifier

The identifier for the `PlaceReference` data type is:

`http://gedcomx.org/v1/PlaceReference`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
original | The original place name text as supplied by the contributor. | string | OPTIONAL.
descriptionRef | A reference to a _description_ of this place. | [URI](#uri) | OPTIONAL. If provided, MUST resolve to a [PlaceDescription](#place-description).


<a name="name-part"/>

## 3.18 The "NamePart" Data Type

The `NamePart` data type is used to model a portion of a full name, including the terms that make up that portion. Some name parts may have qualifiers
to provide additional semantic meaning to the name part (e.g., "given name" or "surname").

### identifier

The identifier for the `NamePart` data type is:

`http://gedcomx.org/v1/NamePart`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
type | Enumerated value identifying the type of the name part. | [Enumerated Value](#enumerated-value) | OPTIONAL. If provided, MUST identify a name part type, and use of a [known name part type](#known-name-part-types) is RECOMMENDED.
value | The term(s) from the name that make up this name part. | string | REQUIRED.  A name part value MAY contain more than one term from the full name, such as in the name part "John Fitzgerald" from the full name "John Fitzgerald Kennedy". If multiple terms are detailed in a single `NamePart`, these terms SHOULD be separated using the name separator appropriate to the locale applicable to the containing name form.
qualifiers | Qualifiers to add additional semantic meaning to the name part. | List of [http://gedcomx.org/v1/Qualifier](#qualifier) | OPTIONAL. If present, use of a name part qualifier defined by the [GEDCOM X Name Part Qualifiers](https://github.com/FamilySearch/gedcomx/blob/master/specifications/name-part-qualifiers-specification.md) specification is RECOMMENDED.

<a name="known-name-part-types"/>

### 3.18.1 Known Name Part Types

The following name part types are defined by GEDCOM X:

URI | description
----|-------------
`http://gedcomx.org/Prefix`| A name prefix.
`http://gedcomx.org/Suffix`| A name suffix.
`http://gedcomx.org/Given`| A given name.
`http://gedcomx.org/Surname`| A surname.


<a name="name-form"/>

## 3.19 The "NameForm" Data Type

The `NameForm` data type defines a representation of a name (a "name form") within a given cultural context,
such as a given language and script.

As names are captured (both in records or in applications), the terms in the name are sometimes classified by type.
For example, a certificate of death might prompt for "given name(s)" and "surname". The `parts` list can be used to
represent the terms in the name that have been classified.

If both a full rendering of the name and a list of parts are provided, it NOT REQUIRED that every term in the fully
rendered name appear in the list of parts.

Name parts in the `parts` list SHOULD be ordered in the natural order they would be used in the applicable
cultural context.

If a full rendering of the name is not provided (i.e., the name has only been expressed in parts), a full
rendering of the name MAY be derived (sans punctuation) by concatenating, in order, each name part value in the
list of parts, separating each part with the name part separator appropriate for the applicable cultural context.

### identifier

The identifier for the `NameForm` data type is:

`http://gedcomx.org/v1/NameForm`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
lang | The locale identifier for the name form. | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag | OPTIONAL. If not provided, the locale is determined per [Internationalization Considerations](#i18n).
fullText | A full rendering of the name (or as much of the name as is known). | string | OPTIONAL. If provided, the name SHOULD be rendered as it would normally be spoken in the applicable cultural context.
parts | Any identified name parts from the name. | List of [`http://gedcomx.org/v1/NamePart`](#name-part). Order is preserved. | OPTIONAL. If provided, the list SHOULD be ordered such that the parts are in the order they would normally be spoken in the applicable cultural context.

### examples

Consider the following: the Russian name "Пётр Ильи́ч Чайко́вский" in the Cyrillic script, its Latin-script
equivalent "Pyotr Ilyich Tchaikovsky", and its anglicised equivalent "Peter Ilyich Tchaikovsky". Using an
informal pseudo code, these name forms might be modeled as follows:

```
NameForm1.locale=ru-Cyrl
NameForm1.fullText=Пётр Ильи́ч Чайко́вский
NameForm1.parts[0].type=http://gedcomx.org/Given
NameForm1.parts[0].value=Пётр
NameForm1.parts[0].qualifiers[0]=http://gedcomx.org/First
NameForm1.parts[1].type=http://gedcomx.org/Middle
NameForm1.parts[1].value=Ильи́ч
NameForm1.parts[1].qualifiers[0]=http://gedcomx.org/Middle
NameForm1.parts[2].type=http://gedcomx.org/Surname
NameForm1.parts[2].value=Чайко́вский

NameForm2.locale=ru-Latn
NameForm2.fullText=Pyotr Ilyich Tchaikovsky
NameForm2.parts[0].type=http://gedcomx.org/Given
NameForm2.parts[0].value=Pyotr
NameForm2.parts[0].qualifiers[0]=http://gedcomx.org/First
NameForm2.parts[1].type=http://gedcomx.org/Given
NameForm2.parts[1].value=Ilyich
NameForm2.parts[1].qualifiers[0]=http://gedcomx.org/Middle
NameForm2.parts[2].type=http://gedcomx.org/Surname
NameForm2.parts[2].value=Tchaikovsky

NameForm3.locale=en-Latn
NameForm3.fullText=Peter Ilyich Tchaikovsky
NameForm3.parts[0].type=http://gedcomx.org/Given
NameForm3.parts[0].value=Peter
NameForm3.parts[0].qualifiers[0]=http://gedcomx.org/First
NameForm3.parts[1].type=http://gedcomx.org/Given
NameForm3.parts[1].value=Ilyich
NameForm3.parts[1].qualifiers[0]=http://gedcomx.org/Middle
NameForm3.parts[2].type=http://gedcomx.org/Surname
NameForm3.parts[2].value=Tchaikovsky
```

<a name="qualifier"/>

## 3.20 The "Qualifier" Data Type

The `Qualifier` data type defines the data structure used to supply additional details, annotations, tags, or other qualifying data
to a specific data element.

The `Qualifier` data type does NOT support extension properties (see [Extension Properties](#extension-properties)).

### identifier

The identifier for the "Qualifier" data type is:

`http://gedcomx.org/v1/Qualifier`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
name | The name of the qualifier. | [Enumerated Value](#enumerated-value) | REQUIRED. It is RECOMMENDED that the qualifier name resolve to an element of a constrained vocabulary.
value | The value of the qualifier. | string | OPTIONAL. If provided, the name MAY give the semantic meaning of the value.

<a name="coverage"/>

## 3.21 The "Coverage" Data Type

The `Coverage` data type defines the data structure used to supply information about the coverage of a resource.

### identifier

The identifier for the "Coverage" data type is:

`http://gedcomx.org/v1/Coverage`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
spatial | The spatial (i.e., geographic) coverage. | [`http://gedcomx.org/v1/PlaceReference`](#conclusion-place-reference) | OPTIONAL.
temporal | The temporal coverage. | [`http://gedcomx.org/v1/Date`](#conclusion-date) | OPTIONAL.

</div>