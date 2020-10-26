package com.example.level5_task2.ui

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
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as MainActivity?)?.supportActionBar?.title = getString(R.string.add)
        (activity as MainActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
        val gameDay = etDay.text.toString()
        val gameMonth = etMonth.text.toString()
        val gameYear = etYear.text.toString()

        checkInput(gameTitle, gamePlatform, gameDay, gameMonth, gameYear)
        if (checkInput(gameTitle, gamePlatform, gameDay, gameMonth, gameYear)) {
            viewModel.insertGame(Game(gameTitle, Date(gameYear.toInt() - 1900, gameMonth.toInt()-1, gameDay.toInt()), gamePlatform))

            //"pop" the backstack, this means we destroy
            //this fragment and go back to the GamesFragment
            findNavController().popBackStack()
        }
    }

    private fun checkInput(title: String, platform: String, day: String, month: String, year: String ): Boolean {
        var wrongElements = ""
        if (title.isBlank()) wrongElements = wrongElements + getString(R.string.title) + " "
        if (platform.isBlank()) wrongElements = wrongElements + getString(R.string.platform) + " "
        if (day.isBlank() || day.toInt() < 1 || day.toInt() > 31 ) wrongElements = wrongElements + getString(R.string.day) + " "
        if (month.isBlank() || month.toInt() < 1 || month.toInt() > 12 ) wrongElements = wrongElements + getString(R.string.month) + " "
        if (year.isBlank() || year.toInt() < 1900 ) wrongElements = wrongElements + getString(R.string.year) + " "

        if (wrongElements.isNotBlank()) {
            Toast.makeText(
                activity,
                getString(R.string.not_valid_game, wrongElements), Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }
}