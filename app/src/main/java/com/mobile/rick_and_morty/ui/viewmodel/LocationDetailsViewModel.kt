package com.mobile.rick_and_morty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.domain.repository.CharacterRepository
import com.mobile.rick_and_morty.domain.repository.LocationDetailsRepository
import com.mobile.rick_and_morty.ui.screens.main.UiState
import com.mobile.rick_and_morty.utils.extractIds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationDetailsViewModel @Inject constructor(
    private val locationDetailsRepository: LocationDetailsRepository,
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val  _locationState = MutableStateFlow<UiState<Location>>(UiState.Loading)
    val locationState : StateFlow<UiState<Location>> = _locationState

    private val _charactersState = MutableStateFlow<UiState<List<Character>>>(UiState.Loading)
    val charactersState: StateFlow<UiState<List<Character>>> = _charactersState


    fun loadLocation(id: Int) {
        viewModelScope.launch {
            _locationState.value = UiState.Loading
            try {
                val location = locationDetailsRepository.getLocationById(id)
                _locationState.value = UiState.Success(location)
            } catch (e: Exception) {
                _locationState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }

    fun loadCharacters(characterUrls: List<String>) {
        val characterIds = extractIds(characterUrls)

        if(characterIds.isEmpty()) {
            _charactersState.value = UiState.Success(emptyList())
            return
        }

        viewModelScope.launch {
            _charactersState.value = UiState.Loading

            characterRepository.getCharactersByIds(characterIds)
                .catch { e ->_charactersState.value = UiState.Error(e.localizedMessage ?: "Error loading characters") }
                .collect { list ->
                    _charactersState.value = UiState.Success(list)
                }
        }
    }
}