package com.paulo.rickandmorty.domain.contracts.repositories

import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.domain.entities.Episode
import com.paulo.rickandmorty.domain.entities.Location


interface INetwork {
    suspend fun getCharacters(): List<Character>
    suspend fun getLocations(): List<Location>
    suspend fun getEpisodes(): List<Episode>
    suspend fun filterCharacters(
        status: String,
        name: String
    ): List<Character>
}