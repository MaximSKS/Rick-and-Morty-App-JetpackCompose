package com.mobile.rick_and_morty.domain.repository

import kotlinx.coroutines.flow.Flow

interface RMGenericListRepository<T: Any> {
    fun getDataByIds(ids: List<Int>): Flow<List<T>> //get list of items for details screen
}