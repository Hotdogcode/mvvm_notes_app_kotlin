package com.hotdogcode.notes.view.fragments.newNoteFragment

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.hotdogcode.notes.data.NoteRepo
import com.hotdogcode.notes.data.model.Note
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewNoteViewModel(private val noteRepo: NoteRepo):ViewModel() {
    var title = MutableLiveData<String>()
    var subTitle = MutableLiveData<String>()
    var valid = MutableLiveData<Int>(3)

    //0 -> cancelled
    //1 -> invalid
    //2 -> added

    fun add(){
        if(title.value.isNullOrEmpty() || subTitle.value.isNullOrEmpty())
            valid.value = 1
        else {
            val note = Note(0,title.value!!,subTitle.value!!)
            viewModelScope.launch {
                noteRepo.insertNote(note)
                Log.e("aslam","inserted")
                delay(500)
                valid.value = 2
            }
        }
    }


    fun cancel(){
        valid.value = 0
    }

}