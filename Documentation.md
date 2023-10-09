---
layout: default
title: GEDCOM X Documentation
---

# The Primer

The [GEDCOM X Primer](Primer.html) is being developed to provide an overview of GEDCOM X and how it can be used to represent genealogical data.

# The Specifications

GEDCOM X is really just a set of specifications, so the first thing you have to do is identify which ones
you care about. For the complete specification set, refer to [Specifications](Specifications.html), but here are some of
the most relevant to developers:

* [The GEDCOM X Conceptual Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md) specifies an abstract conceptual model for genealogical data, independent of any serialization format.
* [The GEDCOM X XML Serialization Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md) specifies how to represent the conceptual model in XML.
* [The GEDCOM X JSON Serialization Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md) specifies how to represent the conceptual model in JSON.
* [The GEDCOM X File Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md) specifies how to bundle up genealogical data into a file.

# Recipe Book

The [GEDCOM X Recipe Book](Recipe-Book.html) provides a set of practical examples that demonstrate how GEDCOM X can be used to capture
data from the genealogical research process.

# Code

There might be some code that you could use to start development. And as you develop, we'd love you to contribute your
tools and libraries back to the community. Visit [Code](Code.html) for more information.

# Schemas

GEDCOM X provides [some semantic definitions](schemas.html) of the GEDCOM X conceptual model for use in structured data (e.g. RDFa, Microdata, JSON-LD, etc.).
