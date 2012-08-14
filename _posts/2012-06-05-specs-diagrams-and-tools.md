---
title: Specs, Diagrams, and Illustrations
date: 2012-06-05 14:13:00
layout: default
author: Ryan Heaton
---

We're glad to (finally!) announce the availability of some additional resources
that we're hoping will make the GEDCOM X project more accessible and available
to everybody.

Formal Specification Documents
------------------------------

Until now, there weren't really any formal specification documents for
GEDCOM X--it was all being built and formalized in Java source code and 
we used an open-source toolset to generate documentation from that code. 

But things are different now. GEDCOM X is now formally specified by a 
[new set of documents](http://gedcomx.org/Specs.html) that we've made 
available. They're still in draft form, and there's probably some 
precision that still needs to be added, but we think this goes a long way
toward helping people understand what we're trying to do here.

We hope it opens up further discussion, too. Please 
[don't be shy](http://www.gedcomx.org/Community.html).

Diagrams and Illustrations
--------------------------

We've had some [requests for UML diagrams](https://github.com/FamilySearch/gedcomx/issues/114). 
We're maintaining [a UML diagram](http://familysearch.github.com/gedcomx/uml/conceptual-model.png)
of the [GEDCOM X conceptual model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md) 
using [ArgoUML](http://argouml.tigris.org/). The ArgoUML project is 
[checked into version control](https://github.com/FamilySearch/gedcomx/blob/master/specifications/support/gedcomx.zargo),
and we'd love some help making it better. Send us a [pull request](https://help.github.com/articles/using-pull-requests).

Community member [CMEliasz-Solomon](https://github.com/CMEliasz-Solomon) suggested that
[Graphic Syntax Diagrams](http://en.wikipedia.org/wiki/Syntax_diagram) were a good way to 
illustrate GEDCOM X. So we thought we'd give it a try:

* [Conclusion Model](http://familysearch.github.com/gedcomx/rr/conclusion/index.html)
* [Source Model](http://familysearch.github.com/gedcomx/rr/sources/index.html)
* [Contributor Model](http://familysearch.github.com/gedcomx/rr/contributor/index.html)

These were generated from some [EBNF](http://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_Form) documents 
using a tool called [Clapham](http://sourceforge.net/projects/clapham/). We've 
[checked the bnf documents into version control](https://github.com/FamilySearch/gedcomx/tree/master/specifications/support),
and (again) we'd love some help making it better. Send us a [pull request](https://help.github.com/articles/using-pull-requests).
