package com.developersbreach.darkthemeandroid.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.developersbreach.darkthemeandroid.model.Sports
import java.util.*

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private var sports: MutableLiveData<List<Sports>> = MutableLiveData()
    private var searchSports: MutableLiveData<List<Sports>> = MutableLiveData()
    private val sportsData: List<Sports> = Sports.sportsList(application.applicationContext)

    init {
        sports.value = sportsData
    }

    fun getSports(): LiveData<List<Sports>> {
        return sports
    }

    fun filter(query: String): LiveData<List<Sports>> {
        return onFilterChanged(query)
    }

    private fun onFilterChanged(filterQuery: String): LiveData<List<Sports>> {
        onQueryChanged(filterQuery)
        return searchSports
    }

    private fun onQueryChanged(filterQuery: String) {
        val sportsList: MutableList<Sports> = ArrayList<Sports>()
        for (currentSport in sportsData) {
            if (currentSport.title.toLowerCase(Locale.getDefault()).contains(filterQuery)) {
                sportsList.add(currentSport)
            }
        }
        searchSports.postValue(sportsList)
    }
}