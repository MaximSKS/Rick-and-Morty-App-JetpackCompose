package com.mobile.rick_and_morty.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val episode: List<String>,
    val origin: CharacterOriginDto,
    val location: CharacterLocationDto
)