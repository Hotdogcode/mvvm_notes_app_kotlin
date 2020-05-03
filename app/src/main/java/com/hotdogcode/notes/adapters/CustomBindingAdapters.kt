package com.hotdogcode.notes.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hotdogcode.notes.data.model.Note

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, data: List<Note>) {
    val adapter = NoteAdapter(data, view.context)
    view.adapter = adapter
}