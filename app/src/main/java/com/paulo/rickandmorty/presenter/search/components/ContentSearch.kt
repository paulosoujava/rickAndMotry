package com.paulo.rickandmorty.presenter.search.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.rickandmorty.R
import com.paulo.rickandmorty.domain.usecases.ParamDetail
import com.paulo.rickandmorty.presenter.common.CustomDivider
import com.paulo.rickandmorty.presenter.nav.Screen
import com.paulo.rickandmorty.presenter.search.SearchUI
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.Green
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.Red
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
@OptIn(ExperimentalMaterial3Api::class)
 fun ColumnScope.ContentSearch(
    state: State<SearchUI>,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .weight(1f)
    ) {
        item {
            AnimatedVisibility(visible = state.value.success.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null
                    )
                    Text(
                        text = "Do something interesting",
                        style = TextStyle(
                            color = Black,
                            fontSize = 24.sp,
                        )
                    )
                }
            }
        }
        items(state.value.success) { person ->

            Box(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = CutCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Black
                    ),
                    onClick = {
                        ParamDetail.character = person
                        navController.navigate("${Screen.Detail.route}/${person.id}")
                    }) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 15.dp,
                                        bottomStart = 15.dp
                                    )
                                )
                                .size(154.dp),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(person.image)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.logo),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,

                            )
                        Column(
                            modifier = Modifier.padding(top = 15.dp)
                        ) {
                            Text(
                                text = "${person.name} ",

                                style = TextStyle(
                                    color = White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                maxLines = 1,
                            )
                            CustomDivider()
                            Row() {
                                Text(
                                    text = "Status: ${person.status}",
                                    color = White,
                                )
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .background(
                                            when (person.status) {
                                                "Alive" -> Green
                                                "Dead" -> Red
                                                else -> Orange
                                            },
                                            shape = RoundedCornerShape(50.dp)
                                        )
                                )
                            }

                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .background(
                                            Orange,
                                            shape = CutCornerShape(10.dp)
                                        )
                                        .size(30.dp)
                                        .clip(CutCornerShape(12.dp)),
                                ) {
                                    IconButton(onClick = { navController.navigate("${Screen.Detail.route}/${person.id}") }) {
                                        Icon(
                                            Icons.Default.ArrowForward,
                                            contentDescription = null
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}