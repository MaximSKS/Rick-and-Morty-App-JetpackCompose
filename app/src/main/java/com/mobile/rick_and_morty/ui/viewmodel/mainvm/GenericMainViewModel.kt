package com.mobile.rick_and_morty.ui.viewmodel.mainvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mobile.rick_and_morty.domain.repository.RMGenericDetailsRepository
import com.mobile.rick_and_morty.domain.repository.RMGenericListRepository
import com.mobile.rick_and_morty.domain.repository.RMGenericPagingRepository
import com.mobile.rick_and_morty.ui.screens.main.UiState
import com.mobile.rick_and_morty.ui.viewmodel.BaseViewModel
import com.mobile.rick_and_morty.utils.extractIds
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

open class GenericMainViewModel<T: Any>(
    repository: RMGenericPagingRepository<T>,
) : ViewModel() {

   protected val pagingDataFlow: Flow<PagingData<T>> = repository
        .getPagedData()
        .cachedIn(viewModelScope) //cachedIn возвращает Flow, удобно кэшировать в scope VM
}