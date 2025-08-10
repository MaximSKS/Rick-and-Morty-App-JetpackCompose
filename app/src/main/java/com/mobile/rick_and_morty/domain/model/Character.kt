package com.mobile.rick_and_morty.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val gender: Gender,
    val imageUrl: String,
    val episodeUrls: List<String>,
    val origin: String,
    val locationName: String
)