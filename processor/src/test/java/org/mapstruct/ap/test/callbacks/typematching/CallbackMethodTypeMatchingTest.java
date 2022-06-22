/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.callbacks.typematching;

import static org.assertj.core.api.Assertions.assertThat;

import org.mapstruct.ap.test.callbacks.typematching.CarMapper.CarDto;
import org.mapstruct.ap.test.callbacks.typematching.CarMapper.CarEntity;
import org.mapstruct.testutil.ProcessorTest;
import org.mapstruct.testutil.WithClasses;

/**
 * @author Andreas Gudian
 *
 */
@WithClasses({
    CarMapper.class
})
public class CallbackMethodTypeMatchingTest {
    @ProcessorTest
    public void callbackMethodAreCalled() {
        CarEntity carEntity = CarMapper.INSTANCE.toCarEntity( new CarDto() );

        assertThat( carEntity.getId() ).isEqualTo( 2 );
        assertThat( carEntity.getSeatCount() ).isEqualTo( 5 );
    }
}
