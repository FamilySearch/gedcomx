---
title: GEDCOM X Representation of Birth Information
date: 2014-03-07 15:00:00
layout: default
author: Ryan Heaton
---

This post is part of an initiative to improve the available documentation of GEDCOM X. This particular post describes how birth-like information found during a research activity might be represented using GEDCOM X.

## Summary

During research for Emma Bocock (born 1843, daughter of William and Sarah Bocock, in Sheffield, Yorkshire, England), a researcher uses Free BMD Birth Index, 1837-1915 to locate and order a birth record from the General Registry Office at Southport, England.  The record is described by providing a title, citation, and other metadata. Information about the birth, the name, father, mother, etc. is extracted from the record. The extracted information is assembled together with information extracted from other records to aggregate what is presumed to be known about Emma Bocock.

## Gathering the Information

A researcher receives a copy of a birth record from the General Registry Office at Southport, England. The following is a partial digital image of the record, smudged to avoid copyright issues:

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

The researcher analyzes the birth record within the context of the other records of Emma Bocock she has found. She writes an analysis document that details her conclusions of the identity of Emma Bocock.

## Representing the Information

The information gathered is represented using GEDCOM X as follows:

### Create the GEDCOM X Root Document

All GEDCOM X information is contained within a "root" document. When the document is created, the software being used by the researcher provides information about who can be attributed the information.

