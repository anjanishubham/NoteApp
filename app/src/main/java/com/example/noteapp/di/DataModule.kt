package com.example.noteapp.di

import com.example.noteapp.data.repo.TodoRepo
import com.example.noteapp.data.repo.TodoRepoImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class RepositoryModule {

        @Singleton
        @Binds
        abstract fun bindTaskRepository(repository: TodoRepoImp): TodoRepo
    }
}