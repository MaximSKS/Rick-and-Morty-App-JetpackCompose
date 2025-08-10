package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.LocationDetailsRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.LocationDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationDetailsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLocationDetailsRepository(
        locationDetailsRepositoryImpl: LocationDetailsRepositoryImpl
    ): LocationDetailsRepository
}