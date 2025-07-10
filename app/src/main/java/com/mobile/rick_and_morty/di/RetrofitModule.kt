package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.remote.NetworkModule
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        return NetworkModule.provideApi()
    }
}