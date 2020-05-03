package com.hotdogcode.notes.view.fragments.editNoteFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.hotdogcode.notes.R
import com.hotdogcode.notes.databinding.FragmentEditNoteBinding
import com.hotdogcode.notes.utilities.Injector

/**
 * A simple [Fragment] subclass.
 */
class EditNoteFragment : Fragment() {

    private lateinit var viewModel: EditNoteViewModel
    private lateinit var binding : FragmentEditNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        init(arguments?.getLong("noteId")?:-1)
        binding = FragmentEditNoteBinding.bind(inflater.inflate(R.layout.fragment_edit_note, container, false))
        binding.viewModel = viewModel
        return binding.root



    }


    fun init(noteId:Long){
        if(noteId==-1L){
            Toast.makeText(context,"Invalid Note, Try Again",Toast.LENGTH_SHORT).show()
            val nav = findNavController()
            nav.popBackStack()
        }
        else {
            activity?.run {
                val factory = Injector.provideViewModelFactory(context!!)
                viewModel = ViewModelProvider(this, factory).get(EditNoteViewModel::class.java)
                viewModel.status.observe(this@EditNoteFragment, Observer {
                    when(it){
                        1->{
                            Toast.makeText(context!!,"Updated",Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }

            viewModel.fetch(noteId)
        }

    }

}
