package com.example.api.java.v1.global;

public class ValueObjectVerifier {

    public static void NullableOrBankStringValue(String value, String errorMessage) {
        if (value == null || value.isBlank()) {
            throw new NullableOrBlankValueException(errorMessage);
        }
    }
}
