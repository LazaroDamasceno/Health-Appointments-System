package com.example.api.kotlin.v1.people.valueobjects

import com.example.api.kotlin.v1.global.ValueObjectVerifier


@ConsistentCopyVisibility
data class FullName private constructor(
    val firstName: String,
    val middleName: String?,
    val lastName: String,
) {
    companion object {
        operator fun invoke(
            firstName: String,
            middleName: String?,
            lastName: String
        ): FullName {
            ValueObjectVerifier.blankValue(
                firstName,
                "First name is required"
            )

            ValueObjectVerifier.blankValue(
                lastName,
                "Last name is required"
            )

            val firstNameTrimmed = firstName.trim()
            val middleNameTrimmed = if (middleName.isNullOrBlank()) null
                                    else middleName.trim()
            val lastNameTrimmed = lastName.trim()

            return FullName(
                firstNameTrimmed,
                middleNameTrimmed,
                lastNameTrimmed
            )
        }
    }

    fun getFormattedName(): String {
        if (middleName.isNullOrBlank()) {
            return "$firstName $lastName"
        }
        return "$firstName $middleName $lastName"
    }
}
