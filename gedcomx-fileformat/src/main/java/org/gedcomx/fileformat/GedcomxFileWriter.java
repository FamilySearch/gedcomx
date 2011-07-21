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
import java.io.OutputStream;

/**
 * Standard interface for writing a GEDCOM X file.
 *
 * @author Ryan Heaton
 */
public interface GedcomxFileWriter {

  /**
   * Add a part to the file.
   *
   * @param mediaType The media type for the part. Examples include "image/png", "application/x-gedcom-conclusion-v1+xml", etc.
   * @param content The content. Possible types include a JAXB root element, a string, or an InputStream.
   * @return The content id for the type.
   */
  String addPart(String mediaType, Object content);

  /**
   * Set a specific header for this part.
   *
   * @param name The header name.
   * @param value The header value.
   * @throws IllegalArgumentException If <tt>name</tt> doesn't start with "Content-".
   */
  void setHeader(String name, String value);

  /**
   * Writes this file.
   *
   * @param out The output stream to write to.
   * @throws IOException If there was a problem writing the file.
   */
  void writeTo(OutputStream out) throws IOException;
}
