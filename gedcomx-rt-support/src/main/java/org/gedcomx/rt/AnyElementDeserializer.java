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
import org.codehaus.jackson.map.jsontype.impl.AsPropertyTypeDeserializer;
import org.codehaus.jackson.map.type.SimpleType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom JSON serializer for @XmlAnyElement fields/properties
 *
 * @author Ryan Heaton
 */
public class AnyElementDeserializer extends JsonDeserializer<List> {

  private final XmlTypeIdResolver xmlTypeIdResolver;
  private final AsPropertyTypeDeserializer typeDeserializer;

  public AnyElementDeserializer() {
    this.xmlTypeIdResolver = new XmlTypeIdResolver();
    this.typeDeserializer = new AsPropertyTypeDeserializer(SimpleType.construct(Object.class), this.xmlTypeIdResolver, null, "@type");
  }

  @Override
  public List deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    if (!jp.isExpectedStartArrayToken()) {
      throw new JsonParseException("Unable to read custom elements from JSON: not an array.", jp.getCurrentLocation());
    }
    List list = new ArrayList();
    JsonToken t;
    while ((t = jp.nextToken()) != JsonToken.END_ARRAY) {
      Object value;
      if (t == JsonToken.VALUE_NULL) {
        value = null;
      }
      else {
        //todo: deserialize logic from custom element?
        value = this.typeDeserializer.deserializeTypedFromAny(jp, ctxt);
      }
      list.add(value);
    }
    return list;
  }
}
