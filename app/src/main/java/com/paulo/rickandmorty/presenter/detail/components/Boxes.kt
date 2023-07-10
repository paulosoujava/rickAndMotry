package com.paulo.rickandmorty.presenter.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.rickandmorty.presenter.common.Logo
import com.paulo.rickandmorty.presenter.ui.theme.Background
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun Boxes(title: String, subTitle: String, color: Color) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Background)
            .padding(10.dp)
    ) {
        Column {
            Text(
                text = title,
                style = TextStyle(
                    color = White,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = subTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    color = Black,
                    fontSize = 16.sp,
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Logo(size = 50, color = color)
            }

        }
    }
}
