package com.example.covaxspotter.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CountyVaccine::class], version = 1, exportSchema = false)
abstract class CountyDB: RoomDatabase() {
    abstract fun countyDao(): CountyDao

    companion object {
        @Volatile private var instance: CountyDB? = null
        private var LOCK = Any()

        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        operator fun invoke (context: Context) = instance?: synchronized(LOCK) {
            instance?: createDatabase(context).also { instance = it }
            //instance = if (instance == null) createDatabase(context) else instance
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, CountyDB::class.java, "county_db")
                .createFromAsset("database/county_db.db")
                .build()
    }

}