package com.developersbreach.darkthemeandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mNavigationController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        mNavigationController = Navigation.findNavController(this, R.id.myNavHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, mNavigationController)

        mNavigationController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.detailFragment) {
                bottomNavigationView.visibility = View.INVISIBLE
            } else {
                bottomNavigationView.visibility = View.VISIBLE
            }
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.listFragment,
                R.id.searchFragment,
                R.id.settingsFragment -> {
                    NavigationUI.onNavDestinationSelected(item, mNavigationController)
                }
                else -> TODO("Not yet implemented")
            }
        }

    }
}
