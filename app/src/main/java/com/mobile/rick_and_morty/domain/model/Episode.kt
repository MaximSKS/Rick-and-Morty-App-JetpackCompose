package com.mobile.rick_and_morty.domain.model


data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episodeCode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)