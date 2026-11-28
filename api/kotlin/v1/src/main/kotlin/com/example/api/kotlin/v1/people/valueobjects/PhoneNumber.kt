package com.example.api.kotlin.v1.people.valueobjects

import com.example.api.kotlin.v1.global.ValueObjectVerifier

@ConsistentCopyVisibility
data class PhoneNumber private constructor(val value: String) {

    companion object {
        private val REGEX = Regex("^\\d{11}$")

        operator fun invoke(value: String): PhoneNumber {
            ValueObjectVerifier.blankValue(
                value,
                "Phone number is required"
            )

            val valueTrimmed = value.trim()
            ValueObjectVerifier.unmatchablePattern(
                valueTrimmed,
                REGEX,
                "Invalid phone number format: $valueTrimmed"
            )

            return PhoneNumber(valueTrimmed)
        }
    }
}