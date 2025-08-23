package com.mobile.rick_and_morty.data.repository

import com.mobile.rick_and_morty.domain.repository.RMGenericDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class RMGenericDetailsRepositoryImpl<T : Any, Dto>(
    private val fetchSingle: suspend (Int) -> Dto,
    private val mapper: (Dto) -> T
) : RMGenericDetailsRepository<T> {

    // get data by id for the details screen
    override fun getDetDataById(id: Int): Flow<T> = flow {
        val dto = fetchSingle(id)
        emit(mapper(dto))
    }

}