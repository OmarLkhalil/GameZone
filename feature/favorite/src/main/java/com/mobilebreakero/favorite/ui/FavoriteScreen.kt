package com.mobilebreakero.favorite.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun FavoriteScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF303A56))
    ){
    Hello()
    }
}

@Composable
fun Hello(){
    Text(text = "Hello", modifier = Modifier.fillMaxSize(), fontSize = 20.sp)
}