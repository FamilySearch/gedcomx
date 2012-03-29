---
title: The Identity of GEDCOM X
date: 2012-03-23 11:16:00
layout: default
---

We're excited to say that we've been given additional resources to keep GEDCOM X
moving forward. This includes five new members of the GEDCOM X team at FamilySearch. These new 
resources will allow us to more actively engage the community with reasonable vigor and agility.

Thanks to some valuable feedback from the community, we've been active in refactoring the 
GEDCOM X project to better reflect the concepts that the members of the community are
used to seeing and discussing. We'd like to invite you to visit [gedcomx.org](http://www.gedcomx.org/Home.html),
where you'll see some of the results of this refactor. We hope you'll like the changes.

Project Purpose and Scope
-------------------------

The purpose of GEDCOM X has been stated as:

> To define an open data model and an open serialization format for exchanging the 
> components of the genealogical proof standard.

The genealogical proof standard has been articulated and defined by the 
[Board for Certification of Genealogists](http://www.bcgcertification.org/resources/standard.html).
Around here, we also like to refer to the [Genealogy Research Process Map](http://www.thinkgenealogy.com/map/)
that software architect and family historian [Mark Tucker](http://www.thinkgenealogy.com/) put together.
Here's how Mark articulates the proof standard:

* Search Reliable Sources
* Cite Each Source
* Analyze Sources, Information, and Evidence
* Resolve Conflicts
* Make a Soundly-Reasoned Conclusion

That's what GEDCOM X is trying to enable. If you think this sounds a lot like legacy GEDCOM,
nobody's going to blame you. The difference between GEDCOM X and legacy GEDCOM isn't so much the project scope 
as it is the capacity to achieve the same goals with the latest tools and technologies.

A ferryboat may have goals similar to those of a ten-lane cable-stayed bridge, but the latter has
significantly greater potential and capacity.

Even so, some might find the purpose of the GEDCOM X project to be kind of boring. Maybe you were
hoping for a model for stating research goals. Or maybe you'd like to see a standard Web service 
interface for genealogical data. Or maybe you'd like to see how large-scale, field-based record data
can be exchanged between clients that do image extraction.

That's where extension projects come in.

GEDCOM X Extension Projects
---------------------------

GEDCOM X is designed from ground up to be extensible. We'd like to introduce the two extension
projects that we've identified so far today:

*   [Web Services Extension](http://rs.gedcomx.org)

    The GEDCOM X Web services extension (i.e. "GEDCOM X RS") defines a standard Web service API for 
    genealogical data. This API is defined as a set of [RESTful](http://en.wikipedia.org/wiki/Representational_State_Transfer) 
    Web resources, the links between those resources, the HTTP operations that are applicable to those resources, 
    and the standard inputs and outputs that can be expected from invoking those operations.

*   [Record Extension](http://record.gedcomx.org)

    The GEDCOM X record extension provides the data structures that are used to model the results of large-scale, 
    field-based extraction of record data from digital images.

Coming Soon...
--------------

We've got pretty exciting stuff that's currently in development. This includes things like conversion utilities
from legacy GEDCOM to GEDCOM X, a GEDCOM X reference implementation, and some fun client applications. We're looking 
forward to showing it all to you, but give us a bit of time to make it presentable.

We won't make you wait too long.

Submit Your Feedback
--------------------

We'd love to hear your thoughts on some of the things we're working through right now. Would you be willing
to fill out a brief feedback form? We're just asking for three things:

1. What are the top five biggest holes in GEDCOM 5.5 that you'd like to see addressed in GEDCOM X?
2. There are currently two active proposals for the new GEDCOM X file format:  a text-editor-friendly MIME multipart;
   or a binary, indexed, zip-based bundle. Which do you prefer and why?
3. What kind of feedback do you have for us at this point in the project?

That won't take too long, will it?

[Click here to fill out the form.](http://familysearch.github.com/gedcomx/feedback/2012-03-23.html) And thank you!
