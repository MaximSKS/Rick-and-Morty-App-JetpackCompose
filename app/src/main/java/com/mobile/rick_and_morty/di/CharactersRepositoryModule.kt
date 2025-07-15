package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.CharactersRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CharactersRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharactersRepository(
        charactersRepositoryImpl: CharactersRepositoryImpl
    ): CharactersRepository
}