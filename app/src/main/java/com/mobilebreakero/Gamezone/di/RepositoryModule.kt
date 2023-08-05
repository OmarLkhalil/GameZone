package com.mobilebreakero.Gamezone.di

import android.content.Context
import com.mobilebreakero.domain.repository.FavGamesRepo
import com.mobilebreakero.domain.dao.GamesDao
import com.mobilebreakero.domain.repository.GamesRepository
import com.mobilebreakero.local.GamesDatabase
import com.mobilebreakero.mapper.GamesMapper
import com.mobilebreakero.remote.GamesApi
import com.mobilebreakero.repoimpl.FavGamesRepoImpl
import com.mobilebreakero.repoimpl.GamesRepoImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{

    @Provides
    @Singleton
    fun provideGamesRepository(api: GamesApi, gamesMapper: GamesMapper): GamesRepository = GamesRepoImplementation(api, gamesMapper)

    @Provides
    @Singleton
    fun provideFavoritesRepository(dao : GamesDao) : FavGamesRepo = FavGamesRepoImpl(dao)

    @Provides
    @Singleton
    fun provideGamesDao(db: GamesDatabase): GamesDao = db.gamesDao()


    @Provides
    @Singleton
    fun provideGamesDatabase(context: Context): GamesDatabase = GamesDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideContext (@ApplicationContext context: Context): Context = context

}