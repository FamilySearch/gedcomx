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
package org.gedcomx.common;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Conclusion data that has notes.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "HasNotes" )
public interface HasNotes {

  /**
   * The notes of a conclusion resource.
   *
   * @return The notes of a conclusion resource.
   */
  List<Note> getNotes();

  /**
   * The notes of a conclusion resource.
   *
   * @param notes The notes of a conclusion resource.
   */
  void setNotes(List<Note> notes);
}
