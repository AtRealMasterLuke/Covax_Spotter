package com.example.covaxspotter.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "county_vac_table")

data class CountyVaccine(
@ColumnInfo val countyName: String,
@ColumnInfo val subCountyName: String,
@ColumnInfo val hospital: String,
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}