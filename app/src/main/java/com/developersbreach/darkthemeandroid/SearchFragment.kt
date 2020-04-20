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
    private var socialList: List<Social> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)

        socialList = socialList()
        recyclerView = view.findViewById(R.id.search_recycler_view)

        val searchAdapter = SearchAdapter(socialList)
        recyclerView.adapter = searchAdapter

        return view
    }

}

private operator fun <E> List<E>.invoke(): List<Social> {
    return listOf(
        Social(R.drawable.ic_baseball, "Baseball", "Sports"),
        Social(R.drawable.ic_basketball, "Basketball", "Sports"),
        Social(R.drawable.ic_cricket, "Cricket", "Sports"),
        Social(R.drawable.ic_esports, "Esports", "Sports"),
        Social(R.drawable.ic_football, "Football", "Sports"),
        Social(R.drawable.ic_handball, "Handball", "Sports"),
        Social(R.drawable.ic_hockey, "Hockey", "Sports"),
        Social(R.drawable.ic_kabaddi, "Kabaddi", "Sports"),
        Social(R.drawable.ic_mma, "MMA", "Sports"),
        Social(R.drawable.ic_rugby, "Rugby", "Sports"),
        Social(R.drawable.ic_soccer, "Soccer", "Sports"),
        Social(R.drawable.ic_tennis, "Tennis", "Sports"),
        Social(R.drawable.ic_volleyball, "Volleyball", "Sports")
    )
}