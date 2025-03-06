package com.example.noteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [MyTask::class], version = 1, exportSchema = false)

abstract class ToDoDatabase : RoomDatabase(){
    abstract fun getToDoDao(): ToDoDao
}