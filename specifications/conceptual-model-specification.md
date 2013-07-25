# The GEDCOM X Conceptual Model

## Status

This document specifies a conceptual model for exchanging genealogical data,
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

The GEDCOM X Conceptual Model is a specification of formal concepts and types
that are used to provide a standard model and vocabulary for describing genealogical
data. Genealogical data is structured by data types such as persons, 
relationships, and sources.

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/conceptual-model/v1`

For convenience, the GEDCOM X conceptual model may be referred to as "GEDCOM X Conceptual Model 1.0".
This specification uses "GEDCOM X" or "GEDCOM X Conceptual Model" internally.

This specification is depends on the GEDCOM X Date Format specification identified
by [`http://gedcomx.org/date/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md).

This specification refers to the GEDCOM X Event Types specification identified
by [`http://gedcomx.org/event-types/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/event-types-specification.md)
to recommend event types to be used.

This specification refers to the GEDCOM X Fact Types specification identified
by [`http://gedcomx.org/fact-types/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/fact-types-specification.md)
to recommend fact types to be used.

This specification refers to the GEDCOM X Name Part Qualifiers specification identified
by [`http://gedcomx.org/name-part-qualifiers/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/name-part-qualifiers-specification.md)
to recommend name part qualifiers to be used.

## 1.2 Notational Conventions

### 1.2.1 Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

## 1.3 Definitions

### 1.3.1 Data Types and Properties

The term "data type" is used to refer to a formal description of a data structure. The term "property" is used to refer to a
distinct component or element of a data type. For example, information about a person might be contained within a
data structure that supplies the person's name, birth date, gender, etc. A "data type" defines the formal "properties" of
a data structure.

When a property of a data type is specified as being of a particular data type, the value of the property inherits the
corresponding requirements from that data type's definition. When a data type is specified as an "extension" of another data type,
the extending data type inherits the corresponding requirements and properties from the extended data type's definition.

Data type definitions provided by this specification use the following elements:

1. The *identifier* for the data type, which takes the form of a URI.
2. The *extension* of the data type (if any) which specifies which data type is extended by the data type.
3. The *properties* of the data type, which define the information the data type encapsulates.

### 1.3.2 Data Instances

The term "data instance" to refer to a particular instance, or instantiation, of a data type.

<a name="char-string-list"/>

### 1.3.3 Basic Data Types

This section defines a set of basic data types that are used by GEDCOM X.

A "boolean" refers to the mathematical concept of binary-valued logic: `true` or `false`.

A "timestamp" refers to an instance of time, including values for year, month, date, hour, minute, second and timezone.

A "double" refers to an `IEEE 754 binary64` value.

A "character" is an atomic unit of text as specified by `ISO/IEC 10646`.

A "string" is defined as a finite-length sequence of characters.

A "list" is defined as a sequence of data instances. When a property is defined in terms of a "list",
the data type of the data instances in the list is also provided.

<a name="uri"/>

### 1.3.4 The URI Reference

The Uniform Resource Identifier ("URI") is fundamental to the GEDCOM X conceptual model.
The URI is used to identify both the data types and data instances. The
URI is also used to identify elements of the controlled vocabularies defined by GEDCOM X.
The URI is specified by [RFC 3986](http://tools.ietf.org/html/rfc3986).

GEDCOM X resources use the URI to reference other entities. For example, a GEDCOM X `Relationship`
identifies a person in the relationship by referencing a URI that identifies the person. When a property
(such as the `person1` property of `Relationship`) is of data type `URI`, the value of the property
is interpreted as a "URI Reference" as defined by [RFC 3986, section 4](http://tools.ietf.org/html/rfc3986#section-4).
This specification uses the term "URI" to refer to both a "URI" and a "URI Reference" as
defined by [RFC 3986](http://tools.ietf.org/html/rfc3986).

<a name="formal-values" />

### 1.3.5 Original and Normalized Values

When a property is identified as an "original value", the value of the property
is interpreted as the literal value supplied by a user. If a property is identified as a
"normalized value", the value of the property is assumed to be formally formatted (either by
a user or by the application) for the purpose of easier processing, such as for display
purposes.

<a name="enumerated-value"/>

### 1.3.6 Enumerated Values

Enumerated values are used throughout GEDCOM X to constrain values of properties to a limited (though
not necessarily small) number of possibilities. Enumerated values are used to ensure portability and must
be a discrete, machine-identifiable value based on a specific specification.  Members of controlled
vocabularies are enumerated values.

Enumerated values take the form of a URI. The base URI for enumerated values defined by GEDCOM X is
`http://gedcomx.org/`. As such, if an enumerated value is provided as a relative URI reference as defined
by [RFC 3986 Section 4.2](http://tools.ietf.org/html/rfc3986#section-4.2), the base URI to be used for
reference resolution as defined by [RFC 3986 Section 5](http://tools.ietf.org/html/rfc3986#section-5) is
is `http://gedcomx.org/`.

Enumerated values which are neither defined directly from this specification nor indirectly referenced by
this specification SHOULD be declared in a freely-distributable specification and MUST NOT use the value
`http://gedcomx.org/` as a base URI.

### 1.3.7 Controlled Vocabularies

GEDCOM X defines a set of controlled vocabularies for the purposes of identifying the semantic
context of data instances. A controlled vocabulary is often defined to create a set
of "known types" of data instances such as facts, names, genders, etc. For example, a controlled
vocabulary is specified to identify the set of known types of events so applications
can share semantic context of the event.

Elements of a controlled vocabulary are identified by an enumerated value.

<a name="text-types"/>

### 1.3.8 Text Types

In some cases, a text value must include styling or layout to fully convey its intended meaning.  Where such
a requirement has been identified, implementers can designate that a text value may include such styling or
layout by specifying an alternate text type. The following text types are supported:

#### plain

The "plain" text type identifies plain text. "plain" is the default text type for text without an explicitly specified type.

#### xhtml

The "xhtml" text type identifies XHTML text complying with the
[XHTML 1.0 W3C Recommendation](http://www.w3.org/TR/xhtml1/). In order to maximize compatibility and
minimize security risks, support for the following subset of modules (defined by XHTML Modularization
1.1 W3C Recommendation](http://www.w3.org/TR/xhtml-modularization/)) is REQUIRED:

* [Core Modules](http://www.w3.org/TR/xhtml-modularization/abstract_modules.html#sec_5.2.), including the Structure Module, Text Module, Hypertext Module, and List Module.
* [Text Extension Modules](http://www.w3.org/TR/xhtml-modularization/abstract_modules.html#s_text), including the Presentation Module, Edit Module, and Bi-directional Text Module.
* [Table Modules](http://www.w3.org/TR/xhtml-modularization/abstract_modules.html#sec_5.6.), including the Basic Tables Module, and Tables Module.
* [Base Module](http://www.w3.org/TR/xhtml-modularization/abstract_modules.html#s_basemodule)

Support for other XHTML modules is OPTIONAL. Parsers MAY ignore elements from optional modules.


<a name="i18n"/>

## 1.4 Internationalization Considerations

GEDCOM X is be designed to accommodate users and software of different languages and cultures.
Genealogical data often needs to be interpreted from the perspective of its cultural context.

To this end, a property named `lang` is supported on relevant GEDCOM X data types. The value
of this property is the locale of the data being processed. The locale is used to identify the
cultural context of the data. The values of the `lang` property are language identifiers as
defined by [IETF BCP 47](http://tools.ietf.org/html/bcp47), _Tags for the Identification of Languages_;
in addition, the empty string may be specified to explicitly state a processor may process the data
as if it were provided in the default locale of the processor.

The `lang` property is optional. When a value for the `lang` property is provided, it is presumed to
apply to the data instance and to any data it contains. The value of the `lang` property overrides the
value of the `lang` property on any containing data. When a value for the `lang` property is neither
provided on a data instance nor on any containing data instances, a processor MAY process the
data as if it were provided in the default locale of the processor.

For example, to determine the cultural context of a given name form, the value of the `lang` property
on the name form is used. If the `lang` property is not provided on the name form, the value of the
`lang` property on the name is used. If the `lang` property is not provided on the name, the value of
the `lang` property on the person is used. If the `lang` property is not provided on the person, the
value of the `lang` property on the containing dataset is used. If the `lang` property on the containing
dataset is not provided, the default locale of the processor is used.

In order to prevent undue burden on producers and consumers of GEDCOM X data, not all data types
provide multiple values for properties that are used for user input. For example, the text of
a note is _not_ defined as a list of language-identified strings. However, some cases have been
identified where multi-valued input is needed for the benefit of exchanging genealogical data
across cultural boundaries. Such cases include the need to input multiple name forms and the need
to identify multiple titles for a source.

# 2. Top-Level Data Types

The data types in this section are designated as "top-level" data types because they define the
top-level units of genealogical data. A GEDCOM X data set is defined as a collection of instances
of top-level data types. The definitions of top-level data types stand separately
from the definitions of other top-level data types and the lifecycle of instances of these data
types is distinct from the lifecycle of instances of the other top-level data types.


<a name="person"/>

## 2.1 The "Person" Data Type

The `Person` data type defines a description of a person.

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
names | The names of the person. | List of [`http://gedcomx.org/v1/Name`](#name-conclusion). Order is preserved. | OPTIONAL.
facts | The facts of the person. | List of [`http://gedcomx.org/v1/Fact`](#fact-conclusion). Order is preserved. | OPTIONAL.


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
latitude | Angular distance, in degrees, north or south of the Equator (0.0 degrees). | double | OPTIONAL.  If provided, MUST provide `longitude` also.  Values range from −90.0 degrees (south of the equator) to 90.0 degrees (north of the equator). It is assumed that descriptions that provide the same value for the `place` property share identical `longitude` values.
longitude | Angular distance, in degrees, east or west of the Prime Meridian (0.0 degrees). | double | OPTIONAL.  If provided, MUST provide `latitude` also.  Values range from −180.0 degrees (west of the Meridian) to 180.0 degrees (east of the Meridian). It is assumed that descriptions that provide the same value for the `place` property share identical `latitude` values.
temporalDescription | A description of the time period to which this place description is relevant. | [`http://gedcomx.org/v1/Date`](#conclusion-date) | OPTIONAL.
spatialDescription | A reference to a geospatial description of this place. | [`URI`](#uri) | OPTIONAL. It is RECOMMENDED that this geospatial description resolve to a [KML](http://en.wikipedia.org/wiki/Keyhole_Markup_Language) document.


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


<a name="fact-conclusion"/>

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


<a name="extracted-conclusion-constraints"/>

# 4. Extracted Conclusion Constraints

GEDCOM X provides a specific definition for the term "extracted conclusion" that is used to refer to a set of constraints
that MUST be applied to conclusion data that is identified as "extracted" using the `extracted` property (see `Subject` and `Document`).

When data is identified as "extracted", it means that the data is to be treated as having been extracted from a single
source or record.  Extracted data is distinguished from other data by the notion that it is intended to describe information
about a subject found in a single source, as opposed to what a researcher or system believes to be true about the subject.

Applications MUST recognize the `extracted` property and SHOULD ensure that any modifications to the extracted data are
aligned with the information that is provided by the specific (single) source, even if the source provides information that
may conflict with information in other sources.

Data that is identified as "extracted" MUST conform to the following constraints:

* The `Subject` or `Document` MUST NOT refer to more than one source description, including any supporting conclusions on the `Subject`.
* All source references, including those on supporting conclusions, MUST resolve to the same source description, although each reference
MAY contain distinct qualifying information such as attribution.


<a name="persona"/>

## 4.1 Persona

GEDCOM X provides a specific definition for the term "persona" that is used to refer to an instance of
`http://gedcomx.org/v1/Person` that has been identified as an extracted conclusion.


<a name="extensibility"/>

# 5. Extensibility

Data types, properties, and enumerated values MAY be defined as extensions to the GEDCOM X Conceptual Model by external
specifications. New data types, properties, and enumerated values MAY also be added by future versions of the
GEDCOM X Conceptual Model or by other GEDCOM X specifications. Implementations of this version of the specification
will not be able to process such extensions correctly and, in fact, will not be able to distinguish such extensions
from error.

This section defines the constraints by which implementations of the GEDCOM X Conceptual Model SHOULD identify
and process data types, properties, and enumerated values not defined by this version of GEDCOM X.

## 5.1 Data Type Extensions

New data types MAY be defined as extensions to GEDCOM X by providing the following:

* A description of the data type.
* An identifier for the data type.
* The data type being extended by the data type, if any.
* The properties of the data type.
* Examples needed to clarify the usage of the data type, if any.

The base URI `http://gedcomx.org/` is reserved for identifiers of data types defined by the GEDCOM X specification
set. Data types defined outside the scope of the GEDCOM X specification set MUST NOT use the value `http://gedcomx.org/`
as a base URI for the data type identifier.

Specifications that define new data types as GEDCOM X extensions MUST be published and made freely available and
compatible with the terms and constraints that govern the GEDCOM X Conceptual Model.

## 5.2 Enumerated Value Extensions

New enumerated values MAY be defined as extensions to GEDCOM X by providing the following:

* An identifier for each enumerated value.
* A description for each enumerated value.
* An identification of which properties of which data types to which each enumerated value applies.

The base URI for enumerated values defined by the GEDCOM X specification set is `http://gedcomx.org/`.
Enumerated values defined outside the scope of the GEDCOM X specification set MUST NOT use the value `http://gedcomx.org/`
as a base URI for the enumerated value identifier.

Specifications that define new enumerated values as GEDCOM X extensions MUST be published and made freely available and
compatible with the terms and constraints that govern the GEDCOM X Conceptual Model.

### 5.2.1 User-Defined Enumerated Values

Some applications MAY allow enumerated values to be provided by a user. For example, a genealogy
application may provide a feature that allows a user to describe a "custom" fact about a person
when there doesn't exist a formally specified enumerated value.

In the case where a user has supplied a title or description instead of selecting
a known enumerated value, GEDCOM X recognizes the data URI scheme as defined by
[RFC 2397](http://tools.ietf.org/html/rfc2397).


<a name="extension-properties"/>

## 5.3 Extension Properties

New properties MAY be defined as extensions to existing GEDCOM X data types by providing the following:

* The data type to which the property applies.
* A name of the property.
* A description of the property.
* The data type of the value of the property.
* Any constraints that are applicable to the property.

Extension properties MUST NOT be defined on data types that explicitly restrict extension properties.

Extension properties MUST NOT be defined as "REQUIRED".

Specifications that define new properties as GEDCOM X extensions MUST be published and made freely available and
compatible with the terms and constraints that govern the GEDCOM X Conceptual Model.

## 5.4 Processing Extensions

If extensions are used, extensions MUST be provided such that GEDCOM X implementations can bypass the extension and continue processing.
GEDCOM X implementations that encounter extensions in a location that is legal according to this specification SHOULD NOT stop processing or
signal an error, although implementations MAY signal nonfatal warnings. A GEDCOM X implementation MAY be able to process the extension
correctly and choose to do so.  Otherwise, GEDCOM X implementations MAY bypass the extensions and MUST NOT change their behavior as a result
of the presence of the extension.
