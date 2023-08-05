package com.mobilebreakero.Gamezone.ui.components

sealed class BottomNavItem(var route: String){
    object Home : BottomNavItem("Home")
    object Search : BottomNavItem("Search")
    object Favorite : BottomNavItem("Favorites")
}