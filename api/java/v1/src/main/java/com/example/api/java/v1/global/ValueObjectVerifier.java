package com.example.api.java.v1.global;

import com.example.api.java.v1.global.NullableOrBlankValueException;
import com.example.api.java.v1.global.InvalidRegexException;

public class ValueObjectVerifier {

    public static void NullableOrBankStringValue(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new NullableOrBlankValueException(message);
        }
    }

    public static void UnmatchablePattern(String value, Pattern pattern, String message) {
        NullableOrBankStringValue(value, message);
        if (!pattern.matcher(value).matches()) {
            throw new InvalidRegexException(message);
        }
    }
}
