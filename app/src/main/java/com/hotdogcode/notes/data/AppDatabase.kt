package com.hotdogcode.notes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hotdogcode.notes.data.model.Note


@Database(entities = [Note::class],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase(){

    abstract fun getNoteDao():NoteDao


    companion object {
        private var INSTANCE : AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                return INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }
        }

        private fun buildDatabase(context: Context):AppDatabase{
            return Room.databaseBuilder(context,AppDatabase::class.java,"app_db").build()
        }
    }

}