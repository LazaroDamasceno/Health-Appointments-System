package com.example.api.java.v1.people.valueobjects;

import com.example.api.java.v1.global.ValueObjectVerifier;

import java.util.regex.Pattern;

public record Identifier(String value) {

    private static final Pattern PATTERN = Pattern.compile("^[A-Z]\\d{6}[A-Z]{2}$");

    public Identifier {
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
