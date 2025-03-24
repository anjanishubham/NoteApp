package com.example.noteapp.domain.usecase

import com.example.noteapp.data.repo.TodoRepo
import javax.inject.Inject


class ObserveAllTodoUsecase @Inject constructor(
    private val repository: TodoRepo
) {
    suspend operator fun invoke() = repository.observeTodos()
}