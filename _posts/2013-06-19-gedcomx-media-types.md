---
title: The GEDCOM X Media Types
date: 2013-06-19 10:23:00
layout: default
author: Ryan Heaton
---

GEDCOM X is fundamentally about getting computers to exchange genealogical data with other computers. To this end, GEDCOM X specifies a set of media types. The intent of this post is to discuss what a media type _is_, what it _isn't_, and why an understanding of media types is important for you and for the project.

# Media Types

A media type is a definition of a way for a computer to interpret a stream of 1's and 0's. Because humans have to be able to program a computer to interpret that stream of 1's and 0's, a media type specification has to define the concepts and data types that are represented by that stream. We'll refer to the set of concepts and types as a "data model." In addition to the data model, a media type has to provide some kind of identifier. This identifier can also be referred to as the "MIME type" or "content type."

Here are some media types that you're probably familiar with:

identifier | data model
-----------|-----------
`text/html` | Web Page
`image/jpeg` | JPEG Image
`audio/mpeg` | MP3 Audio
`application/pdf` | PDF Document

The GEDCOM X project provides a set of media types for genealogical data communications. Like all media types, the GEDCOM X media types (XML and JSON) use a specific data model. The [GEDCOM X conceptual model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md) specifies the GEDCOM X data model, but it does not define a media type. The [XML](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md) and the [JSON](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md) media type specifications each define a media type by providing an identifier ("application/x-gedcomx-v1+xml" and "application/x-gedcomx-v1+json") and defining how the data model is serialized using XML and JSON respectively.

# The One-Data-Model Myth

Because the GEDCOM X data model is not designed for anything other than exchanging genealogical data between computers, this data model has a single, narrowly-scoped purpose. That purpose is to define the way a computer can interpret a bit stream that conforms to a GEDCOM X media type.

The data model defined by GEDCOM X has a single, narrowly-scoped purpose: to define the way a computer can interpret a stream of 1's and 0's that conforms to a GEDCOM X media type. The GEDCOM X data model is not designed for anything other than exchanging genealogical data between computers.

The scope of the GEDCOM X data model is really important to remember. When we forget that we're limiting the scope to data exchange, we start getting into heavy arguments about which data model is the _one best_ model for genealogical data. The problem with trying to design the _one best_ data model is that it doesn't exist. It's a myth. Every architect values certain aspects of genealogical data over others, and every product needs to optimize its own data model according to its own requirements.

One of the reasons for a number of stalled efforts to define a new genealogical data exchange format is that the expeditions got lost in the desert chasing the mirage of a single, perfect data model. Focusing on a data model that is narrowly-scoped to the purposes of data exchange allows GEDCOM X to get the traction it needs to make progress.

I occasionally hear concerns about GEDCOM X that effectively boil down to a fear that it is an attempt to force all genealogical products on the planet to be overhauled in alignment with the [GEDCOM X conceptual model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md). This "one spec to rule them all" notion is frankly quite silly. GEDCOM X does not intend to impose its data model on any product.

Granted, if any product developers want to use _GEDCOM X_ to exchange data, they have to figure out how to best use the GEDCOM X data model to represent the data. But that concept is nothing new.

Let's consider HTML as an example. HTML is a media type. It has its own conceptual model and serialization format. A lot of people choose to use HTML to deliver their data and services to end users over the World Wide Web. HTML isn't the only media type designed for end-user interaction over the World Wide Web, but it is probably the most popular one. Even so, you hear a lot of complaints about HTML: it doesn't support this feature or that feature, it's awkward to use this element, or that attribute is misnamed. Many of those complaints have merit, but more often than not developers just shrug and live with HTML the way it is. The alternative is to use another media type and toolset.

Like HTML, each GEDCOM X media type has a data model and serialization format. GEDCOM X is certainly not the only way to exchange genealogical data, but it _is_ a good one. I'll be the first to admit that GEDCOM X is not perfect. It has its fair share of awkwardness, and there are some valid genealogical concepts that it hasn't addressed yet. Some of the gaps in GEDCOM X have been identified and may be addressed with future enhancements. Others may never be addressed.

Regardless of how GEDCOM X falls short of your ideal, if you are a genealogical data provider and you want to exchange data with other providers, GEDCOM X is a good choice for you. We've done a respectable job of gathering requirements both internal and external, and we've made our solution open and publicly available. Sure, it has its flaws, and we can do more to fill in the gaps in the project and build out the toolset. These realities need to be considered as part of your media type decision.

Keep in mind that FamilySearch is successfully using the GEDCOM X media types to exchange genealogical data. Of course, we're not _exclusively_ using GEDCOM X because it's not designed to exchange every type of data in the world. To exchange images, for example, we might use the [JPEG media type](http://en.wikipedia.org/wiki/Jpeg). Furthermore, just because FamilySearch is using GEDCOM X for data exchange doesn't mean that we're imposing the GEDCOM X data model on all of our products. Each product has its own data model that is optimized for its own requirements. But when data needs to be _exchanged_, GEDCOM X is used.

We invite you to use GEDCOM X to exchange genealogical data. It's a good choice. Give it some thought.
