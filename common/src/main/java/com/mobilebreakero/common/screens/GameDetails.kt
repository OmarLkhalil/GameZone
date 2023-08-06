package com.mobilebreakero.common.screens

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobilebreakero.common.components.CoilImage


@Composable
fun DetailsScreen(
    name: String,
    description: String,
    image: String,
    rating: Int,
    link: String
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CoilImage(
            data = image,
            contentDescription = name,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop,
            gameTitle = name,
            onClick = {}
        )

        Card(
            modifier = Modifier
                .fillMaxWidth().height(400.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                ).align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(containerColor = (Color(0xFF778FD2)))
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                color = Color.White,
                modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = description,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = Color.White,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Rating: $rating",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = Color.White,
                    modifier = Modifier.padding(10.dp)
                )
                val uriHandler = LocalUriHandler.current

                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    val uri = Uri.parse("http://$link")
                    uriHandler.openUri(uri.toString())
                }) {
                    Text(text = "Play Now")
                }
            }
        }
    }
}