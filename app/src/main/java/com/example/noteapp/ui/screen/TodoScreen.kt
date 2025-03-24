package com.example.noteapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.ui.viewmodel.TodoListScreenViewModel

@Composable
fun ToDoScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<TodoListScreenViewModel>()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "To-Do Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}