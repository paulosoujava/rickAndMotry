package com.paulo.rickandmorty.presenter.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.paulo.rickandmorty.presenter.common.AnimatedBox
import com.paulo.rickandmorty.presenter.utils.Filter

@Composable
fun Filters(activeClick: MutableState<Filter>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        for (actClick in Filter.values()) {
            AnimatedBox(
                title = actClick.name,
                active = when (actClick) {
                    Filter.Alive -> activeClick.value == Filter.Alive
                    Filter.Dead -> activeClick.value == Filter.Dead
                    Filter.Unknown -> activeClick.value == Filter.Unknown
                },
            ) {
                when (actClick) {
                    Filter.Alive -> activeClick.value = Filter.Alive
                    Filter.Dead -> activeClick.value = Filter.Dead
                    Filter.Unknown -> activeClick.value = Filter.Unknown
                }
            }
        }
    }
}
