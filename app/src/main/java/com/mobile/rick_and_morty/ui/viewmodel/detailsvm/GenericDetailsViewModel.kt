package com.mobile.rick_and_morty.ui.viewmodel.detailsvm

import com.mobile.rick_and_morty.domain.repository.RMGenericDetailsRepository
import com.mobile.rick_and_morty.domain.repository.RMGenericListRepository
import com.mobile.rick_and_morty.ui.screens.main.UiState
import com.mobile.rick_and_morty.ui.viewmodel.BaseViewModel
import com.mobile.rick_and_morty.utils.extractIds
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class GenericDetailsViewModel<T: Any, K: Any>(
    private val detailsRepository: RMGenericDetailsRepository<T>,
    private val listRepository: RMGenericListRepository<K>,
) : BaseViewModel() {

    private val _detailsState = MutableStateFlow<UiState<T>>(UiState.Loading)
    val detailsState: StateFlow<UiState<T>> = _detailsState

    private val _relatedState = MutableStateFlow<UiState<List<K>>>(UiState.Loading)
    val relatedState: StateFlow<UiState<List<K>>> = _relatedState

    //Load details (for CharacterDetailsScreen, EpisodeDetailsScreen, LocationDetailsScreen)
    fun loadDetails(id: Int) {
        collectUiState(
            targetState = _detailsState,
            source = detailsRepository.getDetDataById(id),
            errorMessage = "Error loading details data",
        )
    }

    // Load related items list (Characters list, Episodes list)
    fun loadRelated(urls: List<String>) {
        val itemIds = extractIds(urls)

        if (itemIds.isEmpty()) {
            _relatedState.value = UiState.Success(emptyList())
            return
        }

        collectUiState(
            targetState = _relatedState,
            source = listRepository.getDataByIds(itemIds),
            errorMessage = "Error loading data list",
        )

    }

}