/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.work.impl.logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class InternalLoggerTest {

    private static final String TAG = "InternalLoggerTest";

    @Rule
    public ExpectedException mThrown = ExpectedException.none();

    @Before
    public void setUp() {
        InternalLogger.LOG_LEVEL = Log.VERBOSE;
    }

    @Test
    public void testLog_verbose() {
        assertThat(InternalLogger.isLoggable(Log.VERBOSE), is(true));
        InternalLogger.LOG_LEVEL = Log.DEBUG;
        assertThat(InternalLogger.isLoggable(Log.VERBOSE), is(false));
    }

    @Test
    public void testLog_debug() {
        assertThat(InternalLogger.isLoggable(Log.DEBUG), is(true));
        InternalLogger.LOG_LEVEL = Log.INFO;
        assertThat(InternalLogger.isLoggable(Log.DEBUG), is(false));
    }

    @Test
    public void testLog_info() {
        assertThat(InternalLogger.isLoggable(Log.INFO), is(true));
        InternalLogger.LOG_LEVEL = Log.WARN;
        assertThat(InternalLogger.isLoggable(Log.INFO), is(false));
    }

    @Test
    public void testLog_warn() {
        assertThat(InternalLogger.isLoggable(Log.WARN), is(true));
        InternalLogger.LOG_LEVEL = Log.ERROR;
        assertThat(InternalLogger.isLoggable(Log.WARN), is(false));
    }

    @Test
    public void testLog_error() {
        assertThat(InternalLogger.isLoggable(Log.ERROR), is(true));
        InternalLogger.LOG_LEVEL = Log.ASSERT;
        assertThat(InternalLogger.isLoggable(Log.ERROR), is(false));
    }
}