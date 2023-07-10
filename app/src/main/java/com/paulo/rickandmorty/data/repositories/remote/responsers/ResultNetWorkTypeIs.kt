package com.paulo.rickandmorty.data.repositories.remote.responsers

data class ResultNetWorkTypeIs<T>(
    val info: Info,
    val results: List<T>,
)