package org.gedcomx.rt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates a member as an RDF Property.
 *
 * @link
 * @author Ryan Heaton
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ( { ElementType.METHOD, ElementType.FIELD} )
public @interface RDFProperty {

  String label() default "##default";

  String comment() default "##default";

  RDFQName subPropertyOf() default @RDFQName;

  RDFQName[] domain() default @RDFQName;
}
