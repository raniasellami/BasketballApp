package com.example.basketb.data.model.game


import com.google.gson.annotations.SerializedName

data class GameApiModel(
    @SerializedName("data")
    val data: List<GameDetailApiModel>
)