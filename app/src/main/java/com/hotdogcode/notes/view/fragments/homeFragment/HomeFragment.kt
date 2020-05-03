package com.hotdogcode.notes.view.fragments.homeFragment


import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hotdogcode.notes.OnNoteClickListener

import com.hotdogcode.notes.R
import com.hotdogcode.notes.adapters.NoteAdapter
import com.hotdogcode.notes.data.model.Note
import com.hotdogcode.notes.databinding.FragmentHomeBinding
import com.hotdogcode.notes.utilities.Injector
import com.hotdogcode.notes.utilities.ViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(),OnNoteClickListener {


    lateinit var viewModel : HomeFragmentViewModel
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init()
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        binding.viewModel = viewModel
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete -> {
                viewModel.deleteAll()
                Toast.makeText(context,"Cleared All",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun init(){



        viewModel = activity?.run {
            val viewModelFactory = Injector.provideViewModelFactory(this)
            ViewModelProvider(this,viewModelFactory).get(HomeFragmentViewModel::class.java)
        }?: throw Exception("Inavlid Activity")


        viewModel.notes.observe(this, Observer {
            binding.recyclerView.adapter = NoteAdapter(it,context!!,this)
        })

        viewModel.getNotesList()

    }


    override fun onNoteClicked(note: Note) {
        viewModel.editNoteClick(this,note.id)
    }
}
