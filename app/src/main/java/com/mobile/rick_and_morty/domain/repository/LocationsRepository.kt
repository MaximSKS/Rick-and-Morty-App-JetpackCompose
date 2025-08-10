package com.mobile.rick_and_morty.domain.repository

import androidx.paging.PagingData
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationsRepository {
    fun getLocations(): Flow<PagingData<Location>>
}