/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.internal.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.mapstruct.ap.internal.model.assignment.AssignmentWrapper;
import org.mapstruct.ap.internal.model.assignment.ReturnWrapper;
import org.mapstruct.ap.internal.model.common.Assignment;
import org.mapstruct.ap.internal.model.common.ModelElement;
import org.mapstruct.ap.internal.model.common.Parameter;
import org.mapstruct.ap.internal.model.common.Type;
import org.mapstruct.ap.internal.util.TypeUtils;

/**
 * @author Ben Zegveld
 */
public class SubClassMapping extends ModelElement {

    private final Type sourceType;
    private Type targetType;
    private Assignment assignment;
    private String sourceArgument;
    private TypeUtils typeUtils;

    public SubClassMapping(Type sourceType, Type targetType, TypeUtils typeUtils) {
        this.sourceType = sourceType;
        this.targetType = targetType;
        this.typeUtils = typeUtils;
    }

    public Type getSourceType() {
        return sourceType;
    }

    @Override
    public Set<Type> getImportTypes() {
        return new HashSet<>( Arrays.asList( sourceType, targetType ) );
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public AssignmentWrapper getAssignment() {
        return new ReturnWrapper( assignment );
    }

    public void updateWithParameters(List<Parameter> parameters) {
        for ( Parameter parameter : parameters ) {
            if ( typeUtils.isAssignable( sourceType.getTypeMirror(), parameter.getType().getTypeMirror() ) ) {
                sourceArgument = parameter.getName();
                assignment.setSourceLocalVarName( "(" + sourceType.createReferenceName() + ") " + sourceArgument );
            }
        }
    }

    public String getSourceArgument() {
        return sourceArgument;
    }

    @Override
    public boolean equals(final Object other) {
        if ( !( other instanceof SubClassMapping ) ) {
            return false;
        }
        SubClassMapping castOther = (SubClassMapping) other;
        return Objects.equals( sourceType, castOther.sourceType ) && Objects.equals( targetType, castOther.targetType );
    }

    @Override
    public int hashCode() {
        return Objects.hash( sourceType, targetType );
    }
}
