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

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/xml/v1`

For convenience, the GEDCOM X XML Format may be referred to as "GEDCOM X XML 1.0".

This specification is depends on the conceptual model specification identified
by [`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).

## 1.2 Examples

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


## 1.3 Notational Conventions

This document uses the following namespace prefixes:

prefix | namespace
-------|----------
gx | `http://gedcomx.org/`
gxc | `http://gedcomx.org/conclusion/v1/`
gxs | `http://gedcomx.org/source/v1/`
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

The `rdf:ResourceReference` XML type uses the `rdf:resource` XML attribute to refer to other resources,
in conformance to the RDF specification.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
resource | The URI to the resource being referenced. | rdf:resource (attribute) | [anyURI](#uri)

### examples

```xml
<... rdf:resource="http://uri/to/resource/being/referenced"/>
```

<a id="identifier-type"/>

## 2.3 The "Identifier" Data Type

The `gxc:Identifier` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Identifier`
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
modified | Timestamp of when the attributed data was contributed. | gx:modified | xsd:dateTime
confidence  | Reference to the confidence level of the contributor of the attributed data. | gx:confidence | [`rdf#ResourceReference`](#resource-reference)
changeMessage | A statement of why the attributed data is being provided by the contributor. | gx:changeMessage | xsd:string

### examples

```xml
  <...>
    <gx:contributor rdf:resource="http://identifier/for/contributor"/>
    <gx:modified>2012-05-29T00:00:00</gx:modified>
    <gx:confidence rdf:resource="http://gedcomx.org/Certainly"/>
    <gx:changeMessage>...change message here...</gx:changeMessage>
  </...>
```

<a id="formal-value"/>

## 2.5 The "FormalValue" Data Type

The `gxc:FormalValue` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/FormalValue`
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


<a id="note"/>

## 2.6 The "Note" Data Type

The `gx:Note` XML type is used to (de)serialize the `http://gedcomx.org/Note` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
text | The text of the note. | gx:text | [`gx:TextValue`](#text-value)
attribution | The attribution of this note. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <...>
    <gx:text xml:lang="en">...text of the note...</gx:text>
    <gx:attribution>
      ...
    </gx:attribution>
  </...>
```

<a id="literal-value"/>

## 2.7 The "LiteralValue" Data Type

The `gx:LiteralValue` XML type is used to (de)serialize the `http://gedcomx.org/Literal`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The language of the literal value. | xml:lang (attribute) | xml:lang
datatype  | URI identifying the way the value is to be processed according to a specific standard. | rdf:datatype (attribute) | [anyURI](#uri)
value | The literal value. | (child text) | xsd:string

### examples

```xml
  <... xml:lang="en" rdf:datatype="...">...text of the literal value...</...>
```

<a id="text-value"/>

## 2.8 The "TextValue" Data Type

The `gx:TextValue` XML type is used to (de)serialize the `http://gedcomx.org/TextValue`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The language of the text value. | xml:lang (attribute) | xml:lang
value | The text value. | (child text) | xsd:string

### examples

```xml
  <... xml:lang="en">...textual value...</...>
```


# 3. Data Types for Describing Sources

This section defines XML types for each of the data types specified by the
"Data Types for Describing Sources" section of the conceptual model specification.

<a id="source-description"/>

## 3.1 The "SourceDescription" Data Type

The `gxs:SourceDescription` XML type is used to (de)serialize the
`http://gedcomx.org/source/v1/SourceDescription` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | A local, transient identifier for the resource being described. | rdf:ID (attribute) | xsd:string
citation | The bibliographic citation for this source | gxs:citation | [`gxs:SourceCitation`](#source-citation)
about | A uniform resource identifier (URI) for the resource being described. | rdf:about (attribute) | [anyURI](#uri)
mediator | A reference to the entity that mediates access to the described source. | gxs:mediator | [`rdf:ResourceReference`](#resource-reference)
sources | A list of references to sources to which this source is related. This is usually applicable to sources that are derived from or contained in another source. | gxs:source | [`gxs:SourceReference`](#source-reference)
displayName | A display name for this source. | gxs:displayName | xsd:string
alternateNames | A list of alternate display names for this source. | gxs:alternateName | [`gx:LiteralValue`](#literal-value)
notes | A list of notes about a source | gxs:note | [`gx:Note`](#note)
attribution | The attribution of this source. | gxs:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... rdf:ID="local_id" rdf:about="http://identifier/for/the/source/being/described">
    <gxs:citation>
      ...
    </gxs:citation>
    <gxs:mediator rdf:resource="http://identifier/for/the/mediator/of/source/being/described"/>
    <gxs:source>
      ...
    </gxs:source>
    ...
    <gxs:displayName>...the display name for this source...</gxs:displayName>
    <gxs:alternateName>
      ...
    </gxs:alternateName>
    ...
    <gxs:note>
      ...
    </gxs:note>
    ...
    <gxs:attribution>
      ...
    </gxs:attribution>
  </...>
```

<a id="source-citation"/>

## 3.2 The "SourceCitation" Data Type

The `gxs:SourceCitation` XML type is used to (de)serialize the
`http://gedcomx.org/source/v1/SourceCitation` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
value | A rendering of the full (working) citation as a string. | rdf:value | xsd:string
citationTemplate | The identifier of the citation template by which this citation may be interpreted. | gxs:citationTemplate | [`rdf:ResourceReference`](#resource-reference)
fields | A list of citation fields about a source. | gxs:field | [`gx:CitationField`](#citation-field)

### examples

```xml
  <... rdf:ID="local_id" rdf:about="http://identifier/for/the/source/being/described">
    <rdf:value>...a rendering of the full (working) citation as a string...</rdf:value>
    <gxs:citationTemplate rdf:resource="http://identifier/for/ciation/template"/>
    <gxs:field>
      ...
    </gxs:field>
    ...
  </...>
```

<a id="citation-field"/>

## 3.3 The "CitationField" Data Type

The `gxs:CitationField` XML type is used to (de)serialize the
`http://gedcomx.org/source/v1/CitationField` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
name | A rendering of the full (working) citation as a string. | gxs:name | [anyURI](#uri)
value | A rendering of the full (working) citation as a string. | rdf:value | xsd:string

### examples

```xml
  <...>
    <gxs:name>...a citation field name...</gxs:name>
    <rdf:value>...a citation field value...</rdf:value>
  </...>
```

<a id="source-reference"/>

## 3.4 The "SourceReference" Data Type

The `gxs:SourceReference` XML type is used to (de)serialized the `http://gedcomx.org/source/v1/SourceReference`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | A local identifier for the source reference. | rdf:ID (attribute) | xsd:string
type  | Reference to the type of the resource being referenced. | rdf:type | [`rdf:ResourceReference`](#resource-reference)
sourceDescription  | Reference to a _description_ of the source being referenced. | gxs:sourceDescription | [`rdf:ResourceReference`](#resource-reference)
attribution | The attribution of this source reference. | gxs:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... rdf:ID="local_id">
    <rdf:type rdf:resource="http://gedcomx.org/PreservationCopy"/>
    <gxs:sourceDescription rdf:resource="http://identifier/for/description/of/source/being/referenced"/>
    <gxs:attribution>
      ...
    </gxs:attribution>
    <!-- possibility of extension elements -->
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
accountName | The name of the account. | foaf:accountName | [`gx:LiteralValue`](#literal-value)
displayName | A display name for the account. | foaf:displayName | [`gx:LiteralValue`](#literal-value)

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
name | The name of the person or organization. | foaf:name | [`gx:LiteralValue`](#literal-value)
homepage | The homepage of the person or organization. | foaf:homepage | [`gx:LiteralValue`](#literal-value)
openid  | The [openid](http://openid.net/) of the person or organization. | foaf:openid | [`gx:LiteralValue`](#literal-value)
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
    ...
    <foaf:mbox rdf:resource="mailto:someone@gedcomx.org"/>
    ...
    <foaf:phone rdf:resource="tel:+1-201-555-0123"/>
    ...
    <contact:address>
      ...
    </contact:address>
    ...
    <!-- possibility of extension elements -->
    ...
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
familyName | The family name of the person. | foaf:familyName | [`gx:LiteralValue`](#literal-value)
givenName | The given name of the person. | foaf:givenName | [`gx:LiteralValue`](#literal-value)
language | The language of the person. | foaf:language | [`gx:LiteralValue`](#literal-value)

### examples

```xml
  <... rdf:ID="local_id">
    <foaf:familyName>
      ...
    </foaf:familyName>
    <foaf:givenName>
      ...
    </foaf:givenName>
    <foaf:language>
      ...
    </foaf:language>
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
id | A local, transient identifier for the resource being described. | rdf:ID (attribute) | xsd:string
sources | A list of references to the sources of the conclusion. | gxc:source | [`gxs:SourceReference`](#source-reference)
notes | A list of notes about a source | gxc:note | [`gx:Note`](#note)
attribution | The attribution of this source. | gxc:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:source>
      ...
    </gxc:source>
    ...
    <gxc:note>
      ...
    </gxc:note>
    ...
    <gxc:attribution>
      ...
    </gxc:attribution>
    <!-- possibility of extension elements -->
    ...
  </...>
```


<a id="document"/>

## 5.2 The "Document" Data Type

The `gxc:Document` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Document` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
text | The text of the document. | gxc:text | [`gx:TextValue`](#text-value)

### examples

```xml
  <...>
    ...
    <gxc:text xml:lang="en">...text of the document...</gxc:text>
  </...>
```

<a id="abstract-document"/>

## 5.2.1 The "AbstractDocument" Data Type

The `gxc:AbstractDocument` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/AbstractDocument` data type.

### properties

The `gxc:AbstractDocument` data type defines no additional properties beyond those defined by its extended type.

<a id="transcription-document"/>

## 5.2.2 The "TranscriptionDocument" Data Type

The `gxc:TranscriptionDocument` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/TranscriptionDocument` data type.

### properties

The `gxc:TranscriptionDocument` data type defines no additional properties beyond those defined by its extended type.

<a id="translation-document"/>

## 5.2.3 The "TranslationDocument" Data Type

The `gxc:TranslationDocument` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/TranslationDocument` data type.

### properties

The `gxc:TranslationDocument` data type defines no additional properties beyond those defined by its extended type.

<a id="analysis-document"/>

## 5.2.4 The "AnalysisDocument" Data Type

The `gxc:AnalysisDocument` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/AnalysisDocument` data type.

### properties

The `gxc:AnalysisDocument` data type defines no additional properties beyond those defined by its extended type.

<a id="gender-conclusion"/>

## 5.3 The "Gender" Data Type

The `gxc:Gender` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Gender`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | The gender type. | rdf:type | [`rdf:ResourceReference`](#resource-reference)

### examples

```xml
  <... rdf:ID="local_id">
    <rdf:type rdf:resource="http://gedcomx.org/Male"/>
  </...>
```

<a id="name-conclusion"/>

## 5.4 The "Name" Data Type

The `gxc:Name` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Name`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | The name type. | rdf:type | [`rdf:ResourceReference`](#resource-reference)
preferred | Whether this name is preferred above the other names of a person. | gxc:preferred | xsd:boolean
primaryForm | The primary form of the name. | gxc:primaryForm | [`gxc:NameForm`](#name-form)
alternateForms | A list of alternate forms of the name. | gxc:alternateForm | [`gxc:NameForm`](#name-form)

### examples

```xml
  <... rdf:ID="local_id">
    <rdf:type rdf:resource="http://gedcomx.org/BirthName"/>
    <gxc:preferred>true</gxc:preferred>
    <gxc:primaryForm>
      ...
    </gxc:primaryForm>
    <gxc:alternateForm>
      ...
    </gxc:alternateForm>
    ...
  </...>
```

<a id="fact-conclusion"/>

## 5.5 The "Fact" Data Type

The `gxc:Fact` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Fact`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the fact. | rdf:type | [`rdf:ResourceReference`](#resource-reference)
date | The date of applicability of the fact. | gxc:date | [`gxc:Date`](#conclusion-date)
place | The place of applicability of the fact. | gxc:place | [`gxc:Place`](#conclusion-place)
original | The value of the fact as supplied by the contributor. | gxc:original | xsd:string
formal | The formal value of the fact. | gxc:formal | [`gxc:FormalValue`](#formal-value)

### examples

```xml
  <... rdf:ID="local_id">
    <rdf:type rdf:resource="http://gedcomx.org/Birth"/>
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

<a id="person"/>

## 5.6 The "Person" Data Type

The `gxc:Person` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Person`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
identifiers | Identifiers for the person. | gxc:identifier | [`gxc:Identifier`](#identifier-type)
living | Whether the person is considered living. | gxc:living | xsd:boolean
gender | The conclusion about the gender of the person. | gxc:gender | [`gxc:Gender`](#gender)
names | The conclusions about the names of the person. | gxc:name | [`gxc:Name`](#name-conclusion)
facts | The conclusions about the facts of the life of the person. | gxc:fact | [`gxc:Fact`](#fact-conclusion)

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:identifier>
      ...
    </gxc:identifier>
    ...
    <gxc:living>true</gxc:living>
    <gxc:gender>
      ...
    </gxc:gender>
    <gxc:name>
      ...
    </gxc:name>
    ...
    <gxc:fact>
      ...
    </gxc:fact>
    ...
  </...>
```

<a id="relationship"/>

## 5.7 The "Relationship" Data Type

The `gxc:Relationship` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Relationship`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the relationship. | rdf:type | [`rdf:ResourceReference`](#resource-reference)
person1 | Reference to the first person in the relationship. | gxc:person1 | [`rdf:ResourceReference`](#resource-reference)
person2 | Reference to the second person in the relationship. | gxc:person2 | [`rdf:ResourceReference`](#resource-reference)
facts | The conclusions about the facts of the life of the relationship. | gxc:fact | [`gxc:Fact`](#fact-conclusion)

### examples

```xml
  <... rdf:ID="local_id">
    <rdf:type rdf:resource="http://gedcomx.org/Couple"/>
    <gxc:person1 rdf:resource="http://identifier/for/person/1"/>
    <gxc:person2 rdf:resource="http://identifier/for/person/2"/>
    <gxc:fact>
      ...
    </gxc:fact>
    ...
  </...>
```

<a id="conclusion-event-role"/>

## 5.8 The "EventRole" Data Type

The `gxc:EventRole` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/EventRole`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
person | Reference to the person playing the role in the event. | gxc:person | [`rdf:ResourceReference`](#resource-reference)
type | Reference to the role. | rdf:type | [`rdf#ResourceReference`](#resource-reference)
details | Details about the role of the person in the event. | gxc:details | xs:string

### examples

```xml
  <... rdf:ID="local_id">
    <gxc:person rdf:resource="http://identifier/for/person/1"/>
    <rdf:type rdf:resource="http://gedcomx.org/Witness"/>
    <gxc:details>...</gxc:details>
  </...>
```

<a id="event"/>

## 5.9 The "Event" Data Type

The `gxc:Event` is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Event`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the event. | rdf:type | [`rdf:ResourceReference`](#resource-reference)
date | The date of the event. | gxc:date | [`gxc:Date`](#conclusion-date)
place | The place the event. | gxc:place | [`gxc:Place`](#conclusion-place)
roles | The roles of the persons in the event. | gxc:role | [`gxc:EventRole`](#conclusion-event-role)

### examples

```xml
  <... rdf:ID="local_id">
    <rdf:type rdf:resource="http://gedcomx.org/Marriage"/>
    <gxc:date>
      ...
    </gxc:date>
    <gxc:place>
      ...
    </gxc:place>
    <gxc:role>
      ...
    </gxc:role>
    ...
  </...>
```

<a id="conclusion-date"/>

## 5.10 The "Date" Data Type

The `gxc:Date` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Date`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
original | The original value of the date as supplied by the contributor. | gxc:original | xsd:string
formal | The formal value of the date. | gxc:formal | [`gxc:FormalValue`](#formal-value)

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

## 5.11 The "Place" Data Type

The `gxc:Place` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/Place`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
original | The original value of the place as supplied by the contributor. | gxc:original | xsd:string
formal | The formal value of the place. | gxc:formal | [`gxc:FormalValue`](#formal-value)

### examples

```xml
  <...>
    <gxc:original>...the original text...</gxc:original>
    <gxc:formal>
      ...
    </gxc:formal>
  </...>
```

<a id="name-part"/>

## 5.12 The "NamePart" Data Type

The `gxc:NamePart` XML type is used to (de)serialize the `http://gedcomx.org/conclusion/v1/NamePart`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the name part. | rdf:type | [`rdf:ResourceReference`](#resource-reference)
text | The text of the name part. | gxc:text | xsd:string

### examples

```xml
  <...>
    <rdf:type rdf:resource="http://gedcomx.org/Prefix"/>
    <gxc:text>...text of the name piece...</gxc:text>
  </...>
```

 <a id="name-form"/>

## 5.13 The "NameForm" Data Type

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
    ...
  </...>
```



# 6. XML Elements

XML types are not enough to provide an XML serialization format for a data model. XML requires elements to be defined
that can be used as the "root" of an XML document. XML elements are also used to identify any extension properties that
have been added to a data structure.

The XML serialization of the GEDCOM X conceptual model identifies the following XML elements. When
these elements are encountered during processing (either as root elements of a document or as
extension properties), the XML types are identified as follows:

name | XML type
-----|-----------------
gxc:person | [`gxc:Person`](#person)
gxc:relationship | [`gxc:Relationship`](#relationship)
gxc:fact | [`gxc:Fact`](#fact-conclusion)
gxc:name | [`gxc:Name`](#name-conclusion)
gxc:gender | [`gxc:Gender`](#gender-conclusion)
gxs:sourceReference | [`gxs:SourceReference`](#source-reference)
gxs:SourceDescription | [`gxs:SourceDescription`](#rdf-description)
foaf:Person | [`foaf:Person`](#foaf-person)
foaf:Organization | [`foaf:Organization`](#organization)

# 9. Miscellaneous To Do

todo: provide the normative XML schema (inline)?
