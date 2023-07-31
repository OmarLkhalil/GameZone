package com.mobilebreakero.mapper

import com.mobilebreakero.domain.model.GamesItem
import com.mobilebreakero.domain.model.GamesModel
import com.mobilebreakero.dto.Games
import com.mobilebreakero.dto.GamesItemDto
import javax.inject.Inject

class GamesMapper @Inject constructor() {

    fun fromRemoteGamesToGamesModel(obj: Games): GamesModel {
        return GamesModel(
            gamesList = mapToGame(obj.results),
            page = obj.page,
            totalPages = obj.numberOfPageResults,
            totalResults = obj.numberOfTotalResults
        )
    }

    private fun mapToGame(obj: List<GamesItemDto>): List<GamesItem> {

        return obj.map {
            GamesItem(
                id = it.id ?: 0,
                name = it.name ?: "",
                description = it.description ?: "",
                image = it.image?.originalUrl ?: "",
                rating = it.originalGameRating ?: 0,
                website = it.siteDetailUrl ?: ""
            )
        }
    }
}