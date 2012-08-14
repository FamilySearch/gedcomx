---
title: Requirements
date: 2012-08-14 13:43:00
layout: default
author: Ryan Heaton
---

GEDCOM X suffers from a lack of clearly specified requirements. The problem surfaces occasionally 
when people wonder whether what a potential feature or enhancement will conflict with the project's
requirements. So I thought I'd put some effort into clarifying this issue. Hopefully, clarifying 
requirements will also help diffuse some uncertainty as to FamilySearch's intentions with 
the project.

Part of the problem is that it's sometimes hard to distinguish between the project's _goals_ and
the project's _requirements_. I think a good way to distinguish between the two is that the project's
_goals_ define when we're successful. The project's _requirements_ define the rules we have to live
by in order to get there. 

I think all of the requirements for the project can be summarized into a single statement:

**GEDCOM X must be able to accommodate FamilySearch's Platform API.**

That's it. Is that too hard a thing to swallow? 

Before you answer that, let me point out a few things.

FamilySearch is excited to sponsor the development of the GEDCOM X project, and the team
is dedicated to actively identifying and accommodating the needs and feedback of the community. We 
believe that the success of FamilySearch's platform is dependent on how well we can reach out
and incorporate the ideas of the community. Hopefully, it's no secret that FamilySearch intends 
to make GEDCOM X a core part of their Web service APIs, so it should come as no surprise that 
GEDCOM X must be able to support that.

## Implications

But let's talk about the practical implications of that requirement, because I think it's easy to
assume that it imposes more constraints than it really does.

First of all, **GEDCOM X must define a serialization format and an associated media type**. That means
that GEDCOM X has to define more than just an abstract model, it has to define how the data can be written
to disk or transferred over the Internet. No surprises there, right? Enough said.

Next, **GEDCOM X should be extensible**. Like all organizations, FamilySearch has their own ideas about
what their clients want and how to give it to them. Sometimes those ideas align with the mainstream
community and sometimes they don't. Regardless of how well FamilySearch is meeting the needs of their
customers, it needs to be able to implement those ideas even when the rest of the community doesn't
need/want to adopt them. Examples of these things include Discussions, Watches, Notifications, 
Hypermedia Links, and LDS Ordinances. GEDCOM X needs to be extensible so FamilySearch can add 
these kinds of features without imposing their proprietary decisions on the community.

## Non-Implications

Just because FamilySearch needs to use GEDCOM X as part of their platform API doesn't mean that
the goals of GEDCOM X are limited to what FamilySearch intends to initially provide as part of their
platform. **GEDCOM X may define concepts that FamilySearch doesn't intend to initially include**
in their platform API. I would hope that's obvious, but it's probably nice to have that explicitly 
stated. 

GEDCOM X already defines concepts that FamilySearch doesn't intend to support yet. These concepts include 
[shared events](https://github.com/FamilySearch/gedcomx/issues/134), citation templates, and a good 
chunk of [known fact types](https://github.com/FamilySearch/gedcomx/issues/161). GEDCOM X defines these 
concepts not because they're important to FamilySearch, but because they're important to _you_.
So even if you don't think FamilySearch will implement [postnoms](https://github.com/FamilySearch/gedcomx/pull/201)
or [dates on names](https://github.com/FamilySearch/gedcomx/issues/194) or whatever other feature you 
think is important, doesn't mean that it's outside the scope of GEDCOM X. Open up an issue! Let's discuss!

### The RDF Anecdote

One issue in particular needs to be cleared up. There seems to be an assumption that GEDCOM X includes
all the RDF and other noise because it's somehow needed to meet the project requirements. This
is _not_ the case.

The only reason RDF and the other XML noise was included was because we thought that it would be a good way 
to get the job done. (Okay, it was pretty much just me. I'll stick first person here so I don't have to 
implicate my team.) On one side of the coin are folks who just want a way to exchange genealogical data 
in the simplest, most straighforward manner. On the other side of the coin are folks that are genuinely 
sold on formal semantics and typing. I guess I thought that by integrating some of the RDF constructs into 
the serialization format, I could please both audiences, but it's becoming pretty obvious that I was wrong. 
Instead of pleasing both audiences, it ended up upsetting both audiences. 

So we'll be cleaning up the RDF mess presently, but what I hope you get out of this anecdote is that you
needn't be anxious about the requirements of the GEDCOM X project. They're not as constraining as you might think.
We all want to see a good, solid, useful way to exchange genealogical data. So [jump on in](http://www.gedcomx.org/Community.html), 
the water's fine.
