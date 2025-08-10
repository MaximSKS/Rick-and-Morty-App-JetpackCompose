package com.mobile.rick_and_morty.domain.model

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)

data class SimpleLocation(
    val name: String,
    val url: String
)