package com.example.noteapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.ui.commonUI.NoteAppToolbar
import com.example.noteapp.ui.navgation.BottomNavigationBar
import com.example.noteapp.ui.state.BottomNavItem
import com.example.noteapp.ui.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val state = viewModel.toolbarState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        },
        topBar = {
            NoteAppToolbar(noteAppToolbarState = state){ event ->
                viewModel.evenClick(event)
            }
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