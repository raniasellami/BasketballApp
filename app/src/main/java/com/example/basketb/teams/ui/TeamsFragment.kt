package com.example.basketb.teams.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basketb.R
import com.example.basketb.Team.teamsList
import com.example.basketb.teams.TeamAdapter


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

        val teamAdapter = TeamAdapter(teamsList)

        teamList.layoutManager = LinearLayoutManager(requireContext())
        teamList.adapter = teamAdapter
    }


}