package com.mobile.rick_and_morty.ui.navigation.typesafenavigation

import kotlinx.serialization.Serializable

@Serializable
data object CharactersMain

@Serializable
data class CharacterDetails(val id: Int)

@Serializable
data object Locations

@Serializable
data class LocationDetails(val id: Int)

@Serializable
data object Episodes

@Serializable
data class EpisodeDetails(val id: Int)