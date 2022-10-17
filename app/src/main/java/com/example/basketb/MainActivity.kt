package com.example.basketb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketb.databinding.ActivityMainBinding
import com.example.basketb.games.GamesFragment
import com.example.basketb.teams.ui.TeamsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = AppPagerAdapter(this)
        binding.pager.adapter = adapter

        TabLayoutMediator(binding.tab, binding.pager){tab, position ->
            tab.text = when(position) {
                1 -> "Teams"
                2 -> "Games"
                else -> "Teams"
            }
        }.attach()
    }
}
