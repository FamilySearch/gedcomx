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
    "primaryForm" : {
      "fullText" : "George Washington",
      "parts" : [ {
        "type" : "http://gedcomx.org/Given",
        "text" : "George"
      }, {
        "type" : "http://gedcomx.org/Surname",
        "text" : "Washington"
      } ]
    },
    "preferred" : true,
    "id" : "789",
    "attribution" : {
      "contributor" : "https://familysearch.org/platform/contributors/STV-WXZY"
    }
  } ],
  "sources" : [ {
    "type" : "http://purl.org/dc/dcmitype/Text",
    "attribution" : {
      "contributor" : "https://familysearch.org/platform/contributors/STV-WXZY"
    },
    "uri" : "http://en.wikipedia.org/wiki/George_washington"
  } ],
  "gender" : {
    "type" : "http://gedcomx.org/Male"
  },
  "facts" : [ {
    "type" : "http://gedcomx.org/Birth",
    "date" : {
      "original" : "February 22, 1732",
      "formal" : {
        "text" : "1732-02-22",
        "datatype" : "http://www.w3.org/2001/XMLSchema#date"
      }
    },
    "place" : {
      "original" : "Pope's Creek, Westmoreland, Virginia",
      "formal" : {
        "resource" : "https://familysearch.org/platform/places/12345",
        "text" : "Pope's Creek, Westmoreland, Virginia"
      }
    },
    "id" : "123",
    "attribution" : {
      "contributor" : "https://familysearch.org/platform/contributors/BCD-FGHJ"
    }
  }, {
    "type" : "http://gedcomx.org/Death",
    "date" : {
      "original" : "December 14, 1799",
      "formal" : {
        "text" : "1799-12-14T22:00:00",
        "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
      }
    },
    "place" : {
      "original" : "Mount Vernon, Virginia",
      "formal" : {
        "resource" : "https://familysearch.org/platform/places/67890",
        "text" : "Mount Vernon, Fairfax County, Virginia"
      }
    },
    "id" : "456",
    "attribution" : {
      "contributor" : "https://familysearch.org/platform/contributors/KLM-NPQR"
    }
  } ],
  "id" : "BBB-BBBB"
}
```

The following example shows the serialization of a relationship between two persons in
JSON according to this specification:

```json
{
  "type" : "http://gedcomx.org/Couple",
  "sources" : [ {
    "type" : "http://purl.org/dc/dcmitype/Text",
    "id" : "5678",
    "resource" : "http://en.wikipedia.org/wiki/George_washington"
  } ],
  "person1" : "https://familysearch.org/platform/persons/DDD-DDDD",
  "person2" : "https://familysearch.org/platform/persons/FFF-FFFF",
  "facts" : [ {
    "type" : "http://gedcomx.org/Marriage",
    "date" : {
      "original" : "January 6, 1759",
      "formal" : {
        "text" : "1759-01-06",
        "datatype" : "http://www.w3.org/2001/XMLSchema#date"
      }
    },
    "id" : "123",
    "attribution" : {
      "contributor" : "https://familysearch.org/platform/contributors/HHH-HHHH"
    }
  } ],
  "id" : "CCC-CCCC",
  "attribution" : {
    "contributor" : "https://familysearch.org/platform/contributors/BCD-FGHJ",
    "proofStatement" : "(proof statement here)"
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

## 1.4 Data Type Identification in JSON Using
Because JSON is not a formally typed data format, a mechanism for
identifying the data type must be specified so that GEDCOM X JSON processors
may identify how to semantically process a JSON object that
appears as either a standalone document or as an extension property.

GEDCOM X specifies that JSON objects MAY supply the identifier
for their data type using theas a standalone document or as an extension property, the JSON object
MUST specify its data type using thethe

# 2. Common Data Types

This section provides JSON object definitions for each data type defined
under the "Common Data Types" section of the conceptual model specification.

<a id="uri"/>

## 2.1 The URI

URIs are supplied as JSON strings.

<a id="identifier-type"/>

## 2.2 The "Identifier" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/Identifier` data type is defined as follows:

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

The JSON object used to (de)serialize the `http://gedcomx.org/Attribution` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
contributor | Reference to the contributor to whom the attributed data is attributed. | contributor | [`URI`](#uri)
confidence  | Reference to the confidence level of the contributor of the attributed data. | confidence | [`URI`](#uri)
modified | Timestamp of when the attributed data was contributed. | modified | number (milliseconds since epoch)
proofStatement | A statement of proof provided by the contributor of the attributed data | proofStatement | string

### examples

```json
{
  "contributor" : "http://identifier/for/contributor",
  "confidence" : "http://gedcomx.org/Certainly",
  "modified" : "1338394969",
  "proofStatement" : "...proof statement here..."
}
```

<a id="formal-value"/>

## 2.4 The "FormalValue" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/FormalValue` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
value | A string supplying the value of the formal value. If the value has been standardized, a datatype will be supplied to identify how the string is to be parsed. | value | string
datatype  | URI identifying the way the value is to be processed according to a specific standard. | datatype | string
resource | URI identifying the resource to which the formal value has been standardized. | resource | string

### examples

Standardized value with a specified datatype:

```json
{
  "datatype" : "http://www.w3.org/2001/XMLSchema#date",
  "value" : "1732-02-22"
}
```

Normalized value:

```json
{
  "value" : "...text of the normalized value..."
}
```
Standardized value:

```json
{
  "resource" : "http://identifier/for/standardized/value"
}
```

Standardized and normalized value:

```json
{
  "resource" : "http://identifier/for/standardized/value",
  "value" : "...text of the normalized value..."
}
```

## 2.5 The "GenealogicalResource" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/GenealogicalResource` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | A local, transient identifier for the genealogical resource being described. | id | string
attribution | The attribution of this resource. | attribution | [`Attribution`](#attribution)

### examples

```json
{
  "id" : "some_local_id",
  "attribution" :  {
    ...
  }
}
```

<a id="note"/>

## 2.6 The "Note" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/Note` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
lang | The language of the note. | lang | string
text | The text of the note. | text | string

### examples

```json
{
  "lang" : "en",
  "text" : "...text of the note..."
}
```

<a id="rdf-literal"/>

## 2.7 The "RDF Literal" Data Type

The JSON object used to (de)serialize the `http://www.w3.org/2000/01/rdf-schema#Literal` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
value | The literal value. | value | string
datatype  | URI identifying the way the value is to be processed according to a specific standard. | datatype | string
lang | The language of the literal value. | lang | string

### examples

```json
{
  "datatype" : "...",
  "lang" : "en",
  "value" : "...text of the literal value..."
}
```


## 2.8 The "RDF Value" Data Type

The JSON object used to (de)serialize the `http://www.w3.org/2000/01/rdf-schema#Resource` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | A local identifier for the value. | id | string
resource | Identifier for the value | resource | [URI](#uri)
type  | Reference to the type of the value. | type | [`URI`](#uri)
value | The string form of the value. | value | string
lang | The language of the string form of the value. | lang | string

### examples

A value that can be specified as a string:

```json
{
  "id" : "...",
  "resource" : "http://identifier/for/the/value",
  "lang" : "en",
  "value" : "...text of the value..."
}
```

A value that has to be resolved, perhaps because more structure is needed
than a string.

```json
{
  "resource" : "http://identifier/for/the/value",
  "type" : "http://identifier/for/the/type/of/resource"
  "value" : "...text of the value..."
}
```

# 3. Data Types for Describing Sources

This section defines JSON types for each of the data types specified by the
"Data Types for Describing Sources" section of the conceptual model specification.

<a id="rdf-description"/>

## 3.1 The "Description" Data Type

The JSON object used to (de)serialize the `http://www.w3.org/1999/02/22-rdf-syntax-ns#Description` 
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | A local, transient identifier for the resource being described. | id | string
about | A uniform resource identifier (URI) for the resource being described. | about | string
type  | Reference to the type of the resource being described. | type | [`URI`](#uri)

### standard extension properties

As stated by the conceptual model specification, GEDCOM X recognizes the
[Dublin Core Metadata Terms](http://dublincore.org/documents/dcmi-terms/) as standard properties for a
description of a resource. The DCMI terms are supported as arrays of members of an instance of the
"Description" JSON object.

### examples

```json
{
  "id" : "local_id",
  "about" : "http://identifier/for/the/resource/being/described",
  "type" : "http://identifier/for/the/type/of/resource/being/described",
  "titles" : [ {...}, {...} ],
  "creators" : [ {...}, {...} ],
  ...
}
```

<a id="source-reference"/>

## 3.2 The "SourceReference" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/SourceReference`
data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | A local identifier for the source reference. | id | string
resource | Identifier for the source being referenced. | uri | [`URI`](#uri)
type  | Reference to the type of the resource being referenced. | type | [`URI`](#uri)
description  | Reference to a _description_ of the source being referenced. | description | [`URI`](#uri)
attribution | The attribution of this source reference. | attribution | [`attribution`](#attribution)

### examples

```json
{
  "id" : "local_id",
  "uri" : "http://identifier/for/the/source/being/referenced",
  "type" : "http://identifier/for/the/type/of/resource/being/referenced",
  "description" : "http://identifier/for/the/description/of/resource/being/referenced",
  "attribution" : { ... }
}
```

# 4. Data Types for Describing Contributors

This section defines JSON types for each of the data types specified by the
"Data Types for Describing Contributors" section of the conceptual model specification.

<a id="online-account"/>

## 4.1 The "OnlineAccount" Data Type

The JSON object used to (de)serialize the `http://xmlns.com/foaf/0.1/OnlineAccount` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | A local, transient identifier for the online account. | id | string
serviceHomepage  | The home page of the service. | serviceHomepage | [`URI`](#uri)
accountName | The name of the account. | accountName | [`Literal`](#rdf-literal)
displayName | A display name for the account. | displayName | [`Literal`](#rdf-literal)

### examples

```json
{
  "id" : "local_id",
  "serviceHomepage" : "http://familysearch.org/",
  "accountName" : {
    "value" : "...name of the account..."
  },
  "displayName" : {
    "value" : "...display name of the account..."
  }
}
```

<a id="address"/>

## 4.2 The "Address" Data Type

The JSON object used to (de)serialize the `http://www.w3.org/2000/10/swap/pim/contact#Address` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
id | A local, transient identifier for the address. | id | string
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
  "id" : "local_id",
  "city" : "...",
  "country" : "...",
  "postalCode" : "...",
  "stateOrProvince" : "...",
  "street" : "...",
  "street2" : "...",
  "street3" : "..."
}
```

## 4.3 The "Agent" Data Type

The JSON object used to (de)serialize the `http://xmlns.com/foaf/0.1/Agent` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
name | The name of the person or organization. | name | [`Literal`](#rdf-literal)
homepage | The homepage of the person or organization. | homepage | [`Literal`](#rdf-literal)
openid  | The [openid](http://openid.net/) of the person or organization. | openid | [`Literal`](#rdf-literal)
accounts  | The online accounts of the person or organization. | accounts | array of [`OnlineAccount`](#online-account)
emails  | The email addresses of the person or organization. | emails | array of [`URI`](#uri)
phones  | The phones (voice, fax, mobile) of the person or organization. | phones | array of [`URI`](#uri)
addresses  | The addresses of the person or organization. | addresses | array of [`Address`](#address)

### examples

```json
{
  "id" : "local_id",
  "name" : {
    "value" : "..."
  },
  "homepage" : {
    "value" : "..."
  },
  "openid" : {
    "value" : "..."
  },
  "accounts" : [ { ... }, { ... } ],
  "emails" : [ "mailto:someone@gedcomx.org" , "mailto:someone@somewhere-else.org" ],
  "phones" : [ "tel:+1-201-555-0123" , "fax:+1-201-555-5555" ],
  "addresses" : [ { ... }, { ... } ]
}
```


<a id="organization"/>

## 4.4 The "Organization" Data Type

The JSON object used to (de)serialize the `http://xmlns.com/foaf/0.1/Organization` data type is defined as follows:

### properties

The `Organization` data type defines no additional properties beyond those defined by
its extended type.


<a id="foaf-person"/>

## 4.5 The "FOAF Person" Data Type

The JSON object used to (de)serialize the `http://xmlns.com/foaf/0.1/Person` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
familyName | The family name of the person. | familyName | [`Literal`](#rdf-literal)
givenName | The given name of the person. | givenName | [`Literal`](#rdf-literal)
language | The language of the person. | language | [`Literal`](#rdf-literal)

### examples

```json
{
  "id" : "local_id",
  "familyName" : {
    "value" : "..."
  },
  "givenName" : {
    "value" : "..."
  },
  "language" : {
    "value" : "..."
  }
}
```

# 5. Data Types for Describing Conclusions

This section defines JSON types for each of the data types specified by the
"Data Types for Describing Conclusions" section of the conceptual model specification.

## 5.1 The "Conclusion" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/Conclusion` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
sources | The list of references to the sources of the conclusion. | sources | array of [`SourceReference`](#source-reference).

### examples

```json
{
  "id" : "local_id",
  "sources" : [ { resource : "http://identifier/for/the/source" }, { resource : "http://identifier/for/the/source" } ]
}
```

<a id="conclusion-date"/>

## 5.2 The "Date" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/Date` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
original | The original value of the date as supplied by the contributor. | original | string
formal | The formal value of the date. | formal | [`FormalValue`](#formal-value)

### examples

```json
{
  "id" : "local_id",
  "original" : "...the original text...",
  "formal" : {
    ...
  }
}
```

<a id="conclusion-place"/>

## 5.3 The "Place" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/Place` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
original | The original value of the place as supplied by the contributor. | original | string
formal | The formal value of the place. | formal | [`FormalValue`](#formal-value)

### examples

```json
{
  "id" : "local_id",
  "original" : "...the original text...",
  "formal" : {
    ...
  }
}
```

<a id="fact-conclusion"/>

## 5.4 The "Fact" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/Fact` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the fact. | type | [`URI`](#uri)
date | The date of applicability of the fact. | date | [`Date`](#conclusion-date)
place | The place of applicability of the fact. | place | [`Place`](#conclusion-place)
original | The value of the fact as supplied by the contributor. | original | string
formal | The formal value of the fact. | formal | [`FormalValue`](#formal-value)

### examples

```json
{
  "id" : "local_id",
  "type" : "http://gedcomx.org/Birth",
  "date" : {
    ...
  },
  "place" : {
    ...
  },
  "original" : "...the original value of the fact...",
  "formal" : {
    ...
  }
}
```


<a id="gender-conclusion"/>

## 5.5 The "Gender" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/Gender` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the gender. | type | [`URI`](#uri)

### examples

```json
{
  "id" : "local_id",
  "type" : "http://gedcomx.org/Male"
}
```

<a id="name-part"/>

## 5.6 The "NamePart" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/NamePart` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the name part. | type | [`URI`](#uri)
text | The text of the name part. | text | string

### examples

```json
{
  "type" : "http://gedcomx.org/Prefix",
  "text" : "...text of the name piece..."
}
```

## 5.7 The "NameForm" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/NameForm` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
fullText | The full text of the name form. | fullText | string
parts | The parts of the name form. | parts | array of [`NamePart`](#name-part)

### examples

```json
{
  "fullText" : "...full text of the name form...",
  "parts" : [ { ... }, { ... } ]
}
```

<a id="name-conclusion"/>

## 5.8 The "Name" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/Name` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the name. | type | [`URI`](#uri)
primaryForm | The primary form of the name. | primaryForm | `NameForm`
alternateForms | The alternate forms of the name. | alternateForms | array of `NameForm`
preferred | Whether this name is preferred above the other names of a person. | preferred | true or false

### examples

```json
{
  "id" : "local_id",
  "type" : "http://gedcomx.org/BirthName",
  "primaryForm" : { ... },
  "alternateForms" : [ { ... }, { ... } ]
}
```

<a id="person"/>

# 6. The Person

This section defines the `Person` JSON type corresponding to the `Person` data type
specified by the section titled "The Person" of the conceptual model specification.

## 6.1 The "Person" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/Person` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
identifiers | Identifiers for the person. | identifiers | array of [`Identifier`](#identifier-type)
living | Whether the person is considered living. | living | true or false
gender | The conclusion about the gender of the person. | gender | [`Gender`](#gender)
names | The conclusions about the names of the person. | names | array of [`Name`](#name-conclusion)
facts | The conclusions about the facts of the life of the person. | facts | array of [`Fact`](#fact-conclusion)
sources | The list of references to the evidence of the person. | sources | array of [`SourceReference`](#source-reference)
notes | Contributed notes about the person. | notes | array of [`Note`](#note)

### examples

```json
{
  "id" : "local_id",
  "identifiers" : [ { ... }, { ... } ],
  "living" : true,
  "gender" : {
    ...
  },
  "names" : [ { ... }, { ... } ]
  "facts" : [ { ... }, { ... } ]
  "sources" : [ { ... }, { ... } ]
  "notes" : [ { ... }, { ... } ]
}
```

<a id="relationship"/>

# 7. The Relationship

This section defines the `Relationship` JSON type corresponding to the `Relationship` data type
specified by the section titled "The Relationship" of the conceptual model specification.

## 7.1 The "Relationship" Data Type

The JSON object used to (de)serialize the `http://gedcomx.org/conclusion/v1/Relationship` data type is defined as follows:

### properties

name | description | JSON member | JSON object type
-----|-------------|--------------|---------
type | URI identifying the type of the relationship. | type | [`URI`](#uri)
person1 | Reference to the first person in the relationship. | person1 | [`URI`](#uri)
person2 | Reference to the second person in the relationship. | person2 | [`URI`](#uri)
facts | The conclusions about the facts of the life of the relationship. | facts | array of [`Fact`](#fact-conclusion)
sources | The list of references to the evidence of the relationship. | sources | array of [`SourceReference`](#source-reference)
notes | Contributed notes about the relationship. | notes | array of [`Note`](#note)

### examples

```json
{
  "id" : "local_id",
  "type" : "http://gedcomx.org/Couple",
  "person1" : "http://identifier/for/person/1",
  "person2" : "http://identifier/for/person/2",
  "facts" : [ { ... }, { ... } ],
  "sources" : [ { ... }, { ... } ],
  "notes" : [ { ... }, { ... } ]
}
```

# 8. Known JSON Extension Members

GEDCOM X defines the notion of extension properties, and the JSON serialization
supports the extensibility requirements detailed in the GEDCOM X conceptual model
specification. When an extension property is provided in a JSON object, the type
of the object can be determined by the value of thesection 1.3 above.

For convenience, GEDCOM X reserves the use of the following member names as
"known" extension members:

name | JSON object type
-----|-----------------
persons | array of [Person](#person)
relationships | array of [Relationship](#relationship)
notes | array of [Note](#note)
facts | array of [Fact](#fact-conclusion)
names | array of [Name](#name-conclusion)
genders | array of [Gender](#gender-conclusion)
sources | array of [SourceReference](#source-reference)
descriptions | array of [Description](#rdf-description)

//todo: include all the dublin core terms as extension members.

# 9. Miscellaneous To Do

todo:
