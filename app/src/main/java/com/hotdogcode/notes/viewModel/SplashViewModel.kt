package com.hotdogcode.notes.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hotdogcode.notes.data.NoteRepo
import com.hotdogcode.notes.data.model.Note
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SplashViewModel(private val noteRepo: NoteRepo)  : ViewModel(){
    var _counter = MutableLiveData<Int>(0)
    fun incCounter(i:Long){
        viewModelScope.launch {
            delay(i*1000)
            _counter.value = i.toInt()
        }

    }


}