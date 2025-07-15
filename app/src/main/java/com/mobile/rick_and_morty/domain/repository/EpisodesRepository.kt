package com.mobile.rick_and_morty.domain.repository

import androidx.paging.PagingData
import com.mobile.rick_and_morty.domain.model.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun getEpisodes(): Flow<PagingData<Episode>>
}