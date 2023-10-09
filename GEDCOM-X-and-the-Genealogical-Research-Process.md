---
layout: default
title: GEDCOM X and the Genealogical Research Process
---

# The Genealogical Research Process

<a href="Genealogical%20Research%20Process.pdf"><img src="Genealogical%20Research%20Process.png" alt="Genealogical Research Process" /></a>

#### Question Asking

The research process begins with a focused research _question_.

#### Information Gathering

Armed with an appropriate _question_, a researcher creates a search plan.  This plan identifies all of _sources_ that need to be searched to satisfy the "reasonably exhaustive search" [Genealogical Proof Standard (GPS)](https://www.familysearch.org/wiki/en/Genealogical_Proof_Standard) requirement&mdash;i.e., all of the _sources_ that may contain _information_ suggesting answer(s) to the research _question_.  As the researcher executes this search plan, he should avoid forming _answers_ to the _question_ (i.e., no _hypotheses_), focusing only on potential _evidence_ (i.e., _information_ suggesting _tentative answers_ to the research _question_).

#### Hypothesis Testing

When the researcher is done executing his search plan, he is presumably in possession of all "reasonably available" _evidence_.  The researcher then uses his gathered _evidence_ to form _hypotheses_ (i.e., _tentative answers_ to the research _question_ based on all gathered _evidence_) and subjects these _hypotheses_ to testing.  A thorough researcher will consider all _hypotheses_ that can be reasonably construed from the _evidence_ gathered, testing each of them.

#### Conclusion Accepting

If a sole _hypothesis_ passes testing and all conflicting _evidence_ can be resolved, this sole hypothesis is called a _conclusion_.

#### Proof Explained

If the researcher goes on to explain his _conclusion_ by demonstrating the five [GPS](https://www.familysearch.org/wiki/en/Genealogical_Proof_Standard) elements, the _conclusion_ becomes _proven_.

# Essential Data Concepts from the Genealogical Research Process

The GEDCOM X project identifies the following as the essential data concepts from the genealogical research process (represented here by the following data domain diagram and bulleted list of definitions):
 
<div><img src="Genealogical%20Research%20Process%20-%20Domain%20Model.png" alt="Genealogical Research Process - Data Domain" /></div>

* __*Source*__ &mdash; a container of _Information_<sup><a name="footnoteref1"/><a href="#footnote1">1</a></sup>
* __*Information*__ &mdash; statements based on experience, fabrication, hearsay, intuition, observation, reading, research, or some other means; a _Source_’s surface content, including its physical characteristics; what we see or hear when we examine a source, not what we interpret<sup><a name="footnoteref2"/><a href="#footnote2">2</a></sup>
* __*Question*__ &mdash; a question that research aims to answer; in genealogy, a focused question that seeks unknown _Information_ about a documented person and that helps frame research scope, lead to relevant _Information_, and identify _Evidence_<sup><a name="footnoteref3"/><a href="#footnote3">3</a></sup>
* __*Evidence*__ &mdash; a tentative _Answer_ to a research _Question_ that is the product of using _Information_ to answer a research _Question_<sup><a name="footnoteref4"/><a href="#footnote4">4</a></sup>
* __*Analysis*__ &mdash; notes or narrative text about the result of two processes: _(a)_ recognizing the _Information_ items a _Source_ contains that are likely to answer a research question; _(b)_ considering the characteristics, purpose, and history of a _Source_ and its relevant _Information_ items in order to determine their likely accuracy<sup><a name="footnoteref5"/><a href="#footnote5">5</a></sup>
* __*Hypothesis*__ &mdash; a tentative _Answer_ to a research _Question_ resulting from correlating two or more independent items of _Evidence_
* __*Conclusion*__ &mdash; an accepted _Answer_ to a research _Question_; a _Hypothesis_ that has passed testing and for which conflicts can be resolved
* __*Proof*__ &mdash; a _Conclusion_ **explained** in writing; an explanation that demonstrates the five [GPS](https://www.familysearch.org/wiki/en/Genealogical_Proof_Standard) elements


# Modeling Data Concepts from the Genealogical Research Process in GEDCOM X

#### _Questions_

At this time, the core GEDCOM X model does not include a provision for modeling _Questions_ (research goals), but it might be a good candidate for a future [extension](Extensions.html).

#### _Answers_

Use specializations of [`Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject) to record _Answers_ to research _Questions_.

#### _Information_

Use specializations of [`Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject) to record _Information_ found in a single _Source_.  Configure the [`Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject) to adhere to the [Extracted Conclusion Constraints](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#extracted-conclusion-constraints).

#### _Evidence_

Use specializations of [`Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject) to represent _Evidence_.  Configure the [`Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject) such that its `evidence` property contains only references to _Information_.

#### _Hypotheses_ and _Conclusions_

Use specializations of [`Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject) to represent _Hypotheses_.  Configure the [`Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject) such that its `evidence` property contains only references to _Evidence_.  _Conclusions_ are _Hypotheses_ that have been successfully tested and accepted (presumably discussed in its associated _Analysis_ or _Proof_).

#### _Sources_

Use a [`SourceDescription`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-description) to describe a _Source_, then reference that description in the data entities in the [`Subject`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#subject) representing the _Information_ from that _Source_ by adding instances of [`SourceReference`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-reference) as appropriate.

#### _Analysis_ and _Proof_

Use a [`Document`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#document) of type `http://gedcomx.org/Analysis` to record analyses and/or proof arguments.  To support more complex narrative layout needs (e.g., footnotes, tables, images, etc.), the [`Document`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#document) class includes an option for XHTML text (see `Document.textType`).  Associate an analysis document with the entities being analyzed via the `analysis` property (found in [`EvidenceReference`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#evidence-reference), [`SourceDescription`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#source-description) and all specializations of [`Conclusion`]( https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#conclusion)).


# Further Reading

If you are not familiar with the genealogical research process as it has been touched upon here, you might consider the following resources for a more in-depth study of the topic:

* Jones, Thomas W. _Mastering Genealogical Proof_. Arlington, VA: National Genealogical Society, 2013.
* Board for Certification of Genealogists. _Genealogy Standards_. 50th Anniversary Ed. Nashville, Tennessee: Ancestry.com, 2014. 
* Rose, Christine. _Genealogical Proof Standard: Building a Solid Case_. 3rd revised edition. San Jose, California: CR Publications, 2009.


----
<div><a name="footnote1" /><a href="#footnoteref1">1</a>. Thomas W. Jones, <i>Mastering Genealogical Proof</i> (Arlington, VA: National Genealogical Society, 2013), 139.</div>
<div><a name="footnote2" /><a href="#footnoteref2">2</a>. Jones, <i>Mastering Genealogical Proof</i>, 136.</div>
<div><a name="footnote3" /><a href="#footnoteref3">3</a>. Jones, <i>Mastering Genealogical Proof</i>, 138-9.</div>
<div><a name="footnote4" /><a href="#footnoteref4">4</a>. Jones, <i>Mastering Genealogical Proof</i>, 13-14, 134.</div>
<div><a name="footnote5" /><a href="#footnoteref5">5</a>. Jones, <i>Mastering Genealogical Proof</i>, 133.</div>