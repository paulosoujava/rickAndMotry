package com.paulo.rickandmorty.data.repositories.remote.responsers

data class Info(
    val count: Long,
    val pages: Long,
    val next: String,
    val prev: Any?,
)
