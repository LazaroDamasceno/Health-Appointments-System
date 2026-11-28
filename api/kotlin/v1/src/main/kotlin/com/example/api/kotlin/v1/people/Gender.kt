package com.example.api.kotlin.v1.people

import com.example.api.kotlin.v1.global.ValueObjectVerifier

enum class Gender(val value: String) {
    MALE("Male"),
    FEMALE("Female");

    companion object {
        fun fromValue(value: String): Gender {
            ValueObjectVerifier.blankValue(
                value,
                message = "Gender is required"
            )

            val valueTrimmed = value.trim()
            val message = "Invalid gender: $valueTrimmed"

            return entries.firstOrNull {
                it.value.equals(valueTrimmed, ignoreCase = true)
            } ?: throw IllegalArgumentException(message)
        }
    }
}
