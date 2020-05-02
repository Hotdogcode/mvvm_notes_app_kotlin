package com.hotdogcode.notes.utilities

import android.content.Context
import com.hotdogcode.notes.data.AppDatabase
import com.hotdogcode.notes.data.NoteRepo

object Injector {
    fun provideViewModelFactory(context: Context):ViewModelFactory{
        val noteRepo = NoteRepo.getInstance(AppDatabase.getInstance(context).getNoteDao())
        return ViewModelFactory(noteRepo)
    }

}