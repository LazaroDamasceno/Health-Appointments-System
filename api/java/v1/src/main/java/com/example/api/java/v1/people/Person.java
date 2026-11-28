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

    private Person(
            UUID id,
            FullName fullName,
            Identifier identifier,
            Email email,
            Gender gender,
            PhoneNumber phoneNumber,
            Instant createdAt
    ) {
        this.id = id;
        this.fullName = fullName;
        this.identifier = identifier;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
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

    public PersonEntity toEntity() {
        return new PersonEntity(
                id,
                fullName.firstName(),
                fullName.middleName(),
                fullName.lastName(),
                identifier.value(),
                email.value(),
                gender.getValue(),
                phoneNumber.value(),
                createdAt
        );
    }

    public Person toDomain(PersonEntity entity) {
        return new Person(
                entity.getId(),
                new FullName(
                        entity.getFirstName(),
                        entity.getMiddleName(),
                        entity.getLastName()
                ),
                new Identifier(entity.getIdentifier()),
                new Email(entity.getEmail()),
                Gender.fromValue(entity.getEmail()),
                new PhoneNumber(entity.getPhoneNumber()),
                entity.getCreatedAt()
        );
    }
}