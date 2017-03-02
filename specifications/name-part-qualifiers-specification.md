# GEDCOM X Name Part Qualifiers

## Status

This document enumerates a set of name part qualifiers to be used for genealogical data exchange,
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

The GEDCOM X Name Part Qualifiers spec provides a set of enumerated values that identify common qualifiers of name parts that are relevant to genealogical research. The spec includes notational conventions, the URI reference, and name part qualifiers. 

# 1. Introduction

An enumeration of name part qualifiers provides the means for parts of names of persons to
be described and qualified in such a way so as to be semantically processed by applications,
rather than being only interpreted by people. This specification provides such an enumeration
by identifying specific name part qualifiers and defining the semantic significance of each
qualifier.

A name part qualifier may be used to identify how the name part was used by the person to which the name
applies. For example, a name part qualifier may specify that a given name part was used by the person
as a `Title`.

## 1.1 Identifier and Version

The identifier for this specification is:

`http://gedcomx.org/name-part-qualifiers/v1`

For convenience, this specification may be referred to as "GEDCOM X Name Part Qualifiers 1.0".
This specification uses "GEDCOM X Name Part Qualifiers" internally.

## 1.2 Notational Conventions

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

## 1.2.1 The URI Reference

The Uniform Resource Identifier ("URI") is used to identify event types. The URI is
specified by [RFC 3986](http://tools.ietf.org/html/rfc3986). This specification uses the term
"URI" to refer to both a "URI" and a "URI Reference" as defined by
[RFC 3986](http://tools.ietf.org/html/rfc3986).

# 2. Name Part Qualifiers

The following name part qualifiers are specified. Note that in addition to the name of the qualifier,
the definition of a qualifier includes an optional `value` property. Included in the definition of each name
part qualifier is information about whether the `value` property should be used.

URI | description
----|-------------
`http://gedcomx.org/Title`|A designation for honorifics (e.g. Dr., Rev., His Majesty, Haji), ranks (e.g. Colonel, General, Knight, Esquire), positions (e.g. Count, Chief, Father, King) or other titles (e.g., PhD, MD). Name part qualifiers of type `Title` SHOULD NOT provide a value.
`http://gedcomx.org/Primary`|A designation for the name of most prominent in importance among the names of that type (e.g., the primary given name). Name part qualifiers of type `Primary` SHOULD NOT provide a value.
`http://gedcomx.org/Secondary`|A designation for a name that is not primary in its importance among the names of that type (e.g., a secondary given name). Name part qualifiers of type `Secondary` SHOULD NOT provide a value.
`http://gedcomx.org/Middle`|A designation useful for cultures that designate a middle name that is distinct from a given name and a surname. Name part qualifiers of type `Middle` SHOULD NOT provide a value.
`http://gedcomx.org/Familiar`|A designation for one's familiar name. Name part qualifiers of type `Familiar` SHOULD NOT provide a value.
`http://gedcomx.org/Religious`|A designation for a name given for religious purposes. Name part qualifiers of type `Religious` SHOULD NOT provide a value.
`http://gedcomx.org/Family`|A name that associates a person with a group, such as a clan, tribe, or patriarchal hierarchy. Name part qualifiers of type `Family` SHOULD NOT provide a value.
`http://gedcomx.org/Maiden`|A designation given by women to their original surname after they adopt a new surname upon marriage. Name part qualifiers of type `Maiden` SHOULD NOT provide a value.
`http://gedcomx.org/Patronymic`|A name derived from a father or paternal ancestor. Name part qualifiers of type `Patronymic` SHOULD NOT provide a value.
`http://gedcomx.org/Matronymic`|A name derived from a mother or maternal ancestor. Name part qualifiers of type `Matronymic` SHOULD NOT provide a value.
`http://gedcomx.org/Geographic`|A name derived from associated geography. Name part qualifiers of type `Geographic` SHOULD NOT provide a value.
`http://gedcomx.org/Occupational`|A name derived from one's occupation. Name part qualifiers of type `Occupational` SHOULD NOT provide a value.
`http://gedcomx.org/Characteristic`|A name derived from a characteristic. Name part qualifiers of type `Characteristic` SHOULD NOT provide a value.
`http://gedcomx.org/Postnom`|A name mandated by law for populations from Congo Free State / Belgian Congo / Congo / Democratic Republic of Congo (formerly Zaire). Name part qualifiers of type `Postnom` SHOULD NOT provide a value.
`http://gedcomx.org/Particle`|A grammatical designation for articles (a, the, dem, las, el, etc.), prepositions (of, from, aus, zu, op, etc.), initials, annotations (e.g. twin, wife of, infant, unknown), comparators (e.g. Junior, Senior, younger, little), ordinals (e.g. III, eighth), descendancy words (e.g. ben, ibn, bat, bin, bint, bar), and conjunctions (e.g. and, or, nee, ou, y, o, ne, &amp;). Name part qualifiers of type `Particle` SHOULD NOT provide a value.
`http://gedcomx.org/RootName`|The "root" of a name part as distinguished from prefixes or suffixes. For example, the root of the Polish name "Wilkówna" is "Wilk". A `RootName` qualifier MUST provide a `value` property.
