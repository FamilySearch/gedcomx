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

  @XmlAttribute
  @XmlQNameEnumRef (NameScript.class)
  public QName getScript() {
    return script;
  }

  public void setScript(QName script) {
    this.script = script;
  }

  @XmlTransient
  public NameScript getKnownScript() {
    return XmlQNameEnumUtil.fromQName(getScript(), NameScript.class);
  }

  public void setKnownScript(NameScript knownScript) {
    this.script = XmlQNameEnumUtil.toQName(knownScript);
  }

  public String getFullText() {
    return fullText;
  }

  public void setFullText(String fullText) {
    this.fullText = fullText;
  }

  @XmlElementWrapper (name = "parts")
  @XmlElement (name = "part")
  public List<NamePart> getParts() {
    return parts;
  }

  public void setParts(List<NamePart> parts) {
    this.parts = parts;
  }
}
