package com.developersbreach.darkthemeandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var sportsList: List<Sports> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)
        sportsList = Sports.sportsList(requireContext())
        recyclerView = view.findViewById(R.id.search_recycler_view)

        val searchAdapter = SearchAdapter(sportsList)
        recyclerView.adapter = searchAdapter

        return view
    }
}
