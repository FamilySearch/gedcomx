---
title: GEDCOM X Semantic Schema Definitions
date: 2015-10-06 11:00:00
layout: default
author: Ryan Heaton
---

The [semantic web](http://www.w3.org/standards/semanticweb/) is a concept that has been around for almost as long as the World Wide Web itself. The hope of the semantic web is to provide structured data with each resource on the Web such that software can be written to _understand_ the data in addition to display it to users.

While the full realization of the semantic web faces some challenges and inhibitors, there have been some successful applications of some of its concepts. One of the most notable applications might be the [schema.org](http://schema.org/) initiative which provides semantic schema definitions for many of the most common [Thing](http://schema.org/Thing)s that are described on the Web today.

Now available are some [semantic schema definitions](http://www.gedcomx.org/schemas.html) for the GEDCOM X conceptual model.

These definition documents are really just a different encoding of the normative definitions provided by the [GEDCOM X Conceptual Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md) specification. The Conceptual Model Specification officially provides the canonical definitions, but these semantic schema documents will make it easier for structure data (e.g. RDFa, Microdata, JSON-LD) processors to use.

Following the lead of [schema.org](http://schema.org/), [RDFa](http://www.w3.org/TR/xhtml-rdfa-primer/) was chosen as the encoding for these schema definitions. It's easy to imagine other encodings of the definitions (e.g. Turtle, JSON-LD, RDF/XML), but we'll start with RDFa for now.

One of the nice benefits of this effort is that you don't get a "Not Found" error when you make HTTP requests to the various GEDCOM X data types and controlled vocabulary elements. Instead, the request resolves to one of these semantic schema definitions. For example, the [GEDCOM X Fact Types](https://github.com/FamilySearch/gedcomx/blob/master/specifications/fact-types-specification.md) specification defines a controlled vocabulary for the most common genealogical fact types. These fact types are identified by a URI (e.g. [`http://gedcomx.org/Birth`](http://gedcomx.org/Birth), [`http://gedcomx.org/Death`](http://gedcomx.org/Death), etc.), which now resolve to a real web page decorated with RDFa schema definition elements. The same concept applies to the data types provided by the Conceptual Model (e.g. [`http://gedcomx.org/v1/Person`](http://gedcomx.org/v1/Person)).
