package org.gedcomx.rt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates a type as an RDF Class.
 *
 * @link
 * @author Ryan Heaton
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ( ElementType.TYPE )
public @interface RDFClass {

  RDFQName subclassOf() default @RDFQName();

  String label() default "##default";

  String comment() default "##default";

}