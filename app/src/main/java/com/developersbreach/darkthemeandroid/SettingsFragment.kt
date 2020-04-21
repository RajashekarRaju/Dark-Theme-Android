package com.developersbreach.darkthemeandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:  View = inflater.inflate(R.layout.fragment_settings, container, false)
        val fragment: SettingsCompatFragment = SettingsCompatFragment.newInstance()
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.settings_fragment_compact_container, fragment)
        fragmentTransaction.commit()
        return view
    }

}
