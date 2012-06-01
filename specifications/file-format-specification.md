# The GEDCOM X File Format

## Status

This document specifies a file format for data defined by the [GEDCOM X standard conceptual
model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md),
and requests discussion and suggestions for improvements.

## Copyright Notice

Copyright 2011-2012 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

# 1. Introduction

A GEDCOM X file is a bundle of digital genealogical resources. Resources reference other resources,
which may be located within the same file or may be located external to the file.

Perhaps the most familiar use of a GEDCOM X file is to bundle together conclusions about a pedigree. This
research is composed of a lot of different resources such as persons, relationships, citations and images.
The GEDCOM X File Format is designed to enable the bundling of all of these resources into a single file
and to specify how each resource may reference (or link to) other resources, which are either
bundled in the same file or are located external to the file, such as in an online database.

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/file/v1`

For convenience, the GEDCOM X file format may be referred to as "GEDCOM X File Format 1.0".
This specification uses "GEDCOM X File Format" internally.

This specification is depends on a variety of different standards and specifications.

* The [ZIP file format](http://en.wikipedia.org/wiki/ZIP_file_format) is used to package
  resources.
* Processors are required to support genealogical resources provided in the GEDCOM X XML 1.0
  format identified by [`http://gedcomx.org/xml/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md).
* The [GEDCOM X Standard Header Set](https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md)
  specification provides the set of attributes that are applicable to resources in the file.
* Conventions for supplying metadata for resources were adopted from the
  [JAR file format](http://docs.oracle.com/javase/7/docs/technotes/guides/jar/jar.html). Processors MAY support
  digital signatures as specified by the JAR file format.


## 1.2 Notational Conventions

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

# 2. Zip File

The GEDCOM X File Format is an extension of the [ZIP file format](http://en.wikipedia.org/wiki/ZIP_file_format).
Each resource in the GEDCOM X file is defined as an entry in the file.
A GEDCOM X File must include a manifest file that provides metadata about the GEDCOM X file and resources
contained in it.

# 3. GEDCOM X Resource Representations

For all resources defined by the [GEDCOM X conceptual model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md),
file format processors MUST support the XML representation of those resources as defined by the
[XML format specification](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md). Processors
MAY also support the JSON representation of the resource as defined by the
[JSON format specification](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md).

# 4. The Manifest

The manifest is a required entry in the GEDCOM X file that provides metadata about the GEDCOM X file and each of the
resources contained within the file. The manifest is the entry within the file named `META-INF/MANIFEST.MF` as defined
by the [JAR specification](http://docs.oracle.com/javase/7/docs/technotes/guides/jar/jar.html).
The metadata about the file and about each entry in the file
is supplied as Name-Value pairs grouped into Sections as specified by the JAR specification. Each Name-Value pair is referred to as an
"Attribute".

## 4.1 Main Attributes

Attributes that apply globally to the GEDCOM X file are defined in the "Main" section of the manifest and are referred to as "Main Attributes".

Currently, the GEDCOM X File Format does not require any of the Main attributes specified by the JAR specification.

All of the headers defined by the [GEDCOM X Standard Header Set](https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md)
MAY be used as main attributes and are interpreted to be applicable to the file itself. Some of the most notable include:

* `DC-created`, used to determine when the file was created.
* `DC-creator`, used to identify the creator of the file.

## 4.2 Per-Entry Attributes

Attributes that apply to a specific resource in the file are referred to as
["Per-Entry Attributes" defined by the JAR specification](http://docs.oracle.com/javase/7/docs/technotes/guides/jar/jar.html#Per-Entry_Attributes).
All entries in a GEDCOM X file _MUST_ supply a `Name` and `Content-Type` attributes.

All of the headers defined by the [GEDCOM X Standard Header Set](https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md)
MAY be used as per-entry attributes and are interpreted to be applicable to the resource associated with the entry. Some of the most notable include:

* `Content-Type` MUST be supplied and is used to determine the media type of the resource in the file.
* `ETag` is used to supply a version for the resource.
* `DC-modified` is used to supply a timestamp of when the resource was last modified.

In addition to the headers defined by the [GEDCOM X Standard Header Set](https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md),
The GEDCOM-X File Format defined the following per-entry attributes:

### 4.2.1 Name

The `Name` attribute is **required** for all entries of a GEDCOM X file and is the attribute that begins a new section for the next entry.
The `Name` attribute specifies the name of the resource and the value should always be a relative path i.e. it should not begin with a `/`.

### 4.2.2 GX-Root

A GEDCOM X file often contains object graphs, such as when the file contains a serialized pedigree. The `GX-Root` attribute is an _optional_ attribute
with a `boolean` value ("true" or "false") that is used to hint that the entry is to be considered a root of an object graph in the file.

# 5. Local Resource References

Resources in a GEDCOM X file refer to other resources in the file using URIs. If a resource refers to an external resource, such
as an online resource, the URI must be an absolute URI. References to resources that are contained within the same GEDCOM X file
are referred to as local resource references. Local references take the form of a relative URI that is to be resolved to an entry per
[RFC 3986 Section 5](http://tools.ietf.org/html/rfc3986#section-5).

For example, consider a relationship found in a GEDCOM X file that refers to two persons, one contained within the same GEDCOM X
file as the relationship and the other presumably found external to the file in an online database:

<pre class="prettyprint lang-xml">
&lt;relationship xmlns="http://gedcomx.org/conclusion/v1"
        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
  ...
  &lt;person1 rdf:resource="/persons/12345-ABCDE"/>
  &lt;person2 rdf:resource="https://example.com/persons/98765-ZYXWV"/>
  ...
&lt;/person>
</pre>

# 6. Digital Signatures

The GEDCOM X File Format also specifies how genealogical data within the file can be digitally signed. A
digital signature can be used to identify the provider of the data and to verify that the data was not
modified since it was signed. Signing entries is optional and if provided is defined
by the [JAR specification](http://docs.oracle.com/javase/7/docs/technotes/guides/jar/jar.html)

# 7. Conventions and Best Practices

In order to promote familiarity and ease of use, it is recommended to conform to the following conventions and best practices:

* Use the file extension: .gedx
* Place resources of similar types in the same sub-directory. The common names are:
  - persons
  - relationships
  - images
* Name of the entry for a resource should be the Id if exists. For example a resource for a person with Id of X324 would be stored in the entry persons/X324