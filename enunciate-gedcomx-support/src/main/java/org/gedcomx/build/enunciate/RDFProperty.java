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

import com.sun.mirror.declaration.AnnotationMirror;
import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.util.DeclarationVisitor;
import com.sun.mirror.util.SourcePosition;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author Ryan Heaton
 */
public class RDFProperty implements Declaration {

  private String qname;
  private String label;
  private String comment;
  private Set<String> domain;
  private Set<String> range;
  private String subPropertyOf;
  private SourcePosition position;

  public String getQname() {
    return qname;
  }

  public void setQname(String qname) {
    this.qname = qname;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Set<String> getDomain() {
    return domain;
  }

  public void setDomain(Set<String> domain) {
    this.domain = domain;
  }

  public Set<String> getRange() {
    return range;
  }

  public void setRange(Set<String> range) {
    this.range = range;
  }

  public String getSubPropertyOf() {
    return subPropertyOf;
  }

  public void setSubPropertyOf(String subPropertyOf) {
    this.subPropertyOf = subPropertyOf;
  }

  public SourcePosition getPosition() {
    return position;
  }

  public void setPosition(SourcePosition position) {
    this.position = position;
  }

  public String getDocComment() {
    return getComment();
  }

  public Collection<AnnotationMirror> getAnnotationMirrors() {
    return Collections.emptyList();
  }

  public <A extends Annotation> A getAnnotation(Class<A> aClass) {
    return null;
  }

  public Collection<Modifier> getModifiers() {
    return Collections.emptyList();
  }

  public String getSimpleName() {
    return getLabel();
  }

  public void accept(DeclarationVisitor declarationVisitor) {
    declarationVisitor.visitDeclaration(this);
  }
}
