package com.hotdogcode.notes.data

import androidx.room.*
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

    @Update
    suspend fun updateNote(note:Note)

    @Query("SELECT * FROM tbl_notes WHERE id= :id")
    suspend fun getNoteById(id:Long):Note
}