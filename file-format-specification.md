# File Format

This document defines the specification for the GEDCOM X File Format.

A GEDCOM X file is a bundle of digital genealogical resources. Resources reference other resources,
which may be located within the same file or may be located external to the file.

Perhaps the most familiar use of a GEDCOM X file is to bundle together conclusions about a pedigree. This
research is composed of a lot of different resources such as persons, relationships, citations and images.
The GEDCOM X File Format is designed to enable the bundling of all of these resources into a single file
and to specify how each resource may reference (or link to) other resources, which are either
bundled in the same file or are located external to the file, such as in an online database.

# Zip File

The GEDCOM X File Format is an extension of the [ZIP file format](http://en.wikipedia.org/wiki/ZIP_file_format).
Each resource in the GEDCOM X file is defined as an entry in the file.
A GEDCOM X File must include a manifest file that provides metadata about the GEDCOM X file and resources
contained in it.

# GEDCOM X Resource Representations

For all resources defined by the [GEDCOM X conceptual model](https://github.com/FamilySearch/gedcomx/blob/master/conceptual-model-specification.md),
file format processors MUST support the XML representation of those resources as defined by the
[XML format specification](https://github.com/FamilySearch/gedcomx/blob/master/xml-format-specification.md). Processors
MAY also support the JSON representation of the resource as defined by the
[JSON format specification](https://github.com/FamilySearch/gedcomx/blob/master/json-format-specification.md).

# The Manifest

The manifest is a required entry in the GEDCOM X file that provides metadata about the GEDCOM X file and each of the
resources contained within the file. The manifest is the entry within the file named `META-INF/MANIFEST.MF` as defined
by the [JAR specification](http://docs.oracle.com/javase/7/docs/technotes/guides/jar/jar.html).
The metadata about the file and about each entry in the file
is supplied as Name-Value pairs grouped into Sections as specified by the JAR specification. Each Name-Value pair is referred to as an
"Attribute".

### Main Attributes

Attributes that apply globally to the GEDCOM X file are defined in the "Main" section of the manifest and are referred to as "Main Attributes".

Currently, the GEDCOM X File Format does not require any of the Main attributes specified by the JAR specification.

### Per-Entry Attributes

Attributes that apply to a specific resource in the file are referred to as
["Per-Entry Attributes" defined by the JAR specification](http://docs.oracle.com/javase/7/docs/technotes/guides/jar/jar.html#Per-Entry_Attributes).
All entries in a GEDCOM X file _MUST_ supply a `Name` and `Content-Type` attributes.
The the GEDCOM X file
format supports the following per-entry attributes:

#### Name

The `Name` attribute is **required** for all entries of a GEDCOM X file and is the attribute that begins a new section for the next entry.
The `Name` attribute specifies the name of the resource and the value should always be a relative path i.e. it should not begin with a `/`.

#### Content-Type

The `Content-Type` attribute is **required** for all entries of a GEDCOM X file. The `Content-Type` attribute specifies how the given entry
is to be parsed. If the `Content-Type` of the entry is missing or not recognized, the entry should be skipped and references to the
entry should be treated as errors.

#### GX-Root

A GEDCOM X file often contains object graphs, such as when the file contains a serialized pedigree. The `GX-Root` attribute is an _optional_ attribute
with a `boolean` value ("true" or "false") that is used to hint that the entry is to be considered a root of an object graph in the file.

#### ETag

The `ETag` attribute is used to supply a version for the resource. The `ETag` is specified by the HTTP specification, section
[14.19](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.19). See also [wikipedia](http://en.wikipedia.org/wiki/HTTP_ETag).

#### Last-Modified

The `Last-Modified` attribute is used to supply a timestamp for the modification of the resource. The `Last-Modified` attribute is specified by
the HTTP specification, section [14.29](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.29).

# Local Resource References

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

# Digital Signatures

The GEDCOM X File Format also specifies how genealogical data within the file can be digitally signed. A
digital signature can be used to identify the provider of the data and to verify that the data was not
modified since it was signed. Signing entries is optional and if provided is defined
by the [JAR specification](http://docs.oracle.com/javase/7/docs/technotes/guides/jar/jar.html)

# Conventions and Best Practices

In order to promote familiarity and ease of use, it is recommended to conform to the following conventions and best practices:

* Use the file extension: .gedx
* Place resources of similar types in the same sub-directory. The common names are:
  - persons
  - relationships
  - images
* Name of the entry for a resource should be the Id if exists. For example a resource for a person with Id of X324 would be stored in the entry persons/X324