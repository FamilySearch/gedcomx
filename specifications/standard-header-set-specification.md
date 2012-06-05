# The GEDCOM X Standard Header Set

## Status

This document specifies a standard set of headers used to supply metadata for
genealogical resources such as those defined by the
[GEDCOM X standard conceptual model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md),
and requests discussion and suggestions for improvements.

## Copyright Notice

Copyright 2011-2012 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

# 1. Introduction

When processing a set of genealogical resources (such as those defined by the
[GEDCOM X standard conceptual model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md))
it is often useful--sometimes even necessary--to process metadata for the resource before processing
it. Examples of this kind of metadata include:

* The data format for the resource.
* Caching directives such as the last modified timestamp or version.
* Identifiers for the resource.
* Bibliographic metadata, such as a bibliographic citation.
* Display names or titles.

The GEDCOM X Standard Header Set specifies the set of metadata terms that are
recognized for genealogical resources and the mechanism for providing that metadata.

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/headers/v1`

For convenience, this specification may be referred to as "GEDCOM X Standard Header Set 1.0".
This specification uses "GEDCOM X Headers" internally.

This specification is depends on the following standards and specifications:

* [RFC 822](http://www.w3.org/Protocols/rfc822/) defines the mechanism for supplying headers.
* Headers are specified for each of the [Dublin Core Terms](http://dublincore.org/documents/dcmi-terms/).
* Some of the [HTTP Standard Headers](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html) are
  imported by the GEDCOM X Standard Header Set.

## 1.2 Notational Conventions

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

# 2. Providing Headers

Headers are provided follow the same generic format as that given in Section 3.1 of
[RFC 822](http://www.w3.org/Protocols/rfc822/). Each header consists of a name
followed by a colon (":") and the header value. Header names are case-insensitive. The
value MAY be preceded by any amount of LWS, though a single SP is preferred.
Headers can be extended over multiple lines by preceding each extra line with at
least one SP or HT. The header values contain either text or combinations of token,
separators, and quoted-string as specified by RFC 822.

The order in which header fields with differing field names are received is not significant.

# 3. Header Values

Each header MAY supply multiple values. This is done either in a single name-value pair
by separating each value by a comma OR in multiple headers of the same name. Order of
the values MUST be preserved and MAY be significant based on the definition of the header.

## 3.1. Text Headers

Values of headers designated as text headers are to be interpreted as text.

## 3.2. URI Headers

Values of headers designated as URI headers are to be interpreted as a URI that
identifies the value of the metadata. For cases in which the value of the metadata
may not have an identifier except for its text value, the text value is
encoded according to the data URI scheme defined by [RFC 2397](http://tools.ietf.org/html/rfc2397).

## 3.3. Date Headers

Values of headers designated as date headers are to be interpreted as dates
according to [ISO 8601](http://en.wikipedia.org/wiki/ISO_8601).

# 4. The Standard Header Set

The GEDCOM X Standard Header Set includes the following headers:

name | value type | description
-----|------------|------------
Content-Type | text (media type) | The media type of the resource, as defined by [RFC 2616, Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
Content-Encoding | text | The encoding of the resource, as defined by [RFC 2616, Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
Content-Language | text | The language of the content of the resource, as defined by [RFC 2616, Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
Content-Length | text | The size of the resource, as defined by [RFC 2616, Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
Content-Location | text | The location of the resource, as defined by [RFC 2616, Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
Content-MD5 | text | The MD5 sum of the resource for integrity checks, as defined by [RFC 2616, Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
ETag | text | Version of the resource, as defined by [RFC 2616, Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
User-Agent | text | Information about the user agent originating the request or file, as defined by [RFC 2616, Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
X-DC-abstract | text | A summary of the resource, as defined by [http://purl.org/dc/terms/abstract](http://dublincore.org/documents/dcmi-terms/#terms-abstract).
X-DC-accessRights | URI | Identifier for information about who can access the resource or an indication of its security status, as defined by [http://purl.org/dc/terms/accessRights](http://dublincore.org/documents/dcmi-terms/#terms-accessRights).
X-DC-accrualMethod | URI | Identifier for the method by which items are added to a collection, as defined by [http://purl.org/dc/terms/accrualMethod](http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod).
X-DC-accrualPeriodicity | date | The frequency with which items are added to a collection, as defined by [http://purl.org/dc/terms/accrualPeriodicity](http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity).
X-DC-accrualPolicy | URI | Identifier for the policy governing the addition of items to a collection, as defined by [http://purl.org/dc/terms/accrualPolicy](http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy).
X-DC-alternative | text | An alternative name for the resource, as defined by [http://purl.org/dc/terms/alternative](http://dublincore.org/documents/dcmi-terms/#terms-alternative).
X-DC-audience | URI | Identifier for a class of entity for whom the resource is intended or useful, as defined by [http://purl.org/dc/terms/audience](http://dublincore.org/documents/dcmi-terms/#terms-audience).
X-DC-available | date | Date (often a range) that the resource became or will become available, as defined by [http://purl.org/dc/terms/available](http://dublincore.org/documents/dcmi-terms/#terms-available).
X-DC-bibliographicCitation | text | A bibliographic reference for the resource, as defined by [http://purl.org/dc/terms/bibliographicCitation](http://dublincore.org/documents/dcmi-terms/#terms-bibliographicCitation).
X-DC-conformsTo | URI | Identifier for an established standard to which the described resource conforms, as defined by [http://purl.org/dc/terms/conformsTo](http://dublincore.org/documents/dcmi-terms/#terms-conformsTo).
X-DC-contributor | URI | Identifier for an entity responsible for making contributions to the resource, as defined by [http://purl.org/dc/terms/contributor](http://dublincore.org/documents/dcmi-terms/#terms-contributor).
X-DC-coverage | text | The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant, as defined by [http://purl.org/dc/terms/coverage](http://dublincore.org/documents/dcmi-terms/#terms-coverage).
X-DC-created | date | Date of creation of the resource, as defined by [http://purl.org/dc/terms/created](http://dublincore.org/documents/dcmi-terms/#terms-created).
X-DC-creator | URI | Identifier for an entity primarily responsible for making the resource, as defined by [http://purl.org/dc/terms/creator](http://dublincore.org/documents/dcmi-terms/#terms-creator).
X-DC-date | date | A point or period of time associated with an event in the lifecycle of the resource, as defined by [http://purl.org/dc/terms/date](http://dublincore.org/documents/dcmi-terms/#terms-date).
X-DC-dateAccepted | date | Date of acceptance of the resource, as defined by [http://purl.org/dc/terms/dateAccepted](http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted).
X-DC-dateCopyrighted | date | Date of copyright, as defined by [http://purl.org/dc/terms/dateCopyrighted](http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted).
X-DC-dateSubmitted | date | Date of submission of the resource, as defined by [http://purl.org/dc/terms/dateSubmitted](http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted).
X-DC-description | text | An account of the resource, as defined by [http://purl.org/dc/terms/description](http://dublincore.org/documents/dcmi-terms/#terms-description).
X-DC-educationLevel | URI | Identifier for a class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended, as defined by [http://purl.org/dc/terms/educationLevel](http://dublincore.org/documents/dcmi-terms/#terms-educationLevel).
X-DC-extent | text | The size or duration of the resource, as defined by [http://purl.org/dc/terms/extent](http://dublincore.org/documents/dcmi-terms/#terms-extent).
X-DC-format | text | The file format, physical medium, or dimensions of the resource, as defined by [http://purl.org/dc/terms/format](http://dublincore.org/documents/dcmi-terms/#terms-format).
X-DC-hasFormat | URI | Identifier for a related resource that is substantially the same as the pre-existing described resource, but in another format, as defined by [http://purl.org/dc/terms/hasFormat](http://dublincore.org/documents/dcmi-terms/#terms-hasFormat).
X-DC-hasPart | URI | Identifier for a related resource that is included either physically or logically in the described resource, as defined by [http://purl.org/dc/terms/hasPart](http://dublincore.org/documents/dcmi-terms/#terms-hasPart).
X-DC-hasVersion | URI | Identifier for a related resource that is a version, edition, or adaptation of the described resource, as defined by [http://purl.org/dc/terms/hasVersion](http://dublincore.org/documents/dcmi-terms/#terms-hasVersion).
X-DC-identifier | text | An unambiguous reference to the resource within a given context, as defined by [http://purl.org/dc/terms/identifier](http://dublincore.org/documents/dcmi-terms/#terms-identifier).
X-DC-instructionalMethod | URI | Identifier for a process, used to engender knowledge, attitudes and skills, that the described resource is designed to support, as defined by [http://purl.org/dc/terms/instructionalMethod](http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod).
X-DC-isFormatOf | URI | Identifier for a related resource that is substantially the same as the described resource, but in another format, as defined by [http://purl.org/dc/terms/isFormatOf](http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf).
X-DC-isPartOf | URI | Identifier for a related resource in which the described resource is physically or logically included, as defined by [http://purl.org/dc/terms/isPartOf](http://dublincore.org/documents/dcmi-terms/#terms-isPartOf).
X-DC-isReferencedBy | URI | Identifier for a related resource that references, cites, or otherwise points to the described resource, as defined by [http://purl.org/dc/terms/isReferencedBy](http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy).
X-DC-isReplacedBy | URI | Identifier for a related resource that supplants, displaces, or supersedes the described resource, as defined by [http://purl.org/dc/terms/isReplacedBy](http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy).
X-DC-isRequiredBy | URI | Identifier for a related resource that requires the described resource to support its function, delivery, or coherence, as defined by [http://purl.org/dc/terms/isRequiredBy](http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy).
X-DC-issued | date | Date of formal issuance (e.g., publication) of the resource, as defined by [http://purl.org/dc/terms/issued](http://dublincore.org/documents/dcmi-terms/#terms-issued).
X-DC-isVersionOf | URI | Identifier for a related resource of which the described resource is a version, edition, or adaptation, as defined by [http://purl.org/dc/terms/isVersionOf](http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf).
X-DC-language | text | A language of the resource interpreted per RFC 4646, as defined by [http://purl.org/dc/terms/language](http://dublincore.org/documents/dcmi-terms/#terms-language).
X-DC-license | URI | Identifier for a legal document giving official permission to do something with the resource, as defined by [http://purl.org/dc/terms/license](http://dublincore.org/documents/dcmi-terms/#terms-license).
X-DC-mediator | URI | Identifier for an entity that mediates access to the resource and for whom the resource is intended or useful, as defined by [http://purl.org/dc/terms/mediator](http://dublincore.org/documents/dcmi-terms/#terms-mediator).
X-DC-medium | URI | Identifier for the material or physical carrier of the resource, as defined by [http://purl.org/dc/terms/medium](http://dublincore.org/documents/dcmi-terms/#terms-medium).
X-DC-modified | date | Date on which the resource was changed, as defined by [http://purl.org/dc/terms/modified](http://dublincore.org/documents/dcmi-terms/#terms-modified).
X-DC-provenance | text | A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation, as defined by [http://purl.org/dc/terms/provenance](http://dublincore.org/documents/dcmi-terms/#terms-provenance).
X-DC-publisher | URI | Identifier for an entity responsible for making the resource available, as defined by [http://purl.org/dc/terms/publisher](http://dublincore.org/documents/dcmi-terms/#terms-publisher).
X-DC-references | URI | Identifier for a related resource that is referenced, cited, or otherwise pointed to by the described resource, as defined by [http://purl.org/dc/terms/references](http://dublincore.org/documents/dcmi-terms/#terms-references).
X-DC-relation | URI | Identifier for a related resource, as defined by [http://purl.org/dc/terms/relation](http://dublincore.org/documents/dcmi-terms/#terms-relation).
X-DC-replaces | URI | Identifier for a related resource that is supplanted, displaced, or superseded by the described resource, as defined by [http://purl.org/dc/terms/replaces](http://dublincore.org/documents/dcmi-terms/#terms-replaces).
X-DC-requires | URI | Identifier for a related resource that is required by the described resource to support its function, delivery, or coherence, as defined by [http://purl.org/dc/terms/requires](http://dublincore.org/documents/dcmi-terms/#terms-requires).
X-DC-rights | URI | Identifier for information about rights held in and over the resource, as defined by [http://purl.org/dc/terms/rights](http://dublincore.org/documents/dcmi-terms/#terms-rights).
X-DC-rightsHolder | URI | Identifier for a person or organization owning or managing rights over the resource, as defined by [http://purl.org/dc/terms/rightsHolder](http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder).
X-DC-source | URI | Identifier for a related resource from which the described resource is derived, as defined by [http://purl.org/dc/terms/source](http://dublincore.org/documents/dcmi-terms/#terms-source).
X-DC-spatial | text | Spatial characteristics of the resource, as defined by [http://purl.org/dc/terms/spatial](http://dublincore.org/documents/dcmi-terms/#terms-spatial).
X-DC-subject | text | The topic of the resource, as defined by [http://purl.org/dc/terms/subject](http://dublincore.org/documents/dcmi-terms/#terms-subject).
X-DC-tableOfContents | URI | Identifier for a list of subunits of the resource, as defined by [http://purl.org/dc/terms/tableOfContents](http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents).
X-DC-temporal | text | Temporal characteristics of the resource, as defined by [http://purl.org/dc/terms/temporal](http://dublincore.org/documents/dcmi-terms/#terms-temporal).
X-DC-title | text | A name given to the resource, as defined by [http://purl.org/dc/terms/title](http://dublincore.org/documents/dcmi-terms/#terms-title).
X-DC-valid | date | Date (often a range) of validity of a resource, as defined by [http://purl.org/dc/terms/valid](http://dublincore.org/documents/dcmi-terms/#terms-valid).