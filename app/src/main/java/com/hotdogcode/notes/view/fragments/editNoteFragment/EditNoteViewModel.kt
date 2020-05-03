package com.hotdogcode.notes.view.fragments.editNoteFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hotdogcode.notes.data.NoteRepo
import com.hotdogcode.notes.data.model.Note
import kotlinx.coroutines.launch

class EditNoteViewModel(private val noteRepo: NoteRepo) : ViewModel() {
    var noteId:Long = -1
    var title = MutableLiveData<String>()
    var subtitle = MutableLiveData<String>()
    var status = MutableLiveData<Int>()

    //0 = cancelled
    //1 = updated
    //2 = nothing
    init {
        status.value = 2
    }

    fun fetch(id:Long){
        noteId = id
        viewModelScope.launch {
            val note = noteRepo.getNoteById(noteId)
            title.value = note.title
            subtitle.value = note.subTitle
        }
    }

    fun update(){
        viewModelScope.launch {
            val note = Note(noteId,title.value.toString(),subtitle.value.toString())
            noteRepo.updateNote(note)
            status.value = 1
        }
    }

}