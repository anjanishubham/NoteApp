package com.example.noteapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class MyTask(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val dateOfCreation:Long,
    val dateOfCompletion:Long
)