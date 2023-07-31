package com.mobilebreakero.domain.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mobilebreakero.domain.model.GamesItem
import com.mobilebreakero.domain.repository.GamesRepository

class GamesPagingSource(
    private val repository: GamesRepository,
) : PagingSource<Int, GamesItem>(){

    override fun getRefreshKey(state: PagingState<Int, GamesItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GamesItem> {
        return try {
            val page = params.key ?: 1
            val response = repository.getGames()
            if (response.gamesList.isNotEmpty()) {
                LoadResult.Page(
                    data = response.gamesList,
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (response.gamesList.isEmpty()) null else page.plus(1)
                )
            } else {
                LoadResult.Error(Exception("No data available"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}