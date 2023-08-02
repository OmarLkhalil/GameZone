package com.mobilebreakero.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobilebreakero.common.components.LoadingIndicator
import com.mobilebreakero.domain.model.GamesItem

@Composable
fun SearchList(games: List<GamesItem?>, navController : NavController) {

    if(games.isEmpty()){
        LoadingIndicator()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(games) { game ->
            SearchItem(
                image = game!!.image,
                title = game.name
            ){
                navController.navigate("Details?name=${game.name}&description=${game.description}&image=${game.image}&rating=${game.rating}&link=${game.website}")
            }
        }
    }
}