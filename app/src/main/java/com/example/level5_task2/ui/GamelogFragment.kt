package com.example.level5_task2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.level5_task2.R
import com.example.level5_task2.model.Game
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_gamelog.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GamelogFragment : Fragment() {

    private lateinit var gameAdapter: GameAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val viewModel: GameViewModel by viewModels()

    //populate some test data in Reminders list
    private var gamelog: ArrayList<Game> = arrayListOf()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gamelog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        observeAddGameResult()

    }

    private fun initRv() {

        gameAdapter = GameAdapter(gamelog)
        viewManager = LinearLayoutManager(activity)

        rvGamelog.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = gameAdapter
        }
        //createItemTouchHelper().attachToRecyclerView(rvGamelog)
    }

    public fun addGame() {
        Log.i("ja", "jeej")
    }

    private fun observeAddGameResult() {
        viewModel.gamelog.observe(viewLifecycleOwner, Observer { gamelog ->
            this@GamelogFragment.gamelog.clear()
            this@GamelogFragment.gamelog.addAll(gamelog)
            gameAdapter.notifyDataSetChanged()
        })
    }
}