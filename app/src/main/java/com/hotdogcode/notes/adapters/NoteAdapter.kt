package com.hotdogcode.notes.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hotdogcode.notes.R
import com.hotdogcode.notes.data.model.Note
import kotlinx.android.synthetic.main.note_list_item.view.*

class NoteAdapter(val data : List<Note>, val context: Context):RecyclerView.Adapter<NoteAdapter.ViewHolder>()
{



    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = data[position]
        holder.title.text = note.title
        holder.subTitle.text = note.subTitle
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val title = view.title
        val subTitle = view.subtitle
    }
}