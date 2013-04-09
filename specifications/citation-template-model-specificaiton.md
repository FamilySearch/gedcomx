# The GEDCOM X Citation Template Model

## Status

This document defines the concept of a "Citation Template" and specifies how the GEDCOM X Conceptual Model,
the GEDCOM X XML Format, and the GEDCOM X JSON Format are to be extended to support citation templates.
The current state of this document is as a DRAFT, and as such, the document may be subject to changes,
including backwards-incompatible changes, according to the discussion and suggestions for improvement.

## Copyright Notice

Copyright 2011-2013 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

# 1. Introduction

Building source citations is said to be an "art" and requires a great deal of flexibility.  While source citation style guides
exist (e.g. Chicago Manual of Style, etc.), execution within their guidelines is flexible.  As no one citation style enjoys
universal acceptance, the GEDCOM X Citation Template Model defines the concept of "citation templates" to allow a variety of
citation styles to coexist and to be exchanged.

Within a given citation style, citation information is formed into "variants" as the context of the citation varies. For example,
the citation formed for a document's first footnote can be different from the citation formed for the same document in a subsequent
footnote, and again different from the citation formed when it appears in a source list at the end of the same document.

Source citations are hard for even the most diligent genealogists.  Recent industry efforts toward making citation creation
approachable for a typical genealogist have been focused on making citations easy to create in very well-defined and specific
circumstances (i.e., on a per-record-set or per-artifact-type basis), not in finding a one-size-fits-all solution.  The needs
seem to be for mechanisms that hide the complexity of forming a citation in favor of mechanisms that collect fielded information
that a user can readily identify and then providing automation to form the various citation variants (e.g., source list entry,
first reference note, subsequent reference, etc.) within a selected citation style (e.g., Chicago Manual of Style) using this
fielded data as required by circumstance.

In support of the variations in style and context, citation information is collected in pieces, hereby referred to as "citation
fields".  These citation fields can be formed and reformed to produce the variants within a particular style, and perhaps even be
formed into citations in alternate styles.

Citation templates are intended to be a framework within which vendors and standards organizations declare the citation fields
that can be collected about a given type of source -- a controlled vocabulary that defines acceptable fields, field value ranges
and syntax, and any semantic meaning.  Citation templates are also used to declare how the fields are formed into citations (each
variant addressable by a combination of style and variant identifiers). Separate citation templates could be provided for
specific record types (e.g. a template for an online image in the 1910 United States Census) and could be associated with other
templates according to the record type (e.g. a group of templates for newspapers, US census records, UK census records, etc.).
Citation templates could also be bundled with other templates into "template libraries" such that nuances in semantic meaning of
a specific citation field (e.g. "Volume") are shared among all the associated templates. Perhaps a standard template library
could be developed to address the most common citation needs.

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/citaton-template-model/v1`

This specification depends on and extends the conceptual model specification identified
by [`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).

