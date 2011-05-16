package org.gedcomx.rt;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A nice namespace prefix mapper that can be used to make XML output as pretty as it can be.
 *
 * @author Ryan Heaton
 */
public class GedcomNamespacePrefixMapper extends NamespacePrefixMapper {

  private final String defaultns;
  private final Map<String, String> ns2prefix;

  public GedcomNamespacePrefixMapper(Class<?> rootClass) {
    this(gatherOverrides(rootClass), null);
  }

  private static Map<String, String> gatherOverrides(Class<?> rootClass) {
    Map<String, String> overrides = new HashMap<String, String>();
    if (rootClass.getPackage() != null) {
      XmlSchema schemaInfo = rootClass.getPackage().getAnnotation(XmlSchema.class);
      for (XmlNs xmlNs : schemaInfo.xmlns()) {
        overrides.put(xmlNs.namespaceURI(), xmlNs.prefix());
      }
    }
    return overrides;
  }

  public GedcomNamespacePrefixMapper(Map<String, String> overrides, String defaultns) {
    Map<String, String> ns2prefix = new HashMap<String, String>();
    ns2prefix.put("http://gedcomx.org/types", "gedtype");
    ns2prefix.put("http://gedcomx.org/id/v1", "gedid");
    ns2prefix.put("http://gedcomx.org/attribution/v1", "gedatt");
    ns2prefix.put("http://gedcomx.org/source/v1", "gedsrc");
    ns2prefix.put("http://gedcomx.org/record/v1", "gedrec");
    ns2prefix.put("http://gedcomx.org/conclusion/v1", "gedconc");

    ns2prefix.put("http://gedcomx.org/www/v1", "gedwww");
    ns2prefix.put("http://gedcomx.org/source/www/v1", "gedsrcw");
    ns2prefix.put("http://gedcomx.org/record/www/v1", "gedrecw");
    ns2prefix.put("http://gedcomx.org/conclusion/www/v1", "gedconcw");

    ns2prefix.put("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
    ns2prefix.put("http://purl.org/dc/terms/", "dcterms");
    ns2prefix.put("http://purl.org/dc/dcmitype/", "dctypes");
    ns2prefix.put("http://www.w3.org/1999/xlink", "xlink");
    ns2prefix.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
    if (overrides != null) {
      ns2prefix.putAll(overrides);
    }
    this.ns2prefix = Collections.unmodifiableMap(ns2prefix);
    if (defaultns == null) {
      defaultns = "";
    }
    this.defaultns = defaultns;
  }

  public GedcomNamespacePrefixMapper(String defaultns) {
    this(null, defaultns);
  }

  public GedcomNamespacePrefixMapper(Map<String, String> overrides) {
    this(overrides, null);
  }

  public GedcomNamespacePrefixMapper() {
    this(null, null);
  }

  @Override
  public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
    String choice = this.ns2prefix.get(namespaceUri);
    if (!requirePrefix && this.defaultns.equals(namespaceUri)) {
      return "";
    }
    return choice;
  }

  @Override
  public String[] getPreDeclaredNamespaceUris() {
    return new String[] {"http://gedcomx.org/types"}; //just make sure the 'types' namespace gets predeclared.
  }
}
