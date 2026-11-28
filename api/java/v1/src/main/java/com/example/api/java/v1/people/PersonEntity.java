package com.example.api.java.v1.people;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "people")
@Getter
@NoArgsConstructor
public class PersonEntity {

    @Id
    private UUID id;

    @Column(name = "first_name", nullable = false, updatable = false)
    private String firstName;

    @Column(name = "middle_name",updatable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false, updatable = false)
    private String lastName;

    @Column(nullable = false, updatable = false)
    private String identifier;

    @Column(nullable = false, updatable = false)
    private String email;

    @Column(nullable = false, updatable = false)
    private String gender;

    @Column(name = "phone_number", nullable = false, updatable = false)
    private String phoneNumber;

    @Column(name = "created_at", nullable = false, updatable = false)
    private  Instant createdAt;

    PersonEntity(
            UUID id,
            String firstName,
            String middleName,
            String lastName,
            String identifier,
            String email,
            String gender,
            String phoneNumber,
            Instant createdAt
    ) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.identifier = identifier;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }
}
