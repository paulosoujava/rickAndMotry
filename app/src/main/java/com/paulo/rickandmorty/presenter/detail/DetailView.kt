package com.paulo.rickandmorty.presenter.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.paulo.rickandmorty.presenter.detail.components.ContentDetail
import com.paulo.rickandmorty.presenter.detail.components.HeaderDetail
import com.paulo.rickandmorty.presenter.ui.theme.Black


@Composable
fun DetailView(navController: NavHostController) {
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
            HeaderDetail(
                onClickBack = {
                    navController.popBackStack()
                }
            ) {
                ContentDetail()
            }
        }

    }
}


