package com.mobilebreakero.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.mobilebreakero.common.components.CoilImage

@Composable
fun SearchItem(image: String, title: String, onClick: () -> Unit) {


    Row(
        modifier = Modifier
            .width(380.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(bottom = 10.dp),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {

        Row(
            modifier = Modifier.fillMaxSize()
        )
        {
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
        }
    }
}