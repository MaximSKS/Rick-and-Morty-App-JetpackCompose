package com.mobile.rick_and_morty.data.repository.listrepositoryimpl

import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.data.model.EpisodeDto
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.repository.RMGenericListRepositoryImpl
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.EpisodeListRepository
import javax.inject.Inject

class EpisodeGenericListRepositoryImpl @Inject constructor(
    api: RickAndMortyApi
) : RMGenericListRepositoryImpl<Episode, EpisodeDto, >(
    fetchSingle = { id -> api.getEpisode(id) },
    fetchMultiple = { ids -> api.getEpisodesByIds(ids) },
    mapper = { it.toDomain() }
), EpisodeListRepository