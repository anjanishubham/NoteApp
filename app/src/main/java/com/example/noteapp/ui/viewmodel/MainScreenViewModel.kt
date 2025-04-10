package com.example.noteapp.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.SavaTodoDatabaseUseCase
import com.example.noteapp.domain.data.Todo
import com.example.noteapp.ui.state.NoteAppToolbarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val saveTodoUseCase: SavaTodoDatabaseUseCase

) :ViewModel() {

    val toolbarState = MutableStateFlow(NoteAppToolbarState().copy(title = "Note App"))

    fun evenClick(event: String){
        // open todos bottom sheet to create new task //
        viewModelScope.launch {
            saveTodoUseCase.createTodo(getTodo())
        }
        Log.d("MainScreenViewModel", "evenClick: $event")
    }

    fun addNote(title: String, desc: String) {

    }

    companion object{
        fun getTodo() = Todo(
            id = "",
            title = "1st task",
            description = "Hello this my 1st task",
            isCompleted = false,
            dateOfCreation = System.currentTimeMillis(),
            dateOfCompletion = 0
        )
    }
}


private const val TAG = "MainScreenViewModel"