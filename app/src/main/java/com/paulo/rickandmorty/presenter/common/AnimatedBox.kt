package com.paulo.rickandmorty.presenter.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.rickandmorty.presenter.customShapes.TicketShape
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun AnimatedBox(
    title: String,
    active: Boolean = false,
    onClick: (String) -> Unit = {},
) {
    val activeColor = if (active) White else Orange
    Box(
        modifier = Modifier
            .size(80.dp)
            .border(1.dp, activeColor, shape = TicketShape(12.dp, CornerSize(12.dp)))
            .clickable { onClick(title) },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            style = TextStyle(fontSize = 15.sp, color = activeColor),
        )
    }
}
