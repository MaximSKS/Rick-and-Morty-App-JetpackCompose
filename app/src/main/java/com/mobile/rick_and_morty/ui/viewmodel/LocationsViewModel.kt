package com.mobile.rick_and_morty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mobile.rick_and_morty.domain.repository.EpisodesRepository
import com.mobile.rick_and_morty.domain.repository.LocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val repository: LocationsRepository
) : ViewModel() {

    val locations = repository
        .getLocations()
        .cachedIn(viewModelScope)
}