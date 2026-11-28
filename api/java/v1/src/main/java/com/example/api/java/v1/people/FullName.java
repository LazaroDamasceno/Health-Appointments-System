package com.example.api.java.v1.people;

import com.example.api.java.v1.global.ValueObjectVerifier;

public record FullName(
        String firstName,
        String middleName,
        String lastName
) {
    public FullName {
        ValueObjectVerifier.NullableOrBankStringValue(
                firstName,
                "First name is required"
        );

        ValueObjectVerifier.NullableOrBankStringValue(
                lastName,
                "Last name is required"
        );

        firstName = firstName.trim();
        middleName = middleName == null || middleName.isBlank() ? null : middleName.trim();
        lastName = lastName.trim();
    }
}
