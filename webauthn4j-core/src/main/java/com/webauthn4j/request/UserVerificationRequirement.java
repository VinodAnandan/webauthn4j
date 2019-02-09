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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public enum UserVerificationRequirement {
    REQUIRED("required"),
    PREFERRED("preferred"),
    DISCOURAGED("discouraged");

    private String value;

    UserVerificationRequirement(String value) {
        this.value = value;
    }

    public static UserVerificationRequirement create(String value) {
        if (value == null) {
            return null;
        }
        switch (value) {
            case "required":
                return REQUIRED;
            case "preferred":
                return PREFERRED;
            case "discouraged":
                return DISCOURAGED;
            default:
                throw new IllegalArgumentException("value '" + value + "' is out of range");
        }
    }

    @JsonCreator
    private static UserVerificationRequirement fromJson(String value) throws InvalidFormatException{
        try{
            return create(value);
        }
        catch (IllegalArgumentException e){
            throw new InvalidFormatException(null, "value is out of range", value, UserVerificationRequirement.class);
        }
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
