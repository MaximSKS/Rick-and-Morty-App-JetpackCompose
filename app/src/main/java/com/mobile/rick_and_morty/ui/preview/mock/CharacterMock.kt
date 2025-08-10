package com.mobile.rick_and_morty.ui.preview.mock

import com.mobile.rick_and_morty.data.model.CharacterOriginDto
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.CharacterStatus
import com.mobile.rick_and_morty.domain.model.Gender
import kotlin.random.Random


object CharacterMock {
    val characterMockData = Character(
        id = Random.nextInt(1, 1000),
        name = "Rick Sanchez",
        status = CharacterStatus.fromString("Alive"),
        species = "Human",
        gender = Gender.fromString("Male"),
        imageUrl = "",
        episodeUrls = listOf(),
        origin = "Earth (C-137)",
        locationName = "Earth", // Last known location of the character
    )
}