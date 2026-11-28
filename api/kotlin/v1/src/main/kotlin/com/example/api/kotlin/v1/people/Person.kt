package com.example.api.kotlin.v1.people

import com.example.api.kotlin.v1.people.valueobjects.*
import com.example.api.kotlin.v1.people.valueobjects.PhoneNumber
import java.time.Instant
import java.util.UUID

@ConsistentCopyVisibility
data class Person private constructor(
    val id: UUID,
    val fullName: FullName,
    val identifier: Identifier,
    val email: Email,
    val gender: Gender,
    val phoneNumber: PhoneNumber,
    val createdAt: Instant
) {

    companion object {
        fun from(
            firstName: String,
            middleName: String?,
            lastName: String,
            identifier: String,
            email: String,
            gender: String,
            phoneNumber: String,
        ): Person {
            return Person(
                UUID.randomUUID(),
                FullName(firstName, middleName, lastName),
                Identifier(identifier),
                Email(email),
                Gender.fromValue(gender),
                PhoneNumber(phoneNumber),
                Instant.now(),
            )
        }

        fun fromEntity(entity: PersonEntity): Person {
            return Person(
                entity.id,
                FullName(entity.firstName, entity.middleName, entity.lastName),
                Identifier(entity.identifier),
                Email(entity.email),
                Gender.fromValue(entity.gender),
                PhoneNumber(entity.phoneNumber),
                entity.createdAt
            )
        }

    }

    fun toEntity(): PersonEntity {
        return PersonEntity(
            id,
            fullName.firstName,
            fullName.middleName,
            fullName.lastName,
            identifier.value,
            email.value,
            gender.value,
            phoneNumber.value,
            createdAt
        )
    }
}
