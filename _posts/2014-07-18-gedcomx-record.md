---
title: Introducing GEDCOM X Record Extensions
date: 2014-07-18 15:10:00
layout: default
author: Ryan Heaton
---

Of all of the different types of genealogical data, the most valuable is record data. "Record data" refers to digital images of
original records and the data that is directly extracted from those images.

At [FamilySearch](https://familysearch.org/), we've got a lot of record data. The exchange of this record data is at the core of
most of our partnerships with other entities, such as [Ancestry](http://www.ancestry.com/), 
[MyHeritage](http://www.myheritage.com/), and [FindMyPast](https://www.findmypast.com/). [GEDCOM X](http://gedcomx.org) defines the
data format and exchange mechanism that is used to share data among partners, but the 
[GEDCOM X Core Specification set](http://www.gedcomx.org/Specifications.html) doesn't account for some of the nuances of the data 
provided by large-scale extraction efforts, such as [FamilySearch Indexing](https://familysearch.org/indexing/).

The [GEDCOM X Record Extensions specification](https://github.com/FamilySearch/gedcomx-record/blob/master/specifications/record-specification.md)
has been developed to define extensions to the GEDCOM X Core Specification set for exchanging of field-based record data. The
first draft of the GEDCOM X Record Extensions specification is complete. The specification will continue to mature as it undergoes
copy edits and peer review, but the substance of the specification is considered to be solidified.

The Record Extensions define additional data types (including their XML and JSON forms) and extension properties to the core data types.
For example:

* The `Collection` data type is defined by the GEDCOM X Record Extensions specification for the purposes of describing a collection of
  records. The `Collection` data type is comprised of a title and some metadata about the size of the collection and the types of data
  contained by the collection. An example of a collection that can be described using the `Collection` data type is the 1940 U.S. Census.
* The `Field` data type is defined by the GEDCOM X Record Extensions specification to describe a specific "field" in a record from which
  data was extracted. Fields are bounded regions of a record, such as a rectangle of a digital image that contains the name of a person.
  According to the record extensions specification, a standard GEDCOM X data set can be extended to include the fields from which the data 
  was extracted. For example, fields might be added to a name, gender, or fact of a person.

For more information about the GEDCOM X Record Extensions, your questions and feedback are welcome at the 
[Record Extensions Github Project](https://github.com/FamilySearch/gedcomx-record) or at the 
[GEDCOM X users and developers list](https://groups.google.com/forum/#!forum/gedcomx).