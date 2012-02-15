---
title: GEDCOM X 0.3.0 Released
date: 2011-08-04 12:04:00
layout: default
---

GEDCOM X 0.3.0 has been released.

The primary feature of this release is support for the [GEDCOM X File Format](http://www.gedcomx.org/File-Format.html),
designed to be the replacement for [GEDCOM 5.5](https://devnet.familysearch.org/docs/gedcom/gedcom55.pdf). There is
also a new project for [reading and writing the file format in Java](https://github.com/FamilySearch/gedcomx-fileformat-java).

Other changes include the following:

* [Support for some additional types](https://github.com/FamilySearch/gedcomx/commit/48cbe9b88618846f66b19d9f67ca80bbf3a7da7c)
  that are known to be needed for record processing.
* [Renaming 'fieldId' to 'label'](https://github.com/FamilySearch/gedcomx/commit/c8b0d5693f27fc01fbfde3f7eed35839fb235296)
  per [issue #43](https://github.com/FamilySearch/gedcomx/issues/43)
* [Attribution added to relationship and event role](https://github.com/FamilySearch/gedcomx/commit/8ea41a7980d47eff4fd52de3a5cf516fbefcead4)
  per [issue #28](https://github.com/FamilySearch/gedcomx/issues/28)
* [Bibliographic citation added to record, record collection, person, and relationship](https://github.com/FamilySearch/gedcomx/commit/2a49d491370fdca08c266dba8534a609e66bf85d)
* [Adding language code to record](https://github.com/FamilySearch/gedcomx/commit/34f6c7f00d85663e71cdda89a084c430b095e59c)
  per [issue #51](https://github.com/FamilySearch/gedcomx/issues/51)

Enjoy!
