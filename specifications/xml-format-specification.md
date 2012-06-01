# The GEDCOM X XML Serialization Format

## Status

This document specifies an XML serialization format for the [GEDCOM X standard conceptual
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

The GEDCOM X XML Serialization Format is a specification that defines the way that
the GEDCOM X conceptual model is serialized to and deserialized from
[XML](http://www.w3.org/TR/REC-xml/).

## 1.1 Examples

The following example shows the serialization of a [person data type](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#person)
in XML according to this specification:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<person xmlns:gx="http://gedcomx.org/" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns="http://gedcomx.org/conclusion/v1/" rdf:ID="BBB-BBBB">
    <gender>
        <rdf:type rdf:resource="http://gedcomx.org/Male"/>
    </gender>
    <name rdf:ID="789">
        <gx:attribution>
            <gx:contributor rdf:resource="https://familysearch.org/platform/contributors/STV-WXZY"/>
        </gx:attribution>
        <preferred>true</preferred>
        <primaryForm>
            <fullText>George Washington</fullText>
            <part>
                <rdf:type rdf:resource="http://gedcomx.org/Given"/>
                <text>George</text>
            </part>
            <part>
                <rdf:type rdf:resource="http://gedcomx.org/Surname"/>
                <text>Washington</text>
            </part>
        </primaryForm>
    </name>
    <fact rdf:ID="123">
        <gx:attribution>
            <gx:contributor rdf:resource="https://familysearch.org/platform/contributors/BCD-FGHJ"/>
        </gx:attribution>
        <rdf:type rdf:resource="http://gedcomx.org/Birth"/>
        <date>
            <original>February 22, 1732</original>
            <formal rdf:datatype="http://www.w3.org/2001/XMLSchema#date">1732-02-22</formal>
        </date>
        <place>
            <original>Pope's Creek, Westmoreland, Virginia</original>
            <formal rdf:resource="https://familysearch.org/platform/places/12345">Pope's Creek, Westmoreland, Virginia</formal>
        </place>
    </fact>
    <fact rdf:ID="456">
        <gx:attribution>
            <gx:contributor rdf:resource="https://familysearch.org/platform/contributors/KLM-NPQR"/>
        </gx:attribution>
        <rdf:type rdf:resource="http://gedcomx.org/Death"/>
        <date>
            <original>December 14, 1799</original>
            <formal rdf:datatype="http://www.w3.org/2001/XMLSchema#dateTime">1799-12-14T22:00:00</formal>
        </date>
        <place>
            <original>Mount Vernon, Virginia</original>
            <formal rdf:resource="https://familysearch.org/platform/places/67890">Mount Vernon, Fairfax County, Virginia</formal>
        </place>
    </fact>
    <source rdf:resource="http://en.wikipedia.org/wiki/George_washington">
        <gx:attribution>
            <gx:contributor rdf:resource="https://familysearch.org/platform/contributors/STV-WXZY"/>
        </gx:attribution>
        <rdf:type rdf:resource="http://purl.org/dc/dcmitype/Text"/>
    </source>
</person>
```

The following example shows the serialization of a relationship between two persons in
XML according to this specification:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<relationship rdf:ID="CCC-CCCC" xmlns:gx="http://gedcomx.org/" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns="http://gedcomx.org/conclusion/v1/">
    <gx:attribution>
        <gx:proofStatement>(proof statement here)</gx:proofStatement>
        <gx:contributor rdf:resource="https://familysearch.org/platform/contributors/BCD-FGHJ"/>
    </gx:attribution>
    <rdf:type rdf:resource="http://gedcomx.org/Couple"/>
    <person1 rdf:resource="https://familysearch.org/platform/persons/DDD-DDDD"/>
    <person2 rdf:resource="https://familysearch.org/platform/persons/FFF-FFFF"/>
    <fact rdf:ID="123">
        <gx:attribution>
            <gx:contributor rdf:resource="https://familysearch.org/platform/contributors/HHH-HHHH"/>
        </gx:attribution>
        <rdf:type rdf:resource="http://gedcomx.org/Marriage"/>
        <date>
            <original>January 6, 1759</original>
            <formal rdf:datatype="http://www.w3.org/2001/XMLSchema#date">1759-01-06</formal>
        </date>
    </fact>
    <source rdf:ID="5678" rdf:resource="http://en.wikipedia.org/wiki/George_washington">
        <rdf:type rdf:resource="http://purl.org/dc/dcmitype/Text"/>
    </source>
</relationship>
```


## 1.2 Notational Conventions

This document uses the following namespace prefixes:

prefix | namespace
-------|----------
gx | `http://gedcomx.org/`
gxc | `http://gedcomx.org/conclusion/v1/`
rdf | `http://www.w3.org/1999/02/22-rdf-syntax-ns#`
dc | `http://purl.org/dc/terms/`
foaf | `http://xmlns.com/foaf/0.1/`
contact | `http://www.w3.org/2000/10/swap/pim/contact#`
xsd | `http://www.w3.org/2001/XMLSchema`

For each data type specified by the GEDCOM X conceptual model, an
associated [XML schema](http://www.w3.org/TR/xmlschema-0/) type is
supplied which specifies how each of the properties of the data
type are to be serialized in XML.

The properties of each data type are serialized as either an XML
attribute or as an XML child element of the containing XML element.
For each data type specified in the GEDCOM X conceptual model, an
associated XML type is supplied by this document that details how
each property is to be serialized.

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14, 
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance 
targets.


# 2. Common Data Types

This section provides XML types for each data type defined under the "Common Data Types"
section of the conceptual model specification.

<a id="uri"/>

## 2.1 The URI

The [`xsd:anyURI`](http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#anyURI)
XML type defined by the XML schema specification will be used to (de)serialize the URI.

<a id="resource-reference"/>

## 2.2 The "ResourceReference" Data Type

The `rdf:ResourceReference` XML type is used to (de)serialize the
`http://www.w3.org/1999/02/22-rdf-syntax-ns#ResourceReference` data type.

References to resources are serialized in XML using the `rdf:resource` XML attribute.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
resource | The URI to the resource being referenced. | rdf:value (attribute) | [anyURI](#uri)

### examples

```xml
<... rdf:resource="http://uri/to/resource/being/referenced"/>
```

<a id="identifier-type"/>

## 2.3 The "Identifier" Data Type

The `gx:Identifier` XML type is used to (de)serialize the `http://gedcomx.org/Identifier`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
value | The value of the identifier. | rdf:value | xsd:string
type  | URI identifying the type of the identifier. | rdf:type | [`rdf:ResourceReference`](#resource-reference)

### examples

```xml
  <...>
    <rdf:value>value_of_identifier</rdf:value>
    <rdf:type rdf:resource="http://gedcomx.org/IdentifierType"/>
  </...>
```

<a id="attribution"/>

## 2.4 The "Attribution" Data Type

The `gx:Attribution` XML type is used to (de)serialize the `http://gedcomx.org/Attribution`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
contributor | Reference to the contributor to whom the attributed data is attributed. | gx:contributor | [`rdf#ResourceReference`](#resource-reference)
confidence  | Reference to the confidence level of the contributor of the attributed data. | gx:confidence | [`rdf#ResourceReference`](#resource-reference)
modified | Timestamp of when the attributed data was contributed. | gx:modified | xsd:dateTime
proofStatement | A statement of proof provided by the contributor of the attributed data | gx:proofStatement | xsd:string

### examples

```xml
  <...>
    <gx:contributor rdf:resource="http://identifier/for/contributor"/>
    <gx:confidence rdf:resource="http://gedcomx.org/Certainly"/>
    <gx:modified>2012-05-29T00:00:00</gx:modified>
    <gx:proofStatement>...proof statement here...</gx:proofStatement>
  </...>
```

<a id="formal-value"/>

## 2.5 The "FormalValue" Data Type

The `gx:FormalValue` XML type is used to (de)serialize the `http://gedcomx.org/FormalValue`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
value | A string supplying the value of the formal value. If the value has been standardized, a datatype will be supplied to identify how the string is to be parsed. | (child text) | xsd:string
datatype  | URI identifying the way the value is to be processed according to a specific standard. | rdf:datatype (attribute) | [anyURI](#uri)
resource | URI identifying the resource to which the formal value has been standardized. | rdf:resource (attribute) | [anyURI](#uri)

### examples

Standardized value with a specified datatype:

```xml
  <... rdf:datatype="http://www.w3.org/2001/XMLSchema#date">1732-02-22</...>
```

Normalized value:

```xml
  <...>...text of the normalized value...</...>
```
Standardized value:

```xml
  <... rdf:resource="http://identifier/for/standardized/value"/>
```

Standardized and normalized value:

```xml
  <... rdf:resource="http://identifier/for/standardized/value">...text of the normalized value...</...>
```

## 2.6 The "GenealogicalResource" Data Type

The `gx:GenealogicalResource` XML type is used to (de)serialize the `http://gedcomx.org/GenealogicalResource`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | A local, transient identifier for the genealogical resource being described. | rdf:ID (attribute) | xsd:string
attribution | The attribution of this resource. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... rdf:ID="some_local_id">
    <gx:attribution>
      ...
    </gx:attribution>
  </...>
```

<a id="note"/>

## 2.7 The "Note" Data Type

The `gx:Note` XML type is used to (de)serialize the `http://gedcomx.org/Note` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The language of the note. | xml:lang (attribute) | xml:lang
text | The text of the note. | gx:text | xsd:string

### examples

```xml
  <... xml:lang="en">
    <gx:text>...text of the note...</gx:text>
  </...>
```

<a id="rdf-literal"/>

## 2.8 The "RDF Literal" Data Type

The `rdfs:Literal` XML type is used to (de)serialize the `http://www.w3.org/2000/01/rdf-schema#Literal`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
value | The literal value. | (child text) | xsd:string
datatype  | URI identifying the way the value is to be processed according to a specific standard. | rdf:datatype (attribute) | [anyURI](#uri)
lang | The language of the literal value. | xml:lang (attribute) | xml:lang

### examples

```xml
  <... xml:lang="en" rdf:datatype="...">...text of the literal value...</...>
```


## 2.9 The "RDF Value" Data Type

The `rdf:Resource` XML type is used to (de)serialize the `http://www.w3.org/2000/01/rdf-schema#Resource`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | A local identifier for the value. | rdf:ID (attribute) | xsd:string
type  | Reference to the type of the value. | rdf:type | [`rdf:ResourceReference`](#resource-reference)
value | The string form of the value. | rdf:value | xsd:string
lang | The language of the string form of the value. | xml:lang (attribute) | xml:lang

### examples

A value that can be specified as a string:

```xml
  <... xml:lang="en" rdf:ID="...">
    <rdf:value>...text of the value...</rdf:value>
  </...>
```

A value that has to be resolved, perhaps because more structure is needed
than a string.

```xml
  <... rdf:resource="http://identifier/for/the/value">
    <rdf:type rdf:resource="http://identifier/for/the/type/of/resource"/>
  </...>
```

# 3. Data Types for Describing Sources

This section defines XML types for each of the data types specified by the
"Data Types for Describing Sources" section of the conceptual model specification.

<a id="rdf-description"/>

## 3.1 The "Description" Data Type

The `rdf:Description` XML type is used to (de)serialize the
`http://www.w3.org/1999/02/22-rdf-syntax-ns#Description` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | A local, transient identifier for the resource being described. | rdf:ID (attribute) | xsd:string
about | A uniform resource identifier (URI) for the resource being described. | rdf:about (attribute) | [anyURI](#uri)
type  | Reference to the type of the resource being described. | rdf:type | [`rdf:ResourceReference`](#resource-reference)

### standard extension properties

As stated by the conceptual model specification, GEDCOM X recognizes the
[Dublin Core Metadata Terms](http://dublincore.org/documents/dcmi-terms/) as standard properties for a
description of a resource. The DCMI terms are supported as elements of an instance of the
rdf:Description XML Type.

### examples

```xml
  <... rdf:ID="local_id" rdf:about="http://identifier/for/the/resource/being/described">
    <rdf:type rdf:resource="http://identifier/for/the/type/of/resource/being/described"/>
    <dc:title>...</dc:title>
    <dc:creator>...</dc:creator>
    ...
  </...>
```

<a id="source-reference"/>

## 3.2 The "SourceReference" Data Type

The `gxc:SourceReference` XML type is used to (de)serialized the `http://gedcomx.org/conclusion/v1/SourceReference`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | A local identifier for the source reference. | rdf:ID (attribute) | xsd:string
type  | Reference to the type of the resource being referenced. | rdf:type | [`rdf:ResourceReference`](#resource-reference)
description  | Reference to a _description_ of the source being referenced. | gx:description | [`rdf:ResourceReference`](#resource-reference)
attribution | The attribution of this source reference. | gx:attribution | [`gx:attribution`](#attribution)

### examples

```xml
  <... rdf:ID="local_id">
    <rdf:type rdf:resource="http://identifier/for/the/type/of/resource/being/referenced"/>
    <gx:description rdf:resource="http://identifier/for/description/of/source/being/referenced"/>
    <gx:attribution>...</gx:attribution>
    ...
  </...>
```

# 4. Data Types for Describing Contributors

This section defines XML types for each of the data types specified by the
"Data Types for Describing Contributors" section of the conceptual model specification.

<a id="online-account"/>

## 4.1 The "OnlineAccount" Data Type

The `foaf:OnlineAccount` XML type is used to (de)serialize the `http://xmlns.com/foaf/0.1/OnlineAccount`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | A local, transient identifier for the online account. | rdf:ID (attribute) | xsd:string
serviceHomepage  | The home page of the service. | foaf:serviceHomepage | [`rdf:ResourceReference`](#resource-reference)
accountName | The name of the account. | foaf:accountName | [`rdfs:Literal`](#rdf-literal)
displayName | A display name for the account. | foaf:displayName | [`rdfs:Literal`](#rdf-literal)

### examples

```xml
  <... rdf:ID="local_id">
    <foaf:serviceHomepage rdf:resource="http://familysearch.org/"/>
    <foaf:accountName>...name of the account...</foaf:accountName>
    <foaf:displayName>...display name of the account...</foaf:displayName>
  </...>
```

<a id="address"/>

## 4.2 The "Address" Data Type

The `contact:Address` XML type is used to (de)serialize the `http://www.w3.org/2000/10/swap/pim/contact#Address`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | A local, transient identifier for the address. | rdf:ID (attribute) | xsd:string
city | The city. | contact:city | xsd:string
country | The country. | contact:country | xsd:string
postalCode | The postal code. | contact:postalCode | xsd:string
stateOrProvince | The state or province. | contact:stateOrProvince | xsd:string
street | The street. | contact:street | xsd:string
street2 | The street (second line). | contact:street2 | xsd:string
street3 | The street (third line). | contact:street3 | xsd:string

### examples

```xml
  <... rdf:ID="local_id">
    <contact:city>...</contact:city>
    <contact:country>...</contact:country>
    <contact:postalCode>...</contact:postalCode>
    <contact:stateOrProvince>...</contact:stateOrProvince>
    <contact:street>...</contact:street>
    <contact:street2>...</contact:street2>
    <contact:street3>...</contact:street3>
  </...>
```

## 4.3 The "Agent" Data Type

The `foaf:Agent` XML type is used to (de)serialize the `http://xmlns.com/foaf/0.1/Agent`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
name | The name of the person or organization. | foaf:name | [`rdfs:Literal`](#rdf-literal)
homepage | The homepage of the person or organization. | foaf:homepage | [`rdfs:Literal`](#rdf-literal)
openid  | The [openid](http://openid.net/) of the person or organization. | foaf:openid | [`rdfs:Literal`](#rdf-literal)
accounts  | The online accounts of the person or organization. | foaf:account | [`foaf:OnlineAccount`](#online-account)
emails  | The email addresses of the person or organization. | foaf:mbox | [`rdf:ResourceReference`](#resource-reference)
phones  | The phones (voice, fax, mobile) of the person or organization. | foaf:phone | [`rdf:ResourceReference`](#resource-reference)
addresses  | The addresses of the person or organization. | contact:address | [`contact:Address`](#address)

### examples

```xml
  <... rdf:ID="local_id">
    <foaf:name>...</foaf:name>
    <foaf:homepage>...</foaf:homepage>
    <foaf:openid>...</foaf:openid>
    <foaf:account>
      ...
    </foaf:account>
    <foaf:account>
      ...
    </foaf:account>
    <foaf:mbox rdf:resource="mailto:someone@gedcomx.org"/>
    <foaf:mbox rdf:resource="mailto:someone@somewhere-else.org"/>
    <foaf:phone rdf:resource="tel:+1-201-555-0123"/>
    <foaf:phone rdf:resource="fax:+1-201-555-5555"/>
    <contact:address>
      ...
    </contact:address>
  </...>
```


<a id="organization"/>

## 4.4 The "Organization" Data Type

The `foaf:Organization` XML type is used to (de)serialize the `http://xmlns.com/foaf/0.1/Organization`
data type.

### properties

The `Organization` data type defines no additional properties beyond those defined by
its extended type.


<a id="foaf-person"/>

## 4.5 The "FOAF Person" Data Type

The `foaf:Person` XML type is used to (de)serialize the `http://xmlns.com/foaf/0.1/Person`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
familyName | The family name of the person. | foaf:familyName | [`rdfs:Literal`](#rdf-literal)
givenName | The given name of the person. | foaf:givenName | [`rdfs:Literal`](#rdf-literal)
language | The language of the person. | foaf:language | [`rdfs:Literal`](#rdf-literal)

### examples

```xml
  <... rdf:ID="local_id">
    <foaf:familyName>...</foaf:familyName>
    <foaf:givenName>...</foaf:givenName>
    <foaf:language>...</foaf:language>
  </...>
```

# 5. Data Types for Describing Conclusions

This section defines XML types for each of the data types specified by the
"Data Types for Describing Conclusions" section of the conceptual model specification.

## 5.1 The "Conclusion" Data Type

The `gxc:Conclusion` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Conclusion`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
sources | The list of references to the sources of the conclusion. | gxc:source | [`gxc:SourceReference`](#source-reference).

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:source rdf:resource="http://identifier/for/the/source"/>
    <gxc:source rdf:resource="http://identifier/for/the/source"/>
    ...
  </...>
```

<a id="conclusion-date"/>

## 5.2 The "Date" Data Type

The `gxc:Date` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Date`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
original | The original value of the date as supplied by the contributor. | gxc:original | xsd:string
formal | The formal value of the date. | gxc:formal | [`gx:FormalValue`](#formal-value)

### examples

```xml
  <...>
    <gxc:original>...the original text...</gxc:original>
    <gxc:formal>
      ...
    </gxc:formal>
  </...>
```

<a id="conclusion-place"/>

## 5.3 The "Place" Data Type

The `gxc:Place` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Place`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
original | The original value of the place as supplied by the contributor. | gxc:original | xsd:string
formal | The formal value of the place. | gxc:formal | [`gx:FormalValue`](#formal-value)

### examples

```xml
  <...>
    <gxc:original>...the original text...</gxc:original>
    <gxc:formal>
      ...
    </gxc:formal>
  </...>
```

<a id="fact-conclusion"/>

## 5.4 The "Fact" Data Type

The `gxc:Fact` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Fact`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the fact. | gxc:type | [`rdf:ResourceReference`](#resource-reference)
date | The date of applicability of the fact. | gxc:date | [`gxc:Date`](#conclusion-date)
place | The place of applicability of the fact. | gxc:place | [`gxc:Place`](#conclusion-place)
original | The value of the fact as supplied by the contributor. | gxc:original | xsd:string
formal | The formal value of the fact. | gxc:formal | [`gxc:FormalValue`](#formal-value)

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:type rdf:resource="http://gedcomx.org/Birth"/>
    <gxc:date>
      ...
    </gxc:date>
    <gxc:place>
      ...
    </gxc:place>
    <gxc:original>...original value of the fact...</gxc:original>
    <gxc:formal>
      ...
    </gxc:formal>
  </...>
```


<a id="gender-conclusion"/>

## 5.5 The "Gender" Data Type

The `gxc:Gender` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Gender`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the gender. | gxc:type | [`rdf:ResourceReference`](#resource-reference)

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:type rdf:resource="http://gedcomx.org/Male"/>
  </...>
```

<a id="name-part"/>

## 5.6 The "NamePart" Data Type

The `gxc:NamePart` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/NamePart`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the name part. | gxc:type | [`rdf:ResourceReference`](#resource-reference)
text | The text of the name part. | gxc:text | xsd:string

### examples

```xml
  <...>
    <gxc:type rdf:resource="http://gedcomx.org/Prefix"/>
    <gxc:text>...text of the name piece...</gxc:text>
  </...>
```

## 5.7 The "NameForm" Data Type

The `NameForm` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/NameForm`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
fullText | The full text of the name form. | gxc:fullText | xsd:string
parts | The parts of the name form. | gxc:part | [`gxc:NamePart`](#name-part)

### examples

```xml
  <...>
    <gxc:fullText>...full text of the name form...</gxc:fullText>
    <gxc:part>
      ...
    </gxc:part>
    <gxc:part>
      ...
    </gxc:part>
    <gxc:part>
      ...
    </gxc:part>
  </...>
```

<a id="name-conclusion"/>

## 5.8 The "Name" Data Type

The `gxc:Name` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Name`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the name. | gxc:type | [`rdf:ResourceReference`](#resource-reference)
primaryForm | The primary form of the name. | gxc:primaryForm | `gxc:NameForm`
alternateForms | The alternate forms of the name. | gxc:alternateForm | `gxc:NameForm`
preferred | Whether this name is preferred above the other names of a person. | gxc:preferred | xsd:boolean

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:type rdf:resource="http://gedcomx.org/BirthName"/>
    <gxc:preferred>true</gxc:preferred>
    <gxc:primaryForm>
      ...
    </gxc:primaryForm>
    <gxc:alternateForm>
      ...
    </gxc:alternateForm>
    <gxc:alternateForm>
      ...
    </gxc:alternateForm>
  </...>
```

<a id="person"/>

# 6. The Person

This section defines the `Person` XML type corresponding to the `Person` data type
specified by the section titled "The Person" of the conceptual model specification.

## 6.1 The "Person" Data Type

The `gxc:Person` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Person`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
identifiers | Identifiers for the person. | gxc:identifier | [`gx:Identifier`](#identifier-type)
living | Whether the person is considered living. | gxc:living | xsd:boolean
gender | The conclusion about the gender of the person. | gxc:gender | [`gxc:Gender`](#gender)
names | The conclusions about the names of the person. | gxc:name | [`gxc:Name`](#name-conclusion)
facts | The conclusions about the facts of the life of the person. | gxc:fact | [`gxc:Fact`](#fact-conclusion)
sources | The list of references to the evidence of the person. | gxc:source | [`gxc:SourceReference`](#source-reference)
notes | Contributed notes about the person. | gxc:note | [`gxc:Note`](#note)

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:identifier>
      ...
    </gxc:identifier>
    <gxc:living>true</gxc:living>
    <gxc:gender>
      ...
    </gxc:gender>
    <gxc:fact>
      ...
    </gxc:fact>
    <gxc:fact>
      ...
    </gxc:fact>
    <gxc:name>
      ...
    </gxc:name>
    <gxc:name>
      ...
    </gxc:name>
    <gxc:source>
      ...
    </gxc:source>
    <gxc:source>
      ...
    </gxc:source>
    <gxc:note>
      ...
    </gxc:note>
    <gxc:note>
      ...
    </gxc:note>
  </...>
```

<a id="relationship"/>

# 7. The Relationship

This section defines the `Relationship` XML type corresponding to the `Relationship` data type
specified by the section titled "The Relationship" of the conceptual model specification.

## 7.1 The "Relationship" Data Type

The `Relationship` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Relationship`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the relationship. | gxc:type | [`rdf:ResourceReference`](#resource-reference)
person1 | Reference to the first person in the relationship. | gxc:person1 | [`rdf:ResourceReference`](#resource-reference)
person2 | Reference to the second person in the relationship. | gxc:person2 | [`rdf:ResourceReference`](#resource-reference)
facts | The conclusions about the facts of the life of the relationship. | gxc:fact | [`gxc:Fact`](#fact-conclusion)
sources | The list of references to the evidence of the relationship. | gxc:source | [`gxc:SourceReference`](#source-reference)
notes | Contributed notes about the relationship. | gxc:note | [`gxc:Note`](#note)

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:type rdf:resource="http://gedcomx.org/Couple"/>
    <gxc:person1 rdf:resource="http://identifier/for/person/1"/>
    <gxc:person2 rdf:resource="http://identifier/for/person/2"/>
    <gxc:fact>
      ...
    </gxc:fact>
    <gxc:fact>
      ...
    </gxc:fact>
    <gxc:name>
      ...
    </gxc:name>
    <gxc:name>
      ...
    </gxc:name>
    <gxc:source>
      ...
    </gxc:source>
    <gxc:source>
      ...
    </gxc:source>
    <gxc:note>
      ...
    </gxc:note>
    <gxc:note>
      ...
    </gxc:note>
  </...>
```

# 8. XML Elements

XML types are not enough to provide an XML serialization format for a data model. XML requires elements to be defined
that can be used as the "root" of an XML document. XML elements are also used to identify any extension properties that
have been added to a data structure.

The XML serialization of the GEDCOM X conceptual model identifies the following XML elements. When
these elements are encountered during processing (either as root elements of a document or as
extension properties), the XML types are identified as follows:

name | XML type
-----|-----------------
gxc:person | [gxc:Person](#person)
gxc:relationship | [gxc:Relationship](#relationship)
gxc:fact | [gxc:Fact](#fact-conclusion)
gxc:name | [gxc:Name](#name-conclusion)
gxc:gender | [gxc:Gender](#gender-conclusion)
gxc:sourceReference | [gxc:SourceReference](#source-reference)
rdf:Description | [rdf:Description](#rdf-description)
foaf:Person | [foaf:Person](#foaf-person)
foaf:Organization | [foaf:Organization](#organization)

# 9. Miscellaneous To Do

todo: provide the normative XML schema (inline)?
