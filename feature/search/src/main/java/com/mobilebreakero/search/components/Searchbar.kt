package com.mobilebreakero.search.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.mobilebreakero.common.components.LoadingIndicator
import com.mobilebreakero.common.viewmodell.MainViewModel
import kotlinx.coroutines.delay


@Composable
fun SearchBar(viewModel: MainViewModel = hiltViewModel(), navController: NavController) {

    var text by remember { mutableStateOf("") }
    val games = viewModel.games.value.games!!.flow.collectAsLazyPagingItems()

    val filteredGames = games.itemSnapshotList.filter { game ->
        text.isBlank() || game?.name?.contains(text, ignoreCase = true) == true
    }

    val isLoading = remember { mutableStateOf(false) }

    LaunchedEffect(text) {
        isLoading.value = true
        delay(500)
        isLoading.value = false
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.DarkGray,
                textColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(20.dp)),
            label = { Text("Search") },
            leadingIcon = { Text("🔍", fontSize = 20.sp) }
        )

        if (text.isBlank()) {
            Text(
                text = "Search for a game",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 100.dp, start = 50.dp, end = 50.dp)
            )
        } else if (isLoading.value) {
            LoadingIndicator()
        } else {
            Spacer(modifier = Modifier.height(20.dp))
            SearchList(games = filteredGames, navController = navController)
        }
    }
}