This specification depends on and extends the XML serialization format specification identified
by [`http://gedcomx.org/xml/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md).

This specification depends on and extends JSON xml serialization format specification identified
by [`http://gedcomx.org/json/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md).

## 1.2 Notational Conventions

### 1.2.1 Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

# 2. Data Type Extensions

This section defines new data types and new extension properties on existing data types
for support of citation templates.

<a id="citation-template"/>

## 2.1 The "CitationTemplate" Data Type

The `CitationTemplate` data type defines a citation template.

### identifier

The identifier for the `CitationTemplate` data type is:

`http://gedcomx.org/v1/CitationTemplate`

### constraints

A citation template data type MUST conform to the following provisions:

* A citation template MUST provide a globally unique identifier.
* A citation template MUST declare the citation fields that can be used to form a citation, including which fields are optional and which are required.
* A citation template MUST provide rendering definitions for each relevant citation variant, including:
  * REQUIRED identifier for each citation variant.
  * REQUIRED specification for rendering citation field values into a citation for each citation variant; each rendering specification MUST include any text formatting requirements (e.g. italics).
  * OPTIONAL identifier(s) for the citation style of each citation variant.
  * OPTIONAL titles for each variant (including support for alternate languages)
* A citation template SHOULD provide self-descriptive metadata, such as:
  * identifiers (e.g., template library identifiers)
  * titles (including support for alternate languages)
  * descriptions (including support for alternate languages)
  * keywords for finding and associating relevant templates
* A citation template SHOULD provide information to assist applications in collecting citation field values, such as:
  * display names for citation fields (including support for alternate languages)
  * hints for the citation field values (including support for alternate languages)
  * validation criteria for citation field values

### extension

todo:

### properties

todo:


<a id="citation-field"/>

## 2.2 The "CitationField" Data Type

The `CitationField` data type defines a piece of metadata (e.g., author, volume, page, publisher, etc.)
necessary to identify a source.

The `CitationField` data type does NOT support extension properties.

### identifier

The identifier for the "CitationField" data type is:

`http://gedcomx.org/v1/CitationField`

### properties

name  | description | data type | constraints
------|-------------|-----------|------------
name | The identifier for the citation detail -- defined by a citation template or a citation template library. | [URI](#uri) | REQUIRED.
value | The value of the citation detail. | string | REQUIRED.

## 2.3 Extension Properties to the "SourceCitation" Data Type

The following extension properties are defined as applicable to the [`http://gedcomx.org/v1/SourceCitation`](#source-citation) data type.

name  | description | data type | constraints
------|-------------|-----------|------------
citationTemplate | The identifier of the citation template by which this citation may be interpreted. | [URI](#uri) | OPTIONAL. If provided, MUST resolve to an instance of [`http://gedcomx.org/v1/CitationTemplate`](#citation-template).
fields  | A list of citation fields about a source. | List of [`http://gedcomx.org/v1/CitationField`](#citation-field) | OPTIONAL.


# 3. XML Serialization Format

This section specifies how the [XML serialization format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md)
is extended to support the data types and extension properties for citation templates.

### namespace prefixes

This document uses the following namespace prefixes:

prefix | namespace
-------|----------
gx | `http://gedcomx.org/v1/`
xsd | `http://www.w3.org/2001/XMLSchema`

<a id="citation-template"/>

## 3.1 The "CitationTemplate" Data Type

todo:

<a id="citation-field"/>

## 3.2 The "CitationField" Data Type

The `gx:CitationField` XML type is used to (de)serialize the
`http://gedcomx.org/v1/CitationField` data type.

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
name | The identifier for the citation detail -- defined by a citation template or a citation template library. | gx:name | [anyURI](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md#uri)
value | A rendering of the full (working) citation as a string. | gx:value | xsd:string

### examples

```xml
  <... name="...a citation field name...">...a citation field value...</...>
```

## 3.3 Extension Properties to the "SourceCitation" Data Type

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
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


# 4. JSON Serialization Format

This section specifies how the [JSON serialization format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md)
is extended to support the data types and extension properties for citation templates.


<a id="citation-template"/>

## 4.1 The "CitationTemplate" Data Type

todo:

<a id="citation-field"/>

## 4.2 The "CitationField" Data Type

The JSON object used to (de)serialize the
`http://gedcomx.org/v1/CitationField` data type is defined as follows:

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
name | The identifier for the citation detail -- defined by a citation template or a citation template library. | name | [URI](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md#uri)
value | The value of the citation detail. | value | string

### examples

```json
{
  "name" : "...a citation field name..."
  "value" : "...a citation field value..."
}
```

## 4.3 Extension Properties to the "SourceCitation" Data Type

### properties

name | description | XML property | XML type
-----|-------------|--------------|---------
citationTemplate | The identifier of the citation template by which this citation may be interpreted. | citationTemplate | [`ResourceReference`](#resource-reference)
fields | A list of citation fields about a source. | field | array of [`CitationField`](#citation-field)

### examples

```json
{
  "lang" : "en",
  "value" : "...a rendering of the full (working) citation as a string...",
  "citationTemplate" : {
    "resource" : "http://identifier/for/ciation/template"
  },
  "fields" : [ { ... }, { ... } ]
}
```
