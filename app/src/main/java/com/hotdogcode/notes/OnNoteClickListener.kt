package com.hotdogcode.notes

import com.hotdogcode.notes.data.model.Note

interface OnNoteClickListener {
    fun onNoteClicked(note: Note)
}