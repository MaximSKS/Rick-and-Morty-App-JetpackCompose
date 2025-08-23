package com.mobile.rick_and_morty.ui.viewmodel.mainvm

import androidx.paging.PagingData
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.EpisodesPagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    pagingRepository: EpisodesPagingRepository
) : GenericMainViewModel<Episode>(repository = pagingRepository) {

    val episodes: Flow<PagingData<Episode>> = pagingDataFlow
}