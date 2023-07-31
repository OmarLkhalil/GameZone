package com.mobilebreakero.Gamezone.di

import com.mobilebreakero.domain.repository.GamesRepository
import com.mobilebreakero.domain.usecase.GetGames
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule{

    @Provides
    @Singleton
    fun provideGamesUseCase(repo: GamesRepository): GetGames = GetGames(repo)
}
