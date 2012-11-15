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
<person xmlns="http://gedcomx.org/v1/" xmlns:ns2="http://familysearch.org/v1/" id="BBB-BBBB">
    <gender type="http://gedcomx.org/Male"/>
    <name id="789">
        <preferred>true</preferred>
        <nameForm xml:lang="ru-Cyrl">
            <ns2:customMarker userProvided="true"/>
            <fullText>Никола́й Андре́евич Ри́мский-Ко́рсаков</fullText>
            <part type="http://gedcomx.org/Given" value="Никола́й">
                <qualifier resource="http://gedcomx.org/Primary"/>
            </part>
            <part type="http://gedcomx.org/Given" value="Андре́евич">
                <qualifier resource="http://gedcomx.org/Secondary"/>
            </part>
            <part type="http://gedcomx.org/Surname" value="Ри́мский-Ко́рсаков"/>
        </nameForm>
        <nameForm xml:lang="ru-Latn">
            <fullText>Nikolai Andreyevich Rimsky-Korsakov</fullText>
            <part type="http://gedcomx.org/Given" value="Nikolai">
                <qualifier resource="http://gedcomx.org/Primary"/>
            </part>
            <part type="http://gedcomx.org/Given" value="Andreyevich">
                <qualifier resource="http://gedcomx.org/Secondary"/>
            </part>
            <part type="http://gedcomx.org/Surname" value="Rimsky-Korsakov"/>
        </nameForm>
    </name>
    <fact type="http://gedcomx.org/Birth" id="123">
        <date>
            <original>March 18, 1844</original>
            <formal>+1844-03-18</formal>
        </date>
        <place description="#tikhvinDesc1">
            <original>Tikhvin, Leningradskaya Oblast', Russia</original>
        </place>
    </fact>
    <fact type="http://gedcomx.org/Death" id="456">
        <date>
            <original>June 21, 1908</original>
            <formal>+1908-06-21T12:34:56</formal>
        </date>
        <place description="#lugaDesc1">
            <original>Luga, Russia</original>
        </place>
    </fact>
</person>
```

The following example shows the serialization of a relationship between two persons in
XML according to this specification:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<relationship xmlns="http://gedcomx.org/v1/" type="http://gedcomx.org/Couple" id="CCC-CCCC">
    <attribution>
        <contributor resource="https://familysearch.org/platform/contributors/BCD-FGHJ"/>
        <changeMessage>(justification here)</changeMessage>
    </attribution>
    <source>
        <sourceDescription resource="urn:srcDescId"/>
    </source>
    <person1 resource="https://familysearch.org/platform/persons/DDD-DDDD"/>
    <person2 resource="https://familysearch.org/platform/persons/FFF-FFFF"/>
    <fact type="http://gedcomx.org/Marriage" id="123">
        <attribution>
            <contributor resource="https://familysearch.org/platform/contributors/HHH-HHHH"/>
        </attribution>
        <date>
            <original>January 6, 1759</original>
            <formal>+1759-01-06</formal>
        </date>
    </fact>
</relationship>
```


## 1.3 Notational Conventions

This document uses the following namespace prefixes:

prefix | namespace
-------|----------
gx | `http://gedcomx.org/v1/`
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

