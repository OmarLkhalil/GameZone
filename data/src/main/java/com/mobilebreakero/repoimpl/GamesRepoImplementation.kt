package com.mobilebreakero.repoimpl

import com.mobilebreakero.domain.model.GamesModel
import com.mobilebreakero.domain.repository.GamesRepository
import com.mobilebreakero.mapper.GamesMapper
import com.mobilebreakero.remote.GamesApi
import javax.inject.Inject

class GamesRepoImplementation @Inject constructor(
    private val gamesApi: GamesApi,
    private val gamesMapper: GamesMapper
) : GamesRepository {

    override suspend fun getGames(): GamesModel {
        return gamesMapper.fromRemoteGamesToGamesModel(gamesApi.getGames())
    }

}