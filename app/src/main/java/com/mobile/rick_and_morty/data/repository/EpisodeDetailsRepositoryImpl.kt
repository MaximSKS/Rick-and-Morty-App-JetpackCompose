package com.mobile.rick_and_morty.data.repository

import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.EpisodeDetailsRepository
import javax.inject.Inject

class EpisodeDetailsRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): EpisodeDetailsRepository {
    override suspend fun getEpisodeById(id: Int): Episode {
        return api.getEpisode(id).toDomain()
    }
}