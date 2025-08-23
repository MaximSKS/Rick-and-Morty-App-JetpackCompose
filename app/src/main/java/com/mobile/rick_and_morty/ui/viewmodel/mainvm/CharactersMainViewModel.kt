package com.mobile.rick_and_morty.ui.viewmodel.mainvm

import androidx.paging.PagingData
import androidx.paging.filter
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.CharacterStatus
import com.mobile.rick_and_morty.domain.repository.CharactersPagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CharactersMainViewModel @Inject constructor(
    pagingRepository: CharactersPagingRepository
) : GenericMainViewModel<Character>(repository = pagingRepository) {

    val characters: Flow<PagingData<Character>>  = pagingDataFlow
}