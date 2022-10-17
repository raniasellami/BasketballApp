package com.example.basketb.teams
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basketb.R

class  TeamAdapter(
    private val teams: List<Team>
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.name)
        private val city = itemView.findViewById<TextView>(R.id.city)
        private val division = itemView.findViewById<TextView>(R.id.division)
        private val conference = itemView.findViewById<TextView>(R.id.conference)
        fun bind(team: Team) {
            name.text = team.name
            city.text = team.city
            division.text = team.division
            conference.text = team.conference

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.team_item_view, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.bind(team)
    }

    override fun getItemCount() = teams.size
}