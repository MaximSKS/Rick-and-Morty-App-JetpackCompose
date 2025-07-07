package com.mobile.rick_and_morty.ui.preview.mock

import com.mobile.rick_and_morty.domain.model.Episode
import kotlin.random.Random

object EpisodeMock {
    val episodeMockData = Episode(
        id = Random.nextInt(1, 1000),
        name = "The Ricklantis Mixup",
        airDate = "September 10, 2017",
        episodeCode = "S03E07",
        characters = listOf("https://rickandmortyapi.com/api/character/1"),
        url = "https://rickandmortyapi.com/api/episode/1",
        created = "2017-11-10T12:56:33.798Z"
    )
}