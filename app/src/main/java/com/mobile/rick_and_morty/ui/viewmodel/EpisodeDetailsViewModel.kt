package com.mobile.rick_and_morty.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
    //private val repository: EpisodeDetailsRepository
) : ViewModel() {

//    val episodes = repository
//        .getEpisodes()
//        .cachedIn(viewModelScope)
}