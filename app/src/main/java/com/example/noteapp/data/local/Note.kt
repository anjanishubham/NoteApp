package com.example.noteapp.data.local

import java.time.LocalDateTime

data class Note(
    val title: String,
    val description: String,
    val createdTime: LocalDateTime,
    var completedTime: LocalDateTime? = null
)