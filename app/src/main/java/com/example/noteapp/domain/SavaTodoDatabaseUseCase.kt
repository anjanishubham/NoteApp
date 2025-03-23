package com.example.noteapp.domain

import com.example.noteapp.data.local.TodoLocal
import com.example.noteapp.data.repo.TodoRepo
import com.example.noteapp.domain.data.Todo
import javax.inject.Inject

class SavaTodoDatabaseUseCase @Inject constructor(
    private val repository: TodoRepo
) {
   suspend fun createTodo(todo: Todo) {
        repository.createTodo(todo)
    }
}