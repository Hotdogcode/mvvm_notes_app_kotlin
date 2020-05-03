package com.hotdogcode.notes.view.fragments.newNoteFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hotdogcode.notes.R

/**
 * A simple [Fragment] subclass.
 */
class NewNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_note, container, false)
    }


}
