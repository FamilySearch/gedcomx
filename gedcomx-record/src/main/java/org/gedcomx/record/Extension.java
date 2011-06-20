package org.gedcomx.record;

import javax.xml.bind.annotation.XmlAnyElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * An extension point to the record model.
 *
 * @author Ryan Heaton
 */
public class Extension implements Iterable<Object> {

  private List<Object> elements;

  /**
   * The extension elements.
   *
   * @return The extension elements.
   */
  @XmlAnyElement (lax = true)
  public List<Object> getElements() {
    return elements;
  }

  /**
   * The extension elements.
   *
   * @param elements The extension elements.
   */
  public void setElements(List<Object> elements) {
    this.elements = elements;
  }

  /**
   * Iterator through the extension elements.
   *
   * @return The iterator through the extension elements.
   */
  public Iterator<Object> iterator() {
    return this.elements == null ? Collections.<Object>emptyList().iterator() : this.elements.iterator();
  }

  /**
   * Finds the first extension of a specified type.
   *
   * @param clazz The type.
   * @return The extension, or null if none found.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> E findExtensionOfType(Class<E> clazz) {
    if (this.elements != null) {
      for (Object extension : elements) {
        if (clazz.isInstance(extension)) {
          return (E) extension;
        }
      }
    }

    return null;
  }

  /**
   * Find the extensions of a specified type.
   *
   * @param clazz The type.
   * @return The extensions, possibly empty but not null.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> List<E> findExtensionsOfType(Class<E> clazz) {
    List<E> ext = new ArrayList<E>();
    if (this.elements != null) {
      for (Object extension : elements) {
        if (clazz.isInstance(extension)) {
          ext.add((E) extension);
        }
      }
    }

    return ext;
  }
}
