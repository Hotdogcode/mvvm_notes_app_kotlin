package com.hotdogcode.notes.view.fragments.homeFragment

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.hotdogcode.notes.R
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

    fun newNoteClick(view : View){
        val navigation = view.findNavController()
        navigation.navigate(R.id.action_homeFragment_to_newNoteFragment)
    }
}