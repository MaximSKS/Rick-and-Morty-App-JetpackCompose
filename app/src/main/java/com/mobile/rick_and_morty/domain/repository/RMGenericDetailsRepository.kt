package com.mobile.rick_and_morty.domain.repository

import kotlinx.coroutines.flow.Flow

interface RMGenericDetailsRepository<T: Any> {
     fun getDetDataById(id: Int): Flow<T> // get data by id for the 'details' screen
}