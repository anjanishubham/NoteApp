package com.example.noteapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.ui.navgation.BottomNavigationBar
import com.example.noteapp.ui.state.BottomNavItem

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.ToDo.route, // Set initial screen
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.ToDo.route) {
                ToDoScreen() // Replace with your composable
            }
            composable(BottomNavItem.CompletedToDo.route) {
               TOdoCompletedScreen()
            }
            composable(BottomNavItem.Settings.route) {
                SettingScreen()
            }
        }
    }
}