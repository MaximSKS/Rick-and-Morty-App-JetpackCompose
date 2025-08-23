package com.mobile.rick_and_morty.ui.viewmodel.detailsvm

import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.repository.CharacterListRepository
import com.mobile.rick_and_morty.domain.repository.EpisodeDetailsRepository
import com.mobile.rick_and_morty.ui.viewmodel.detailsvm.GenericDetailsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
     episodeDetailsRepository: EpisodeDetailsRepository,
    characterListRepository: CharacterListRepository
) : GenericDetailsViewModel<Episode, Character>(
    detailsRepository = episodeDetailsRepository,
    listRepository = characterListRepository
)

//@HiltViewModel
//class EpisodeDetailsViewModel @Inject constructor(
//    private val episodeDetailsRepository: EpisodeDetailsRepository,
//    private val characterListRepository: CharacterListRepository
//) : ViewModel() {
//
//    private val  _episodeState = MutableStateFlow<UiState<Episode>>(UiState.Loading)
//    val episodeState : StateFlow<UiState<Episode>> = _episodeState
//
//    private val _charactersState = MutableStateFlow<UiState<List<Character>>>(UiState.Loading)
//    val charactersState: StateFlow<UiState<List<Character>>> = _charactersState
//
//
//    fun loadEpisode(id: Int) {
//        viewModelScope.launch {
//            _episodeState.value = UiState.Loading
//            try {
//                episodeDetailsRepository.getDetDataById(id).collect { episode ->
//                    _episodeState.value = UiState.Success(episode)
//                }
//
//            } catch (e: Exception) {
//                _episodeState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
//            }
//        }
//    }
//
//    // for displaying characters on the EpisodeDetailsScreen
//    fun loadCharacters(characterUrls: List<String>) {
//        val characterIds = extractIds(characterUrls)
//
//        if(characterIds.isEmpty()) {
//            _charactersState.value = UiState.Success(emptyList())
//            return
//        }
//
//        viewModelScope.launch {
//            _charactersState.value = UiState.Loading
//
//            characterListRepository.getDataByIds(characterIds)
//                .catch { e ->_charactersState.value = UiState.Error(e.localizedMessage ?: "Error loading characters") }
//                .collect { list ->
//                    _charactersState.value = UiState.Success(list)
//                }
//        }
//    }
//}