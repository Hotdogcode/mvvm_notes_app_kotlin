package com.hotdogcode.notes.view.fragments.homeFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hotdogcode.notes.data.NoteRepo
import com.hotdogcode.notes.data.model.Note
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val noteRepo: NoteRepo):ViewModel() {
    val notes = MutableLiveData<List<Note>>()
    val count = MutableLiveData<Int>(0)
    fun getNotesList(){
        viewModelScope.launch {
            notes.value = noteRepo.getNotes()
            count.value = notes.value!!.size
        }
    }
}