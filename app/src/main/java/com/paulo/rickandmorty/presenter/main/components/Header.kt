package com.paulo.rickandmorty.presenter.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paulo.rickandmorty.presenter.anim.AnimatedText
import com.paulo.rickandmorty.presenter.common.AnimatedBox
import com.paulo.rickandmorty.presenter.common.CustomDivider
import com.paulo.rickandmorty.presenter.common.Logo
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.White
import com.paulo.rickandmorty.presenter.utils.ActiveClick


@Composable
fun Header(
    onSearchClick: () -> Unit,
    onActiveClick: (ActiveClick) -> Unit,
    currentTab: ActiveClick
) {
    val activeClick = remember {
        mutableStateOf(currentTab)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp)
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AnimatedText(
                text = "Rick",
            )

            Logo(size = 50)
            Box(modifier = Modifier.weight(1f)) {
                AnimatedText(text = "Morty")
            }

            IconButton(onClick = onSearchClick) {
                Icon(Icons.Default.Search, contentDescription = null, tint = White)
            }

        }

        CustomDivider()


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (actClick in ActiveClick.values()) {
                AnimatedBox(
                    title = actClick.name,
                    active = when (actClick) {
                        ActiveClick.Characters -> activeClick.value == ActiveClick.Characters
                        ActiveClick.Locations -> activeClick.value == ActiveClick.Locations
                        ActiveClick.Episodes -> activeClick.value == ActiveClick.Episodes
                    }
                ) {
                    onActiveClick( actClick )

                    when (actClick) {
                        ActiveClick.Characters ->
                        {
                            activeClick.value = ActiveClick.Characters

                        }
                        ActiveClick.Locations -> activeClick.value = ActiveClick.Locations
                        ActiveClick.Episodes -> activeClick.value = ActiveClick.Episodes
                    }
                }
            }
        }

    }
}
