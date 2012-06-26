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
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.*;

/**
 * @author Ryan Heaton
 */
public class KeyedListSerializer extends JsonSerializer<Collection<? extends HasUniqueJsonKey>> {

  public static final String JSON_DEFAULT_KEY = "$";

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
      Map<String, List<Object>> bykey = new HashMap<String, List<Object>>();
      for (Object keyed : value) {
        String jsonKey = ((HasJsonKey) keyed).getJsonKey();
        if (jsonKey == null) {
          jsonKey = JSON_DEFAULT_KEY;
        }

        List<Object> keyedList = bykey.get(jsonKey);
        if (keyedList == null) {
          keyedList = new ArrayList<Object>();
          bykey.put(jsonKey, keyedList);
        }
        keyedList.add(keyed);
      }

      for (Map.Entry<String, List<Object>> keyedObjects : bykey.entrySet()) {
        String jsonKey = keyedObjects.getKey();
        jgen.writeFieldName(jsonKey);
        boolean notUnique = keyedObjects.getValue().size() != 1 || (!(keyedObjects.getValue().get(0) instanceof HasUniqueJsonKey));
        if (notUnique) {
          jgen.writeStartArray();
        }

        for (Object keyed : keyedObjects.getValue()) {
          provider.findTypedValueSerializer(keyed.getClass(), true, null).serialize(keyed, jgen, provider);
        }

        if (notUnique) {
          jgen.writeEndArray();
        }
      }
      jgen.writeEndObject();
    }
  }
}
