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
package org.gedcomx.build.enunciate.rs;

/**
 * @author Ryan Heaton
 */
public final class ResponseCode {

  private final int code;
  private final String condition;

  public ResponseCode(int code, String condition) {
    this.code = code;
    this.condition = condition;
  }

  public int getCode() {
    return code;
  }

  public String getCondition() {
    return condition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ResponseCode that = (ResponseCode) o;

    if (code != that.code) {
      return false;
    }
    if (condition != null ? !condition.equals(that.condition) : that.condition != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = code;
    result = 31 * result + (condition != null ? condition.hashCode() : 0);
    return result;
  }
}
