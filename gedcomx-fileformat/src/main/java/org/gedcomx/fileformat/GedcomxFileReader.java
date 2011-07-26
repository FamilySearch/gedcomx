package org.gedcomx.fileformat;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Standard interface for reading a GEDCOM X file.
 *
 * @author Ryan Heaton
 */
public interface GedcomxFileReader {

  /**
   * Get the value of the specified file header.
   *
   * @param name The header name.
   * @return The header value.
   */
  String getHeader(String name);

  /**
   * Get the headers for the file.
   *
   * @return The headers.
   */
  Map<String, List<String>> getHeaders();

  /**
   * Get the parts of the file.
   *
   * @return The parts of the file.
   */
  Collection<GedcomxFilePart> getParts();
}
