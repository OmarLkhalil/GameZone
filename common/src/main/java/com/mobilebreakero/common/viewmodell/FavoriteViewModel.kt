package com.mobilebreakero.common.viewmodell

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilebreakero.domain.model.GamesItem
import com.mobilebreakero.domain.repository.FavGamesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val gamesRepository: FavGamesRepo) : ViewModel() {

    private val _games = MutableStateFlow<List<GamesItem>>(emptyList())
    val games: Flow<List<GamesItem>> get() = _games

    init {
        getGames()
    }

    fun insertGames(games: GamesItem) {
        viewModelScope.launch {
            gamesRepository.insertGames(games)
        }
    }

    fun deleteGames(games: GamesItem) {
        viewModelScope.launch {
            gamesRepository.deleteGames(games)
        }
    }

    fun getGames() {
        viewModelScope.launch {
            val games = gamesRepository.getGames()
            _games.value = games
        }
    }
}
