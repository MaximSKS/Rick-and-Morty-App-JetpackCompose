package com.mobile.rick_and_morty.data.repository

import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.domain.repository.EpisodeDetailsRepository
import com.mobile.rick_and_morty.domain.repository.LocationDetailsRepository
import javax.inject.Inject

class LocationDetailsRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): LocationDetailsRepository {
    override suspend fun getLocationById(id: Int): Location {
        return api.getLocation(id).toDomain()
    }
}