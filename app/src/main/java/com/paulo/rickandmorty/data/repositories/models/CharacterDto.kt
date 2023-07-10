package com.paulo.rickandmorty.data.repositories.models

import com.paulo.rickandmorty.domain.entities.Character

data class CharacterDto(

    val id: Long = 0L,

    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val origin: OriginDto = OriginDto(),
    val location: LocationDto = LocationDto(),
    val image: String = "",
    val episode: List<String> = emptyList(),
    val url: String = "",
    val created: String = "",
) {
    fun toEntity(): Character {
        return Character(
            id = id,
            name = name,
            status = status,
            species = species,
            type = type,
            gender = gender,
            origin = origin.toEntity(),
            location = location.toEntity(),
            image = image,
            episode = episode,
            url = url,
            created = created,
        )
    }
}
