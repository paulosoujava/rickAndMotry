package com.paulo.rickandmorty.presenter.favorite.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.rickandmorty.presenter.common.CustomDivider
import com.paulo.rickandmorty.presenter.common.Logo
import com.paulo.rickandmorty.presenter.common.TextAux
import com.paulo.rickandmorty.presenter.ui.theme.Black
import com.paulo.rickandmorty.presenter.ui.theme.GreenLight
import com.paulo.rickandmorty.presenter.ui.theme.Orange
import com.paulo.rickandmorty.presenter.ui.theme.Red
import com.paulo.rickandmorty.presenter.ui.theme.White

@Composable
fun PopUpFavorite(
    onClickClose: () -> Unit,
    onClickDelete: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black.copy(alpha = 0.9f)),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(350.dp)
                .background(Orange),
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Are you sure?",
                        style = TextStyle(
                            color = Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    IconButton(onClick = onClickClose) {
                        Icon(Icons.Default.Close, contentDescription = null, tint = Black)
                    }
                }
                CustomDivider(color = Black, iconColor = Black)
                TextAux("Are you sure you want to delete this? Remember, once it's gone, you can never bring it back. It's like deleting the last slice of pizza at a party. You may think it's the right move, but deep down, you'll always wonder if you made a terrible mistake. Proceed with caution, my friend.")

                Row {
                    Box(
                        Modifier
                            .padding(top = 10.dp, bottom = 15.dp)
                            .height(40.dp)
                            .weight(1f)
                            .background(Red, shape = CutCornerShape(10.dp)),
                        contentAlignment = Alignment.Center,
                    ) {
                        TextButton(onClick = { onClickDelete("123") }) {
                            Text(
                                text = "Yes, Delete",
                                style = TextStyle(color = White, fontWeight = FontWeight.Bold),
                            )
                        }
                    }
                    Logo(45, color = Black)
                    Box(
                        Modifier
                            .weight(1f)
                            .padding(top = 10.dp, bottom = 15.dp)
                            .height(40.dp)
                            .fillMaxWidth()
                            .background(GreenLight, shape = CutCornerShape(10.dp)),
                        contentAlignment = Alignment.Center,
                    ) {
                        TextButton(onClick = onClickClose) {
                            Text(
                                text = "No",
                                style = TextStyle(color = White, fontWeight = FontWeight.Bold),
                            )
                        }
                    }
                }
            }
        }
    }
}
