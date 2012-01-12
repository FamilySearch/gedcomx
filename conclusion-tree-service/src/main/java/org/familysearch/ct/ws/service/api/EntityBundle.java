package org.familysearch.ct.ws.service.api;

import java.util.Date;

/**
 * A bundle of an entity with associated metadata.
 *
 * @author Ryan Heaton
 */
public interface EntityBundle<E> {

  /**
   * The date that the entity was last modified.
   *
   * @return The date that the entity was last modified.
   */
  Date getLastModified();

  /**
   * Get the entity. It is suggested that implementations of this method be "lazy" because the method might not get invoked based on the
   * conditions of the entity metadata.
   *
   * @return Get the entity.
   */
  E getEntity();
}
