package com.example.api.java.v1.global;

import java.util.regex.Pattern;

public class ValueObjectVerifier {

    public static void nullableOrBankStringValue(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new NullableOrBlankValueException(message);
        }
    }

    public static void unmatchablePattern(String value, Pattern pattern, String message) {
        nullableOrBankStringValue(value, message);
        if (!pattern.matcher(value).matches()) {
            throw new InvalidRegexException(message);
        }
    }
}
