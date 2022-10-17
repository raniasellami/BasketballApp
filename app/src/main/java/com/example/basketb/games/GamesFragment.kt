package com.example.basketb.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basketb.R
import com.example.basketb.data.GameService
import com.example.basketb.data.NetworkClient
import com.example.basketb.data.TeamService
import com.example.basketb.teams.Team
import com.example.basketb.teams.TeamAdapter


class GamesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gamesList = view.findViewById<RecyclerView>(R.id.games)

        lifecycleScope.launchWhenCreated {
            val result = NetworkClient.getInstance().create(GameService::class.java).fetchGames()
            val list = result.data.map { gameDetails ->
                Game(
                    id = gameDetails.id,
                    homeTeamAbbreviation = gameDetails.homeTeam.abbreviation,
                    homeTeamName = gameDetails.homeTeam.name,
                    visitorTeamAbbreviation = gameDetails.visitorTeam.abbreviation,
                    visitorTeamName = gameDetails.visitorTeam.name,
                    gameDate = gameDetails.date,
                    result = "${gameDetails.homeTeamScore} : ${gameDetails.visitorTeamScore}",
                    gameTime = gameDetails.status
                )
            }
            gamesList.layoutManager = LinearLayoutManager(requireContext())
            gamesList.adapter = GameAdapter(list)
        }
    }
}