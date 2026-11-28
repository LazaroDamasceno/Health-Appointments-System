package com.example.api.kotlin.v1.people

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
        ) {

        }
    }
}
