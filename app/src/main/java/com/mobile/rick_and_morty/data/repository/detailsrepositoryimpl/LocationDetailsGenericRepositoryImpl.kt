package com.mobile.rick_and_morty.data.repository.detailsrepositoryimpl

import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.data.model.LocationDto
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.repository.RMGenericDetailsRepositoryImpl
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.domain.repository.LocationDetailsRepository
import javax.inject.Inject

class LocationDetailsGenericRepositoryImpl @Inject constructor(
    api: RickAndMortyApi
) : RMGenericDetailsRepositoryImpl<Location, LocationDto>(
    fetchSingle = { id -> api.getLocation(id) },
    mapper = { it.toDomain() }
), LocationDetailsRepository