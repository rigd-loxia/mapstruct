package org.mapstruct;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Configures the mapping to handle hierarchy of the source type.
 * <p>
 * The subclasses to check for when handling this conversion method must be added.
 * </p>
 * 
 * @author Ben Zegveld
 */
@Retention( RetentionPolicy.CLASS )
@Target( { ElementType.METHOD, ElementType.ANNOTATION_TYPE } )
public @interface SubClassMapping {
    /**
     * @return the source subclasses to check for before using the default mapping as fallback.
     */
    Class<?>[] subClasses();
}
