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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * A nice namespace prefix mapper that can be used to make XML output as pretty as it can be.
 *
 * @author Ryan Heaton
 */
public class GedcomNamespaceManager extends NamespacePrefixMapper {

  private final String defaultns;
  private final Map<String, String> ns2prefix;

  private static Map<String, String> KNOWN_PREFIXES = null;
  private static final Map<String, String> RUNTIME_VERSIONS = new HashMap<String, String>();

  public GedcomNamespaceManager(Class<?> rootClass) {
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

  public GedcomNamespaceManager(Map<String, String> overrides, String defaultns) {
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

  public GedcomNamespaceManager(String defaultns) {
    this(null, defaultns);
  }

  public GedcomNamespaceManager(Map<String, String> overrides) {
    this(overrides, null);
  }

  public GedcomNamespaceManager() {
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
      ns2prefix.put("http://gedcomx.org/record/v1/", "gxr");
      ns2prefix.put("http://gedcomx.org/conclusion/v1/", "gxc");
      Map<String, String> namespacePrefixes = loadNamespacePrefixes(Thread.currentThread().getContextClassLoader());
      ns2prefix.putAll(namespacePrefixes);

      KNOWN_PREFIXES = ns2prefix;
    }

    return KNOWN_PREFIXES;
  }

  protected static Map<String, String> loadNamespacePrefixes(ClassLoader loader) {
    Map<String, String> namespacePrefixes = new HashMap<String, String>();
    Set<Class<?>> modelClasses = new HashSet<Class<?>>();
    modelClasses.add(CommonModels.class);

    try {
      Enumeration<URL> resources = loader.getResources("META-INF/gedcomx.models");
      while (resources.hasMoreElements()) {
        try {
          URL resource = resources.nextElement();
          BufferedReader reader = new BufferedReader(new InputStreamReader(resource.openStream()));
          String classname = reader.readLine();
          while (classname != null) {
            modelClasses.add(Class.forName(classname, true, loader));
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

    for (Class<?> modelClass : modelClasses) {
      Models modelsInfo = modelClass.getAnnotation(Models.class);
      for (Model model : modelsInfo.value()) {
        namespacePrefixes.put(model.namespace(), model.id());
      }
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

  /**
   * Get the version of the runtime java library that defines the model for the given namespace.
   *
   * @param namespace The model namespace.
   * @return The runtime version.
   */
  public synchronized static String getRuntimeVersion(String namespace) {
    String prefix = getKnownPrefixes().get(namespace);
    String version = RUNTIME_VERSIONS.get(prefix);
    if (version == null) {
      InputStream in = GedcomNamespaceManager.class.getClassLoader().getResourceAsStream("META-INF/" + prefix + ".rt.properties");
      if (in != null) {
        Properties properties = new Properties();
        try {
          properties.load(in);
          version = properties.getProperty("version");
        }
        catch (IOException e) {
          version = null;
        }
      }

      if (version == null) {
        version = "(unknown)";
      }

      RUNTIME_VERSIONS.put(prefix, version);
    }
    return version;
  }

}
