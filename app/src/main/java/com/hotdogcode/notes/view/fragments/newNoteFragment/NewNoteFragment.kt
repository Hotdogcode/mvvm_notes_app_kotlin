package com.hotdogcode.notes.view.fragments.newNoteFragment


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
import com.hotdogcode.notes.databinding.FragmentNewNoteBinding
import com.hotdogcode.notes.utilities.Injector

/**
 * A simple [Fragment] subclass.
 */
class NewNoteFragment : Fragment() {


    private lateinit var viewModel: NewNoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init()
        val binding = FragmentNewNoteBinding.inflate(inflater,container,false)
        binding.viewModel = viewModel
        return binding.root
    }


    fun init(){
        val nav = findNavController()
        viewModel = activity?.run {
            val factory = Injector.provideViewModelFactory(this)
            ViewModelProvider(this,factory).get(NewNoteViewModel::class.java)
        }?: throw Exception("Cannot create View Model")
        viewModel.valid.observe(this, Observer {
            when(it){
                0-> {
                    Toast.makeText(activity,"Cancelled",Toast.LENGTH_SHORT).show()
                }
                1-> {
                    Toast.makeText(activity,"Invalid Data",Toast.LENGTH_SHORT).show()
                    viewModel.valid.value = 3
                }
                2->{
                    Toast.makeText(activity,"Created",Toast.LENGTH_SHORT).show()
                }
            }
            if(it==0 || it==2) {
                viewModel.valid.value = 3
                nav.popBackStack()
            }

        })
    }

}
