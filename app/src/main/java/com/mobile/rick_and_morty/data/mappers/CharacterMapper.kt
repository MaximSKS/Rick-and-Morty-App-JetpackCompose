package com.mobile.rick_and_morty.data.mappers

import com.mobile.rick_and_morty.data.model.CharacterDto
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.CharacterStatus
import com.mobile.rick_and_morty.domain.model.Gender

fun CharacterDto.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        status = CharacterStatus.fromString(status),
        species = species,
        gender = Gender.fromString(gender),
        imageUrl = image,
        episodeUrls = episode,
        locationName = location.name
    )
}