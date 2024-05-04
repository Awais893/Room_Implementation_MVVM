package com.shadowarm.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ListAdapter
import com.shadowarm.Repositories.Repository
import com.shadowarm.ViewModels.ContactViewModel
import com.shadowarm.ViewModels.ContactViewModelFactory
import com.shadowarm.dataclass.ContactDatabae
import com.shadowarm.roomimplementation.R

class ViewdataFragment : Fragment() {

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_viewdata, container, false)

   //RecyclerView
        val adapter=ListAdapter()
        val recyclerView=view.findViewById<RecyclerView>(R.id.recView)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())

        val dao= ContactDatabae.getDatabse(requireContext())
        val repository=Repository(dao)

        contactViewModel = ViewModelProvider(this, ContactViewModelFactory(repository)).get(ContactViewModel::class.java)

        contactViewModel.getAllContact().observe(viewLifecycleOwner, Observer {contact->
            adapter.setData(contact)
        })

        return view

    }
}