package com.hotdogcode.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hotdogcode.notes.data.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM tbl_notes")
    suspend fun getNotes():List<Note>

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM tbl_notes")
    suspend fun deleteNotes()
}