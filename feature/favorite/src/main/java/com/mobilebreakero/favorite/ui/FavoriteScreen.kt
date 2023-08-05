package com.mobilebreakero.favorite.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mobilebreakero.common.viewmodell.FavoriteViewModel

@Composable
fun FavoriteScreen(navController: NavController, viewModel: FavoriteViewModel = hiltViewModel()) {

    val games by viewModel.games.collectAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF303A56))
    ) {
        FavoriteList(games = games, navController = navController)
    }
}
