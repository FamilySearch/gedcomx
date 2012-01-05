---
title: GEDCOM X Discovery
date: 2011-12-22 15:00:00
---

Since the inception of the GEDCOM X project, we've known that GEDCOM X will be more than just a file format. GEDCOM X is also being developed as the standard for genealogical Web service APIs. To flesh out those API definitions, we're starting with the notion of discovery.

The GEDCOM X APIs are to be designed to conform to [RESTful architectural principles](http://en.wikipedia.org/wiki/Representational_State_Transfer), 
including the principle of [Hypermedia as the Engine of Application State](http://en.wikipedia.org/wiki/HATEOAS). From the perspective of
consumers of the GEDCOM X APis, this means that you don't have to manage a big list of URLs that map to the resources in the system, because 
everything is "linked". In other words, the _state of the application_ is being _driven_ by _hypermedia_.

So the only thing consumers should need to get started is the URL to the "discovery" resource, which serves as the entry point to all the
other resources in the application implementing the GEDCOM X standard. 

The GEDCOM X specification refers to standards that are already defined and adopted in the industry to define the discovery resource. It is defined 
by the [host meta](http://tools.ietf.org/html/draft-hammer-hostmeta) specification and modeled by [XRD](http://docs.oasis-open.org/xri/xrd/v1.0/xrd-1.0.html).

So here's an example request and response for the discovery resource:

#### Request
<pre>GET /.well-known/host-meta
Accept: application/xrd+xml</pre>

#### Response
<pre>HTTP/1.1 200 OK
Last-Modified: Thu, 05 Jan 2012 20:00:35 GMT
Content-Type: application/xrd+xml

<code class="prettyprint lang-xml">&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;yes&quot;?&gt;
&lt;XRD xmlns=&quot;http://docs.oasis-open.org/ns/xri/xrd-1.0&quot;&gt;
    &lt;Link href=&quot;...&quot; rel=&quot;...&quot;/&gt;
    &lt;Link href=&quot;...&quot; rel=&quot;...&quot;/&gt;
    &lt;Link href=&quot;...&quot; rel=&quot;...&quot;/&gt;
    &lt;Link href=&quot;...&quot; rel=&quot;...&quot;/&gt;
&lt;/XRD&gt;</code></pre>

