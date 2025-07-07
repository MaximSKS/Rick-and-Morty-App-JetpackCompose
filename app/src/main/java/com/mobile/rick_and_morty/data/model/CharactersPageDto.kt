package com.mobile.rick_and_morty.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersPageDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)