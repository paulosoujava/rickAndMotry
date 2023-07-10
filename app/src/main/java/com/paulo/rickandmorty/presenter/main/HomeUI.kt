package com.paulo.rickandmorty.presenter.main

import com.paulo.rickandmorty.core.BaseEvent
import com.paulo.rickandmorty.core.BaseUI
import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.domain.entities.Episode
import com.paulo.rickandmorty.domain.entities.Location

data class HomeUICharacter(
    override val errorMessage: String = "",
    override val success: List<Character> = emptyList(),
    override val event: BaseEvent = BaseEvent.LOADING
): BaseUI<Character>

data class HomeUIEpisode(
    override val errorMessage: String = "",
    override val success: List<Episode> = emptyList(),
    override val event: BaseEvent = BaseEvent.LOADING
): BaseUI<Episode>

data class HomeUILocation(
    override val errorMessage: String = "",
    override val success: List<Location> = emptyList(),
    override val event: BaseEvent = BaseEvent.LOADING
): BaseUI<Location>