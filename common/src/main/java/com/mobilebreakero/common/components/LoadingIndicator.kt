package com.mobilebreakero.common.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoadingIndicator() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight().fillMaxWidth()
    ) {
        CircularProgressIndicator(
            color = Color.White,
            modifier = Modifier.size(size = 46.dp),
        )
        Spacer(modifier = Modifier.width(width = 8.dp))
        Text(text = "Loading...", color = Color.White, fontSize = 30.sp)
    }
}