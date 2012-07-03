---
title: The File Format - Jeers and Cheers
date: 2012-07-03 12:09:00
layout: default
---

So now that we've had a few weeks to take a look at the new file
format, let's figure out where to go from here, shall we?

## Jeers

Let's start out by acknowledging the inefficiencies of the new
file format. These aren't news--we've all had a few weeks now 
to grin and giggle at these.

### It's loud.

A first look at the new GEDCOM X file format seems to be leaving
a bad taste in the mouth. I mean _look_ at all that _noise_! It
really becomes evident when you compare the two records 
side-by-side:

<table>
  <thead>
  <tr>
    <td>GEDCOM 5.5 <br/>(Total Characters: 277)</td>
    <td>GEDCOM X <br/>(Total Characters: 1915)</td>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td valign="top">
{% highlight text %}
0 @I00020@ INDI
1 NAME Debbie Cecilia /Clement/
2 SOUR @S004353@
2 SOUR @S003208@
1 SEX F
1 BIRT
2 DATE 14 Feb 1878
2 PLAC Indiana
2 SOUR @S002132@
2 SOUR @S003208@
1 DEAT
2 DATE 17 Apr 1936
2 PLAC Providence Hospital, Wallace, Shoshone Co, ID
2 SOUR @S002132@
2 SOUR @S001551@
{% endhighlight %}
    </td>
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
  </tr>
  </tbody>
</table>

Wow.

So the prolog is superfluous, as are half of those `xmlns` declarations.
Those need to be cleaned up for sure. We could also deflate a lot of
the extra characters if we wanted to. The following is the extreme example,
but it illustrates what a semantically-equivalent XML snipped _could_ look
like:

<table>
  <thead>
  <tr>
    <td>GEDCOM 5.5 <br/>(Total Characters: 277)</td>
    <td>GEDCOM X, Extreme Deflate Example <br/>(Total Characters: 386)</td>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td valign="top">
{% highlight text %}
0 @I00020@ INDI
1 NAME Debbie Cecilia /Clement/
2 SOUR @S004353@
2 SOUR @S003208@
1 SEX F
1 BIRT
2 DATE 14 Feb 1878
2 PLAC Indiana
2 SOUR @S002132@
2 SOUR @S003208@
1 DEAT
2 DATE 17 Apr 1936
2 PLAC Providence Hospital, Wallace, Shoshone Co, ID
2 SOUR @S002132@
2 SOUR @S001551@
{% endhighlight %}
    </td>
    <td valign="top">
{% highlight xml %}
<p id="I00020"><g><t>F</t></g><n><s><d>S004353-1e</d></s>
<s><d>S003208-1f</d></s><p><f>Debbie Cecilia Clement</f><p>
<t>S</t><v>Clement</v></p></n><f><s><d>S002132-20</d></s><s>
<d>S003208-21</d><t>B</t><d><o>14 Feb 1878</o></d><p>
<o>Indiana</o></p></f><f><s><d>S002132-22</d></s><s>
<d>S001551-23</d><t>D</t><d><o>17 Apr 1936</o></d><p>
<o>Providence Hospital, Wallace, Shoshone Co, ID</o></p></f></p>
{% endhighlight %}
    </td>
  </tr>
  </tbody>
</table>

The problem with XML like _that_ is that it's almost _too_ quiet.
You can't even read it. And even _then_ it's not as succinct as
the equivalent GEDCOM 5.5 (386 characters vs. 277 characters). 

