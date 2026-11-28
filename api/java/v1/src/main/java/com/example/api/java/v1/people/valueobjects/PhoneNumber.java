package com.example.api.java.v1.people.valueobjects;

import com.example.api.java.v1.global.ValueObjectVerifier;

import java.util.regex.Pattern;

public record PhoneNumber(String value) {
    private static final Pattern PATTERN = Pattern.compile("^\\d{11}$");

    public PhoneNumber {
        ValueObjectVerifier.nullableOrBankStringValue(
                value,
                "Phone number is required"
        );

        var valueTrimmed = value.trim();
        ValueObjectVerifier.unmatchablePattern(
                value,
                PATTERN,
                "Invalid phone number format" + valueTrimmed
        );

        value = valueTrimmed;
    }
}
