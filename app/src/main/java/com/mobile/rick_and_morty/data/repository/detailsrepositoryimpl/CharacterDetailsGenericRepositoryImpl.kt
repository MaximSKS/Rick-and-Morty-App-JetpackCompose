package com.mobile.rick_and_morty.data.repository.detailsrepositoryimpl

import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.data.model.CharacterDto
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.repository.RMGenericDetailsRepositoryImpl
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import javax.inject.Inject

class CharacterDetailsGenericRepositoryImpl @Inject constructor(
    api: RickAndMortyApi
) : RMGenericDetailsRepositoryImpl<Character, CharacterDto, >(
    fetchSingle = { id -> api.getCharacter(id) },
    mapper = { it.toDomain() }
), CharacterDetailsRepository