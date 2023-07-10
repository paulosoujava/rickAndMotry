package com.paulo.rickandmorty.domain.usecases

import com.paulo.rickandmorty.domain.contracts.repositories.INetwork
import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.domain.utils.DomainResult
import retrofit2.HttpException

class GetByFilter(
    private val repository: INetwork,
) {
    suspend operator fun invoke(status: String, name: String): DomainResult<List<Character>> {
        return try {
            val result = repository.filterCharacters(status, name)
            DomainResult.Success(result)
        } catch (e: HttpException) {
            DomainResult.Error(e.code(), e.message())
        } catch (t: Throwable) {
            DomainResult.Exception(t)
        }
    }
}
