package com.paulo.rickandmorty.presenter.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paulo.rickandmorty.domain.usecases.ParamDetail
import com.paulo.rickandmorty.presenter.common.CustomDivider
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.Blue
import com.paulo.rickandmorty.presenter.ui.theme.GreenDark
import com.paulo.rickandmorty.presenter.ui.theme.Purple
import com.paulo.rickandmorty.presenter.ui.theme.Red
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun ContentDetail() {
    CustomDivider()
    Row(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(1f)) {
            Boxes(title = "Status", subTitle = ParamDetail.character.status, Red)
            Boxes(title = "Species", subTitle = ParamDetail.character.species, Black)
        }

        Column(modifier = Modifier.weight(1f)) {
            Boxes(title = "Gender", subTitle = ParamDetail.character.gender, GreenDark)
            Boxes(title = "Origin", subTitle = ParamDetail.character.origin.name, Blue)
        }
    }
    Row(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            Boxes(
                title = "location",
                subTitle = ParamDetail.character.location.name,
                Purple,
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            Boxes(
                title = "episode",
                subTitle = ParamDetail.character.episode.size.toString(),
                White,
            )
        }
    }
}
