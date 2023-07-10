package com.paulo.rickandmorty.presenter.favorite.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.paulo.rickandmorty.R
import com.paulo.rickandmorty.presenter.common.CustomDivider
import com.paulo.rickandmorty.presenter.ui.theme.Gray
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun HeaderFavorite(
    onClickBack: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            IconButton(
                modifier = Modifier
                    .size(34.dp)
                    .background(Orange, shape = RoundedCornerShape(50.dp))
                    .clip(RoundedCornerShape(50.dp)),
                onClick = onClickBack ) {
                Icon(Icons.Default.ArrowBack, contentDescription = null, tint = White)
            }
            Text(
                text = "Favorites ",
                modifier = Modifier.weight(2f),
                maxLines = 1,
                style = TextStyle(
                    color = White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Image(
                painterResource(id = R.drawable.logo), contentDescription = null,
                modifier = Modifier.size(94.dp),
            )
        }
        CustomDivider()
        content()
    }
}