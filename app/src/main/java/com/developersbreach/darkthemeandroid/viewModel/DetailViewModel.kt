package com.developersbreach.darkthemeandroid.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.developersbreach.darkthemeandroid.model.Sports

class DetailViewModel(application: Application, sports: Sports) : AndroidViewModel(application) {

    private var sport: MutableLiveData<Sports> = MutableLiveData()

    init {
        sport.value = sports
    }

    fun getSport(): LiveData<Sports> {
        return sport
    }
}