package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.detailsrepositoryimpl.CharacterDetailsGenericRepositoryImpl
import com.mobile.rick_and_morty.data.repository.listrepositoryimpl.CharacterGenericListRepositoryImpl
import com.mobile.rick_and_morty.data.repository.pagingrepositoryimpl.CharactersPagingRepositoryImpl
import com.mobile.rick_and_morty.data.repository.detailsrepositoryimpl.EpisodeDetailsGenericRepositoryImpl
import com.mobile.rick_and_morty.data.repository.listrepositoryimpl.EpisodeGenericListRepositoryImpl
import com.mobile.rick_and_morty.data.repository.pagingrepositoryimpl.EpisodesPagingRepositoryImpl
import com.mobile.rick_and_morty.data.repository.detailsrepositoryimpl.LocationDetailsGenericRepositoryImpl
import com.mobile.rick_and_morty.data.repository.pagingrepositoryimpl.LocationsPagingRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import com.mobile.rick_and_morty.domain.repository.CharacterListRepository
import com.mobile.rick_and_morty.domain.repository.CharactersPagingRepository
import com.mobile.rick_and_morty.domain.repository.EpisodeDetailsRepository
import com.mobile.rick_and_morty.domain.repository.EpisodeListRepository
import com.mobile.rick_and_morty.domain.repository.EpisodesPagingRepository
import com.mobile.rick_and_morty.domain.repository.LocationDetailsRepository
import com.mobile.rick_and_morty.domain.repository.LocationsPagingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // Paging repositories
    @Binds
    @Singleton
    abstract fun bindCharactersPagingRepository(
        charactersPagingRepositoryImpl: CharactersPagingRepositoryImpl
    ): CharactersPagingRepository

    @Binds
    @Singleton
    abstract fun bindEpisodesPagingRepository(
        episodesPagingRepositoryImpl: EpisodesPagingRepositoryImpl
    ): EpisodesPagingRepository

    @Binds
    @Singleton
    abstract fun bindLocationsPagingRepository(
        locationsPagingRepositoryImpl: LocationsPagingRepositoryImpl
    ): LocationsPagingRepository

    //  Details repositories
    @Binds
    @Singleton
    abstract fun bindCharacterDetailsRepository(
        characterDetailsRepositoryImpl: CharacterDetailsGenericRepositoryImpl
    ): CharacterDetailsRepository

    @Binds
    @Singleton
    abstract fun bindEpisodeDetailsRepository(
        episodeDetailsRepositoryImpl: EpisodeDetailsGenericRepositoryImpl
    ): EpisodeDetailsRepository

    @Binds
    @Singleton
    abstract fun bindLocationDetailsRepository(
        locationDetailsRepositoryImpl: LocationDetailsGenericRepositoryImpl
    ): LocationDetailsRepository

    // List repositories for details
    @Binds
    abstract fun bindCharacterListRepository(
        characterListRepositoryImpl: CharacterGenericListRepositoryImpl
    ): CharacterListRepository

    @Binds
    abstract fun bindEpisodeListRepository(
        episodeListRepositoryImpl: EpisodeGenericListRepositoryImpl
    ): EpisodeListRepository
}