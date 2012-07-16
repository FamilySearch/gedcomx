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

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.*;
import org.codehaus.jackson.map.type.CollectionType;

/**
 * GEDCOM Jackson module for Jackson customizations.
 *
 * @author Ryan Heaton
 */
public class GedcomJacksonModule extends Module {

  @Override
  public String getModuleName() {
    return "gedcomx";
  }

  @Override
  public Version version() {
    return new Version(1,0,0,null);
  }

  @Override
  public void setupModule(SetupContext context) {
    context.addBeanSerializerModifier(new GedcomBeanSerializerModifier());
    context.addBeanDeserializerModifier(new GedcomBeanDeserializerModifier());
    context.addDeserializers(new GedcomDeserializers());
    context.addSerializers(new GedcomSerializers());
  }

  protected static class GedcomSerializers extends Serializers.None {

    @Override
    public JsonSerializer<?> findCollectionSerializer(SerializationConfig config, CollectionType type, BeanDescription beanDesc, BeanProperty property, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) {
      if (type.getContentType() != null && HasJsonKey.class.isAssignableFrom(type.getContentType().getRawClass())) {
        return new KeyedListSerializer();
      }

      return super.findCollectionSerializer(config, type, beanDesc, property, elementTypeSerializer, elementValueSerializer);
    }
  }

  protected static class GedcomDeserializers extends Deserializers.None {

    @Override
    public JsonDeserializer<?> findCollectionDeserializer(CollectionType type, DeserializationConfig config, DeserializerProvider provider, BeanDescription beanDesc, BeanProperty property, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
      if (type.getContentType() != null && HasJsonKey.class.isAssignableFrom(type.getContentType().getRawClass())) {
        return new KeyedListDeserializer(type.getContentType().getRawClass());
      }

      return super.findCollectionDeserializer(type, config, provider, beanDesc, property, elementTypeDeserializer, elementDeserializer);
    }

  }

}
