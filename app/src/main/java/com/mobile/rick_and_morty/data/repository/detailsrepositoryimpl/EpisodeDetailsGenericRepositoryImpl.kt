package com.mobile.rick_and_morty.data.repository.detailsrepositoryimpl

import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.data.model.EpisodeDto
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.repository.RMGenericDetailsRepositoryImpl
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.EpisodeDetailsRepository

import javax.inject.Inject


class EpisodeDetailsGenericRepositoryImpl @Inject constructor(
    api: RickAndMortyApi
) : RMGenericDetailsRepositoryImpl<Episode, EpisodeDto>(
    fetchSingle = { id -> api.getEpisode(id) },
    mapper = { it.toDomain() }
), EpisodeDetailsRepository