package com.mobile.rick_and_morty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mobile.rick_and_morty.domain.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersMainViewModel @Inject constructor(
    private val repository: CharactersRepository
) : ViewModel() {

    val characters = repository
        .getCharacters()
        .cachedIn(viewModelScope)  //cashing in VM lifecycle
}