package com.mobilebreakero.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobilebreakero.domain.model.GamesItem

@Dao
interface GamesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGames(games: GamesItem)

    @Delete
    suspend fun deleteGames(games: GamesItem)

    @Query("SELECT * FROM gamesitem")
    suspend fun getGames(): List<GamesItem>

}