package com.mobilebreakero.favorite.ui


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mobilebreakero.common.components.GamesCard
import com.mobilebreakero.common.components.LoadingIndicator
import com.mobilebreakero.common.viewmodell.FavoriteViewModel
import com.mobilebreakero.domain.model.GamesItem

@Composable
fun FavoriteList(
    games: List<GamesItem?>,
    navController: NavController,
    viewModel: FavoriteViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    if (games.isEmpty()) {
        LoadingIndicator()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(games) { game ->

            GamesCard(
                image = game!!.image,
                title = game.name,
                isFavorite = game.isFavorite,
                onClick = {
                    navController.navigate("Details?name=${game.name}&description=${game.description}&image=${game.image}&rating=${game.rating}&link=${game.website}")
                }
            ) {
                game.isFavorite = !game.isFavorite
                if (game.isFavorite) {
                    game.isFavorite = true
                    viewModel.insertGames(game)
                    Toast.makeText(context, "Added to Favorite", Toast.LENGTH_SHORT).show()
                } else {
                    game.isFavorite = false
                    viewModel.deleteGames(game)
                    Toast.makeText(context, "Removed from Favorite", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}