# The GEDCOM X N-Tier Evidence Architecture

## Status

This document defines a concept called the "N-Tier Evidence Architecture" which consists of a set of principles
and rules that may be implemented by a genealogical data provider in support of the genealogical research process,
and requests discussion and suggestions for improvements.

The current state of this document is as a DRAFT, and as such, the document
may be subject to changes, including backwards-incompatible changes, according to the
discussion and suggestions for improvement.

## Copyright Notice

Copyright 2011-2012 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

# 1. Introduction

The N-Tier Evidence Architecture is a concept that consists of a set of principles
and rules that may be implemented by a genealogical data provider in support of the genealogical research process.

## 1.1 Identifier, Version, and Dependencies

The identifier for this specification is:

`http://gedcomx.org/n-tier-evidence-architecture/v1`

This specification depends on the conceptual model specification identified
by [`http://gedcomx.org/conceptual-model/v1`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).

## 1.2 Notational Conventions

### 1.2.1 Keywords

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT",
"SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this
document are to be interpreted as described in BCP 14,
[RFC2119](http://tools.ietf.org/html/rfc2119), as scoped to those conformance
targets.

### 1.2.2 Compliance

An implementation of the N-Tier Evidence Architecture is "non-compliant" if it fails to satisfy
one or more of the MUST or REQUIRED level requirements. An implementation that satisfies all of
the  MUST or REQUIRED and all of the SHOULD level requirements is said to be "unconditionally
compliant"; and implementation that satisfies all of the MUST level requirements but not all of the
SHOULD level requirements is said to be "conditionally compliant".

### 1.2.3 Joining Personas

When a researcher decides that two or more personas describe the same person, a new instance of `http://gedcomx.org/v1/Person` is created
that referenced each person by an identifier. The instance is said to "join" the personas.

### 1.2.4 Higher-Tier Person

An instance of the `http://gedcomx.org/v1/Person` data type that is used to join personas and/or other persons is referred to as
a "higher-tier person".

## 1.3 Examples

An application allows a researcher to extract information from a single census record about a person. The application assigns an identifier "abcde" to the
`persona` extracted from the census record. The researcher extracts additional information about a person from a birth certificate and the application
assigns identifier "fghij" to the `persona` extracted from the birth certificate. As the researcher gathers and analyzes evidence, she concludes that
`persona` "abcde" and `persona` "fghij" apply to the same person.

An application that implements the N-Tier Evidence Architecture creates a higher-tier person conclusion that includes two identifiers of type
`http://gedcomx.org/ComponentEvidence`: one that resolves to `persona` "abcde" and another that resolves to `persona` "fghij". The higher-tier person
MUST NOT cite any sources, and it SHOULD NOT contain any names, facts, or a gender except as to be used to resolve any conflicts between `persona`
"abcde" and `persona` "fghij".

# 2. Constraints

An N-Tier Evidence Architecture conforms to the following constraints:

* Personas MUST be maintained under the [Persona Constraints](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#persona-constraints)
  as defined by the [GEDCOM X Conceptual Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md).
* A higher-tier person SHOULD NOT repeat the data of its associated personas unless necessary to resolve conflicts.
* A higher-tier person MUST NOT have source references.
* A higher-tier person MAY join personas to personas, higher-tier persons to higher-tier persons, or higher-tier persons to personas.

## 2.1 Presentation of Higher-Tier Persons

When providing a consolidated view of the evidence gathered for a specific person, an application does so by assembling the data
of each persona and higher-tier that is joined by the higher-tier person.

### 2.1.1 Resolving Conflicts Between Personas

If there are conflicts between two personas that have been joined, the application uses data of each higher-tier person
to resolve them.

todo: fill in the details about how to resolve conflicts, taking into account confidence levels, data types and evidence type (e.g. direct, indirect, negative, etc.).

# 3. Data Types

## 3.1 The "Component Evidence" Identifier Type

The identifier type `http://gedcomx.org/ComponentEvidence` is used to model higher-tier persons in
an N-Tier Evidence Architecture. Each higher-tier person refers to its components by providing an identifier of type
`http://gedcomx.org/ComponentEvidence` that resolves to each persona or higher-tier person being joined. Personas MUST be
identified by setting the `persona` property to `true`.