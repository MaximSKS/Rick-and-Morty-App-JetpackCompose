package com.mobile.rick_and_morty.data.repository

import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.domain.mappers.toDomain
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import javax.inject.Inject

class CharacterDetailsRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): CharacterDetailsRepository {
    override suspend fun getCharacterById(id: Int): Character {
        return api.getCharacter(id).toDomain()
    }
}