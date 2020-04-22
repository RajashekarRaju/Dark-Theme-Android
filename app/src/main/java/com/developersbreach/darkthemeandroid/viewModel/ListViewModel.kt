package com.developersbreach.darkthemeandroid.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.developersbreach.darkthemeandroid.model.Sports

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private var sports: MutableLiveData<List<Sports>> = MutableLiveData()

    init {
        val sportsList: List<Sports> = Sports.sportsList(application.applicationContext)
        sports.value = sportsList
    }

    fun getSports(): LiveData<List<Sports>> {
        return sports
    }
}