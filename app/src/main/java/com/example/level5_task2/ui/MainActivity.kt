package com.example.level5_task2.ui

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.level5_task2.R
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        navController = findNavController(R.id.nav_host_fragment)

        fab.setOnClickListener {
            navController.navigate(
                    R.id.action_GamelogFragment_to_AddGameFragment
            )
        }

        fabToggler()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun fabToggler() {
        navController.addOnDestinationChangedListener { _,       destination, _ ->
            if (destination.id in arrayOf(R.id.AddGameFragment)) {
                fab.setImageResource(android.R.drawable.ic_menu_save);
                fab.setOnClickListener {
                    navController.navigate(
                        R.id.action_AddGameFragment_to_GamelogFragment
                    )
                }
            } else {
                fab.setImageResource(android.R.drawable.ic_input_add);
                fab.setOnClickListener {
                    navController.navigate(
                        R.id.action_GamelogFragment_to_AddGameFragment
                    )
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}