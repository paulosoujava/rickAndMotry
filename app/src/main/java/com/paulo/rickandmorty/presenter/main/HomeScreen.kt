package com.paulo.rickandmorty.presenter.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.paulo.rickandmorty.core.BaseEvent
import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.domain.entities.Episode
import com.paulo.rickandmorty.domain.entities.Location
import com.paulo.rickandmorty.presenter.helpers.LoadingView
import com.paulo.rickandmorty.presenter.helpers.WarningView
import com.paulo.rickandmorty.presenter.main.components.ContentOfHome
import com.paulo.rickandmorty.presenter.utils.ActiveClick

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<HomeViewModel>()

    val stateCharacter = viewModel.stateCharacters.collectAsState()
    val stateEpisode = viewModel.stateEpisode.collectAsState()
    val stateLocation = viewModel.stateLocation.collectAsState()
    val currentTab = viewModel.stateTab.collectAsState()

    when (currentTab.value) {
        ActiveClick.Characters ->
            UiEvent(
                stateCharacter.value.event,
                stateCharacter.value.errorMessage,
                navController,
                viewModel = viewModel,
                listOfCharacter = stateCharacter.value.success,
                listOfEpisode = stateEpisode.value.success,
                listOfLocation = stateLocation.value.success,
                currentTab = currentTab.value,
            )

        ActiveClick.Locations ->
            UiEvent(
                stateLocation.value.event,
                stateLocation.value.errorMessage,
                navController,
                viewModel = viewModel,
                listOfCharacter = stateCharacter.value.success,
                listOfEpisode = stateEpisode.value.success,
                listOfLocation = stateLocation.value.success,
                currentTab = currentTab.value,
            )

        ActiveClick.Episodes ->
            UiEvent(
                stateEpisode.value.event,
                stateEpisode.value.errorMessage,
                navController,
                viewModel = viewModel,
                listOfCharacter = stateCharacter.value.success,
                listOfEpisode = stateEpisode.value.success,
                listOfLocation = stateLocation.value.success,
                currentTab = currentTab.value,
            )
    }
}

@Composable
fun UiEvent(
    event: BaseEvent,
    message: String = "",
    navController: NavHostController,
    viewModel: HomeViewModel,
    listOfCharacter: List<Character>,
    listOfEpisode: List<Episode>,
    listOfLocation: List<Location>,
    currentTab: ActiveClick,
) {
    when (event) {
        BaseEvent.ERROR -> {
            WarningView(message = message)
        }

        BaseEvent.LOADING -> {
            LoadingView()
        }

        BaseEvent.REGULAR -> ContentOfHome(
            navController = navController,
            listOfCharacter = listOfCharacter,
            listOfEpisode = listOfEpisode,
            listOfLocation = listOfLocation,
            currentTab = currentTab,
            onActiveClick = {
                if (it != currentTab) {
                    viewModel.onActiveClick(it)
                }
            },
        )
    }
}
