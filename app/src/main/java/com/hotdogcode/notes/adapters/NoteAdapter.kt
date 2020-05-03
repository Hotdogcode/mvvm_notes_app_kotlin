package com.hotdogcode.notes.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hotdogcode.notes.OnNoteClickListener
import com.hotdogcode.notes.R
import com.hotdogcode.notes.data.model.Note
import com.hotdogcode.notes.generated.callback.OnClickListener
import kotlinx.android.synthetic.main.note_list_item.view.*

class NoteAdapter(val data : List<Note>, val context: Context, private val itemClickListener: OnNoteClickListener):RecyclerView.Adapter<NoteAdapter.ViewHolder>()
{



    override fun getItemCount(): Int {
        return data.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = data[position]
        holder.bind(note,itemClickListener)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title = itemView.title
        val subTitle = itemView.subtitle
        fun bind(note : Note,listener: OnNoteClickListener){
            title.text = note.title
            subTitle.text = note.subTitle
            itemView.setOnClickListener {
                listener.onNoteClicked(note)
            }
        }
    }
}