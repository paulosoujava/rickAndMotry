package com.paulo.rickandmorty.data.repositories.models

import com.google.gson.annotations.SerializedName
import com.paulo.rickandmorty.domain.entities.Episode

data class EpisodeDto(
    val id: Long?,
    val name: String?,
    @SerializedName("air_date")
    val airDate: String?,
    val episode: String?,
    val characters: List<String>,
    val url: String?,
    val created: String?,
){
    fun toEntity(): Episode {
        return Episode(
            id = id ?: 0L,
            name = name ?: "",
            airDate = airDate ?: "",
            episode = episode ?: "",
            characters = characters,
            url = url ?: "",
            created = created ?: "",
        )
    }
}