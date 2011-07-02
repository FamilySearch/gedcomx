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
package org.gedcomx.rt;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom JSON serializer for @XmlAnyElement fields/properties
 *
 * @author Ryan Heaton
 */
public class AnyAttributeDeserializer extends JsonDeserializer<Map<QName, String>> {

  @Override
  public Map<QName, String> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    if (jp.getCurrentToken() != JsonToken.START_OBJECT) {
      throw new JsonParseException("Unable to read custom attributes from JSON: not a map of qname to string.", jp.getCurrentLocation());
    }

    Map<QName, String> attributes = new HashMap<QName, String>();
    for (jp.nextToken(); jp.getCurrentToken() != JsonToken.END_OBJECT; jp.nextToken()) {
      String qnameValue = jp.getCurrentName();
      jp.nextToken();

      String value = jp.getText();
      QName qname;
      try {
        qname = QName.valueOf(qnameValue);
      }
      catch (IllegalArgumentException e) {
        qname = new QName("", qnameValue);
      }
      attributes.put(qname, value);
    }

    return attributes;
  }
}
