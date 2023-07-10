package com.paulo.rickandmorty.domain.usecases

import com.paulo.rickandmorty.domain.contracts.repositories.INetwork
import com.paulo.rickandmorty.domain.entities.Location
import com.paulo.rickandmorty.domain.utils.DomainResult
import retrofit2.HttpException

class GetLocations(
    private val repository: INetwork,
) {
    suspend operator fun invoke(): DomainResult<List<Location>> {
        return try {
            val result = repository.getLocations()
            DomainResult.Success(result)
        } catch (e: HttpException) {
            DomainResult.Error(e.code(), e.message())
        } catch (t: Throwable) {
            DomainResult.Exception(t)
        }
    }
}
