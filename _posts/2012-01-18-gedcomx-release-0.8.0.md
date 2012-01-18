---
title: GEDCOM X 0.8.0
date: 2012-01-18 12:48:00
---

GEDCOM X 0.8.0 has been released.

### Marriages With No Spouse ###

The question was raised about how to model a marriage (or divorce, etc) for which the spouse was not specified.
After [some discussion](https://github.com/FamilySearch/gedcomx/issues/104), it was decided that the 
[official recommendation](http://www.gedcomx.org/Modeling-Recommendations.html) be to just add a marriage event
to the person or persona. There were some significant drawbacks to the other options, which include
creating a "relationship to nowhere" or an "empty person".

### Lang/Locale ###

The `xml:lang` attribute was added to collections, allowing collections to specify their own language. It's 
probably approprate to mention here how GEDCOM X handles specifying language or locale. There isn't much to say since
GEDCOM X just refers to [BCP (best current practice) 47](http://tools.ietf.org/html/bcp47) which is RFC 5646, which 
obsoletes RFC 4646, which obsoletes RFC 3066. And we're leveraging 
[the industry-specified attribute xml:lang](http://www.w3.org/TR/REC-xml/#sec-lang-tag) to specify it in XML.

### Other Changes ###

* We've done an initial take on the [person summary resource](http://www.gedcomx.org/rs/PersonSummary_resource.html)
* We've clarified the notion of [application profiles ](http://www.gedcomx.org/Application-Profiles.html)
* We've initialized a place to put official [modeling recommendations](http://www.gedcomx.org/Modeling-Recommendations.html)
