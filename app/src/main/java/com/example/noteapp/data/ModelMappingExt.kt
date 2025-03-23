package com.example.noteapp.data

import com.example.noteapp.data.local.TodoLocal
import com.example.noteapp.domain.data.Todo


fun Todo.toLocal() = TodoLocal(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted,
    dateOfCreation = dateOfCreation,
    dateOfCompletion = dateOfCompletion
)
