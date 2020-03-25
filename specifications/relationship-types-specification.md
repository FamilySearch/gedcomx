# GEDCOM X Event Types

## Status

This document enumerates a set of event types to be used for genealogical data exchange,
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

The GEDCOM X Relationship Types spec specifies a set of enumerated values that identify common relationship types that are relevant to genealogical research. 
A "relationship" is a relationship between two persons. The spec includes notational conventions, relationship types, and the URI reference used to identify 
relationship types.

# 1. Introduction

An enumeration of types of relationships provides the means for descriptions of relationships to
be semantically processed by applications, rather than being only interpreted by people. This
specification provides such an enumeration by identifying specific relationship types and defining
the semantic significance of each type.

## 1.1 Identifier and Version

The identifier for this specification is:

`http://gedcomx.org/relationship-types/v1`

For convenience, this specification may be referred to as "GEDCOM X Relationship Types 1.0".
This specification uses "GEDCOM X Relationship Types" internally.

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

# 2. Relationship Types

The following relationship types are specified:

URI | description
----|-------------
`http://gedcomx.org/AncestorDescendant`| A relationship from an ancestor to a descendant.
`http://gedcomx.org/Couple`| A relationship of a pair of persons.
`http://gedcomx.org/EnslavedBy`| A relationship from an enslaved person to the enslaver or slaveholder of the person.
`http://gedcomx.org/Godparent`| A relationship from a godparent to a person.
`http://gedcomx.org/ParentChild`| A relationship from a parent to a child.
