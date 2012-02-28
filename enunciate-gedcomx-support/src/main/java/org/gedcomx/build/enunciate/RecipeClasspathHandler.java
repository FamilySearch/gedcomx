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
import org.codehaus.enunciate.main.Enunciate;
import org.gedcomx.test.Recipe;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Heaton
 */
public class RecipeClasspathHandler implements ClasspathHandler {

  private final Enunciate enunciate;
  private final List<Recipe> cases = new ArrayList<Recipe>();
  private final Unmarshaller unmarshaller;

  public RecipeClasspathHandler(Enunciate enunciate) {
    this.enunciate = enunciate;
    try {
      unmarshaller = JAXBContext.newInstance(Recipe.class).createUnmarshaller();
    }
    catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Recipe> getRecipes() {
    return cases;
  }

  @Override
  public void startPathEntry(File pathEntry) {
  }

  @Override
  public void handleResource(ClasspathResource resource) {
    if (resource.getPath().endsWith(".recipe.xml")) {
      try {
        this.cases.add((Recipe) unmarshaller.unmarshal(resource.read()));
      }
      catch (Exception e) {
        this.enunciate.error("Unable to unmarshal recipe %s: %s.", resource.getPath(), e.getMessage());
      }
    }
  }

  @Override
  public boolean endPathEntry(File pathEntry) {
    return false;
  }
}
