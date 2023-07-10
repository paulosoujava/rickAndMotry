package com.paulo.rickandmorty.presenter.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paulo.rickandmorty.presenter.common.Logo
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
 fun Loading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = White,
            strokeWidth = 2.dp
        )
        Logo(size = 30, color = White)

    }
}