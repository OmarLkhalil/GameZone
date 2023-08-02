package com.mobilebreakero.common.viewmodell

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilebreakero.domain.usecase.GetGames
import com.mobilebreakero.domain.utils.GameState
import com.mobilebreakero.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getGamesUseCase: GetGames) : ViewModel() {

    private val _state = mutableStateOf(GameState())

    val games: State<GameState>
        get() = _state

    init {
        fetchGames()
    }

   private fun fetchGames() {
        getGamesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {

                    _state.value = GameState(
                        games = result.data
                    )
                    Log.e("Games", result.data.toString())

                }
                is Resource.Error -> {
                    _state.value = GameState(
                        error = result.message ?: "An unexpected error happened"
                    )
                    Log.e("Games", result.data.toString())

                }
                is Resource.Loading -> {
                    _state.value = GameState(isLoading = true)
                    Log.e("Games", "Loading..")
                }
            }
        }.launchIn(viewModelScope)
    }

}
