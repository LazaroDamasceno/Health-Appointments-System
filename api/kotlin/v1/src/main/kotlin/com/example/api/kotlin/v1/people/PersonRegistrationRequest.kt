package com.example.api.kotlin.v1.people

data class PersonRegistrationRequest(
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val identifier: String,
    val email: String,
    val gender: String,
    val phoneNumber: String
)
