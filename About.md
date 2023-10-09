---
layout: default
title: About GEDCOM X
---

Genealogy work is complicated.

It's nice that we have computers to help us manage complex work, but that puts a big responsibility
on software developers to create the right tools to do the job well.

In the past, genealogical software was primarily used to manage somebody's family tree. In order to
share those conclusions with their family or to the data to a another computer, the conclusions
had to be saved to a disk. GEDCOM was the name of the standard way to save that data to disk.

The world has shifted. Computers are being used more broadly across all aspects of the genealogical
research process. With the arrival of the Internet and the World Wide Web, genealogists are using
computers to:

* Make records available online as digital artifacts
* Extract and annotate online artifacts so as to make them searchable
* Search for records and other genealogical information
* Make conclusions based on sound evidence found in records
* Support conclusions by accurately citing the sources of the evidence
* Identify contradictory evidence and alternate theories
* Share and collaborate on genealogy work

The GEDCOM X project encompasses a set of specifications, libraries, and tools that can be used to
exchange the data for these kinds of activities.

A Long Time Coming
------------------

A lot of things have evolved with genealogical technology since the original GEDCOM format
was provided. Genealogical applications aren't just about making conclusions anymore. Indeed,
a much more sound research philosophy focuses more on records and evidence than it does
on making conclusions. Furthermore, with the advent of powerful search engines, software as a
service (SaaS) offerings, and social networking applications, the legacy GEDCOM model just isn't
going to cut it anymore.

Up through 2010, FamilySearch had been busy with other important things, like online access to their
huge collection of records. But around 2010 a lot of notable events--including the sprouting of some
impressive standardization efforts--came together to raise the priority of a new GEDCOM. By the end of
[RootsTech](http://rootstech.org/) 2011, it became clear that the community needed something new.

Project Scope
-------------

The goal of GEDCOM X is to define an open data model and an open serialization format for exchanging the
genealogical data essential to the [genealogical research process](GEDCOM-X-and-the-Genealogical-Research-Process.html).

Nobody's going to blame you if you think that sounds a lot like legacy GEDCOM. The difference
between GEDCOM X and legacy GEDCOM isn't so much in the project scope as much as it is in the capacity to
achieve the same goals with the latest tools and technologies.

A ferryboat may have goals similar to those of a ten-lane cable-stayed bridge, but the latter has
significantly greater potential and capacity.

Built to Last
-------------

One of the primary design considerations of GEDCOM X is to meet the needs of the latest trends in
software development. GEDCOM X is built from it's foundation to support the agile needs and growing demands of
developers for a wide variety of products, including desktop record managers, online data providers, web-based
search engines and mobile applications.

Models, Formats, and Extensions
-------------------------------

The GEDCOM X [Conceptual Model](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md)
defines the genealogical data types with their associated properties. Specific serialization formats (e.g.
[XML](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md),
[JSON](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md)) are defined to describe
how the data is written to a file or exchanged over the Internet. You may also be interested in learning more about
how [GEDCOM X is being extended](Extensions.html) to provide for additional use cases, such as [Web service APIs](https://github.com/FamilySearch/gedcomx-rs),
[field-based record data extracted from digital images](https://github.com/FamilySearch/gedcomx-record), and
[citation fields and citation templates](https://github.com/FamilySearch/gedcomx-citation).

Here for the Long Term
----------------------

GEDCOM X is designed for the long-term. Through [solid design principles](http://en.wikipedia.org/wiki/Solid_%28object-oriented_design%29)
and engagement with the [community](Community.html), GEDCOM X hopes to become a well-established mechanism for providing a
rich and collaborative environment for the noble work of genealogical research.

Welcome!