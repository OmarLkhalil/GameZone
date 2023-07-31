package com.mobilebreakero.domain.model

data class GamesModel(
    val gamesList: List<GamesItem> = emptyList(),
    val page: Long = 0L,
    val totalPages: Int = 0,
    val totalResults: Int = 0,

    )

data class GamesItem(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val rating: Any,
    val website: String
)