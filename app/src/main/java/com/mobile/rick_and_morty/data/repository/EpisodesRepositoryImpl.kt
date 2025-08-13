package com.mobile.rick_and_morty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.data.paging.RMGenericPagingSource
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.EpisodesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): EpisodesRepository {
    override fun getEpisodes(): Flow<PagingData<Episode>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { // old version -> { EpisodesPagingSource(api) }
                RMGenericPagingSource { page ->
                    val response = api.getEpisodes(page)
                    response.results.map { it.toDomain() }
                }
            }
        ).flow
    }
}