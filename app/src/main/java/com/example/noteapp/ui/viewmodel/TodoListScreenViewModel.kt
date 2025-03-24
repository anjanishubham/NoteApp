package com.example.noteapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.di.IoDispatcher
import com.example.noteapp.domain.usecase.ObserveAllTodoUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TodoListScreenViewModel @Inject constructor(
    private val observeAllTodoUsecase: ObserveAllTodoUsecase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : ViewModel() {
    init {
        observeTodoList()
    }

   private fun observeTodoList() {
        viewModelScope.launch(dispatcher) {
            observeAllTodoUsecase.invoke().collect {
                Log.d("TodoListScreenViewModel", "observeTodoList: $it")
            }
        }
   }

}