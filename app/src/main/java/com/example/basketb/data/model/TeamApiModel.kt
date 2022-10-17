package com.example.basketb.data.model


import com.google.gson.annotations.SerializedName

data class TeamApiModel(
    @SerializedName("data")
    val data: List<TeamDetailsApiModel>,
    @SerializedName("meta")
    val meta: Meta
)