package com.paulo.rickandmorty.presenter.main.components

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.domain.entities.Episode
import com.paulo.rickandmorty.domain.entities.Location
import com.paulo.rickandmorty.domain.usecases.ParamDetail
import com.paulo.rickandmorty.domain.utils.isOnline
import com.paulo.rickandmorty.presenter.nav.Screen
import com.paulo.rickandmorty.presenter.utils.ActiveClick


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentOfHome(
    navController: NavHostController,
    currentTab: ActiveClick,
    listOfCharacter: List<Character>,
    listOfEpisode: List<Episode>,
    listOfLocation: List<Location>,
    onActiveClick: (ActiveClick) -> Unit,
) {
    val context = LocalContext.current

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        stickyHeader {
            Header(
                onSearchClick = {
                    if (isOnline(context))
                        navController.navigate(Screen.Search.route)
                    else {
                        Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
                    }
                },
                onActiveClick = {
                    onActiveClick(it)
                },
                currentTab = currentTab
            )
        }

        items(listOfCharacter) { character ->
            AnimatedVisibility(visible = currentTab == ActiveClick.Characters) {
                CharacterTab(
                    character = character,
                    onClickCard = {
                        ParamDetail.character = it
                        navController.navigate(
                            "${Screen.Detail.route}/${it.id}"
                        )
                    }
                )
            }
        }
        items(listOfEpisode) { episode ->
            AnimatedVisibility(visible = currentTab == ActiveClick.Episodes) {
                EpisodeTab(episode = episode)

            }
        }
        items(listOfLocation) { location ->
            AnimatedVisibility(visible = currentTab == ActiveClick.Locations) {
                LocationTab(location = location)
            }
        }
    }
}
