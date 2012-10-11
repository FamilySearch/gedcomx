# The GEDCOM X JSON Serialization Format

## Status

This document specifies a JSON serialization format for the [GEDCOM X standard conceptual
model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md), and requests discussion and suggestions for improvements.

## Copyright Notice

Copyright 2011-2012 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

# 1. Introduction

The GEDCOM X conceptual model is a specification of formal concepts and types
that are used to provide a standard model and vocabulary for describing genealogical
data.

The GEDCOM X JSON Serialization Format is a specification that defines the way that
the GEDCOM X conceptual model is serialized to and deserialized from
[JSON](http://json.org).

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/json/v1`

For convenience, the GEDCOM X JSON Format may be referred to as "GEDCOM X JSON 1.0".

This specification is depends on the conceptual model specification identified
by [`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).

## 1.2 Examples

The following example shows the serialization of a [person data type](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#person)
in JSON according to this specification:

```json
{
  "names" : [ {
    "nameForms" : [ {
      "locale" : "ru-Cyrl",
      "parts" : [ {
        "value" : "Никола́й",
        "type" : "http://gedcomx.org/Given",
        "qualifiers" : [ "http://gedcomx.org/First" ]
      }, {
        "value" : "Андре́евич",
        "type" : "http://gedcomx.org/Given",
        "qualifiers" : [ "http://gedcomx.org/Middle" ]
      }, {
        "value" : "Ри́мский-Ко́рсаков",
        "type" : "http://gedcomx.org/Surname"
      } ],
      "fullText" : "Никола́й Андре́евич Ри́мский-Ко́рсаков",
      "http://familysearch.org/v1/customMarker" : [ {
        "userProvided" : true
      } ]
    }, {
      "locale" : "ru-Latn",
      "parts" : [ {
        "value" : "Nikolai",
        "type" : "http://gedcomx.org/Given",
        "qualifiers" : [ "http://gedcomx.org/First" ]
      }, {
        "value" : "Andreyevich",
        "type" : "http://gedcomx.org/Given",
        "qualifiers" : [ "http://gedcomx.org/Middle" ]
      }, {
        "value" : "Rimsky-Korsakov",
        "type" : "http://gedcomx.org/Surname"
      } ],
      "fullText" : "Nikolai Andreyevich Rimsky-Korsakov"
    } ],
    "preferred" : true,
    "id" : "789"
  } ],
  "facts" : [ {
    "type" : "http://gedcomx.org/Birth",
    "date" : {
      "original" : "March 18, 1844",
      "formal" : "+1844-03-18"
    },
    "place" : {
      "resource" : "https://familysearch.org/platform/places/12345",
      "original" : "Tikhvin, Leningradskaya Oblast', Russia"
    },
    "id" : "123"
  }, {
    "type" : "http://gedcomx.org/Death",
    "date" : {
      "original" : "June 21, 1908",
      "formal" : "+1908-06-21T12:34:56"
    },
    "place" : {
      "resource" : "https://familysearch.org/platform/places/67890",
      "original" : "Luga, Russia",
      "normalized" : "Luga, Novgorodskaya Oblast', Russia"
    },
    "id" : "456"
  } ],
  "gender" : {
    "type" : "http://gedcomx.org/Male"
  },
  "id" : "BBB-BBBB"
}
```

The following example shows the serialization of a relationship between two persons in
JSON according to this specification:

```json
{
  "type" : "http://gedcomx.org/Couple",
  "person1" : "https://familysearch.org/platform/persons/DDD-DDDD",
  "person2" : "https://familysearch.org/platform/persons/FFF-FFFF",
  "facts" : [ {
    "type" : "http://gedcomx.org/Marriage",
    "date" : {
      "original" : "January 6, 1759",
      "formal" : "+1759-01-06"
    },
    "id" : "123",
    "attribution" : {
      "contributor" : "https://familysearch.org/platform/contributors/HHH-HHHH"
    }
  } ],
  "id" : "CCC-CCCC",
  "sources" : [ {
    "sourceDescription" : "urn:srcDescId"
  } ],
  "attribution" : {
    "contributor" : "https://familysearch.org/platform/contributors/BCD-FGHJ",
    "changeMessage" : "(justification here)"
  }
}
```


## 1.3 Notational Conventions

For each data type specified by the GEDCOM X conceptual model, a
JSON data format is supplied which specifies how each of the
properties of the data type are to be serialized in JSON. Each instance
of a data type is serialized as a JSON object. The properties
of each data type are serialized as members of the JSON object.

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14, 
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance 
targets.

# 2. Common Data Types

This section provides JSON object definitions for each data type defined
under the "Common Data Types" section of the conceptual model specification.

<a id="uri"/>

## 2.1 The URI

URIs are supplied as JSON strings and are interpreted according to
[RFC 3986: Uniform Resource Identifier (URI): Generic Syntax](http://www.ietf.org/rfc/rfc3986.txt).

<a id="identifier-type"/>

## 2.2 The "Identifier" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Identifier` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
value | The value of the identifier. | value | string
type  | URI identifying the type of the identifier. | type | [`URI`](#uri)

### examples

```json
{
  "value" : "value_of_identifier",
  "type" : "http://gedcomx.org/IdentifierType"
}
```

<a id="attribution"/>

## 2.3 The "Attribution" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Attribution` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
contributor | Reference to the contributor to whom the attributed data is attributed. | contributor | [`URI`](#uri)
modified | Timestamp of when the attributed data was contributed. | modified | number (milliseconds since epoch)
changeMessage | A statement of why the attributed data is being provided by the contributor. | changeMessage | string

### examples

```json
{
  "contributor" : "http://identifier/for/contributor",
  "modified" : "1338394969",
  "changeMessage" : "...change message here..."

  ...possibility of extension elements...

}
```

<a id="note"/>

## 2.4 The "Note" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Note` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
lang | The locale identifier for the note. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
subject | A subject or title for the note. | subject | string
text | The text of the note. | text | string
attribution | The attribution of this note. | attribution | [`Attribution`](#attribution)

### examples

```json
{
  "lang" : "en",
  "subject" : "...",
  "text" : "...",
  "attribution" : { ... }

  ...possibility of extension elements...

}
```

## 2.5 The "TextValue" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/TextValue` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
lang | The locale identifier for the value of the text. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
value | The string form of the value. | value | string

### examples

A value that can be specified as a string:

```json
{
  "lang" : "en",
  "value" : "...text of the value..."
}
```


# 3. Data Types for Describing Sources

This section defines JSON types for each of the data types specified by the
"Data Types for Describing Sources" section of the conceptual model specification.

<a id="source-description"/>

## 3.1 The "SourceDescription" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/SourceDescription`
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | An identifier for the JSON object holding the source description data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id | string
citations | The citation for this source. | citations | array of [`SourceCitation`](#source-citation)
about | A uniform resource identifier (URI) for the resource being described. | about | [`URI`](#uri)
mediator | A reference to the entity that mediates access to the described source. | mediator | [`URI`](#uri)
sources | A list of references to any sources from which this source is derived. | sources | array of [`SourceReference`](#source-reference)
extractedConclusions | A list of references to any conclusions that were extracted from this source, to be analyzed and evaluated atomically within on context of the source. | extractedConclusions | [`URI`](#uri)
componentOf | A reference to the source that contains this source. | componentOf | [`SourceReference`](#source-reference)
titles | The display names for this source. | titles | array of [`TextValue`](#text-value)
notes | A list of notes about a source | notes | array of [`Note`](#note)
attribution | The attribution of this source. | attribution | [`Attribution`](#attribution)

### examples

```json
{
  "id" : "local_id",
  "citations" : [ { ... }, { ... } ],
  "about" : "http://identifier/for/the/source/being/described",
  "mediator" : "http://identifier/for/the/mediator/of/source/being/described",
  "sources" : [ { ... }, { ... } ],
  "extractedConclusions" : [ "...", "..." ],
  "componentOf" : { ... },
  "titles" : [ { ... }, { ... } ],
  "notes" : [ { ... }, { ... } ],
  "attribution" : { ... }

  ...possibility of extension elements...

}
```


<a id="source-citation"/>

## 3.2 The "SourceCitation" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/SourceCitation` data type is defined as follows:

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the citation. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
value | A rendering of the full (working) citation as a string. | value | string
citationTemplate | The identifier of the citation template by which this citation may be interpreted. | citationTemplate | [`URI`](#uri)
fields | A list of citation fields about a source. | field | array of [`CitationField`](#citation-field)

### examples

```json
{
  "lang" : "en",
  "value" : "...a rendering of the full (working) citation as a string...",
  "citationTemplate" : "http://identifier/for/ciation/template",
  "fields" : [ { ... }, { ... } ]
}
```

<a id="citation-field"/>

## 3.3 The "CitationField" Data Type

The JSON object used to (de)serialize the
`http://gedcomx.org/v1/CitationField` data type is defined as follows:

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
name | The identifier for the citation detail -- defined by a citation template or a citation template library. | name | [URI](#uri)
value | The value of the citation detail. | value | string

### examples

```json
{
  "name" : "...a citation field name..."
  "value" : "...a citation field value..."
}
```

<a id="source-reference"/>

## 3.4 The "SourceReference" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/SourceReference`
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
description  | Reference to a _description_ of the source being referenced. | description | [`URI`](#uri)
attribution | The attribution of this source reference. | attribution | [`Attribution`](#attribution)

### examples

```json
{
  "description" : "http://identifier/for/description/of/source/being/referenced",
  "attribution" : { ... }

  ...possibility of extension elements...

}
```

# 4. Data Types for Describing Contributors

This section defines JSON types for each of the data types specified by the
"Data Types for Describing Contributors" section of the conceptual model specification.

<a id="online-account"/>

## 4.1 The "OnlineAccount" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/OnlineAccount` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
serviceHomepage  | The home page of the service. | serviceHomepage | [`URI`](#uri)
accountName | The name, label, or id associating the owner of the account with the account. | accountName | string

### examples

```json
{
  "serviceHomepage" : "http://familysearch.org/",
  "accountName" : "...",
}
```

<a id="address"/>

## 4.2 The "Address" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Address` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
value | A string representation of the value. Used when the address isn't separated into its constituent parts. | value | string
city | The city. | city | string
country | The country. | country | string
postalCode | The postal code. | postalCode | string
stateOrProvince | The state or province. | stateOrProvince | string
street | The street. | street | string
street2 | The street (second line). | street2 | string
street3 | The street (third line). | street3 | string

### examples

```json
{
  "city" : "...",
  "country" : "...",
  "postalCode" : "...",
  "stateOrProvince" : "...",
  "street" : "...",
  "street2" : "...",
  "street3" : "...",
  "value" : "..."
}
```
<a id="agent"/>

## 4.3 The "Agent" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Agent` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | An identifier for the JSON object holding the agent data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id | string
names | The names of the person or organization. | names | array of [`TextValue`](#text-value)
identifiers | Identifiers for the agent. | identifiers | [`Identifier`](#identifier-type)
homepage | The homepage of the person or organization. | homepage | [`URI`](#uri)
openid  | The [openid](http://openid.net/) of the person or organization. | openid | [`URI`](#uri)
accounts  | The online accounts of the person or organization. | accounts | array of [`OnlineAccount`](#online-account)
emails  | The email addresses of the person or organization. | emails | array of [`URI`](#uri)
phones  | The phones (voice, fax, mobile) of the person or organization. | phones | array of [`URI`](#uri)
addresses  | The addresses of the person or organization. | addresses | array of [`Address`](#address)

### examples

```json
{
  "id" : "local_id",
  "names" : [ { ... }, { ... } ],
  "homepage" : "...",
  "openid" : "...",
  "accounts" : [ { ... }, { ... } ],
  "emails" : [ "mailto:someone@gedcomx.org" , "mailto:someone@somewhere-else.org" ],
  "phones" : [ "tel:+1-201-555-0123" , "fax:+1-201-555-5555" ],
  "addresses" : [ { ... }, { ... } ],

  ...possibility of extension elements...

}
```


# 5. Data Types for Describing Conclusions

This section defines JSON types for each of the data types specified by the
"Data Types for Describing Conclusions" section of the conceptual model specification.

## 5.1 The "Conclusion" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Conclusion` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | An identifier for the JSON object holding the conclusion data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id | string
lang | The locale identifier for the conclusion. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
confidence  | Reference to the confidence level of the contributor of the attributed data. | confidence | [`URI`](#uri)
sources | The list of references to the sources of the conclusion. | sources | array of [`SourceReference`](#source-reference).
notes | A list of notes about this conclusion. | note | array of [`gx:Note`](#note)

### examples

```json
{
  "id" : "local_id",
  "lang" : "en",
  "confidence" : "http://gedcomx.org/Certainly",
  "sources" : [ { ... }, { ... } ],
  "notes" : [ { ... }, { ... } ],

  ...possibility of extension elements...

}
```

## 5.2 The "Document" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Document` data type is defined as follows:

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
attribution | The attribution of this document. | attribution | [`gx:Attribution`](#attribution)
text | The text of the document. | text | string

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "attribution" : { ... },
  "text" : "...text of the document..."
}
```

<a id="abstract-document"/>

## 5.2.1 The "AbstractDocument" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/AbstractDocument` data type is defined as follows:

### properties

The `AbstractDocument` data type defines no additional properties beyond those defined by its extended type.

<a id="transcription-document"/>

## 5.2.2 The "TranscriptionDocument" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/TranscriptionDocument` data type is defined as follows:

### properties

The `TranscriptionDocument` data type defines no additional properties beyond those defined by its extended type.

<a id="translation-document"/>

## 5.2.3 The "TranslationDocument" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/TranslationDocument` data type is defined as follows:

### properties

The `TranslationDocument` data type defines no additional properties beyond those defined by its extended type.

<a id="analysis-document"/>

## 5.2.4 The "AnalysisDocument" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/AnalysisDocument` data type is defined as follows:

### properties

The `AnalysisDocument` data type defines no additional properties beyond those defined by its extended type.

<a id="gender-conclusion"/>

## 5.3 The "Gender" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Gender` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the gender. | type | [`URI`](#uri)

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "type" : "http://gedcomx.org/Male"
}
```

<a id="name-conclusion"/>

## 5.4 The "Name" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Name` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the name. | type | [`URI`](#uri)
preferred | Whether this name is preferred above the other `Name` conclusions of a person. | preferred | boolean
nameForms | The name form(s) that best represents this name `NameForm` -- usually representations considered proper and well formed in the person's native, historical cultural context. All included name forms should be representations of the same name -- __*not*__ name variants (e.g., nicknames, spelling variations). | nameForms | array of [`NameForm`](#name-form)

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "type" : "http://gedcomx.org/BirthName",
  "preferred" : true,
  "nameForms" : [ { ... }, { ... } ]
}
```

<a id="fact-conclusion"/>

## 5.5 The "Fact" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Fact` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the fact. | type | [`URI`](#uri)
date | The date of applicability of the fact. | date | [`Date`](#conclusion-date)
place | The place of applicability of the fact. | place | [`Place`](#conclusion-place)
value | The original value of the fact as supplied by the contributor. | original | string

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "type" : "http://gedcomx.org/Birth",
  "date" : { ... },
  "place" : { ... },
  "value" : "...the original value of the fact...",
}
```

<a id="person"/>


# 5.6 The "Person" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Person` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
attribution | The attribution of this conclusion. | attribution | [`gx:Attribution`](#attribution)
identifiers | Identifiers for the person. | identifiers | array of [`Identifier`](#identifier-type)
living | Whether the person is considered living. | living | boolean
gender | The conclusion about the gender of the person. | gender | [`Gender`](#gender)
names | The conclusions about the names of the person. | names | array of [`Name`](#name-conclusion)
facts | The conclusions about the facts of the life of the person. | facts | array of [`Fact`](#fact-conclusion)

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "attribution" : { ... },
  "identifiers" : [ { ... }, { ... } ],
  "living" : true,
  "gender" : { ... },
  "names" : [ { ... }, { ... } ],
  "facts" : [ { ... }, { ... } ]
}
```

<a id="relationship"/>

## 5.7 The "Relationship" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Relationship` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
attribution | The attribution of this conclusion. | attribution | [`gx:Attribution`](#attribution)
type | URI identifying the type of the relationship. | type | [`URI`](#uri)
person1 | Reference to the first person in the relationship. | person1 | [`URI`](#uri)
person2 | Reference to the second person in the relationship. | person2 | [`URI`](#uri)
facts | The conclusions about the facts of the life of the relationship. | facts | array of [`Fact`](#fact-conclusion)

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "attribution" : { ... },
  "type" : "http://gedcomx.org/Couple",
  "person1" : "http://identifier/for/person/1",
  "person2" : "http://identifier/for/person/2",
  "facts" : [ { ... }, { ... } ]
}
```

<a id="conclusion-event-role"/>

## 5.8 The "EventRole" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/EventRole`
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
person | Reference to the person playing the role in the event. | person | [`URI`](#uri)
type | Reference to the role type. | type | [`URI`](#uri)
details | Details about the role of the person in the event. | details | string

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "person" : "http://identifier/for/person/1",
  "type" : "http://gedcomx.org/Witness",
  "details" : "..."
}
```

<a id="event"/>

# 5.9 The "Event" Data Type

the JSON object used to (de)serialize the `http://gedcomx.org/v1/Event` data type
is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
attribution | The attribution of this conclusion. | attribution | [`gx:Attribution`](#attribution)
type | URI identifying the type of the event. | type | [`URI`](#uri)
date | The date of the event. | date | [`Date`](#conclusion-date)
place | The place the event. | place | [`Place`](#conclusion-place)
roles | The roles of the persons in the event. | roles | array of [`EventRole`](#conclusion-event-role)

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "attribution" : { ... },
  "type" : "http://gedcomx.org/Marriage",
  "date" : { ... },
  "place" : { ... },
  "roles" : [ { ... }, { ... } ]
}
```

<a id="conclusion-date"/>

## 5.10 The "Date" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Date` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
original | The original value of the date as supplied by the contributor. | original | string
formal | The formal value of the date. | gx:formal | [GEDCOM X Date](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-model-specification.md)

### examples

```json
{
  "original" : "...the original text...",
  "formal" : "..."
}
```

<a id="conclusion-place"/>

## 5.11 The "Place" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Place` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
resource | Reference to the standardized resource describing the place. | resource | [`URI`](#uri)
original | The original value of the place as supplied by the contributor. | original | string
normalized | The normalized text value of the place. | normalized | string

### examples

```json
{
  "resource" : "/path/to/place/resource",
  "original" : "...the original text...",
  "normalized" : "...the normalized value..."
}
```

<a id="name-part"/>

## 5.12 The "NamePart" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/NamePart` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the name part. | type | [`URI`](#uri)
value | The text of the name part. | value | string
qualifiers | Type qualifiers to further describe the type of the name part. | qualifiers | array of [`URI`](#uri)

### examples

```json
{
  "type" : "http://gedcomx.org/Prefix",
  "value" : "...value of the name part..."
  "qualifiers" : [ "http://gedcomx.org/Family", "http://gedcomx.org/Patronymic" ]

  ...possibility of extension elements...

}
```

## 5.13 The "NameForm" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/NameForm` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
lang | The locale identifier for the name form. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
fullText | The full text of the name form. | fullText | string
parts | The parts of the name form. | parts | array of [`NamePart`](#name-part)

### examples

```json
{
  "lang" : "en",
  "fullText" : "...full text of the name form...",
  "parts" : [ { ... }, { ... } ]

  ...possibility of extension elements...

}
```



# 6. Known JSON Extension Members

GEDCOM X defines the notion of extension properties, and the JSON serialization
supports the extensibility requirements detailed in the GEDCOM X conceptual model
specification. When an extension property is provided in a JSON object, the type
of the object can be determined by the value of thesection 1.3 above.

For convenience, GEDCOM X reserves the use of the following member names as
"known" extension members:

name | JSON object type
-----|-----------------
persons | array of [`Person`](#person)
relationships | array of [`Relationship`](#relationship)
facts | array of [`Fact`](#fact-conclusion)
names | array of [`Name`](#name-conclusion)
genders | array of [`Gender`](#gender-conclusion)
source-references | array of [`SourceReference`](#source-reference)
source-descriptions | array of [`SourceDescription`](#rdf-description)
agents | array of [`Agent`](#agent)


7. Fragment Identifiers

Fragment identifiers are used to identify specific objects (i.e. "fragments") within a JSON document. The GEDCOM X
JSON serialization format specifies the use of the "id" member as the fragment identifier for any object in
a given JSON document. Note that some data types explicitly define an "id" property, but the JSON serialization format
allows the option of an "id" property on _all_ objects for the purpose of identifying fragments of the JSON document.
The values of all fragment identifiers within a single JSON document MUST be unique.

For more information about fragment identifiers, see [RFC 3986, Section 3.5](http://tools.ietf.org/html/rfc3986#section-3.5).

# 8. Miscellaneous To Do

todo:
