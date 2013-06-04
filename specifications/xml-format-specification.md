# The GEDCOM X XML Serialization Format

## Status

This document specifies an XML media type for the [GEDCOM X Conceptual
Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md),
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

The GEDCOM X Conceptual Model is a specification of formal concepts and types
that are used to provide a standard model and vocabulary for describing genealogical
data.

The GEDCOM X XML Serialization Format is a specification that defines the media type used
to serialize and deserialize the GEDCOM X Conceptual Model to and from
[XML](http://www.w3.org/TR/REC-xml/).

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/xml/v1`

For convenience, the GEDCOM X XML Format may be referred to as "GEDCOM X XML 1.0".

The media type defined by this specification is:

`application/x-gedcomx-v1+xml`

This specification depends on the GEDCOM X Conceptual Model specification identified
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
            <value>"George Washington." Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012.</value>
        </citation>
    </sourceDescription>
    <sourceDescription about="http://en.wikipedia.org/wiki/Martha_washington" id="FFF-FFFF">
        <citation>
            <value>"Martha Washington." Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012.</value>
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

For each data type specified by the GEDCOM X conceptual model, an associated [XML schema](http://www.w3.org/TR/xmlschema-0/) type is
supplied, which specifies how each of the properties of the data type are to be serialized in XML. The properties of each data type
are serialized as either an XML attribute or as an XML child element of the containing XML element.

## 1.4 Compliance

In addition to the compliance requirements provided by this specification, all compliance requirements provided by the GEDCOM X Conceptual Model identified by
[`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md)
are inherited.


# 2. Top-Level Data Types

This section specifies XML types for each top-level data type defined by the
GEDCOM X Conceptual Model specification.

<a name="person"/>

## 2.1 The "Person" Data Type

The `gx:Person` XML type is used to (de)serialize the `http://gedcomx.org/v1/Person`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
private | Whether this instance of `Person` has been designated for limited distribution or display. | private (attribute) | xs:boolean
gender | The gender of the person. | gx:gender | [`gx:Gender`](#gender)
names | The names of the person. | gx:name | [`gx:Name`](#name-conclusion)
facts | The facts of the person. | gx:fact | [`gx:Fact`](#fact-conclusion)

### examples

```xml
  <... id="local_id" extracted="false" private="false">

    <!-- ...the members of [gx:Subject](#subject)... -->

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

<a name="relationship"/>

## 2.2 The "Relationship" Data Type

The `gx:Relationship` XML type is used to (de)serialize the `http://gedcomx.org/v1/Relationship`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the relationship. | type (attribute) | [`URI`](#uri)
person1 | Reference to the first person in the relationship. | gx:person1 | [`gx:ResourceReference`](#resource-reference)
person2 | Reference to the second person in the relationship. | gx:person2 | [`gx:ResourceReference`](#resource-reference)
facts | The facts about the relationship. | gx:fact | [`gx:Fact`](#fact-conclusion)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Couple" extracted="false">

    <!-- ...the members of [gx:Subject](#subject)... -->

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

<a name="source-description"/>

## 2.3 The "SourceDescription" Data Type

The `gx:SourceDescription` XML type is used to (de)serialize the
`http://gedcomx.org/v1/SourceDescription` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | The identifier for the XML element holding the source description data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id (attribute) | xsd:string
resourceType | URI identifying the type of resource being described. | resourceType (attribute) | [anyURI](#uri)
citations | The citation(s) for this source. | gx:citation | [`gx:SourceCitation`](#source-citation)
mediaType | A hint about the media type of the resource being described. | mediaType (attribute) | xsd:string
about | A uniform resource identifier (URI) for the resource being described. | about (attribute) | [anyURI](#uri)
mediator | A reference to the entity that mediates access to the described source. | gx:mediator | [`gx:ResourceReference`](#resource-reference)
sources | A list of references to any sources from which this source is derived. | gx:source | [`gx:SourceReference`](#source-reference)
analysis | A reference to a document containing analysis about this source. | gx:analysis | [`gx:ResourceReference`](#resource-reference)
componentOf | A reference to the source that contains this source. | gx:componentOf | [`gx:SourceReference`](#source-reference)
titles | The display name(s) for this source. | gx:title | [`gx:TextValue`](#text-value)
notes | A list of notes about a source | gx:note | [`gx:Note`](#note)
attribution | The attribution of this source. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... id="local_id" about="(uri reference to the source)" mediaType="..." resourceType="...">
    <gx:citation>
      ...
    </gx:citation>
    ...
    <gx:mediator resource="(uri reference to the mediator)"/>
    <gx:source>
      ...
    </gx:source>
    ...
    <gx:analysis resource="(uri reference to an analysis document)"/>
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

<a name="agent"/>

## 2.4 The "Agent" Data Type

The `gx:Agent` XML type is used to (de)serialize the `http://gedcomx.org/v1/Agent`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | An identifier for the XML element holding the agent data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id (attribute) | xsd:string
names | The name(s) of the person or organization. | gx:name | [`gx:TextValue`](#text-value)
homepage | The homepage of the person or organization. | gx:homepage | [`gx:ResourceReference`](#resource-reference)
openid  | The [openid](http://openid.net/) of the person or organization. | gx:openid | [`gx:ResourceReference`](#resource-reference)
accounts  | The online account(s) of the person or organization. | gx:account | [`gx:OnlineAccount`](#online-account)
emails  | The email address(es) of the person or organization. | gx:email | [`gx:ResourceReference`](#resource-reference)
phones  | The phone(s) (voice, fax, mobile) of the person or organization. | gx:phone | [`gx:ResourceReference`](#resource-reference)
addresses  | The address(es) of the person or organization. | gx:address | [`gx:Address`](#address)
person | A reference to the person that describes this agent. | gx:person | [`gx:ResourceReference`](#resource-reference)

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
    <gx:person resource="..."/>

    <!-- possibility of extension elements -->

  </...>
```

<a name="event"/>

## 2.5 The "Event" Data Type

The `gx:Event` is used to (de)serialize the `http://gedcomx.org/v1/Event`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the event. | type (attribute) | [`URI`](#uri)
date | The date of the event. | gx:date | [`gx:Date`](#conclusion-date)
place | The place of the event. | gx:place | [`gx:Place`](#conclusion-place)
roles | Information about how persons participated in the event. | gx:role | [`gx:EventRole`](#conclusion-event-role)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Marriage" >

    <!-- ...the members of [gx:Subject](#subject)... -->

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

<a name="document"/>

## 2.6 The "Document" Data Type

The `gx:Document` XML type is used to (de)serialize the `http://gedcomx.org/v1/Document` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | The type of the document. | type (attribute) | [`URI`](#uri)
extracted | Whether this document is to be constrained as an [_extracted conclusion_](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#4-extracted-conclusion-constraints). | type (attribute) | xsd:boolean
textType | The type of text in the `text` property. | gx:textType | xsd:string
text | The text of the document. | gx:text | xsd:string
attribution | The attribution of this document. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... xml:lang="en" extracted="false" type="http://gedcomx.org/Analysis" textType="plain">

    <!-- ...the members of [gx:Conclusion](#conclusion)... -->

    <gx:attribution>
      ...
    </gx:attribution>
    <gx:text>...text of the document...</gx:text>
  </...>
```

<a name="place-description"/>

## 2.7 The "PlaceDescription" Data Type

The `gx:PlaceDescription` is used to (de)serialize the `http://gedcomx.org/v1/PlaceDescription` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
names | A list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place. | gx:name | [`gx:TextValue`](#text-value)
type | A uniform resource identifier (URI) identifying the type of the place as it is applicable to this description. | type (attribute) | [`URI`](#uri)
place | An identifier for the place being described. | gx:place | [`gx:ResourceReference`](#resource-reference)
latitude | Angular distance, in degrees, north or south of the Equator. | gx:latitude | xsd:double
longitude | Angular distance, in degrees, east or west of the Prime Meridian. | gx:latitude | xsd:double
temporalDescription | A description of the time period to which this place description is relevant. | gx:temporalDescription | [`gx:Date`](#conclusion-date)
spatialDescription | A reference to a geospatial description of this place. | gx:spatialDescription | [`gx:ResourceReference`](#resource-reference)

### examples

```xml
  <... id="local_id" type="http://identifier/for/the/place/type">

    <!-- ...the members of [gx:Subject](#subject)... -->

    <gx:name>
      ...
    </gx:name>
    ...
    <gx:place resource="..."/>
    <gx:latitude>27.9883575</gx:latitude>
    <gx:longitude>86.9252014</gx:longitude>
    <gx:temporalDescription>
      ...
    </gx:temporalDescription>
    <gx:spatialDescription resource="http://uri/for/KML/document"/>
    ...
  </...>
```


# 3. Component-Level Data Types

This section specifies XML types for each component-level data type defined by the
conceptual model specification.

<a name="identifier-type"/>

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

<a name="attribution"/>

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

<a name="note"/>

## 3.3 The "Note" Data Type

The `gx:Note` XML type is used to (de)serialize the `http://gedcomx.org/Note` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the note. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
subject | A subject or title for the note. | gx:subject | xsd:string
text | The text of the note. | gx:text | xsd:string
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

<a name="text-value"/>

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

<a name="source-citation"/>

## 3.5 The "SourceCitation" Data Type

The `gx:SourceCitation` XML type is used to (de)serialize the
`http://gedcomx.org/v1/SourceCitation` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the citation. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
value | A rendering of the full citation as a string. | gx:value | xsd:string

### examples

```xml
  <... xml:lang="en">
    <gx:value>...a rendering of the full citation as a string...</gx:value>

    <!-- possibility of extension elements -->

  </...>
```

<a name="source-reference"/>

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

<a name="evidence-reference"/>

## 3.7 The "EvidenceReference" Data Type

The `gx:EvidenceReference` XML type is used to (de)serialized the `http://gedcomx.org/v1/EvidenceReference`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
resource  | Reference to the supporting data. | resource (attribute) | [`URI`](#uri)
attribution | The attribution of this evidence reference. | gx:attribution | [`gx:Attribution`](#attribution)

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

<a name="online-account"/>

## 3.8 The "OnlineAccount" Data Type

The `gx:OnlineAccount` XML type is used to (de)serialize the `http://gedcomx.org/v1/OnlineAccount`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
serviceHomepage  | The URI identifying the online service provider that holds the account being described. | gx:serviceHomepage | [`gx:ResourceReference`](#resource-reference)
accountName | The name, label, or id that uniquely identifies the account maintained by the online service provider. | gx:accountName | xsd:string

### examples

```xml
  <...>
    <gx:serviceHomepage resource="http://familysearch.org/"/>
    <gx:accountName>...</gx:accountName>

    <!-- possibility of extension elements -->

  </...>
```

<a name="address"/>

## 3.9 The "Address" Data Type

The `gx:Address` XML type is used to (de)serialize the `http://gedcomx.org/v1/Address`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
value | A full representation of the complete address. | gx:value | xsd:string
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

    <!-- possibility of extension elements -->

  </...>
```

<a name="conclusion"/>

## 3.10 The "Conclusion" Data Type

The `gx:Conclusion` XML type is used to (de)serialize the `http://gedcomx.org/v1/Conclusion`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
id | An identifier for the XML element holding this conclusion's data. The id attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids). | id (attribute) | xsd:string
lang | The locale identifier for the conclusion. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
sources | The list of references to sources related to this conclusion. | gx:source | [`gx:SourceReference`](#source-reference)
analysis  | Reference to a document containing analysis supporting this conclusion. | gx:analysis | [`gx:ResourceReference`](#resource-reference)
notes | A list of notes about this conclusion. | gx:note | [`gx:Note`](#note)
confidence  | Reference to a confidence level for this conclusion. | confidence (attribute) | [`URI`](#uri)

### examples

```xml
  <... id="local_id" xml:lang="en" confidence="http://gedcomx.org/High">
    <gx:source>
      ...
    </gx:source>
    ...
    <gx:analysis resource="http://identifier/for/analysis/document"/>
    <gx:note>
      ...
    </gx:note>
    ...

    <!-- possibility of extension elements -->

  </...>
```

<a name="subject"/>

## 3.11 The "Subject" Data Type

The `gx:Subject` XML type is used to (de)serialize the `http://gedcomx.org/v1/Subject` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
extracted | Whether this subject is to be constrained as an [_extracted conclusion_](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#4-extracted-conclusion-constraints). | extracted (attribute) | xsd:boolean
evidence | References to other subjects that support this subject. | gx:evidence | [`gx:EvidenceReference`](#evidence-reference)
media | References to multimedia resources for this subject, such as photos or videos. | gx:media | [`gx:SourceReference`](#source-reference)
identifiers | Identifiers for this subject. | gx:identifier | [`gx:Identifier`](#identifier-type)
attribution | The attribution of this subject. | gx:attribution | [`gx:Attribution`](#attribution)

### examples

```xml
  <... id="local_id" extracted="false">

    <!-- ...the members of [gx:Conclusion](#conclusion)... -->

    <gx:evidence>
      ...
    </gx:evidence>
    ...
    <gx:media>
      ...
    </gx:media>
    ...
    <gx:identifiers>
      ...
    </gx:identifiers>
    ...
    <gx:attribution>
      ...
    </gx:attribution>

    <!-- possibility of extension elements -->

  </...>
```

<a name="gender-conclusion"/>

## 3.12 The "Gender" Data Type

The `gx:Gender` XML type is used to (de)serialize the `http://gedcomx.org/v1/Gender`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the gender. | type (attribute) | [`URI`](#uri)

### examples

```xml
<... id="local_id" type="http://gedcomx.org/Male">

  <!-- ...the members of [gx:Conclusion](#conclusion)... -->

</...>
```

<a name="name-conclusion"/>

## 3.13 The "Name" Data Type

The `gx:Name` XML type is used to (de)serialize the `http://gedcomx.org/v1/Name`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the name type. | type (attribute) | [`URI`](#uri)
date | The date of applicability of the name. | gx:date | [`gx:Date`](#conclusion-date)
nameForms | The name form(s) that best represents this name; representations of the same name&mdash;__*not*__ name variants (i.e., not nicknames or spelling variations). | gx:nameForm | [`gx:NameForm`](#name-form)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/BirthName">

    <!-- ...the members of [gx:Conclusion](#conclusion)... -->

    <gx:date>
      ...
    </gx:date>
    <gx:nameForm>
      ...
    </gx:nameForm>
    ...
  </...>
```

<a name="fact-conclusion"/>

## 3.14 The "Fact" Data Type

The `gx:Fact` XML type is used to (de)serialize the `http://gedcomx.org/v1/Fact`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the fact. | type (attribute) | [`URI`](#uri)
date | The date of applicability of the fact. | gx:date | [`gx:Date`](#conclusion-date)
place | The place of applicability of the fact. | gx:place | [`gx:PlaceReference`](#conclusion-place-reference)
value | The value of the fact. | gx:value | xsd:string
qualifiers | Qualifiers to add additional details about the fact. | gx:qualifier | [`gx:Qualifier`](#qualifier)

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Birth">

    <!-- ...the members of [gx:Conclusion](#conclusion)... -->

    <gx:date>
      ...
    </gx:date>
    <gx:place>
      ...
    </gx:place>
    <gx:value>
      ...
    </gx:value>
    <gx:qualifier name="http://gedcomx.org/Age">...</gx:qualifier>
    ...
  </...>
```

<a name="conclusion-event-role"/>

## 3.15 The "EventRole" Data Type

The `gx:EventRole` XML type is used to (de)serialize the `http://gedcomx.org/v1/EventRole`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
person | Reference to the event participant. | gx:person | [`gx:ResourceReference`](#resource-reference)
type | URI identifying the participant's role. | type (attribute) | [`URI`](#uri)
details | Details about the role of participant in the event. | gx:details | xsd:string

### examples

```xml
  <... id="local_id" type="http://gedcomx.org/Witness">

    <!-- ...the members of [gx:Conclusion](#conclusion)... -->

    <gx:person resource="http://identifier/for/person/1"/>
    <gx:details>...</gx:details>
  </...>
```

<a name="conclusion-date"/>

## 3.16 The "Date" Data Type

The `gx:Date` XML type is used to (de)serialize the `http://gedcomx.org/v1/Date`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
original | The original value of the date as supplied by the contributor. | gx:original | xsd:string
formal | The standardized, formal representation of the date. | gx:formal | [GEDCOM X Date](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md)

### examples

```xml
  <...>
    <gx:original>...the original text...</gx:original>
    <gx:formal>...</gx:formal>

    <!-- possibility of extension elements -->

  </...>
```

<a name="conclusion-place-reference"/>

## 3.17 The "PlaceReference" Data Type

The `gx:PlaceReference` is used to (de)serialize the `http://gedcomx.org/v1/PlaceReference` data type.

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

<a name="name-part"/>

## 3.18 The "NamePart" Data Type

The `gx:NamePart` XML type is used to (de)serialize the `http://gedcomx.org/v1/NamePart`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
type | URI identifying the type of the name part. | type (attribute) | [`URI`](#uri)
value | The term(s) from the name that make up this name part. | value (attribute) | xsd:string
qualifiers | Qualifiers to add additional semantic meaning to the name part. | gx:qualifier | [`gx:Qualifier`](#qualifier)

### examples

```xml
  <... type="http://gedcomx.org/Prefix" value="...value of the name part...">
    <qualifier name="http://gedcomx.org/First"/>
    ...

    <!-- possibility of extension elements -->

  </...>
```

 <a name="name-form"/>

## 3.19 The "NameForm" Data Type

The `gx:NameForm` XML type is used to (de)serialize the `http://gedcomx.org/v1/NameForm`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
lang | The locale identifier for the name form. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag
fullText | A full rendering of the name. | gx:fullText | xsd:string
parts | Any identified name parts from the name. | gx:part | [`gx:NamePart`](#name-part)

### examples

```xml
  <... xml:lang="en">
    <gx:fullText>...full text of the name form...</gx:fullText>
    <gx:part>
      ...
    </gx:part>
    ...

    <!-- possibility of extension elements -->

  </...>
```

<a name="qualifier"/>

## 3.20 The "Qualifier" Data Type

The `gx:Qualifier` XML type is used to (de)serialize the `http://gedcomx.org/v1/Qualifier`
data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
name | The name of the qualifier. | name (attribute) | [anyURI](#uri)
value | The value of the qualifier. | (child text) | xsd:string

### examples

```xml
  <... name="http://gedcomx.org/QualifierName">...qualifier value...</...>
```


# 4 XML-Specific Data Types

This section describes a set of data types that are specific to the GEDCOM X XML media
type, used for the convenience of serialization.

<a name="uri"/>

## 4.1 The URI

The [`xsd:anyURI`](http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#anyURI)
XML type defined by the XML schema specification will be used to (de)serialize the URI.

<a name="resource-reference"/>

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

name | description | XML property | XML type | constraints
-----|-------------|--------------|----------|------------
id | An identifier for the data set. | id (attribute) | xsd:string | OPTIONAL. If provided, the `id` attribute MUST conform to the constraints defined in [Section 7, "Fragment Identifiers"](#fragment-ids).
lang | The locale identifier for the data set. | xml:lang (attribute) | [IETF BCP 47](http://tools.ietf.org/html/bcp47) locale tag | OPTIONAL. If not provided, the locale is determined per [Internationalization Considerations](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#i18n).
attribution | The attribution of this data set. | gx:attribution | [`gx:Attribution`](#attribution) | OPTIONAL.
persons | The list of persons contained in the data set. | gx:person | [`gx:Person`](#person) | OPTIONAL.
relationships | The list of relationships contained in the data set. | gx:relationship | [`gx:Relationship`](#relationship) | OPTIONAL.
sourceDescriptions | The list of source descriptions contained in the data set. | gx:sourceDescription | [`gx:SourceDescription`](#source-description) | OPTIONAL.
agents | The list of agents contained in the data set. | gx:agent | [`gx:Agent`](#agent) | OPTIONAL.
events | The list of events contained in the data set. | gx:event | [`gx:Event`](#event) | OPTIONAL.
documents | The list of documents contained in the data set. | gx:document | [`gx:Document`](#document) | OPTIONAL.

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

<a name="gedcomx-element"/>


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


# 6. Extensibility

In accordance with the [extensibility provisions](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#extensibility)
of the GEDCOM X Conceptual Model, extensions MAY be provided as XML elements or attributes on data types where
extensions are not explicitly prohibited.

## 6.1 Data Type Extensions

New data types MAY be defined as extensions to the GEDCOM X XML Serialization Format by providing the following:

* A conceptual data type definition as specified by the GEDCOM X Conceptual Model [Section 5.1](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#51-data-type-extensions).
* An XML name and namespace for each property of the data type, and whether the property is serialized as an XML element or attribute.

The namespace `http://gedcomx.org/v1/` is reserved for elements and attributes defined by the GEDCOM X specification
set. Data types defined outside the scope of the GEDCOM X specification set MUST NOT use the value `http://gedcomx.org/v1/`
as a namespace for the XML element or attribute.

Specifications that define new data types as GEDCOM X XML extensions MUST be published and made freely available and
compatible with the terms and constraints that govern the GEDCOM X XML Serialization Format.

## 6.2 Known XML Element Extensions

GEDCOM X defines a set of elements that are explicitly associated with a data type such that
GEDCOM X XML parsers MAY interpret the elements correctly if they are included as an extension
element in a valid data type as defined by the conceptual model. The following elements are
identified:

name | XML type
-----|-----------------
gx:person | [`gx:Person`](#person)
gx:relationship | [`gx:Relationship`](#relationship)
gx:sourceDescription | [`gx:SourceDescription`](#source-description)
gx:agent| [`gx:Agent`](#agent)
gx:event | [`gx:Event`](#event)
gx:document | [`gx:Document`](#document)
gx:placeDescription | [`gx:PlaceDescription`](#place-description)
gx:attribution | [`gx:Attribution`](#attribution)
gx:note | [`gx:Note`](#note)
gx:sourceReference | [`gx:SourceReference`](#source-reference)
gx:gender | [`gx:Gender`](#gender-conclusion)
gx:name | [`gx:Name`](#name-conclusion)
gx:fact | [`gx:Fact`](#fact-conclusion)


<a name="fragment-ids"/>

7. Fragment Identifiers

Fragment identifiers are used to identify specific elements (i.e. "fragments") within an XML document. The GEDCOM X
XML serialization format specifies the use of the "id" attribute as the fragment identifier for any element in
a given XML document. Note that some data types explicitly define an "id" attribute, but the XML serialization format
allows the option of an "id" attribute on _all_ elements for the purpose of identifying fragments of the XML document.
The values of all fragment identifiers within a single XML document MUST be unique.

For more information about fragment identifiers, see [RFC 3986, Section 3.5](http://tools.ietf.org/html/rfc3986#section-3.5).


