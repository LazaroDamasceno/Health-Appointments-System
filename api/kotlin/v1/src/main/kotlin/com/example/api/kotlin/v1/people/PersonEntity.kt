package com.example.api.kotlin.v1.people

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table("people")
data class PersonEntity(
    @Id
    val id: UUID,
    @Column("first_name")
    val firstName: String,
    @Column("middle_name")
    val middleName: String?,
    @Column("last_name")
    val lastName: String,
    val identifier: String,
    val email: String,
    val gender: String,
    @Column("phone_number")
    val phoneNumber: String,
    @Column("created_at")
    val createdAt: Instant
)
