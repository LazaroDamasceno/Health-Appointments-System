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
        if (!PATTERN.matcher(valueNormalized).matches()) {
            var message = "Invalid identifier format: %s".formatted(valueNormalized);
            throw new InvalidRegexException(message);
        }
    }
}
