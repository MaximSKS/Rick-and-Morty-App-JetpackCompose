package com.mobile.rick_and_morty.ui.viewmodel.mainvm

import androidx.paging.PagingData
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.domain.repository.LocationsPagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    pagingRepository: LocationsPagingRepository
) : GenericMainViewModel<Location>(repository = pagingRepository) {

    val locations: Flow<PagingData<Location>> = pagingDataFlow
}