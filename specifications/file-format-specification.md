# The GEDCOM X File Format

## Status

This document specifies a file format for data defined by the [GEDCOM X standard conceptual
model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md),
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

The GEDCOM X File Format spec specifies how to bundle up genealogical data into a file and defines how the resources within the file can link to each other. The spec includes notational conventions, the ZIP file format, the GEDCOM X resources, the manifest, data references, examples, and the GEDCOM X filename extension.

<a name="intro"/>

# 1. Introduction

A GEDCOM X file is a bundle of digital genealogical resources, such as data that has been gathered
through the genealogical research process about persons, relationships, sources, images, etc.
This specification defines a mechanism to bundle all of these resources into a single file
and defines a mechanism whereby each resource within the bundle may refer to other resources within
the same file.

## Table Of Contents

* [1. Introduction](#intro)
  * [1.1 Identifier, Version and Dependencies](#id-and-version)
  * [1.2 Notational Conventions](#notational-conventions)
* [2. Zip File](#zip-file)
* [3. Resources in a GEDCOM X File](#resources-gedcomx-file)
  * [3.1 Resources Defined by GEDCOM X](#resources-gedcomx)
  * [3.2 Resources Defined Externally to GEDCOM X](#resources-externally-gedcomx-)
* [4. The Manifest](#manifest)
  * [4.1 Main Header Fields](#main-header-fields)
  * [4.2 Individual Resource Header Fields](#individual-resource-header-fields)
* [5. Data References](#data-references)
  * [5.1 Absolute References](#absolute-references)
  * [5.2 Same-Document References](#same-document-references)
  * [5.3 Relative References](#relative-references)
    * [5.3.1 Network-Path Relative References](#network-relative-references)
    * [5.3.2 Absolute-Path Relative References](#absolute-path-relative-references)
    * [5.3.3 Relative-Path Relative References](#relative-relative-references)
* [6. Example](#example)
  * [6.1 Example Data References](#example-data-references)
* [7. GEDCOM X Filename Extension](#gedxomx-filename-extension)

<a name="id-and-version"/>

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/file/v1`

For convenience, the GEDCOM X file format may be referred to as "GEDCOM X File Format 1.0".
This specification uses "GEDCOM X File Format" internally.

This specification depends on the [ZIP file format](http://www.pkware.com/documents/casestudies/APPNOTE.TXT)
defined by PKWARE, Inc.

This specification depends on the GEDCOM X XML Serialization Format identified
by [`http://gedcomx.org/xml/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md).

This specification depends on the GEDCOM X Standard Header Set identified
by [`http://gedcomx.org/headers/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md).

This specification depends on [RFC 822](http://tools.ietf.org/html/rfc822) which defines the format
for header fields that are used to define the GEDCOM X file manifest.

This specification refers to [RFC 3986](http://tools.ietf.org/html/rfc3986) to explain how URI references are to be
resolved within a GEDCOM X file.

<a name="notational-conventions"/>

## 1.2 Notational Conventions

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

<a name="zip-file"/>

# 2. Zip File

The GEDCOM X File Format is an extension of the [ZIP file format](http://www.pkware.com/documents/casestudies/APPNOTE.TXT).
Each resource in the GEDCOM X file is provided as an entry in the file. A GEDCOM X File MUST include a manifest file that
provides metadata about the GEDCOM X file and the resources contained in it.

<a name="resources-gedcomx-file"/>

# 3. Resources in a GEDCOM X File

<a name="resources-gedcomx"/>

## 3.1 Resources Defined by GEDCOM X

All resources defined by the [GEDCOM X Conceptual Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md)
MUST be represented using the GEDCOM X XML media type as defined by the [GEDCOM X XML Format specification](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md).
As such, each GEDCOM X resource is provided within a valid GEDCOM X XML document with the
[GEDCOM X XML Element](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md) as the root element.
Each GEDCOM X file MUST contain at least one GEDCOM X XML document. A GEDCOM X file MAY contain more than one GEDCOM X XML document.
This specification does not specify a maximum number of elements nor a minimum number of elements supplied within each GEDCOM X document.

<a name="resources-externally-gedcomx-"/>

## 3.2 Resources Defined Externally to GEDCOM X

A GEDCOM X file MAY contain resources other than those defined by the [GEDCOM X Conceptual Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).
Examples of such resources include images, videos, audio files, etc. For each such resource in the GEDCOM X file,
a media type MUST be provided using the GEDCOM X file manifest.

<a name="manifest"/>

# 4. The Manifest

The manifest is a REQUIRED entry in the GEDCOM X file that provides metadata about the GEDCOM X file and each of the
resources contained within the file. The manifest is provided as an entry in the file named `META-INF/MANIFEST.MF`.

The metadata about the file and about each entry in the file is supplied in the manifest using "header fields" as defined by
[RFC 822, Section 3.2](http://tools.ietf.org/html/rfc822#section-3.2). Each header field consists of a name followed by a colon (":")
and the field value. Field names are case-insensitive. The field value MAY be preceded by any amount of linear white space, though
a single space is RECOMMENDED. Header fields can be extended over multiple lines by preceding each extra line with at least one
space character.

Header fields are grouped into "sections". Sections are separated from other sections by one or more empty lines. The manifest consists
of a "main" section followed by one section for each resource in the GEDCOM X file.

The main section consists of a (possibly empty) set of header fields that supply metadata for the GEDCOM X file itself. The main section
MUST NOT contain a header field named "Name".

Each section for individual resources in the GEDCOM X file MUST start with a header field with the name "Name" and the value being the name
of the entry for the resource in the GEDCOM X file.

<a name="main-header-fields"/>

## 4.1 Main Header Fields

All of the headers defined by the [GEDCOM X Standard Header Set](https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md)
MAY be used as header fields in the main section of the manifest.

Use of the following headers is REQUIRED:

* `X-DC-conformsTo`, used to identify the specification(s) the file conforms to. There MUST be one `X-DC-conformsTo` header with the value `http://gedcomx.org/file/v1`
  to identify the file's compliance with this specification. Other `X-DC-conformsTo` headers MAY be supplied to identify compliance with other specifications.

Use of the following headers is RECOMMENDED if the metadata is available:

* `User-Agent`, used to provide information about the software, program, or other application used to create the file.
* `X-DC-created`, used to determine when the file was created.
* `X-DC-creator`, used to identify the agent that created the file. The value of the header is interpreted as a URI Reference that resolves to the agent, possibly provided in the GEDCOM X file itself.

<a name="individual-resource-header-fields"/>

## 4.2 Individual Resource Header Fields

All of the headers defined by the [GEDCOM X Standard Header Set](https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md)
MAY be used as header fields applicable to the resource to which the section applies. Use of the following headers is RECOMMENDED for each individual resource
if the metadata is available:

* `Content-Type` is used to determine the media type of the resource in the file. If a `Content-Type` header field is not provided, the media type of the resource is assumed to be `application/x-gedcomx-v1+xml`.
* `ETag` is used to supply a version for the resource.
* `X-DC-modified` is used to supply a timestamp of when the resource was last modified.

<a name="data-references"/>

# 5. Data References

The [GEDCOM X Conceptual Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md) specifies
that instances of data types refer to other instances via [URI Reference](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#uri).
To support references to instances of data types within a GEDCOM X file, this section clarifies how URI References are to
be resolved within the context of a file.

<a name="absolute-references"/>

## 5.1 Absolute References

If an instance of a data type refers to an resource that is external to the file, such as an online resource, the URI Reference MUST be an
Absolute URI as defined by [RFC 3986 Section 4.3](http://tools.ietf.org/html/rfc3986#section-4.3).

<a name="same-document-references"/>

## 5.2 Same-Document References

References to instances of data types that are contained within the same GEDCOM X XML Document within a GEDCOM X file
are referred to as "same-document references". A same-document URI reference is specified by
[RFC 3986 Section 4.4](http://tools.ietf.org/html/rfc3986#section-4.4).

<a name="relative-references"/>

## 5.3 Relative References

Data type instances MAY refer to other data type instances that reside in the same GEDCOM X file but in different entries within that file.
Such references use a relative URI reference as defined by [RFC 3986 Section 4.2](http://tools.ietf.org/html/rfc3986#section-4.2).

Per [RFC 3986 Section 5.1](http://tools.ietf.org/html/rfc3986#section-5.1), relative references are only usable when a base URI is known.
For the purposes of resolving relative references within a GEDCOM X file, the base URI is defined as the URI to the directory at the root of
the ZIP file. The base URI of a GEDCOM X file aligns with the concept of the "Base URI from the Encapsulating Entity" as defined by
[RFC 3986 Section 5.1.2](http://tools.ietf.org/html/rfc3986#section-5.1.2).

<a name="network-relative-references"/>

### 5.3.1 Network-Path Relative References

[RFC 3986 Section 4.2](http://tools.ietf.org/html/rfc3986#section-4.2) specifies that a relative reference that begins with two slash
characters is termed a network-path reference. Network-path references SHOULD NOT be used within a GEDCOM X file. The resolution mechanism
for a network-path reference within a GEDCOM X file is not defined by this specification.

<a name="absolute-relative-references"/>

### 5.3.2 Absolute-Path Relative References

[RFC 3986 Section 4.2](http://tools.ietf.org/html/rfc3986#section-4.2) specifies that a relative reference that begins with a single slash
character is termed an absolute-path reference. Absolute path references are to be resolved as defined by [RFC 3986 Section 5.2](http://tools.ietf.org/html/rfc3986#section-5.2).

<a name="relative-relative-references"/>

### 5.3.3 Relative-Path Relative References

[RFC 3986 Section 4.2](http://tools.ietf.org/html/rfc3986#section-4.2) specifies that a relative reference that does not begin with a
slash character is termed a relative-path reference. Relative path references are to be resolved as defined by [RFC 3986 Section 5.2](http://tools.ietf.org/html/rfc3986#section-5.2).


<a name="example"/>

# 6. Example

The following example is provided to illustrate of the make up of a GEDCOM X file, to demonstrate how resource references are resolved
from within a GEDCOM X file. The example is a GEDCOM X file that contains three resources along with the (mandatory) GEDCOM X file
manifest, as follows:

(ZIP) File Entry | Description
-----------------|------------
`bishop/tree.xml` | A GEDCOM X XML document containing a single person.
`images/alma-birth-certificate.jpg` | A JPEG image that represents a digital copy of a birth certificate.
`tree.xml` | A GEDCOM X XML document containing a person, a relationship, and a source description.
`META-INF/MANIFEST.MF` | The GEDCOM X file manifest.

#### bishop/tree.xml

The resource in the entry `bishop/tree.xml` in the file is a GEDCOM X XML document that contains genealogical information about
a person named Marie Bishop and her ancestry. The instance of `Person` in the document that describes Marie provides the value
"KWCR-JW3" for its `id` property.

#### images/alma-birth-certificate.jpg

The resource in the entry `images/alma-birth-certificate.jpg` in the file is a JPEG image that is a digital copy of a birth
certificate for a person named Alma Heaton.

#### tree.xml

The resource in the entry `tree.xml` in the file is a GEDCOM X XML document that contains genealogical information about
a person named Alma Heaton and his ancestry. The instance of `Person` in the document that describes Alma provides the value
"KWCR-JWS" for its `id` property.

The document also contains an instance of `SourceDescription` that describes the copy of the birth certificate of Alma Heaton
that is provided in the entry `images/alma-birth-certificate.jpg`. In addition to information about the source such as a title,
citation, etc., the instance of `SourceDescription` that describes the birth certificate provides the value "M8PT-4GP" for its
`id` property.

The document also contains an instance of `Relationship` that describes the relationship between Alma Heaton and Marie Bishop.
In relationship is described as a `Couple` relationship and contains an instance of `Fact` that describes the marriage of
Alma and Marie. The relationship does not provide a value for its `id` property.

#### META-INF/MANIFEST.MF

The resource in the entry `META-INF/MANIFEST.MF` is the GEDCOM X file manifest. It describes the file as follows:

```
X-DC-created: 2013-05-17T12:31:14

Name: tree.xml
Content-Type: application/x-gedcomx-v1+xml

Name: bishop/tree.xml
Content-Type: application/x-gedcomx-v1+xml

Name: images/alma-birth-certificate.jpg
Content-Type: image/jpeg
```

<a name="example-data-references"/>

## 6.1 Example Data References

This section describes the data references that are used by the data instances to refer to other data instances.

#### The couple relationship

In the above example, the instance of `Relationship` contained by the document at `tree.xml` refers to both the instance
of `Person` that describes Alma and to the instance of `Person` that describes Marie. Because the instance of `Relationship`
is contained within the same document as the instance of `Person` that describes Alma, the relationship references
Alma using a _same-document reference_ to the fragment id of Alma, "#KWCR-JWS". The relationship refers to the
instance of `Person` that describes Marie by using a _relative reference_ that includes the reference fragment id.
In this case, an _absolute-path relative reference_ is used: "/bishop/tree.xml#KWCR-JW3". For convenience, the XML snippet
of `tree.xml` illustrating the relationship is provided here:

```xml
<gedcomx xmlns="http://gedcomx.org/v1/">
  ...
  <relationship type="http://gedcomx.org/Couple">
    <person1 resource="#KWCR-JWS"/>
    <person2 resource="/bishop/tree.xml#KWCR-JW3"/>
    ...
  </relationship>
  ...
</gedcomx>
```

#### The source reference and source description

In the above example, the instance of `Person` that describes Alma references a description of a source, which in turn
references the image of the birth certificate. Because the source reference and the source description are contained
within the same document, the source reference refers to the document using a _same-document reference_: "#M8PT-4GP".
The source description refers to the image using the `about` property. For the purposes of illustration, a _relative-path
relative reference_ is used: "./images/alma-birth-certificate.jpg". For convenience, the XML snippet of `tree.xml`
illustrating the source reference and source description is provided here:

```xml
<gedcomx xmlns="http://gedcomx.org/v1/">
  ...
  <person id="KWCR-JWS">
    ...
    <source description="#M8PT-4GP"/>
    ...
  </person>
  ...
  <sourceDescription about="./images/alma-birth-certificate.jpg">
    ...
  </sourceDescription>
  ...
</gedcomx>
```

<a name="gedxomx-filename-extension"/>

# 7. GEDCOM X Filename Extension

The filename extension `.gedx` is RECOMMENDED for GEDCOM X files.
