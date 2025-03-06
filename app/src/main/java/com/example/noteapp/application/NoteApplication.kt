package com.example.noteapp.application

import android.app.Application
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class NoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    companion object {
        private const val TAG = "NoteApplication"
    }
}