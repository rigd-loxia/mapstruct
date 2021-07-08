package org.mapstruct.ap.internal.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mapstruct.ap.internal.model.common.ModelElement;
import org.mapstruct.ap.internal.model.common.Type;
import java.util.Objects;

public class SubClassMapping extends ModelElement {

    private final Type sourceType;
    private Type targetType;
    private MappingMethod mappingMethod;

    public SubClassMapping(Type sourceType, Type targetType) {
        this.sourceType = sourceType;
        this.targetType = targetType;
    }

    public Type getSourceType() {
        return sourceType;
    }

    public void setMappingMethod(List<MappingMethod> methods) {
        for ( MappingMethod mappingMethod : methods ) {
            if ( mappingMethod.getParameters().size() == 1
                && mappingMethod.getParameters().get( 0 ).getType().equals( sourceType )
                && mappingMethod.getResultType().equals( targetType ) ) {
                this.mappingMethod = mappingMethod;
            }
        }
    }

    @Override
    public Set<Type> getImportTypes() {
        return new HashSet<>( Arrays.asList( sourceType, targetType ) );
    }

    public String getMappingMethod() {
        return mappingMethod.getName();
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
