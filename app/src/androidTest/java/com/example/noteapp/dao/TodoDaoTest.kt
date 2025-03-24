package com.example.noteapp.dao

import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.noteapp.data.local.ToDoDatabase
import com.example.noteapp.data.local.TodoLocal
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class TodoDaoTest {

    // using an in-memory database
    private lateinit var database: ToDoDatabase

    // Ensure that we use a new database for each test.
    @Before
    fun initDb() {
        database = Room.inMemoryDatabaseBuilder(
            getApplicationContext(),
            ToDoDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun tearDown(){
        database.close()
        Log.d(TAG, "database closed")
    }

    @Test
    fun insertTaskAndGetById() = runTest {
        // GIVEN - insert a task
        val task = TodoLocal(
            title = "title",
            description = "description",
            id = "id",
            dateOfCreation = System.currentTimeMillis(),
            dateOfCompletion = System.currentTimeMillis(),
            isCompleted = false,
        )
        database.getToDoDao().upsert(task)

        // WHEN - Get the task by id from the database
        val loaded = database.getToDoDao().getById(task.id)

        // THEN - The loaded data contains the expected values
        assertNotNull(loaded as TodoLocal)
        assertEquals(task.id, loaded.id)
        assertEquals(task.title, loaded.title)
        assertEquals(task.description, loaded.description)
        assertEquals(task.isCompleted, loaded.isCompleted)
        assertEquals(task.dateOfCompletion, loaded.dateOfCompletion)
        assertEquals(task.dateOfCreation, loaded.dateOfCreation)
    }
    companion object{
        private const val TAG = "TodoDaoTest"
    }
}