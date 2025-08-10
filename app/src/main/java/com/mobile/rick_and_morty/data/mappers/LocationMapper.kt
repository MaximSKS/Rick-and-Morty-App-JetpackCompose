package com.mobile.rick_and_morty.data.mappers

import com.mobile.rick_and_morty.data.model.CharacterLocationDto
import com.mobile.rick_and_morty.data.model.LocationDto
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.domain.model.SimpleLocation

fun LocationDto.toDomain(): Location {
    return Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents,
        url = url,
        created = created
    )
}

fun CharacterLocationDto.toDomain(): SimpleLocation =
    SimpleLocation(name = name, url = url)