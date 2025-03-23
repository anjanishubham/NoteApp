package com.example.noteapp.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.noteapp.ui.state.NoteAppToolbarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() :ViewModel() {

    val toolbarState = MutableStateFlow(NoteAppToolbarState().copy(title = "Note App"))

    fun evenClick(event: String){
        // open todos bottom sheet to create new task //
        Log.d("MainScreenViewModel", "evenClick: $event")
    }
}

private const val TAG = "MainScreenViewModel"