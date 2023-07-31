package com.mobilebreakero.Gamezone.ui.composables

import com.mobilebreakero.common.R

sealed class BottomNavItem (var route : String, var icon : Int){
    object Home : BottomNavItem("Home", R.drawable.home)
    object Search : BottomNavItem("Search", R.drawable.search)
    object Favorite : BottomNavItem("Favorites", R.drawable.favorite)
}