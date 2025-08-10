package com.mobile.rick_and_morty.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationsPageDto(
    val info: InfoDto,
    val results: List<LocationDto>
)