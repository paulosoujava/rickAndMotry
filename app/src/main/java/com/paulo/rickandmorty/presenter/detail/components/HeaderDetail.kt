package com.paulo.rickandmorty.presenter.detail.components

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
import com.paulo.rickandmorty.domain.usecases.ParamDetail
import com.paulo.rickandmorty.domain.utils.converterData
import com.paulo.rickandmorty.presenter.ui.theme.Gray
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun HeaderDetail(
    onClickBack: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,

) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(184.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(ParamDetail.character.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,

        )
        Row(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            IconButton(
                modifier = Modifier
                    .size(34.dp)
                    .background(Orange, shape = RoundedCornerShape(50.dp))
                    .clip(RoundedCornerShape(50.dp)),
                onClick = onClickBack,
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = null, tint = White)
            }
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    text = ParamDetail.character.name,
                    maxLines = 1,
                    style = TextStyle(
                        color = White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                )
                Text(
                    text = converterData(ParamDetail.character.created),
                    maxLines = 1,
                    style = TextStyle(
                        color = Gray,
                        fontSize = 17.sp,
                    ),
                )
            }
        }
        content()
    }
}
