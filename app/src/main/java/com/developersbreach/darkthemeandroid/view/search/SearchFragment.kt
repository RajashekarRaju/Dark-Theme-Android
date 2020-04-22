package com.developersbreach.darkthemeandroid.view.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.darkthemeandroid.R
import com.developersbreach.darkthemeandroid.model.Sports
import com.developersbreach.darkthemeandroid.viewModel.SearchViewModel
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var editText: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView

    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)
        recyclerView = view.findViewById(R.id.search_recycler_view)
        editText = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)

        viewModel.getSports().observe(viewLifecycleOwner, Observer { sportsList ->
            searchAdapter = SearchAdapter(sportsList, searchItemListener())
            recyclerView.adapter = searchAdapter
        })

        setSearch(editText)
        return view
    }

    private fun setSearch(editText: AppCompatEditText?) {
        editText?.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(query: CharSequence?, start: Int, before: Int, count: Int) {
                filterWithViewModel(query.toString().toLowerCase(Locale.getDefault()))
            }

            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
        })
    }

    private fun filterWithViewModel(query: String) {
        viewModel.filter(query).observe(viewLifecycleOwner, Observer { filteredSports ->
            if (query.isNotEmpty()) {
                val adapter = SearchAdapter(filteredSports, searchItemListener())
                recyclerView.adapter = adapter
                toggleRecyclerView(filteredSports)
            }
        })
    }

    private fun searchItemListener(): SearchAdapter.OnClickListener {
        return SearchAdapter.OnClickListener { sports ->

            val direction: NavDirections =
                SearchFragmentDirections.actionSearchFragmentToDetailFragment(
                    sports
                )
            Navigation.findNavController(requireView()).navigate(direction)
        }
    }

    private fun toggleRecyclerView(sportsList: List<Sports>) {
        if (sportsList.isEmpty()) {
            recyclerView.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            noSearchResultsFoundText.visibility = View.INVISIBLE
        }
    }
}