Well, part of that is because the GEDCOM X model is trying to 
account for some of the deficiencies in the GEDCOM 5.5 model. For
example, a source reference is more than just an ID. And the name,
birth, death, etc. support more "stuff". We could certainly
evaluate whether that extra stuff needs to be supported, and
we're doing that every day at the 
[issues forum](https://github.com/FamilySearch/gedcomx/issues). But 
for the purposes of this discussion, let's just assume that
the extra stuff _does_ need to be supported.

If we really care about optimizing the number of characters, why
not use a less verbose serialization format, like JSON? Look:

<table>
  <thead>
  <tr>
    <td>GEDCOM 5.5 <br/>(Total Characters: 277)</td>
    <td>GEDCOM X JSON <br/>(Total Characters: 746)</td>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td valign="top">
{% highlight text %}
0 @I00020@ INDI
1 NAME Debbie Cecilia /Clement/
2 SOUR @S004353@
2 SOUR @S003208@
1 SEX F
1 BIRT
2 DATE 14 Feb 1878
2 PLAC Indiana
2 SOUR @S002132@
2 SOUR @S003208@
1 DEAT
2 DATE 17 Apr 1936
2 PLAC Providence Hospital, Wallace, Shoshone Co, ID
2 SOUR @S002132@
2 SOUR @S001551@
{% endhighlight %}
    </td>
    <td valign="top">
{% highlight javascript %}
{
  "names":[
    {
      "preferred":true,
      "primaryForm":{
        "fullText":"Debbie Cecilia Clement",
        "parts":[
          {
            "type":"http://gedcomx.org/Surname",
            "text":"Clement"
          }
        ]
      },
      "sources":[
        {
          "description":"descriptions/S004353-1e"
        },
        {
          "description":"descriptions/S003208-1f"
        }
      ]
    }
  ],
  "gender":{
    "type":"http://gedcomx.org/Female"
  },
  "facts":[
    {
      "type":"http://gedcomx.org/Birth",
      "date":{
        "original":"14 Feb 1878"
      },
      "place":{
        "original":"Indiana"
      },
      "sources":[
        {
          "description":"descriptions/S002132-20"
        },
        {
          "description":"descriptions/S003208-21"
        }
      ]
    },
    {
      "type":"http://gedcomx.org/Death",
      "date":{
        "original":"17 Apr 1936"
      },
      "place":{
        "original":"Providence Hospital, Wallace, Shoshone Co, ID"
      },
      "sources":[
        {
          "description":"descriptions/S002132-22"
        },
        {
          "description":"descriptions/S001551-23"
        }
      ]
    }
  ],
  "id":"I00020"
}
{% endhighlight %}
    </td>
  </tr>
  </tbody>
</table>

Or, like the XML, we could deflate to the extreme:

<table>
  <thead>
  <tr>
    <td>GEDCOM 5.5 <br/>(Total Characters: 277)</td>
    <td>GEDCOM X JSON, Extreme Deflate Example <br/>(Total Characters: 369)</td>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td valign="top">
{% highlight text %}
0 @I00020@ INDI
1 NAME Debbie Cecilia /Clement/
2 SOUR @S004353@
2 SOUR @S003208@
1 SEX F
1 BIRT
2 DATE 14 Feb 1878
2 PLAC Indiana
2 SOUR @S002132@
2 SOUR @S003208@
1 DEAT
2 DATE 17 Apr 1936
2 PLAC Providence Hospital, Wallace, Shoshone Co, ID
2 SOUR @S002132@
2 SOUR @S001551@
{% endhighlight %}
    </td>
    <td valign="top">
{% highlight javascript %}
{"n":[{"p":{"t":"Debbie Cecilia Clement","p":[{
"t":"S","t":"Clement"}]},"s":[{"d":"S004353"},
{"d":"S003208"}]}],"g":{"t":"F"}, "f":[{"t":"B",
"d":{"o":"14 Feb 1878"},"p":{"o":"Indiana"},"s":
[{"d":"S002132"},{"d":"S003208"}]},{"t":"D",
"d":{"o":"17 Apr 1936"},"p":{"o":
"Providence Hospital, Wallace, Shoshone Co, ID"},
"s":[{"d":"S002132"},{"d":"S001551"}]}],"id":"I00020"}
{% endhighlight %}
    </td>
  </tr>
  </tbody>
</table>

Hmmm.... Getting closer, but still not as efficient as GEDCOM 5.5.
Well, maybe we should just consider using the GEDCOM 5.5 
serialization format? Or maybe [protocol buffers](http://code.google.com/p/protobuf/)? 
[YAML](http://www.yaml.org/)? [Thrift](http://thrift.apache.org/)?

Well, everything has its own benefits and drawbacks. And everybody
has their own biases and preferences.

We (that is, the GEDCOM X development team) tend to think that we should
pick a serialization format that everybody's familiar with, even
if it's not as storage-efficient as GEDCOM 5.5, and then apply a
standard compression mechanism to make it small enough. That's the thinking
that got us to where we are today, anyway.

Which brings us to our next jeer...

### It's fat.

If you take a GEDCOM 5.5 file and convert it to a GEDCOM X file,
the GEDCOM X file is much, much bigger. It turns out there is something
else (beyond the serialization format) that makes a significant contribution 
to the size of a GEDCOM X file. It's the ZIP file format itself.

Surprised? It turns out that the efficiency of a ZIP file degrades
as the files get smaller and the file count gets larger. The GEDCOM
X file format, as defined today, is made up of a large number of very
small files. And you don't have to take our word for it. Try it yourself:

1. Create a directory with two one-character files in it
2. Zip it up 
3. Take a look at the file size. 
4. Double the number of one-character files in the directory.
5. Loop to step 2 until you get the picture.

Embarrassed by all the jeering about the size of the GEDCOM X file, I
thought I could make it all better by showing that XML was the culprit.
So I cut a release of the file format converter that has an option to use 
JSON instead of XML. FYI, if you'd like to try it out yourself, you can 
download the new version of the file converter with the new options at the 
[project site](https://github.com/FamilySearch/gedcom5-conversion).

Anyway, as expected, using JSON helped. On the example I used, JSON reduced
the size of a GEDCOM X file from 85 MB to 51 MB. But the results were still
disappointing given the fact that the original GEDCOM 5.5 file was 15 MB.

A closer look revealed a surprise. Here's the `zipinfo` output for an 85 MB 
GEDCOM X file:

{% highlight text %}
Archive:  G675.gedx
Zip file size: 52506493 bytes, number of entries: 133
-rw----     2.0 fat       87 bX defN 12-Jul-02 10:14 descriptions/S001250-1
-rw----     2.0 fat      409 bl defN 12-Jul-02 10:14 persons/I00001
-rw----     2.0 fat       87 bl defN 12-Jul-02 10:14 descriptions/S001250-2
-rw----     2.0 fat       87 bl defN 12-Jul-02 10:14 descriptions/S001551-3
-rw----     2.0 fat      547 bl defN 12-Jul-02 10:14 persons/I00002

...

-rw----     2.0 fat      373 bl defN 12-Jul-02 10:15 descriptions/S002884
-rw----     2.0 fat      137 bl defN 12-Jul-02 10:15 contributors/SUBM
-rw----     2.0 fat 17682587 bl defN 12-Jul-02 10:15 META-INF/MANIFEST.MF
196741 files, 52227556 bytes uncompressed, 24223883 bytes compressed:  53.6%
{% endhighlight %}

Take note: the file size is 52506493 bytes. The compressed size of the data is
24223883 bytes. The overhead of the ZIP file format _more than doubles_ the
size of the data.

Wow. Is anybody else surprised?

I learned a lot about the zip file format. I could go into the "why"s, but
I won't bore you. Er... that is... I'll try to avoid boring you _more_.

Anyway, here's an interesting tidbit of information. If you unzip the
GEDCOM X file and repackage all the data as a gzipped tarball, the resulting
file is 9.3 MB. That's about a 40% reduction in the file size of the 
original GEDCOM 5.5.

## Cheers

So before we can decide how to move forward, it's important to recognize
the _good_ things about the new file format.

### It's real.

Sure, it's fat and loud. But isn't it nice to have something _real_ to
whine about?

### It's memory efficient.

Some of you may have observed that the GEDCOM file converter sucked up a lot
memory. One of the culprits it the Java Virtual Machine but hey, whatchya 
gonna do? That's Java for you.

The other culprit is GEDCOM 5.5. Before you laugh me to scorn, hear me out.

The GEDCOM 5.5 format makes it really hard to validate the data without 
bringing the entire object graph into memory. If a GEDCOM 5.5 `FAM` record
at the beginning of the file references an `INDI` record that might (or might
not) be found at the end of the file, there is no way to (in)validate that `FAM`
record without processing the entirety of the file.

There are undoubtedly more efficient ways to process a GEDCOM file, but the 
[open-source GEDCOM parser](https://github.com/DallanQ/GEDCOM) that we're using 
brings the entire object graph into memory before it gets traversed and processed. 
Generally speaking, this is a common way to process a GEDCOM file.

Here's what the memory profile looks like for the conversion of a 15 MB GEDCOM
file to a GEDCOM X file on my local computer. On my box, the VM starts off at
200 MB. At 8:53:45, I kick off the conversion process that climbs to about 
1500 MB of memory before finishing:

![Memory Profile Converting GEDCOM 5.5](familysearch.github.com/gedcomx/img/gedcom5-conversion.png)

The memory profile will differ depending on the machine you're using and the
configuration of the VM, but the basic shape of the graph should look similar.

One of the reasons that GEDCOM X breaks up all of the entities into separate
entries is to allow more efficient memory management while processing a file. 
A processor can determine whether a reference to a `person` record is valid by
doing a quick look into the central directory of the ZIP file. Futhermore, the
ZIP file format also supports [random access](http://en.wikipedia.org/wiki/Random_access),
which means that a processor can go directly to a _part_ of the file without
having to read any other parts of the file.

To illustrate this point, the conversion utility has been updated with a new
option to allow a GEDCOM X file to be processed instead of a GEDCOM 5.5 file.
Here's the memory profile on my machine. Like above, the VM starts off at
200 MB. At about 9:15:25, I kick off the process. See how flat that line is?
I can do this _all day_ folks.

![Memory Profile Processing GEDCOM X](familysearch.github.com/gedcomx/img/gedcom5-process.png)

Now, to be fair, a more efficient GEDCOM 5.5 processor might be able to maintain
a flatter profile. But in order to fully validate the GEDCOM 5.5 data, you'd
have to put the object graph into some kind of random access vehicle, volatile
memory being a common one.

The GEDCOM X file format supports random-access out of the box.

### It's processing efficient.

Processing efficiency is a hard thing to illustrate, but because of the
[random accessibility](http://en.wikipedia.org/wiki/Random_access) of a GEDCOM
X file, the processing load can be scaled laterally across as many threads
as you have available.

For you Big Data architects out there, think [MapReduce](http://en.wikipedia.org/wiki/Map_reduce).
The "Map" step is just a matter of consulting the ZIP central directory. The
"Reduce" step is processing an entry in the file.

Has anyone ever tried that with a GEDCOM 5.5 file?

### It's loosely coupled.

The GEDCOM X file format is loosely coupled to both the data model and the
serialization format. The loose coupling allows for great flexibility in future
revisions of GEDCOM X. The data model can rev independently of the
file format. We can switch out the serialization format (e.g. from XML to JSON
to BSON to GEDCOM 5.5 to YAML to ...) without significant changes
to the file format.

### It's self-describing.

Each entry in a GEDCOM X file can carry it's own metadata. Not only does this 
provide a tried-and-tested mechanism for data versioning, but it also allows
for data defined by other specifications to be included and referenced in the
file. Examples of this kind of data include images, audio files, and video files.

The self-description mechanism provides for other notable features as well. A 
processor could use the supplied metadata to provide an immediate synopsis of the file 
without actually processing the file's data. The summary information might include
coverage (e.g. what geographic areas does this file cover? What date spans does this
file cover?), ownership (e.g. who is responsible for maintaining this file?), and
other metadata supplied by the user (e.g. title, description, notes, etc.).

The self-description mechanism also provides a means to digitally sign the file (or
parts of the file). This allows processors to verify that the data is from a specific
provider and that the data hasn't been modified since it was signed by that
provider.

### It's accessible.

Using a well-known set of tools and specifications makes the GEDCOM X file highly
accessible. You can open the file with your favorite archiving tool. You can open each
entry with your favorite text editor. There are a rich set of tools and libraries 
available on every platform that can be used to read and write a GEDCOM X file.
This level of accessibility gives a big boost to everybody who wants to start reading
and writing genealogical data. It encourages innovation and invites new people and
ideas to come and participate because of the low entry barrier.

## So Now What?

Well, we've got some work to do. 

### Settle on a Serialization Format

* XML is probably most accessible, but it's also the most noisy.
* JSON is quite accessible and less noisy, but it's got a weak feature set
  (no support for comments, no support for document start/end markers, no
  support for typing, no support for object identity, etc.)
* GEDCOM tags (or some other custom serialization format) are very efficient
  and readable, but they're not very accessible because everybody
  has to write their own readers and writers.
* YAML's pretty cool, but probably suffers from the same deficiencies
  as GEDCOM tags.
* Protocol Buffers are highly efficient and there are a lot of different 
  libraries available, but you can't just open a buffer up in your favorite
  text editor.

And we could go on and on and on....

### Settle on a Packaging Mechanism

* ZIP/JAR is highly accessible, supports random access, and supports a 
  self-description mechanism. But it's _fat_.
* A GZipped MIME Multipart message would be accessible and fairly efficient.
  It also comes with its own self-description mechanism, but it doesn't
  support random access.
* A GZipped Tarball would also be efficient, and there are a pretty good
  set of libraries available, but it doesn't support random access and 
  we'd have to come up with a custom self-description mechanism.
* [7-Zip ](http://www.7-zip.org/) would also be efficient, but doesn't have
  a great set of development libraries available. And it suffers from
  the same drawbacks as a GZipped Tarball.

And we could go on and on and on....

Well? What angles are we missing? What features are most important to _you_?
