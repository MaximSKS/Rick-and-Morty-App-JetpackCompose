package com.mobile.rick_and_morty.data.remote

import com.mobile.rick_and_morty.data.model.CharacterDto
import com.mobile.rick_and_morty.data.model.CharactersPageDto
import com.mobile.rick_and_morty.data.model.EpisodeDto
import com.mobile.rick_and_morty.data.model.EpisodesPageDto
import com.mobile.rick_and_morty.data.model.LocationDto
import com.mobile.rick_and_morty.data.model.LocationsPageDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharactersPageDto

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterDto

    // for displaying characters on the EpisodeDetailsScreen
    @GET("character/{ids}")
    suspend fun getCharactersByIds(@Path("ids") ids: String): List<CharacterDto>

    @GET("episode")
    suspend fun getEpisodes(@Query("page") page: Int): EpisodesPageDto

    @GET("episode/{id}")
    suspend fun getEpisode(@Path("id") id: Int): EpisodeDto

    @GET("episode/{ids}")
    suspend fun getEpisodesByIds(@Path("ids") ids: String): List<EpisodeDto>


    @GET("location")
    suspend fun getLocations(@Query("page") page: Int): LocationsPageDto

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): LocationDto

    @GET("location/{ids}")
    suspend fun getLocationsByIds(@Path("ids") ids: String): List<LocationDto>
}