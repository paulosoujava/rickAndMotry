package com.paulo.rickandmorty.presenter.favorite.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.rickandmorty.R
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.Red
import com.paulo.rickandmorty.presenter.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentFavorite(
    onNavigate: (String) -> Unit,
    onClosePopUp: () -> Unit
) {
    val numbers = (0..20).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(numbers.size) {
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
                ),
                onClick = {
                    onNavigate("123")
                }
            ) {
                Box {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(184.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://rickandmortyapi.com/api/character/avatar/645.jpeg")
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.logo),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,

                        )
                    Vertical(
                        onDelete = onClosePopUp,
                        onNavigate = { onNavigate("123") }
                    )
                }
            }
        }
    }
}

@Composable
fun Vertical(
    onDelete: () -> Unit,
    onNavigate: () -> Unit,
) {
    Column(
        modifier = Modifier.size(180.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .vertical()
                    .rotate(-90f)
                    .background(Black.copy(alpha = 0.8f))
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { onNavigate() }) {
                    Icon(
                        Icons.Default.Person, contentDescription = null, tint = Orange,
                        modifier = Modifier.size(14.dp)
                    )
                }
                Text(

                    text = "Rick Sanchez",
                    style = TextStyle(
                        color = White,
                    )
                )
                IconButton(onClick = { onDelete() }) {
                    Icon(
                        Icons.Default.Delete, contentDescription = null, tint = Red,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }


        }
    }
}

fun Modifier.vertical() =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.height, placeable.width) {
            placeable.place(
                x = -(placeable.width / 2 - placeable.height / 2),
                y = -(placeable.height / 2 - placeable.width / 2)
            )
        }
    }