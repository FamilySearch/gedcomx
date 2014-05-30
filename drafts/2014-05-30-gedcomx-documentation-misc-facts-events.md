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

This guide is intended to supplement the information presented in the other guides regarding
[birth-like information](http://familysearch.github.io/gedcomx//2014/03/21/gedcomx-documentation-birth-information.html),
[death-like information](http://familysearch.github.io/gedcomx//2014/04/04/gedcomx-documentation-death-information.html),
[marriage-like information](http://familysearch.github.io/gedcomx//2014/05/02/gedcomx-documentation-marriage-information.html),
and [personal names](http://familysearch.github.io/gedcomx//2014/05/16/gedcomx-documentation-names.html) by providing a high-level
overview of the other types of facts and events that are able to be represented using GEDCOM X. In an effort to align with the genealogical
research process, the guides about [birth-like](http://familysearch.github.io/gedcomx//2014/03/21/gedcomx-documentation-birth-information.html),
[death-like](http://familysearch.github.io/gedcomx//2014/04/04/gedcomx-documentation-death-information.html), and
[marriage-like](http://familysearch.github.io/gedcomx//2014/05/02/gedcomx-documentation-marriage-information.html) information
each follow a particular pattern for capturing genealogical research:

1. Describe the source.
2. Extract the information from the source.
3. Analyze the extracted information.

More details about how to use GEDCOM X to capture data at each of these steps will be provided in a separate guide.
This guide will not attempt to supply a narrative that provides the background for these other types of facts and
events, but it is assumed that good genealogical research practices are followed as this type of information is captured.

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
        &lt;fact type="http://gedcomx.org/Census">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Emigration">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Immigration">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/LandTransaction">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MoveTo">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MoveFrom">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Residence">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "facts" : [ {
      "type" : "http://gedcomx.org/Census",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Emigration",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Immigration",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/LandTransaction",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MoveTo",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MoveFrom",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Residence",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
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
        &lt;fact type="http://gedcomx.org/MilitaryAward">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MilitaryDischarge">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MilitaryDraftRegistration">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MilitaryInduction">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MilitaryService">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "facts" : [ {
      "type" : "http://gedcomx.org/MilitaryAward",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MilitaryDischarge",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MilitaryDraftRegistration",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MilitaryInduction",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MilitaryService",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
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
        &lt;fact type="http://gedcomx.org/Apprenticeship">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Education">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Occupation">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Retirement">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "facts" : [ {
      "type" : "http://gedcomx.org/Apprenticeship",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Education",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Occupation",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Retirement",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    } ]
  } ]
}
</pre>

## Religious or Cultural Information

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
        &lt;fact type="http://gedcomx.org/AdultChristening">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Baptism">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/BarMitzvah">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/BatMitzvah">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Caste">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Christening">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Circumcision">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Clan">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Confirmation">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Excommunication">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/FirstCommunion">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Nationality">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Ordination">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Religion">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Yahrzeit">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "facts" : [ {
      "type" : "http://gedcomx.org/AdultChristening",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Baptism",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/BarMitzvah",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/BatMitzvah",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Caste",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Christening",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Circumcision",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Clan",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Confirmation",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Excommunication",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/FirstCommunion",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Nationality",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Ordination",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Religion",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Yahrzeit",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    } ]
  } ]
}
</pre>

### LDS Ordinance Information

The original GEDCOM standard provided specific fact types that recorded the LDS ordinances that apply to a person. While GEDCOM X recognizes the
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
    &lt;relationship type="http://gedcomx.org/Couple">
        &lt;fact type="http://gedcomx.org/CivilUnion">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/DomesticPartnership">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Divorce">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Marriage">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MarriageBanns">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MarriageContract">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/MarriageLicense">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/relationship>
    &lt;relationship type="http://gedcomx.org/ParentChild">
        &lt;fact type="http://gedcomx.org/AdoptiveParent">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/BiologicalParent">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/FosterParent">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/GuardianParent">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/StepParent">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/relationship>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "relationships" : [ {
    "type" : "http://gedcomx.org/Couple",
    "facts" : [ {
      "type" : "http://gedcomx.org/CivilUnion",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/DomesticPartnership",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Divorce",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/Marriage",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MarriageBanns",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MarriageContract",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/MarriageLicense",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    } ]
  }, {
    "type" : "http://gedcomx.org/ParentChild",
    "facts" : [ {
      "type" : "http://gedcomx.org/AdoptiveParent",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/BiologicalParent",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/FosterParent",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/GuardianParent",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    }, {
      "type" : "http://gedcomx.org/StepParent",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
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
        &lt;fact type="http://gedcomx.org/Christening">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
            &lt;qualifier name="http://gedcomx.org/Religion">Catholic&lt;/qualifier>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Census">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
            &lt;qualifier name="http://gedcomx.org/Age">44&lt;/qualifier>
        &lt;/fact>
        &lt;fact type="http://gedcomx.org/Death">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
            &lt;qualifier name="http://gedcomx.org/Cause">Heart failure&lt;/qualifier>
        &lt;/fact>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "facts" : [ {
      "type" : "http://gedcomx.org/Christening",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      },
      "qualifiers" : [ {
        "name" : "http://gedcomx.org/Religion",
        "value" : "Catholic"
      } ]
    }, {
      "type" : "http://gedcomx.org/Census",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      },
      "qualifiers" : [ {
        "name" : "http://gedcomx.org/Age",
        "value" : "44"
      } ]
    }, {
      "type" : "http://gedcomx.org/Death",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      },
      "qualifiers" : [ {
        "name" : "http://gedcomx.org/Cause",
        "value" : "Heart failure"
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
custom fact types can not be semantically processed by software, making the data less amenable to digital analysis and display. For example,
among the notable disadvantages is that custom fact types can not be presented to users in their native language.

In conformance to the best practices of semantic web and other technologies, GEDCOM X fact types are identified using a
[Uniform Resource Identifier (URI)](http://en.wikipedia.org/wiki/Uniform_resource_identifier). In the case of custom (user-supplied)
types, [RFC 2397](http://tools.ietf.org/html/rfc2397) is used to encode the text supplied by the user as a URI.

The following snippet demonstrates how custom types might be applied to facts using GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;fact type="data:,Eagle%20Scout">
            &lt;date>
                &lt;original>...&lt;/original>
            &lt;/date>
            &lt;place>
                &lt;original>...&lt;/original>
            &lt;/place>
        &lt;/fact>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "facts" : [ {
      "type" : "data:,Eagle%20Scout",
      "date" : {
        "original" : "..."
      },
      "place" : {
        "original" : "..."
      }
    } ]
  } ]
}
</pre>

## Events

Many software applications allow users to capture genealogical information in an "event-centric" manner instead of in a "person-centric" manner.
In other words, users may be allowed provide a description of a specific event, and then reference each of the persons that participated in
the event. For example, a marriage record might record witnesses and perhaps an officiator without providing any data about their relationship
to the bride or groom. In such a case, it may be useful to capture information about the event outside the context of the persons that
participated in the event. An example of such a case is provided in the
[guide to marriage-like information](http://familysearch.github.io/gedcomx//2014/05/02/gedcomx-documentation-marriage-information.html).

GEDCOM X defines an [`Event` data type](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#event)
that can be used to capture event-centric information. In addition to a date and place, the `Event` provides a list of instances of the
[`EventRole` data type](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#conclusion-event-role)
that is used to reference each person that participated in the event. The `EventRole` supports a `details` property for describing the
nature of the role as well as a `type` the provides a semantic element for describing the role. GEDCOM X specifies the following event role types:

type | description
-----|------------
`http://gedcomx.org/Principal`| The person is the principal person of the event. For example, the principal of a birth event is the person that was born.
`http://gedcomx.org/Participant`| A participant in the event.
`http://gedcomx.org/Official`| A person officiating the event.
`http://gedcomx.org/Witness`| A witness of the event.

For an example in both XML and JSON of an `Event`, see the
[guide to marriage-like information](http://familysearch.github.io/gedcomx//2014/05/02/gedcomx-documentation-marriage-information.html)

## Code Examples

[This Java code example](https://github.com/FamilySearch/gedcomx-java/blob/master/gedcomx-model/src/test/java/org/gedcomx/examples/MiscellaneousFactsExampleTest.java#L25),
found in the [`gedcomx-java`](https://github.com/FamilySearch/gedcomx) repository demonstrates how to produce the serialization examples above.