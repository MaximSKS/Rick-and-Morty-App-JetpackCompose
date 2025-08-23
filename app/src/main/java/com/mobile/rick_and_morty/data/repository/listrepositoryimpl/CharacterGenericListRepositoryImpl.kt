package com.mobile.rick_and_morty.data.repository.listrepositoryimpl

import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.data.model.CharacterDto
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.repository.RMGenericListRepositoryImpl
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.repository.CharacterListRepository
import javax.inject.Inject

class CharacterGenericListRepositoryImpl @Inject constructor(
    api: RickAndMortyApi
) : RMGenericListRepositoryImpl<Character, CharacterDto, >(
    fetchSingle = { id -> api.getCharacter(id) },
    fetchMultiple = { ids -> api.getCharactersByIds(ids) },
    mapper = { it.toDomain() }
), CharacterListRepository