package com.thoughtworks.miniweibo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController =
            Navigation.findNavController(this, R.id.container)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =
            Navigation.findNavController(this, R.id.container)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
