package com.mobilebreakero.remote

import com.mobilebreakero.Constants
import com.mobilebreakero.dto.Games
import retrofit2.http.GET

interface GamesApi {

    @GET("games/?api_key=${Constants.apiKey}&format=${Constants.json}")
    suspend fun getGames(): Games

}