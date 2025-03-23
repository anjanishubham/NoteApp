package com.example.noteapp.domain.data

data class Todo(
    val id:String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val dateOfCreation:Long,
    val dateOfCompletion:Long
)
