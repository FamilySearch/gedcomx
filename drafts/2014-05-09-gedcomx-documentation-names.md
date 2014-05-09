---
title: GEDCOM X Representation of Personal Names
date: 2014-05-09 17:00:00
layout: default
author: Ryan Heaton
---

This post is part of an initiative to improve the available documentation of GEDCOM X. This particular post describes how the many varieties
of personal names might be represented using GEDCOM X. This post is also [available at gedcomx.org](http://www.gedcomx.org/recipe-names.html),
where you will find a link to propose edits or updates.

## Summary

...

mention [this guide](http://www.w3.org/International/questions/qa-personal-names)

...

## Basic Western-Style Name

A basic western-style name is typically pronounced and written with given name(s) followed by surname (i.e., family name). For example, the
name "John Fitzgerald Kennedy" consists of two given names ("John" and "Fitzgerald") followed by a surname ("Kennedy").

In GEDCOM X, such a name is represented using an instance of the
[`Name`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name) data type.
The `Name` has a single form, represented as an instance of
[`NameForm`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name-form). The name form
may capture the name as text, as separate parts, or both. The full text of the name (if available) is provided in the `fullText` property of
the `NameForm`. The parts of the name (if available) are provided using the `parts` property of `NameForm` which provides a list of instances of
the [`NamePart`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name-part) data type.

The cultural context of the name form becomes an important component in order for users to be able to correctly interpret the name. The `lang`
property of `NameForm` is processed according to [BCP 47](http://tools.ietf.org/html/bcp47) and is used to capture the cultural context.
The full text of the name form is presumed to be provided as it would be represented in the specified cultural context. The list of name parts
(if provided) is assumed to be ordered according to the common order of the cultural context.

The following snippet demonstrates how the name "John Fitzgerald Kennedy" might be captured by GEDCOM X in both XML and JSON:

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


## Multiple Name Forms

It is common in some cultures to have multiple forms of the same name. For example, a Japanese name will often be written
using ideographic characters (e.g., [kanji](http://en.wikipedia.org/wiki/Kanji)) that can have multiple pronunciations. To provide
additional clarity, a phonetic form of the name is often provided using kana characters (e.g. [katakana](http://en.wikipedia.org/wiki/Katakana)).
Furthermore, in order for the name to be understood by western cultures, a romanized form of the same name may also be provided.

Note that it is important to understand the different between a _single_ name with multiple forms and two distinct (alternate) names.
For example, a person may be identified by both the name "Johnny" and the name "Johnathan", but the two are separate and distinct names
and are not different "forms" of the same name.

In GEDCOM X, a name with multiple forms is provided using a single instance of the
[`Name`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name) data type with multiple
[`NameForm`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name-form)s. Each name form
should specify its script using the [BCP 47](http://tools.ietf.org/html/bcp47) language tag. Name forms are assumed to be ordered by preference
of the culture in which the name was provided.

The following snippet demonstrates how the Japanese name "山田太郎" might be captured along with its alternate forms (katakana: "ヤマダタロー",
romanized: "Yamada Tarō") by GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="ja-Hani">
                &lt;fullText>山田太郎&lt;/fullText>
                &lt;part type="http://gedcomx.org/Surname" value="山田"/>
                &lt;part type="http://gedcomx.org/Given" value="太郎"/>
            &lt;/nameForm>
            &lt;nameForm xml:lang="ja-Kana">
                &lt;fullText>ヤマダタロー&lt;/fullText>
                &lt;part type="http://gedcomx.org/Surname" value="ヤマダ"/>
                &lt;part type="http://gedcomx.org/Given" value="タロー"/>
            &lt;/nameForm>
            &lt;nameForm xml:lang="ja-Latn">
                &lt;fullText>Yamada Tarō&lt;/fullText>
                &lt;part type="http://gedcomx.org/Surname" value="Tarō"/>
                &lt;part type="http://gedcomx.org/Given" value="Yamada"/>
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
        "lang" : "ja-Hani",
        "fullText" : "山田太郎",
        "parts" : [ {
          "value" : "山田",
          "type" : "http://gedcomx.org/Surname"
        }, {
          "value" : "太郎",
          "type" : "http://gedcomx.org/Given"
        } ]
      }, {
        "lang" : "ja-Kana",
        "fullText" : "ヤマダタロー",
        "parts" : [ {
          "value" : "ヤマダ",
          "type" : "http://gedcomx.org/Surname"
        }, {
          "value" : "タロー",
          "type" : "http://gedcomx.org/Given"
        } ]
      }, {
        "lang" : "ja-Latn",
        "fullText" : "Yamada Tarō",
        "parts" : [ {
          "value" : "Tarō",
          "type" : "http://gedcomx.org/Surname"
        }, {
          "value" : "Yamada",
          "type" : "http://gedcomx.org/Given"
        } ]
      } ]
    } ]
  } ]
}
</pre>

##

## Code Examples

[This Java code example](https://github.com/FamilySearch/gedcomx-java/blob/master/gedcomx-model/src/test/java/org/gedcomx/examples/NamesExampleTest.java#L25),
found in the [`gedcomx-java`](https://github.com/FamilySearch/gedcomx) repository demonstrates how to produce the above results.