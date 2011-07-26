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
package org.gedcomx.fileformat;

import java.io.IOException;

/**
 * Part of a GEDCOM X file.
 *
 * @author Ryan Heaton
 */
public interface GedcomxFilePart {

  /**
   * The content id of the part.
   *
   * @return The content id of the part.
   */
  String getCid();

  /**
   * The media type of the part.
   *
   * @return The media type of the part.
   */
  String getMediaType();

  /**
   * The content of the part. E.g. a JAXB root element or an InputStream.
   *
   * @return The content of the part.
   * @throws IOException If there was a problem reading the content.
   */
  Object getContent() throws IOException;

}
