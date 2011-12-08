---
title: GEDCOM X 0.6.0
date: 2011-12-08 12:06:00
---

Wow. Has it really been _three months_ since we cut the last release?

Yes. Yes it has. Sad, but true.

## What Happened?

As the momentum of the GEDCOM X project started gathering, we realized internally at FamilySearch that we needed
to decide how seriously we were dedicated to a standard initiative. We were developing an industry standard
at the same time that we were applying resources to proprietary projects and internal APIs. It soon became apparent
that a reconciliation was needed.

So the GEDCOM X project was effectively put on hold as we grappled internally with some tough questions, including:

* Are we really committed to the development and maintainance of an open industry standard? 
* What resources are we dedicating to standards development?
* What is the timeline for the release of a standard and a viable reference implementation?

After a lot of internal disruption and realignment, we're excited to state definitively that FamilySearch is truly
committed to the development and maintenance of this standards effort. We've taken the time to align our internal 
model with the GEDCOM X standard. Announcements about a release timeline will come at a later time.

## Changes Since 0.5.0

As a result of the alignment of the FamilySearch model to the new standard, there were some refinements and changes
applied to the standard model that we think are better aligned to the direction of the genealogical development 
industry. These changes have been discussed and applied with the release of 0.6.0 and are summarized in three sections
as follows.

### Event, EventRole, Characteristic are Now Fact

After lengthy discussions [as documented](https://github.com/FamilySearch/gedcomx/pull/99) 
[in](https://github.com/FamilySearch/gedcomx/issues/84) [multiple](https://github.com/FamilySearch/gedcomx/issues/85) 
[threads](https://github.com/FamilySearch/gedcomx/issues/97), it was decided that a more generic notion of the concept 
of `Fact` was more useful to genealogical developers than it was to distinguish between facts that are `Event`s and
facts that are `Characteristic`s. The `Fact` is used to model a fact about the life of a person or relationship and 
defines properties that hold the date, place, and "value" of the fact.

While the change was largely precipitated by the conclusion model, it was decided expedient to apply consistent 
conceptual changes in the record model. `Event`, `EventRole`, and `Characteristic` were collapsed into a single
`Fact` object. `Fact` is also used to model record-level fields. Analysis of the historical usage of the record 
model concluded that it was more useful to scope `Fact`s to the persona or relationship than it was to have a "shared"
`Fact` or `Event` that was common to all personas in the record.

### Resource Definitions

The process for defining resources was formalized and an initial set of resources were defined to seed the development
of a standard REST API. Annotations are used to describe resource definitions that document the relationships that
resources have with other resources, the standard HTTP operations that are applicable to each resource, and the
errors and warnings that are possibly when changing the state of the application.

Details still to follow....


### Miscellaneous Changes

* The concepts of a genealogical resource and a genealogical entity [were extracted](https://github.com/FamilySearch/gedcomx/commit/f8df10c292e197af2c6aedf971e9855e1aa8e063) for the sake of conceptual abstraction.
* The [type reference mechanism was adjusted](https://github.com/FamilySearch/gedcomx/commit/e28da0f59aa0167f5af5300b0e85b79548895452) to conform to the RDF standard.
* [FOAF](http://www.foaf-project.org/) was leveraged to describe genealogical contributors per [issue 22](https://github.com/FamilySearch/gedcomx/issues/22)
* The [record collection was made more generic](https://github.com/FamilySearch/gedcomx/commit/0de4f69d1289085c98b32346bf48bae76558ff8d) to support collections of things other than record.
* [Additional name types were identified](https://github.com/FamilySearch/gedcomx/commit/f969785e561eb1e4b9aaedf0536da125b3f833e4).
* The notion of a [person summary](http://gedcomx.org/model/gxc_PersonSummary.html) was introduced to model a resource that defines a summary of a conclusion person.
* [A `living` flag was added to a conclusion person](https://github.com/FamilySearch/gedcomx/commit/697bf3ab04ba0dcd71f4e0f27aad6e9fe6966b50) to model the way the conclusion person is being considered by the system.
* [The concepts of `original`, `interpreted`, and `normalized` were clarified and the `normalized` property was renamed to `processed` to reflect its purpose and usage](https://github.com/FamilySearch/gedcomx/commit/2b39e0f3746e1d6a57a5f12bb888752c7fab6353).
