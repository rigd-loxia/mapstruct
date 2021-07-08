/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
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
@Repeatable( value = SubClassMappings.class )
@Retention( RetentionPolicy.CLASS )
@Target( { ElementType.METHOD, ElementType.ANNOTATION_TYPE } )
public @interface SubClassMapping {
    /**
     * @return the source subclass to check for before using the default mapping as fallback.
     */
    Class<?> sourceClass();

    /**
     * @return the target subclass to map the sourceSubClass to.
     */
    Class<?> targetClass();
}
