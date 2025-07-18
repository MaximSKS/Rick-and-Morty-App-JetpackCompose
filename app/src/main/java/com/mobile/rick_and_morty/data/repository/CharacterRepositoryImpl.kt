package com.mobile.rick_and_morty.data.repository

import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): CharacterRepository {
    override fun getCharactersByIds(ids: List<Int>): Flow<List<Character>> {
       return flow{
           if (ids.isEmpty()) {
               emit(emptyList())
               return@flow
           }
           val characters = if(ids.size == 1) {
               val dto = api.getCharacter(ids.first())
               listOf(dto.toDomain())
           }else{
               val idString = ids.joinToString(",")
               val dtoList = api.getCharactersByIds(idString)
               dtoList.map { it.toDomain() }
           }

           emit(characters)
       }
    }

}