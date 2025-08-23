package com.mobile.rick_and_morty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.rick_and_morty.ui.screens.main.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {

    // Универсальный helper для сборки Flow в UiState
    // Замечание: Если будет использоваться только в CharacterDetailsViewModel,
    // EpisodeDetailsViewModel, LocationDetailsViewModel, то можно напрямую создать в GenericDetailsViewModel)
    protected fun <R> collectUiState(
        targetState: MutableStateFlow<UiState<R>>,
        source: Flow<R>,
        errorMessage: String = "Error loading data"
    ) {
        viewModelScope.launch {
            source
                .onStart { targetState.value = UiState.Loading }
                .catch { e ->
                    targetState.value = UiState.Error(e.localizedMessage ?: errorMessage)
                }
                .collect { data ->
                    targetState.value = UiState.Success(data)
                }
        }
    }
}