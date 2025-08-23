package com.mobile.rick_and_morty.data.repository.pagingrepositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.data.paging.RMGenericPagingSource
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.domain.repository.LocationsPagingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationsPagingRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : LocationsPagingRepository {
    override fun getPagedData(): Flow<PagingData<Location>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                RMGenericPagingSource { page ->
                    val response = api.getLocations(page)
                    response.results.map { it.toDomain() }
                }
            }
        ).flow
    }
}