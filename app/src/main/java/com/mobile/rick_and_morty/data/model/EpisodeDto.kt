package com.mobile.rick_and_morty.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class EpisodeDto(
    val id: Int,
    val name: String,
    @Json(name = "air_date")
    val airDate: String,
    @Json(name = "episode")
    val episodeCode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)