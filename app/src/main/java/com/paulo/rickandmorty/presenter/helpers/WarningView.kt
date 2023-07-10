package com.paulo.rickandmorty.presenter.helpers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.rickandmorty.R
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.White


@Composable
fun WarningView(message: String) {

    Column(
        modifier = Modifier.fillMaxSize().background(Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 35.dp, end = 35.dp),
            text = message, style = TextStyle(
                fontSize = 18.sp, color = White, fontWeight = FontWeight.Bold
            )
        )
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)

    }
}