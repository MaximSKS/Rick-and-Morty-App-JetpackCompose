package com.mobile.rick_and_morty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mobile.rick_and_morty.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterMainViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    val characters = repository
        .getCharactersStream()
        .cachedIn(viewModelScope)  //cashing in VM lifecycle
}