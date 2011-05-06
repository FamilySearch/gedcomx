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
package org.gedcomx.conclusion;

public class CoupleRelationship extends Relationship {

  private SpouseReference person1;
  private SpouseReference person2;

  public SpouseReference getPerson1() {
    return person1;
  }

  public void setPerson1(SpouseReference person1) {
    this.person1 = person1;
  }

  public SpouseReference getPerson2() {
    return person2;
  }

  public void setPerson2(SpouseReference person2) {
    this.person2 = person2;
  }
}
