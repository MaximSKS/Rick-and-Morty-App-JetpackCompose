package com.mobile.rick_and_morty.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationDto(
    val id: Int,
    val name: String,
    val type: String, // The type of the location.
    val dimension: String,    // The dimension in which the location is located.
    val residents: List<String>,  // List of character who have been last seen in the location.
    val url: String, // Link to the location's own endpoint.
    val created: String //	Time at which the location was created in the database.
)