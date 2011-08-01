---
title: The GEDCOM X File Format
date: 2011-07-28 16:18:00
---

The initial draft of the GEDCOM X File Format is now available! This file format is designed to replace the legacy GEDCOM format 
(GEDCOM 5.x) and is designed to be robust and flexible enough to be able to encode a broad set of types of
genealogical data, including [record](http://www.gedcomx.org/Record-Profile.html), [source](http://www.gedcomx.org/Source-Profile.html), 
and [conclusion](http://www.gedcomx.org/Conclusion-Profile.html) data.

Wanna know what else is cool? The GEDCOM X File Format is designed to not only supply structured genealogical data, but also media files
like your images, audio, or video files.

The GEDCOM X File Format is an extension of the [Multipurpose Internet Mail Extensions](http://en.wikipedia.org/wiki/MIME)
(MIME) standard as specified by [RFC 2045](http://tools.ietf.org/html/rfc2045). This allows files to be reasonably
readable via a text editor and removes a lot of obstructions to implementation because developers can leverage a large
set of well-established libraries that are already written for every platform to read and write MIME-formatted files.

The [specification document](http://www.gedcomx.org/File-Format.html) is maintained 
[on the wiki](https://github.com/FamilySearch/gedcomx/wiki/File-Format). There is a [Java](http://java.sun.com) library that will
read and write GEDCOM X files at [FamilySearch/gedcomx-fileformat-java](https://github.com/FamilySearch/gedcomx-fileformat-java), 
and we hope to see libraries for other platforms pop up soon.

Enjoy!
