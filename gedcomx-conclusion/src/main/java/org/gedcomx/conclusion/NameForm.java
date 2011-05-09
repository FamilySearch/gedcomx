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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.NameScript;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.List;

/**
 * A form of a name.
 *
 * @author Ryan Heaton
 */
public class NameForm {

  private QName script;
  private String fullText;
  private List<NamePart> parts;

  /**
   * The script of the name form.
   *
   * @return The script of the name form.
   */
  @XmlAttribute
  @XmlQNameEnumRef (NameScript.class)
  public QName getScript() {
    return script;
  }

  /**
   * The script of the name form.
   *
   * @param script The script of the name form.
   */
  public void setScript(QName script) {
    this.script = script;
  }

  /**
   * The enum referencing the known name form script, or {@link org.gedcomx.types.NameScript#other} if not known.
   *
   * @return The enum referencing the known name form script, or {@link org.gedcomx.types.NameScript#other} if not known.
   */
  @XmlTransient
  public NameScript getKnownScript() {
    return XmlQNameEnumUtil.fromQName(getScript(), NameScript.class);
  }

  /**
   * The enum referencing the known name form script, or {@link org.gedcomx.types.NameScript#other} if not known.
   *
   * @param knownScript The enum referencing the known name form script, or {@link org.gedcomx.types.NameScript#other} if not known.
   */
  public void setKnownScript(NameScript knownScript) {
    this.script = XmlQNameEnumUtil.toQName(knownScript);
  }

  /**
   * The full text of the name form.
   *
   * @return The full text of the name form.
   */
  public String getFullText() {
    return fullText;
  }

  /**
   * The full text of the name form.
   *
   * @param fullText The full text of the name form.
   */
  public void setFullText(String fullText) {
    this.fullText = fullText;
  }

  /**
   * The different parts of the name form.
   *
   * @return The different parts of the name form.
   */
  @XmlElementWrapper (name = "parts")
  @XmlElement (name = "part")
  public List<NamePart> getParts() {
    return parts;
  }

  /**
   * The different parts of the name form.
   *
   * @param parts The different parts of the name form.
   */
  public void setParts(List<NamePart> parts) {
    this.parts = parts;
  }
}
