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
import org.gedcomx.types.NameStyle;
import org.gedcomx.types.NameType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.util.List;

/**
 * A conclusion about the name of a person.
 *
 * @author Ryan Heaton
 */
@XmlType (propOrder = { "primaryForm", "alternateForms" })
public class Name extends Conclusion {

  private QName type;
  private QName style;
  private NameForm primaryForm;
  private List<NameForm> alternateForms;

  @XmlAttribute
  @XmlQNameEnumRef (NameType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public NameType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), NameType.class);
  }

  public void setKnownType(NameType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  @XmlAttribute
  @XmlQNameEnumRef(NameStyle.class)
  public QName getStyle() {
    return style;
  }

  public void setStyle(QName style) {
    this.style = style;
  }

  @XmlTransient
  public NameStyle getKnownStyle() {
    return XmlQNameEnumUtil.fromQName(getType(), NameStyle.class);
  }

  public void setKnownStyle(NameStyle knownStyle) {
    this.style = XmlQNameEnumUtil.toQName(knownStyle);
  }

  public NameForm getPrimaryForm() {
    return primaryForm;
  }

  public void setPrimaryForm(NameForm primaryForm) {
    this.primaryForm = primaryForm;
  }

  public List<NameForm> getAlternateForms() {
    return alternateForms;
  }

  public void setAlternateForms(List<NameForm> alternateForms) {
    this.alternateForms = alternateForms;
  }
}
