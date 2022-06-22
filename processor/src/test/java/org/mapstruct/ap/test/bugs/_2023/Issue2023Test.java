/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.bugs._2023;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.mapstruct.testutil.IssueKey;
import org.mapstruct.testutil.ProcessorTest;
import org.mapstruct.testutil.WithClasses;

/**
 * @author Filip Hrisafov
 */
@IssueKey("2023")
@WithClasses({
    Issue2023Mapper.class,
    NewPersonRequest.class,
    PersonDto.class,
})
public class Issue2023Test {

    @ProcessorTest
    public void shouldUseDefaultExpressionCorrectly() {
        PersonDto person = new PersonDto();
        person.setName( "John" );
        person.setEmail( "john@doe.com" );

        NewPersonRequest request = Issue2023Mapper.INSTANCE.createRequest( person, null );

        assertThat( request ).isNotNull();
        assertThat( request.getName() ).isEqualTo( "John" );
        assertThat( request.getEmail() ).isEqualTo( "john@doe.com" );
        assertThat( request.getCorrelationId() ).isNotNull();

        UUID correlationId = UUID.randomUUID();
        request = Issue2023Mapper.INSTANCE.createRequest( person, correlationId );

        assertThat( request ).isNotNull();
        assertThat( request.getName() ).isEqualTo( "John" );
        assertThat( request.getEmail() ).isEqualTo( "john@doe.com" );
        assertThat( request.getCorrelationId() ).isEqualTo( correlationId );
    }
}
