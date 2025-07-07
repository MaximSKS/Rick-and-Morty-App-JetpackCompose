package com.mobile.rick_and_morty.data.model

data class EpisodesPageDto(
    val info: InfoDto,
    val results: List<EpisodeDto>
)