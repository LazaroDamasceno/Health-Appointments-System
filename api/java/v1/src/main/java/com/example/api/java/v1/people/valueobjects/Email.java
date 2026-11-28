package com.example.api.java.v1.people.valueobjects;

import com.example.api.java.v1.global.ValueObjectVerifier;

import java.util.regex.Pattern;

public record Email(String value) {
    private static final Pattern PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public Email {
        ValueObjectVerifier.nullableOrBankStringValue(
                value,
                "Identifier is required"
        );

        var valueNormalized = value.trim().toUpperCase();
        ValueObjectVerifier.unmatchablePattern(
                value,
                PATTERN,
                "Invalid identifier format" + valueNormalized
        );

        value = valueNormalized;
    }
}
