package com.mobile.rick_and_morty.domain.repository
import com.mobile.rick_and_morty.domain.model.Episode

interface EpisodeDetailsRepository {
    suspend fun getEpisodeById(id: Int): Episode
}