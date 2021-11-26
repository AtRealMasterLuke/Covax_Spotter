package com.example.covaxspotter.room

import androidx.lifecycle.LiveData

class CountyRepository(private val countyDao: CountyDao) {
    val readAll: LiveData<List<CountyVaccine>> = countyDao.readAll()
}