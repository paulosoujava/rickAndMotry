package com.paulo.rickandmorty.presenter.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.rickandmorty.R
import com.paulo.rickandmorty.core.BaseEvent
import com.paulo.rickandmorty.domain.usecases.ParamDetail
import com.paulo.rickandmorty.presenter.anim.AnimatedText
import com.paulo.rickandmorty.presenter.common.AnimatedBox
import com.paulo.rickandmorty.presenter.common.CustomDivider
import com.paulo.rickandmorty.presenter.common.Logo
import com.paulo.rickandmorty.presenter.common.TextAux
import com.paulo.rickandmorty.presenter.customShapes.DottedShape
import com.paulo.rickandmorty.presenter.helpers.WarningView
import com.paulo.rickandmorty.presenter.nav.Screen
import com.paulo.rickandmorty.presenter.search.components.ContentSearch
import com.paulo.rickandmorty.presenter.search.components.Filters
import com.paulo.rickandmorty.presenter.search.components.InputSearch
import com.paulo.rickandmorty.presenter.search.components.Loading
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.Green
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.Red
import com.paulo.rickandmorty.presenter.ui.theme.White
import com.paulo.rickandmorty.presenter.utils.ActiveClick
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
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .background(
                    Black, shape = RoundedCornerShape(
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
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
                        activeClick.value.name
                    )
                }
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





