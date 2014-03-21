---
title: GEDCOM X Representation of Birth Information
date: 2014-03-21 15:00:00
layout: default
author: Ryan Heaton
---

This post is part of an initiative to improve the available documentation of GEDCOM X. This particular post describes how birth-like information found during a research activity might be represented using GEDCOM X.

## Summary

During research for Emma Bocock (born 1843, daughter of William and Sarah Bocock, in Sheffield, Yorkshire, England), a researcher uses Free BMD Birth Index, 1837-1915 to locate and order a birth record from the General Registry Office at Southport, England.  The record is described by providing a title, citation, and other metadata. Information about the birth, the name, father, mother, etc., is extracted from the record. The extracted information is assembled together with information extracted from other records to aggregate what is presumed to be known about Emma Bocock.

## Gathering the Information

A researcher receives a copy of a birth record from the General Registry Office at Southport, England. The following is a partial digital image of the record, smudged to avoid copyright issues:

![Birth Record, Emma Bocock, GRO](http://familysearch.github.io/gedcomx/img/gro-birth-record-emma-bocock.png)

#### Describing the Source

The record is described as a source with the following information:

<table class="table table-striped table-condensed">
<thead>
  <tr>
    <th>name</th>
    <th>value</th>
    <th>provided by</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>Source Title</td>
    <td>Birth Certificate of Emma Bocock, 23 July 1843, General Registry Office</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Source Citation</td>
    <td>England, birth certificate for Emma Bocock, born 23 July 1843; citing 1843 Birth in District and Sub-district of Ecclesall-Bierlow in the County of York, 303; General Registry Office, Southport.</td>
    <td>User, possibly aided by software.</td>
  </tr>
  <tr>
    <td>Repository Name</td>
    <td>General Registry Office, Southport</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Source Type</td>
    <td>Physical Artifact</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Source Creation Date</td>
    <td>27 July 1843</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Source Id</td>
    <td>S-1</td>
    <td>Software</td>
  </tr>
</tbody>
</table>

#### Extracting the Information

The researcher extracts the following information from the source:

<table class="table table-striped table-condensed">
<thead>
  <tr>
    <th>description</th>
    <th>value</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>Event Type</td>
    <td>Birth</td>
  </tr>
  <tr>
    <td>Event Date</td>
    <td>23 June 1843</td>
  </tr>
  <tr>
    <td>Event Place</td>
    <td>Broadfield Bar, Abbeydale Road, Ecclesall-Bierlow, York, England, United Kingdom</td>
  </tr>
  <tr>
    <td>Child’s Name</td>
    <td>Emma Bocock</td>
  </tr>
  <tr>
    <td>Child's Gender</td>
    <td>Female</td>
  </tr>
  <tr>
    <td>Father’s Name</td>
    <td>William Bocock</td>
  </tr>
  <tr>
    <td>Mother’s Name</td>
    <td>Sarah Bocock formerly Brough</td>
  </tr>
  <tr>
    <td>Father’s Occupation</td>
    <td>Toll Collector</td>
  </tr>
  <tr>
    <td>Signature, Description and Residence of Informant</td>
    <td>William Bocock, Father, Broadfield Bar, Abbeydale Road</td>
  </tr>
</tbody>
</table>

#### Analyzing the Information

The researcher analyzes the birth record within the context of the other records of Emma Bocock she has found. She writes an analysis document that details her conclusions of the identity of Emma Bocock.

## Representing the Information

The information gathered is represented using GEDCOM X as follows:

#### Create the GEDCOM X Root Document

All GEDCOM X information is contained within a "root" document. When the document is created, the software being used by the researcher provides information about who can be attributed the information.

The following snippet demonstrates how a root document is initialized in both XML and JSON. The information within the document is dated March 7, 2014 and attributed to a user named "Jane Doe" with an e-mail address of "example@example.org". An instance of the [`Agent`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#agent) data type is provided to describe the contributor, and an instance of the [`Attribution`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#attribution) data type is provided to attribute the information to the contributor.

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    ...
    &lt;attribution>
        &lt;contributor resource="#A-1"/>
        &lt;modified>2014-03-07T00:00:00-07:00&lt;/modified>
    &lt;/attribution>
    ...
    &lt;agent id="A-1">
        &lt;email resource="mailto:example@example.org"/>
        &lt;name>Jane Doe&lt;/name>
    &lt;/agent>
    ...
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "attribution" : {
    "contributor" : {
      "resource" : "#A-1"
    },
    "modified" : 1394175600000
  },
  ...
  "agents" : [ {
    "names" : [ {
      "value" : "Jane Doe"
    } ],
    "emails" : [ {
      "resource" : "mailto:example@example.org"
    } ],
    "id" : "A-1"
  }, ... ]
}
</pre>

#### The Source Description

The source is represented by providing an instance of the [`SourceDescription`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-description) data type in the root document. The following snippet demonstrates how the source is represented in both XML and JSON. The source description includes a title, a citation, a created date, and a reference to the General Registry Office, which is represented using an [`Agent`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#agent).

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?>
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    ...
    &lt;sourceDescription resourceType="http://gedcomx.org/PhysicalArtifact" id="S-1">
        &lt;citation>
            &lt;value>England, birth certificate for Emma Bocock, born 23 July 1843; citing 1843 Birth in District and Sub-district of Ecclesall-Bierlow in the County of York, 303; General Registry Office, Southport.&lt;/value>
        &lt;/citation>
        &lt;title>Birth Certificate of Emma Bocock, 23 July 1843, General Registry Office&lt;/title>
        &lt;created>1843-07-27T00:00:00-07:00&lt;/created>
        &lt;repository resource="#A-2"/>
    &lt;/sourceDescription>
    ...
    &lt;agent id="A-2">
        &lt;name>General Registry Office, Southport&lt;/name>
    &lt;/agent>
    ...
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  ...
  "sourceDescriptions" : [ {
    "resourceType" : "http://gedcomx.org/PhysicalArtifact",
    "citations" : [ {
      "value" : "England, birth certificate for Emma Bocock, born 23 July 1843; citing 1843 Birth in District and Sub-district of Ecclesall-Bierlow in the County of York, 303; General Registry Office, Southport."
    } ],
    "titles" : [ {
      "value" : "Birth Certificate of Emma Bocock, 23 July 1843, General Registry Office"
    } ],
    "created" : -3989840400000,
    "repository" : {
      "resource" : "#A-2"
    },
    "id" : "S-1"
  } ],
  "agents" : [ {
    "names" : [ {
      "value" : "General Registry Office, Southport"
    } ],
    "id" : "A-2"
  }, ... ]
}
</pre>

#### The Extracted Information

The information that is extracted from the source is represented as persons and relationships. An instance of the [`Person`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#person) data type provides person information and an instance of the [`Relationship`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#relationship) data type provides relationship information.

The following snippet demonstrates how the extracted information is represented in both XML and JSON. Each person is designated as `extracted` because the information was extracted from a single source. Each person includes a name, an id, and a reference to the source. The birth information is included on the principal person, and the occupation information is included on the father.

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?>
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    ...
    &lt;person extracted="true" id="P-1">
        &lt;source description="#S-1"/>
        &lt;gender type="http://gedcomx.org/Female"/>
        &lt;name>
            &lt;nameForm>
                &lt;fullText>Emma Bocock&lt;/fullText>
            &lt;/nameForm>
        &lt;/name>
        &lt;fact type="http://gedcomx.org/Birth">
            &lt;date>
                &lt;original>23 June 1843&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>Broadfield Bar, Abbeydale Road, Ecclesall-Bierlow, York, England, United Kingdom&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/person>
    &lt;person extracted="true" id="P-2">
        &lt;source description="#S-1"/>
        &lt;name>
            &lt;nameForm>
                &lt;fullText>William Bocock&lt;/fullText>
            &lt;/nameForm>
        &lt;/name>
        &lt;fact type="http://gedcomx.org/Occupation">
            &lt;value>Toll Collector&lt;/value>
        &lt;/fact>
    &lt;/person>
    &lt;person extracted="true" id="P-3">
        &lt;source description="#S-1"/>
        &lt;name>
            &lt;nameForm>
                &lt;fullText>Sarah Bocock formerly Brough&lt;/fullText>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
    ...
    &lt;relationship type="http://gedcomx.org/ParentChild">
        &lt;person1 resource="#P-2"/>
        &lt;person2 resource="#P-1"/>
    &lt;/relationship>
    &lt;relationship type="http://gedcomx.org/ParentChild">
        &lt;person1 resource="#P-3"/>
        &lt;person2 resource="#P-1"/>
    &lt;/relationship>
    ...
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  ...
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "fullText" : "Emma Bocock"
      } ]
    } ],
    "gender" : {
      "type" : "http://gedcomx.org/Female"
    },
    "facts" : [ {
      "type" : "http://gedcomx.org/Birth",
      "date" : {
        "original" : "23 June 1843"
      },
      "place" : {
        "original" : "Broadfield Bar, Abbeydale Road, Ecclesall-Bierlow, York, England, United Kingdom"
      }
    } ],
    "extracted" : true,
    "sources" : [ {
      "description" : "#S-1"
    } ],
    "id" : "P-1"
  }, {
    "names" : [ {
      "nameForms" : [ {
        "fullText" : "William Bocock"
      } ]
    } ],
    "facts" : [ {
      "value" : "Toll Collector",
      "type" : "http://gedcomx.org/Occupation"
    } ],
    "extracted" : true,
    "sources" : [ {
      "description" : "#S-1"
    } ],
    "id" : "P-2"
  }, {
    "names" : [ {
      "nameForms" : [ {
        "fullText" : "Sarah Bocock formerly Brough"
      } ]
    } ],
    "extracted" : true,
    "sources" : [ {
      "description" : "#S-1"
    } ],
    "id" : "P-3"
  }, ... ],
  "relationships" : [ {
    "type" : "http://gedcomx.org/ParentChild",
    "person1" : {
      "resource" : "#P-2"
    },
    "person2" : {
      "resource" : "#P-1"
    }
  }, {
    "type" : "http://gedcomx.org/ParentChild",
    "person1" : {
      "resource" : "#P-3"
    },
    "person2" : {
      "resource" : "#P-1"
    }
  } ],
  ...
}
</pre>

