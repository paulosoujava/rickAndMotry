package com.paulo.rickandmorty.domain.usecases

data class GetUseCases(
    val getCharacters: GetCharacters,
    val getLocations: GetLocations,
    val getEpisodes: GetEpisodes,
)