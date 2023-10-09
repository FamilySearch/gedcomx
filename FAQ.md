---
layout: default
title: GEDCOM X Frequently Asked Questions
---

# Frequently Asked Questions

* Is GEDCOM X backwards-compatible? Can GEDCOM X be read by consumers of legacy GEDCOM?

  No, a new parser is needed. But there is a lossless conversion from legacy GEDCOM to GEDCOM X. And there are
  [open source libraries](Code.html) available for working with GEDCOM X to help ease the pain of migration.

* Does GEDCOM X define a file format so I can save my data on my computer and work with it using my favorite applications?

  [Yes](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md). And it's designed to address
  the major issues with legacy GEDCOM such as the lack of a well-defined source model, insufficient support for the
  [proof standard](https://wiki.familysearch.org/en/Genealogical_Proof_Standard), and no way to enclose multimedia files
  (e.g. images, audio, video, etc.).

  See [file-format-specification](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md).

* How do I contribute? What if GEDCOM X is missing something?

  We'd love to have you participate! Have you checked out the [community documentation](Community.html)?

* What licenses govern GEDCOM X?

  Code is opened under an [Apache II](http://www.apache.org/licenses/LICENSE-2.0.html) license. Other content is licensed under
  a [Creative Commons Attribution-ShareAlike 3.0 Unported License](http://creativecommons.org/licenses/by-sa/3.0/).

* What's the governance model for GEDCOM X?

  The project is being managed in an [open source](http://en.wikipedia.org/wiki/Open_source) manner with
  requirements and contributions being provided by [the community](Community.html). The licenses are open and the process is
  transparent, and [feedback](https://github.com/FamilySearch/gedcomx/issues) is readily invited.
  [FamilySearch](http://familysearch.org) is the current admin for the project.

* What's up with the name "GEDCOM X"?

  Well...

  * "GEDCOM X" denotes a clean break from "legacy" GEDCOM and clearly communicates a new revision that is
   different in scope and technology.
  * "GEDCOM X" doesn't imply a project-level versioning scheme, making it convenient as an  "umbrella" name for sections
   that can each be revisioned independently.
  * The "X" is a loosely-coupled reference to "XML", which is a major technology being used to define the standard.
  * The "X" has a generally accepted reference to the 'x' in "next", implying the "next" generation of a genealogical tools and specifications.
  * The "X" has a precedent in the genealogical space, e.g. "Generation X".
  * The "X" has a precedent in the technology space, being used quite successfully to denote a new version or platform or
    system, e.g. "Apple OS X", "Droid X", "X11", and all over the place by the W3C.
  * The "X" is simple, brief, one-syllable, and easy to pronounce.
