package com.example.basketb.data

import com.example.basketb.data.model.game.GameApiModel
import retrofit2.http.GET

interface GameService {

    @GET("v2/5de8d38a3100000f006b1479")
    suspend fun fetchGames(): GameApiModel
}