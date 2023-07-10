package com.paulo.rickandmorty.presenter.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.Gray
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.OrangeDark
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun InputSearch(
    search: String,
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onFilter: () -> Unit,
    onValueChange: (String) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        Box(
            modifier = modifier
                .background(Orange, shape = RoundedCornerShape(
                    topStart = 50.dp,
                    bottomStart = 50.dp,
                    topEnd = 8.dp,
                    bottomEnd = 8.dp
                ))
                .weight(3f)
                .padding(5.dp)
                .clip(RoundedCornerShape(
                    topStart = 50.dp,
                    bottomStart = 50.dp,
                    topEnd = 8.dp,
                    bottomEnd = 8.dp
                ))

        ) {
            androidx.compose.material.TextField(
                modifier = Modifier.fillMaxWidth(),
                value = search,
                onValueChange = onValueChange,
                maxLines = 1,
                colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
                    backgroundColor = White,
                    placeholderColor = Gray,
                    leadingIconColor = White,
                    trailingIconColor = White,
                    textColor = Black,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Black,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                },

                //trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                placeholder = { Text(text = "Search") }
            )
        }
        IconButton(
            modifier = Modifier
                .height(50.dp)
                .background(Orange, shape = RoundedCornerShape(
                    topStart = 0.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 50.dp,
                    topEnd = 50.dp
                ))
                .clip(RoundedCornerShape(
                    topStart = 0.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 50.dp,
                    topEnd = 50.dp
                )),
            onClick = onFilter) {
            Icon(Icons.Default.Search, contentDescription = "", tint = Color.White)
        }
    }
}