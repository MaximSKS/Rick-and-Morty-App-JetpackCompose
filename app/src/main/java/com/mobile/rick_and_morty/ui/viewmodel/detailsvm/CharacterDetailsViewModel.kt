package com.mobile.rick_and_morty.ui.viewmodel.detailsvm

import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import com.mobile.rick_and_morty.domain.repository.EpisodeListRepository
import com.mobile.rick_and_morty.ui.viewmodel.detailsvm.GenericDetailsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    characterDetailsRepository: CharacterDetailsRepository,
    episodeListRepository: EpisodeListRepository
) : GenericDetailsViewModel<Character, Episode>(
    detailsRepository = characterDetailsRepository,
    listRepository = episodeListRepository
)

//@HiltViewModel
//class CharacterDetailsViewModel @Inject constructor(
//    private val characterDetailsRepository: CharacterDetailsRepository,
//    private val episodeListRepository: EpisodeListRepository
//): ViewModel() {
//
//    private val _characterState = MutableStateFlow<UiState<Character>>(UiState.Loading)
//    val characterState: StateFlow<UiState<Character>> = _characterState
//
//    private val _episodesState = MutableStateFlow<UiState<List<Episode>>>(UiState.Loading)
//    val episodesState: StateFlow<UiState<List<Episode>>> = _episodesState
//
//
//    fun loadCharacter(id: Int) {
//        viewModelScope.launch {
//            _characterState.value = UiState.Loading
//            try {
//                characterDetailsRepository.getDetDataById(id).collect{ character ->
//                     _characterState.value = UiState.Success(character)
//                }
//
//            } catch (e: Exception) {
//                _characterState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
//            }
//        }
//    }
//
//    fun loadEpisodes(episodeUrls: List<String>) {
//        val episodeIds = extractIds(episodeUrls)
//
//        if(episodeIds.isEmpty()) {
//           _episodesState.value = UiState.Success(emptyList())
//           return
//        }
//
//        viewModelScope.launch {
//            _episodesState.value = UiState.Loading
//
//            episodeListRepository.getDataByIds(episodeIds)
//                .catch { e -> _episodesState.value = UiState.Error(e.localizedMessage ?: "Error loading episodes") }
//                .collect { list ->
//                    _episodesState.value = UiState.Success(list)
//                }
//        }
//    }
//}