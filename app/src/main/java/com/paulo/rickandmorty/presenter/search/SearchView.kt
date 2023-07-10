package com.paulo.rickandmorty.presenter.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.paulo.rickandmorty.core.BaseEvent
import com.paulo.rickandmorty.presenter.common.CustomDivider
import com.paulo.rickandmorty.presenter.helpers.WarningView
import com.paulo.rickandmorty.presenter.search.components.ContentSearch
import com.paulo.rickandmorty.presenter.search.components.Filters
import com.paulo.rickandmorty.presenter.search.components.InputSearch
import com.paulo.rickandmorty.presenter.search.components.Loading
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.utils.Filter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(navController: NavHostController) {
    val activeClick = remember {
        mutableStateOf(Filter.Alive)
    }
    val viewModel = hiltViewModel<SearchViewModel>()
    val state = viewModel.stateSearch.collectAsState()

    var query by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .background(
                    Black,
                    shape = RoundedCornerShape(
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp,
                    ),
                )
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            InputSearch(
                search = query,
                onValueChange = {
                    query = it
                },
                onClickBack = {
                    navController.popBackStack()
                },
                onFilter = {
                    viewModel.onSearchTextChange(
                        query,
                        activeClick.value.name,
                    )
                },
            )

            CustomDivider()

            Filters(activeClick)
        }
        Spacer(modifier = Modifier.height(16.dp))

        when (state.value.event) {
            BaseEvent.LOADING -> Loading()
            BaseEvent.ERROR -> WarningView(message = state.value.errorMessage)
            BaseEvent.REGULAR -> {
                ContentSearch(state, navController)
            }
        }
    }
}
