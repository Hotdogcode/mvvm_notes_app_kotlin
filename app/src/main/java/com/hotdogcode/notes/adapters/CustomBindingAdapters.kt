package com.hotdogcode.notes.adapters

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hotdogcode.notes.data.model.Note

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, data: MutableLiveData<List<Note>>) {
    val adapter = NoteAdapter(data.value?: mutableListOf(), view.context)
    view.adapter = adapter
}