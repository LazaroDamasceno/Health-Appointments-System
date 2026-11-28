package com.example.api.java.v1.people;

import com.example.api.java.v1.global.InvalidRegexException;
import com.example.api.java.v1.global.ValueObjectVerifier;

import java.util.regex.Pattern;

public record PhoneNumber(String value) {
    private static final Pattern PATTERN = Pattern.compile("^\\d{11}$");

    public PhoneNumber {
        ValueObjectVerifier.NullableOrBankStringValue(
                value,
                "Phone number is required"
        );

        var valueTrimmed = value.trim();
        if (!PATTERN.matcher(valueTrimmed).matches()) {
            var message = "Invalid phone number format: %s".formatted(valueTrimmed);
            throw new InvalidRegexException(message);
        }

        value = valueTrimmed;
    }
}
