package com.paulo.rickandmorty.data.di

import android.content.Context
import com.paulo.rickandmorty.data.repositories.cache.okHttpClient
import com.paulo.rickandmorty.data.repositories.remote.network.Api
import com.paulo.rickandmorty.data.repositories.remote.network.NetWorkImpl
import com.paulo.rickandmorty.data.utils.Constants
import com.paulo.rickandmorty.domain.contracts.repositories.INetwork
import com.paulo.rickandmorty.domain.usecases.GetByFilter
import com.paulo.rickandmorty.domain.usecases.GetCharacters
import com.paulo.rickandmorty.domain.usecases.GetEpisodes
import com.paulo.rickandmorty.domain.usecases.GetLocations
import com.paulo.rickandmorty.domain.usecases.GetUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    // ********************************************************
    // RETROFIT
    // ********************************************************

    @Provides
    @Singleton
    fun provideApi(@ApplicationContext context: Context): Api {
        return Retrofit.Builder()
            .client(okHttpClient(context))
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    // ********************************************************
    // USE CASES
    // ********************************************************
    @Provides
    @Singleton
    fun provideUseCases(
        getCharacters: GetCharacters,
        getLocations: GetLocations,
        getEpisodes: GetEpisodes,
    ) = GetUseCases(
        getCharacters = getCharacters,
        getLocations = getLocations,
        getEpisodes = getEpisodes,
    )

    @Provides
    @Singleton
    fun providerFilterSearch(
        repository: INetwork,
    ) = GetByFilter(repository)

    @Provides
    @Singleton
    fun provideCharacterUseCases(
        repository: INetwork,
    ) = GetCharacters(repository = repository)

    @Provides
    @Singleton
    fun provideLocationsUseCases(
        repository: INetwork,
    ) = GetLocations(repository = repository)

    @Provides
    @Singleton
    fun provideEpisodesUseCases(
        repository: INetwork,
    ) = GetEpisodes(repository = repository)

    // ********************************************************
    // REPOSITORIES
    // ********************************************************
    @Provides
    @Singleton
    fun provideRemoteRepository(api: Api): INetwork {
        return NetWorkImpl(api)
    }
}