The following snippet demonstrates how a root document is initialized in both XML and JSON. The information within the document is dated March 7, 2014 and attributed to a user named "Jane Doe" with an e-mail address of "example@example.org". An instance of the [`Agent`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#agent) data type is provided to describe the contributor, and an instance of the [`Attribution`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#attribution) data type is provided to attribute the information to the contributor.

#### XML

```xml
<gedcomx xmlns="http://gedcomx.org/v1/">
    ...
    <attribution>
        <contributor resource="#A-1"/>
        <modified>2014-03-07T00:00:00-07:00</modified>
    </attribution>
    ...
    <agent id="A-1">
        <email resource="mailto:example@example.org"/>
        <name>Jane Doe</name>
    </agent>
    ...
</gedcomx>
```

#### JSON

```json
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
```

### The Source Description

The source is represented by providing an instance of the [`SourceDescription`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-description) data type in the root document. The following snippet demonstrates how the source is represented in both XML and JSON. The source description includes a title, a citation, a created date, and a reference to the General Registry Office, which is represented using an [`Agent`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#agent).

#### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<gedcomx xmlns="http://gedcomx.org/v1/">
    ...
    <sourceDescription resourceType="http://gedcomx.org/PhysicalArtifact" id="S-1">
        <citation>
            <value>England, birth certificate for Emma Bocock, born 23 July 1843; citing 1843 Birth in District and Sub-district of Ecclesall-Bierlow in the County of York, 303; General Registry Office, Southport.</value>
        </citation>
        <title>Birth Certificate of Emma Bocock, 23 July 1843, General Registry Office</title>
        <created>1843-07-27T00:00:00-07:00</created>
        <repository resource="#A-2"/>
    </sourceDescription>
    ...
    <agent id="A-2">
        <name>General Registry Office, Southport</name>
    </agent>
    ...
</gedcomx>
```

#### JSON

```json
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
```

### The Extracted Information

The information that is extracted from the source is represented as persons and relationships. An instance of the [`Person`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#person) data type provides person information and an instance of the [`Relationship`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#relationship) data type provides relationship information.

The following snippet demonstrates how the extracted information is represented in both XML and JSON. Each person is designated as `extracted` because the information was extracted from a single source. Each person includes a name, an id, and a reference to the source. The birth information is included on the principal person, and the occupation information is included on the father.

#### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<gedcomx xmlns="http://gedcomx.org/v1/">
    ...
    <person extracted="true" id="P-1">
        <source description="#S-1"/>
        <gender type="http://gedcomx.org/Female"/>
        <name>
            <nameForm>
                <fullText>Emma Bocock</fullText>
            </nameForm>
        </name>
        <fact type="http://gedcomx.org/Birth">
            <date>
                <original>23 June 1843</original>
            </date>
            <place>
                <original>Broadfield Bar, Abbeydale Road, Ecclesall-Bierlow, York, England, United Kingdom</original>
            </place>
        </fact>
    </person>
    <person extracted="true" id="P-2">
        <source description="#S-1"/>
        <name>
            <nameForm>
                <fullText>William Bocock</fullText>
            </nameForm>
        </name>
        <fact type="http://gedcomx.org/Occupation">
            <value>Toll Collector</value>
        </fact>
    </person>
    <person extracted="true" id="P-3">
        <source description="#S-1"/>
        <name>
            <nameForm>
                <fullText>Sarah Bocock formerly Brough</fullText>
            </nameForm>
        </name>
    </person>
    ...
    <relationship type="http://gedcomx.org/ParentChild">
        <person1 resource="#P-2"/>
        <person2 resource="#P-1"/>
    </relationship>
    <relationship type="http://gedcomx.org/ParentChild">
        <person1 resource="#P-3"/>
        <person2 resource="#P-1"/>
    </relationship>
    ...
</gedcomx>
```

#### JSON

```json
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
```

### The Analysis

Following good research process practices, the researcher writes up a document that describes her analysis of the information about Emma Bocock that was discovered. Presumably, other sources in addition to the birth record were located and their analysis would be included in the document.

The aggregated analysis, including the text of the document, is represented with another [`Person`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#person) that references the extracted information as evidence using instances of [`EvidenceReference`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#evidence-reference). The following snippet demonstrates how the analysis is represented in both XML and JSON.

#### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<gedcomx xmlns="http://gedcomx.org/v1/">
    ...
    <person id="C-1">
        ...
        <analysis resource="#D-1"/>
        ...
        <evidence resource="#P-1"/>
        ...
    </person>
    ...
    <document id="D-1">
        <text>...Jane Doe's analysis document...</text>
    </document>
    ...
</gedcomx>
```

#### JSON

```json
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
```

### The Result

Here are the XML and JSON representations of the use case described above.

#### XML

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<gedcomx xmlns="http://gedcomx.org/v1/">
    <attribution>
        <contributor resource="#A-1"/>
        <modified>2014-03-07T00:00:00-07:00</modified>
    </attribution>
    <person extracted="true" id="P-1">
        <source description="#S-1"/>
        <gender type="http://gedcomx.org/Female"/>
        <name>
            <nameForm>
                <fullText>Emma Bocock</fullText>
            </nameForm>
        </name>
        <fact type="http://gedcomx.org/Birth">
            <date>
                <original>23 June 1843</original>
            </date>
            <place>
                <original>Broadfield Bar, Abbeydale Road, Ecclesall-Bierlow, York, England, United Kingdom</original>
            </place>
        </fact>
    </person>
    <person extracted="true" id="P-2">
        <source description="#S-1"/>
        <name>
            <nameForm>
                <fullText>William Bocock</fullText>
            </nameForm>
        </name>
        <fact type="http://gedcomx.org/Occupation">
            <value>Toll Collector</value>
        </fact>
    </person>
    <person extracted="true" id="P-3">
        <source description="#S-1"/>
        <name>
            <nameForm>
                <fullText>Sarah Bocock formerly Brough</fullText>
            </nameForm>
        </name>
    </person>
    <person id="C-1">
        <analysis resource="#D-1"/>
        <evidence resource="#P-1"/>
    </person>
    <relationship type="http://gedcomx.org/ParentChild">
        <person1 resource="#P-2"/>
        <person2 resource="#P-1"/>
    </relationship>
    <relationship type="http://gedcomx.org/ParentChild">
        <person1 resource="#P-3"/>
        <person2 resource="#P-1"/>
    </relationship>
    <sourceDescription resourceType="http://gedcomx.org/PhysicalArtifact" id="S-1">
        <citation>
            <value>England, birth certificate for Emma Bocock, born 23 July 1843; citing 1843 Birth in District and Sub-district of Ecclesall-Bierlow in the County of York, 303; General Registry Office, Southport.</value>
        </citation>
        <title>Birth Certificate of Emma Bocock, 23 July 1843, General Registry Office</title>
        <created>1843-07-27T00:00:00-07:00</created>
        <repository resource="#A-2"/>
    </sourceDescription>
    <agent id="A-1">
        <email resource="mailto:example@example.org"/>
        <name>Jane Doe</name>
    </agent>
    <agent id="A-2">
        <name>General Registry Office, Southport</name>
    </agent>
    <document id="D-1">
        <text>...Jane Doe's analysis document...</text>
    </document>
</gedcomx>
```

#### JSON

```json
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
```

## Code Examples

[This Java code example](https://github.com/FamilySearch/gedcomx-java/blob/master/gedcomx-model/src/test/java/org/gedcomx/examples/EmmaBocockExampleTest.java#L25), found in [`gedcomx-java`](https://github.com/FamilySearch/gedcomx) repository demonstrates how to produce the above result.

## Extra Credit

* Multiple values for different languages may be provided for the title and citation. This example only provides one value for each and does not specify language.
* In addition to the name of the repository, other information about the repository may be provided, such as address, web page, e-mail, phone number, etc. This example only provides a name.
* Analysis documents for the source
* Saving the digital image instead of describing the physical artifact.
* Name parts
* Formal date
* Place description
* Informant
* HTML representation
