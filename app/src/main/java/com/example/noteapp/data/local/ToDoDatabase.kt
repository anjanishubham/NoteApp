package com.example.noteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TodoLocal::class], version = 1, exportSchema = false)

abstract class ToDoDatabase : RoomDatabase(){
    abstract fun getToDoDao(): ToDoDao
}