package com.mobile.rick_and_morty.data.repository

import com.mobile.rick_and_morty.domain.repository.RMGenericListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class RMGenericListRepositoryImpl<T : Any, Dto,  >(
    private val fetchSingle: suspend (Int) -> Dto,
    private val fetchMultiple: suspend (String) -> List<Dto>,
    private val mapper: (Dto) -> T
) : RMGenericListRepository<T> {

    // get list of items (characters, episodes) in a specific 'details' screen
    override fun getDataByIds(ids: List<Int>): Flow<List<T>> = flow {
        if (ids.isEmpty()) {
            emit(emptyList())
            return@flow
        }

        val result = if (ids.size == 1) {
            listOf(fetchSingle(ids.first())).map(mapper)
        } else {
            val idString = ids.joinToString(",")
            fetchMultiple(idString).map(mapper)
        }

        emit(result)
    }
}