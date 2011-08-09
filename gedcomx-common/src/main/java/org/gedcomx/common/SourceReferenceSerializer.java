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
package org.gedcomx.common;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import javax.xml.bind.annotation.XmlTransient;
import java.io.IOException;

/**
 * Adapter for a source reference to a more generic resource reference.
 *
 * @author Ryan Heaton
 */
@XmlTransient
public class SourceReferenceSerializer extends JsonSerializer<SourceReference> {

  private static final SourceReferenceAdapter ADAPTER = new SourceReferenceAdapter();

  @Override
  public void serialize(SourceReference value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    try {
      provider.findTypedValueSerializer(ResourceReference.class, true, null).serialize(ADAPTER.marshal(value), jgen, provider);
    }
    catch (Exception e) {
      throw new JsonMappingException("error while serializing a source reference", e);
    }
  }

}
