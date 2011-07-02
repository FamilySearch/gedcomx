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
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.rt.AnyAttributeDeserializer;
import org.gedcomx.rt.AnyAttributeSerializer;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

/**
 * A qualifier for a source. Used for specifying things like bounding boxes and applicable fields.
 *
 * @author Ryan Heaton
 */
public final class SourceQualifier {

  private Map<QName, String> properties;

  /**
   * The qualifier properties.
   *
   * @return The qualifier properties.
   */
  @XmlAnyAttribute
  @XmlQNameEnumRef( SourceQualifierProperty.class )
  @JsonSerialize(using = AnyAttributeSerializer.class)
  public Map<QName, String> getProperties() {
    return properties;
  }

  /**
   * The qualifier properties.
   *
   * @param properties The qualifier properties.
   */
  @JsonDeserialize(using = AnyAttributeDeserializer.class)
  public void setProperties(Map<QName, String> properties) {
    this.properties = properties;
  }

  /**
   * Get a property by a qname.
   *
   * @param property The property qname.
   * @return The property value.
   */
  public String getProperty(QName property) {
    return this.properties == null ? null : this.properties.get(property);
  }

  /**
   * Get a property from an enumeration known qualifier properties.
   *
   * @param property The property.
   * @return The property value.
   */
  public String getProperty(SourceQualifierProperty property) {
    return getProperty(XmlQNameEnumUtil.toQName(property));
  }

  /**
   * Set a property value by qname.
   *
   * @param property The property qname.
   * @param value The value of the property.
   */
  public void setProperty(QName property, String value) {
    if (this.properties == null) {
      this.properties = new HashMap<QName, String>();
    }

    this.properties.put(property, value);
  }

  /**
   * Set a source qualifier property from an enumeration of known qualifier properties.
   *
   * @param property The qualifier property.
   * @param value The value of the qualifier property.
   */
  public void setProperty(SourceQualifierProperty property, String value) {
    setProperty(XmlQNameEnumUtil.toQName(property), value);
  }
}
