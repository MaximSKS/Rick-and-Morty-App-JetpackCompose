package com.mobile.rick_and_morty.domain.repository

import com.mobile.rick_and_morty.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
     fun getCharactersByIds(ids: List<Int>): Flow<List<Character>>
}