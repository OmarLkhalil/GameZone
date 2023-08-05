package com.mobilebreakero.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobilebreakero.domain.model.GamesItem
import com.mobilebreakero.domain.dao.GamesDao

@Database(entities = [GamesItem::class], version = 4, exportSchema = false)
@TypeConverters(AnyTypeConverter::class)
abstract class GamesDatabase : RoomDatabase() {

    abstract fun gamesDao(): GamesDao

    companion object {

        fun getDao(context: Context): GamesDao {
            return getInstance(context).gamesDao()
        }

        fun getInstance(context: Context): GamesDatabase {
            return Room.databaseBuilder(
                context,
                GamesDatabase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration().build()

        }

        const val DATABASE_NAME: String = "games_db"

    }

}