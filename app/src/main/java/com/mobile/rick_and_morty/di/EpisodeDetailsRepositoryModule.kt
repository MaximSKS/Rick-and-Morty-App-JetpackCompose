package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.CharacterDetailsRepositoryImpl
import com.mobile.rick_and_morty.data.repository.EpisodeDetailsRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import com.mobile.rick_and_morty.domain.repository.EpisodeDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class EpisodeDetailsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindEpisodeDetailsRepository(
        episodeDetailsRepositoryImpl: EpisodeDetailsRepositoryImpl
    ): EpisodeDetailsRepository
}