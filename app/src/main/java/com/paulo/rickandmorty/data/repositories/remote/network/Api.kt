package com.paulo.rickandmorty.data.repositories.remote.network


import com.paulo.rickandmorty.data.repositories.models.CharacterDto
import com.paulo.rickandmorty.data.repositories.models.EpisodeDto
import com.paulo.rickandmorty.data.repositories.models.LocationDto
import com.paulo.rickandmorty.data.repositories.remote.responsers.ResultNetWorkTypeIs
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("character")
    suspend fun getAllCharacters(): ResultNetWorkTypeIs<CharacterDto>

    @GET("episode")
    suspend fun getAllEpisodes(): ResultNetWorkTypeIs<EpisodeDto>

    @GET("location")
    suspend fun getAllLocations(): ResultNetWorkTypeIs<LocationDto>

    @GET("character")
    suspend fun getFilterCharacters(
        @Query("name") name: String,
        @Query("status") status: String,
    ): ResultNetWorkTypeIs<CharacterDto>
}