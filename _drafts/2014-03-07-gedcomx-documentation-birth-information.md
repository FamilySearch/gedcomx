---
title: GEDCOM X Representation of Birth Information
date: 2014-03-07 15:00:00
layout: default
author: Ryan Heaton
---

This post is part of an initiative to improve the available documentation of GEDCOM X. This particular post describes how birth-like information found during a research activity might be represented using GEDCOM X.

## Summary

During research of Emma Bocock (born 1843, daughter of William and Sarah Bocock), a researcher finds a birth record at the General Registry Office at Southport, England. The record is described by providing a title, citation, and other metadata. Information about the birth, the name, father, mother, etc. is extracted from the record. The extracted information is assembled together with information extracted from other records to aggregate what is presumed to be known about Emma Bocock.

## Gathering the Information

A researcher finds a birth record at the General Registry Office at Southport, England. The following is a digital image of the record, smudged to avoid copyright issues for the sake of this document:

![Birth Record, Emma Bocock, GRO](http://familysearch.github.io/gedcomx/img/gro-birth-record-emma-bocock.png)

### Describing the Source

The record is described as a source with the following information:

name|value|provided by
----|-----|-----
Source Title|Birth Certificate of Emma Bocock, 23 July 1843, General Registry Office|User
Source Citation|England, birth certificate for Emma Bocock, born 23 July 1843; citing 1843 Birth in District and Sub-district of Ecclesall-Bierlow in the County of York, 303; General Registry Office, Southport.|User, possibly aided by software.
Repository Name|General Registry Office, Southport|User
Source Type|Physical Artifact|User
Source Creation Date|27 July 1843|User
Source Id|S-1|Software

### Extracting the Information

The researcher extracts the following information from the source:

description|value
-----------|-----
Event Type|Birth
Event Date|23 June 1843
Event Place|Broadfield Bar, Abbeydale Road, Ecclesall-Bierlow, York, England, United Kingdom
Child’s Name|Emma Bocock
Child's Gender|Female
Father’s Name|William Bocock
Mother’s Name|Sarah Bocock formerly Brough
Father’s Occupation|Toll Collector
Signature, Description and Residence of Informant|William Bocock, Father, Broadfield Bar, Abbeydale Road

### Analyzing the Information

The researcher analyzes the birth record within the context of the other records of Emma Bocock she has found. She writes an analysis document that details her conclusions of the identity Emma Bocock.

## Representing the Information

The information gathered is represented using GEDCOM X as follows:

### Create the GEDCOM X Root Document

All GEDCOM X information is contained within a "root" document. When the document is created, the software being used by the researcher provides information about the researcher to whom the information can be attributed.

The following document snippets demonstrate how a root document is initialized in both XML and JSON. The information within the document is dated March 7, 2014 and attributed to a user named "Jane Doe" with an e-mail address of "example@example.org".

#### XML

```xml
<gedcomx xmlns="http://gedcomx.org/v1/">
  <attribution>
    <contributor resource="#A-1"/>
    <modified>2014-03-07</modified>
  <attribution>
  ...
  <agent id="A-1">
    <name>Jane Doe</name>
    <email resource="mailto:example@example.org"/>
  </agent>
  ...
</gedcomx>
```

#### JSON

```json
{
  "attribution" : {
    "modified" : 1394232645539,
    "contributor" : {
      "resource" : "#A-1"
    }
  }

  ...

  "agents" : [ {
    "id" : "A-1",
    "names" : [ {
      "value" : "Jane Doe"
    } ],
    "emails" : [ {
      "resource" : "mailto:example@example.org"
    } ]
  } ],

  ...
}
```

### The Source Description

todo:

### The Extracted Information

todo:

### The Analysis

todo:


## Extra Credit

* Multiple values for different languages may be provided for the title and citation. This example only provides one value for each and does not specify language.
* In addition to the name of the repository, other information about the repository may be provided, such as address, web page, e-mail, phone number, etc. This example only provides a name.
* Analysis documents for the source
* Saving the digital image instead of describing the physical artifact.
* 
