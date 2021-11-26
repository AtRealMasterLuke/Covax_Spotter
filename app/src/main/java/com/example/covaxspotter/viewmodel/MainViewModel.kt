package com.example.covaxspotter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covaxspotter.room.CountyRepository
import com.example.covaxspotter.room.CountyVaccine
import java.lang.IllegalArgumentException

/**
 * A viewModelFactory creates a new instance of the viewmodel and passes the required arguments.(with/without constructor parameters)
 * if a viewModel instance is made in the viewModel class, a new object is created every time the fragment is re-created
 */


class MainViewModel(countyRepository: CountyRepository): ViewModel() {
    val readAll = countyRepository.readAll
}

class MainViewModelFactory(private val repository: CountyRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}