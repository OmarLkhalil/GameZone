package com.mobilebreakero.domain.repository

import com.mobilebreakero.domain.model.GamesModel

interface GamesRepository {
    suspend fun getGames(): GamesModel
}