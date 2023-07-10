package com.paulo.rickandmorty.presenter.favorite


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.paulo.rickandmorty.presenter.favorite.components.ContentFavorite
import com.paulo.rickandmorty.presenter.favorite.components.HeaderFavorite
import com.paulo.rickandmorty.presenter.favorite.components.PopUpFavorite
import com.paulo.rickandmorty.presenter.nav.Screen
import com.paulo.rickandmorty.presenter.ui.theme.Black


@Composable
fun FavoriteView(navController: NavHostController) {
    var showPopUp by remember {
        mutableStateOf(false)
    }
    val density = LocalDensity.current
    Box {
        Card(
            modifier = Modifier
                .clip(CutCornerShape(12.dp))
                .fillMaxSize()
                .padding(10.dp),
            shape = CutCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Black
            )
        ) {


            HeaderFavorite(
                onClickBack = {
                    navController.popBackStack()
                }
            ) {
                ContentFavorite(
                    onNavigate = {
                        navController.navigate("${Screen.Detail.route}/${it}")
                    }
                ) {
                    showPopUp = !showPopUp
                }
            }
        }



        AnimatedVisibility(visible = showPopUp,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()) {
            PopUpFavorite(
                onClickClose = {
                    showPopUp = !showPopUp
                },
                onClickDelete = {
                    showPopUp = !showPopUp
                }
            )
        }

    }
}


