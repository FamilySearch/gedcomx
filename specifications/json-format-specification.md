# The GEDCOM X JSON Serialization Format

## Status

This document specifies a JSON media type for the [GEDCOM X Conceptual
Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md),
and requests discussion and suggestions for improvements.

The current state of this document is as a "stable draft", and as such, the document
may be subject to limited changes, BUT NOT backwards-incompatible changes, according to the
discussion and suggestions for improvement.

## Copyright Notice

Copyright Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

## Summary

The GEDCOM X JSON Serialization Format spec specifies how to represent the [GEDCOM X Conceptual
Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md) in JSON. The spec includes examples, notational conventions, top-level data types, component-level data types, JSON-specific data types, the GEDCOM X object, extensibility, and fragment identifiers.

<a name="intro"/>

# 1. Introduction

The GEDCOM X Conceptual Model is a specification of formal concepts and types that are used to provide a standard model and vocabulary for describing genealogical data.

The GEDCOM X JSON Serialization Format is a specification that defines the media type used
to serialize and deserialize the GEDCOM X Conceptual Model to and from
[JSON](http://json.org).

## Table Of Contents

* [1. Introduction](#intro)
  * [1.1 Identifier, Version and Dependencies](#id-and-version)
  * [1.2 Examples](#examples)
  * [1.3 Notational Conventions](#notational-conventions)
    * [1.3.1 Keywords](#keywords)
    * [1.3.2 Data Types](#data-types)
  * [1.4 Compliance](#compliance)
* [2. Top-Level Data Types](#top-data-types)
  * [2.1 The "Person" Data Type](#person)
  * [2.2 The "Relationship" Data Type](#relationship)
  * [2.3 The "SourceDescription" Data Type](#source-description)
  * [2.4 The "Agent" Data Type](#agent)
  * [2.5 The "Event" Data Type](#event)
  * [2.6 The "Document" Data Type](#document)
  * [2.7 The "PlaceDescription" Data Type](#place-description)
  * [2.7 The "Group" Data Type](#group)
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
  * [3.11 The "Subject" Data Type](#subject)
  * [3.12 The "Gender" Data Type](#gender-conclusion)
  * [3.13 The "Name" Data Type](#name-conclusion)
  * [3.14 The "Fact" Data Type](#fact-conclusion)
  * [3.15 The "EventRole" Data Type](#conclusion-event-role)
  * [3.16 The "Date" Data Type](#conclusion-date)
  * [3.17 The "PlaceReferece" Data Type](#conclusion-place-reference)
  * [3.18 The "NamePart" Data Type](#name-part)
  * [3.19 The "NameForm" Data Type](#name-form)
  * [3.20 The "Qualifier" Data Type](#qualifier)
  * [3.21 The "Coverage" Data Type](#coverage)
  * [3.22 The "Coverage" Data Type](#conclusion-group-role)
* [4. JSON-Specific Data Types](#json-specific-data-types)
  * [4.1 The URI](#uri)
  * [4.2 The "ResourceReference" Data Type](#resource-reference)
  * [4.3 The "Gedcomx" Data Type](#gedcomx-type)
* [5. The GEDCOM X Object](#gedcomx-object)
* [6. Extensibility](#extensibility)
* [7. Fragment Identifiers](#fragment-ids)

<a name="id-and-version"/>

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/json/v1`

For convenience, the GEDCOM X JSON Format may be referred to as "GEDCOM X JSON 1.0".

The media type defined by this specification is:

`application/x-gedcomx-v1+json`

This specification depends on the GEDCOM X Conceptual Model specification identified
by [`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).

<a name="examples"/>

## 1.2 Examples

The following example shows an instance of a GEDCOM X serialization in accordance with this specification:

```javascript
{
  "attribution" : {
    "contributor" : {
      "resource" : "#GGG-GGGG"
    }
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
    "sources" : [ {
      "description" : "#EEE-EEEE"
    } ],
    "id" : "BBB-BBBB"
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
    "sources" : [ {
      "description" : "#FFF-FFFF"
    } ],
    "id" : "CCC-CCCC"
  } ],
  "relationships" : [ {
    "facts" : [ {
      "type" : "http://gedcomx.org/Marriage",
      "date" : {
        "original" : "January 6, 1759",
        "formal" : "+1759-01-06"
      },
      "place" : {
        "original" : "White House Plantation"
      }
    } ],
    "person1" : {
      "resource" : "#BBB-BBBB"
    },
    "person2" : {
      "resource" : "#CCC-CCCC"
    },
    "sources" : [ {
      "description" : "#FFF-FFFF"
    } ],
    "id" : "DDD-DDDD"
  } ],
  "sourceDescriptions" : [ {
    "citations" : [ {
      "value" : "\"George Washington.\" Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012."
    } ],
    "about" : "http://en.wikipedia.org/wiki/George_washington",
    "id" : "EEE-EEEE"
  }, {
    "citations" : [ {
      "value" : "\"Martha Washington.\" Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012."
    } ],
    "about" : "http://en.wikipedia.org/wiki/Martha_washington",
    "id" : "FFF-FFFF"
  } ],
  "agents" : [ {
    "names" : [ {
      "value" : "Ryan Heaton"
    } ],
    "id" : "GGG-GGGG"
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

<a name="notational-conventions"/>

## 1.3 Notational Conventions

<a name="keywords"/>

### 1.3.1 Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

<a name="data-types"/>

### 1.3.2 Data Types

For each data type specified by the GEDCOM X Conceptual Model, a JSON data
format is supplied which specifies how each of the properties of the data type
are to be serialized in JSON. Each instance of a data type is serialized as a
JSON object. The properties of each data type are serialized as members of the
JSON object.

<a name="compliance"/>

## 1.4 Compliance

In addition to the compliance requirements provided by this specification, all
compliance requirements provided by the GEDCOM X Conceptual Model identified by
[`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md)
are inherited.

<a name="top-data-types"/>

# 2. Top-Level Data Types

This section specifies JSON types for each top-level data type defined by the
GEDCOM X Conceptual Model specification.

<a name="person"/>

# 2.1 The "Person" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Person`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#person) data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
private | Whether this instance of `Person` has been designated for limited distribution or display. | private | boolean
gender | The sex of the person as assigned at birth | gender | [`Gender`](#gender-conclusion)
names | The names of the person. | names | array of [`Name`](#name-conclusion)
facts | The facts of the person. | facts | array of [`Fact`](#fact-conclusion)

### examples

```javascript
{

  //...the members of [Subject](#subject)/*...*/,

  "private" : false,
  "gender" : { /*...*/ },
  "names" : [ { /*...*/ }, { /*...*/ } ],
  "facts" : [ { /*...*/ }, { /*...*/ } ]
}
```

<a name="relationship"/>

## 2.2 The "Relationship" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Relationship`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#relationship) data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the relationship. | type | [`URI`](#uri)
person1 | Reference to the first person in the relationship. | person1 | [`ResourceReference`](#resource-reference)
person2 | Reference to the second person in the relationship. | person2 | [`ResourceReference`](#resource-reference)
facts | The facts about the relationship. | facts | array of [`Fact`](#fact-conclusion)

### examples

```javascript
{

  //...the members of [Subject](#subject)/*...*/,

  "type" : "http://gedcomx.org/Couple",
  "person1" : {
    "resource" : "http://identifier/for/person/1"
  },
  "person2" : {
    "resource" : "http://identifier/for/person/2"
  },
  "facts" : [ { /*...*/ }, { /*...*/ } ]
}
```

<a name="source-description"/>

## 2.3 The "SourceDescription" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/SourceDescription`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-description)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | The identifier for the JSON object holding the source description data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id | string
resourceType | URI identifying the type of resource being described. | resourceType | [`URI`](#uri)
citations | The citation(s) for this source. | citations | array of [`SourceCitation`](#source-citation)
mediaType | A hint about the media type of the resource being described. | mediaType | string
about | A uniform resource identifier (URI) for the resource being described. | about | [`URI`](#uri)
mediator | A reference to the entity that mediates access to the described source. | mediator | [`ResourceReference`](#resource-reference)
publisher | A reference to the entity responsible for making the described source available. | publisher | [`ResourceReference`](#resource-reference)
sources | A list of references to any sources from which this source is derived. | sources | array of [`SourceReference`](#source-reference)
analysis | A reference to a document containing analysis about this source. | analysis | [`ResourceReference`](#resource-reference)
componentOf | A reference to the source that contains this source. | componentOf | [`SourceReference`](#source-reference)
titles | The display name(s) for this source. | titles | array of [`TextValue`](#text-value)
notes | A list of notes about a source | notes | array of [`Note`](#note)
attribution | The attribution of this source. | attribution | [`Attribution`](#attribution)
rights  | The rights for this resource. | rights | array of [`ResourceReference`](#resource-reference)
coverage | The coverage of the resource. | coverage | array of [`Coverage`](#coverage)
descriptions | Human-readable descriptions of this source. | descriptions | array of [`TextValue`](#text-value)
identifiers | A list of identifiers for the resource being described. | identifiers | [`Identifier`](#identifier-type)
created | Timestamp of when the resource being described was created. | created | number (milliseconds since epoch)
modified | Timestamp of when the resource being described was modified. | modified | number (milliseconds since epoch)
repository | A reference to the repository that contains the described resource. | repository | [`ResourceReference`](#resource-reference)

### examples

```javascript
{
  "id" : "local_id",
  "resourceType" : "...",
  "citations" : [ { /*...*/ }, { /*...*/ } ],
  "mediaType" : "...",
  "about" : "http://identifier/for/the/source/being/described",
  "mediator" : {
    "resource" : "http://identifier/for/the/mediator/of/source/being/described"
  },
  "publisher" : {
    "resource" : "http://identifier/for/the/publisher/of/source/being/described"
  },
  "sources" : [ { /*...*/ }, { /*...*/ } ],
  "analysis" : {
    "resource" : "http://identifier/for/analysis/document"
  },
  "componentOf" : { /*...*/ },
  "titles" : [ { /*...*/ }, { /*...*/ } ],
  "notes" : [ { /*...*/ }, { /*...*/ } ],
  "attribution" : { /*...*/ },
  "rights" : [ { /*...*/ }, { /*...*/ }],
  "coverage" : { /*...*/ },
  "descriptions" : [ { /*...*/ }, { /*...*/ } ],
  "identifiers" : { /*...*/ }
  "created" : /*...*/,
  "modified" : /*...*/,
  "repository" : { /*...*/ }

  //...possibility of extension elements...

}
```

<a name="agent"/>

## 2.4 The "Agent" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Agent`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#agent) data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | An identifier for the JSON object holding the agent data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id | string
identifiers | Identifiers for this agent. | identifiers | [`Identifier`](#identifier-type)
names | The name(s) of the person or organization. | names | array of [`TextValue`](#text-value)
homepage | The homepage of the person or organization. | homepage | [`ResourceReference`](#resource-reference)
openid  | The [openid](http://openid.net/) of the person or organization. | openid | [`ResourceReference`](#resource-reference)
accounts  | The online account(s) of the person or organization. | accounts | array of [`OnlineAccount`](#online-account)
emails  | The email address(es) of the person or organization. | emails | array of [`ResourceReference`](#resource-reference)
phones  | The phone(s) (voice, fax, mobile) of the person or organization. | phones | array of [`ResourceReference`](#resource-reference)
addresses  | The address(es) of the person or organization. | addresses | array of [`Address`](#address)
person | A reference to the person that describes this agent. | person | [`ResourceReference`](#resource-reference)

### examples

```javascript
{
  "id" : "local_id",
  "identifiers" : { /*...*/ }
  "names" : [ { /*...*/ }, { /*...*/ } ],
  "homepage" : {
    "resource" : "..."
  },
  "openid" : {
    "resource" : "..."
  },
  "accounts" : [ { /*...*/ }, { /*...*/ } ],
  "emails" : [ { "resource" : "mailto:someone@gedcomx.org" } , { "resource" : "mailto:someone@somewhere-else.org" } ],
  "phones" : [ { "resource" : "tel:+1-201-555-0123" } , { "resource" : "fax:+1-201-555-5555" } ],
  "addresses" : [ { /*...*/ }, { /*...*/ } ],
  "person" : { "resource" : "..." }

  //...possibility of extension elements...

}
```

<a name="event"/>

# 2.5 The "Event" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Event`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#event) data type
is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the event. | type | [`URI`](#uri)
date | The date of the event. | date | [`Date`](#conclusion-date)
place | The place of the event. | place | [`PlaceReference`](#conclusion-place-reference)
roles | Information about how persons participated in the event. | roles | array of [`EventRole`](#conclusion-event-role)

### examples

```javascript
{

  //...the members of [Subject](#subject)...,

  "type" : "http://gedcomx.org/Marriage",
  "date" : { /*...*/ },
  "place" : { /*...*/ },
  "roles" : [ { /*...*/ }, { /*...*/ } ]
}
```

<a name="document"/>

## 2.6 The "Document" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Document`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#document) data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|---------
type | URI identifying the type of the document. | type | [`URI`](#uri)
extracted | Whether this document is to be constrained as an [_extracted conclusion_](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#4-extracted-conclusion-constraints). | extracted | boolean
textType | The type of text in the `text` property. | textType | string
text | The text of the document. | text | string
attribution | The attribution of this document. | attribution | [`Attribution`](#attribution)

### examples

```javascript
{

  //...the members of [Conclusion](#conclusion)...,

  "extracted" : false,
  "type" : "http://gedcomx.org/Analysis",
  "attribution" : { /*...*/ },
  "textType" : "plain",
  "text" : "...text of the document..."
}
```

<a name="place-description"/>

# 2.7 The "PlaceDescription" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/PlaceDescription`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#place-description) data type
is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
names | A list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place. | names | array of [`TextValue`](#text-value)
type | A uniform resource identifier (URI) identifying the type of the place as it is applicable to this description. | type | [`URI`](#uri)
place | An identifier for the place being described. | place | [`ResourceReference`](#resource-reference)
jurisdiction | A reference to a description of the jurisdiction of this place. | jurisdiction | [`ResourceReference`](#resource-reference)
latitude | Angular distance, in degrees, north or south of the Equator. | latitude | number
longitude | Angular distance, in degrees, east or west of the Prime Meridian. | longitude | number
temporalDescription | A description of the time period to which this place description is relevant. | temporalDescription | [`Date`](#conclusion-date)
spatialDescription | A reference to a geospatial description of this place. | spatialDescription | [`ResourceReference`](#resource-reference)

### examples

```javascript
{

  //...the members of [Subject](#subject)...,

  "names" : [ {
    "lang" : "en",
    "value" : "Pope's Creek, Westmoreland, Virginia, United States"
  } ,
  {
    "lang" : "zh",
    "value" : "教皇的小河，威斯特摩兰，弗吉尼亚州，美国"
  } ],
  "type" : "http://identifier/for/the/place/type",
  "place" : { "resource" : "..." },
  "jurisdiction" : { "resource" : "..." },
  "latitude" : "27.9883575",
  "latitude" : "86.9252014",
  "temporalDescription" : { /*...*/ },
  "spatialDescription" : {
    "resource" : "http://uri/for/KML/document"
  }
}
```

<a name="group"/>

# 2.8 The "Group" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Group`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#place-description) data type
is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
names | A list of names of the group. | names | array of [`TextValue`](#text-value)
date | The date of applicability of the group. | date | [`Date`](#conclusion-date)
place | The place of applicability of the group. | place | [`PlaceReference`](#conclusion-place-reference)
roles | Information about how persons participated in the event. | roles | array of [`EventRole`](#conclusion-event-role)

### examples

```javascript
{

  //...the members of [Subject](#subject)...,

  "names" : [ {
    "lang" : "en",
    "value" : "Monticello Plantation"
  } ,
  {
    "lang" : "zh",
    "value" : "monticello种植园"
  } ],
  "date" : { /*...*/ },
  "place" : { /*...*/ },
  "roles" : [ { /*...*/ }, { /*...*/ } ]
}
```

### examples

```javascript
{

  //...the members of [Subject](#subject)...,

  "names" : [ {
    "lang" : "en",
    "value" : "Pope's Creek, Westmoreland, Virginia, United States"
  } ,
  {
    "lang" : "zh",
    "value" : "教皇的小河，威斯特摩兰，弗吉尼亚州，美国"
  } ],
  "type" : "http://identifier/for/the/place/type",
  "place" : { "resource" : "..." },
  "jurisdiction" : { "resource" : "..." },
  "latitude" : "27.9883575",
  "latitude" : "86.9252014",
  "temporalDescription" : { /*...*/ },
  "spatialDescription" : {
    "resource" : "http://uri/for/KML/document"
  }
}
```

<a name="component-data-types"/>

# 3. Component-Level Data Types

This section specifies JSON types for each component-level data type defined by the
conceptual model specification.

<a name="identifier-type"/>

## 3.1 The "Identifier" Data Type

In JSON, the [`http://gedcomx.org/v1/Identifier`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#identifier-type)
data type is always serialized in the context of a set
of identifiers, which is represented using a JSON object. The name of each member of the object is
the identifier `type`. The value of each member carries the string values of the identifiers of that type.
All known GEDCOM X identifier types MAY carry multiple values, so the value of the member for each
known identifier type MUST be an array of `string`s.

Some custom identifier types MAY specify that the identifier type is "single-valued", meaning
there MUST NOT be more than one value of the specified identifier type, per entity. If an identifier
type is specified as a "single-valued" identifier type, the value of the member named by that identifier
type MAY forgo the array and use a single string.

Since the identifier `type` is an OPTIONAL property, the name of the member that carries untyped identifiers
SHALL be "$".

### example: set of identifiers

```javascript
{
  "$" : [ "value_of_untyped_identifier" ],
  "http://gedcomx.org/IdentifierType" : [ "value_of_identifier" ],
  "http://gedcomx.org/OtherIdentifierType" : [ "value_of_identifier" ],
  "http://custom.org/SingleValuedIdentifierType" : "value_of_identifier",
  ...
}
```

<a name="attribution"/>

## 3.2 The "Attribution" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Attribution`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#attribution)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
contributor | Reference to the contributor to whom the attributed data is attributed. | contributor | [`ResourceReference`](#resource-reference)
modified | Timestamp of when the attributed data was contributed. | modified | number (milliseconds since epoch)
changeMessage | A statement of why the attributed data is being provided by the contributor. | changeMessage | string
creator | Reference to the agent that created the attributed data. The creator MAY be different from the contributor if changes were made to the attributed data. | creator | [`ResourceReference`](#resource-reference)
created | Timestamp of when the attributed data was contributed. | created | number (milliseconds since epoch)

### examples

```javascript
{
  "contributor" : {
    "resource" : "http://identifier/for/contributor"
  },
  "modified" : 1338494969,
  "changeMessage" : "...change message here..."
  "creator" : {
    "resource" : "http://identifier/for/creator"
  },
  "created" : 1338394969,

  //...possibility of extension elements...

}
```

<a name="note"/>

## 3.3 The "Note" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Note`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#note)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
lang | The locale identifier for the note. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
subject | A subject or title for the note. | subject | string
text | The text of the note. | text | string
attribution | The attribution of this note. | attribution | [`Attribution`](#attribution)

### examples

```javascript
{
  "lang" : "en",
  "subject" : "...",
  "text" : "...",
  "attribution" : { /*...*/ }

  //...possibility of extension elements...

}
```

<a name="text-value"/>

## 3.4 The "TextValue" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/TextValue`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#text-value)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|-----------------
lang | The locale identifier for the value of the text. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
value | The text value. | value | string

### examples

A value that can be specified as a string:

```javascript
{
  "lang" : "en",
  "value" : "...text of the value..."
}
```

<a name="source-citation"/>

## 3.5 The "SourceCitation" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/SourceCitation`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-citation)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|-----------------
lang | The locale identifier for the citation. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
value | A rendering of the full citation as a string. | value | string

### examples

```javascript
{
  "lang" : "en",
  "value" : "...a rendering of the full citation as a string..."

  //...possibility of extension elements...

}
```

<a name="source-reference"/>

## 3.6 The "SourceReference" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/SourceReference`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-reference)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
descriptionRef  | Reference to a _description_ of the source being referenced. | description | [`URI`](#uri)
descriptionId  | The id of the target source. | descriptionId | string
attribution | The attribution of this source reference. | attribution | [`Attribution`](#attribution)

### examples

```javascript
{
  "description" : "http://identifier/for/description/of/source/being/referenced",
  "descriptionId" : "...",
  "attribution" : { /*...*/ }

  //...possibility of extension elements...

}
```

<a name="evidence-reference"/>

## 3.7 The "EvidenceReference" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/EvidenceReference`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#evidence-reference)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
resource  | Reference to the supporting data. | resource | [`URI`](#uri)
attribution | The attribution of this evidence reference. | attribution | [`Attribution`](#attribution)

### examples

```javascript
{
  "resource" : "http://identifier/for/data/being/referenced",
  "attribution" : { /*...*/ }

  //...possibility of extension elements...

}
```

<a name="online-account"/>

## 3.8 The "OnlineAccount" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/OnlineAccount`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#online-account)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
serviceHomepage  | The URI identifying the online service provider that holds the account being described. | serviceHomepage | [`ResourceReference`](#resource-reference)
accountName | The name, label, or id that uniquely identifies the account maintained by the online service provider. | accountName | string

### examples

```javascript
{
  "serviceHomepage" : {
    "resource" : "http://familysearch.org/"
  },
  "accountName" : "..."

  //...possibility of extension elements...

}
```

<a name="address"/>

## 3.9 The "Address" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Address`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#address)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
value | A full representation of the complete address. | value | string
city | The city. | city | string
country | The country. | country | string
postalCode | The postal code. | postalCode | string
stateOrProvince | The state or province. | stateOrProvince | string
street | The street. | street | string
street2 | The street (second line). | street2 | string
street3 | The street (third line). | street3 | string
street4 | The street (fourth line). | street4 | string
street5 | The street (fifth line). | street5 | string
street6 | The street (sixth line). | street6 | string

### examples

```javascript
{
  "value" : "...",
  "city" : "...",
  "country" : "...",
  "postalCode" : "...",
  "stateOrProvince" : "...",
  "street" : "...",
  "street2" : "...",
  "street3" : "...",
  "street4" : "...",
  "street5" : "...",
  "street6" : "..."

  //...possibility of extension elements...

}
```

<a name="conclusion"/>

## 3.10 The "Conclusion" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Conclusion`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#conclusion)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | An identifier for the JSON object holding this conclusion's data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id | string
lang | The locale identifier for the conclusion. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
sources | The list of references to sources related to this conclusion. | sources | array of [`SourceReference`](#source-reference).
analysis  | Reference to a document containing analysis supporting this conclusion. | analysis | [`ResourceReference`](#resource-reference)
notes | A list of notes about this conclusion. | notes | array of [`Note`](#note)
confidence  | Reference to a confidence level for this conclusion. | confidence | [`URI`](#uri)
attribution | The attribution of this conclusion. | attribution | [`Attribution`](#attribution)

### examples

```javascript
{
  "id" : "local_id",
  "lang" : "en",
  "sources" : [ { /*...*/ }, { /*...*/ } ],
  "analysis" : {
    "resource" : "http://identifier/for/analysis/document"
  },
  "notes" : [ { /*...*/ }, { /*...*/ } ],
  "confidence" : "http://gedcomx.org/High"
  "attribution" : { /*...*/ }

  //...possibility of extension elements...

}
```

<a name="subject"/>

## 3.11 The "Subject" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
extracted | Whether this subject is to be constrained as an [_extracted conclusion_](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#4-extracted-conclusion-constraints). | extracted | boolean
evidence | References to other subjects that support this subject. | evidence | array of [`EvidenceReference`](#evidence-reference)
media | References to multimedia resources for this subject, such as photos or videos. | media | array of [`SourceReference`](#source-reference)
identifiers | Identifiers for this subject. | identifiers | [`Identifier`](#identifier-type)

### examples

```javascript
{

  //...the members of [Conclusion](#conclusion)...,

  "extracted" : false,
  "evidence" : [ { /*...*/ }, { /*...*/ } ],
  "media" : [ { /*...*/ }, { /*...*/ } ],
  "identifiers" : { /*...*/ }
}
```

<a name="gender-conclusion"/>

## 3.12 The "Gender" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Gender`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#gender)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the gender. | type | [`URI`](#uri)

### examples

```javascript
{

  //...the members of [Conclusion](#conclusion)...,

  "type" : "http://gedcomx.org/Male"
}
```

<a name="name-conclusion"/>

## 3.13 The "Name" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Name`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name-conclusion)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the name type. | type | [`URI`](#uri)
date | The date of applicability of the name. | date | [`Date`](#conclusion-date)
nameForms | The name form(s) that best represents this name; representations of the same name&mdash;__*not*__ name variants (i.e., not nicknames or spelling variations). | nameForms | array of [`NameForm`](#name-form)

### examples

```javascript
{

  ...the members of [Conclusion](#conclusion)...,

  "type" : "http://gedcomx.org/BirthName",
  "date" : { /*...*/ },
  "nameForms" : [ { /*...*/ }, { /*...*/ } ]
}
```

<a name="fact-conclusion"/>

## 3.14 The "Fact" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Fact`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#3-fact-conclusion)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the fact. | type | [`URI`](#uri)
date | The date of applicability of the fact. | date | [`Date`](#conclusion-date)
place | The place of applicability of the fact. | place | [`PlaceReference`](#conclusion-place-reference)
value | The value of the fact. | value | string
qualifiers | Qualifiers to add additional details about the fact. | qualifiers | array of [`Qualifier`](#qualifier)

### examples

```javascript
{

  //...the members of [Conclusion](#conclusion)...,

  "type" : "http://gedcomx.org/Birth",
  "date" : { /*...*/ },
  "place" : { /*...*/ },
  "value" : "...the original value of the fact...",
  "qualifiers" : [ { "name" : "http://gedcomx.org/Age", "value" : "..." } ]
}
```

<a name="conclusion-event-role"/>

## 3.15 The "EventRole" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/EventRole`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#conclusion-event-role)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
person | Reference to the event participant. | person | [`ResourceReference`](#resource-reference)
type | URI identifying the participant's role. | type | [`URI`](#uri)
details | Details about the role of participant in the event. | details | string

### examples

```javascript
{

  //...the members of [Conclusion](#conclusion)...,

  "person" : {
    "resource" : "http://identifier/for/person/1"
  },
  "type" : "http://gedcomx.org/Witness",
  "details" : "..."
}
```

<a name="conclusion-date"/>

## 3.16 The "Date" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Date`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#conclusion-date)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
original | The original value of the date as supplied by the contributor. | original | string
formal | The standardized, formal representation of the date. | formal | [GEDCOM X Date](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md)

### examples

```javascript
{
  "original" : "...the original text...",
  "formal" : "..."

  //...possibility of extension elements...

}
```

<a name="conclusion-place-reference"/>

# 3.17 The "PlaceReference" Data Type

the JSON object used to (de)serialize the [`http://gedcomx.org/v1/PlaceReference`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#conclusion-place-reference)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
original | The original place name text as supplied by the contributor. | original | string.
descriptionRef | A reference to a _description_ of this place. | description | [`URI`](#uri)

### examples

```javascript
{
  "original" : "...the original text...",
  "description" : "http://identifier/of/place-description/being/referenced",

  //...possibility of extension elements...

}
```

<a name="name-part"/>

## 3.18 The "NamePart" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/NamePart`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name-part)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the name part. | type | [`URI`](#uri)
value | The term(s) from the name that make up this name part. | value | string
qualifiers | Qualifiers to add additional semantic meaning to the name part. | qualifiers | array of [`Qualifier`](#qualifier)

### examples

```javascript
{
  "type" : "http://gedcomx.org/Surname",
  "value" : "...value of the name part..."
  "qualifiers" : [ { "name" : "http://gedcomx.org/Family" }, { "name" : "http://gedcomx.org/Patronymic" } ]

  //...possibility of extension elements...

}
```

<a name="name-form"/>

## 3.19 The "NameForm" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/NameForm`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name-form)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|---------
lang | The locale identifier for the name form. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
fullText | A full rendering of the name. | fullText | string
parts | Any identified name parts from the name. | parts | array of [`NamePart`](#name-part)

### examples

```javascript
{
  "lang" : "en",
  "fullText" : "...full text of the name form...",
  "parts" : [ { /*...*/ }, { /*...*/ } ]

  //...possibility of extension elements...

}
```
<a name="qualifier"/>

## 3.20 The "Qualifier" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/Qualifier`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#qualifier)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|---------
name | The name of the qualifier. | name | [`URI`](#uri)
value | The value of the qualifier. | value | string

### examples

```javascript
{
  "name" : "http://gedcomx.org/QualifierName",
  "value" : "..."
}
```

<a name="coverage"/>

## 3.21 The "Coverage" Data Type

The `gx:Coverage` JSON type is used to (de)serialize the [`http://gedcomx.org/v1/Coverage`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#user-content-coverage)
data type.

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|---------
spatial | The spatial (i.e., geographic) coverage. | spatial | [`PlaceReference`](#conclusion-place-reference)
temporal | The temporal coverage. | temporal | [`Date`](#conclusion-date)

### examples

```javascript
{
  "spatial" : { /*...*/ },
  "temporal" : { /*...*/ }
}
```

## 3.22 The "GroupRole" Data Type

The JSON object used to (de)serialize the [`http://gedcomx.org/v1/GroupRole`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#conclusion-group-role)
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
person | Reference to the group participant. | person | [`ResourceReference`](#resource-reference)
type | URI identifying the participant's role. | type | [`URI`](#uri)
date | The date of applicability of the role. | date | [`Date`](#conclusion-date)
details | Details about the role of participant in the group. | details | string

### examples

```javascript
{

  //...the members of [Conclusion](#conclusion)...,

  "person" : {
    "resource" : "http://identifier/for/person/1"
  },
  "type" : "...",
  "date" : { /*...*/ },
  "details" : "..."
}
```

<a name="json-specific-data-types"/>

# 4 JSON-Specific Data Types

This section describes a set of data types that are specific to the GEDCOM X JSON media
type, used for the convenience of serialization.

<a name="uri"/>

## 4.1 The URI

URIs are supplied as JSON strings and are interpreted according to
[RFC 3986: Uniform Resource Identifier (URI): Generic Syntax](http://www.ietf.org/rfc/rfc3986.txt).

<a name="resource-reference"/>

## 4.2 The "ResourceReference" Data Type

The `ResourceReference` JSON type is used for properties that reference other resources.
It uses the `resource` member to refer to other resources.

### properties

name | description | JSON member | JSON object type
-----|-------------|-------------|-----------------
resource | The URI to the resource being referenced. | resource | [`URI`](#uri)

### examples

```javascript
{
  "resource" : "http://uri/to/resource/being/referenced"
}
```

<a name="gedcomx-type"/>

## 4.3 The "Gedcomx" Data Type

The `Gedcomx` JSON type is used as a container for a set of GEDCOM X data.

### properties

name | description | JSON member | JSON object type | constraints
-----|-------------|-------------|------------------|------------
id | An identifier for the data set. | id | string | OPTIONAL. If provided, the `id` attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids).
lang | The locale identifier for the data set. | lang | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag | OPTIONAL. If not provided, the locale is determined per [Internationalization Considerations](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#i18n).
attribution | The attribution of this data set. | attribution | [`Attribution`](#attribution) | OPTIONAL.
persons | The list of persons contained in the data set. | persons | array of [`Person`](#person) | OPTIONAL.
relationships | The list of relationships contained in the data set. | relationships | array of [`Relationship`](#relationship) | OPTIONAL.
sourceDescriptions | The list of source descriptions contained in the data set. | sourceDescriptions | array of [`SourceDescription`](#source-description) | OPTIONAL.
agents | The list of agents contained in the data set. | agents | array of [`Agent`](#agent) | OPTIONAL.
events | The list of events contained in the data set. | events | array of [`Event`](#event) | OPTIONAL.
documents | The list of documents contained in the data set. | documents | array of [`Document`](#document) | OPTIONAL.
places | The list of places contained in the data set. | places | array of [`PlaceDescription`](#place-description) | OPTIONAL.
groups | The list of groups contained in the data set. | groups | array of [`Group`](#group) | OPTIONAL.
description | Reference to the description of this data set. | description | [`URI`](#uri) | OPTIONAL. If provided, MUST resolve to an instance of [`SourceDescription`](#source-description).

### examples

```javascript
{
  "id" : "local_id",
  "description" : "...",
  "attribution" : { /*...*/ },
  "persons" : [ { /*...*/ }, { /*...*/ } ],
  "relationships" : [ { /*...*/ }, { /*...*/ }, ],
  "sourceDescriptions" : [ { /*...*/ }, { /*...*/ } ],
  "agents" : [ { /*...*/ } , { /*...*/ } ],
  "events" : [ { /*...*/ } , { /*...*/ } ],
  "documents" : [ { /*...*/ } , { /*...*/ } ],
  "places" : [ { /*...*/ } , { /*...*/ } ],
  "groups" : [ { /*...*/ } , { /*...*/ } ],

  //...possibility of extension elements...

}
```

<a name="gedcomx-object"/>

# 5. The GEDCOM X Object

The body of a document compliant with the GEDCOM X JSON media type MUST be an instance of the
GEDCOM X Object, which is defined by an JSON object of the `Gedcomx` data type.

## Example

The following is an example of the structure of a GEDCOM X JSON Element:

```javascript
{
  "id" : "local_id",
  "attribution" : { /*...*/ },
  "persons" : [ { /*...*/ }, { /*...*/ } ],
  "relationships" : [ { /*...*/ }, { /*...*/ }, ],
  "sourceDescriptions" : [ { /*...*/ }, { /*...*/ } ],
  "agents" : [ { /*...*/ } , { /*...*/ } ],
  "events" : [ { /*...*/ } , { /*...*/ } ],
  "documents" : [ { /*...*/ } , { /*...*/ } ],
  "places" : [ { /*...*/ } , { /*...*/ } ],
  "groups" : [ { /*...*/ } , { /*...*/ } ],

  //...possibility of extension elements...

}
```

<a name="extensibility"/>

# 6. Extensibility

In accordance with the [extensibility provisions](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#extensibility)
of the GEDCOM X Conceptual Model, extensions MAY be provided as JSON members on data types where extensions are not
explicitly prohibited.

<a name="data-type-extensions"/>

## 6.1 Data Type Extensions

New data types MAY be defined as extensions to the GEDCOM X JSON Serialization Format by providing the following:

* A conceptual data type definition as specified by the GEDCOM X Conceptual Model [Section 5.1](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#51-data-type-extensions).
* A JSON member name for each property of the data type.

Specifications that define new data types as GEDCOM X JSON extensions MUST be published and made freely available and
compatible with the terms and constraints that govern the GEDCOM X JSON Serialization Format.

<a name="known-json-extension-members"/>

## 6.2 Known JSON Extension Members

GEDCOM X defines a set of JSON members that are explicitly associated with a data type such that
GEDCOM X JSON parsers MAY interpret the members correctly if they are included as an extension
member in a valid data type as defined by the conceptual model. The following members are
identified:

name | JSON object type
-----|-----------------
persons | array of [`Person`](#person)
relationships | array of [`Relationship`](#relationship)
sourceDescriptions | array of [`SourceDescription`](#source-description)
agents | array of [`Agent`](#agent)
events | array of [`Event`](#event)
documents | array of [`Document`](#document)
placeDescriptions | array of [`PlaceDescription`](#place-description)
attribution | array of [`Attribution`](#attribution)
notes | array of [`Note`](#note)
sourceReferences | array of [`SourceReference`](#source-reference)
genders | array of [`Gender`](#gender-conclusion)
names | array of [`Name`](#name-conclusion)
facts | array of [`Fact`](#fact-conclusion)

<a name="fragment-ids"/>

# 7. Fragment Identifiers

Fragment identifiers are used to identify specific objects (i.e. "fragments") within a JSON document. The GEDCOM X
JSON serialization format specifies the use of the "id" member as the fragment identifier for any object in
a given JSON document. Note that some data types explicitly define an "id" property, but the JSON serialization format
allows the option of an "id" property on _all_ objects for the purpose of identifying fragments of the JSON document.
The values of all fragment identifiers within a single JSON document MUST be unique.

For more information about fragment identifiers, see [RFC 3986, Section 3.5](http://tools.ietf.org/html/rfc3986#section-3.5).
