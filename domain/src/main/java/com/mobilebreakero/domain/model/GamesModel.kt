package com.mobilebreakero.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class GamesModel(
    val gamesList: List<GamesItem> = emptyList(),
    val page: Long = 0L,
    val totalPages: Int = 0,
    val totalResults: Int = 0,
    )

@Entity(tableName = "gamesitem")
data class GamesItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val rating: Any,
    val website: String,
    var isFavorite: Boolean = false
)