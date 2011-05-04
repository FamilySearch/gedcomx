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
package org.gedcomx.source;

import org.codehaus.enunciate.XmlQNameEnumUtil;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public class SourceQualifier {

  private Map<QName, String> properties;

  @XmlAnyAttribute
  public Map<QName, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<QName, String> properties) {
    this.properties = properties;
  }

  public String getProperty(QName property) {
    return this.properties == null ? null : this.properties.get(property);
  }

  public String getProperty(SourceQualifierProperty property) {
    return getProperty(XmlQNameEnumUtil.toQName(property));
  }
  
  public void setProperty(QName property, String value) {
    if (this.properties == null) {
      this.properties = new HashMap<QName, String>();
    }

    this.properties.put(property, value);
  }
  
  public void setProperty(SourceQualifierProperty property, String value) {
    setProperty(XmlQNameEnumUtil.toQName(property), value);
  }
}
