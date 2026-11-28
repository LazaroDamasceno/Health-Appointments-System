package com.example.api.java.v1.people;

import com.example.api.java.v1.global.InvalidRegexException;
import com.example.api.java.v1.global.ValueObjectVerifier;

import java.util.regex.Pattern;

public record Identifier(String value) {
    private static final Pattern PATTERN = Pattern.compile("^[A-Z]\\d{6}[A-Z]{2}$");

    public Identifier {
        ValueObjectVerifier.NullableOrBankStringValue(
                value,
                "Identifier is required"
        );

        var valueNormalized = value.trim().toUpperCase();
        ValueObjectVerifier.UnmatchablePattern(
                value,
                PATTERN,
                "Invalid identifier format" + valueNormalized
        );

        value = valueNormalized;
    }
}
