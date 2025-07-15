package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.EpisodesRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.EpisodesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class EpisodesRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindEpisodesRepository(
        episodesRepositoryImpl: EpisodesRepositoryImpl
    ): EpisodesRepository
}