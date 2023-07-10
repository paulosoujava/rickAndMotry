package com.paulo.rickandmorty.presenter.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.rickandmorty.domain.entities.Episode
import com.paulo.rickandmorty.presenter.common.Logo
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun EpisodeTab(
    episode: Episode,
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(
                Black,
                shape = CutCornerShape(
                    bottomEnd = 20.dp,
                    bottomStart = 20.dp,
                ),
            )
            .padding(20.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Name: ${episode.name}",
                style = TextStyle(color = White, fontSize = 18.sp),
                modifier = Modifier.weight(2f),
            )
            Logo(size = 45)
        }

        Text(
            text = "Date of air: ${episode.airDate}",
            style = TextStyle(color = White, fontSize = 18.sp),
        )
        Text(
            text = "Episode: ${episode.episode}",
            style = TextStyle(color = White, fontSize = 18.sp),
        )
        Text(
            text = "Total number of characters:  ${episode.characters.size}",
            style = TextStyle(color = White, fontSize = 18.sp),
        )
    }
}
