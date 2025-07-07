package com.mobile.rick_and_morty.domain.model

enum class Gender {
    Female, Male, Genderless, Unknown;

    companion object {
        fun fromString(value: String): Gender {
            return when (value.lowercase()) {
                "female" -> Female
                "male" -> Male
                "genderless" -> Genderless
                else -> Unknown
            }
        }
    }
}