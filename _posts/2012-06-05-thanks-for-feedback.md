---
title: Thanks for Your Feedback
date: 2012-06-05 13:20:00
layout: default
---

We just wanted to express our thanks to everybody who participated in the
[informal survey](http://familysearch.github.com/gedcomx/feedback/2012-03-23.html)
we made available a few months ago, and we thought we'd share with you
some of the things that came out of that feedback.

The Zip-Based File Format
-------------------------

Community member [nealmcb](https://github.com/nealmcb) opened up 
[an issue suggesting an alternative](https://github.com/FamilySearch/gedcomx/issues/140)
to the MIME-based file format that was originally proposed. Based on your feedback, 
we've decided to adopt the alternative zip-based file format.

And we think it looks really, really good. File processors don't have to
pull the entire file into memory, nor do they have to process the file sequentially.
And the random-access nature of the zip file allows pieces of the file to be
processed without processing everything else.

And, being based on the [zip file format](http://en.wikipedia.org/wiki/ZIP_file_format),
anybody can open up a GEDCOM X file with their favorite unzip tool to see the raw
contents.

For more information on the GEDCOM X File Format, see the 
[formal specification document](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md).

Know what else? We've got a [tool for you to use](https://github.com/FamilySearch/gedcom5-conversion)
that will convert your GEDCOM 5.5 file to GEDCOM X. We'll make another announcement
about that in a separate blog entry.

A List of GEDCOM 5.5 Deficiencies
---------------------------------

From your survey, we've compiled [a list of deficiencies of GEDCOM 5.5](http://www.gedcomx.org/Legacy-GEDCOM-Deficiencies.html).
We'd love your help in getting this issues addressed correctly in GEDCOM X.

Project Accessibility
---------------------

There have been a number of comments about how the GEDCOM X project isn't accessible
enough to anybody who doesn't know Java.

It's true. We hear you. We've been working on a big set of documentation
that we're hoping will get us closer to where we need to be.

More to come on that in the [next post](http://familysearch.github.com/gedcomx//2012/06/05/specs-diagrams-and-tools.html).

