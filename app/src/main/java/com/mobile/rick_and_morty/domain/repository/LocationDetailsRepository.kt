package com.mobile.rick_and_morty.domain.repository

import com.mobile.rick_and_morty.domain.model.Location

interface LocationDetailsRepository {
    suspend fun getLocationById(id: Int): Location
}