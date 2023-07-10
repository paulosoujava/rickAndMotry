package com.paulo.rickandmorty.data.repositories.remote.network

import com.paulo.rickandmorty.domain.contracts.repositories.INetwork
import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.domain.entities.Episode
import com.paulo.rickandmorty.domain.entities.Location

class NetWorkImpl(
    val api: Api,
) : INetwork {
    override suspend fun getCharacters(): List<Character> {
        return api.getAllCharacters().results.map { it.toEntity() }
    }

    override suspend fun getLocations(): List<Location> {
        return api.getAllLocations().results.map { it.toEntity() }
    }

    override suspend fun getEpisodes(): List<Episode> {
        return api.getAllEpisodes().results.map { it.toEntity() }
    }

    override suspend fun filterCharacters(status: String, name: String): List<Character> {
        return api.getFilterCharacters(status, name).results.map { it.toEntity() }
    }
}
