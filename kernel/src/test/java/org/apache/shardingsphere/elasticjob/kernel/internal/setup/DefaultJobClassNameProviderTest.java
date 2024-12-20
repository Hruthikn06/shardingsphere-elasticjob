/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.elasticjob.kernel.internal.setup;

import org.apache.shardingsphere.elasticjob.kernel.fixture.job.DetailedFooJob;
import org.apache.shardingsphere.elasticjob.kernel.fixture.job.FooJob;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DefaultJobClassNameProviderTest {
    
    @Test
    void assertGetOrdinaryClassJobName() {
        JobClassNameProvider jobClassNameProvider = new DefaultJobClassNameProvider();
        String result = jobClassNameProvider.getJobClassName(new DetailedFooJob());
        assertThat(result, is("org.apache.shardingsphere.elasticjob.kernel.fixture.job.DetailedFooJob"));
    }
    
    @Test
    void assertGetLambdaJobName() {
        JobClassNameProvider jobClassNameProvider = new DefaultJobClassNameProvider();
        FooJob lambdaFooJob = shardingContext -> {
        };
        String result = jobClassNameProvider.getJobClassName(lambdaFooJob);
        assertThat(result, is("org.apache.shardingsphere.elasticjob.kernel.internal.setup.DefaultJobClassNameProviderTest$$Lambda"));
    }
}
