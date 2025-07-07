package com.mobile.rick_and_morty.domain.repository

import androidx.paging.PagingData
import com.mobile.rick_and_morty.domain.model.Character

import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharactersStream(): Flow<PagingData<Character>>
}