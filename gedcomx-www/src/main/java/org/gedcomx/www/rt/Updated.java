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
package org.gedcomx.www.rt;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
public class Updated<T> extends Response {

  private final Response response;

  public Updated(Response response) {
    if (response.getStatus() != Status.NO_CONTENT.getStatusCode()) {
      throw new IllegalArgumentException();
    }

    this.response = response;
  }

  @Override
  public Object getEntity() {
    return response.getEntity();
  }

  @Override
  public int getStatus() {
    return response.getStatus();
  }

  @Override
  public MultivaluedMap<String, Object> getMetadata() {
    return response.getMetadata();
  }
}
