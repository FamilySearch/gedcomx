# The GEDCOM X Standard Header Set

## Status

This document specifies a standard set of headers used to supply metadata for
genealogical resources such as those defined by the
[GEDCOM X standard conceptual model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md),
and requests discussion and suggestions for improvements.

The current state of this document is as a "stable draft", and as such, the document
may be subject to limited changes, BUT NOT backwards-incompatible changes, according to the
discussion and suggestions for improvement.

## Copyright Notice

Copyright 2011-2013 Intellectual Reserve, Inc.

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

This specification depends on [RFC 822](http://www.w3.org/Protocols/rfc822/) to define the mechanism
for supplying headers.

This specification depends on the GEDCOM X Date Format identified
by [`http://gedcomx.org/date/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md).

This specification imports some of the [HTTP Standard Headers](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html)
as defined by [RFC 2616](http://tools.ietf.org/html/rfc2616).

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
according to the [GEDCOM X Date Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md).

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
X-DC-created | date | Date of creation of the resource, as defined by [http://purl.org/dc/terms/created](http://dublincore.org/documents/dcmi-terms/#terms-created).
X-DC-creator | URI | Identifier for an entity primarily responsible for making the resource, as defined by [http://purl.org/dc/terms/creator](http://dublincore.org/documents/dcmi-terms/#terms-creator).
X-DC-conformsTo | URI | Identifier for an established standard to which the described resource conforms, as defined by [http://purl.org/dc/terms/conformsTo](http://dublincore.org/documents/dcmi-terms/#terms-conformsTo).
X-DC-modified | date | Date on which the resource was changed, as defined by [http://purl.org/dc/terms/modified](http://dublincore.org/documents/dcmi-terms/#terms-modified).
