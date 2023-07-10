package com.paulo.rickandmorty.presenter.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.rickandmorty.R
import com.paulo.rickandmorty.domain.entities.Location
import com.paulo.rickandmorty.presenter.ui.theme.OrangeDark
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun LocationTab(
    location: Location,
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(
                OrangeDark,
                shape = CutCornerShape(
                    topStart = 20.dp,
                    topEnd = 120.dp,
                ),
            )
            .padding(20.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Name: ${location.name}",
                style = TextStyle(color = White, fontSize = 18.sp),
                modifier = Modifier.weight(2f),
            )
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = null,
                modifier = Modifier.size(90.dp),
            )
        }

        Text(
            text = "Type: ${location.type}",
            style = TextStyle(color = White, fontSize = 18.sp),
        )
        Text(
            text = "Dimension: ${location.dimension}",
            style = TextStyle(color = White, fontSize = 18.sp),
        )
        Text(
            text = "Total number of residents:  ${location.residents.size}",
            style = TextStyle(color = White, fontSize = 18.sp),
        )
    }
}
