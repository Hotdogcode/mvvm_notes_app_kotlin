package com.hotdogcode.notes.view.fragments.newNoteFragment

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.hotdogcode.notes.data.NoteRepo
import com.hotdogcode.notes.data.model.Note
import kotlinx.coroutines.launch

class NewNoteViewModel(private val noteRepo: NoteRepo):ViewModel() {
    var title = MutableLiveData<String>()
    var subTitle = MutableLiveData<String>()
    var valid = MutableLiveData<Boolean>(true)

    private fun add(){
        if(title.value.isNullOrEmpty() || subTitle.value.isNullOrEmpty())
            valid.value = false
        else {
            val note = Note(0,title.value!!,subTitle.value!!)
            viewModelScope.launch {
                noteRepo.insertNote(note)
            }
        }
    }

    fun addClick(view : View){

    }

}