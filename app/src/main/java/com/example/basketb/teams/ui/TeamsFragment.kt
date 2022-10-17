package com.example.basketb.teams.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basketb.R
import com.example.basketb.Team.teamsList
import com.example.basketb.data.NetworkClient
import com.example.basketb.data.TeamService
import com.example.basketb.data.model.TeamApiModel
import com.example.basketb.teams.Team
import com.example.basketb.teams.TeamAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TeamsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teamList = view.findViewById<RecyclerView>(R.id.teams_list)

        lifecycleScope.launchWhenCreated {
            val response = NetworkClient.getInstance().create(TeamService::class.java).fetchTeams()
            val list = response.data.map { item ->
                Team(
                    id = item.id,
                    city = item.city,
                    division = item.division,
                    name = item.name,
                    conference = item.conference
                )
            }
            val teamAdapter = TeamAdapter(list)
            teamList.layoutManager = LinearLayoutManager(requireContext())
            teamList.adapter = teamAdapter
        }
    }
}