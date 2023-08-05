package com.mobilebreakero.repoimpl

import com.mobilebreakero.domain.model.GamesItem
import com.mobilebreakero.domain.repository.FavGamesRepo
import com.mobilebreakero.domain.dao.GamesDao
import javax.inject.Inject


class FavGamesRepoImpl @Inject constructor(private val dao: GamesDao) : FavGamesRepo{

    override suspend fun insertGames(games: GamesItem) {
        dao.insertGames(games)
    }

    override suspend fun deleteGames(games: GamesItem) {
        dao.deleteGames(games)
    }

    override suspend fun getGames(): List<GamesItem> {
        return dao.getGames()
    }
}