package com.mobilebreakero.home.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mobilebreakero.home.ui.components.MiddlePager
import com.mobilebreakero.home.ui.components.TopPager

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2A3759))
            .verticalScroll(rememberScrollState())
    ) {
        TopPager()
        MiddlePager(navController = navController)
    }

}
