/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    Map<String, String> ns2prefix = getKnownPrefixes();
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

  /**
   * The known set of namespace-to-prefix mappings.
   *
   * @return The known set of namespace-to-prefix mappings.
   */
  public static Map<String, String> getKnownPrefixes() {
    Map<String, String> ns2prefix = new HashMap<String, String>();
    ns2prefix.put("http://gedcomx.org/types", "gxt");
    ns2prefix.put("http://gedcomx.org/id/v1", "gxid");
    ns2prefix.put("http://gedcomx.org/attribution/v1", "gxa");
    ns2prefix.put("http://gedcomx.org/source/v1", "gxs");
    ns2prefix.put("http://gedcomx.org/record/v1", "gxr");
    ns2prefix.put("http://gedcomx.org/conclusion/v1", "gxc");

    ns2prefix.put("http://gedcomx.org/www/v1", "gxw");
    ns2prefix.put("http://gedcomx.org/source/www/v1", "gxsw");
    ns2prefix.put("http://gedcomx.org/record/www/v1", "gxrw");
    ns2prefix.put("http://gedcomx.org/conclusion/www/v1", "gxcw");

    ns2prefix.put("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
    ns2prefix.put("http://purl.org/dc/terms/", "dcterms");
    ns2prefix.put("http://purl.org/dc/dcmitype/", "dctypes");
    ns2prefix.put("http://www.w3.org/1999/xlink", "xlink");
    ns2prefix.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
    return ns2prefix;
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
