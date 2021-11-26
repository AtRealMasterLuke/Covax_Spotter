package com.example.covaxspotter.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CountyDao {
    @Query("SELECT * FROM county_vac_table")
    fun readAll(): LiveData<List<CountyVaccine>>

}