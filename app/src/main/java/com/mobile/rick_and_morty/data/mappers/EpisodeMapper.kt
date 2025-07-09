package com.mobile.rick_and_morty.data.mappers

import com.mobile.rick_and_morty.data.model.EpisodeDto
import com.mobile.rick_and_morty.domain.model.Episode

fun EpisodeDto.toDomain(): Episode {
    return Episode(
        id = id,
        name = name,
        airDate = airDate,
        episodeCode = episodeCode,
        characters = characters,
        url = url,
        created = created
    )
}