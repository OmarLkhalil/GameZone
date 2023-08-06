package com.mobilebreakero.home.ui.components

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import com.mobilebreakero.common.components.CoilImage
import com.mobilebreakero.common.components.LoadingIndicator
import com.mobilebreakero.home.R
import com.mobilebreakero.common.viewmodell.MainViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopPager() {

    val games = mutableListOf(
        R.drawable.apex,
        R.drawable.assasins,
        R.drawable.mk,
        R.drawable.skywater
    )
    val names = mutableListOf(
        "Apex Legends",
        "Assasins Creed",
        "Mortal Kombat",
        "Skywater"
    )

    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            pageCount = games.size
        ) { page ->
            val game = games[page]
            val name = names[page]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                SubcomposeAsyncImage(
                    model = game,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    loading = { LoadingIndicator() })
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                )
                Text(text = name, color = Color.White, fontSize = 26.sp, modifier = Modifier
                    .align(Alignment.BottomStart).padding(start = 16.dp, bottom = 25.dp))
            }
        }
        Row(
            Modifier
                .height(24.dp)
                .padding(start = 4.dp)
                .width(100.dp)
                .align(Alignment.BottomStart),
            horizontalArrangement = Arrangement.Start
        ) {
            repeat(games.size) { iteration ->
                val lineWeight = animateFloatAsState(
                    targetValue = if (pagerState.currentPage == iteration) {
                        1.0f
                    } else {
                        if (iteration < pagerState.currentPage) {
                            0.5f
                        } else {
                            0.5f
                        }
                    }, label = "size", animationSpec = tween(300, easing = EaseInOut)
                )
                val color =
                    if (pagerState.currentPage == iteration) Color.White else Color.White.copy(alpha = 0.5f)
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color)
                        .weight(lineWeight.value)
                        .height(10.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MiddlePager(viewModel: MainViewModel = hiltViewModel(), navController: NavController) {

    val games = viewModel.games.value.games!!.flow.collectAsLazyPagingItems()
    val pagerState = rememberPagerState(
        initialPage = 5,
    )

    if(games.itemCount == 0) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(362.dp)
        ) {
            LoadingIndicator()
        }
    }

    HorizontalPager(
        contentPadding = PaddingValues(horizontal = 60.dp),
        pageSpacing = (-15).dp,
        state = pagerState,
        modifier = Modifier
            .padding(top = 20.dp),
        pageCount = games.itemCount
    ) { page ->
        val scale = animateFloatAsState(
            targetValue = if (page == pagerState.currentPage) 1.0f else 0.8f,
            label = ""
        ).value


        val game = games[page]
        val name = game?.name
        val description = game?.description
        val image = game?.image
        val rating = game?.rating
        val link = game?.website

        CoilImage(
            data = game?.image,
            contentDescription = game!!.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(362.dp)
                .scale(scale)
                .clip(RoundedCornerShape(30.dp)),
            contentScale = ContentScale.FillBounds,
            gameTitle = game.name,
            onClick = {
                navController.navigate("Details?name=$name&description=$description&image=$image&rating=$rating&link=$link")
            }
        )
    }
}