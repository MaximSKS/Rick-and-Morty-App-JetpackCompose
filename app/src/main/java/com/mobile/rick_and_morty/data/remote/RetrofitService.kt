package com.mobile.rick_and_morty.data.remote

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/"

private val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BASIC
}


private val client by lazy {
    OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
}

private val retrofit by lazy {
    val moshi = Moshi.Builder().build()
     Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}


object NetworkModule {
    fun provideApi(): RickAndMortyApi =
        retrofit.create(RickAndMortyApi::class.java)
}