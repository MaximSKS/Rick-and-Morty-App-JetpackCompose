package com.mobile.rick_and_morty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import com.mobile.rick_and_morty.domain.repository.EpisodeRepository
import com.mobile.rick_and_morty.ui.screens.main.UiState
import com.mobile.rick_and_morty.utils.extractIds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val characterDetailsRepository: CharacterDetailsRepository,
    private val episodeRepository: EpisodeRepository
): ViewModel() {

    private val _characterState = MutableStateFlow<UiState<Character>>(UiState.Loading)
    val characterState: StateFlow<UiState<Character>> = _characterState

    private val _episodesState = MutableStateFlow<UiState<List<Episode>>>(UiState.Loading)
    val episodesState: StateFlow<UiState<List<Episode>>> = _episodesState


    fun loadCharacter(id: Int) {
        viewModelScope.launch {
            _characterState.value = UiState.Loading
            try {
                val character = characterDetailsRepository.getCharacterById(id)
                _characterState.value = UiState.Success(character)
            } catch (e: Exception) {
                _characterState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }

    fun loadEpisodes(episodeUrls: List<String>) {
        val episodeIds = extractIds(episodeUrls)

        if(episodeIds.isEmpty()) {
           _episodesState.value = UiState.Success(emptyList())
           return
        }

        viewModelScope.launch {
            _episodesState.value = UiState.Loading

            episodeRepository.getEpisodesByIds(episodeIds)
                .catch { e -> _episodesState.value = UiState.Error(e.localizedMessage ?: "Error loading episodes") }
                .collect { list ->
                    _episodesState.value = UiState.Success(list)
                }
        }
    }
}