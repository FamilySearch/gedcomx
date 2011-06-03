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
package org.gedcomx.build.enunciate;

import org.codehaus.enunciate.main.ClasspathHandler;
import org.codehaus.enunciate.main.ClasspathResource;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Ryan Heaton
 */
public class GEDCOMXClasspathHandler implements ClasspathHandler {

  private final Map<String, ProfileMetadata> profileMetadata = new HashMap<String, ProfileMetadata>();

  public void startPathEntry(File pathEntry) {
  }

  public void handleResource(ClasspathResource resource) {
    try {
      String path = resource.getPath();
      if ("META-INF/gedcomx-profile.properties".equals(path)) {
        Properties props = new Properties();
        props.load(resource.read());

        if (props.getProperty("profile.namespace") != null) {
          ProfileMetadata metadata = new ProfileMetadata();
          metadata.setNamespace(props.getProperty("profile.namespace"));
          metadata.setId(props.getProperty("profile.id"));
          metadata.setLabel(props.getProperty("profile.label"));
          metadata.setXmlMediaType(props.getProperty("profile.mediaType.xml"));
          metadata.setJsonMediaType(props.getProperty("profile.mediaType.json"));
          metadata.setVersion(props.getProperty("profile.version"));
          metadata.setDescription(props.getProperty("profile.description"));
          this.profileMetadata.put(metadata.getNamespace(), metadata);

          int i = 0;
          while (i <= 2 || props.getProperty("profile" + i + ".namespace") != null) {
            if (props.getProperty("profile" + i + ".namespace") != null) {
              metadata = new ProfileMetadata();
              metadata.setNamespace(props.getProperty("profile" + i + ".namespace"));
              metadata.setId(props.getProperty("profile" + i + ".id"));
              metadata.setLabel(props.getProperty("profile" + i + ".label"));
              metadata.setXmlMediaType(props.getProperty("profile" + i + ".mediaType.xml"));
              metadata.setJsonMediaType(props.getProperty("profile" + i + ".mediaType.json"));
              metadata.setVersion(props.getProperty("profile" + i + ".version"));
              metadata.setDescription(props.getProperty("profile" + i + ".description"));
              this.profileMetadata.put(metadata.getNamespace(), metadata);
            }
            i++;
          }
        }
      }
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public boolean endPathEntry(File pathEntry) {
    return false;
  }

  public ProfileMetadata getProfileMetadata(String namespace) {
    return this.profileMetadata.get(namespace);
  }
}
