package com.mobile.rick_and_morty.domain.repository

import com.mobile.rick_and_morty.domain.model.Character

interface CharacterDetailsRepository {
    suspend fun getCharacterById(id: Int): Character
}