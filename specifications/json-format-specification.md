# The GEDCOM X JSON Serialization Format

## Status

This document specifies a JSON media type for the [GEDCOM X standard conceptual
model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md),
and requests discussion and suggestions for improvements.

The current state of this document is as a DRAFT, and as such, the document
may be subject to changes, including backwards-incompatible changes, according to the
discussion and suggestions for improvement.

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

The GEDCOM X XML Serialization Format is a specification that defines the media type used
to serialize and deserialize the GEDCOM X conceptual model to and from
[JSON](http://json.org).

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/json/v1`

For convenience, the GEDCOM X JSON Format may be referred to as "GEDCOM X JSON 1.0".

The media type defined by this specification is:

`application/x-gedcomx-v1+json`

This specification is depends on the conceptual model specification identified
by [`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).

## 1.2 Examples

The following example shows an instance of a GEDCOM X serialization in accordance with this specification:

```json
{
  "attribution" : {
    "contributor" : "#GGG-GGGG"
  },
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "fullText" : "George Washington",
        "parts" : [ {
          "value" : "George",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Washington",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ],
      "preferred" : true,
      "id" : "789"
    } ],
    "gender" : {
      "type" : "http://gedcomx.org/Male"
    },
    "facts" : [ {
      "type" : "http://gedcomx.org/Birth",
      "date" : {
        "original" : "February 22, 1732",
        "formal" : "+1732-02-22"
      },
      "place" : {
        "original" : "pope's creek, westmoreland, virginia, united states",
        "description" : "#888"
      },
      "id" : "123"
    }, {
      "type" : "http://gedcomx.org/Death",
      "date" : {
        "original" : "December 14, 1799",
        "formal" : "+1799-12-14T22:00:00"
      },
      "place" : {
        "original" : "mount vernon, fairfax county, virginia, united states",
        "description" : "#999"
      },
      "id" : "456"
    } ],
    "id" : "BBB-BBBB",
    "sources" : [ {
      "description" : "#EEE-EEEE"
    } ]
  }, {
    "names" : [ {
      "nameForms" : [ {
        "fullText" : "Martha Dandridge Custis",
        "parts" : [ {
          "value" : "Martha Dandridge",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Custis",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ],
      "preferred" : true,
      "id" : "987"
    } ],
    "gender" : {
      "type" : "http://gedcomx.org/Male"
    },
    "facts" : [ {
      "type" : "http://gedcomx.org/Birth",
      "date" : {
        "original" : "June 2, 1731",
        "formal" : "+1731-06-02"
      },
      "place" : {
        "original" : "chestnut grove, new kent, virginia, united states",
        "description" : "#KKK"
      },
      "id" : "321"
    }, {
      "type" : "http://gedcomx.org/Death",
      "date" : {
        "original" : "May 22, 1802",
        "formal" : "+1802-05-22"
      },
      "place" : {
        "original" : "mount vernon, fairfax county, virginia, united states",
        "description" : "#999"
      },
      "id" : "654"
    } ],
    "id" : "CCC-CCCC",
    "sources" : [ {
      "description" : "#FFF-FFFF"
    } ]
  } ],
  "relationships" : [ {
    "facts" : [ {
      "date" : {
        "original" : "January 6, 1759",
        "formal" : "+01-06-1759"
      },
      "place" : {
        "original" : "White House Plantation"
      }
    } ],
    "person1" : "#BBB-BBBB",
    "person2" : "#CCC-CCCC",
    "id" : "DDD-DDDD",
    "sources" : [ {
      "description" : "#FFF-FFFF"
    } ]
  } ],
  "sourceDescriptions" : [ {
    "id" : "EEE-EEEE",
    "about" : "http://en.wikipedia.org/wiki/George_washington",
    "citations" : [ {
      "value" : "\"George Washington.\" Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012."
    } ]
  }, {
    "id" : "FFF-FFFF",
    "about" : "http://en.wikipedia.org/wiki/Martha_washington",
    "citations" : [ {
      "value" : "\"Martha Washington.\" Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012."
    } ]
  } ],
  "agents" : [ {
    "id" : "GGG-GGGG",
    "names" : [ {
      "value" : "Ryan Heaton"
    } ]
  } ],
  "places" : [ {
    "names" : [ {
      "value" : "Pope's Creek, Westmoreland, Virginia, United States"
    } ],
    "latitude" : 38.192353,
    "longitude" : -76.904069,
    "id" : "888"
  }, {
    "names" : [ {
      "value" : "Mount Vernon, Fairfax County, Virginia, United States"
    } ],
    "latitude" : 38.721144,
    "longitude" : -77.109461,
    "id" : "999"
  }, {
    "names" : [ {
      "value" : "Chestnut Grove, New Kent, Virginia, United States"
    } ],
    "latitude" : 37.518304,
    "longitude" : -76.984148,
    "id" : "KKK"
  } ]
}
```


