package com.example.basketb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketb.databinding.ActivityMainBinding
import com.example.basketb.games.GamesFragment
import com.example.basketb.teams.ui.TeamsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Games.setOnClickListener { supportFragmentManager.commit {add (R.id.container ,GamesFragment()) } }
        binding.Teams.setOnClickListener { supportFragmentManager.commit {add (R.id.container ,TeamsFragment()) }
            Val teamAdapter = TeamAdapter(teamslist)
            binding.teamslist.apply {
               layoutManager = LinearLayoutManager
            }

        }
    }
}
