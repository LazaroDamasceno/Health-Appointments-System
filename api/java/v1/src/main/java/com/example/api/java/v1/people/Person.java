package com.example.api.java.v1.people;

import com.example.api.java.v1.people.valueobjects.*;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class Person {

    private final UUID id;
    private final FullName fullName;
    private final Identifier identifier;
    private final Email email;
    private final Gender gender;
    private final PhoneNumber phoneNumber;
    private final Instant createdAt;

    private Person(
            FullName fullName,
            Identifier identifier,
            Email email,
            Gender gender,
            PhoneNumber phoneNumber
    ) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.identifier = identifier;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.createdAt = Instant.now();
    }

    public static Person from(
            String firstName,
            String middleName,
            String lastName,
            String identifier,
            String email,
            String gender,
            String phoneNumber
    ) {
        return new Person(
                new FullName(firstName, middleName, lastName),
                new Identifier(identifier),
                new Email(email),
                Gender.fromValue(gender),
                new PhoneNumber(phoneNumber)
        );
    }
}