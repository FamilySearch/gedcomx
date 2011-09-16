---
title: GEDCOM X 0.5.0 Released
date: 2011-09-16 11:50:00
---

GEDCOM X 0.5.0 has been released.

* There was some consolidation of the type names so that types are now in the `http://gedcomx.org/` namespace 
  and type names have been capitalized to conform to convention.
* The notion of a [Family](http://www.gedcomx.org/namespaces/gxc_el_family.html) was added to support the
  grouping of two parents and a list of children.
* The notion of a [Note](http://www.gedcomx.org/namespaces/gx_Note.html) was added to support collaboration
  among contributors that want to add a note without having to modify the data values.
* The [JSON](http://json.org) serialization format was formalized with regards to extension elements. For
  more information, see [JSON Format](http://www.gedcomx.org/JSON-Format.html).
