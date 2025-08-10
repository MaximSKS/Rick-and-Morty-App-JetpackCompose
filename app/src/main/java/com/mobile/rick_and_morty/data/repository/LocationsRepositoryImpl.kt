package com.mobile.rick_and_morty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mobile.rick_and_morty.data.paging.EpisodesPagingSource
import com.mobile.rick_and_morty.data.paging.LocationsPagingSource
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.domain.repository.EpisodesRepository
import com.mobile.rick_and_morty.domain.repository.LocationsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationsRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): LocationsRepository {
    override fun getLocations(): Flow<PagingData<Location>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { LocationsPagingSource(api) }
        ).flow
    }
}