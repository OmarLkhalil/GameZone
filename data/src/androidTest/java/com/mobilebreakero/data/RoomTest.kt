package com.mobilebreakero.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mobilebreakero.domain.model.GamesItem
import com.mobilebreakero.local.GamesDatabase
import com.mobilebreakero.domain.dao.GamesDao
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class RoomTest {

    private lateinit var gamesDao: GamesDao
    private lateinit var gamesDatabase: GamesDatabase

    @Before
    fun createDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        gamesDatabase = Room.inMemoryDatabaseBuilder(context, GamesDatabase::class.java).build()
        gamesDao = gamesDatabase.gamesDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        gamesDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndRetrieveGames() = runTest {
        val game = GamesItem(id = 1, name = "Sample Game", description = "Sample Description", image = "Sample Image", rating = 4.5, website = "Sample Website")
        gamesDao.insertGames(game)

        val gamesList = gamesDao.getGames()
        assert(gamesList.isNotEmpty())
        assert(gamesList[0].name == "Sample Game")
        assert(gamesList[0].description == "Sample Description")
        assert(gamesList[0].image == "Sample Image")
        assert(gamesList[0].rating == 4.5)
        assert(gamesList[0].website == "Sample Website")
    }

    @Test
    @Throws(Exception::class)
    fun deleteGames() = runTest {
        val game = GamesItem(id = 1, name = "Sample Game", description = "Sample Description", image = "Sample Image", rating = 4.5, website = "Sample Website")
        gamesDao.insertGames(game)

        val gamesList = gamesDao.getGames()
        assert(gamesList.isNotEmpty())

        gamesDao.deleteGames(game)

        val updatedGamesList = gamesDao.getGames()
        assert(updatedGamesList.isEmpty())
    }
}