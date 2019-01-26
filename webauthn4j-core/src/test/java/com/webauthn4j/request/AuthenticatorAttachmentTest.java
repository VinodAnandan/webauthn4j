/*
 * Copyright 2002-2018 the original author or authors.
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

package com.webauthn4j.request;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthenticatorAttachmentTest {

    @Test
    public void create_test() throws InvalidFormatException {
        assertThat(AuthenticatorAttachment.create(null)).isNull();
        assertThat(AuthenticatorAttachment.create("platform")).isEqualTo(AuthenticatorAttachment.PLATFORM);
        assertThat(AuthenticatorAttachment.create("cross-platform")).isEqualTo(AuthenticatorAttachment.CROSS_PLATFORM);
    }

    @Test
    public void getValue_test() {
        assertThat(AuthenticatorAttachment.PLATFORM.getValue()).isEqualTo("platform");
    }

    @Test(expected = InvalidFormatException.class)
    public void create_invalid_value_test() throws InvalidFormatException {
        AuthenticatorAttachment.create("invalid");
    }

}