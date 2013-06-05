---
title: New and Improved File Format
date: 2013-06-05 13:30:00
layout: default
author: Ryan Heaton
---

Some of you may have noticed that [we cut a milestone release of the core GEDCOM X specification set](http://familysearch.github.io/gedcomx/2013/06/04/milestone-1.html) yesterday. I'm sure fewer of you noticed that we cut version 1.0.0.M1 of both [the GEDCOM X Java implementation](https://github.com/FamilySearch/gedcomx-java) and the [GEDCOM 5 to GEDCOM X conversion utility](https://github.com/FamilySearch/gedcom5-conversion). I'd like to suggest that you try out the latest version of the conversion utility because it has been updated to conform to the M1 version of the [file format specification](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md). I thought I'd take you through a brief tour of what you'll see with the new utility.

## Improvements

I'll start by suggesting the improvements you might see. I'll do so by referring to [the issues that we noticed with our first take](http://familysearch.github.io/gedcomx/2012/07/03/file-format-jeers-cheers.html).

### It's not as fat.

Based on [the research that we did on the ZIP file format](http://familysearch.github.io/gedcomx/2012/07/03/file-format-jeers-cheers.html), we discovered that the reason the first take of the file format was so fat was because the ZIP file format is really inefficient when bundling together a ton of tiny little entries. It's sad, but true. It's sad particularly because having a ton of little tiny entries enabled some cool things that we could do in terms of memory and processing efficiency.

Well, we decided that the memory and processing efficiencies weren't worth the overhead. So the new file format suggests only a handful of bigger entries instead of a ton of little entries. In fact, the GEDCOM 5 conversion utility only uses one entry.

These changes enable a GEDCOM X file to generally be significantly smaller than an equivalent GEDCOM 5 file. The original size of the GEDCOM 5 file is 15 MB. The size of the converted GEDCOM X file using the old utility was 87 MB. The size of the converted GEDCOM X file using the new utility is 3.1 MB. The following example shows the `zipinfo` of the results of running a GEDCOM 5 file through the converter using the old conversion utility (version 0.1.0) and the new conversion utility (version 1.0.0.M1):

<table>
  <thead>
  <tr>
    <td>GEDCOM X 0.1.0</td>
    <td>GEDCOM X 1.0.0.M1</td>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td valign="top">
{% highlight text %}
Archive:  ./G675-0.1.0.gedx
Zip file size: 90660471 bytes, number of entries: 133
-rw----     2.0 fat      470 bX defN 13-Jun-05 12:43 descriptions/S001250-1
-rw----     2.0 fat     1251 bl defN 13-Jun-05 12:43 persons/I00001
-rw----     2.0 fat      470 bl defN 13-Jun-05 12:43 descriptions/S001250-2
-rw----     2.0 fat      470 bl defN 13-Jun-05 12:43 descriptions/S001551-3
-rw----     2.0 fat     1612 bl defN 13-Jun-05 12:43 persons/I00002
... 196700 other entries ...
-rw----     2.0 fat      821 bl defN 13-Jun-05 12:44 descriptions/S004034
-rw----     2.0 fat      370 bl defN 13-Jun-05 12:44 organizations/S004612.REPO
-rw----     2.0 fat      648 bl defN 13-Jun-05 12:44 descriptions/S004612
-rw----     2.0 fat      370 bl defN 13-Jun-05 12:44 organizations/S003457.REPO
-rw----     2.0 fat      779 bl defN 13-Jun-05 12:44 descriptions/S003457
-rw----     2.0 fat      370 bl defN 13-Jun-05 12:44 organizations/S002884.REPO
-rw----     2.0 fat      804 bl defN 13-Jun-05 12:44 descriptions/S002884
-rw----     2.0 fat      550 bl defN 13-Jun-05 12:44 contributors/SUBM
-rw----     2.0 fat 17682587 bl defN 13-Jun-05 12:44 META-INF/MANIFEST.MF
196741 files, 152084159 bytes uncompressed, 62377861 bytes compressed:  59.0%
{% endhighlight %}
    </td>
    <td valign="top">
{% highlight text %}
Archive:  G675.gedx
Zip file size: 3188171 bytes, number of entries: 2
-rw----     2.0 fat 63478387 bX defN 13-Jun-05 12:41 tree.xml
-rw----     2.0 fat      198 bl defN 13-Jun-05 12:41 META-INF/MANIFEST.MF
2 files, 63478585 bytes uncompressed, 3187901 bytes compressed:  95.0%
{% endhighlight %}
    </td>
  </tr>
  </tbody>
</table>


### It's not as loud.

The resulting file from the old conversion utility was really loud. There was a ton of XML boilerplate that was redundant and we were overusing XML namespaces. In short, the XML was ugly.

We've since cleaned that up. Here's what the XML looks like using the old conversion utility (version 0.1.0) and the new conversion utility (version 1.0.0.M1):

<table>
  <thead>
  <tr>
    <td>GEDCOM X 0.1.0</td>
    <td>GEDCOM X 1.0.0.M1</td>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td valign="top">
{% highlight xml %}
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<person xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" 
        xmlns:foaf="http://xmlns.com/foaf/0.1/" 
        xmlns:contact="http://www.w3.org/2000/10/swap/pim/contact#" 
        xmlns:gx="http://gedcomx.org/" 
        xmlns="http://gedcomx.org/conclusion/v1/" 
        xmlns:ns6="http://purl.org/dc/terms/" 
        rdf:ID="I00020">
    <gender>
        <rdf:type rdf:resource="http://gedcomx.org/Female"/>
    </gender>
    <name>
        <source>
            <description rdf:resource="descriptions/S004353-1e"/>
        </source>
        <source>
            <description rdf:resource="descriptions/S003208-1f"/>
        </source>
        <preferred>true</preferred>
        <primaryForm>
            <fullText>Debbie Cecilia Clement</fullText>
            <part>
                <rdf:type rdf:resource="http://gedcomx.org/Surname"/>
                <text>Clement</text>
            </part>
        </primaryForm>
    </name>
    <fact>
        <source>
            <description rdf:resource="descriptions/S002132-20"/>
        </source>
        <source>
            <description rdf:resource="descriptions/S003208-21"/>
        </source>
        <rdf:type rdf:resource="http://gedcomx.org/Birth"/>
        <date>
            <original>14 Feb 1878</original>
        </date>
        <place>
            <original>Indiana</original>
        </place>
    </fact>
    <fact>
        <source>
            <description rdf:resource="descriptions/S002132-22"/>
        </source>
        <source>
            <description rdf:resource="descriptions/S001551-23"/>
        </source>
        <rdf:type rdf:resource="http://gedcomx.org/Death"/>
        <date>
            <original>17 Apr 1936</original>
        </date>
        <place>
            <original>Providence Hospital, Wallace, Shoshone Co, ID</original>
        </place>
    </fact>
</person>
{% endhighlight %}
    </td>
    <td valign="top">
{% highlight xml %}
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<gedcomx xmlns="http://gedcomx.org/v1/">
  <!-- ... a bunch of persons ... -->
  <person id="I00020">
    <gender type="http://gedcomx.org/Female"/>
    <name>
      <source description="#S004353-1e"/>
      <source description="#S003208-1f"/>
      <preferred>true</preferred>
      <nameForm>
        <fullText>Debbie Cecilia Clement</fullText>
        <part type="http://gedcomx.org/Surname" value="Clement"/>
      </nameForm>
    </name>
    <fact type="http://gedcomx.org/Birth">
      <source description="#S002132-20"/>
      <source description="#S003208-21"/>
      <date>
        <original>14 Feb 1878</original>
      </date>
      <place>
        <original>Indiana</original>
      </place>
    </fact>
    <fact type="http://gedcomx.org/Death">
      <source description="#S002132-22"/>
      <source description="#S001551-23"/>
      <date>
        <original>17 Apr 1936</original>
      </date>
      <place>
        <original>Providence Hospital, Wallace, Shoshone Co, ID</original>
      </place>
    </fact>
  </person>
  <!-- ... a bunch of persons, relationships, sources, etc. ... -->
</gedcomx>
{% endhighlight %}
    </td>
  </tr>
  </tbody>
</table>

So did you notice that we're sticking with XML? [As I mentioned before](http://familysearch.github.io/gedcomx/2012/07/03/file-format-jeers-cheers.html), we're very aware that there are more efficient serialization formats out there. That's cool and all, but we've decided to just stick with XML. For those of you who are interested in the whole discussion about serialization formats, you're welcome to read through [the thread we opened](https://github.com/FamilySearch/gedcomx/issues/185).

## Persistent Issues

We are well aware that there are still some holes that need to be filled in on the conversion utility. It's still a Java utility and hogs a lot of memory, it doesn't yet handle all the GEDCOM 5 tags, it doesn't yet handle all the notes, I'm sure it still crashes on some GEDCOM files, it would be nice to have a GUI for the utility, etc. And I'm sure you'll find a lot more issues, too.

We'd like to address these issues and any other issues you might find. We'd like to encourage you to [open up an issue](https://github.com/FamilySearch/gedcom5-conversion/issues) so we can track that work. In the mean time, this should give you a pretty good idea of what we've got today.

