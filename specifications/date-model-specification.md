# The GEDCOM X Date Format

## Status

This document specifies a date representation for exchanging dates associated with genealogical data,
and requests discussion and suggestions for improvements.

The current state of this document is as a DRAFT, and as such, the document
may be subject to changes, including backwards-incompatible changes, according to the
discussion and suggestions for improvement.

## Copyright Notice

Copyright 2012 Intellectual Reserve, Inc.

## License

This document is distributed under a Creative Commons Attribution-ShareAlike license.
For details, see:

http://creativecommons.org/licenses/by-sa/3.0/

# 1. Introduction

The GEDCOM X Date specification defines a way of representing dates associated with genealogical data.

This specification is heavliy based on the [ISO 8601](http://dotat.at/tmp/ISO_8601-2004_E.pdf)
standard, the [RFC 3339](http://tools.ietf.org/html/rfc3339) proposal, and [W3C's *profile*]
(http://www.w3.org/TR/NOTE-datetime) of ISO 8601. Concepts from the
[Dublin Core Date and Time Requirements Wiki](http://www.w3.org/TR/NOTE-datetime) were also leveraged.

Each of these standards or proposals individually has limitations or omissions that do not
fulfill the [requirements](https://github.com/FamilySearch/gedcomx/wiki/Date-Model)
for genealogical date representations.

## 1.1 Identifier and Version

The identifier for this specification is:

`http://gedcomx.org/date-model/v1`

For convenience, the GEDCOM X date model may be referred to as "GEDCOM X Date 1.0".
This specification uses "GEDCOM X Date" internally.

# 2. Terms and Definitions

For the purpose of this document, the following terms and definitions apply *in addition to
those defined by [ISO 8601](http://dotat.at/tmp/ISO_8601-2004_E.pdf)*.

## 2.1 Basic Terms

### 2.1.1 calendar date

Portion of a date representing a particular day by specifying its calendar year, its calendar
month and the ordinal number of the day within its calendar month.

### 2.1.2 time of day

Portion remaining from a date if the calendar date portion is ignored, represented in
units of *hours*, *minutes*, and *seconds*.

NOTE 1: By implication, time of day must be less than 24 hours

### 2.1.3 CE

Abbreviation of *Common Era*, *Current Era*, or *Christian Era*. Equivalent to *Anno Domini*, or *AD*

### 2.1.4 BCE

Abbreviation for *Before the Common Era*, *Before the Current Era*, or *Before the Christian Era*.
The designation *BCE* is to *CE*, as *BC* is to *AD*

NOTE 1: The year preceding **1 CE** is identified as **1 BCE**. Neither designation uses a year zero.

### 2.1.5 Gregorian calendar

A calendar introduced in 1582 by Pope Gregory XIII that enhanced the Julian calendar with improved leap year rules.

NOTE 1: The **proleptic** *Gregorian calendar* includes dates prior to 1582 using this calendaring system.

### 2.1.6 simple date

A date representing a single calendar date, and optionally including a time of day. This term is used
to clarify the distinction between a generic *date*  and the aggregation of the Gedcom X Date types
of values (i.e. *simple date*), *date range*, *open-ended date range*, and *approximate date*).

### 2.1.7 date range

A time interval specified by a starting simple date and an ending simple date. Equivalent to a
starting simple date and a duration. Date ranges MAY be either *closed* (both end points are specified
or can be calculated) or *open-ended* (only one end-point is specified).

Examples of `closed date range`: *Between January 1863 CE and December 14, 1642 CE*,

Examples of `open-ended date range`: *Before January 1863 CE*, or *After December 14, 1642 CE*

### 2.1.8 recurring date

A series of discrete dates, separated by a specified duration.
Examples:

* 10 leap years beginning 1924 CE
* at the same time every day for a week starting at June 18, 1937 CE 10 AM local time*
* census is taken in the US every 10 years starting 1820 CE


### 2.1.9 approximate date

An indeterminate date range roughly centered on a specified simple date, with the range
limited to be within one order of magnitude of the smallest specified unit of measurement
in the simple date.


# 3. Notational Conventions

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT",
"RECOMMENDED", "MAY", and "OPTIONAL" in this document are to be interpreted as described in
Best Common Practices #14, [RFC2119](http://tools.ietf.org/html/rfc2119).

# 4. Scope

The GEDCOM X Date must represent one of the following:

* a simple date
* a date range
* a recurring date
* an approximate date

## 4.1 Simple Date

The precision of a simple date is based on the smallest provided unit of measure.

The GEDCOM X Date units of measurement include, and are limited to `year`, `month`,
`day`, `hour`, `minute`, and `second`.  For a given simple date, all units of measure
larger than the smallest unit specified must be provided.

## 4.2 Date Range

A `date range` can be open-ended or closed.

### 4.2.1 Closed Date Range

A *closed* date range may be represented by providing:

* start date and end date, or
* start date and duration

### 4.2.2 Open-Ended Date Range

An *open-ended* date range may be represented by providing either the *start date* or
the *end date*, but not both


## 4.3 Recurring Date
A `recurring date` is represented by providing:

* a start date (or reference date),
* the time interval between occurrences, and
* the number of recurrences (optional)

NOTE 1: If no recurrence count is provided, the recurrences are considered *perpetual*.

## 4.4 Approximate Date

An *approximate date* is represented by providing:

* date, and
* an indicator that the date is *approximate*


# 5. Calendaring System

In order to provide consistency in interpretation of a date, a common calendaring and
time system SHALL be used. Specifically:

* Dates SHALL be specified using the proleptic Gregorian calendar.
* The earliest representable date is January 1, 10000 BCE.
* The latest representable date is December 31, 9999 CE.
* The supported year range SHALL include
    * The year prior to 1 CE (*Common Era* or AD) SHALL be represented as the year 0.
    * Any year prior to year 0 SHALL be represented as a **negative** number.

# 6. Format

## 6.1 Characters used in representation

The following letters are used as value designators, and **precede** the value:

* [A] - designates an `approximate date`
* [P] - designates component is a `duration`
* [R] - designates a `recurring date range`'s recurrence count

The following characters are used as value separators:

* [T] - separates the `calendar date` portion of a `date` or `duration` from the `time of day` portion
* [Z] - designates the date is based on UTC time
* [-] - separates the values of the `calendar date` portion's units of a date
* [:] - separates the values of the `time of day` portion's units of a date
* [/] - separates the components of a `date range` or `recurring date range`

## 6.2 Simple Date

### 6.2.1 Representation

In the format for a `simple date`, letters are used to represent digits of the date as follows:

* [Y] - digit used in the year
* [M] - digit used in the month
* [D] - digit used in the day of month
* [h] - digit used in the hour
* [m] - digit used in the minute
* [s] - digit used in the second
* [z] - digit used in the local time offset
* [±] represents a plus sign [+] if the following element's value is positive or zero, or a minus sign
[-] if the following element's value is negative. Where specified, its presence SHALL be mandatory.

The format for a complete `simple date` shall be
```
±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]
```

### 6.2.2 Description
The *complete* `simple date` format specifies the format of all components and their order (largest to
smallest units). Unit components MAY be **truncated**, right-to-left, to indicate precision
level of the date.

#### 6.2.2.1 Calendar date part

The `year` component MUST consist of a [+] or [-] and four digits, left-padded with zeros.
Valid values range from -9999 to +9999. The `year` component MUST always be present as part of a
simple date, and is the maximal unit of precision.

The `month` component MUST be 2 digits when present, with values of 01-12.

The `day of month` component MUST be 2 digits when present. The range of valid values is
determined by the number of days in that proleptic Gregorian calendar month, with the
first day of the month designated as 01.

#### 6.2.2.2 Time of day part

If any time component is present, the character [T] MUST precede the `time of day` part.

Hours are based on a 24-hour day, and SHALL have a value between 00 and 23. In the special case where the
`minute` and `second` components have zero values, the value 24 SHALL be valid, representing midnight at
the end of the calendar day. Likewise, if all three components have the value 00, it represents midnight
at the beginning of the specified calendar day.
 
When any time of day is specified, there are three options for specifying its geographical reference:

* No specifier implies `local time`
* [Z] specifies UTC
* four digits (with a colon separator), preceded by a [+] or [-] indicates the shift of local time from UTC
   * This is usually referred to as the local *time zone*
   * The [+] or [-] character is REQUIRED
   * The first 2 digits represent the hours
   * The last 2 digits represent minutes, and MAY be omitted if zero

### 6.2.3 Examples

example | description, textual equivalent
--------|--------------------------------
+1752-01-18T22:14:3Z | January 18, 1752 CE 10:14 and 3 seconds PM UTC
+1964-11-14T10-07:00 | November 14, 1964 CE 10 AM, Mountain Standard Time
+1889-05-17T14:23 | May 17, 1889 CE 2:23 PM
+1492-07-27 | July 27, 1492 CE (presumed to be "local time", honoring the International Date Line)
+0186-03 | March 186 CE
-1321 | 1322 BCE

## 6.3 Duration

### 6.3.1 Representation

The initial [P] designates the value is a `duration`. The part including time components SHALL be preceded by [T].

In the format representations for a `duration`, a digit is represented by the letter [n]. Letters have specific
meaning, are literal, and represent the following units:

* [Y] The number of `years`
* [M] The number of `months` or `minutes` (determined by context)
* [D] The number of `days`
* [H] The number of `hours`
* [S] The number of `seconds`

The format for a complete duration SHALL be:
```
PnnnnYnnMnnDTnnHnnMnnS
```

### 6.3.2 Description

`Duration` can be represented by a combination of components/units with designators, with the following
guidelines and restrictions:

1. Each component is OPTIONAL, and MAY be omitted.
    1. However, if any time component is present, the [T] MUST precede the time of day part.
2. All components present MUST appear in hierarchical order, largest to smallest units.
3. Components are **NOT** REQUIRED to be normalized
    1. Any *non-normalized* unit MAY be represented with up to **four** digits.
    2. For example, the descriptive values **13 months** and **2 years, 52 days** are each acceptable.

NOTE 1: For a duration, local time and UTC distinction is meaningless.

NOTE 2: A GEDCOM X Date MAY *contain* a `duration`, but SHALL NOT solely represent a `duration` itself.
 
### 6.3.3 Examples

example | description, textual equivalent
--------|--------------------------------
P17Y6M2D | duration of 17 years, 6 months, and 2 days
P186D | duration of 186 days
PT5H17M | lapsed time: 5 hours 17 minutes
P1000Y18M72DT56H10M1S | 1000 years 18 months 72 days 56 hours 10 minutes 1 second

## 6.4 Date Range

### 6.4.1 Representation

The format for a complete `date range` SHALL either use 2 `simple dates`, separated by a [/]:

```
±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]/±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]
```

or a `simple date` and a `duration`, separated by a [/]:

```
±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]/PnnnnYnnMnnDTnnHnnMnnS
```

In either format, the presence of the slash character [/] indicates the date is a `date range`.

<a id="range-two-dates" />

### 6.4.1 Two Dates

The `simple date` preceding the slash MUST be earlier than or equivalent to the `simple date`
following the slash.

NOTE 1: It is **NOT** REQUIRED that the precision of the two `simple dates` are the same.

### 6.4.2 Date and Duration

The instance referenced by the calculated end date MUST be earlier or equivalent to
the maximum `simple date`: +9999-12-31T23:59:59

NOTE 1: It is **NOT** REQUIRED that the precision of the `simple date` and the `duration` be the same.
The precision of the equivalent final date is the coarser precision of the `simple date` and the `duration`.

### 6.4.3 Examples

example | description, textual equivalent
--------|--------------------------------
+1752/+1823 | between 1752 CE and 1823 CE
+1825-04-13/+1825-11-26 | between April 13, 1825 and November 26, 1825
+1633-02-19/P74Y | 74 years, starting on February 19, 1933, i.e. between February 19, 1933 and 2007

## 6.5 Open-ended Date Range

### 6.5.1 Representation

An `open-ended date range` is an extension of the [two-date `date range` format](#range-two-dates), where
either the starting date or ending date are left blank.

A leading slash character [/] SHALL define a date range *before* the specified date:

```
/±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]
```

A trainling slash character [/] SHALL define a date range *after* the specified date:

```
±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]/
```

### 6.5.2 Examples

example | description, textual equivalent
--------|--------------------------------
/+1887-03 | before May, 1887 CE
+1976-07-11/ | after July 11, 1976 CE
/-1287 | earlier than 1288 BCE
/+0000 | before 1 BCE
-0001-04/ | after May, 2 BCE

## 6.6 Recurring Date

### 6.6.1 Representation

The format for a `recurring date` SHALL be either:

```
R[n]/±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]/±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]
```

or

```
R[n]/±YYYY-MM-DDThh:mm:ss[±hh[:mm]|Z]/PnnnnYnnMnnDTnnHnnMnnS
```

### 6.6.2 Description

The recurring date SHALL be a `date range` prepended with an [R], an OPTIONAL recurrence count, and a slash [/].

NOTE 1: A recurring date MUST reference a *starting date* in the `date range`

### 6.6.3 Examples

example | descriptive use case
--------|--------------------------------
R4/+1776-04-02/+1776-04-09 | every week, for 4 weeks starting on July 2, 1776 CE
R/+2000/P12Y | the Chinese *Year of the Dragon* occurs every 12 years (perpetually), including the year 2000 CE
R100/+1830/+1840 | the US census occurs every 10 years starting in 1830, for 100 repetitions

## 6.7 Approximate Date

The format for an `approximate date` SHALL be a `simple date` prepended by the character [A].

### 6.7.1 Examples

example | unit of approx | description, textual equivalent
--------|----------------|--------------------------------
A+1680 | year | about 1680 CE
A-1400 | year | about 1401 BCE
A+1980-05-18T18:53Z | minutes | about 4:53 PM [UTC], May 18, 1980
A+2014-08-19 | days | about August 19, 2014 CE

# 7. URI Representation

A GEDCOM X Date MAY be identified using a Uniform Resource Identifier (*URI*) as defined by [RFC-2396](http://www.ietf.org/rfc/rfc2396.txt). A URI
that identfies a GEDCOM X Date SHALL have the format:

```
gedcomx-date:<GEDCOM X Date value>
```

NOTE 1: The URI scheme is `gedcomx-date` and the scheme-specific part is the representation of the date as defined
by this specification.

## 7.1 Examples

example type | description | applicable URI
-------------|-------------|----
simple date | Sept 14, 1863 | `gedcomx-date:+1863-09-14`
approx. date | about 1742 | `gedcomx-date:A+1742`
date range | between October 1834 and May 1835 | `gedcomx-date:R+1834-10/+1835-05`

# 8. Outstanding Concerns and Questions

1. Does this specification sufficiently model the ambiguously cyclic years of the Chinese nominal year?
 (I.e. every 60 years is named the same.)

2. Is the concept of a *recurring date* sufficiently useful to provide this functionality?
    * This functionality is included as part of the [ISO 8601](http://dotat.at/tmp/ISO_8601-2004_E.pdf) standard.


# APPENDIX A. Implementation Hints and Observations

The following summaries may be beneficial in parsing and composing GEDCOM X Dates using this specification:

## 1. Parsing GEDCOM X Dates

1. Any value that begins with a [+] or a [-] **must** be a `simple date`
    * The [-] will **only** affect the *year* component
    * A negative `simple date` year component can **always** be converted to a BCE Gregorian year by adding 1 to the absolute value
2. Any value that begins with a [P] **must** be a `duration`
3. A leading [A] is **always** an `approximate date`, and **must** be followed by a `simple date`
4. A leading [R] is **always** a `recurring date range
5. A slash [/] **always** separates values, and its presence **always** indicates a `date range`
    (including *open-ended* and *recurring* date ranges)
6. A [T] **always** separates the `calendar date` or *calendar units* from the `time of day` or *time units*
7. Each component of a `simple date` has a fixed width, **always** preceded by a designated character in the set [±,-,T,:]
    * All components, except `year` have length of 3, including the delimiting prefix character
    * `year` has length of 5 (and the prefix is **always** a [+] or [-])
    * When provided, local time `offset` has a length of 6, or two components (hours and minutes) each of length 3


## 2. Composing GEDCOM X Dates

