package com.mobilebreakero.Gamezone.di

import com.mobilebreakero.domain.repository.GamesRepository
import com.mobilebreakero.mapper.GamesMapper
import com.mobilebreakero.remote.GamesApi
import com.mobilebreakero.repoimpl.GamesRepoImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{

    @Provides
    @Singleton
    fun provideGamesRepository(api: GamesApi, gamesMapper: GamesMapper): GamesRepository = GamesRepoImplementation(api, gamesMapper)
}
