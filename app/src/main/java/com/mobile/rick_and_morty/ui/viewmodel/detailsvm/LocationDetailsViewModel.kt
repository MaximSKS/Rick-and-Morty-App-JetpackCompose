package com.mobile.rick_and_morty.ui.viewmodel.detailsvm

import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.domain.repository.CharacterListRepository
import com.mobile.rick_and_morty.domain.repository.LocationDetailsRepository
import com.mobile.rick_and_morty.ui.viewmodel.detailsvm.GenericDetailsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationDetailsViewModel @Inject constructor(
    locationDetailsRepository: LocationDetailsRepository,
    characterListRepository: CharacterListRepository
) : GenericDetailsViewModel<Location, Character>(
    detailsRepository = locationDetailsRepository,
    listRepository = characterListRepository
)

//@HiltViewModel
//class LocationDetailsViewModel @Inject constructor(
//    private val locationDetailsRepository: LocationDetailsRepository,
//    private val characterListRepository: CharacterListRepository
//) : ViewModel() {
//
//    private val  _locationState = MutableStateFlow<UiState<Location>>(UiState.Loading)
//    val locationState : StateFlow<UiState<Location>> = _locationState
//
//    private val _charactersState = MutableStateFlow<UiState<List<Character>>>(UiState.Loading)
//    val charactersState: StateFlow<UiState<List<Character>>> = _charactersState
//
//
//    fun loadLocation(id: Int) {
//        viewModelScope.launch {
//            _locationState.value = UiState.Loading
//            try {
//                locationDetailsRepository.getDetDataById(id).collect{ location ->
//                    _locationState.value = UiState.Success(location)
//                }
//
//
//            } catch (e: Exception) {
//                _locationState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
//            }
//        }
//    }
//
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