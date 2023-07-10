package com.paulo.rickandmorty.presenter.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.paulo.rickandmorty.presenter.customShapes.DottedShape
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun CustomDivider(color: Color = White, iconColor: Color = White, sizeIcon: Int = 20) {
    Row {
        Box(
            Modifier
                .padding(top = 10.dp, bottom = 15.dp)
                .height(1.dp)
                .weight(1f)
                .background(color, shape = DottedShape(step = 10.dp)),
        )
        Logo(sizeIcon, color = iconColor)
        Box(
            Modifier.weight(1f)
                .padding(top = 10.dp, bottom = 15.dp)
                .height(1.dp)
                .fillMaxWidth()
                .background(color, shape = DottedShape(step = 10.dp)),
        )
    }
}
