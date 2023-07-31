package com.mobilebreakero.Gamezone.ui.composables

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Straight
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.mobilebreakero.favorite.ui.FavoriteScreen
import com.mobilebreakero.home.ui.screens.DetailsScreen
import com.mobilebreakero.home.ui.screens.HomeScreen
import com.mobilebreakero.search.ui.SearchScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { GameZoneTopAppBar(navController) },
        bottomBar = { BottomNavigation(navController = navController) },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                NavigationGraph(navController = navController)
            }
        }
    )
}

@Composable
fun BottomNavigation(navController: NavController) {

    val items = listOf(
        BottomNavItem.Search,
        BottomNavItem.Home,
        BottomNavItem.Favorite,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val Barcolor = Color(0xFF778FD2)

    val routeNames = listOf(
        "Search",
        "Home",
        "Favorites",
    )

    var selectedIndex by remember {
        mutableStateOf(1)
    }

    LaunchedEffect(currentRoute) {
        selectedIndex = items.indexOfFirst { item ->
            item.route == currentRoute
        }
    }

    if (currentRoute in routeNames) {
        AnimatedNavigationBar(
            modifier = Modifier
                .height(70.dp)
                .background(Color(0xFF303A56)),
            selectedIndex = selectedIndex,
            cornerRadius = shapeCornerRadius(cornerRadius = 15.dp),
            ballAnimation = Straight(tween(600)),
            indentAnimation = Height(tween(1000)),
            barColor = Barcolor,
            ballColor = Color.White,
        ) {
            items.forEachIndexed { index, item ->
                Column(
                    modifier = Modifier.fillMaxHeight()
                ) {
                    CustomButtonForButtonNav(
                        item = item,
                        isSelected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun CustomButtonForButtonNav(item: BottomNavItem, isSelected: Boolean, onClick: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {

        if (isSelected) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Text(
            text = item.route,
            fontSize = 16.sp,
            color = if (isSelected) Color.Black else Color.Black.copy(alpha = 0.5f),
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxHeight()
        )
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {


    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeScreen(navController)
        }
        composable("Search") {
            SearchScreen()
        }
        composable("Favorites") {
            FavoriteScreen()
        }
        composable(
            "Details?name={name}&description={description}&image={image}&rating={rating}&link={link}",
            arguments = listOf(
                navArgument("name") {
                    defaultValue = "name"
                },
                navArgument("description") { defaultValue = "description" },
                navArgument("image") { defaultValue = "image" },
                navArgument("rating") {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument("link") { defaultValue = "link" },
            )
        ) { backStackEntry ->
            DetailsScreen(
                name = backStackEntry.arguments?.getString("name")!!,
                description = backStackEntry.arguments?.getString("description")!!,
                image = backStackEntry.arguments?.getString("image")!!,
                link = backStackEntry.arguments?.getString("link")!!,
                rating = backStackEntry.arguments?.getInt("rating")!!,
            )
        }
    }
}
