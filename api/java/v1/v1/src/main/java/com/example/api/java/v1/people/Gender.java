package com.example.api.java.v1.people;

import com.example.api.java.v1.global.InvalidOptionException;
import com.example.api.java.v1.global.ValueObjectVerifier;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public static Gender fromValue(String value) {
        ValueObjectVerifier.NullableOrBankStringValue(
                value,
                "Gender is required"
        );

        var message = "Invalid Gender option: %s".formatted(value);
        return Arrays.stream(values())
                .filter(g -> g.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidOptionException(message));
    }
}
