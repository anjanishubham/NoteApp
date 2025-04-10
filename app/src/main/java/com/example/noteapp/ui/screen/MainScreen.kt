package com.example.noteapp.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.ui.commonUI.NoteAppToolbar
import com.example.noteapp.ui.navgation.BottomNavigationBar
import com.example.noteapp.ui.state.BottomNavItem
import com.example.noteapp.ui.viewmodel.MainScreenViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val state = viewModel.toolbarState.collectAsState()
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        },
        topBar = {
            NoteAppToolbar(noteAppToolbarState = state) { event ->
                viewModel.evenClick(event)
                showBottomSheet = true
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

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                // Your Bottom Sheet Content Goes Here
                BottomSheetContent(onSave = { title, desc ->
                    viewModel.addNote(title, desc)
                    scope.launch { sheetState.hide() }
                    showBottomSheet = false
                })
            }
        }
    }
}