package com.example.level5_task2.ui

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.level5_task2.R
import kotlinx.android.synthetic.main.activity_main.*


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
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(R.id.AddGameFragment)) {
                fab.hide()
//                fab.setImageResource(android.R.drawable.ic_menu_save);
//                fab.setOnClickListener {
//                    navController.navigate(
//                        R.id.action_AddGameFragment_to_GamelogFragment
//                    )
//                }
            } else {
                fab.show()
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
        if (item.getItemId() == android.R.id.home) {
            findNavController(R.id.nav_host_fragment).popBackStack()
            return true;
        };
        return super.onOptionsItemSelected(item);
    }
}