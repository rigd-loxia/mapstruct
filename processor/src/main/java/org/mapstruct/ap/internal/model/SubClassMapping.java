package org.mapstruct.ap.internal.model;

import org.mapstruct.ap.internal.model.common.Type;

public class SubClassMapping {

    public final Type sourceType;

    public SubClassMapping(Type sourceType) {
        this.sourceType = sourceType;
    }

    public Type getSourceType() {
        return sourceType;
    }
}
