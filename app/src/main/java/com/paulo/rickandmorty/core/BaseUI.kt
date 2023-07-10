package com.paulo.rickandmorty.core

interface BaseUI<T> {
    val success: List<T>
    val errorMessage: String
    val event: BaseEvent
}