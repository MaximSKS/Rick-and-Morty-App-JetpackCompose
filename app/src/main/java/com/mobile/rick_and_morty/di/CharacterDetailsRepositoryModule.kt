package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.CharacterDetailsRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterDetailsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharacterDetailsRepository(
        characterDetailsRepositoryImpl: CharacterDetailsRepositoryImpl
    ): CharacterDetailsRepository
}