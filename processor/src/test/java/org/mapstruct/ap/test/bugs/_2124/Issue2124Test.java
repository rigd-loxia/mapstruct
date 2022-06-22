/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.bugs._2124;

import static org.assertj.core.api.Assertions.assertThat;

import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.testutil.ProcessorTest;
import org.mapstruct.testutil.WithClasses;

/**
 * @author Filip Hrisafov
 */
@IssueKey("2124")
@WithClasses({
    CommitComment.class,
    Issue2124Mapper.class
})
public class Issue2124Test {

    @ProcessorTest
    public void shouldCompile() {

        CommitComment clone = Issue2124Mapper.INSTANCE.clone( new CommitComment( 100 ), null );
        assertThat( clone ).isNotNull();
        assertThat( clone.getIssueId() ).isEqualTo( 200 );

        clone = Issue2124Mapper.INSTANCE.clone( new CommitComment( null ), null );
        assertThat( clone ).isNotNull();
        assertThat( clone.getIssueId() ).isNull();
    }
}
