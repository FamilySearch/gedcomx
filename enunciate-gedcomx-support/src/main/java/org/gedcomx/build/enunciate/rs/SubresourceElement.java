/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
package org.gedcomx.build.enunciate.rs;

import org.codehaus.enunciate.contract.jaxb.TypeDefinition;

import javax.xml.namespace.QName;

/**
 * Container for a element supplying a subresource.
 * 
 * @author Ryan Heaton
 */
public class SubresourceElement {
  
  private final QName xmlName;
  private final TypeDefinition typeDefinition;
  private final String jsonName;
  private final boolean collection;
  private final ResourceDefinitionDeclaration definition;

  public SubresourceElement(QName xmlName, String jsonName, TypeDefinition typeDef, boolean collection, ResourceDefinitionDeclaration definition) {
    this.collection = collection;
    this.definition = definition;
    this.xmlName = xmlName;
    this.typeDefinition = typeDef;
    this.jsonName = jsonName;
  }

  /**
   * The xml name of the element.
   * 
   * @return The xml name of the element.
   */
  public QName getXmlName() {
    return this.xmlName;
  }

  /**
   * The json name of the element.
   * 
   * @return The json name of the element.
   */
  public String getJsonName() {
    return jsonName;
  }

  /**
   * The type of the element.
   *
   * @return The type of the element.
   */
  public TypeDefinition getTypeDefinition() {
    return typeDefinition;
  }

  /**
   * Whether the subresource element is part of a collection.
   *
   * @return Whether the subresource element is part of a collection.
   */
  public boolean isCollection() {
    return collection;
  }

  /**
   * The definition of the subresource.
   *
   * @return The definition of the subresource.
   */
  public ResourceDefinitionDeclaration getDefinition() {
    return definition;
  }
}
