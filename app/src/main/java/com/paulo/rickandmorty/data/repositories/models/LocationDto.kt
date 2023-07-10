package com.paulo.rickandmorty.data.repositories.models

import com.paulo.rickandmorty.domain.entities.Location


data class LocationDto(
    val id: Long = 0L,
    val name: String = "",
    val type: String = "",
    val dimension: String = "",
    val residents: List<String> = emptyList(),
    val url: String = "",
    val created: String = "",
) {
    fun toEntity(): Location {
        return Location(
            name = name,
            url = url,
            created = created,
            id = id,
            type = type,
            dimension = dimension,
            residents = residents
        )
    }
}