## 1.3 Notational Conventions

### 1.3.1 Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14, 
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance 
targets.

### Data Types

For each data type specified by the GEDCOM X conceptual model, a
JSON data format is supplied which specifies how each of the
properties of the data type are to be serialized in JSON. Each instance
of a data type is serialized as a JSON object. The properties
of each data type are serialized as members of the JSON object.

## 1.4 Compliance

An implementation of the GEDCOM X conceptual model is "non-compliant" if it fails to satisfy
one or more of the MUST or REQUIRED level requirements. An implementation that satisfies all of
the  MUST or REQUIRED and all of the SHOULD level requirements is said to be "unconditionally
compliant"; and implementation that satisfies all of the MUST level requirements but not all of the
SHOULD level requirements is said to be "conditionally compliant".

In addition to the compliance requirements provided by this specification, all compliance requirements
provided by the GEDCOM X Conceptual Model identified by
[`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md)
are inherited.

# 2. Top-Level Data Types

This section specifies JSON types for each top-level data type defined by the
conceptual model specification.

<a id="person"/>

# 2.1 The "Person" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Person` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
attribution | The attribution of this conclusion. | attribution | [`Attribution`](#attribution)
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

## 2.2 The "Relationship" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Relationship` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
attribution | The attribution of this conclusion. | attribution | [`Attribution`](#attribution)
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

<a id="source-description"/>

## 2.3 The "SourceDescription" Data Type

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

<a id="agent"/>

## 2.4 The "Agent" Data Type

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

<a id="event"/>

# 2.5 The "Event" Data Type

the JSON object used to (de)serialize the `http://gedcomx.org/v1/Event` data type
is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
attribution | The attribution of this conclusion. | attribution | [`Attribution`](#attribution)
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

## 2.6 The "Document" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Document` data type is defined as follows:

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the document. | type | [`URI`](#uri)
attribution | The attribution of this document. | attribution | [`Attribution`](#attribution)
text | The text of the document. | text | string

### examples

```json
{

  ...the members of gxc:Conclusion...,

  "type" : "http://gedcomx.org/Analysis",
  "attribution" : { ... },
  "text" : "...text of the document..."
}
```

# 2.7 The "PlaceDescription" Data Type

the JSON object used to (de)serialize the `http://gedcomx.org/v1/PlaceDescription` data type
is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
about | A uniform resource identifier (URI) for the place being described. | about | [`URI`](#uri)
names | A list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place. | names | array of [`TextValue`](#text-value)
type | A uniform resource identifier (URI) identifying the type of the place as it is applicable to this description. | type | [`URI`](#uri)
temporalDescription | A description of the time period to which this place description is relevant. | temporalDescription | [`Date`](#conclusion-date)
latitude | Degrees north or south of the Equator (0.0 degrees). | latitude | number
longitude | Angular distance in degrees, relative to the Prime Meridian. | longitude | number
spatialDescription | A reference to a geospatial description of this place. | spatialDescription | [`URI`](#uri)
identifiers | A list of known identifiers for this place description (e.g., place authority identifiers). | identifiers | array of [`Identifier`](#identifier-type)
attribution | The attribution of this conclusion. | attribution | [`Attribution`](#attribution)

### examples

```json
{

  ...the members of Conclusion...,

  "about" : "http://identifier/of/the/place/being/described",
  "names" : [ { ... }, { ... } ],
  "type" : "http://identifier/for/the/place/type",
  "temporalDescription" : { ... },
  "latitude" : "27.9883575",
  "latitude" : "86.9252014",
  "spatialDescription" : "http://uri/for/KML/document",
  "identifiers" : [ { ... }, { ... } ],
  "attribution" : { ... }
}
```

# 3. Component-Level Data Types

This section specifies JSON types for each component-level data type defined by the
conceptual model specification.

<a id="identifier-type"/>

## 3.1 The "Identifier" Data Type

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

## 3.2 The "Attribution" Data Type

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

## 3.3 The "Note" Data Type

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

## 3.4 The "TextValue" Data Type

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

<a id="source-citation"/>

## 3.5 The "SourceCitation" Data Type

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

## 3.6 The "CitationField" Data Type

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

## 3.7 The "SourceReference" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/SourceReference`
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
descriptionRef  | Reference to a _description_ of the source being referenced. | description | [`URI`](#uri)
attribution | The attribution of this source reference. | attribution | [`Attribution`](#attribution)

### examples

```json
{
  "description" : "http://identifier/for/description/of/source/being/referenced",
  "attribution" : { ... }

  ...possibility of extension elements...

}
```

## 3.8 The "CitationTemplate" Data Type

TBD

<a id="online-account"/>

## 3.9 The "OnlineAccount" Data Type

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

## 3.10 The "Address" Data Type

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

## 3.11 The "Conclusion" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Conclusion` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | An identifier for the JSON object holding the conclusion data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id | string
lang | The locale identifier for the conclusion. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
confidence  | Reference to the confidence level of the contributor of the attributed data. | confidence | [`URI`](#uri)
sources | The list of references to the sources of the conclusion. | sources | array of [`SourceReference`](#source-reference).
notes | A list of notes about this conclusion. | note | array of [`Note`](#note)

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

## 3.12 The "Gender" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Gender` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the gender. | type | [`URI`](#uri)

### examples

```json
{

  ...the members of Conclusion...,

  "type" : "http://gedcomx.org/Male"
}
```

<a id="name-conclusion"/>

## 3.13 The "Name" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Name` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the name. | type | [`URI`](#uri)
preferred | Whether this name is preferred above the other `Name` conclusions of a person. | preferred | boolean
date | The date of applicability of the name. | date | [`Date`](#conclusion-date)
nameForms | The name form(s) that best represents this name `NameForm` -- usually representations considered proper and well formed in the person's native, historical cultural context. All included name forms should be representations of the same name -- __*not*__ name variants (e.g., nicknames, spelling variations). | nameForms | array of [`NameForm`](#name-form)

### examples

```json
{

  ...the members of Conclusion...,

  "type" : "http://gedcomx.org/BirthName",
  "preferred" : true,
  "date" : { ... },
  "nameForms" : [ { ... }, { ... } ]
}
```

<a id="fact-conclusion"/>

## 3.14 The "Fact" Data Type

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

  ...the members of Conclusion...,

  "type" : "http://gedcomx.org/Birth",
  "date" : { ... },
  "place" : { ... },
  "value" : "...the original value of the fact...",
}
```

<a id="conclusion-event-role"/>

## 3.15 The "EventRole" Data Type

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

  ...the members of Conclusion...,

  "person" : "http://identifier/for/person/1",
  "type" : "http://gedcomx.org/Witness",
  "details" : "..."
}
```

<a id="conclusion-date"/>

## 3.16 The "Date" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/Date` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
original | The original value of the date as supplied by the contributor. | original | string
formal | The formal value of the date. | formal | [GEDCOM X Date](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-model-specification.md)

### examples

```json
{
  "original" : "...the original text...",
  "formal" : "..."
}
```

<a id="conclusion-place-reference"/>

# 3.17 The "PlaceReference" Data Type

the JSON object used to (de)serialize the `http://gedcomx.org/v1/PlaceReference` data type
is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
original | The original place name text as supplied by the contributor. | string | OPTIONAL.
descriptionRef | A reference to a _description_ of this place. | description | [`URI`](#uri)

### examples

```json
{
  "original" : "...the original text...",
  "description" : "http://identifier/of/place-description/being/referenced",

  ...possibility of extension elements...

}
```

<a id="name-part"/>

## 3.18 The "NamePart" Data Type

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

## 3.19 The "NameForm" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/v1/NameForm` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|---------
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

# 4 JSON-Specific Data Types

This section describes a set of data types that are specific to the GEDCOM X JSON media
type, used for the convenience of serialization.

<a id="uri"/>

## 4.1 The URI

URIs are supplied as JSON strings and are interpreted according to
[RFC 3986: Uniform Resource Identifier (URI): Generic Syntax](http://www.ietf.org/rfc/rfc3986.txt).

## 4.2 The "Gedcomx" Data Type

The `Gedcomx` JSON type is used as a container for a set of GEDCOM X data.

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|---------
id | An identifier for the data set. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id | string
lang | The locale identifier for the data set. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
attribution | The attribution of this data set. | attribution | [`Attribution`](#attribution)
persons | The list of persons contained in the data set. | persons | array of [`Person`](#person)
relationships | The list of relationships contained in the data set. | relationships | array of [`Relationship`](#relationship)
sourceDescriptions | The list of source descriptions contained in the data set. | sourceDescriptions | array of [`SourceDescription`](#source-description)
agents | The list of agents contained in the data set. | agents | array of [`Agent`](#agent)
events | The list of events contained in the data set. | events | array of [`Event`](#event)
documents | The list of documents contained in the data set. | documents | array of [`Document`](#document)

### examples

```json
{
  "id" : "local_id",
  "attribution" : { ... },
  "persons" : [ { ... }, { ... } ],
  "relationships" : [ { ... }, { ... }, ],
  "sourceDescriptions" : [ { ... }, { ... } ],
  "agents" : [ { ... } , { ... } ],
  "events" : [ { ... } , { ... } ],
  "documents" : [ { ... } , { ... } ],

    ...possibility of extension elements...

}
```

# 5. The GEDCOM X Object

The body of a document compliant with the GEDCOM X JSON media type MUST be an instance of the
GEDCOM X Object, which is defined by an JSON object of the `Gedcomx` data type.

## Example

The following is an example of the structure of a GEDCOM X XML Element:

```json
{
  "id" : "local_id",
  "attribution" : { ... },
  "persons" : [ { ... }, { ... } ],
  "relationships" : [ { ... }, { ... }, ],
  "sourceDescriptions" : [ { ... }, { ... } ],
  "agents" : [ { ... } , { ... } ],
  "events" : [ { ... } , { ... } ],
  "documents" : [ { ... } , { ... } ],

    ...possibility of extension elements...

}
```


# 6. Known JSON Extension Members

GEDCOM X defines the notion of extension properties, and the JSON serialization
supports the extensibility requirements detailed in the GEDCOM X conceptual model
specification. When an extension property is provided in a JSON object, the type
of the object can be determined by the name of the JSON member.

For convenience, GEDCOM X reserves the use of the following member names as
"known" extension members:

name | JSON object type
-----|-----------------
persons | array of [`Person`](#person)
relationships | array of [`Relationship`](#relationship)
events | array of [`Event`](#event)
facts | array of [`Fact`](#fact-conclusion)
names | array of [`Name`](#name-conclusion)
genders | array of [`Gender`](#gender-conclusion)
sourceReferences | array of [`SourceReference`](#source-reference)
sourceDescriptions | array of [`SourceDescription`](#rdf-description)
agents | array of [`Agent`](#agent)
documents | array of [`Document`](#document)
attribution | array of [`Attribution`](#attribution)
notes | array of [`Note`](#note)


7. Fragment Identifiers

Fragment identifiers are used to identify specific objects (i.e. "fragments") within a JSON document. The GEDCOM X
JSON serialization format specifies the use of the "id" member as the fragment identifier for any object in
a given JSON document. Note that some data types explicitly define an "id" property, but the JSON serialization format
allows the option of an "id" property on _all_ objects for the purpose of identifying fragments of the JSON document.
The values of all fragment identifiers within a single JSON document MUST be unique.

For more information about fragment identifiers, see [RFC 3986, Section 3.5](http://tools.ietf.org/html/rfc3986#section-3.5).

# 8. Miscellaneous To Do

todo:
