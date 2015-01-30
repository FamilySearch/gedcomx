---
title: GEDCOM X for Java, C#, and PHP
date: 2015-01-30 15:10:00
layout: default
author: Ryan Heaton
---

Since the beginnings GEDCOM X, we've been very interested in making the project _practical_ and _useful_ to
developers. To that end, we've been working hard over the last year to provide libraries and SDKs for GEDCOM X
on various platforms and languages. Today, I'd like to introduce you to three of them.

All three of the SDKs being introduced here are made freely available via [Apache II](http://www.apache.org/licenses/LICENSE-2.0) license.

## Java SDK

[Java](http://java.com/en/) is the primary development language here at [FamilySearch](https://familysearch.org), so
the [GEDCOM X Java SDK](https://github.com/FamilySearch/gedcomx-java) has always been maintained and developed along
with the [GEDCOM X Specification Set](http://www.gedcomx.org/Specifications.html). So the
[GEDCOM X Java SDK](https://github.com/FamilySearch/gedcomx-java) serves as the official reference implementation for
GEDCOM X.

The [GEDCOM X Java SDK](https://github.com/FamilySearch/gedcomx-java) provides libraries for reading and writing
[GEDCOM X XML](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md),
[GEDCOM X JSON](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md),
and the [GEDCOM X File Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md).
The Java SDK also provides [a client library](https://github.com/FamilySearch/gedcomx-java/tree/master/gedcomx-rs-client)
that can be used to read and write genealogical data to a server that conforms to the
[GEDCOM X RS specification](https://github.com/FamilySearch/gedcomx-rs/blob/master/specifications/rs-specification.md). This
means that not only will the Java SDK work with the [FamilySearch API](https://familysearch.org/developers/docs/api/resources),
but it will also work with _any_ genealogical data servers that conform to the RS specification.

For more information about how to use the GEDCOM X Java SDK, see [the project README](https://github.com/FamilySearch/gedcomx-java/blob/master/README.md#use).

## C# SDK

The [GEDCOM X C# SDK](https://github.com/FamilySearch/gedcomx-csharp) has been developed for the [.NET platform](http://www.microsoft.com/net).
The C# SDK was developed from scratch as a port of the [GEDCOM X Java SDK](https://github.com/FamilySearch/gedcomx-java), closely following
its project structure and functionality, but in conformance to general best practices and style guidelines established by the
C# community.

Like the [Java SDK](https://github.com/FamilySearch/gedcomx-java), the [GEDCOM X C# SDK](https://github.com/FamilySearch/gedcomx-csharp)
provides libraries for reading and writing
[GEDCOM X XML](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md),
[GEDCOM X JSON](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md),
and the [GEDCOM X File Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md).
The C# SDK also provides [a client library](https://github.com/FamilySearch/gedcomx-java/tree/master/gedcomx-rs-client)
that can be used to read and write genealogical data to a server that conforms to the
[GEDCOM X RS specification](https://github.com/FamilySearch/gedcomx-rs/blob/master/specifications/rs-specification.md).

For more information about how to use the GEDCOM X C# SDK, see [the project README](https://github.com/FamilySearch/gedcomx-csharp/blob/master/README.md).

## PHP SDK

The [GEDCOM X PHP SDK](https://github.com/FamilySearch/gedcomx-php) has been developed for the PHP development community.
Like the [Java SDK](https://github.com/FamilySearch/gedcomx-java) and the [C# SDK](https://github.com/FamilySearch/gedcomx-csharp),
the [GEDCOM X PHP SDK](https://github.com/FamilySearch/gedcomx-php) provides libraries for reading and writing
[GEDCOM X XML](https://github.com/FamilySearch/gedcomx/blob/master/specifications/xml-format-specification.md),
[GEDCOM X JSON](https://github.com/FamilySearch/gedcomx/blob/master/specifications/json-format-specification.md),
and the [GEDCOM X File Format](https://github.com/FamilySearch/gedcomx/blob/master/specifications/file-format-specification.md).
The PHP SDK also provides [a client library](https://github.com/FamilySearch/gedcomx-java/tree/master/gedcomx-rs-client)
that can be used to read and write genealogical data to a server that conforms to the
[GEDCOM X RS specification](https://github.com/FamilySearch/gedcomx-rs/blob/master/specifications/rs-specification.md).

For more information about how to use the GEDCOM X PHP SDK, see [the project README](https://github.com/FamilySearch/gedcomx-php/blob/master/README.md).


