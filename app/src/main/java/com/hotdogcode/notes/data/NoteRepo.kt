package com.hotdogcode.notes.data
import com.hotdogcode.notes.data.model.Note

class NoteRepo private constructor(private val noteDao: NoteDao)
{
    suspend fun insertNote(note: Note){
        return noteDao.insertNote(note)
    }

    suspend fun getNotes():List<Note>{
        return noteDao.getNotes()
    }

    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }

    suspend fun deleteNotes(){
        noteDao.deleteNotes()
    }

    suspend fun updateNote(note:Note){
        noteDao.updateNote(note)
    }

    suspend fun getNoteById(id:Long):Note{
        return noteDao.getNoteById(id)
    }

    companion object{
        private var INSTANCE:NoteRepo? = null
        fun getInstance(noteDao: NoteDao):NoteRepo{
            synchronized(this){
                return INSTANCE ?: NoteRepo(noteDao).also {
                    INSTANCE = it
                }
            }
        }
    }

}