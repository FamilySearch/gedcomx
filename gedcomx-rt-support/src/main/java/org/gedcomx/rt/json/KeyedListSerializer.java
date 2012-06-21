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
package org.gedcomx.rt.json;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.Collection;

/**
 * @author Ryan Heaton
 */
public class KeyedListSerializer extends JsonSerializer<Collection<? extends HasUniqueJsonKey>> {

  @Override
  public void serialize(Collection<? extends HasUniqueJsonKey> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    serializeGeneric(value, jgen, provider);
  }

  static void serializeGeneric(Collection<?> value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
    if (value == null) {
      jgen.writeNull();
    }
    else {
      jgen.writeStartObject();
      for (Object keyed : value) {
        String jsonKey = ((HasUniqueJsonKey) keyed).getJsonKey();
        if (jsonKey == null) {
          throw new JsonMappingException("Extension element of type " + keyed.getClass().getName() + " returned a null JSON key.");
        }
        jgen.writeFieldName(jsonKey);
        provider.findTypedValueSerializer(keyed.getClass(), true, null).serialize(keyed, jgen, provider);
      }
      jgen.writeEndObject();
    }
  }
}
