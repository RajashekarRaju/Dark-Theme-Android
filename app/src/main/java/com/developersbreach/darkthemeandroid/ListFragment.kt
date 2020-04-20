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
    private var socialList: List<Social> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)

        socialList = socialList()
        recyclerView = view.findViewById(R.id.recycler_view)

        val socialAdapter = SocialAdapter(socialList, socialItemListener())
        recyclerView.adapter = socialAdapter

        RecyclerViewItemDecoration.setItemSpacing(resources, recyclerView)
        return view
    }

    private fun socialItemListener(): SocialAdapter.OnClickListener {
        return SocialAdapter.OnClickListener { social ->

            val direction: NavDirections =
                ListFragmentDirections.actionListFragmentToDetailFragment(social)
            Navigation.findNavController(requireView()).navigate(direction)
        }
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
