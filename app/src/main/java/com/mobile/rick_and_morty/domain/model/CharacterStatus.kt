package com.mobile.rick_and_morty.domain.model

enum class CharacterStatus {
    Alive, Dead, Unknown;

    companion object {
        fun fromString(value: String): CharacterStatus {
            return when (value.lowercase()) {
                "alive" -> Alive
                "dead" -> Dead
                else -> Unknown
            }
        }
    }
}