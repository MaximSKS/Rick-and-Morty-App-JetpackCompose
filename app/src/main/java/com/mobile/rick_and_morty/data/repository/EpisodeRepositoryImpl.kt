package com.mobile.rick_and_morty.data.repository

import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.EpisodeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): EpisodeRepository {
    override fun getEpisodesByIds(ids: List<Int>): Flow<List<Episode>> {
       return flow{
           if (ids.isEmpty()) {
               emit(emptyList())
               return@flow
           }
           val episodes = if(ids.size == 1) {
               val dto = api.getEpisodeById(ids.first())
               listOf(dto.toDomain())
           }else{
               val idString = ids.joinToString(",")
               val dtoList = api.getEpisodesByIds(idString)
               dtoList.map { it.toDomain() }
           }

           emit(episodes)
       }
    }

}