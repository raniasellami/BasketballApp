package com.example.basketb.data

import com.example.basketb.data.model.TeamApiModel
import retrofit2.http.GET

interface TeamService {

    @GET("v2/5de8d40d31000074006b1487")
    suspend fun fetchTeams(): TeamApiModel

}