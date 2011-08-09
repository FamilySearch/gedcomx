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

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.type.SimpleType;

import javax.xml.bind.annotation.XmlTransient;
import java.io.IOException;

/**
 * Adapter for a source reference to a more generic resource reference.
 *
 * @author Ryan Heaton
 */
@XmlTransient
public class SourceReferenceDeserializer extends JsonDeserializer<SourceReference> {

  private static final SourceReferenceAdapter ADAPTER = new SourceReferenceAdapter();
  private static final SimpleType RESOURCE_REFERENCE_TYPE = SimpleType.construct(ResourceReference.class);

  @Override
  public SourceReference deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    try {
      return ADAPTER.unmarshal((ResourceReference) ctxt.getDeserializerProvider().
        findTypedValueDeserializer(ctxt.getConfig(), RESOURCE_REFERENCE_TYPE, null)
        .deserialize(jp, ctxt));
    }
    catch (Exception e) {
      throw ctxt.instantiationException(SourceReference.class, e);
    }
  }

}
