package com.mobilebreakero.Gamezone.ui.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameZoneTopAppBar(navController: NavController) {

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF778FD2)),
        title = {
            TopBarTitle(navController = navController)
        },
        navigationIcon = {
            NavIcon(navController = navController)
        },
    )
}

@Composable
fun NavIcon(navController: NavController) {


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute != "Home") {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back",
                tint = Color.White
            )
        }
    }

}

@Composable
fun TopBarTitle(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute == "Details?name={name}&description={description}&image={image}&rating={rating}&link={link}") {
        Text(
            text = "Details",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1,
            color = Color.Black,
            fontSize = 25.sp,
            overflow = TextOverflow.Ellipsis
        )
    } else {
        Text(
            text = currentRoute.toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1,
            color = Color.Black,
            fontSize = 25.sp,
            overflow = TextOverflow.Ellipsis
        )
    }
}