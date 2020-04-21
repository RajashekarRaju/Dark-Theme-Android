package com.developersbreach.darkthemeandroid

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class SettingsCompatFragment : PreferenceFragmentCompat() {

    companion object {
        fun newInstance(): SettingsCompatFragment {
            return SettingsCompatFragment()
        }
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

}
