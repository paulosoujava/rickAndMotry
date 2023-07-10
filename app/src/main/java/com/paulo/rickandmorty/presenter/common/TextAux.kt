package com.paulo.rickandmorty.presenter.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.rickandmorty.presenter.ui.theme.Black

    @Composable
    fun TextAux(text: String) {
        Text(text = text,
            modifier = Modifier.padding(15.dp),
            style = TextStyle(
                color = Black,
                fontSize = 16.sp,
            )
        )
    }
