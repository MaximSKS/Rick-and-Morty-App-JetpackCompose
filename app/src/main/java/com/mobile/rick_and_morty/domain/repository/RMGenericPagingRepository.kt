package com.mobile.rick_and_morty.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface RMGenericPagingRepository<T: Any> {
    fun getPagedData(): Flow<PagingData<T>>
}