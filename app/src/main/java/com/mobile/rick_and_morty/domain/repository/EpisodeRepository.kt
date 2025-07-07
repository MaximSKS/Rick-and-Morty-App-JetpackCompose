package com.mobile.rick_and_morty.domain.repository

import com.mobile.rick_and_morty.domain.model.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {
     fun getEpisodesByIds(ids: List<Int>): Flow<List<Episode>>
}