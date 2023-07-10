package com.paulo.rickandmorty.data.repositories.models

import com.paulo.rickandmorty.domain.entities.Origin

data class OriginDto(

    val name: String = "",
    val url: String = "",
) {
    fun toEntity(): Origin {
        return Origin(
            name = name,
            url = url,
        )
    }
}
