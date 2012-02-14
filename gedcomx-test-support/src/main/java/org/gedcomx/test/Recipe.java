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
package org.gedcomx.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A recipe for doing something specific with the model.
 *
 * @author Mike Gardiner
 * @author Ryan Heaton
 */
@XmlRootElement
public class Recipe {

  private String title;
  private String description;
  private final List<Snippet> snippets = new ArrayList<Snippet>();
  private final Set<String> applicableTypes = new HashSet<String>();

  /**
   * @return Title of the recipe
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title - The recipe title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @param description - A description to associate with the recipe
   *
   * @return The associated recipe
   */
  public Recipe withDescription(String description) {
    setDescription(description);
    return this;
  }

  /**
   * @return Description of the recipe
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description - Description to assign to the recipe
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Add a code snippet.
   *
   * @param snippet The code snippet to add.
   */
  public void addSnippet(Snippet snippet) {
    this.snippets.add(snippet);
  }

  /**
   * Code snippets for the recipe.
   *
   * @return The code snippets.
   */
  @XmlElement
  public List<Snippet> getSnippets() {
    return snippets;
  }

  /**
   * Add a type for which this recipe is applicable.
   *
   * @param type The type for which this recipe is applicable.
   * @return this recipe.
   */
  public Recipe applicableTo(Class<?> type) {
    this.applicableTypes.add(type.getName());
    return this;
  }

  /**
   * The set of fully-qualified names of types to which this recipe is applicable.
   *
   * @return The set of fully-qualified names of types to which this recipe is applicable.
   */
  @XmlElement
  public Set<String> getApplicableTypes() {
    return applicableTypes;
  }

}
