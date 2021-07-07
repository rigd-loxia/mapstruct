package org.mapstruct.ap.internal.model.source;

import static org.mapstruct.ap.internal.util.Message.ENUMMAPPING_MISSING_CONFIGURATION;

import java.util.Collections;
import java.util.List;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeMirror;

import org.mapstruct.ap.internal.gem.SubClassMappingGem;
import org.mapstruct.ap.internal.util.FormattingMessager;
import org.mapstruct.ap.internal.util.TypeUtils;

// is this extends needed?
public class SubClassMappingOptions extends DelegatingOptions {

    private List<TypeMirror> subClasses;

    public SubClassMappingOptions(List<TypeMirror> subClasses, DelegatingOptions next) {
        super( next );
        this.subClasses = subClasses;
    }

    @Override
    public boolean hasAnnotation() {
        return !subClasses.isEmpty();
    }

    public static SubClassMappingOptions getInstanceOn(ExecutableElement method, MapperOptions mapperOptions,
                                                       FormattingMessager messager, TypeUtils typeUtils) {

        SubClassMappingGem subClassMapping = SubClassMappingGem.instanceOn( method );
        if ( subClassMapping == null ) {
            return new SubClassMappingOptions( Collections.emptyList(), mapperOptions );
        }
        else if ( !isConsistent( subClassMapping, method, messager, typeUtils ) ) {
            return new SubClassMappingOptions( Collections.emptyList(), mapperOptions );
        }

        List<TypeMirror> subClasses = subClassMapping.subClasses().getValue();

        return new SubClassMappingOptions( subClasses, mapperOptions );
    }

    private static boolean isConsistent(SubClassMappingGem gem, ExecutableElement method, FormattingMessager messager,
                                        TypeUtils typeUtils) {

        List<TypeMirror> subClasses = gem.subClasses().getValue();

        boolean isConsistent = true;

        TypeMirror parentType = method.getParameters().get( 0 ).asType();
        for ( TypeMirror childType : subClasses ) {
            if ( !isChildOfParent( typeUtils, childType, parentType ) ) {
                messager
                        .printMessage(
                            method,
                            gem.mirror(),
                            ENUMMAPPING_MISSING_CONFIGURATION,
                            parentType.toString(),
                            childType.toString() );
                return false;
            }
        }
        return isConsistent;
    }

    private static boolean isChildOfParent(TypeUtils typeUtils, TypeMirror childType, TypeMirror parentType) {
        return typeUtils.isAssignable( childType, parentType );
    }

    public List<TypeMirror> getSubClasses() {
        return subClasses;
    }
}
