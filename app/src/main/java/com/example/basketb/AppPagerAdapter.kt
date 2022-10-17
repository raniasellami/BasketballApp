package com.example.basketb

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.basketb.games.GamesFragment
import com.example.basketb.teams.ui.TeamsFragment

class AppPagerAdapter(val activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TeamsFragment()
            1 -> GamesFragment()
            else -> TeamsFragment()
        }
    }
}