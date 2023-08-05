package com.mobilebreakero.domain.repository

import com.mobilebreakero.domain.model.GamesItem

interface FavGamesRepo {

    suspend fun insertGames(games: GamesItem)
    suspend fun deleteGames(games: GamesItem)
    suspend fun getGames(): List<GamesItem>
}