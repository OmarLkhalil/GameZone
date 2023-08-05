package com.mobilebreakero.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mobilebreakero.common.R

@Composable
fun GamesCard(
    image: String,
    title: String,
    isFavorite: Boolean = false,
    onClick: () -> Unit,
    onFavClick: () -> Unit
) {

    var isSelected by remember { mutableStateOf(isFavorite) }

    Row(
        modifier = Modifier
            .width(380.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(bottom = 10.dp),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                CoilImage(
                    data = image,
                    contentDescription = title,
                    modifier = Modifier
                        .height(200.dp)
                        .width(400.dp),
                    contentScale = ContentScale.FillBounds,
                    gameTitle = title,
                    onClick = { onClick() }
                )

                val favIcon =
                    if (isSelected) R.drawable.filledfavorite else R.drawable.favorite

                Image(
                    painter = painterResource(id = favIcon),
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .padding(10.dp)
                        .align(TopEnd)
                        .clip(RoundedCornerShape(50))
                        .height(40.dp)
                        .width(40.dp)
                        .padding(5.dp)
                        .clickable {
                            isSelected = !isSelected
                            onFavClick()
                        }
                )
            }
        }
    }
}