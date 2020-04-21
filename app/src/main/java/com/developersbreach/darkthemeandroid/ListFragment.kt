package com.developersbreach.darkthemeandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var sportsList: List<Sports> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)

        sportsList = Sports.sportsList(requireContext())
        recyclerView = view.findViewById(R.id.recycler_view)

        val sportsAdapter = SportsAdapter(sportsList, sportsItemListener())
        recyclerView.adapter = sportsAdapter

        RecyclerViewItemDecoration.setItemSpacing(resources, recyclerView)
        return view
    }

    private fun sportsItemListener(): SportsAdapter.OnClickListener {
        return SportsAdapter.OnClickListener { sports ->

            val direction: NavDirections =
                ListFragmentDirections.actionListFragmentToDetailFragment(sports)
            Navigation.findNavController(requireView()).navigate(direction)
        }
    }
}
