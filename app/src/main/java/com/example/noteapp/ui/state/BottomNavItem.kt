package com.example.noteapp.ui.state

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {
    data object ToDo : BottomNavItem("todo", "Home", Icons.Default.Home)
    data object CompletedToDo : BottomNavItem("completed_todo", "Completed", Icons.Default.Person)
    data object Settings : BottomNavItem("settings", "Settings", Icons.Default.Settings)
}