package com.example.level5_task2.ui

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.level5_task2.R
import com.example.level5_task2.model.Game
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.fragment_add_game.*
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("SETUP", "SETUP IN ON CREATE")
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        (activity as MainActivity?)?.supportActionBar?.title = "Add";//TODO hc string
        (activity as MainActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //(activity as MainActivity?)?.supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener {
            onAddGame()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_add_game, menu)
    }

    private fun onAddGame() {
        val gameTitle    = etTitle.text.toString()
        val gamePlatform = etPlatform.text.toString()

        if (gameTitle.isNotBlank()) {
            viewModel.insertGame(Game(gameTitle, Date(2010 - 1900, 7 + 1, 9), gamePlatform))

            //"pop" the backstack, this means we destroy
            //this fragment and go back to the GamesFragment
            findNavController().popBackStack()

        } else {
            Toast.makeText(
                activity,
                R.string.not_valid_game, Toast.LENGTH_SHORT
            ).show()
        }
    }
}