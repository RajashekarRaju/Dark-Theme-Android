package com.developersbreach.darkthemeandroid.view.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.developersbreach.darkthemeandroid.R

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
