package com.mobilebreakero.domain.utils

import androidx.paging.Pager
import com.mobilebreakero.domain.model.GamesItem


data class GameState(
    val isLoading: Boolean = false,
    val games:  Pager<Int, GamesItem>? = null,
    val error: String = ""
)