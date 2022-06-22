/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.injectionstrategy.jakarta.compileoptionconstructor;

import static java.lang.System.lineSeparator;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.mapstruct.ap.test.injectionstrategy.shared.CustomerDto;
import org.mapstruct.ap.test.injectionstrategy.shared.CustomerEntity;
import org.mapstruct.ap.test.injectionstrategy.shared.Gender;
import org.mapstruct.ap.test.injectionstrategy.shared.GenderDto;
import org.mapstruct.ap.testutil.runner.GeneratedSource;
import org.mapstruct.testutil.IssueKey;
import org.mapstruct.testutil.ProcessorTest;
import org.mapstruct.testutil.WithClasses;
import org.mapstruct.testutil.WithJakartaInject;
import org.mapstruct.testutil.compilation.annotation.ProcessorOption;

/**
 * Test constructor injection for component model jakarta with compile option
 * mapstruct.defaultInjectionStrategy=constructor
 *
 * @author Filip Hrisafov
 */
@IssueKey("2567")
@WithClasses({
    CustomerDto.class,
    CustomerEntity.class,
    Gender.class,
    GenderDto.class,
    CustomerJakartaCompileOptionConstructorMapper.class,
    GenderJakartaCompileOptionConstructorMapper.class
})
@ProcessorOption(name = "mapstruct.defaultInjectionStrategy", value = "constructor")
@WithJakartaInject
public class JakartaCompileOptionConstructorMapperTest {

    @RegisterExtension
    final GeneratedSource generatedSource = new GeneratedSource();

    @ProcessorTest
    public void shouldHaveJakartaInjection() {
        generatedSource.forMapper( CustomerJakartaCompileOptionConstructorMapper.class )
            .content()
            .contains( "import jakarta.inject.Inject;" )
            .contains( "import jakarta.inject.Named;" )
            .contains( "import jakarta.inject.Singleton;" )
            .contains( "private final GenderJakartaCompileOptionConstructorMapper" )
            .contains( "@Inject" + lineSeparator() +
                "    public CustomerJakartaCompileOptionConstructorMapperImpl" +
                "(GenderJakartaCompileOptionConstructorMapper" )
            .doesNotContain( "javax.inject" );
    }
}
