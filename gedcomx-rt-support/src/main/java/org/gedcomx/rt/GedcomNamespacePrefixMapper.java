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

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * A nice namespace prefix mapper that can be used to make XML output as pretty as it can be.
 *
 * @author Ryan Heaton
 */
public class GedcomNamespacePrefixMapper extends NamespacePrefixMapper {

  private final String defaultns;
  private final Map<String, String> ns2prefix;

  private static Map<String, String> KNOWN_PREFIXES = null;

  public GedcomNamespacePrefixMapper(Class<?> rootClass) {
    this(getDefaultNamespace(rootClass));
  }

  private static String getDefaultNamespace(Class<?> rootClass) {
    DefaultNamespace defaultNs = rootClass.getAnnotation(DefaultNamespace.class);
    if (defaultNs == null && rootClass.getPackage() != null) {
      defaultNs = rootClass.getPackage().getAnnotation(DefaultNamespace.class);
    }

    String defaultNamespace = "";
    if (defaultNs != null) {
      defaultNamespace = defaultNs.value();
    }
    else {
      XmlRootElement rootElement = rootClass.getAnnotation(XmlRootElement.class);
      if (rootElement != null) {
        if ("##default".equals(rootElement.namespace())) {
          if (rootClass.getPackage() != null) {
            XmlSchema xmlSchema = rootClass.getPackage().getAnnotation(XmlSchema.class);
            if (xmlSchema != null) {
              defaultNamespace = xmlSchema.namespace();
            }
          }
        }
        else {
          defaultNamespace = rootElement.namespace();
        }
      }
    }

    return defaultNamespace;
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
  public static synchronized Map<String, String> getKnownPrefixes() {
    if (KNOWN_PREFIXES == null) {
      Map<String, String> ns2prefix = new HashMap<String, String>();
      ns2prefix.put("http://www.w3.org/1999/xlink", "xlink");
      ns2prefix.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
      Map<String, String> namespacePrefixes = loadNamespacePrefixes(Thread.currentThread().getContextClassLoader());
      ns2prefix.putAll(namespacePrefixes);

      KNOWN_PREFIXES = ns2prefix;
    }

    return KNOWN_PREFIXES;
  }

  protected static Map<String, String> loadNamespacePrefixes(ClassLoader loader) {
    Map<String, String> namespacePrefixes = new HashMap<String, String>();
    try {
      Enumeration<URL> resources = loader.getResources("META-INF/gedcomx.namespaces");
      while (resources.hasMoreElements()) {
        try {
          URL resource = resources.nextElement();
          BufferedReader reader = new BufferedReader(new InputStreamReader(resource.openStream()));
          String classname = reader.readLine();
          while (classname != null) {
            Namespaces namespacesInfo = Class.forName(classname, true, loader).getAnnotation(Namespaces.class);
            for (Namespace ns : namespacesInfo.value()) {
              namespacePrefixes.put(ns.uri(), ns.id());
            }
            classname = reader.readLine();
          }
        }
        catch (Exception e) {
          //no-op...
        }
      }
    }
    catch (IOException e) {
      //no-op.
    }
    return namespacePrefixes;
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
