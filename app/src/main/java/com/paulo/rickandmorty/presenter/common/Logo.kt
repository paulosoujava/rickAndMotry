package com.paulo.rickandmorty.presenter.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.paulo.rickandmorty.R
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun Logo(size: Int, color: Color = White) {
    Image(
        modifier = Modifier.size(size.dp),
        painter = painterResource(id = R.drawable.splash),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color),
    )
}