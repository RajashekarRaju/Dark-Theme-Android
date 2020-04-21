package com.developersbreach.darkthemeandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.appbar.CollapsingToolbarLayout

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private lateinit var sportsArgs: Sports

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        sportsArgs = DetailFragmentArgs.fromBundle(args).detailFragmentArgs
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)

        val toolbar: Toolbar = view.findViewById(R.id.detail_toolbar)
        val appBarLayout: AppBarLayout = view.findViewById(R.id.detail_appbar)
        val collapsingToolbar: CollapsingToolbarLayout =
            view.findViewById(R.id.detail_collapsing_toolbar)
        val icon: ImageView = view.findViewById(R.id.social_detail_image_view)
        val title: TextView = view.findViewById(R.id.title_detail_text_view)
        val subtitle: TextView = view.findViewById(R.id.subtitle_detail_text_view)
        val about: TextView = view.findViewById(R.id.about_detail_text_view)

        icon.setImageResource(sportsArgs.icon)
        title.text = sportsArgs.title
        subtitle.text = sportsArgs.subtitle
        about.text = sportsArgs.about

        toolbar.setNavigationOnClickListener { v ->
            Navigation.findNavController(v).navigateUp()
        }

        // Using a listener to get state of CollapsingToolbar and Toolbar to set properties.
        appBarLayout.addOnOffsetChangedListener(object : OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    // Show title when completely collapsed.
                    collapsingToolbar.title = sportsArgs.title
                    isShow = true
                } else if (isShow) {
                    // Hide title when collapsedToolBar is completely visible using empty string.
                    collapsingToolbar.title = ""
                    isShow = false
                }
            }
        })
        return view
    }

}
