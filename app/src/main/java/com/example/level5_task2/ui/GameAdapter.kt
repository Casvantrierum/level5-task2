package com.example.level5_task2.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.level5_task2.R
import com.example.level5_task2.model.Game
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat

class GameAdapter(private val gamelog: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SimpleDateFormat")
        fun databind(game: Game) {
            itemView.tvTitle.text = game.title
            itemView.tvPlatform.text = game.platform
            val dateFormat = SimpleDateFormat("dd MMMM yyyy")
            itemView.tvRelease.text = dateFormat.format(game.release)
        }
    }


    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return gamelog.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(gamelog[position])
    }
}