#### The Analysis

Following good research process practices, the researcher writes up a document that describes her analysis of the information about Emma Bocock that was discovered. Presumably, other sources in addition to the birth record were located and their analysis would be included in the document.

The aggregated analysis, including the text of the document, is represented with another [`Person`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#person) that references the extracted information as evidence using instances of [`EvidenceReference`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#evidence-reference). The following snippet demonstrates how the analysis is represented in both XML and JSON.

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?>
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    ...
    &lt;person id="C-1">
        ...
        &lt;analysis resource="#D-1"/>
        ...
        &lt;evidence resource="#P-1"/>
        ...
    &lt;/person>
    ...
    &lt;document id="D-1">
        &lt;text>...Jane Doe's analysis document...&lt;/text>
    &lt;/document>
    ...
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ ... , {
    "evidence" : [ {
      "resource" : "#P-1"
    } ],
    "analysis" : {
      "resource" : "#D-1"
    },
    "id" : "C-1"
  } ],
  ...
  "documents" : [ {
    "text" : "...Jane Doe's analysis document...",
    "id" : "D-1"
  } ]
}
</pre>

#### The Result

Here are the XML and JSON representations of the use case described above.

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?>
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;attribution>
        &lt;contributor resource="#A-1"/>
        &lt;modified>2014-03-07T00:00:00-07:00&lt;/modified>
    &lt;/attribution>
    &lt;person extracted="true" id="P-1">
        &lt;source description="#S-1"/>
        &lt;gender type="http://gedcomx.org/Female"/>
        &lt;name>
            &lt;nameForm>
                &lt;fullText>Emma Bocock&lt;/fullText>
            &lt;/nameForm>
        &lt;/name>
        &lt;fact type="http://gedcomx.org/Birth">
            &lt;date>
                &lt;original>23 June 1843&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>Broadfield Bar, Abbeydale Road, Ecclesall-Bierlow, York, England, United Kingdom&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/person>
    &lt;person extracted="true" id="P-2">
        &lt;source description="#S-1"/>
        &lt;name>
            &lt;nameForm>
                &lt;fullText>William Bocock&lt;/fullText>
            &lt;/nameForm>
        &lt;/name>
        &lt;fact type="http://gedcomx.org/Occupation">
            &lt;value>Toll Collector&lt;/value>
        &lt;/fact>
    &lt;/person>
    &lt;person extracted="true" id="P-3">
        &lt;source description="#S-1"/>
        &lt;name>
            &lt;nameForm>
                &lt;fullText>Sarah Bocock formerly Brough&lt;/fullText>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
    &lt;person id="C-1">
        &lt;analysis resource="#D-1"/>
        &lt;evidence resource="#P-1"/>
    &lt;/person>
    &lt;relationship type="http://gedcomx.org/ParentChild">
        &lt;person1 resource="#P-2"/>
        &lt;person2 resource="#P-1"/>
    &lt;/relationship>
    &lt;relationship type="http://gedcomx.org/ParentChild">
        &lt;person1 resource="#P-3"/>
        &lt;person2 resource="#P-1"/>
    &lt;/relationship>
    &lt;sourceDescription resourceType="http://gedcomx.org/PhysicalArtifact" id="S-1">
        &lt;citation>
            &lt;value>England, birth certificate for Emma Bocock, born 23 July 1843; citing 1843 Birth in District and Sub-district of Ecclesall-Bierlow in the County of York, 303; General Registry Office, Southport.&lt;/value>
        &lt;/citation>
        &lt;title>Birth Certificate of Emma Bocock, 23 July 1843, General Registry Office&lt;/title>
        &lt;created>1843-07-27T00:00:00-07:00&lt;/created>
        &lt;repository resource="#A-2"/>
    &lt;/sourceDescription>
    &lt;agent id="A-1">
        &lt;email resource="mailto:example@example.org"/>
        &lt;name>Jane Doe&lt;/name>
    &lt;/agent>
    &lt;agent id="A-2">
        &lt;name>General Registry Office, Southport&lt;/name>
    &lt;/agent>
    &lt;document id="D-1">
        &lt;text>...Jane Doe's analysis document...&lt;/text>
    &lt;/document>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "attribution" : {
    "contributor" : {
      "resource" : "#A-1"
    },
    "modified" : 1394175600000
  },
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "fullText" : "Emma Bocock"
      } ]
    } ],
    "gender" : {
      "type" : "http://gedcomx.org/Female"
    },
    "facts" : [ {
      "type" : "http://gedcomx.org/Birth",
      "date" : {
        "original" : "23 June 1843"
      },
      "place" : {
        "original" : "Broadfield Bar, Abbeydale Road, Ecclesall-Bierlow, York, England, United Kingdom"
      }
    } ],
    "extracted" : true,
    "sources" : [ {
      "description" : "#S-1"
    } ],
    "id" : "P-1"
  }, {
    "names" : [ {
      "nameForms" : [ {
        "fullText" : "William Bocock"
      } ]
    } ],
    "facts" : [ {
      "value" : "Toll Collector",
      "type" : "http://gedcomx.org/Occupation"
    } ],
    "extracted" : true,
    "sources" : [ {
      "description" : "#S-1"
    } ],
    "id" : "P-2"
  }, {
    "names" : [ {
      "nameForms" : [ {
        "fullText" : "Sarah Bocock formerly Brough"
      } ]
    } ],
    "extracted" : true,
    "sources" : [ {
      "description" : "#S-1"
    } ],
    "id" : "P-3"
  }, {
    "evidence" : [ {
      "resource" : "#P-1"
    } ],
    "analysis" : {
      "resource" : "#D-1"
    },
    "id" : "C-1"
  } ],
  "relationships" : [ {
    "type" : "http://gedcomx.org/ParentChild",
    "person1" : {
      "resource" : "#P-2"
    },
    "person2" : {
      "resource" : "#P-1"
    }
  }, {
    "type" : "http://gedcomx.org/ParentChild",
    "person1" : {
      "resource" : "#P-3"
    },
    "person2" : {
      "resource" : "#P-1"
    }
  } ],
  "sourceDescriptions" : [ {
    "resourceType" : "http://gedcomx.org/PhysicalArtifact",
    "citations" : [ {
      "value" : "England, birth certificate for Emma Bocock, born 23 July 1843; citing 1843 Birth in District and Sub-district of Ecclesall-Bierlow in the County of York, 303; General Registry Office, Southport."
    } ],
    "titles" : [ {
      "value" : "Birth Certificate of Emma Bocock, 23 July 1843, General Registry Office"
    } ],
    "created" : -3989840400000,
    "repository" : {
      "resource" : "#A-2"
    },
    "id" : "S-1"
  } ],
  "agents" : [ {
    "names" : [ {
      "value" : "Jane Doe"
    } ],
    "emails" : [ {
      "resource" : "mailto:example@example.org"
    } ],
    "id" : "A-1"
  }, {
    "names" : [ {
      "value" : "General Registry Office, Southport"
    } ],
    "id" : "A-2"
  } ],
  "documents" : [ {
    "text" : "...Jane Doe's analysis document...",
    "id" : "D-1"
  } ]
}
</pre>

