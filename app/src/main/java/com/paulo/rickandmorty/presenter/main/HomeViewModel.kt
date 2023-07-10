package com.paulo.rickandmorty.presenter.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.rickandmorty.core.BaseEvent
import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.domain.entities.Episode
import com.paulo.rickandmorty.domain.entities.Location
import com.paulo.rickandmorty.domain.usecases.GetUseCases
import com.paulo.rickandmorty.domain.utils.DomainResult
import com.paulo.rickandmorty.domain.utils.handlerErrorsApi
import com.paulo.rickandmorty.presenter.utils.ActiveClick
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: GetUseCases
) : ViewModel() {

    private val _stateCharacters = MutableStateFlow(HomeUICharacter())
    val stateCharacters = _stateCharacters

    private val _stateEpisode = MutableStateFlow(HomeUIEpisode())
    val stateEpisode = _stateEpisode

    private val _stateLocation = MutableStateFlow(HomeUILocation())
    val stateLocation = _stateLocation

    private val _stateTab = MutableStateFlow(ActiveClick.Characters)
    val stateTab = _stateTab

    init {
        viewModelScope.launch {
            onActiveClick(ActiveClick.Characters)
        }
    }



    fun onActiveClick(it: ActiveClick) {
        viewModelScope.launch {
            when (it) {
                ActiveClick.Characters ->{
                    _stateCharacters.update { it.copy(event = BaseEvent.LOADING) }
                    factoryCall(useCases.getCharacters(), it)
                    _stateTab.value = ActiveClick.Characters
                }
                ActiveClick.Locations -> {
                    _stateLocation.update { it.copy(event = BaseEvent.LOADING) }
                    factoryCall(useCases.getLocations(), it)
                    _stateTab.value = ActiveClick.Locations
                }
                ActiveClick.Episodes ->  {
                    _stateEpisode.update { it.copy(event = BaseEvent.LOADING) }
                    factoryCall(useCases.getEpisodes(), it)
                    _stateTab.value = ActiveClick.Episodes
                }
            }
        }
    }



    private fun <T : Any> factoryCall(result: DomainResult<T>, type: ActiveClick) {
        when (result) {

            is DomainResult.Error -> {
                val messageFromErrors = handlerErrorsApi(result.code)
                updateError(
                    type, "Ops, obtivemos este erro:\n" +
                            "$messageFromErrors\n #${result.message}"
                )

            }

            is DomainResult.Exception -> {
                updateError(
                    type,
                    "Ops, falha nossa tente mais tarde!\n" +
                            " ${result.exception.localizedMessage}",
                )

            }

            is DomainResult.Success -> {
                updateSuccess(
                    type,
                    result.data as List<T>
                )
            }
        }
    }

    private fun <T : Any> updateSuccess(
        type: ActiveClick,
        list: List<T>? = null,
    ) {
        when (type) {
            ActiveClick.Characters -> _stateCharacters.update {
                it.copy(
                    success = list as List<Character>,
                    errorMessage = "",
                    event = BaseEvent.REGULAR
                )
            }

            ActiveClick.Locations -> _stateLocation.update {
                it.copy(
                    success = list as List<Location>,
                    errorMessage = "",
                    event = BaseEvent.REGULAR
                )
            }

            ActiveClick.Episodes -> _stateEpisode.update {
                it.copy(
                    success = list as List<Episode>,
                    errorMessage = "",
                    event = BaseEvent.REGULAR
                )
            }
        }

    }

    private fun updateError(
        type: ActiveClick, messageError: String,
    ) {
        when (type) {
            ActiveClick.Characters -> _stateCharacters.update {
                it.copy(
                    errorMessage = messageError,
                    event = BaseEvent.ERROR
                )
            }

            ActiveClick.Locations -> _stateLocation.update {
                it.copy(
                    errorMessage = messageError,
                    event = BaseEvent.ERROR
                )
            }

            ActiveClick.Episodes -> _stateEpisode.update {
                it.copy(
                    errorMessage = messageError,
                    event = BaseEvent.ERROR
                )
            }
        }

    }

}