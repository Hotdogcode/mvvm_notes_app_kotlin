package com.hotdogcode.notes.utilities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hotdogcode.notes.data.NoteRepo
import com.hotdogcode.notes.view.fragments.homeFragment.HomeFragmentViewModel
import com.hotdogcode.notes.viewModel.SplashViewModel

class ViewModelFactory(private val noteRepo: NoteRepo):ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when(modelClass){
            SplashViewModel::class.java -> return SplashViewModel(noteRepo) as T
            HomeFragmentViewModel::class.java -> return HomeFragmentViewModel(noteRepo) as T
        }
        return ClassNotFoundException("Class Not found for ViewModelFactory") as T
    }
}