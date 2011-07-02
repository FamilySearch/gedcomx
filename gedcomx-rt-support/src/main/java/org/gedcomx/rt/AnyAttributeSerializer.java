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

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.Map;

/**
 * Custom JSON serializer for @XmlAnyElement fields/properties
 *
 * @author Ryan Heaton
 */
public class AnyAttributeSerializer extends JsonSerializer<Map<QName, String>> {

  @Override
  public void serialize(Map<QName, String> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    if (value == null) {
      jgen.writeNull();
    }
    else {
      jgen.writeStartObject();
      try {
        for (Map.Entry<QName, String> entry : value.entrySet()) {
          if (entry.getKey() != null) {
            jgen.writeStringField(entry.getKey().toString(), entry.getValue());
          }
        }
      }
      finally {
        jgen.writeEndObject();
      }
    }
  }
}
