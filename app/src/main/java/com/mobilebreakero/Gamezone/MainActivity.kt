package com.mobilebreakero.Gamezone


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mobilebreakero.Gamezone.ui.composables.MainScreenView
import com.mobilebreakero.Gamezone.ui.theme.GameZoneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameZoneTheme {
                MainScreenView()
            }
        }
    }
}
