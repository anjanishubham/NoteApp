package com.example.noteapp.data.repo

import com.example.noteapp.data.local.TodoLocal
import com.example.noteapp.domain.data.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepo {
    suspend fun createTodo(task: Todo)
    suspend fun updateTodo(task: TodoLocal)
    suspend fun refresh()
    suspend fun observeTodos(): Flow<List<TodoLocal>>
    suspend fun deleteTodo(id: String)
}