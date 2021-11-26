package com.example.covaxspotter

import android.app.Application
import com.example.covaxspotter.room.CountyDB
import com.example.covaxspotter.room.CountyRepository

/**
 * For only one instance of the database and of the repository in the app.
 * An easy way to achieve this is by creating them as members of the Application class.
 * Then they will just be retrieved from the Application whenever they're needed, rather than constructed every time.
 */
class CountyApplication: Application() {
    private val database by lazy { CountyDB(this) }
    val repository by lazy { CountyRepository( database.countyDao() ) }
}