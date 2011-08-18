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
public @interface RDFQName {

  String namespace() default "##default";

  String name() default "##default";

}