The `gx:ResourceReference` XML type uses the `resource` XML attribute to refer to other resources.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
resource | The URI to the resource being referenced. | resource (attribute) | [anyURI](#uri)

### examples

```xml
<... resource="http://uri/to/resource/being/referenced"/>
```

<a id="identifier-type"/>

## 2.3 The "Identifier" Data Type

The `gx:Identifier` XML type is used to (de)serialize the `http://gedcomx.org/v1/Identifier`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
value | The value of the identifier. | (child text) | xsd:string
type  | URI identifying the type of the identifier. | type (attribute) | [`URI`](#uri)

### examples

```xml
  <... type="http://gedcomx.org/Primary">value_of_identifier</...>
```

<a id="attribution"/>

## 2.4 The "Attribution" Data Type

The `gx:Attribution` XML type is used to (de)serialize the `http://gedcomx.org/Attribution`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
contributor | Reference to the contributor to whom the attributed data is attributed. | gx:contributor | [`gx:ResourceReference`](#resource-reference)
modified | Timestamp of when the attributed data was contributed. | gx:modified | xsd:dateTime
changeMessage | A statement of why the attributed data is being provided by the contributor. | gx:changeMessage | xsd:string

### examples

```xml
  <...>
    <gx:contributor resource="http://identifier/for/contributor"/>
    <gx:modified>2012-05-29T00:00:00</gx:modified>
    <gx:changeMessage>...change message here...</gx:changeMessage>

    <!-- possibility of extension elements -->

  </...>
```

<a id="note"/>

## 2.5 The "Note" Data Type

The `gx:Note` XML type is used to (de)serialize the `http://gedcomx.org/Note` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the note. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
subject | A subject or title for the note. | gx:subject | xsd:string
text | The text of the note. | gx:text | string
attribution | The attribution of this note. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... xml:lang="en">
    <gx:subject>...subject or title...</gx:subject>
    <gx:text>...text of the note...</gx:text>
    <gx:attribution>
      ...
    </gx:attribution>

    <!-- possibility of extension elements -->

  </...>
```

<a id="text-value"/>

## 2.6 The "TextValue" Data Type

The `gx:TextValue` XML type is used to (de)serialize the `http://gedcomx.org/TextValue`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the text of the note. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
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

The `gx:SourceDescription` XML type is used to (de)serialize the
`http://gedcomx.org/v1/SourceDescription` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | An identifier for the XML element holding the source description data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id (attribute) | xsd:string
citations | The citations for this source. | gx:citation | [`gx:SourceCitation`](#source-citation)
about | A uniform resource identifier (URI) for the resource being described. | about (attribute) | [anyURI](#uri)
mediator | A reference to the entity that mediates access to the described source. | gx:mediator | [`gx:ResourceReference`](#resource-reference)
sources | A list of references to any sources from which this source is derived. | gx:source | [`gx:SourceReference`](#source-reference)
extractedConclusions | A list of references to any conclusions that were extracted from this source, to be analyzed and evaluated atomically within on context of the source. | gx:extractedConclusion | [`gx:ResourceReference`](#resource-reference)
componentOf | A reference to the source that contains this source. | gx:componentOf | [`gx:SourceReference`](#source-reference)
titles | The display names for this source. | gx:title | [`gx:TextValue`](#text-value)
notes | A list of notes about a source | gx:note | [`gx:Note`](#note)
attribution | The attribution of this source. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... id="local_id" about="http://identifier/for/the/source/being/described">
    <gx:citation>
      ...
    </gx:citation>
    ...
    <gx:mediator resource="http://identifier/for/the/mediator/of/source/being/described"/>
    <gx:source>
      ...
    </gx:source>
    ...
    <gx:extractedConclusion resource="http://identifier/for/the/extracted/conclusion"/>
    ...
    <gx:componentOf>
      ...
    </gx:componentOf>
    <gx:title>...the display name for this source...</gx:title>
    ...
    <gx:note>
      ...
    </gx:note>
    ...
    <gx:attribution>
      ...
    </gx:attribution>

    <!-- possibility of extension elements -->

  </...>
```

<a id="source-citation"/>

## 3.2 The "SourceCitation" Data Type

The `gx:SourceCitation` XML type is used to (de)serialize the
`http://gedcomx.org/v1/SourceCitation` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the citation. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
value | A rendering of the full (working) citation as a string. | gx:value | xsd:string
citationTemplate | The identifier of the citation template by which this citation may be interpreted. | gx:citationTemplate | [`gx:ResourceReference`](#resource-reference)
fields | A list of citation fields about a source. | gx:field | [`gx:CitationField`](#citation-field)

### examples

```xml
  <... xml:lang="en">
    <gx:value>...a rendering of the full (working) citation as a string...</gx:value>
    <gx:citationTemplate resource="http://identifier/for/ciation/template"/>
    <gx:field>
      ...
    </gx:field>
    ...
  </...>
```

<a id="citation-field"/>

## 3.3 The "CitationField" Data Type

The `gx:CitationField` XML type is used to (de)serialize the
`http://gedcomx.org/v1/CitationField` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
name | The identifier for the citation detail -- defined by a citation template or a citation template library. | gx:name | [anyURI](#uri)
value | A rendering of the full (working) citation as a string. | gx:value | xsd:string

### examples

```xml
  <... name="...a citation field name...">...a citation field value...</...>
```

<a id="source-reference"/>

## 3.4 The "SourceReference" Data Type

The `gx:SourceReference` XML type is used to (de)serialized the `http://gedcomx.org/v1/SourceReference`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
descriptionRef  | Reference to a _description_ of the source being referenced. | description (attribute) | [`URI`](#uri)
attribution | The attribution of this source reference. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... description="http://identifier/for/description/of/source/being/referenced">
    <gx:attribution>
      ...
    </gx:attribution>

    <!-- possibility of extension elements -->

  </...>
```

# 4. Data Types for Describing Contributors

This section defines XML types for each of the data types specified by the
"Data Types for Describing Contributors" section of the conceptual model specification.

<a id="online-account"/>

## 4.1 The "OnlineAccount" Data Type

The `gx:OnlineAccount` XML type is used to (de)serialize the `http://gedcomx.org/v1/OnlineAccount`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
serviceHomepage  | The home page of the service. | gx:serviceHomepage | [`gx:ResourceReference`](#resource-reference)
accountName | The name, label, or id associating the owner of the account with the account. | gx:accountName | xsd:string

### examples

```xml
  <...>
    <gx:serviceHomepage resource="http://familysearch.org/"/>
    <gx:accountName>...</gx:accountName>
  </...>
```

<a id="address"/>

## 4.2 The "Address" Data Type

The `gx:Address` XML type is used to (de)serialize the `http://gedcomx.org/v1/Address`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
value | A string representation of the value. Used when the address isn't separated into its constituent parts. | gx:value | xsd:string
city | The city. | gx:city | xsd:string
country | The country. | gx:country | xsd:string
postalCode | The postal code. | gx:postalCode | xsd:string
stateOrProvince | The state or province. | gx:stateOrProvince | xsd:string
street | The street. | gx:street | xsd:string
street2 | The street (second line). | gx:street2 | xsd:string
street3 | The street (third line). | gx:street3 | xsd:string
street3 | The street (third line). | gx:street3 | xsd:string

### examples

```xml
  <...>
    <gx:value>...</gx:value>
    <gx:city>...</gx:city>
    <gx:country>...</gx:country>
    <gx:postalCode>...</gx:postalCode>
    <gx:stateOrProvince>...</gx:stateOrProvince>
    <gx:street>...</gx:street>
    <gx:street2>...</gx:street2>
    <gx:street3>...</gx:street3>
  </...>
```

<a id="agent"/>

## 4.3 The "Agent" Data Type

The `gx:Agent` XML type is used to (de)serialize the `http://gedcomx.org/v1/Agent`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | An identifier for the XML element holding the agent data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id (attribute) | xsd:string
identifiers | Identifiers for the agent. | gx:identifier | [`gx:Identifier`](#identifier-type)
names | The names of the person or organization. | gx:name | [`gx:TextValue`](#text-value)
homepage | The homepage of the person or organization. | gx:homepage | [`gx:ResourceReference`](#resource-reference)
openid  | The [openid](http://openid.net/) of the person or organization. | gx:openid | [`gx:ResourceReference`](#resource-reference)
accounts  | The online accounts of the person or organization. | gx:account | [`gx:OnlineAccount`](#online-account)
emails  | The email addresses of the person or organization. | gx:email | [`gx:ResourceReference`](#resource-reference)
phones  | The phones (voice, fax, mobile) of the person or organization. | gx:phone | [`gx:ResourceReference`](#resource-reference)
addresses  | The addresses of the person or organization. | gx:address | [`gx:Address`](#address)

### examples

```xml
  <... id="local_id">
    <gx:name>...</gx:name>
    ...
    <gx:homepage>...</gx:homepage>
    <gx:openid>...</gx:openid>
    <gx:account>
      ...
    </gx:account>
    ...
    <gx:email resource="mailto:someone@gedcomx.org"/>
    ...
    <gx:phone resource="tel:+1-201-555-0123"/>
    ...
    <gx:address>
      ...
    </gx:address>
    ...

    <!-- possibility of extension elements -->

  </...>
```

# 5. Data Types for Describing Conclusions

This section defines XML types for each of the data types specified by the
"Data Types for Describing Conclusions" section of the conceptual model specification.

## 5.1 The "Conclusion" Data Type

The `gx:Conclusion` XML type is used to (de)serialize the `http://gedcomx.org/v1/Conclusion`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | An identifier for the XML element holding the conclusion data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id (attribute) | xsd:string
lang | The locale identifier for the conclusion. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
confidence  | Reference to the confidence level of the contributor of the attributed data. | confidence (attribute) | [`URI`](#uri)
sources | A list of references to the sources of the conclusion. | gx:source | [`gx:SourceReference`](#source-reference)
notes | A list of notes about this conclusion. | gx:note | [`gx:Note`](#note)

### examples

```xml
  <... id="local_id" confidence="http://gedcomx.org/Certainly" xml:lang="en">
    <gx:source>
      ...
    </gx:source>
    ...
    <gx:note>
      ...
    </gx:note>
    ...

    <!-- possibility of extension elements -->

  </...>
```


<a id="document"/>

## 5.2 The "Document" Data Type

The `gx:Document` XML type is used to (de)serialize the `http://gedcomx.org/v1/Document` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | The type of the document. | type (attribute) | [`URI`](#uri)
attribution | The attribution of this document. | gx:attribution | [`gx:Attribution`](#attribution)
text | The text of the document. | gx:text | xsd:string

### examples

```xml
  <... xml:lang="en" type="http://gedcomx.org/Analysis">
    <!-- ...the members of gx:Conclusion... -->

    <gx:attribution>
      ...
    </gx:attribution>
    <gx:text>...text of the document...</gx:text>
  </...>
```

<a id="gender-conclusion"/>

## 5.3 The "Gender" Data Type

The `gx:Gender` XML type is used to (de)serialize the `http://gedcomx.org/v1/Gender`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | The gender type. | type (attribute) | [`URI`](#uri)

### examples

```xml
<... id="local_id" type="http://gedcomx.org/Male">

  <!-- ...the members of gx:Conclusion... -->

</...>
```

<a id="name-conclusion"/>

## 5.4 The "Name" Data Type

The `gx:Name` XML type is used to (de)serialize the `http://gedcomx.org/v1/Name`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | The name type. | type (attribute) | [`URI`](#uri)
preferred | Whether this name is preferred above the other `Name` conclusions of a person. | gx:preferred | xsd:boolean
date | The date of applicability of the name. | gx:date | [`gx:Date`](#conclusion-date)
nameForms | The name form(s) that best represents this name `NameForm` -- usually representations considered proper and well formed in the person's native, historical cultural context. All included name forms should be representations of the same name -- __*not*__ name variants (e.g., nicknames, spelling variations). | gx:nameForm | [`gx:NameForm`](#name-form)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/BirthName">

    <!-- ...the members of gx:Conclusion... -->

    <gx:preferred>true</gx:preferred>
    <gx:date>
      ...
    </gx:date>
    <gx:nameForm>
      ...
    </gx:nameForm>
    ...
  </...>
```

<a id="fact-conclusion"/>

## 5.5 The "Fact" Data Type

The `gx:Fact` XML type is used to (de)serialize the `http://gedcomx.org/v1/Fact`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the fact. | type (attribute) | [`URI`](#uri)
date | The date of applicability of the fact. | gx:date | [`gx:Date`](#conclusion-date)
place | The place of applicability of the fact. | gx:place | [`gx:PlaceReference`](#conclusion-place-reference)
value | The original value of the fact as supplied by the contributor. | gx:value | xsd:string

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Birth">

    <!-- ...the members of gx:Conclusion... -->

    <gx:date>
      ...
    </gx:date>
    <gx:place>
      ...
    </gx:place>
    <gx:original>...original value of the fact...</gx:original>
    <gx:value>
      ...
    </gx:value>
  </...>
```

<a id="person"/>

## 5.6 The "Person" Data Type

The `gx:Person` XML type is used to (de)serialize the `http://gedcomx.org/v1/Person`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
attribution | The attribution of this person. | gx:attribution | [`gx:Attribution`](#attribution)
identifiers | Identifiers for the person. | gx:identifier | [`gx:Identifier`](#identifier-type)
living | Whether the person is considered living. | gx:living | xsd:boolean
gender | The conclusion about the gender of the person. | gx:gender | [`gx:Gender`](#gender)
names | The conclusions about the names of the person. | gx:name | [`gx:Name`](#name-conclusion)
facts | The conclusions about the facts of the life of the person. | gx:fact | [`gx:Fact`](#fact-conclusion)

### examples

```xml
  <... id="local_id">

    <!-- ...the members of gx:Conclusion... -->

    <gx:attribution>
      ...
    </gx:attribution>
    <gx:identifier>
      ...
    </gx:identifier>
    ...
    <gx:living>true</gx:living>
    <gx:gender>
      ...
    </gx:gender>
    <gx:name>
      ...
    </gx:name>
    ...
    <gx:fact>
      ...
    </gx:fact>
    ...
  </...>
```

<a id="relationship"/>

## 5.7 The "Relationship" Data Type

The `gx:Relationship` XML type is used to (de)serialize the `http://gedcomx.org/v1/Relationship`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
attribution | The attribution of this relationship. | gx:attribution | [`gx:Attribution`](#attribution)
type | URI identifying the type of the relationship. | type (attribute) | [`URI`](#uri)
person1 | Reference to the first person in the relationship. | gx:person1 | [`gx:ResourceReference`](#resource-reference)
person2 | Reference to the second person in the relationship. | gx:person2 | [`gx:ResourceReference`](#resource-reference)
facts | The conclusions about the facts of the life of the relationship. | gx:fact | [`gx:Fact`](#fact-conclusion)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Couple">

    <!-- ...the members of gx:Conclusion... -->

    <gx:attribution>
      ...
    </gx:attribution>
    <gx:person1 resource="http://identifier/for/person/1"/>
    <gx:person2 resource="http://identifier/for/person/2"/>
    <gx:fact>
      ...
    </gx:fact>
    ...
  </...>
```

<a id="conclusion-event-role"/>

## 5.8 The "EventRole" Data Type

The `gx:EventRole` XML type is used to (de)serialize the `http://gedcomx.org/v1/EventRole`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
person | Reference to the person playing the role in the event. | gx:person | [`gx:ResourceReference`](#resource-reference)
type | Reference to the role type. | type (attribute) | [`URI`](#uri)
details | Details about the role of the person in the event. | gx:details | xs:string

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Witness">

    <!-- ...the members of gx:Conclusion... -->

    <gx:person resource="http://identifier/for/person/1"/>
    <gx:details>...</gx:details>
  </...>
```

<a id="event"/>

## 5.9 The "Event" Data Type

The `gx:Event` is used to (de)serialize the `http://gedcomx.org/v1/Event`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
attribution | The attribution of this event. | gx:attribution | [`gx:Attribution`](#attribution)
type | URI identifying the type of the event. | type (attribute) | [`URI`](#uri)
date | The date of the event. | gx:date | [`gx:Date`](#conclusion-date)
place | The place the event. | gx:place | [`gx:PlaceReference`](#conclusion-place-reference)
roles | The roles of the persons in the event. | gx:role | [`gx:EventRole`](#conclusion-event-role)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Marriage">

    <!-- ...the members of gx:Conclusion... -->

    <gx:attribution>
      ...
    </gx:attribution>
    <gx:date>
      ...
    </gx:date>
    <gx:place>
      ...
    </gx:place>
    <gx:role>
      ...
    </gx:role>
    ...
  </...>
```


<a id="conclusion-place-description"/>

## 5.10 The "PlaceDescription" Data Type

The `gx:PlaceDescription` is used to (de)serialize the `http://gedcomx.org/v1/PlaceDescription` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
about | A uniform resource identifier (URI) for the place being described. | about (attribute) | [anyURI](#uri)
names | A list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place. | gx:name | [`gx:TextValue`](#text-value)
type | A uniform resource identifier (URI) identifying the type of the place as it is applicable to this description. | type (attribute) | [`URI`](#uri)
temporalDescription | A description of the time period to which this place description is relevant. | gx:temporalDescription | [`gx:Date`](#conclusion-date)
latitude | Degrees north or south of the Equator (0.0 degrees). | gx:latitude | xsd:double
longitude | Angular distance in degrees, relative to the Prime Meridian. | gx:latitude | xsd:double
spatialDescription | A reference to a geospatial description of this place. | gx:spatialDescription | [`gx:ResourceReference`](#resource-reference)
identifiers | A list of known identifiers for this place description (e.g., place authority identifiers). | gx:identifier | [`gx:Identifier`](#identifier-type)
attribution | Attribution metadata for this place description. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... id="local_id" about="http://identifier/of/the/place/being/described" type="http://identifier/for/the/place/type">

    <!-- ...the members of gx:Conclusion... -->

    <gx:name>
      ...
    </gx:name>
    ...
    <gx:temporalDescription>
      ...
    </gx:temporalDescription>
    <gx:latitude>27.9883575</gx:latitude>
    <gx:longitude>86.9252014</gx:longitude>
    <gx:spatialDescription resource="http://uri/for/KML/document"/>
    <gx:identifier>
      ...
    </gx:identifier>
    ...
    <gx:attribution>
      ...
    </gx:attribution>
  </...>
```


<a id="conclusion-place-reference"/>

## 5.11 The "PlaceReference" Data Type

The `gx:PlaceDescription` is used to (de)serialize the `http://gedcomx.org/v1/PlaceReference` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
original | The original place name text as supplied by the contributor. | gx:original | xsd:string
descriptionRef | A reference to a _description_ of this place. | description (attribute) | [`URI`](#uri)

### examples

```xml
  <... description="http://identifier/of/place/description/being/referenced">
    <gx:original>...the original text...</gx:original>

    <!-- possibility of extension elements -->

  </...>
```


<a id="conclusion-date"/>

## 5.12 The "Date" Data Type

The `gx:Date` XML type is used to (de)serialize the `http://gedcomx.org/v1/Date`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
original | The original value of the date as supplied by the contributor. | gx:original | xsd:string
formal | The formal value of the date. | gx:formal | [GEDCOM X Date](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-model-specification.md)

### examples

```xml
  <...>
    <gx:original>...the original text...</gx:original>
    <gx:formal>...</gx:formal>
  </...>
```


<a id="name-part"/>

## 5.13 The "NamePart" Data Type

The `gx:NamePart` XML type is used to (de)serialize the `http://gedcomx.org/v1/NamePart`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the name part. | type (attribute) | [`URI`](#uri)
value | The text of the name part. | value (attribute) | xsd:string
qualifiers | Type qualifiers to further describe the type of the name part. | gx:qualifier | [`gx:ResourceReference`](#resource-reference)

### examples

```xml
  <... type="http://gedcomx.org/Prefix" value="...value of the name part...">
    <qualifier resource="http://gedcomx.org/First"/>
    ...

    <!-- possibility of extension elements -->

  </...>
```

 <a id="name-form"/>

## 5.14 The "NameForm" Data Type

The `NameForm` XML type is used to (de)serialize the `http://gedcomx.org/v1/NameForm`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the name form. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
fullText | The full text of the name form. | gx:fullText | xsd:string
parts | Any identified name parts from the name represented in this instance, ordered in the natural order they would be spoken in the given cultural context. | gx:part | [`gx:NamePart`](#name-part)

### examples

```xml
  <...>
    <gx:locale>...an IETF BCP 47 language tag...</gx:locale>
    <gx:fullText>...full text of the name form...</gx:fullText>
    <gx:part>
      ...
    </gx:part>
    ...

    <!-- possibility of extension elements -->

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
gx:person | [`gx:Person`](#person)
gx:relationship | [`gx:Relationship`](#relationship)
gx:fact | [`gx:Fact`](#fact-conclusion)
gx:name | [`gx:Name`](#name-conclusion)
gx:gender | [`gx:Gender`](#gender-conclusion)
gx:agent| [`gx:Agent`](#agent)
gx:sourceReference | [`gx:SourceReference`](#source-reference)
gx:sourceDescription | [`gx:SourceDescription`](#source-description)
gx:document | [`gx:Document`](#document)


<a id="fragment-ids"/>

7. Fragment Identifiers

Fragment identifiers are used to identify specific elements (i.e. "fragments") within an XML document. The GEDCOM X
XML serialization format specifies the use of the "id" attribute as the fragment identifier for any element in
a given XML document. Note that some data types explicitly define an "id" attribute, but the XML serialization format
allows the option of an "id" attribute on _all_ elements for the purpose of identifying fragments of the XML document.
The values of all fragment identifiers within a single XML document MUST be unique.

For more information about fragment identifiers, see [RFC 3986, Section 3.5](http://tools.ietf.org/html/rfc3986#section-3.5).

# 8. Miscellaneous To Do

todo: provide the normative XML schema (inline)?
