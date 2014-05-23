---
title: GEDCOM X Representation of Miscellaneous Facts and Events
date: 2014-05-30 17:00:00
layout: default
author: Ryan Heaton
---

This post is part of an initiative to improve the available documentation of GEDCOM X. This particular post describes how the many varieties
of personal names might be represented using GEDCOM X. This post is also [available at gedcomx.org](http://www.gedcomx.org/recipe-misc-facts-events.html),
where you will find a link to propose edits or updates.

## Introduction

This guide is intended to supplement the information presented in the guides about
[birth-like information](http://familysearch.github.io/gedcomx//2014/03/21/gedcomx-documentation-birth-information.html),
[death-like information](http://familysearch.github.io/gedcomx//2014/04/04/gedcomx-documentation-death-information.html),
[marriage-like information](http://familysearch.github.io/gedcomx//2014/05/02/gedcomx-documentation-marriage-information.html),
and [personal names](http://familysearch.github.io/gedcomx//2014/05/16/gedcomx-documentation-names.html) to give a high-level
overview of the other types of facts and events that are able to be represented using GEDCOM X. In alignment with the genealogical
research process, the guides about
[birth-like](http://familysearch.github.io/gedcomx//2014/03/21/gedcomx-documentation-birth-information.html),
[death-like](http://familysearch.github.io/gedcomx//2014/04/04/gedcomx-documentation-death-information.html), and
[marriage-like](http://familysearch.github.io/gedcomx//2014/05/02/gedcomx-documentation-marriage-information.html) information
each follow a particular pattern for capturing genealogical research:

1. Describe the source.
2. Extract the information from the source.
3. Analyze the extracted information.

More details regarding how data from each of these steps can be represented using GEDCOM X will be provided in a separate guide.
This guide will not attempt to supply a narrative that provides the background for these other types of facts and
events&mdash;it is assumed that good genealogical research practices are followed as this type of information is captured.

## Census and Residence-Like Information

Researchers often find records that provide information about a person's residence. Perhaps the most obvious example is
a census record. Other records include immigration records, emigration records, land transactions, relocations, etc.

The following fact types are among those provided by the [GEDCOM X Fact Types](http://gedcomx.org/fact-types/v1) specification for
capturing residence-like information:

type | use case
-----|---------
`http://gedcomx.org/Census`| A person's participation in a census.
`http://gedcomx.org/Emigration`| A person's emigration.
`http://gedcomx.org/Heimat`| "Heimat" refers to a person's affiliation by birth to a specific geographic place. Distinct heimaten are often useful as indicators that two persons of the same name are not likely to be closely related genealogically. In English, "heimat" may be described using terms like "ancestral home", "homeland", or "place of origin".
`http://gedcomx.org/Immigration`| A person's immigration.
`http://gedcomx.org/LandTransaction`| A land transaction enacted by a person, such as a land purchase or sell.
`http://gedcomx.org/MoveTo`| A person's move (i.e. change of residence) to a new location.
`http://gedcomx.org/MoveFrom`| A person's move (i.e. change of residence) from a location.
`http://gedcomx.org/Residence`| A person's residence.

The following snippet demonstrates how these types of facts might be captured by GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="en">
                &lt;fullText>John Fitzgerald Kennedy&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="John"/>
                &lt;part type="http://gedcomx.org/Given" value="Fitzgerald"/>
                &lt;part type="http://gedcomx.org/Surname" value="Kennedy"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "en",
        "fullText" : "John Fitzgerald Kennedy",
        "parts" : [ {
          "value" : "John",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Fitzgerald",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Kennedy",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>


## Military Service

The following fact types are among those provided by the [GEDCOM X Fact Types](http://gedcomx.org/fact-types/v1) specification for
capturing information about a person's military service:

type | use case
-----|---------
`http://gedcomx.org/MilitaryAward`| A person's military award.
`http://gedcomx.org/MilitaryDischarge`| A person's military discharge.
`http://gedcomx.org/MilitaryDraftRegistration`| A person's registration for a military draft.
`http://gedcomx.org/MilitaryInduction`| A person's military induction.
`http://gedcomx.org/MilitaryService`| A person's military service.

The following snippet demonstrates how these types of facts might be captured by GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="en">
                &lt;fullText>John Fitzgerald Kennedy&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="John"/>
                &lt;part type="http://gedcomx.org/Given" value="Fitzgerald"/>
                &lt;part type="http://gedcomx.org/Surname" value="Kennedy"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "en",
        "fullText" : "John Fitzgerald Kennedy",
        "parts" : [ {
          "value" : "John",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Fitzgerald",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Kennedy",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>


## Education and Occupation

The following fact types are among those provided by the [GEDCOM X Fact Types](http://gedcomx.org/fact-types/v1) specification for
capturing information about a person's education, career, and occupation:

type | use case
-----|---------
`http://gedcomx.org/Apprenticeship`| A person's apprenticeship.
`http://gedcomx.org/Education`| An education or an educational achievement (e.g. diploma, graduation, scholarship, etc.) of a person.
`http://gedcomx.org/Occupation`| A person's occupation or employment.
`http://gedcomx.org/Retirement`| A person's retirement.

The following snippet demonstrates how these types of facts might be captured by GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="en">
                &lt;fullText>John Fitzgerald Kennedy&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="John"/>
                &lt;part type="http://gedcomx.org/Given" value="Fitzgerald"/>
                &lt;part type="http://gedcomx.org/Surname" value="Kennedy"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "en",
        "fullText" : "John Fitzgerald Kennedy",
        "parts" : [ {
          "value" : "John",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Fitzgerald",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Kennedy",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>

## Religious or Cultural Rites

The following fact types are among those provided by the [GEDCOM X Fact Types](http://gedcomx.org/fact-types/v1) specification for
capturing information about a person's religious or cultural background:

type | use case
-----|---------
`http://gedcomx.org/AdultChristening`| A person's christening or baptism as an adult.
`http://gedcomx.org/Baptism`| A person's baptism.
`http://gedcomx.org/BarMitzvah`| A person's bar mitzvah.
`http://gedcomx.org/BatMitzvah`| A person's bat mitzvah.
`http://gedcomx.org/Caste`| A person's caste.
`http://gedcomx.org/Christening`| A person's christening *at birth* (as opposed to adult christening).
`http://gedcomx.org/Circumcision`| A person's circumcision.
`http://gedcomx.org/Clan`| A person's clan.
`http://gedcomx.org/Confirmation`| A person's confirmation (or other rite of initiation) in a church or religion.
`http://gedcomx.org/Excommunication`| A person's excommunication from a church.
`http://gedcomx.org/FirstCommunion`| A person's first communion in a church.
`http://gedcomx.org/Nationality`| A person's nationality.
`http://gedcomx.org/Ordination`| A person's ordination to a stewardship in a church.
`http://gedcomx.org/Religion`| A person's religion.
`http://gedcomx.org/Yahrzeit`| A person's _yahrzeit_ date.  A person's yahzeit is the anniversary of their death as measured by the Hebrew calendar.

The following snippet demonstrates how these types of facts might be captured by GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="en">
                &lt;fullText>John Fitzgerald Kennedy&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="John"/>
                &lt;part type="http://gedcomx.org/Given" value="Fitzgerald"/>
                &lt;part type="http://gedcomx.org/Surname" value="Kennedy"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "en",
        "fullText" : "John Fitzgerald Kennedy",
        "parts" : [ {
          "value" : "John",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Fitzgerald",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Kennedy",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>

### LDS Ordinance Information

The original GEDCOM standard provided specific fact types that recorded a person's participation in LDS ordinances. While GEDCOM X recognizes the
legitimacy of such fact types, the definition and specification of those fact types is outside the scope of the GEDCOM X specification. It is presumed
that the [Church of Jesus Christ of Latter-day Saints](http://www.lds.org) will provide a separate specification that defines these fact types.

## Additional Relationship Facts

The following fact types are among those provided by the [GEDCOM X Fact Types](http://gedcomx.org/fact-types/v1) specification for
capturing information about a particular relationship:

type | use case
-----|---------
`http://gedcomx.org/CivilUnion`| A civil union.
`http://gedcomx.org/DomesticPartnership`| A domestic partnership.
`http://gedcomx.org/Divorce`| A divorce.
`http://gedcomx.org/Marriage`| A marriage.
`http://gedcomx.org/MarriageBanns`| A marriage banns.
`http://gedcomx.org/MarriageContract`| A marriage contract.
`http://gedcomx.org/MarriageLicense`| A marriage license.
`http://gedcomx.org/AdoptiveParent`| An adoptive relationship between a parent an a child.
`http://gedcomx.org/BiologicalParent`| A biological relationship between a parent and a child.
`http://gedcomx.org/FosterParent`| A foster relationship between a foster parent and a child.
`http://gedcomx.org/GuardianParent`| A legal guardianship between a parent and a child.
`http://gedcomx.org/StepParent`| A step relationship between a parent and a child.

The following snippet demonstrates how these types of facts might be captured by GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="en">
                &lt;fullText>John Fitzgerald Kennedy&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="John"/>
                &lt;part type="http://gedcomx.org/Given" value="Fitzgerald"/>
                &lt;part type="http://gedcomx.org/Surname" value="Kennedy"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "en",
        "fullText" : "John Fitzgerald Kennedy",
        "parts" : [ {
          "value" : "John",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Fitzgerald",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Kennedy",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>

## Fact Qualifiers

There are some occasions that warrant the need to capture additional information that only makes sense in the context of a specific fact.
The following fact qualifiers are recognized by GEDCOM X:

name | value
-----|-------
`http://gedcomx.org/Age`| The age of a person at the event described by the fact.
`http://gedcomx.org/Cause`| The cause of the fact, such as the cause of death.
`http://gedcomx.org/Religion`| The religion associated with a religious event such as a baptism or excommunication.

The following snippet demonstrates how these qualifiers might be applied to facts using GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="en">
                &lt;fullText>John Fitzgerald Kennedy&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="John"/>
                &lt;part type="http://gedcomx.org/Given" value="Fitzgerald"/>
                &lt;part type="http://gedcomx.org/Surname" value="Kennedy"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "en",
        "fullText" : "John Fitzgerald Kennedy",
        "parts" : [ {
          "value" : "John",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Fitzgerald",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Kennedy",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>

## The Canonical List of Fact Types

The [GEDCOM X Fact Types Specification](http://gedcomx.org/fact-types/v1) is used to manage the list of fact types that are officially
recognized by GEDCOM X. This specification is separate from the other specifications because it is expected to be updated more often
with additional fact types. Proposals for additional fact types may be submitted by [opening an issue](https://github.com/FamilySearch/gedcomx/issues).

### Custom Facts

No matter how comprehensive a list of known fact types might be, some genealogical applications might want to provide an option to users to
provide "custom" fact types by allowing them to supply text that describes the fact type. The disadvantage of this option is that
custom fact types can not be semantically processed by software, making the data less amenable to digital analysis and display. Among the
notable disadvantages is that custom fact types can not be presented to users in their native language.

In conformance to the best practices of semantic web and other technologies, GEDCOM X fact types are identified using a
[Uniform Resource Identifier (URI)](http://en.wikipedia.org/wiki/Uniform_resource_identifier). [RFC 2397](http://tools.ietf.org/html/rfc2397)
defines a standard way to encode user-defined data into a URI.

The following snippet demonstrates how custom types might be applied to facts using GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="en">
                &lt;fullText>John Fitzgerald Kennedy&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="John"/>
                &lt;part type="http://gedcomx.org/Given" value="Fitzgerald"/>
                &lt;part type="http://gedcomx.org/Surname" value="Kennedy"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "en",
        "fullText" : "John Fitzgerald Kennedy",
        "parts" : [ {
          "value" : "John",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Fitzgerald",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Kennedy",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>

## Events

...

## Code Examples

[This Java code example](https://github.com/FamilySearch/gedcomx-java/blob/master/gedcomx-model/src/test/java/org/gedcomx/examples/NamesExampleTest.java#L25),
found in the [`gedcomx-java`](https://github.com/FamilySearch/gedcomx) repository demonstrates how to produce the above results.