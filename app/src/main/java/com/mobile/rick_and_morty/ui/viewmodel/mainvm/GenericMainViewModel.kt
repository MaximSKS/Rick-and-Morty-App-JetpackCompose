package com.mobile.rick_and_morty.ui.viewmodel.mainvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mobile.rick_and_morty.domain.repository.RMGenericPagingRepository
import kotlinx.coroutines.flow.Flow

open class GenericMainViewModel<T: Any>(
    repository: RMGenericPagingRepository<T>,
) : ViewModel() {

    protected val pagingDataFlow: Flow<PagingData<T>> = repository
        .getPagedData()
        .cachedIn(viewModelScope) //cachedIn возвращает Flow, удобно кэшировать в scope VM
}