## Code Examples

[This Java code example](https://github.com/FamilySearch/gedcomx-java/blob/master/gedcomx-model/src/test/java/org/gedcomx/examples/EmmaBocockExampleTest.java#L25), found in [`gedcomx-java`](https://github.com/FamilySearch/gedcomx) repository demonstrates how to produce the above result.

## Extra Credit

Here are some other elements that a GEDCOM X processor may want to provide. These items were left out of the above example for the sake of brevity.

* Multiple values for different languages may be provided for the title and citation of a source. In such a case, the "lang" property on each title and citation may be used to specify the language of the text using [BCP 47](http://tools.ietf.org/html/bcp47). For more information, see the section [about Internationalization Considerations](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#i18n). See also the [Source Description](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-description) data type and its associated representations in [XML](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md#source-description) and [JSON](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md#source-description).
* In addition to the name of the repository, other information about the repository may be provided, such as address, web page, e-mail, phone number, etc. For more information, see the [Agent](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#agent) data type and its associated representations in [XML](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md#agent) and [JSON](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md#agent).
* In addition to an analysis document for the researcher's conclusions about Emma Bocock, a researcher may also want to provide a document containing an analysis of the birth certificate itself, perhaps describing the informant, whether the source is primary or secondary, etc. For such purposes, the [Source Description](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-description) data type provides an `analysis` property that can resolve to an analysis [document](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#document).
* Some software allows the researcher to provide a digital image of the source that can be included in the data set and displayed along with the extracted information. In such a case, descriptions of _two_ sources would be provided: one for the physical birth certificate, and one for the scanned image of the birth certificate. The latter description would reference the former as a source using the `sources` property of the [Source Description](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-description), and reference the digital image by its URI using the `about` property. If the researcher wished to export the data, the digital image would be bundled up with the XML using the [GEDCOM X File Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md).
* When providing a name of a person, the software may wish to prompt the user for the parts of a name in addition to (or instead of) the full text of the name. In such a case, the parts can be provided using the `parts` property of the [Name](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name) data type.
* When providing a date (such as the birth date), the software may wish to prompt the user for a specific "formalized" date value in addition to the text of the date of the birth certificate. In such a case, the formal date can be provided using the `formal` property of the [Date](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#date) data type, which conforms to the [GEDCOM X Date Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/date-format-specification.md).
* When providing information about a place, the software may be able to prompt the user for specifics about the place, such as it's jurisdictions, geo-coordinates, name variants, etc. In such a case, an instance of a [Place Description](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#place-description) can be provided in the document, which can be referenced using the `descriptionRef` property of the [Place Reference](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#conclusion-place-reference) data type.
* When writing an analysis document, some software may allow the researcher to apply fonts, formatting and styles. In such a case, the text of the document can specify a `textType` property with the value of "xhtml".
