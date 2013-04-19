# The GEDCOM X XML Serialization Format

## Status

This document specifies an XML media type for the [GEDCOM X standard conceptual
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
[XML](http://www.w3.org/TR/REC-xml/).

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/xml/v1`

For convenience, the GEDCOM X XML Format may be referred to as "GEDCOM X XML 1.0".

The media type defined by this specification is:

`application/x-gedcomx-v1+xml`

This specification is depends on the conceptual model specification identified
by [`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).

## 1.2 Examples

The following example shows an instance of a GEDCOM X serialization in accordance with this specification:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<gedcomx xmlns="http://gedcomx.org/v1/">
    <attribution>
        <contributor resource="#GGG-GGGG"/>
    </attribution>
    <person id="BBB-BBBB">
        <source description="#EEE-EEEE"/>
        <gender type="http://gedcomx.org/Male"/>
        <name id="789">
            <preferred>true</preferred>
            <nameForm>
                <fullText>George Washington</fullText>
                <part type="http://gedcomx.org/Given" value="George"/>
                <part type="http://gedcomx.org/Surname" value="Washington"/>
            </nameForm>
        </name>
        <fact type="http://gedcomx.org/Birth" id="123">
            <date>
                <original>February 22, 1732</original>
                <formal>+1732-02-22</formal>
            </date>
            <place description="#888">
                <original>pope's creek, westmoreland, virginia, united states</original>
            </place>
        </fact>
        <fact type="http://gedcomx.org/Death" id="456">
            <date>
                <original>December 14, 1799</original>
                <formal>+1799-12-14T22:00:00</formal>
            </date>
            <place description="#999">
                <original>mount vernon, fairfax county, virginia, united states</original>
            </place>
        </fact>
    </person>
    <person id="CCC-CCCC">
        <source description="#FFF-FFFF"/>
        <gender type="http://gedcomx.org/Male"/>
        <name id="987">
            <preferred>true</preferred>
            <nameForm>
                <fullText>Martha Dandridge Custis</fullText>
                <part type="http://gedcomx.org/Given" value="Martha Dandridge"/>
                <part type="http://gedcomx.org/Surname" value="Custis"/>
            </nameForm>
        </name>
        <fact type="http://gedcomx.org/Birth" id="321">
            <date>
                <original>June 2, 1731</original>
                <formal>+1731-06-02</formal>
            </date>
            <place description="#KKK">
                <original>chestnut grove, new kent, virginia, united states</original>
            </place>
        </fact>
        <fact type="http://gedcomx.org/Death" id="654">
            <date>
                <original>May 22, 1802</original>
                <formal>+1802-05-22</formal>
            </date>
            <place description="#999">
                <original>mount vernon, fairfax county, virginia, united states</original>
            </place>
        </fact>
    </person>
    <relationship id="DDD-DDDD">
        <source description="#FFF-FFFF"/>
        <person1 resource="#BBB-BBBB"/>
        <person2 resource="#CCC-CCCC"/>
        <fact>
            <date>
                <original>January 6, 1759</original>
                <formal>+01-06-1759</formal>
            </date>
            <place>
                <original>White House Plantation</original>
            </place>
        </fact>
    </relationship>
    <sourceDescription about="http://en.wikipedia.org/wiki/George_washington" id="EEE-EEEE">
        <citation>
            <value>&quot;George Washington.&quot; Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012.</value>
        </citation>
    </sourceDescription>
    <sourceDescription about="http://en.wikipedia.org/wiki/Martha_washington" id="FFF-FFFF">
        <citation>
            <value>&quot;Martha Washington.&quot; Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012.</value>
        </citation>
    </sourceDescription>
    <agent id="GGG-GGGG">
        <name>Ryan Heaton</name>
    </agent>
    <place id="888">
        <name>Pope's Creek, Westmoreland, Virginia, United States</name>
        <latitude>38.192353</latitude>
        <longitude>-76.904069</longitude>
    </place>
    <place id="999">
        <name>Mount Vernon, Fairfax County, Virginia, United States</name>
        <latitude>38.721144</latitude>
        <longitude>-77.109461</longitude>
    </place>
    <place id="KKK">
        <name>Chestnut Grove, New Kent, Virginia, United States</name>
        <latitude>37.518304</latitude>
        <longitude>-76.984148</longitude>
    </place>
</gedcomx>
```


## 1.3 Notational Conventions

### 1.3.1 Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

### 1.3.2 Namespace Prefixes

This document uses the following namespace prefixes:

prefix | namespace
-------|----------
gx | `http://gedcomx.org/v1/`
xsd | `http://www.w3.org/2001/XMLSchema`

For each data type specified by the GEDCOM X conceptual model, an
associated [XML schema](http://www.w3.org/TR/xmlschema-0/) type is
supplied, which specifies how each of the properties of the data
type are to be serialized in XML. The properties of each data type
are serialized as either an XML attribute or as an XML child element
of the containing XML element.

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

This section specifies XML types for each top-level data type defined by the
conceptual model specification.

<a id="person"/>

## 2.1 The "Person" Data Type

The `gx:Person` XML type is used to (de)serialize the `http://gedcomx.org/v1/Person`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
attribution | The attribution of this person. | gx:attribution | [`gx:Attribution`](#attribution)
identifiers | Identifiers for the person. | gx:identifier | [`gx:Identifier`](#identifier-type)
extracted | Whether the person is to be constrained as an *extracted conclusion*. | extracted (attribute) | xsd:boolean
living | Whether the person is considered living. | gx:living | xsd:boolean
gender | The conclusion about the gender of the person. | gx:gender | [`gx:Gender`](#gender)
names | The conclusions about the names of the person. | gx:name | [`gx:Name`](#name-conclusion)
facts | The conclusions about the facts of the life of the person. | gx:fact | [`gx:Fact`](#fact-conclusion)
media | References to multimedia resources for this person, such as photos or videos. | gx:media | [`gx:SourceReference`](#source-reference)

### examples

```xml
  <... id="local_id" extracted="false">

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
    <gx:media>
      ...
    </gx:media>
    ...
  </...>
```

<a id="relationship"/>

## 2.2 The "Relationship" Data Type

The `gx:Relationship` XML type is used to (de)serialize the `http://gedcomx.org/v1/Relationship`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
attribution | The attribution of this relationship. | gx:attribution | [`gx:Attribution`](#attribution)
type | URI identifying the type of the relationship. | type (attribute) | [`URI`](#uri)
extracted | Whether the relationship is to be constrained as an *extracted conclusion*. | extracted (attribute) | xsd:boolean
person1 | Reference to the first person in the relationship. | gx:person1 | [`gx:ResourceReference`](#resource-reference)
person2 | Reference to the second person in the relationship. | gx:person2 | [`gx:ResourceReference`](#resource-reference)
facts | The conclusions about the facts of the life of the relationship. | gx:fact | [`gx:Fact`](#fact-conclusion)
identifiers | Identifiers for the relationship. | gx:identifier | [`gx:Identifier`](#identifier-type)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Couple" extracted="false">

    <!-- ...the members of gx:Conclusion... -->

    <gx:attribution>
      ...
    </gx:attribution>
    <gx:person1 resource="(uri reference to person 1)"/>
    <gx:person2 resource="(uri reference to person 2)"/>
    <gx:fact>
      ...
    </gx:fact>
    ...
  </...>
```

<a id="source-description"/>

## 2.3 The "SourceDescription" Data Type

The `gx:SourceDescription` XML type is used to (de)serialize the
`http://gedcomx.org/v1/SourceDescription` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | An identifier for the XML element holding the source description data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id (attribute) | xsd:string
citations | The citations for this source. | gx:citation | [`gx:SourceCitation`](#source-citation)
mediaType | A hint about the media type of the resource being described. | mediaType (attribute) | xsd:string
about | A uniform resource identifier (URI) for the resource being described. | about (attribute) | [anyURI](#uri)
mediator | A reference to the entity that mediates access to the described source. | gx:mediator | [`gx:ResourceReference`](#resource-reference)
sources | A list of references to any sources from which this source is derived. | gx:source | [`gx:SourceReference`](#source-reference)
componentOf | A reference to the source that contains this source. | gx:componentOf | [`gx:SourceReference`](#source-reference)
titles | The display names for this source. | gx:title | [`gx:TextValue`](#text-value)
notes | A list of notes about a source | gx:note | [`gx:Note`](#note)
attribution | The attribution of this source. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... id="local_id" about="(uri reference to the source)" mediaType="...">
    <gx:citation>
      ...
    </gx:citation>
    ...
    <gx:mediator resource="(uri reference to the mediator)"/>
    <gx:source>
      ...
    </gx:source>
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

<a id="agent"/>

## 2.4 The "Agent" Data Type

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

<a id="event"/>

## 2.5 The "Event" Data Type

The `gx:Event` is used to (de)serialize the `http://gedcomx.org/v1/Event`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
attribution | The attribution of this event. | gx:attribution | [`gx:Attribution`](#attribution)
type | URI identifying the type of the event. | type (attribute) | [`URI`](#uri)
extracted | Whether the event is to be constrained as an *extracted conclusion*. | extracted (attribute) | xsd:boolean
date | The date of the event. | gx:date | [`gx:Date`](#conclusion-date)
place | The place the event. | gx:place | [`gx:Place`](#conclusion-place)
roles | The roles of the persons in the event. | gx:role | [`gx:EventRole`](#conclusion-event-role)
media | References to multimedia resources for this event, such as photos or videos. | gx:media | [`gx:SourceReference`](#source-reference)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Marriage" extracted="false">

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
    <gx:media>
      ...
    </gx:media>
    ...
  </...>
```

<a id="document"/>

## 2.6 The "Document" Data Type

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

## 2.7 The "PlaceDescription" Data Type

The `gx:PlaceDescription` is used to (de)serialize the `http://gedcomx.org/v1/PlaceDescription` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
names | A list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place. | gx:name | [`gx:TextValue`](#text-value)
type | A uniform resource identifier (URI) identifying the type of the place as it is applicable to this description. | type (attribute) | [`URI`](#uri)
extracted | Whether the place description is to be constrained as an *extracted conclusion*. | extracted (attribute) | xsd:boolean
temporalDescription | A description of the time period to which this place description is relevant. | gx:temporalDescription | [`gx:Date`](#conclusion-date)
latitude | Degrees north or south of the Equator (0.0 degrees). | gx:latitude | xsd:double
longitude | Angular distance in degrees, relative to the Prime Meridian. | gx:latitude | xsd:double
spatialDescription | A reference to a geospatial description of this place. | gx:spatialDescription | [`gx:ResourceReference`](#resource-reference)
identifiers | A list of known identifiers for this place description (e.g., place authority identifiers). | gx:identifier | [`gx:Identifier`](#identifier-type)
media | References to multimedia resources for this place, such as photos or videos. | gx:media | [`gx:SourceReference`](#source-reference)
attribution | Attribution metadata for this place description. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... id="local_id" about="http://identifier/of/the/place/being/described" type="http://identifier/for/the/place/type" extracted="false">

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
    <gx:media>
      ...
    </gx:media>
    ...
    <gx:attribution>
      ...
    </gx:attribution>
  </...>
```

# 3. Component-Level Data Types

This section specifies XML types for each component-level data type defined by the
conceptual model specification.


<a id="identifier-type"/>

## 3.1 The "Identifier" Data Type

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

## 3.2 The "Attribution" Data Type

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

## 3.3 The "Note" Data Type

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

## 3.4 The "TextValue" Data Type

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

<a id="source-citation"/>

## 3.5 The "SourceCitation" Data Type

The `gx:SourceCitation` XML type is used to (de)serialize the
`http://gedcomx.org/v1/SourceCitation` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the citation. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
value | A rendering of the full (working) citation as a string. | gx:value | xsd:string

### examples

```xml
  <... xml:lang="en">
    <gx:value>...a rendering of the full (working) citation as a string...</gx:value>
    ...
  </...>
```

<a id="source-reference"/>

## 3.6 The "SourceReference" Data Type

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

<a id="evidence-reference"/>

## 3.7 The "EvidenceReference" Data Type

The `gx:EvidenceReference` XML type is used to (de)serialized the `http://gedcomx.org/v1/EvidenceReference`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
resource  | Reference to data being used as _evidence_. | description (attribute) | [`URI`](#uri)
analysis  | Reference to a document containing analysis that supports the use of the referenced data as _evidence_. | gx:analysis | [`URI`](#uri)
attribution | The attribution of this _evidence_ reference. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... resource="http://identifier/for/data/being/referenced">
    <gx:analysis resource="http://identifier/for/analysis/document"/>
    <gx:attribution>
      ...
    </gx:attribution>

    <!-- possibility of extension elements -->

  </...>
```

<a id="online-account"/>

## 3.8 The "OnlineAccount" Data Type

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

## 3.9 The "Address" Data Type

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
street4 | The street (fourth line). | gx:street4 | xsd:string
street5 | The street (fifth line). | gx:street5 | xsd:string
street6 | The street (sixth line). | gx:street6 | xsd:string

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
    <gx:street4>...</gx:street4>
    <gx:street5>...</gx:street5>
    <gx:street6>...</gx:street6>
  </...>
```

## 3.10 The "Conclusion" Data Type

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
  <... id="local_id" confidence="http://gedcomx.org/High" xml:lang="en">
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


<a id="gender-conclusion"/>

## 3.11 The "Gender" Data Type

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

## 3.12 The "Name" Data Type

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

## 3.13 The "Fact" Data Type

The `gx:Fact` XML type is used to (de)serialize the `http://gedcomx.org/v1/Fact`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the fact. | type (attribute) | [`URI`](#uri)
date | The date of applicability of the fact. | gx:date | [`gx:Date`](#conclusion-date)
place | The place of applicability of the fact. | gx:place | [`gx:PlaceReference`](#conclusion-place-reference)
value | The original value of the fact as supplied by the contributor. | gx:value | xsd:string
qualifiers | Qualifiers to add additional details about the fact. | gx:qualifier | [`gx:Qualifier`](#qualifier)

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
    <gx:qualifier name="http://gedcomx.org/Age">...</gx:qualifier>
    ...
  </...>
```

<a id="conclusion-event-role"/>

## 3.14 The "EventRole" Data Type

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

<a id="conclusion-date"/>

## 3.15 The "Date" Data Type

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

<a id="conclusion-place-reference"/>

## 3.16 The "PlaceReference" Data Type

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


<a id="name-part"/>

## 3.17 The "NamePart" Data Type

The `gx:NamePart` XML type is used to (de)serialize the `http://gedcomx.org/v1/NamePart`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the name part. | type (attribute) | [`URI`](#uri)
value | The text of the name part. | value (attribute) | xsd:string
qualifiers | Qualifiers to add additional semantic meaning to the name part. | gx:qualifier | [`gx:Qualifier`](#qualifier)

### examples

```xml
  <... type="http://gedcomx.org/Prefix" value="...value of the name part...">
    <qualifier name="http://gedcomx.org/First"/>
    ...

    <!-- possibility of extension elements -->

  </...>
```

 <a id="name-form"/>

## 3.18 The "NameForm" Data Type

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

<a id="qualifier"/>

## 3.19 The "Qualifier" Data Type

The `Qualifier` XML type is used to (de)serialize the `http://gedcomx.org/v1/Qualifier`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
name | The name of the qualifier, used to determine the nature of the qualifier. | name (attribute) | [anyURI](#uri)
value | The value of the qualifier. The semantic meaning of the value is determined by the qualifier name. | (child text) | xsd:string

### examples

```xml
  <... name="http://gedcomx.org/QualifierName">...qualifier value...</...>
```

# 4 XML-Specific Data Types

This section describes a set of data types that are specific to the GEDCOM X XML media
type, used for the convenience of serialization.

<a id="uri"/>

## 4.1 The URI

The [`xsd:anyURI`](http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#anyURI)
XML type defined by the XML schema specification will be used to (de)serialize the URI.

<a id="resource-reference"/>

## 4.2 The "ResourceReference" Data Type

The `gx:ResourceReference` XML type is used for properties that reference other resources.
It uses the `resource` XML attribute to refer to other resources.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
resource | The URI to the resource being referenced. | resource (attribute) | [anyURI](#uri)

### examples

```xml
<... resource="http://uri/to/resource/being/referenced"/>
```

## 4.3 The "Gedcomx" Data Type

The `gx:Gedcomx` XML type is used as a container for a set of GEDCOM X data.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | An identifier for the data set. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id (attribute) | xsd:string
lang | The locale identifier for the data set. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
attribution | The attribution of this data set. | gx:attribution | [`gx:Attribution`](#attribution)
persons | The list of persons contained in the data set. | gx:person | [`gx:Person`](#person)
relationships | The list of relationships contained in the data set. | gx:relationship | [`gx:Relationship`](#relationship)
sourceDescriptions | The list of source descriptions contained in the data set. | gx:sourceDescription | [`gx:SourceDescription`](#source-description)
agents | The list of agents contained in the data set. | gx:agent | [`gx:Agent`](#agent)
events | The list of events contained in the data set. | gx:event | [`gx:Event`](#event)
documents | The list of documents contained in the data set. | gx:document | [`gx:Document`](#document)

### examples

```xml
<... id="local_id" lang="en">
  <gx:attribution>...</gx:attribution>
  <gx:person>...</gx:person>
  <gx:person>...</gx:person>
  ...
  <gx:relationship>...</gx:relationship>
  <gx:relationship>...</gx:relationship>
  ...
  <gx:sourceDescription>...</gx:sourceDescription>
  <gx:sourceDescription>...</gx:sourceDescription>
  ...
  <gx:agent>...</gx:agent>
  <gx:agent>...</gx:agent>
  ...
  <gx:event>...</gx:event>
  <gx:event>...</gx:event>
  ...
  <gx:document>...</gx:document>
  <gx:document>...</gx:document>
  ...

  <!-- possibility of extension elements -->
</...>
```

# 5. The GEDCOM X Element

The body of a document compliant with the GEDCOM X XML media type MUST be an instance of the
root GEDCOM X Element, which is defined by an XML [QName](http://www.w3.org/TR/REC-xml-names/#NT-QName)
and an XML data types, as follows:

## 5.1 GEDCOM X Element QName

The QName of a GEDCOM X element is defined by a `LocalPart` of the value `gedcomx` and the `NamespaceURI`
of the value `http://gedcomx.org/v1/`.

## 5.2 GEDCOM X Element Data Type

The data type of the GEDCOM X element is the `gx:Gedcomx` XML type.

## Example

The following is an example of the structure of a GEDCOM X XML Element:

```xml
<gedcomx xmlns="http://gedcomx.org/v1/">

  <attribution>...</attribution>

  <person>...</person>
  <person>...</person>
  ...

  <relationship>...</relationship>
  <relationship>...</relationship>
  ...

  <sourceDescription>...</sourceDescription>
  <sourceDescription>...</sourceDescription>
  ...

  <agent>...</agent>
  <agent>...</agent>
  ...

  <event>...</event>
  <event>...</event>
  ...

  <document>...</document>
  <document>...</document>
  ...

  <!-- possibility of extension elements -->
</gedcomx>
```

# 6. XML Extension Elements

GEDCOM X defines a set of elements that are explicitly associated with a data type such that
GEDCOM X XML parsers MAY interpret the elements correctly if they are included as an extension
element in a valid data type as defined by the conceptual model. The following elements are
identified:

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
gx:event | [`gx:Event`](#event)
gx:document | [`gx:Document`](#document)
gx:attribution | [`gx:Attribution`](#attribution)
gx:note | [`gx:Note`](#note)


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
