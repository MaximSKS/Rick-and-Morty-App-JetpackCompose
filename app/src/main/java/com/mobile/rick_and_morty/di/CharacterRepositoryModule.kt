package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.CharacterRepositoryImpl
import com.mobile.rick_and_morty.data.repository.EpisodeRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.CharacterRepository
import com.mobile.rick_and_morty.domain.repository.EpisodeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(
        episodeRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository
}