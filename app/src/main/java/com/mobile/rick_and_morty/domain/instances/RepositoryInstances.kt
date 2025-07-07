package com.mobile.rick_and_morty.domain.instances

import com.mobile.rick_and_morty.data.repository.CharacterDetailsRepositoryImpl
import com.mobile.rick_and_morty.data.repository.CharacterRepositoryImpl
import com.mobile.rick_and_morty.data.repository.EpisodeRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import com.mobile.rick_and_morty.domain.repository.CharacterRepository

object RepositoryInstances {
    val characterRepo: CharacterRepository = CharacterRepositoryImpl(ApiInstance.api)
    val characterDetailsRepo: CharacterDetailsRepository = CharacterDetailsRepositoryImpl(ApiInstance.api)
    val episodeRepo = EpisodeRepositoryImpl(ApiInstance.api)
}