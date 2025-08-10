package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.LocationsRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.LocationsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class LocationsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLocationsRepository(
        locationsRepositoryImpl: LocationsRepositoryImpl
    ): LocationsRepository
}