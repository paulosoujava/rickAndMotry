package com.paulo.rickandmorty.presenter.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.rickandmorty.R
import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.presenter.common.Logo
import com.paulo.rickandmorty.presenter.customShapes.TicketShape
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.Gray
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun CharacterTab(
    character: Character,
    onClickCard: (Character) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(190.dp)
            .border(
                1.dp,
                Orange,
                shape = TicketShape(12.dp, CornerSize(12.dp)),
            )
            .background(
                Black,
                shape = TicketShape(12.dp, CornerSize(12.dp)),
            )
            .clickable { onClickCard(character) },
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 15.dp,
                            bottomStart = 15.dp,
                        ),
                    )
                    .width(174.dp)
                    .height(190.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,

            )
            Logo(size = 20)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
            ) {
                Text(
                    text = character.name,
                    style = TextStyle(color = White, fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "Specie: ${character.species}",
                    style = TextStyle(color = White, fontSize = 13.sp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
                Divider(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
                Text(
                    text = "Last Known location:",
                    style = TextStyle(color = Gray, fontSize = 14.sp),
                )
                Text(
                    text = character.location.name,
                    style = TextStyle(color = White, fontSize = 16.sp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}
