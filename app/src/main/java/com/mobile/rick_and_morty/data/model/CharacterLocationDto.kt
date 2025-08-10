package com.mobile.rick_and_morty.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterLocationDto(
    val name: String,
    val url: String
)
