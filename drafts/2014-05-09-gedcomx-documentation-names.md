---
title: GEDCOM X Representation of Names of Persons
date: 2014-05-09 17:00:00
layout: default
author: Ryan Heaton
---

This post is part of an initiative to improve the available documentation of GEDCOM X. This particular post describes how the many varieties
of personal names might be represented using GEDCOM X. This post is also [available at gedcomx.org](http://www.gedcomx.org/recipe-names.html),
where you will find a link to propose edits or updates.

## Summary

The name of a person is one of the most significant elements of genealogical data. Because there are so many ways
that names are used and given across cultural and historical boundaries, accurately capturing a name can be quite difficult.

This guide provides examples that illustrate how GEDCOM X can be used to exchange information about names of persons
of different cultures and traditions. Many of the use cases covered in this guide were identified in
[_Personal names around the world_](http://www.w3.org/International/questions/qa-personal-names) by Richard Ishida
of the [W3C](http://www.w3.org/). The examples in this guide include a basic western-style name, a Japanese name with multiple
name forms, a Spanish name with multiple name parts, and an Icelandic patronymic name.

## Basic Western-Style Name

A basic western-style name is typically pronounced and written with given name(s) followed by family name. For example, the
name "John Fitzgerald Kennedy" consists of two given names ("John" and "Fitzgerald") followed by a family name ("Kennedy").

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


## Multiple Name Forms and Name Part Order

It is common in some cultures to have multiple forms of the same name. For example, a Japanese name will often be written
using ideographic characters (e.g., [kanji](http://en.wikipedia.org/wiki/Kanji)) that can have multiple pronunciations. To provide
additional clarity, a phonetic form of the name is sometimes provided using kana characters (e.g., [katakana](http://en.wikipedia.org/wiki/Katakana)).
Furthermore, in order for the name to be understood by western cultures, a romanized form of the same name may also be provided.

Note that it is important to understand the different between a _single_ name with multiple forms and two distinct (alternate) names.
For example, a person may be identified by both the name "Johnny" and the name "Johnathan", but the two are separate and distinct names
and are not different "forms" of the same name.

Many cultures commonly use a different order of name parts. For example, some cultures order the family name before
the given name(s). This convention applies to cultures such as those in Japan, China, Korea, and Hungary.

In GEDCOM X, a name with multiple forms is provided using a single instance of the
[`Name`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name) data type with multiple
[`NameForm`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name-form)s. Each name form
should specify its script using the [BCP 47](http://tools.ietf.org/html/bcp47) language tag.

The text of the name forms are assumed to be ordered by preference of the culture in which the name was provided. When name parts are provided,
the parts are also assumed to be ordered by cultural preference.

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

## Multiple Given Names, Multiples Family Names

It is very common for persons to have multiple given names. Some cultures commonly have multiple family names, too. This is common in
many areas of South America. For example, María-Jose Carreño Quiñones may be the daughter of Antonio Carreño Rodríguez and
María Quiñones Marqués.

When providing multiple given names or multiple family names, GEDCOM X does not specify whether each given name or family name should
be separated into its own distinct instance of
[`NamePart`](https://github.com/FamilySearch/gedcomx/blob/master/specifications/conceptual-model-specification.md#name-part) or whether
the value of a single name part should provide the entire sequence of given names or family names. Which alternative is selected generally
depends upon how the information is gathered from the user. Some applications may only provide a single text field for all family names
and another text field for all given names. Other applications might allow the user to break the name down into distinct parts, which
might enhance the searching/matching capabilities of the software.

The following snippet demonstrates the alternate ways that the name "José Eduardo Santos Tavares Melo Silva" might be provided
by GEDCOM X in both XML and JSON:

###### XML (one part per part type)

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="pt-BR">
                &lt;fullText>José Eduardo Santos Tavares Melo Silva&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="José Eduardo"/>
                &lt;part type="http://gedcomx.org/Surname" value="Santos Tavares Melo Silva"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### XML (multiple parts of same type)

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="pt-BR">
                &lt;fullText>José Eduardo Santos Tavares Melo Silva&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="José"/>
                &lt;part type="http://gedcomx.org/Given" value="Eduardo"/>
                &lt;part type="http://gedcomx.org/Surname" value="Santos"/>
                &lt;part type="http://gedcomx.org/Surname" value="Tavares"/>
                &lt;part type="http://gedcomx.org/Surname" value="Melo"/>
                &lt;part type="http://gedcomx.org/Surname" value="Silva"/>
            &lt;/nameForm>
        &lt;/name>
    &lt;/person>
&lt;/gedcomx>
</pre>

###### JSON (one part per part type)

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "pt-BR",
        "fullText" : "José Eduardo Santos Tavares Melo Silva",
        "parts" : [ {
          "value" : "José Eduardo",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Santos Tavares Melo Silva",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>

###### JSON (multiple parts of same type)

<pre class="prettyprint lang-javascript" style="max-height: 400px; overflow:auto">
{
  "persons" : [ {
    "names" : [ {
      "nameForms" : [ {
        "lang" : "pt-BR",
        "fullText" : "José Eduardo Santos Tavares Melo Silva",
        "parts" : [ {
          "value" : "José",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Eduardo",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Santos",
          "type" : "http://gedcomx.org/Surname"
        }, {
          "value" : "Tavares",
          "type" : "http://gedcomx.org/Surname"
        }, {
          "value" : "Melo",
          "type" : "http://gedcomx.org/Surname"
        }, {
          "value" : "Silva",
          "type" : "http://gedcomx.org/Surname"
        } ]
      } ]
    } ]
  } ]
}
</pre>

## Patronymic/Matronymic Names

Some cultures follow a patronymic naming convention such that the person's name consists of a given name followed by the name
of the father with a suffix indicating the relation. For example, in the Icelandic name Björk Guðmundsdóttir, Björk is the given name
and Guðmundsdóttir is a patronymic indicating "daughter of Guðmund." The name "Guðmundsdóttir" may or may not be considered a
surname.

Because the patronymic (or matronymic) carries genealogical significance, GEDCOM X provides a way to "qualify" a name part to indicate
the patronymic or matronymic nature of the name part.

The following snippet demonstrates how the name "Björk Guðmundsdóttir" might be captured with its patronymic designation
by GEDCOM X in both XML and JSON:

###### XML

<pre class="prettyprint lang-xml" style="max-height: 400px; overflow:auto">
&lt;gedcomx xmlns="http://gedcomx.org/v1/">
    &lt;person>
        &lt;name>
            &lt;nameForm xml:lang="is">
                &lt;fullText>Björk Guðmundsdóttir&lt;/fullText>
                &lt;part type="http://gedcomx.org/Given" value="Björk"/>
                &lt;part value="Guðmundsdóttir">
                    &lt;qualifier name="http://gedcomx.org/Patronymic"/>
                &lt;/part>
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
        "lang" : "is",
        "fullText" : "Björk Guðmundsdóttir",
        "parts" : [ {
          "value" : "Björk",
          "type" : "http://gedcomx.org/Given"
        }, {
          "value" : "Guðmundsdóttir",
          "qualifiers" : [ {
            "name" : "http://gedcomx.org/Patronymic"
          } ]
        } ]
      } ]
    } ]
  } ]
}
</pre>

## Other Name Part Qualifiers

In addition to patronymic and matronymic qualifiers, GEDCOM X supplies other qualifiers that might be used to provide details about how
persons use names. A name part can be qualified as a geographic name, a religious name, a maiden name, a title, an occupational name, etc.
The current registry of name part qualifiers is provided by the
[GEDCOM X Name Part Qualifiers Specification](https://github.com/FamilySearch/gedcomx/blob/master/specifications/name-part-qualifiers-specification.md)
and may be updated as need arises.

## Code Examples

[This Java code example](https://github.com/FamilySearch/gedcomx-java/blob/master/gedcomx-model/src/test/java/org/gedcomx/examples/NamesExampleTest.java#L25),
found in the [`gedcomx-java`](https://github.com/FamilySearch/gedcomx) repository demonstrates how to produce the above results.