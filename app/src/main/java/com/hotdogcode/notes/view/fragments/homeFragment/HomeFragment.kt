package com.hotdogcode.notes.view.fragments.homeFragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.hotdogcode.notes.R
import com.hotdogcode.notes.adapters.NoteAdapter
import com.hotdogcode.notes.databinding.FragmentHomeBinding
import com.hotdogcode.notes.utilities.Injector
import com.hotdogcode.notes.utilities.ViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {


    lateinit var viewModel : HomeFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init()
        val binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        binding.viewModel = viewModel
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        Log.e("aslam","OnResume")
    }

    fun init(){



        viewModel = activity?.run {
            val viewModelFactory = Injector.provideViewModelFactory(this)
            ViewModelProvider(this,viewModelFactory).get(HomeFragmentViewModel::class.java)
        }?: throw Exception("Inavlid Activity")


        viewModel.notes.observe(this, Observer {
            Log.e("aslam","List Updated")
        })

        viewModel.getNotesList()

    }


}
