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

  private Map<QName, String> attributes;

  /**
   * The qualifier attributes.
   *
   * @return The qualifier attributes.
   */
  @XmlAnyAttribute
  @XmlQNameEnumRef( SourceQualifierAttribute.class )
  @JsonSerialize(using = AnyAttributeSerializer.class)
  public Map<QName, String> getAttributes() {
    return attributes;
  }

  /**
   * The qualifier attributes.
   *
   * @param attributes The qualifier attributes.
   */
  @JsonDeserialize(using = AnyAttributeDeserializer.class)
  public void setAttributes(Map<QName, String> attributes) {
    this.attributes = attributes;
  }

  /**
   * Get an attribute by a qname.
   *
   * @param attribute The attribute qname.
   * @return The attribute value.
   */
  public String getAttribute(QName attribute) {
    return this.attributes == null ? null : this.attributes.get(attribute);
  }

  /**
   * Get an attribute from an enumeration of known qualifier attributes.
   *
   * @param attribute The attribute.
   * @return The attribute value.
   */
  public String getAttribute(SourceQualifierAttribute attribute) {
    return getAttribute(XmlQNameEnumUtil.toQName(attribute));
  }

  /**
   * Set an attribute value by qname.
   *
   * @param attribute The attribute qname.
   * @param value The value of the attribute.
   */
  public void setAttribute(QName attribute, String value) {
    if (this.attributes == null) {
      this.attributes = new HashMap<QName, String>();
    }

    this.attributes.put(attribute, value);
  }

  /**
   * Set a source qualifier attribute from an enumeration of known qualifier attributes.
   *
   * @param attribute The qualifier attribute.
   * @param value The value of the qualifier attribute.
   */
  public void setAttribute(SourceQualifierAttribute attribute, String value) {
    setAttribute(XmlQNameEnumUtil.toQName(attribute), value);
  }
}
