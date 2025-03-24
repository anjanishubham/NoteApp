package com.example.noteapp.data.repo

import com.example.noteapp.data.local.TodoLocal
import com.example.noteapp.data.local.ToDoDao
import com.example.noteapp.data.toLocal
import com.example.noteapp.di.DefaultDispatcher
import com.example.noteapp.domain.data.Todo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject

class TodoRepoImp @Inject constructor(
    private val localDataSource: ToDoDao,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,

    ) : TodoRepo {
    override suspend fun createTodo(task: Todo) {
        val taskId = withContext(dispatcher) {
            UUID.randomUUID().toString()
        }
        val todo = task.copy(id = taskId)
        val localTask = todo.toLocal()
        localDataSource.upsert(localTask)
    }

    override suspend fun updateTodo(task: TodoLocal) {

    }

    override suspend fun refresh() {

    }

    override suspend fun observeTodos(): Flow<List<TodoLocal>> {
        return localDataSource.observeAll()
    }

    override suspend fun deleteTodo(id: String) {

    }
}