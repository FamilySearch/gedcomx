---
layout: default
title: GEDCOM X Specifications
---

# The Specifications

The GEDCOM X specification set is comprised of the following specifications, some of which build on others. The
formal specifications are maintained in a version-controlled and access-controlled repository.

#### Core Specifications

* [The GEDCOM X Date Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md)
* [The GEDCOM X Conceptual Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md)
* [The GEDCOM X XML Serialization Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md)
* [The GEDCOM X JSON Serialization Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md)
* [The GEDCOM X Standard Header Set](https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md)
* [The GEDCOM X File Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md)
* [GEDCOM X Event Types](https://github.com/FamilySearch/gedcomx/blob/master/specifications/event-types-specification.md)
* [GEDCOM X Fact Types](https://github.com/FamilySearch/gedcomx/blob/master/specifications/fact-types-specification.md)
* [GEDCOM X Name Part Qualifiers](https://github.com/FamilySearch/gedcomx/blob/master/specifications/name-part-qualifiers-specification.md)

#### Record Specifications

* [GEDCOM X Record Extensions](https://github.com/FamilySearch/gedcomx-record/blob/master/specifications/record-specification.md)
* [GEDCOM X Field Types](https://github.com/FamilySearch/gedcomx-record/blob/master/specifications/field-types-specification.md)

#### Web Service Specifications

* [GEDCOM X Atom Extensions](https://github.com/FamilySearch/gedcomx-rs/blob/master/specifications/atom-model-specification.md)
* [GEDCOM X RS](https://github.com/FamilySearch/gedcomx-rs/blob/master/specifications/rs-specification.md)

-------------------------------

## Core Specifications

### The GEDCOM X Date Format

The GEDCOM X date format specifies a mechanism for representing dates, with specific attention given to the
need to represent genealogical dates.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md">The GEDCOM X Date Format</a>

### The GEDCOM X Conceptual Model

The GEDCOM X conceptual model is a specification of formal concepts and data types that are used to model
genealogical data. Genealogical data is represented using data types such as persons, relationships, and
sources.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md">The GEDCOM X Conceptual Model</a>

### The GEDCOM X XML Serialization Format

The GEDCOM X XML Serialization Format is a specification that defines the way that the GEDCOM X Conceptual Model is serialized to
and deserialized from [XML](http://www.w3.org/TR/REC-xml/).

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md">The GEDCOM X XML Format</a>

### The GEDCOM X JSON Serialization Format

The GEDCOM X JSON Serialization Format is a specification that defines the way that the GEDCOM X Conceptual Model is serialized to
and deserialized from [JSON](http://json.org).

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md">The GEDCOM X JSON Format</a>

### The GEDCOM X Standard Header Set

When processing a set of genealogical resources, it is often useful to process metadata for the resource before processing it. Examples
of this kind of metadata include:

* The data format for the resource.
* Caching directives such as the last modified timestamp or version.
* Identifiers for the resource.
* Bibliographic metadata, such as a bibliographic citation.
* Display names or titles.

The GEDCOM X Standard Header Set specifies the set of metadata terms that are
recognized for genealogical resources and the mechanism for providing that metadata.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/standard-header-set-specification.md">The GEDCOM X Standard Header Set</a>

### The GEDCOM X File Format

A GEDCOM X file is a bundle of digital genealogical resources, such as data that has been gathered
through the genealogical research process about persons, relationships, sources, images, etc.
The GEDCOM X File Format defines a mechanism to bundle all of these resources into a single file
and defines a mechanism whereby each resource within the bundle may refer to other resources within
the same file.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md">The GEDCOM X File Format</a>

### GEDCOM X Event Types

The GEDCOM X Event Types specification provides a set of enumerated values that identify common event types that are relevant to
genealogical research.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/event-types-specification.md">GEDCOM X Event Types</a>

### GEDCOM X Fact Types

The GEDCOM X Fact Types specification provides a set of enumerated values that identify common fact types that are relevant to
genealogical research.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/fact-types-specification.md">GEDCOM X Fact Types</a>

### GEDCOM X Name Part Qualifiers

The GEDCOM X Name Part Qualifiers specification provides a set of enumerated values that identify common qualifiers of name parts that
are relevant to genealogical research.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx/blob/master/specifications/name-part-qualifiers-specification.md">GEDCOM X Name Part Qualifiers</a>

-------------------------------

## Record Specifications

### GEDCOM X Record Extensions

The GEDCOM X Record Extensions specification provides a set of extensions to GEDCOM X for providing a mechanism to exchange 
field-based genealogical record data.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx-record/blob/master/specifications/record-specification.md">GEDCOM X Record Extensions</a>

### GEDCOM X Field Types

The GEDCOM X Field Types specification enumerates a set of field types for use in exchanging field-based genealogical record data.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx-record/blob/master/specifications/field-types-specification.md">GEDCOM X Field Types</a>

-------------------------------

## Web Service Specifications

### GEDCOM X Atom Extensions

The GEDCOM X Atom Extensions specification specifies a set of genealogical data extensions to RFC 4287, The Atom Syndication Format.

<a class="btn btn-default btn-lg" href="https://github.com/FamilySearch/gedcomx-rs/blob/master/specifications/atom-model-specification.md">GEDCOM X Atom Extensions</a>

### GEDCOM X RS

The GEDCOM X RS specification defines a standard interface for a genealogical data application on the World Wide Web.

<a href="https://github.com/FamilySearch/gedcomx-rs/blob/master/specifications/rs-specification.md">GEDCOM X RS</a>
