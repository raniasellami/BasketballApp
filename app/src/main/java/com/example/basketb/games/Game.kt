package com.example.basketb.games

data class Game(
    val id: Int,
    val gameDate: String,
    val result: String,
    val gameTime: String,
    val homeTeamName: String,
    val homeTeamAbbreviation: String,
    val visitorTeamName: String,
    val visitorTeamAbbreviation: String
)