package com.paulo.rickandmorty.presenter.search

import com.paulo.rickandmorty.core.BaseEvent
import com.paulo.rickandmorty.core.BaseUI
import com.paulo.rickandmorty.domain.entities.Character

data class SearchUI(
    override val errorMessage: String = "",
    override val success: List<Character> = emptyList(),
    override val event: BaseEvent = BaseEvent.REGULAR
) : BaseUI<Character>
